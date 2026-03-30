package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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


public class MyInfo_SearchEmployeeAndEdit {
	
	
	// Common objects
	TestObject myInfoMenu          = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/a_My Info')
	TestObject contactDetailsMenu          = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/a_Contact Details')
	TestObject saveBtn          = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/button_Save')
	TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')
	TestObject personalDetailsHeader = findTestObject('Page_OrangeHRM/PIM/Add/text_PersonalsDetails')
	
	
	// Inputs
	TestObject input_MaritalStatus          = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_maritalStatus')
	TestObject input_Street         = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_Street')
	TestObject input_City         = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_Street')
	TestObject input_NumberStreet        = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_NumberStreet')
	TestObject input_State         = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_State')
	TestObject input_Mobile       = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/Page_OrangeHRM/input_Mobile')
	
	
	// Methods
	def openMenu(String menuType) {
		switch(menuType.toLowerCase()) {
			case "myinfomenu":
			WebUI.waitForElementClickable(myInfoMenu, 10)
				WebUI.click(myInfoMenu)
				KeywordUtil.logInfo("myInfo menu opened")
				break
	
			case "contactdetails":
				WebUI.click(contactDetailsMenu)
				KeywordUtil.logInfo("contactdetails tab opened")
				break
			
			default:
				KeywordUtil.markFailed("Unsupported menu type: " + menuType)
				break
		}
	}
	
	def selectOption(String optionType, String optionText) {
		switch(optionType.toLowerCase()) {
		
			case "maritalstatus":
				WebUI.waitForElementClickable(input_MaritalStatus, 10)
				WebUI.click(input_MaritalStatus)
				new helpersKeywords().selectDropdownOption(optionText)
				break
				case "street":
				WebUI.waitForElementClickable(input_Street, 10)
				WebUI.click(input_Street)
				WebUI.sendKeys(input_Street, Keys.chord(Keys.CONTROL, "a"))
				WebUI.sendKeys(input_Street, Keys.chord(Keys.DELETE))
				WebUI.setText(input_Street, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(input_Street, 'value'), optionText, false)
				break
				case "city":
				WebUI.waitForElementClickable(input_City, 10)
				WebUI.click(input_City)
				WebUI.sendKeys(input_City, Keys.chord(Keys.CONTROL, "a"))
				WebUI.sendKeys(input_City, Keys.chord(Keys.DELETE))
				WebUI.setText(input_City, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(input_City, 'value'), optionText, false)
				break
				case "number":
				WebUI.waitForElementClickable(input_NumberStreet, 10)
				WebUI.click(input_NumberStreet)
				WebUI.sendKeys(input_NumberStreet, Keys.chord(Keys.CONTROL, "a"))
				WebUI.sendKeys(input_NumberStreet, Keys.chord(Keys.DELETE))
				WebUI.setText(input_NumberStreet, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(input_NumberStreet, 'value'), optionText, false)
				break
				case "state":
				WebUI.waitForElementClickable(input_State, 10)
				WebUI.click(input_State)
				WebUI.sendKeys(input_State, Keys.chord(Keys.CONTROL, "a"))
				WebUI.sendKeys(input_State, Keys.chord(Keys.DELETE))
				WebUI.setText(input_State, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(input_State, 'value'), optionText, false)
				break
				case "phone":
				WebUI.waitForElementClickable(input_Mobile, 10)
				WebUI.click(input_Mobile)
				WebUI.sendKeys(input_Mobile, Keys.chord(Keys.CONTROL, "a"))
				WebUI.sendKeys(input_Mobile, Keys.chord(Keys.DELETE))
				WebUI.setText(input_Mobile, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(input_Mobile, 'value'), optionText, false)
				break
			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}

	def clickButton(String buttonType) {
		switch(buttonType.toLowerCase()) {
			case "save":
				WebUI.waitForElementClickable(saveBtn, 10)
				WebUI.click(saveBtn)
				KeywordUtil.logInfo("Save button clicked")
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

			default:
				KeywordUtil.markFailed("No suported: " + actionType)
				return
		}
	}
}


