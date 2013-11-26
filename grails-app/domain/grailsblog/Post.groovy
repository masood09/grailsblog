package grailsblog

class Post {
    def slugGeneratorService

    String title
    String slug = ""
    String content
    Date dateCreated
    Date lastUpdated

    static belongsTo = [author: SecUser]

    static constraints = {
        title blank: false, nullable: false
        content blank: false, nullable: false, type: 'text'
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