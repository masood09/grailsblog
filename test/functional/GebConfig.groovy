/*
 This is the Geb configuration file.
 See: http://www.gebish.org/manual/current/configuration.html
 */

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

driver = { new FirefoxDriver() }

environments {
    // run as "grails -Dgeb.env=firefox test-app"
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

    // run as "grails -Dgeb.env=xpie8 test-app"
    xpie8 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "8")
            capabilities.setCapability("platform", "Windows XP")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=xpie7 test-app"
    xpie7 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "7")
            capabilities.setCapability("platform", "Windows XP")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=xpie6 test-app"
    xpie6 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "6")
            capabilities.setCapability("platform", "Windows XP")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=win7ie8 test-app"
    win7ie8 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "8")
            capabilities.setCapability("platform", "Windows 7")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=win7ie9 test-app"
    win7ie9 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "9")
            capabilities.setCapability("platform", "Windows 7")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=win7ie10 test-app"
    win7ie10 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "10")
            capabilities.setCapability("platform", "Windows 7")

            new RemoteWebDriver(
                new URL("http://masood09@a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4445/wd/hub"), capabilities
            )
        }
    }
}
