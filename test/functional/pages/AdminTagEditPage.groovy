package pages
import geb.Module

class AdminTagEditPage extends ScaffoldPage {
    static at = {
        title ==~ /Grailsblog - Edit tag.+/
    }

    static content = {
        updateTagButton { $("button.btn.btn-primary") }
        deleteTagButton { $("a.btn.btn-danger") }
    }
}
