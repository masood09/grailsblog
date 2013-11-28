package pages
import geb.Module

class AdminPostIndexPage extends ScaffoldPage {
    static url = "admin/posts"

    static at = {
        title ==~ /Grailsblog - Posts/
    }

    static content = {
        createNewPostLink { $("a", text: "Create a new post") }
        postTable { $("div.table-responsive table", 0) }
        postRow { module PostRow, postRows[it] }
        postRows(required: false) { postTable.find("tbody").find("tr") }
    }
}

class PostRow extends Module {
    static content = {
        cell { $("td", it) }
        cellText { cell(it).text() }
        title { cellText(0) }
        author(required: false) { cellText(1) }
        published(required: false) { cellText(2) }
        slug(required: false) { cellText(3) }
        editLink(to: AdminPostEditPage) { cell(0).find("a") }
    }
}
