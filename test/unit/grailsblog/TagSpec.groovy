package grailsblog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tag)
class TagSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Check model properties"() {
        when:
        def testTag = new Tag()

        then:
        assert testTag.hasProperty("name")
        assert testTag.hasProperty("slug")
        assert testTag.hasProperty("dateCreated")
        assert testTag.hasProperty("lastUpdated")
    }
}
