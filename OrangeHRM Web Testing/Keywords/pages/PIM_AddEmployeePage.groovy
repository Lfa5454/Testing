package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import helpers.helpersKeywords


class PIM_AddEmployeePage {

	// Common objects

	TestObject menuPIM = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')
	TestObject addEmployeeBtn = findTestObject('Page_OrangeHRM/PIM/Add/button_AddEmployee')
	TestObject saveBtn = findTestObject('Page_OrangeHRM/PIM/Add/button_Save')
	TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')

	// Inputs
	TestObject firstNameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_FirstName')
	TestObject lastNameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_LastName')
	TestObject employeeIdInput = findTestObject('Page_OrangeHRM/PIM/Add/input_EmployeeId_active')
	TestObject usernameAlreadyExistInput = findTestObject('Page_OrangeHRM/PIM/Add/input_UsernameAlreadyExist')
	TestObject createLoginDetailsCheckboxEnabled = findTestObject('Page_OrangeHRM/PIM/Add/CreateLoginDetailsCheckbox')
	TestObject usernameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_Username')
	TestObject passwordInput = findTestObject('Page_OrangeHRM/PIM/Add/input_Password')
	TestObject confirmPasswordInput = findTestObject('Page_OrangeHRM/PIM/Add/input_PasswordConfirm')


	// Error validations
	TestObject firstNameError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeFirstName_Required')
	TestObject lastNameError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeLastName_Required')
	TestObject employeeIdError = findTestObject('Page_OrangeHRM/PIM/Add/errorMessage_EmployeeId_Required')

	// Success validations
	TestObject personalDetailsHeader = findTestObject('Page_OrangeHRM/PIM/Add/text_PersonalsDetails')
	TestObject enabledToggle = findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/span_Enabled')

	// Methods
	def openForm() {
		WebUI.click(menuPIM)
		WebUI.click(addEmployeeBtn)
	}

	def fillEmployeeData(String firstName, String lastName) {
		WebUI.setText(firstNameInput, firstName)
		WebUI.setText(lastNameInput, lastName)
	}

	def setEmployeeId() {
		String newId = new helpersKeywords().clearAndSetEmployeeId(employeeIdInput)
		GlobalVariable.employeeId = newId
	}
	def enableLoginDetails() {
		WebUI.click(createLoginDetailsCheckboxEnabled)

		WebUI.waitForElementClickable(usernameInput, 1)

		WebUI.setText(usernameInput, GlobalVariable.employeeUsername)

		WebUI.click(enabledToggle)

		WebUI.setEncryptedText(passwordInput, GlobalVariable.employeePassword)

		WebUI.setEncryptedText(confirmPasswordInput, GlobalVariable.employeePassword)
	}


	def saveEmployee() {
		WebUI.click(saveBtn)
	}

	def createLoginDetailsCheckboxEnabled() {
		WebUI.click(createLoginDetailsCheckboxEnabled)
	}



	def verifyRequiredErrors() {
		WebUI.verifyElementText(firstNameError, 'Required')
		WebUI.verifyElementText(lastNameError, 'Required')
		WebUI.verifyElementText(employeeIdError, 'Required')
	}

	// ============================
	// 🔹 VERIFY GENERIC NOTIFICATION
	// ============================


	def verifyNotification(String actionType) {
		TestObject notificationObj
		String expectedMessage

		switch(actionType.toLowerCase()) {
			case "update":
				notificationObj = notificationUpdate
				expectedMessage = "Successfully Updated"
				WebUI.delay(2)
				break

			case "save":
				notificationObj = notificationSaved
				expectedMessage = "Successfully Saved"
				WebUI.delay(2)
				break
			case "personaldetails":
				notificationObj =  personalDetailsHeader
				expectedMessage = "Personal Details"
				WebUI.delay(2)
				break
			case "usernamealreadyexists":
				notificationObj = usernameAlreadyExistInput
				expectedMessage = "User already exists."
				WebUI.delay(2)
				break
			default:
				KeywordUtil.markFailed("No suported: " + actionType)
				return
		}
	}
}
