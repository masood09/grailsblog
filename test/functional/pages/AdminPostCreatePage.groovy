package pages
import geb.Module

class AdminPostCreatePage extends ScaffoldPage {
    static url = "admin/posts/create"

    static at = {
        title ==~ /Grailsblog - Create a new post/
    }

    static content = {
        createPostButton { $("button.btn.btn-primary") }
    }
}
