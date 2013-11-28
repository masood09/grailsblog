package pages
import geb.Module

class AdminTagCreatePage extends ScaffoldPage {
    static url = "admin/tags/create"

    static at = {
        title ==~ /Grailsblog - Create a new tag/
    }

    static content = {
        createTagButton { $("button.btn.btn-primary") }
    }
}
