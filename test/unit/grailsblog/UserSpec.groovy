package grailsblog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Check Model Properties"() {
        when:
        def testUser = new User()

        then:
        assert testUser.hasProperty("firstname")
        assert testUser.hasProperty("middlename")
        assert testUser.hasProperty("lastname")
        assert testUser.hasProperty("nickname")
        assert testUser.hasProperty("email")
        assert testUser.hasProperty("password")
        assert testUser.hasProperty("isAdmin")
        assert testUser.hasProperty("isActive")
        assert testUser.hasProperty("profilePic")
        assert testUser.hasProperty("dateCreated")
        assert testUser.hasProperty("lastUpdated")
    }

    void "Check fullname returns the correct fullname"() {
        def testUser = new User()

        when: "All firstname, middlename and lastname are present"
        testUser.setFirstname("First")
        testUser.setMiddlename("Middle")
        testUser.setLastname("Last")

        then: "Fullname should be First Middle Last"
        assertEquals "First Middle Last", testUser.getFullname()

        when: "Only firstname and lastname are present"
        testUser.setMiddlename("")

        then: "Fullname should be First Last"
        assertEquals "First Last", testUser.getFullname()

        when: "White spaces are present"
        testUser.setFirstname("First ")
        testUser.setLastname(" Last")

        then: "Fullname should be First Last"
        assertEquals "First Last", testUser.getFullname()
    }
}
