package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

class DashboardPage {

	// 🔒 Reusable objects (mapped to Object Repository)
	private TestObject dashboardMenu = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Dashboard/span_Dashboard')
	private TestObject employeesOnLeaveCard = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Dashboard/div_EmployeesOnLeaveToday')

	// 🔑 Actions
	def openDashboardMenu() {
		//WebUI.waitForElementClickable(dashboardMenu, 10)
		WebUI.click(dashboardMenu)
		WebUI.waitForPageLoad(10)
	}

	def verifyToDashboardUrl() {
		// Get current URL
		String currentUrl = WebUI.getUrl()

		// Expected dashboard URL
		String expectedUrl = 'https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index'

		// Verify
		WebUI.verifyMatch(currentUrl, expectedUrl, false)
	}

	def employeesOnLeaveCard(String firstName, String lastName) {
		// Defensive check: ensure TestObject is not null
		if (employeesOnLeaveCard == null) {
			KeywordUtil.markFailed("TestObject employeesOnLeaveCard is null. Check the Object Repository path.")
			return
		}

		// Wait until the card is visible
		WebUI.waitForElementVisible(employeesOnLeaveCard, 10)

		// Get the actual text from the card
		String actualText = WebUI.getText(employeesOnLeaveCard)
		KeywordUtil.logInfo("Card text: " + actualText)

		// Build expected full name
		String expectedName = firstName + " " + lastName
		KeywordUtil.logInfo("Expected name: " + expectedName)

		// Validate (case-insensitive)
		if (!actualText.toLowerCase().contains(expectedName.toLowerCase())) {
			KeywordUtil.markFailed("Card does not contain the expected name. Expected: '${expectedName}' | Found: '${actualText}'")
		} else {
			KeywordUtil.logInfo("Validation successful: card text matches expected name.")
		}
	}
	// Groovy assert (case-insensitive)
	def assertDataMatches(String firstName, String lastName) {
		if (employeesOnLeaveCard == null) {
			KeywordUtil.markFailed("TestObject employeesOnLeaveCard is null. Check the Object Repository path.")
			return
		}

		WebUI.waitForElementVisible(employeesOnLeaveCard, 10)

		String actualText = WebUI.getText(employeesOnLeaveCard)
		KeywordUtil.logInfo("Card text: " + actualText)

		String expectedName = firstName + " " + lastName
		KeywordUtil.logInfo("Expected name: " + expectedName)

		// Groovy assert (case-insensitive)
		assert actualText.toLowerCase().contains(expectedName.toLowerCase()) :
		"Assertion failed: Card does not contain expected name. Expected: '${expectedName}' | Found: '${actualText}'"

		KeywordUtil.logInfo("Validation successful: card text matches expected name.")
	}
}
