package helpers

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import org.openqa.selenium.Keys
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import org.openqa.selenium.StaleElementReferenceException
import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class helpersKeywords {

	// Success validations
	TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')


	/*
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


	/**
	 * Clear an input field and set a new Employee ID
	 * @param inputField TestObject representing the Employee ID input
	 * @return String new Employee ID generated
	 */
	@Keyword
	def clearAndSetEmployeeId(TestObject inputField) {
		// Clear field
		WebUI.click(inputField)
		WebUI.sendKeys(inputField, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(inputField, Keys.chord(Keys.BACK_SPACE))

		// Generate random ID
		int randomNumber = ((Math.random() * 90000) as int) + 10000
		String newId = 'E-' + randomNumber

		// Set new ID
		WebUI.setText(inputField, newId)

		return newId
	}

	/**
	 * Verify if a username already exists in the system
	 * @param usernameField TestObject representing the "username already exists" message
	 * @return true if the username exists, false otherwise
	 */
	@Keyword
	def checkIfUserExists(TestObject usernameField) {
		boolean userExists = WebUI.verifyElementText(
				usernameField,
				'Username already exists',
				FailureHandling.OPTIONAL
				)

		if (userExists) {
			KeywordUtil.logInfo('Test Result: Username already exists')
			WebUI.closeBrowser()
			KeywordUtil.markFailedAndStop('User already exists.')
		}

		return userExists
	}


	// ============================
	// 🔹 SEARCH EMPLOYEE FLOW
	// ============================
	@Keyword
	def searchEmployee(String firstName, String lastName) {
		WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Common/menu_PIM'))
		WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName'),
				firstName + ' ' + lastName)
		WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/button_Search'))
	}



	/**
	 * Search employees by different criteria in OrangeHRM
	 * @param nameInput TestObject for the employee name input field
	 * @param idInput TestObject for the employee ID input field
	 * @param statusDropdown TestObject for the employee status dropdown
	 * @param searchButton TestObject for the search button
	 * @param firstName First name of the employee (optional)
	 * @param lastName Last name of the employee (optional)
	 * @param employeeId Employee ID value (optional)
	 * @param status Employee status label (optional)
	 */

	@Keyword
	def searchEmployeeByCriteria(TestObject nameInput, TestObject idInput, TestObject statusDropdown, TestObject usernameInput,
			TestObject searchButton, String firstName, String lastName,
			String employeeId, String status, String username) {
		if (firstName && lastName) {
			WebUI.clearText(nameInput)
			WebUI.setText(nameInput, firstName + ' ' + lastName)
			KeywordUtil.logInfo("Search by Full Name: " + firstName + " " + lastName)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}

		else if (firstName && firstName.trim()) {
			WebUI.clearText(nameInput)
			WebUI.setText(nameInput, firstName)
			KeywordUtil.logInfo("Search by First Name: " + firstName)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}

		else if (lastName && lastName.trim()) {
			WebUI.clearText(nameInput)
			WebUI.setText(nameInput, lastName)
			KeywordUtil.logInfo("Search by Last Name: " + lastName)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}



		if (employeeId && employeeId.trim()) {
			WebUI.clearText(idInput)
			WebUI.setText(idInput, employeeId)
			KeywordUtil.logInfo("Search by Employee ID: " + employeeId)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}

		if (status && status.trim()) {
			WebUI.selectOptionByLabel(statusDropdown, status, false)
			KeywordUtil.logInfo("Search by Status: " + status)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}
		if (username && username.trim()) {
			WebUI.clearText(usernameInput)
			WebUI.setText(usernameInput, username)
			KeywordUtil.logInfo("Search by Status: " + username)
			WebUI.delay(2)
			WebUI.click(searchButton)
		}
	}

	/**
	 * Validate that a given Employee ID exists in the table and matches the expected value.
	 *
	 * @param employeeId The Employee ID value to search for
	 *
	 * Steps performed:
	 * 1. Create a dynamic TestObject with an XPath that matches the given Employee ID.
	 * 2. Verify if the element is present within 5 seconds.
	 * 3. If present, retrieve the text and compare it with the expected Employee ID.
	 * 4. Mark the test as Passed if it matches, otherwise mark as Failed.
	 * 5. If not found, mark as Failed with a descriptive message.
	 */

	@Keyword

	def validateInputValue(String value1) {
		// If value2 is not empty, concatenate with a space; otherwise just use value1

		String inputValue = value1

		TestObject dynamicEmployeeId = new TestObject("dynamicEmployeeId")
		dynamicEmployeeId.addProperty("xpath", ConditionType.EQUALS,"//*[normalize-space(text()) and normalize-space(.)='" + value1 + "']")


		boolean idExists = WebUI.verifyElementPresent(dynamicEmployeeId, 5)

		if (idExists) {
			String employeeIdFound = WebUI.getText(dynamicEmployeeId)
			println("Employee ID found: " + employeeIdFound)

			if (employeeIdFound.equals(inputValue)) {
				KeywordUtil.markPassed("Employee ID " + inputValue + " was found successfully.")
			} else {
				KeywordUtil.markFailed("Employee ID does not match. Expected: "
						+ inputValue + " but found: " + employeeIdFound)
			}
			return dynamicEmployeeId
		} else {
			KeywordUtil.markFailed("Employee ID " + inputValue + " was not found in the table.")
			return null
		}
	}


	// ============================
	// 🔹 VERIFY RECORD(S)
	// ============================


	@Keyword
	def verifyRecords() {
		String actualMessage = WebUI.getText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/text_RecordFound')).trim()

		if (actualMessage.startsWith("No Records")) {
			KeywordUtil.markFailedAndStop("No records found,with the criteria added in Employee information")
			//WebUI.callTestCase(findTestCase('Test Suites/E2E - 01'), [:], FailureHandling.STOP_ON_FAILURE)

			return false
		} else if (actualMessage.startsWith("(1) Record Found")) {
			KeywordUtil.markPassed("Single record found")
			return true
		} else if (actualMessage.startsWith("\\(\\d+\\) Records Found")) {
			KeywordUtil.markPassed("Multiple records found")
			return true
		} else {
			KeywordUtil.markFailedAndStop("Unexpected result: " + actualMessage)
			return false
		}
	}




	/**
	 * 🔹 Selects a dropdown option by visible text
	 * @param optionText Exact text of the option to select
	 */

	@Keyword
	def selectDropdownOption(String optionText, TestObject selectedValueObj = null) {
		String xpath = "(//div[contains(@class,'oxd-select-dropdown')]//span[normalize-space(text())='" + optionText + "'])[1]"
		KeywordUtil.logInfo("XPath used: " + xpath)

		TestObject dynamicOption = new TestObject("dynamicOption")
		dynamicOption.addProperty("xpath", ConditionType.EQUALS, xpath)

		if (WebUI.waitForElementVisible(dynamicOption, 10)) {
			WebUI.waitForElementClickable(dynamicOption, 10)
			WebUI.click(dynamicOption)
			KeywordUtil.logInfo("Option '" + optionText + "' selected successfully")

			if (selectedValueObj != null) {
				WebUI.waitForElementVisible(selectedValueObj, 10)
				String selectedText = WebUI.getText(selectedValueObj)
				WebUI.verifyMatch(selectedText, optionText, false)
			}
		} else {
			KeywordUtil.markFailed("Option '" + optionText + "' not found in dropdown")
		}
	}

	/**
	 * Verify that a given text is displayed in the specified TestObject.
	 *
	 * @param textMessageObject TestObject pointing to the element that contains the message
	 * @param expectedText Expected text to validate
	 * @return boolean True if the text matches, False otherwise
	 */
	@Keyword
	def verifyTextDisplayed(TestObject textMessageObject, String expectedText) {
		// Wait until the element is visible
		WebUI.waitForElementVisible(textMessageObject, 5)

		// Get actual text and normalize
		String actualText = WebUI.getText(textMessageObject).trim()
		println("Actual text found: " + actualText)

		// Compare ignoring case
		if (actualText.equalsIgnoreCase(expectedText.trim())) {
			KeywordUtil.markPassed("Text matched: " + actualText)
			return true
		} else {
			KeywordUtil.markFailed("Text mismatch. Expected: " + expectedText + " but found: " + actualText)
			return false
		}
	}


	@Keyword
	def verifyUniqueUsername(TestObject usernameObj, String expectedUsername) {
		WebUI.waitForElementVisible(usernameObj, 10)

		long count = 0
		int retries = 0

		while (count == 0 && retries < 2) {
			try {
				List<WebElement> usernames = WebUiCommonHelper.findWebElements(usernameObj, 5)
				count = usernames.stream()
						.filter { it.getText().equalsIgnoreCase(expectedUsername) }
						.count()
			} catch (StaleElementReferenceException e) {
				KeywordUtil.logInfo("Element refreshed, retrying...")
			}
			retries++
			if (count == 0) {
				WebUI.delay(2) // wait before retrying
			}
		}

		if (count == 1) {
			KeywordUtil.markPassed("Exactly one username found: " + expectedUsername)
		} else if (count == 0) {
			KeywordUtil.markFailed("Username not found: " + expectedUsername)
		} else {
			KeywordUtil.markFailed("Multiple matches (" + count + ") found for: " + expectedUsername)
		}
	}

	@Keyword
	def verifyFullName(String firstName, String lastName) {
		// Construir dinámicamente el TestObject con XPath que busque ambos valores en la misma fila
		TestObject fullNameRow = new TestObject("dynamicFullNameRow")
		fullNameRow.addProperty("xpath", ConditionType.EQUALS,
				"//tr[td[normalize-space(text())='" + firstName + "'] and td[normalize-space(text())='" + lastName + "']]")

		WebUI.waitForElementVisible(fullNameRow, 10)

		if (WebUI.verifyElementPresent(fullNameRow, 5, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Nombre y apellido encontrados en la misma fila: " + firstName + " " + lastName)
		} else {
			KeywordUtil.markFailed("No se encontró la fila con: " + firstName + " " + lastName)
		}
	}

	@Keyword
	def verifyRedirectPage(String expectedUrlFragment) {
		WebUI.waitForPageLoad(10)
		String currentUrl = WebUI.getUrl()

		if (currentUrl.matches(".*${expectedUrlFragment}.*")) {
			KeywordUtil.logInfo("Redirect successful: " + currentUrl)
		} else {
			KeywordUtil.markFailed("Redirect failed. Expected fragment: " + expectedUrlFragment + " but got: " + currentUrl)
			WebUI.closeBrowser()
		}
	}
	/**
	 * Keyword to set text in any input field by XPath
	 * @param xpath - the XPath of the input field
	 * @param value - the text to set
	 */
	@Keyword
	def setInputByXpath(TestObject inputField, String value) {
		WebUI.waitForElementClickable(inputField, 10)

		WebUI.click(inputField)
		WebUI.sendKeys(inputField, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(inputField, Keys.chord(Keys.DELETE))

		WebUI.setText(inputField, value)

		String actualValue = WebUI.getAttribute(inputField, "value")
		WebUI.verifyMatch(actualValue, value, false)
	}

	/**
	 * Keyword to select an employee from a search input
	 * @param employeeInput - TestObject for the input field
	 * @param selectEmployee - TestObject for the dropdown/selection element
	 * @param employeeName - the name to type and select
	 */
	@Keyword
	def selectEmployee(TestObject employeeInput, TestObject selectEmployee, String employeeName) {
		// Type employee name
		WebUI.waitForElementClickable(employeeInput, 10)
		WebUI.setText(employeeInput, employeeName)

		// Small delay to allow dropdown to populate
		WebUI.delay(2)

		// Click on the dropdown option
		WebUI.click(selectEmployee)

		// Log info
		KeywordUtil.logInfo("✅ Employee selected: " + employeeName)

		// Optional verification
		String actualValue = WebUI.getAttribute(employeeInput, "value")
		WebUI.verifyMatch(actualValue, employeeName, false)
	}
	@Keyword
	def verifyActiveCheckbox(TestObject activeCheckbox) {
		// Wait until the checkbox is clickable
		WebUI.waitForElementClickable(activeCheckbox, 10)

		// Check if the checkbox is selected
		boolean isChecked = WebUI.verifyElementChecked(activeCheckbox, 5, FailureHandling.OPTIONAL)

		if (isChecked) {
			KeywordUtil.logInfo("✅ Checkbox is ACTIVE")
		} else {
			KeywordUtil.logInfo("❌ Checkbox is INACTIVE")
		}

		return isChecked
	}


	@Keyword

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

			default:
				KeywordUtil.markFailed("Unsupported action type: " + actionType)
				return
		}

		// Wait for the notification to appear
		//	WebUI.waitForElementVisible(notificationObj, 10)

		// Get the actual message displayed
		String actualMessage = WebUI.getText(notificationObj)
		KeywordUtil.logInfo("Actual notification message: " + actualMessage)

		// Validate the message
		if (!actualMessage.contains(expectedMessage)) {
			KeywordUtil.markFailed(
					"Expected: '" + expectedMessage + "' but received: '" + actualMessage + "'"
					)
		} else {
			KeywordUtil.logInfo("Notification verified successfully.")
		}
	}
	
	
	@Keyword
	def setDateInput(TestObject dateInput, String dateValue) {
		// Esperar a que el campo sea clickeable
		WebUI.waitForElementClickable(dateInput, 10)

		// Click en el campo
		WebUI.click(dateInput)

		// Seleccionar todo y borrar
		WebUI.sendKeys(dateInput, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(dateInput, Keys.chord(Keys.DELETE))

		// Escribir la nueva fecha
		WebUI.setText(dateInput, dateValue)
	}

	
}