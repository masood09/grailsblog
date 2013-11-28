package pages
import geb.Module

class LoginPage extends ScaffoldPage {
    static url = "login/auth"

    static at = {
        title ==~ /Grailsblog - Login/
    }

    static content = {
        loginButton { $("button.btn.btn-red") }
    }
}
