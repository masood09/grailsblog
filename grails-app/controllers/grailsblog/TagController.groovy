package grailsblog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TagController {

    static allowedMethods = [save: "POST", update: "PUT"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tag.list(params), model:[tagInstanceCount: Tag.count()]
    }

    def create() {
        respond new Tag(params)
    }

    @Transactional
    def save(Tag tagInstance) {
        if (tagInstance == null) {
            notFound()
            return
        }

        if (tagInstance.hasErrors()) {
            respond tagInstance.errors, view:'create'
            return
        }

        tagInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tagInstance.label', default: 'Tag'), tagInstance.name])
                redirect action: "index", method: "GET"
            }
            '*' { respond tagInstance, [status: CREATED] }
        }
    }

    def edit(Tag tagInstance) {
        respond tagInstance
    }

    @Transactional
    def update(Tag tagInstance) {
        if (tagInstance == null) {
            notFound()
            return
        }

        if (tagInstance.hasErrors()) {
            respond tagInstance.errors, view:'edit'
            return
        }

        tagInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Tag.label', default: 'Tag'), tagInstance.name])
                redirect action: "index", method: "GET"
            }
            '*'{ respond tagInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Tag tagInstance) {

        if (tagInstance == null) {
            notFound()
            return
        }

        PostTag.removeAll(tagInstance)

        tagInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Tag.label', default: 'Tag'), tagInstance.name])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tagInstance.label', default: 'Tag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
