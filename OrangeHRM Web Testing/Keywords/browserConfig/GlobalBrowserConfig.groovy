package browserConfig

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class GlobalBrowserConfig {
	
	
	TestObject userName            = findTestObject('Page_OrangeHRM/Login/input_Username')
	TestObject userPass            = findTestObject('Page_OrangeHRM/Login/input_Password')
	TestObject loginBtn            = findTestObject('Page_OrangeHRM/Login/button_Login')
	TestObject headerDashboard     = findTestObject('Page_OrangeHRM/Login/header_Dashboard')
	
    static WebDriver getDriver() {
        WebDriver driver
        String browserTypeSelected = (GlobalVariable.browserType ?: "chrome").toLowerCase()
        boolean incognito = GlobalVariable.incognito ?: false

        switch (browserTypeSelected) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions()
                if (incognito) chromeOptions.addArguments("--incognito")
                driver = new ChromeDriver(chromeOptions)
                break

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions()
                if (incognito) firefoxOptions.addArguments("-private")
                driver = new FirefoxDriver(firefoxOptions)
                break

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions()
                if (incognito) edgeOptions.addArguments("-inprivate")
                driver = new EdgeDriver(edgeOptions)
                break

            default:
                KeywordUtil.logInfo("BrowserType no reconocido, se usará Chrome por defecto")
                driver = new ChromeDriver()
                break
        }

        DriverFactory.changeWebDriver(driver)
        WebUI.maximizeWindow()
        return driver
    }

    @Keyword
def login(String username, String password) {
    if (DriverFactory.getWebDriver() == null) {
        getDriver()
    }

    if (!(GlobalVariable.isLoggedIn ?: false)) {
        WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
        WebUI.waitForPageLoad(10)

        KeywordUtil.logInfo("Login with user: " + username)

        WebUI.waitForElementClickable(userName, 10)
        WebUI.setText(userName, username)

        WebUI.waitForElementClickable(userPass, 10)
        WebUI.setEncryptedText(userPass, password)

        WebUI.click(loginBtn)

        WebUI.waitForElementVisible(headerDashboard, 10)
        KeywordUtil.logInfo("Login successful")

        GlobalVariable.isLoggedIn = true   // ✅ Marca que ya se inició sesión
    } else {
        KeywordUtil.logInfo("Login already performed, reusing session")
    }
}
}