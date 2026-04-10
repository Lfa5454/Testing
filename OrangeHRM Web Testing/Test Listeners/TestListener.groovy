// ======================
// ✅ Katalon imports
// ======================
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration

// ======================
// ✅ Selenium Cookie handling
// ======================
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

// ======================
// ✅ Java utilities
// ======================
import java.io.File

// ======================
// ✅ Custom config loader
// ======================
import config.ConfigLoader

// ======================
// ✅ Custom login keyword
// ======================
import login.LoginKeywords
import internal.GlobalVariable

class TestListener {

	// 🔹 Path for persisted cookies
	static final String COOKIE_PATH =
	RunConfiguration.getProjectDir() + "/Data/cookies/cookies.json"

	// ============================
	// 🔹 Before Suite:
	//    1. Load CSV config
	//    2. Login once (using encrypted password from Profile)
	//    3. Load cookies
	// ============================
	
	@BeforeTestSuite
		def beforeSuite() {
	
			// ✅ 1️ Load configuration from CSV
			String projectDir = RunConfiguration.getProjectDir()
			String csvPath = projectDir + "/Data/config/config-exported.csv"
			ConfigLoader.loadFromCsv(csvPath)
	
			// ✅ 2️ Perform login
			// (Login keyword MUST create WebDriver if needed)
			CustomKeywords.'login.LoginKeywords.login'(
				GlobalVariable.adminUsername,
				GlobalVariable.adminPassword
			)
			GlobalVariable.loginDone = true
	
			// ✅ 3️ Safely verify WebDriver exists (compatible with all Katalon versions)
			WebDriver driver
			try {
				driver = DriverFactory.getWebDriver()
			} catch (Exception e) {
				KeywordUtil.markFailedAndStop(
					"Login keyword did not initialize WebDriver. Execution cannot continue."
				)
				return
			}
	
			// ✅ 4️⃣ Load cookies if present
			File cookieFile = new File(COOKIE_PATH)
			if (cookieFile.exists()) {
	
				def cookies = new JsonSlurper().parse(cookieFile)
	
				cookies.each { c ->
					Cookie.Builder builder =
						new Cookie.Builder(c.name as String, c.value as String)
							.domain(c.domain as String)
							.path(c.path as String)
	
					if (c.expiry != null) {
						builder.expiresOn(c.expiry)
					}
					if (c.isSecure != null && c.isSecure) {
						builder.isSecure(true)
					}
	
					driver.manage().addCookie(builder.build())
				}
	
				driver.navigate().refresh()
				KeywordUtil.logInfo("✅ Cookies loaded successfully")
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
					name     : c.getName(),
					value    : c.getValue(),
					domain   : c.getDomain(),
					path     : c.getPath(),
					expiry   : c.getExpiry(),
					isSecure : c.isSecure()
				]
			}

			def cookieFile = new File(COOKIE_PATH)
			cookieFile.parentFile.mkdirs()
			cookieFile.text = JsonOutput.toJson(cookieList)

			KeywordUtil.logInfo("✅ Cookies saved to ${COOKIE_PATH}")
		}
	}

	// ============================
	// 🔹 After each Test Case:
	//    Stop suite on failure
	// ============================
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {

		if (testCaseContext.testCaseStatus == "FAILED") {
			KeywordUtil.logInfo(
					"❌ Test Case failed: ${testCaseContext.testCaseId}"
					)

			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(
					"Test case failed. Stopping suite execution."
					)
		}
	}
}