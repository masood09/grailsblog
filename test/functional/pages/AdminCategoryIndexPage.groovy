package pages
import geb.Module

class AdminCategoryIndexPage extends ScaffoldPage {
    static url = "admin/category"

    static at = {
        title ==~ /Grailsblog - Categories/
    }

    static content = {
        createNewCategoryLink { $("a", text: "Create a new category") }
        categoryTable { $("div.table-responsive table", 0) }
        categoryRow { module CategoryRow, categoryRows[it] }
        categoryRows(required: false) { categoryTable.find("tbody").find("tr") }
    }
}

class CategoryRow extends Module {
    static content = {
        cell { $("td", it) }
        cellText { cell(it).text() }
        name { cellText(0) }
        slug(required: false) { cellText(1) }
        editLink(to: AdminCategoryEditPage) { cell(0).find("a") }
    }
}
