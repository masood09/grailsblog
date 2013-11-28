import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class AdminPostSpec extends GebReportingSpec {
    def "Test blog post index page"() {
        given: "I am at login page"
        to LoginPage

        when: "I enter the correct username and password"
        $("#loginForm").j_username = 'admin@example.com'
        $("#loginForm").j_password = '123456'
        loginButton.click()
        to AdminPostIndexPage

        then: "I am at admin posts section"
        at AdminPostIndexPage
    }

    def "Test creation of new post"() {
        when: "I click on Create a new post"
        createNewPostLink.click()

        then: "I am at Create a new post page"
        at AdminPostCreatePage

        when: "I enter title and content"
        $("form").title = "This is a test title"
        js.exec 1, 2, """
            tinyMCE.execCommand('mceInsertContent', false, 'This is a test content');
            return true;
        """
        createPostButton.click()

        then: "I should be at post index page"
        at AdminPostIndexPage
        infoMessage == "Post This is a test title created"
    }
}
