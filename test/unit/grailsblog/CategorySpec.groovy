package grailsblog

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategorySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Check model properties"() {
        when:
        def testCategory = new Category()

        then:
        assert testCategory.hasProperty("name")
        assert testCategory.hasProperty("slug")
        assert testCategory.hasProperty("dateCreated")
        assert testCategory.hasProperty("lastUpdated")
    }
}
