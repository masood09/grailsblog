import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class PostSpec extends GebReportingSpec {
    def setupSpec() {
        to LogoutPage
    }

    def cleanupSpec() {
        to LogoutPage
    }

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
        postRows.size() == 1
        postRow(0).title == "No Posts Found!"
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
        postRows.size() == 1
        postRow(0).title == "This is a test title"
        postRow(0).author == "Admin User"
        postRow(0).slug == "this-is-a-test-title"
    }

    def "edit a post"() {
        when: "I click on post title"
        postRow(0).editLink.click()

        then: "I should be at post edit page"
        at AdminPostEditPage
        $("form").title == "This is a test title"

        when: "I change the title and publish the post"
        $("form").title = "This is a test title edit"
        updatePostButton.click()

        then: "I should be at post index page"
        at AdminPostIndexPage
        infoMessage == "Post This is a test title edit updated"
        postRows.size() == 1
        postRow(0).title == "This is a test title edit"
        postRow(0).author == "Admin User"
        postRow(0).slug == "this-is-a-test-title-edit"
    }

    def "delete a post"() {
        given:
        def postTitle = postRow(0).title

        when: "I click on post title"
        postRow(0).editLink.click()

        then: "I should be at post edit page"
        at AdminPostEditPage
        $("form").title == "This is a test title edit"

        when: "I click on delete post link"
        withConfirm { deletePostButton.click() }

        then: "I should be at the post index page"
        at AdminPostIndexPage
        infoMessage == "Post $postTitle deleted"
        postRows.size() == 1
        postRow(0).title == "No Posts Found!"
    }
}
