package grailsblog

class Comment {
    String name
    String email
    String comment
    Date dateCreated
    Date lastUpdated

    static belongsTo = [post: Post]

    static constraints = {
        name blank: false, nullable: false, maxSize: 100
        email blank: false, nullable: false, email: true
        comment blank: false, nullable: false, type: 'text'
    }

    static mapping = {
        comment sqlType: 'text'
    }
}
