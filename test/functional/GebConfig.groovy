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

    // run as "grails -Dgeb.env=travisxpie8 test-app"
    travisxpie8 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "8")
            capabilities.setCapability("platform", "Windows XP")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=traviswin7ie8 test-app"
    traviswin7ie8 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "8")
            capabilities.setCapability("platform", "Windows 7")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=traviswin7ie9 test-app"
    traviswin7ie9 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "9")
            capabilities.setCapability("platform", "Windows 7")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=traviswin7ie10 test-app"
    traviswin7ie10 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "10")
            capabilities.setCapability("platform", "Windows 7")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=traviswin8ie10 test-app"
    traviswin8ie10 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "10")
            capabilities.setCapability("platform", "Windows 8")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }

    // run as "grails -Dgeb.env=traviswin81ie11 test-app"
    traviswin81ie11 {
        driver = {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
            capabilities.setCapability("version", "11")
            capabilities.setCapability("platform", "Windows 8.1")
            capabilities.setCapability("tunnel-identifier", System.env.TRAVIS_JOB_NUMBER)

            new RemoteWebDriver(
                new URL("http://masood09:a677f19e-8103-4576-8ab8-71c0dbfe29c2@ondemand.saucelabs.com/wd/hub"), capabilities
            )
        }
    }
}
