package grailsblog

class SecUser {

    transient springSecurityService

    String firstname
    String lastname
    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    Date dateCreated
    Date lastUpdated

    static transients = ['springSecurityService']

    static hasMany = [posts: Post]

    static constraints = {
        firstname blank: false, maxSize: 50
        lastname blank: false, maxSize: 50
        email blank: false, unique: true, email: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<SecRole> getAuthorities() {
        SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }

    String getFullname() {
        return firstname.trim() + " " + lastname.trim()
    }
}
