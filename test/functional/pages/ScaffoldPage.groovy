package pages

import geb.Page

class ScaffoldPage extends Page {
    static content = {
        errorMessage { $("div.alert.alert-error").text() }
        infoMessage { $("div.alert.alert-info").text() }
    }
}
