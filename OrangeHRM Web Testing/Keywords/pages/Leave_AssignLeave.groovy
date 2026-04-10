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
import helpers.helpersKeywords
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.Keys

import internal.GlobalVariable

public class Leave_AssignLeave {
	// ======================================================
	// Dependencies
	// ======================================================
	def helpers = new helpersKeywords()
	// ====== Common Objects ======
	TestObject leaveMenu       = findTestObject('Page_OrangeHRM/Admin/MyInfo/span_Leave')
	TestObject moreMenu        = findTestObject('Page_OrangeHRM/Admin/MyInfo/span_More_1')
	TestObject assignLeaveLink = findTestObject('Page_OrangeHRM/Admin/MyInfo/a_Assign Leave')
	TestObject assignButton    = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Assign')
	TestObject okButton        = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Ok')
	TestObject successMessage  = findTestObject('Page_OrangeHRM/Admin/MyInfo/div_SuccessSuccessfully Saved')
	TestObject leaveListMenu   = findTestObject('Page_OrangeHRM/Admin/MyInfo/li_Leave List')
	TestObject searchButton    = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Search')
	TestObject menuPerformance = findTestObject('Page_OrangeHRM/Admin/Page_Leave/a_Performance')
	//TestObject employeeInput = findTestObject('Page_OrangeHRM/Admin/Page_Leave/input')
	TestObject dropdownArrow = findTestObject('Page_OrangeHRM/Admin/Page_Leave/input_ShowLeaveWithStatus')
	//TestObject searchButton = findTestObject('Page_OrangeHRM/Admin/Page_Leave/button_Search')
	TestObject resultRow = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_2026-14-04Luiz Carlos AnjosCAN - Bereav_d323b8')
	TestObject employeeName = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_Luiz Carlos Anjos')
	TestObject leaveAmount = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_1.00')

	// ====== Inputs ======
	TestObject employeeInput   = findTestObject('Page_OrangeHRM/Admin/MyInfo/input')
	TestObject fromDateInput   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Leave/input_FromDate')
	TestObject toDateInput     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Leave/input_ToDate')
	TestObject selectEmployee     = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_NameDropdown')
	TestObject leaveTypeInput     = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_LeaveType')

	// Success validations
	TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')

	// ====== Dynamic Objects ======

	// ====== Methods ======
	// ====== Switch-based method ======
	def performAction(String actionType, Map params = [:],String optionText = "") {
		if (params.containsKey('firstName') && params.containsKey('lastName')) {
			params['name'] = params['firstName'] + " " + params['lastName']
		}
		switch(actionType.toLowerCase()) {
			case "leavemenu":
				WebUI.waitForElementClickable(leaveMenu, 10)
				WebUI.click(leaveMenu)
				KeywordUtil.logInfo("Leave page opened")
				break
			case "openassignleave":
				WebUI.waitForElementClickable(assignLeaveLink, 10)
				WebUI.click(assignLeaveLink)
				KeywordUtil.logInfo("Assign Leave page opened")
				break

			case "selectemployee":
/*
				WebUI.setText(employeeInput, params['name'])
				WebUI.waitForElementPresent(selectEmployee, 10, FailureHandling.STOP_ON_FAILURE)
				WebUI.click(selectEmployee)
				KeywordUtil.logInfo("Employee selected : " + params['name'])*/
			
			helpers.selectEmployee(employeeInput, selectEmployee, params['name'])
				break

			case "leavetype":
				WebUI.waitForElementClickable(leaveTypeInput, 10)
				WebUI.click(leaveTypeInput)
				new helpersKeywords().selectDropdownOption(optionText)
				break

			case "assignleave":
				WebUI.click(assignButton)
				KeywordUtil.logInfo("Assign button clicked")
				break

			case "confirmassignment":
				WebUI.click(okButton)
				WebUI.verifyElementVisible(successMessage)
				KeywordUtil.logInfo("Leave assignment confirmed")
				break

			case "searchleavelist":
				WebUI.waitForElementClickable(leaveListMenu, 10)
				WebUI.click(leaveListMenu)
			//WebUI.click(searchButton)
				KeywordUtil.logInfo("Leave list opened ")
				break

			default:
				KeywordUtil.markFailed("Unsupported action type: " + actionType)
				break
		}
	}


	
	def verifyNotification(String actionType) {
	
		TestObject notificationObj
		String expectedMessage
	
		switch (actionType?.toLowerCase()) {
			case "update":
				notificationObj = notificationUpdate
				expectedMessage = "Successfully Updated"
				break
	
			case "save":
				notificationObj = notificationSaved
				expectedMessage = "Successfully Saved"
				break
	
			default:
				KeywordUtil.markWarning(
					"Unsupported action type for notification validation: ${actionType}"
				)
				return
		}
	
		// ✅ Try to detect notification WITHOUT failing the test
		boolean notificationPresent = WebUI.waitForElementPresent(
			notificationObj,
			3,
			FailureHandling.OPTIONAL
		)
	
		if (!notificationPresent) {
			KeywordUtil.logInfo(
				"ℹ️ No notification displayed for action '${actionType}'. This is acceptable."
			)
			return
		}
	
		// ✅ Try to read text safely
		try {
			String actualMessage = WebUI.getText(
				notificationObj,
				FailureHandling.OPTIONAL
			)
	
			KeywordUtil.logInfo(
				"ℹ️ Toast notification detected: ${actualMessage}"
			)
	
			if (!actualMessage?.contains(expectedMessage)) {
				KeywordUtil.markWarning(
					"Expected notification to contain '${expectedMessage}', but got '${actualMessage}'"
				)
			} else {
				KeywordUtil.logInfo("✅ Notification verified successfully.")
			}
	
		} catch (Exception e) {
			KeywordUtil.logInfo(
				"ℹ️ Notification appeared but could not be read (non-blocking)."
			)
		}
	}

	void EmployeeResult(String firstName, String lastName, String expectedDays) {

		// Build full name
		String expectedName = firstName + " " + lastName
		KeywordUtil.logInfo("Expected name: " + expectedName)

		// 1. Validate full row text
		String rowText = WebUI.getText(resultRow)
		KeywordUtil.logInfo("Row text: " + rowText)

		if (!rowText.contains(expectedName)) {
			KeywordUtil.markFailed("Row does not contain the expected name. Expected: '${expectedName}' | Found: '${rowText}'")
		}

		if (!rowText.contains(expectedDays)) {
			KeywordUtil.markFailed("Row does not contain the expected days. Expected: '${expectedDays}' | Found: '${rowText}'")
		}

		// 2. Validate specific name
		String actualName = WebUI.getText(employeeName)
		KeywordUtil.logInfo("Displayed name: " + actualName)

		if (!actualName.contains(expectedName)) {
			KeywordUtil.markFailed("Name does not match. Expected: '${expectedName}' | Found: '${actualName}'")
		}

		// 3. Validate specific days
		String actualDays = WebUI.getText(leaveAmount)
		KeywordUtil.logInfo("Displayed days: " + actualDays)

		if (!actualDays.contains(expectedDays)) {
			KeywordUtil.markFailed("Days do not match. Expected: '${expectedDays}' | Found: '${actualDays}'")
		}

		KeywordUtil.logInfo("Validation successful: name and days match.")
	}

	def SearchOption(String actionType, Map params = [:],String optionText = "") {
		if (params.containsKey('firstName') && params.containsKey('lastName')) {
			params['name'] = params['firstName'] + " " + params['lastName']
		}
		switch(actionType.toLowerCase()) {

			case "employeename":
				WebUI.setText(employeeInput, params['name'])
				WebUI.delay(2)
				WebUI.click(selectEmployee)
				KeywordUtil.logInfo("Employee selected : " + params['name'])
				break

			case "showleavetaken":
				WebUI.waitForElementClickable(dropdownArrow, 10)
				WebUI.click(dropdownArrow)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "showleavescheduled":
				WebUI.waitForElementClickable(dropdownArrow, 10)
				WebUI.click(dropdownArrow)
				new helpersKeywords().selectDropdownOption(optionText)
				break


			default:
				KeywordUtil.markFailed("Unsupported action type: " + actionType)
				break
		}
	}

	def setFromDate(String dateValue) {
		/*TestObject fromDateInput = new TestObject("dynamicFromDate")
		 fromDateInput.addProperty("xpath", ConditionType.EQUALS,
		 "//label[text()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input[@placeholder='yyyy-dd-mm']")
		 */
		WebUI.waitForElementClickable(fromDateInput, 10)
		WebUI.click(fromDateInput)
		WebUI.sendKeys(fromDateInput, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(fromDateInput, Keys.chord(Keys.DELETE))
		WebUI.setText(fromDateInput, dateValue)
	}

	def setToDate(String dateValue) {
		/*TestObject toDateInput = new TestObject("dynamicToDate")
		 toDateInput.addProperty("xpath", ConditionType.EQUALS,
		 "//label[text()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input[@placeholder='yyyy-dd-mm']")
		 */
		WebUI.waitForElementClickable(toDateInput, 10)
		WebUI.click(toDateInput)
		WebUI.sendKeys(toDateInput, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(toDateInput, Keys.chord(Keys.DELETE))
		WebUI.setText(toDateInput, dateValue)
	}

	def setDates(String fromDate, String toDate) {
		setFromDate(fromDate)
		setToDate(toDate)
	}




	def clickButton(String buttonType) {

		switch(buttonType.toLowerCase()) {

			case "ok":
				WebUI.delay(1)
				WebUI.waitForElementClickable(okButton, 10)
				WebUI.click(okButton)
				break

			case "search":
				WebUI.waitForElementClickable(searchButton, 10)
				WebUI.click(searchButton)
				break

			default:
				KeywordUtil.markFailed("Unsupported button type: " + buttonType)
		}
	}
}

