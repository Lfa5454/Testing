package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class HelpersStorageKEywords {
	@Keyword
	def validateLocalStoragePersistence(String key, String value) {
		// Step 1: Save value in localStorage
		WebUI.executeJavaScript("localStorage.setItem('${key}','${value}')", null)

		// Step 2: Refresh the page
		WebUI.refresh()

		// Step 3: Retrieve value
		String storedValue = WebUI.executeJavaScript("return localStorage.getItem('${key}')", null)

		// Step 4: Validate
		WebUI.verifyMatch(storedValue, value, false)
		KeywordUtil.logInfo("LocalStorage persistence validated successfully")
	}

	@Keyword
	def validateSessionStoragePersistence(String key, String value) {
		WebUI.executeJavaScript("sessionStorage.setItem('${key}','${value}')", null)
		WebUI.refresh()
		String storedValue = WebUI.executeJavaScript("return sessionStorage.getItem('${key}')", null)
		WebUI.verifyMatch(storedValue, value, false)
		KeywordUtil.logInfo("SessionStorage persistence validated successfully")
	}
}

