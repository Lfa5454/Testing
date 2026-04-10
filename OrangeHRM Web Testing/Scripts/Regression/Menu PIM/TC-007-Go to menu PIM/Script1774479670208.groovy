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

CustomKeywords.'login.LoginKeywords.loginToOrangeHRM'(GlobalVariable.adminUsername, GlobalVariable.adminPassword)

// ============ Test Steps ===========
// Click the PIM button on the left sidebar menu
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/PIM/Common/menu_PIM'))

// =========== Validation ============
// Validation 1 : Verify redirect to the PIM page
WebUI.verifyMatch(WebUI.getUrl(), 'https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList', false)

// Validation 2 :Verify the page header text is “PIM”
WebUI.verifyElementText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Common/header_PIM'), 'PIM')

// ============ End Test =============
WebUI.closeBrowser()