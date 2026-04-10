import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import pages.PIM_SearchEmployeeAndEdit
//2.4  Admin → User Management → Users → search 'vramirez'.

// ========== Pre-Condition ==========
// CustomKeywords.'login.LoginKeywords.loginToOrangeHRM'(GlobalVariable.adminUsername,	GlobalVariable.adminPassword)
// ========== Object References ==========
PIM_SearchEmployeeAndEdit searchEmployeeAndEdit = new PIM_SearchEmployeeAndEdit()

// ============ Test Steps ===========

// 1. Go to PIM module
searchEmployeeAndEdit.openMenu("admin")

// 2. Search employee
searchEmployeeAndEdit.searchEmployee('', '', '', '', GlobalVariable.employeeUsername)

CustomKeywords.'helpers.helpersKeywords.verifyRecords'()


// 3 Validate employee
boolean recordsExist = CustomKeywords.'helpers.helpersKeywords.verifyRecords'()
if (recordsExist==true) {searchEmployeeAndEdit.validateInputValue(GlobalVariable.employeeUsername)

}
if (!recordsExist) {
	KeywordUtil.markFailedAndStop("No records found, step stoped.")
}
// 4. Verify username is unique in results no duplicated
searchEmployeeAndEdit.verifyUniqueUsername()
