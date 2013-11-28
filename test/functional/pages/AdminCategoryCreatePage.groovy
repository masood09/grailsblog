package pages
import geb.Module

class AdminCategoryCreatePage extends ScaffoldPage {
    static url = "admin/category/create"

    static at = {
        title ==~ /Grailsblog - Create a new category/
    }

    static content = {
        createCategoryButton { $("button.btn.btn-primary") }
    }
}
