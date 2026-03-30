// ✅ Katalon imports
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// ✅ Selenium WebDriver cookie handling
import org.openqa.selenium.Cookie

// ✅ Groovy JSON utilities
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

// ✅ Java file handling
import java.io.File

// ✅ Your custom keyword class
import login.LoginKeywords
import internal.GlobalVariable

class TestListener {

	// ============================
	// 🔹 Before Suite: open browser and load cookies
	// ============================
	@BeforeTestSuite
	def beforeSuite() {
		if (!GlobalVariable.loginDone) {
			CustomKeywords.'login.LoginKeywords.login'(GlobalVariable.adminUsername, GlobalVariable.adminPass)
			GlobalVariable.loginDone = true
		}

		def driver = DriverFactory.getWebDriver()
		def cookieFile = new File("C:/ruta/cookies.json")
		if (cookieFile.exists()) {
			def jsonSlurper = new JsonSlurper()
			def cookies = jsonSlurper.parse(cookieFile)

			cookies.each { c ->
				Cookie cookie = new Cookie(c.name, c.value, c.domain, c.path, null, c.secure)
				driver.manage().addCookie(cookie)
			}
			driver.navigate().refresh() // refresh to apply cookies
		}
		
	}

	// ============================
	// 🔹 After Suite: save cookies
	// ============================
	@AfterTestSuite
	def afterSuite() {
		def driver = DriverFactory.getWebDriver()
		if (driver != null) {
			def cookies = driver.manage().getCookies()
			def cookieList = []
			cookies.each { c ->
				cookieList << [
					name: c.getName(),
					value: c.getValue(),
					domain: c.getDomain(),
					path: c.getPath(),
					expiry: c.getExpiry(),
					isSecure: c.isSecure()
				]
			}
			new File("Cookies.json").text = JsonOutput.toJson(cookieList)
			KeywordUtil.logInfo(">>> Cookies saved to Cookies.json")
		}

		// Stop the entire suite execution immediately on any failure
		KeywordUtil.markFailedAndStop("A test case failed, stopping suite execution.")
	}

	// ============================
	// 🔹 After each Test Case: handle failures
	// ============================
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		if (testCaseContext.getTestCaseStatus() == "FAILED") {
			KeywordUtil.logInfo(">>> Test Case failed: " + testCaseContext.getTestCaseId())

			// Take screenshot
			String screenshotPath = WebUI.takeScreenshot()
			KeywordUtil.logInfo(">>> Screenshot saved at: " + screenshotPath)
		}
	}
}