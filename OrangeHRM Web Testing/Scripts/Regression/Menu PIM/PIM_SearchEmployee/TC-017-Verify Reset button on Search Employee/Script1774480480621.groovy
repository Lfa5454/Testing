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

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(
    GlobalVariable.adminUsername, 
    GlobalVariable.adminPassword
)

// ============ Test Steps ===========
// Click the PIM button on the left sidebar menu
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Common/menu_PIM'))

// Input valid Employee Name
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName'), 'Harry Potter')

// Click button "Reset"
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/button_Reset'))

// =========== Validation ============
// Validation 1 : Verify the “Employee Name” field is cleared
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName'), 'value', '', 0)
