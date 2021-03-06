import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class LoginPageSpec extends GebReportingSpec {
    def setupSpec() {
        to LogoutPage
    }

    def "visit login page"() {
        when:
        to LoginPage

        then:
        assert $("h3").text() == "Login"
        assert page instanceof LoginPage
    }

    def "when incorrect username and password is entered"() {
        when:
        $("#loginForm").j_username = 'test@example.com'
        $("#loginForm").j_password = '123456'
        loginButton.click()

        then:
        at LoginPage
        errorMessage == "Sorry, we were not able to find a user with that username and password."
        assert page instanceof LoginPage
    }

    def "when correct username and password is entered"() {
        given:
        at LoginPage

        when:
        $("#loginForm").j_username = 'admin@example.com'
        $("#loginForm").j_password = '123456'
        loginButton.click()

        then:
        at AdminPostIndexPage
    }
}
