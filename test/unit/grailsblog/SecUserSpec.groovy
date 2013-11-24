package grailsblog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SecUser)
class SecUserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Check Model Properties"() {
        when:
        def testUser = new SecUser()

        then:
        assert testUser.hasProperty("firstname")
        assert testUser.hasProperty("lastname")
        assert testUser.hasProperty("email")
        assert testUser.hasProperty("password")
        assert testUser.hasProperty("enabled")
        assert testUser.hasProperty("accountExpired")
        assert testUser.hasProperty("accountLocked")
        assert testUser.hasProperty("passwordExpired")
        assert testUser.hasProperty("dateCreated")
        assert testUser.hasProperty("lastUpdated")
    }

    void "Check fullname returns the correct fullname"() {
        def testUser = new SecUser()

        when: "firstname and lastname are present"
        testUser.setFirstname("First")
        testUser.setLastname("Last")

        then: "Fullname should be First Last"
        assertEquals "First Last", testUser.getFullname()

        when: "White spaces are present"
        testUser.setFirstname("First ")
        testUser.setLastname(" Last")

        then: "Fullname should be First Last"
        assertEquals "First Last", testUser.getFullname()
    }
}
