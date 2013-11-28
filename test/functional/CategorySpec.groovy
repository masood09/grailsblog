import geb.spock.GebReportingSpec
import spock.lang.*
import pages.*

@Stepwise
class CategorySpec extends GebReportingSpec {
    def setupSpec() {
        to LogoutPage
    }

    def cleanupSpec() {
        to LogoutPage
    }

    def "Test category index page"() {
        given: "I am at login page"
        to LoginPage

        when: "I enter the correct username and password"
        $("#loginForm").j_username = 'admin@example.com'
        $("#loginForm").j_password = '123456'
        loginButton.click()
        to AdminCategoryIndexPage

        then: "I am at admin categories section"
        at AdminCategoryIndexPage
        categoryRows.size() == 1
        categoryRow(0).name == "No Categories Found!"
    }

    def "Test creation of new category"() {
        when: "I click on Create a new category"
        createNewCategoryLink.click()

        then: "I am at Create a new category page"
        at AdminCategoryCreatePage

        when: "I enter name"
        $("form").name = "Test Category 1"
        createCategoryButton.click()

        then: "I should be at category index page"
        at AdminCategoryIndexPage
        infoMessage == "Category Test Category 1 created"
        categoryRows.size() == 1
        categoryRow(0).name == "Test Category 1"
        categoryRow(0).slug == "test-category-1"
    }

    def "edit a category"() {
        when: "I click on category name"
        categoryRow(0).editLink.click()

        then: "I should be at category edit page"
        at AdminCategoryEditPage
        $("form").name == "Test Category 1"

        when: "I change the name"
        $("form").name = "Test Category 1 Edit"
        updateCategoryButton.click()

        then: "I should be at category index page"
        at AdminCategoryIndexPage
        infoMessage == "Category Test Category 1 Edit updated"
        categoryRows.size() == 1
        categoryRow(0).name == "Test Category 1 Edit"
        categoryRow(0).slug == "test-category-1-edit"
    }

    def "delete a category"() {
        given:
        def categoryName = categoryRow(0).name

        when: "I click on category name"
        categoryRow(0).editLink.click()

        then: "I should be at category edit page"
        at AdminCategoryEditPage
        $("form").name == "Test Category 1 Edit"

        when: "I click on delete category link"
        withConfirm { deleteCategoryButton.click() }

        then: "I should be at the category index page"
        at AdminCategoryIndexPage
        infoMessage == "Category $categoryName deleted"
        categoryRows.size() == 1
        categoryRow(0).name == "No Categories Found!"
    }
}
