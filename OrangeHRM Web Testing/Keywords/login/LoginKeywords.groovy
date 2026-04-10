package login


// ======================
// ✅ Katalon imports
// ======================
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


// ======================
// ✅ Selenium
// ======================

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

// ======================
// ✅ Project imports
// ======================
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable
class LoginKeywords {
	TestObject userName            = findTestObject('Page_OrangeHRM/Login/input_Username')
	TestObject userPass            = findTestObject('Page_OrangeHRM/Login/input_Password')
	TestObject loginBtn            = findTestObject('Page_OrangeHRM/Login/button_Login')
	TestObject headerDashboard     = findTestObject('Page_OrangeHRM/Login/header_Dashboard')

	// ============================
	// 🔹 Routes / Paths
	// ============================

	private static final String LOGIN_PATH = "/web/index.php/auth/login"


	// ======================
	// 🔹 LOGIN KEYWORD
	// ======================
	/**
	 * Logs into OrangeHRM.
	 * Guarantees:
	 * - WebDriver is created if missing
	 * - User is logged in
	 * - Browser remains open for the TestListener
	 */

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
	def login(String username, String encryptedPassword) {

		WebDriver driver
		boolean driverExists = true

		// ✅ 1️⃣ Check if WebDriver already exists (COMPATIBLE WAY)
		try {
			driver = DriverFactory.getWebDriver()
		} catch (Exception e) {
			driverExists = false
		}

		// ✅ 2️⃣ Create WebDriver ONLY if it does not exist
		if (!driverExists) {

			String browserType = (GlobalVariable.browserType ?: "chrome").toLowerCase()
			boolean incognito  = GlobalVariable.isIncognito ?: false

			switch (browserType) {

				case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions()
					if (incognito) {
						chromeOptions.addArguments("--incognito")
					}
					driver = new ChromeDriver(chromeOptions)
					break

				case "firefox":
					FirefoxOptions firefoxOptions = new FirefoxOptions()
					if (incognito) {
						firefoxOptions.addArguments("-private")
					}
					driver = new FirefoxDriver(firefoxOptions)
					break

				case "edge":
					EdgeOptions edgeOptions = new EdgeOptions()
					if (incognito) {
						edgeOptions.addArguments("-inprivate")
					}
					driver = new EdgeDriver(edgeOptions)
					break

				default:
					KeywordUtil.logInfo(
					"Browser not recognized. Defaulting to Chrome."
					)
					driver = new ChromeDriver()
			}

			// ✅ Register driver with Katalon
			DriverFactory.changeWebDriver(driver)
			WebUI.maximizeWindow()
		}

		// ✅ 3️⃣ Execute login ONLY if user is not already logged in
		if (!isUserAlreadyLoggedIn()) {

			WebUI.navigateToUrl(
					GlobalVariable.baseUrl + LOGIN_PATH
					)
			WebUI.waitForPageLoad(10)

			KeywordUtil.logInfo("Logging in as user: ${username}")

			WebUI.waitForElementClickable(
					findTestObject('Page_OrangeHRM/Login/input_Username'),
					10
					)
			WebUI.setText(
					findTestObject('Page_OrangeHRM/Login/input_Username'),
					username
					)

			WebUI.setEncryptedText(
					findTestObject('Page_OrangeHRM/Login/input_Password'),
					encryptedPassword
					)

			WebUI.click(
					findTestObject('Page_OrangeHRM/Login/button_Login')
					)

			WebUI.waitForElementVisible(
					findTestObject('Page_OrangeHRM/Login/header_Dashboard'),
					15
					)

			KeywordUtil.logInfo("✅ Login successful")
		} else {
			KeywordUtil.logInfo("✅ User already logged in. Skipping login.")
		}

		// ✅ 4️⃣ Contract guarantee: user is on Dashboard
		WebUI.verifyElementVisible(
				findTestObject('Page_OrangeHRM/Login/header_Dashboard')
				)
	}

	// ======================
	// 🔹 Helper method
	// ======================
	/**
	 * Determines whether the user is already logged in.
	 * NOTE: MUST NOT be private in Katalon Custom Keywords.
	 */
	def isUserAlreadyLoggedIn() {
		return WebUI.verifyElementPresent(
				findTestObject('Page_OrangeHRM/Login/header_Dashboard'),
				5,
				FailureHandling.OPTIONAL
				)
	}
}
