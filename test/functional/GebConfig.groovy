/*
 This is the Geb configuration file.
 See: http://www.gebish.org/manual/current/configuration.html
 */

import org.openqa.selenium.firefox.FirefoxDriver

driver = { new FirefoxDriver() }

environments {
    // run as “grails -Dgeb.env=firefox test-app”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
}
