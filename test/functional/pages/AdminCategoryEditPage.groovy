package pages
import geb.Module

class AdminCategoryEditPage extends ScaffoldPage {
    static at = {
        title ==~ /Grailsblog - Edit category.+/
    }

    static content = {
        updateCategoryButton { $("button.btn.btn-primary") }
        deleteCategoryButton { $("a.btn.btn-danger") }
    }
}
