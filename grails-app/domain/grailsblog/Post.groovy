package grailsblog

class Post {
    def slugGeneratorService

    String title
    String slug = ""
    String content
    Date dateCreated
    Date lastUpdated

    static belongsTo = [author: SecUser]

    static hasMany = [comments: Comment]

    static constraints = {
        title blank: false, nullable: false
        content blank: false, nullable: false, type: 'text'
    }

    static mapping = {
        content sqlType: 'text'
    }

    Set<Category> getCategories() {
        PostCategory.findAllByPost(this).collect { it.category } as Set
    }

    Set<Tag> getTags() {
        PostTag.findAllByPost(this).collect { it.tag } as Set
    }

    def beforeInsert() {
        this.slug = slugGeneratorService.generateSlug(this.class, "slug", title, true)
    }

    def beforeUpdate() {
        if (isDirty('title')) {
            this.slug = slugGeneratorService.generateSlug(this.class, "slug", title, true)
        }
    }
}
