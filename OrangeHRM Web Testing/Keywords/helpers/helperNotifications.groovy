package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class helperNotifications {

	// ============================
	// 🔹 VERIFY GENERIC NOTIFICATION
	// ============================
	@Keyword

	def verifyNotification(String actionType) {
		TestObject notificationObj
		String expectedMessage

		switch(actionType.toLowerCase()) {
			case "update":
				notificationObj = findTestObject('Object Repository/Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
				expectedMessage = "Successfully Updated"
				break

			case "save":
				notificationObj = findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')
				expectedMessage = "Successfully Saved"
				break

			default:
				KeywordUtil.markFailed("No suported: " + actionType)
				return
		}

		WebUI.waitForElementVisible(notificationObj, 10)

		// 🔹 get and print the real text
		String actualText = WebUI.getText(notificationObj)
		println("Texto encontrado en notificación: [" + actualText + "]")

		// flexible Validation
		WebUI.verifyMatch(actualText.trim(), expectedMessage, true)
	}
	// ============================
	// 🔹 VERIFY UPDATE NOTIFICATION
	// ============================
	@Keyword
	def verifyUpdateNotification() {
		WebUI.verifyElementText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated'),
				'Successfully Updated')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated'), 2)
	}

	// ============================
	// 🔹 VERIFY SAVE NOTIFICATION
	// ============================
	@Keyword
	def verifySaveNotification() {
		WebUI.verifyElementText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved'),
				'Successfully Saved')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved'), 2)
	}
}
