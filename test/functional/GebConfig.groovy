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
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@localhost:4455/wd/hub"), capabilities
            )
        }
    }
}
