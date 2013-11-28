package pages
import geb.Module

class AdminTagIndexPage extends ScaffoldPage {
    static url = "admin/tags"

    static at = {
        title ==~ /Grailsblog - Tags/
    }

    static content = {
        createNewTagLink { $("a", text: "Create a new tag") }
        tagTable { $("div.table-responsive table", 0) }
        tagRow { module TagRow, tagRows[it] }
        tagRows(required: false) { tagTable.find("tbody").find("tr") }
    }
}

class TagRow extends Module {
    static content = {
        cell { $("td", it) }
        cellText { cell(it).text() }
        name { cellText(0) }
        slug(required: false) { cellText(1) }
        editLink(to: AdminTagEditPage) { cell(0).find("a") }
    }
}
