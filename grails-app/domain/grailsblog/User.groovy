package grailsblog

class User {
    String firstname
    String middlename
    String lastname
    String nickname
    String email
    String password
    Boolean isAdmin
    Boolean isActive
    String profilePic
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    String getFullname() {
        String fullname

        if (middlename) {
            fullname = firstname.trim() + " " + middlename.trim() + " " + lastname.trim()
        } else {
            fullname = firstname.trim() + " " + lastname.trim()
        }

        return fullname
    }
}
