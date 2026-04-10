package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import helpers.helpersKeywords



public class PIM_SearchEmployeeAndEdit {
	// Common objects
	TestObject menuPIM            = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')
	TestObject adminMenu          = findTestObject('Page_OrangeHRM/Admin/Common/Admin_Menu')
	TestObject addEmployeeBtn	  = findTestObject('Page_OrangeHRM/PIM/Add/button_AddEmployee')
	TestObject searchButton       = findTestObject('Page_OrangeHRM/Admin/Search/button_Search')
	TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')
	TestObject usernameAlreadyExistInput = findTestObject('Page_OrangeHRM/PIM/Add/input_UsernameAlreadyExist')
	TestObject saveButton         = findTestObject('Page_OrangeHRM/PIM/Edit/button_Save')
	TestObject addButton          = findTestObject('Page_OrangeHRM/PIM/Edit/button_Add')

	// Inputs
	TestObject employeeNameInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName')
	TestObject employeeIdInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeId')
	TestObject usernameInput      = findTestObject('Page_OrangeHRM/Admin/Search/input_Username')
	TestObject statusDropdown = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/dropdown_EmployeeStatus')
	TestObject jobTab             = findTestObject('Page_OrangeHRM/PIM/Edit/job_Tab')
	TestObject joinedDateInput    = findTestObject('Page_OrangeHRM/PIM/Edit/input_JoinedDate')
	TestObject jobTitleInput      = findTestObject('Page_OrangeHRM/PIM/Edit/txt_JobTitle')
	TestObject salaryTab          = findTestObject('Page_OrangeHRM/PIM/Edit/salary_Tab')
	TestObject salaryComponent    = findTestObject('Page_OrangeHRM/PIM/Edit/input_SalaryComponent')
	TestObject payGradeDropdown   = findTestObject('Page_OrangeHRM/PIM/Edit/txt_PayGrade')
	//TestObject payGradeSelected   = findTestObject('Page_OrangeHRM/PIM/Edit/payGrade_SelectedText')
	TestObject payFrequencyDropdown = findTestObject('Page_OrangeHRM/PIM/Edit/txt_PayFrequency')
	TestObject currencyDropdown   = findTestObject('Page_OrangeHRM/PIM/Edit/txt_Currency')
	//TestObject currencySelected   = findTestObject('Page_OrangeHRM/PIM/Edit/currency_SelectedText')
	TestObject amountInput        = findTestObject('Page_OrangeHRM/PIM/Edit/input_Amount')


	// Error validations
	TestObject firstNameError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeFirstName_Required')
	TestObject lastNameError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeLastName_Required')
	TestObject employeeIdError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeId_Required')

	// Success validations
	TestObject recordFoundText    = findTestObject('Page_OrangeHRM/Admin/Search/text_Record Found')
	TestObject employeeEnabled    = findTestObject('Page_OrangeHRM/Admin/Search/text_employeeEnabled')
	TestObject usernameDisplayed  = findTestObject('Page_OrangeHRM/Admin/Search/text_vramirezDisplayed')
	TestObject personalDetailsHeader = findTestObject('Page_OrangeHRM/PIM/Add/text_PersonalsDetails')

	// Methods
	def openMenu(String menuType) {
		switch(menuType.toLowerCase()) {
			case "admin":
				WebUI.click(adminMenu)
				KeywordUtil.logInfo("Admin menu opened")
				break

			case "pim":
				WebUI.click(menuPIM)
				KeywordUtil.logInfo("PIM menu opened")
				break
			case "job":
				WebUI.click(jobTab)
				KeywordUtil.logInfo("jobTab opened")
				break
			case "salary":
				WebUI.click(salaryTab)
				KeywordUtil.logInfo("salaryTab opened")
				break
			default:
				KeywordUtil.markFailed("Unsupported menu type: " + menuType)
				break
		}
	}

	// Method that delegates to the keyword
	def searchEmployee(String firstName, String lastName, String employeeId, String status, String username) {
		new helpersKeywords().searchEmployeeByCriteria(
				employeeNameInput,
				employeeIdInput,
				statusDropdown,
				usernameInput,
				searchButton,
				firstName,
				lastName,
				employeeId,
				status,
				username
				)
	}

	def verifyRecords() {
		new helpersKeywords().verifyRecords()
	}


	def employeeEnabled(String elementType) {
		switch(elementType.toLowerCase()) {
			case "employeeenabled":
				WebUI.waitForElementVisible(employeeEnabled, 10)
				WebUI.verifyElementVisible(employeeEnabled, FailureHandling.OPTIONAL)
				KeywordUtil.logInfo("Employee Enabled verified")
				break

			case "usernamedisplayed":
				WebUI.waitForElementVisible(usernameDisplayed, 10)
				WebUI.verifyElementVisible(usernameDisplayed, FailureHandling.OPTIONAL)
				KeywordUtil.logInfo("Username Displayed verified")
				break

			default:
				KeywordUtil.markFailed("Unsupported element type: " + elementType)
				break
		}
	}
	def verifyUniqueUsername() {
		// Direct instantiation
		new helpersKeywords().verifyUniqueUsername(
				usernameDisplayed,
				GlobalVariable.employeeUsername
				)
	}
	def verifyUniqueFullName(String employeeId, String firstName, String lastName) {

		TestObject textEmployeeID = new TestObject("dynamicEmployeeId")
		textEmployeeID.addProperty("xpath", ConditionType.EQUALS,
				"//div[contains(normalize-space(.),'" + employeeId + "')]")

		TestObject textEmployeeFirstName = new TestObject("dynamicEmployeeFirstName")
		textEmployeeFirstName.addProperty("xpath", ConditionType.EQUALS,
				"//div[contains(normalize-space(.),'" + firstName + "')]")

		TestObject textEmployeeLastName = new TestObject("dynamicEmployeeLastName")
		textEmployeeLastName.addProperty("xpath", ConditionType.EQUALS,
				"//div[contains(normalize-space(.),'" + lastName + "')]")

		WebUI.verifyElementPresent(textEmployeeID, 10)
		WebUI.verifyElementPresent(textEmployeeFirstName, 10)
		WebUI.verifyElementPresent(textEmployeeLastName, 10)

		KeywordUtil.markPassed("Record verified: " + employeeId + " - " + firstName + " " + lastName)
	}


	def validateInputValue(String value1) {
		// Concatenate if value2 is provided, otherwise just use value1
		//String inputValue = value2?.trim() ? value1 + " " + value2 : value1

		// Call your custom keyword to get the TestObject
		TestObject empObj = new helpersKeywords().validateInputValue(value1)

		// Wait until clickable
		WebUI.waitForElementClickable(empObj, 10)

		// Click on the employee record
		WebUI.delay(2)
		WebUI.click(empObj)
	}


	def setJoinedDate(String dateValue) {
		WebUI.waitForElementClickable(joinedDateInput, 10)
		WebUI.click(joinedDateInput)
		WebUI.sendKeys(joinedDateInput, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(joinedDateInput, Keys.chord(Keys.DELETE))
		//WebUI.click(joinedDateInput)
		WebUI.setText(joinedDateInput, dateValue)

		String actualValue = WebUI.getAttribute(joinedDateInput, 'value')
		if (WebUI.verifyMatch(actualValue, dateValue, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.logInfo("Joined Date set correctly: " + actualValue)
		} else {
			KeywordUtil.markFailed("Joined Date mismatch. Expected: " + dateValue + " but found: " + actualValue)
		}
	}


	def selectOption(String optionType, String optionText) {
		switch(optionType.toLowerCase()) {
			case "jobtitle":
				WebUI.waitForElementClickable(jobTitleInput, 10)
				WebUI.click(jobTitleInput)
			// Call your custom keyword to select the option
				new helpersKeywords().selectDropdownOption(optionText)
				break

			case "salarytab":
				WebUI.waitForElementClickable(salaryComponent, 10)
				WebUI.setText(salaryComponent, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(salaryComponent, 'value'), optionText, false)
				break

			case "paygrade":
				WebUI.waitForElementClickable(payGradeDropdown, 10)
				WebUI.click(payGradeDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "payfrequency":
				WebUI.waitForElementClickable(payFrequencyDropdown, 10)
				WebUI.click(payFrequencyDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "currency":
				WebUI.waitForElementClickable(currencyDropdown, 10)
				WebUI.click(currencyDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "amount":
				WebUI.waitForElementClickable(amountInput, 10)
				WebUI.setText(amountInput, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(amountInput, 'value'), optionText, false)
				break
			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}




	def clickButton(String buttonType) {
		switch(buttonType.toLowerCase()) {
			case "save":
				WebUI.waitForElementClickable(saveButton, 10)
				WebUI.click(saveButton)
				KeywordUtil.logInfo("Save button clicked")
				break

			case "addsalary":
				WebUI.waitForElementClickable(addButton, 10)
				WebUI.click(addButton)
				KeywordUtil.logInfo("Add button clicked")
				break


			default:
				KeywordUtil.markFailed("Unsupported button type: " + buttonType)
				break
		}
	}

	def verifyNotification(String actionType) {
		TestObject notificationObj
		String expectedMessage

		switch(actionType.toLowerCase()) {
			case "update":
				notificationObj = notificationUpdate
				expectedMessage = "Successfully Updated"
				break

			case "save":
				notificationObj = notificationSaved
				expectedMessage = "Successfully Saved"
				break
			case "personaldetails":
				notificationObj =  personalDetailsHeader
				expectedMessage = "Personal Details"
				break
			case "usernamealreadyexists":
				notificationObj = usernameAlreadyExistInput
				expectedMessage = "User already exists."
				break
			default:
				KeywordUtil.markFailed("No suported: " + actionType)
				return
		}
	}
}

