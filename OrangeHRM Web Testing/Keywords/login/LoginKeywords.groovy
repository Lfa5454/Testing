package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import browserConfig.GlobalBrowserConfig


import internal.GlobalVariable

class LoginKeywords {
	TestObject userName            = findTestObject('Page_OrangeHRM/Login/input_Username')
	TestObject userPass            = findTestObject('Page_OrangeHRM/Login/input_Password')
	TestObject loginBtn            = findTestObject('Page_OrangeHRM/Login/button_Login')
	TestObject headerDashboard     = findTestObject('Page_OrangeHRM/Login/header_Dashboard')

	// ============================
	// 🔹 LOGIN FLOW
	// ============================
	@Keyword
	def loginToOrangeHRM(String username, String password) {
		// Always open browser first
		WebUI.openBrowser('')
		WebUI.maximizeWindow()

		// Navigate to login page
		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
		WebUI.waitForPageLoad(10)

		KeywordUtil.logInfo("Logging in with user: " + username)

		// Perform login
		WebUI.waitForElementClickable(userName, 10)
		WebUI.setText(userName, username)
		WebUI.waitForElementClickable(userPass, 10)
		WebUI.setEncryptedText(userPass, password)
		WebUI.click(loginBtn)


		// Validate login
		WebUI.waitForElementVisible(headerDashboard, 10)
		KeywordUtil.logInfo("Login successful")
	}


	@Keyword
	def login(String username, String password) {
		WebDriver driver
		String browserType = (GlobalVariable.browserType ?: "chrome").toLowerCase()
		boolean incognito = GlobalVariable.incognito ?: false

		switch (browserType) {
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
				KeywordUtil.logInfo("Browser no reconocido, se usará Chrome por defecto")
				driver = new ChromeDriver()
		}

		DriverFactory.changeWebDriver(driver)
		WebUI.maximizeWindow()

		// Login
		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
		WebUI.waitForPageLoad(10)

		WebUI.setText(findTestObject('Page_OrangeHRM/Login/input_Username'), username)
		WebUI.setEncryptedText(findTestObject('Page_OrangeHRM/Login/input_Password'), password)
		WebUI.click(findTestObject('Page_OrangeHRM/Login/button_Login'))

		WebUI.waitForElementVisible(findTestObject('Page_OrangeHRM/Login/header_Dashboard'), 10)
		KeywordUtil.logInfo("Login successful")
		
		
		

		// =========== Validation ============
		// Validation 1 : Verify redirect to the Dashboard page
		WebUI.verifyMatch(WebUI.getUrl(), 'https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index', false)

		// Validation 2 : Verify the page header text is “Dashboard”
		WebUI.verifyElementVisible(findTestObject('Object Repository/Page_OrangeHRM/Login/header_Dashboard'))
	}
}


