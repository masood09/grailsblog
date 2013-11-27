package grailsblog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PostController {
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        def currentUser = springSecurityService.getCurrentUser()
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN')

        params.max = Math.min(max ?: 10, 100)

        def posts = Post.list(params)
        def postsCount = 0

        if (!currentUser.authorities.contains(adminRole)) {
            posts = Post.findAllByAuthor(currentUser)
            postsCount = Post.countByAuthor(currentUser)
        } else {
            postsCount = Post.count()
        }

        respond posts, model:[postInstanceCount: postsCount]
    }

    def create() {
        respond new Post(params), model:[currentUser: springSecurityService.getCurrentUser(), categories: Category.findAll(), tags: Tag.findAll()]
    }

    @Transactional
    def save(Post postInstance) {
        if (postInstance == null) {
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
            respond postInstance.errors, view:'create'
            return
        }

        postInstance.save flush:true

        associatePostsWithCategories(postInstance, params.list("categories"))
        associatePostsWithTags(postInstance, params.list("tags"))

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postInstance.label', default: 'Post'), postInstance.title])
                redirect action: "index", method: "GET"
            }
            '*' { respond postInstance, [status: CREATED] }
        }
    }

    def edit(Post postInstance) {
        respond postInstance, model:[categories: Category.findAll(), tags: Tag.findAll()]
    }

    @Transactional
    def update(Post postInstance) {
        if (postInstance == null) {
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
            respond postInstance.errors, view:'edit'
            return
        }

        postInstance.save flush:true

        associatePostsWithCategories(postInstance, params.list("categories"))
        associatePostsWithTags(postInstance, params.list("tags"))

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.title])
                redirect action: "index", method: "GET"
            }
            '*'{ respond postInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Post postInstance) {

        if (postInstance == null) {
            notFound()
            return
        }

        PostCategory.removeAll(postInstance)
        PostTag.removeAll(postInstance)

        postInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.title])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void associatePostsWithTags(Post post, tags) {
        def tag

        PostTag.removeAll(post)

        tags.each() {
            tag = Tag.findByName(it) ?: new Tag(name: it).save(failOnError: true)

            if (!post.tags.contains(tag)) {
               PostTag.create post, tag
            }
        }
    }

    protected void associatePostsWithCategories(Post post, categories) {
        def category

        PostCategory.removeAll(post)

        categories.each() {
            category = Category.findByName(it) ?: new Category(name: it).save(failOnError: true)

            if (!post.categories.contains(category)) {
               PostCategory.create post, category
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postInstance.label', default: 'Post'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
