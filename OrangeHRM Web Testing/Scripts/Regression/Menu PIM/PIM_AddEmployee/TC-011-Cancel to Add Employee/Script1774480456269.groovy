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
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(GlobalVariable.adminUsername, GlobalVariable.adminPassword)

// ========== Object Repository References ==========
TestObject menuPIM = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')

TestObject addEmployeeBtn = findTestObject('Page_OrangeHRM/PIM/Add/button_AddEmployee')

TestObject cancelButton = findTestObject('Page_OrangeHRM/PIM/Add/button_Cancel')

// ============ Test Steps ===========
WebUI.click(menuPIM)

WebUI.click(addEmployeeBtn)

WebUI.click(cancelButton)

// =========== Validation ============
// Validation 1 : Verify redirect back to the PIM page
WebUI.verifyMatch(WebUI.getUrl(), 'https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList', false)

