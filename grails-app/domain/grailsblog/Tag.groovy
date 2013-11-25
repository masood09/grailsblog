package grailsblog

class Tag {
    def slugGeneratorService

    String name
    String slug = ""
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false, nullable: false, unique: true
    }

    def beforeInsert() {
        this.slug = slugGeneratorService.generateSlug(this.class, "slug", name, true)
    }

    def beforeUpdate() {
        if (isDirty('name')) {
            this.slug = slugGeneratorService.generateSlug(this.class, "slug", name, true)
        }
    }
}
