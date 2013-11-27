package pages
import geb.Module

class AdminPostIndexPage extends ScaffoldPage {
    static url = "admin/posts"

    static at = {
        title ==~ /Grailsblog - Posts/
    }

    static content = {
        createNewPostLink { $("a", text: "Create a new post") }
    }
}
