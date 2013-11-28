package pages
import geb.Module

class AdminPostEditPage extends ScaffoldPage {
    static at = {
        title ==~ /Grailsblog - Edit post.+/
    }

    static content = {
        updatePostButton { $("button.btn.btn-primary") }
        deletePostButton { $("a.btn.btn-danger") }
    }
}
