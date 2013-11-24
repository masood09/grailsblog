import grailsblog.SecRole
import grailsblog.SecUser
import grailsblog.SecUserSecRole

class BootStrap {
    def springSecurityService

    def init = { servletContext ->
        def authorRole = SecRole.findByAuthority('ROLE_AUTHOR') ?: new SecRole(authority: 'ROLE_AUTHOR').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = SecUser.findByEmail('admin@example.com') ?: new SecUser(
            firstname: 'Admin',
            lastname: 'User',
            email: 'admin@example.com',
            password: '123456'
        ).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
    }
    def destroy = {
    }
}
