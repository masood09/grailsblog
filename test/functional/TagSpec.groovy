import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class TagSpec extends GebReportingSpec {
    def setupSpec() {
        to LogoutPage
    }

    def cleanupSpec() {
        to LogoutPage
    }

    def "Test tag index page"() {
        given: "I am at login page"
        to LoginPage

        when: "I enter the correct username and password"
        $("#loginForm").j_username = 'admin@example.com'
        $("#loginForm").j_password = '123456'
        loginButton.click()
        to AdminTagIndexPage

        then: "I am at admin tags section"
        at AdminTagIndexPage
        tagRows.size() == 1
        tagRow(0).name == "No Tags Found!"
    }

    def "Test creation of new tag"() {
        when: "I click on Create a new tag"
        createNewTagLink.click()

        then: "I am at Create a new tag page"
        at AdminTagCreatePage

        when: "I enter name"
        $("form").name = "Test Tag 1"
        createTagButton.click()

        then: "I should be at tag index page"
        at AdminTagIndexPage
        infoMessage == "Tag Test Tag 1 created"
        tagRows.size() == 1
        tagRow(0).name == "Test Tag 1"
        tagRow(0).slug == "test-tag-1"
    }

    def "edit a tag"() {
        when: "I click on tag name"
        tagRow(0).editLink.click()

        then: "I should be at tag edit page"
        at AdminTagEditPage
        $("form").name == "Test Tag 1"

        when: "I change the name"
        $("form").name = "Test Tag 1 Edit"
        updateTagButton.click()

        then: "I should be at tag index page"
        at AdminTagIndexPage
        infoMessage == "Tag Test Tag 1 Edit updated"
        tagRows.size() == 1
        tagRow(0).name == "Test Tag 1 Edit"
        tagRow(0).slug == "test-tag-1-edit"
    }

    def "delete a tag"() {
        given:
        def tagName = tagRow(0).name

        when: "I click on tag name"
        tagRow(0).editLink.click()

        then: "I should be at tag edit page"
        at AdminTagEditPage
        $("form").name == "Test Tag 1 Edit"

        when: "I click on delete tag link"
        withConfirm { deleteTagButton.click() }

        then: "I should be at the tag index page"
        at AdminTagIndexPage
        infoMessage == "Tag $tagName deleted"
        tagRows.size() == 1
        tagRow(0).name == "No Tags Found!"
    }
}
