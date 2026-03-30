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
CustomKeywords.'login.LoginKeywords.loginToOrangeHRM'(GlobalVariable.adminUsername, GlobalVariable.adminPass)

// ============ Test Steps ===========
// Click the profile button on the top right
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Logout/button_UserDropdown'))

// Click menu "Logout"
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Logout/menuItem_Logout'))

// =========== Validation ============
// Validation 1 : Verify redirect to the Login page
CustomKeywords.'login.LoginValidationsKeywords.verifyLoginPage'()

// Validation 2 : Verify the text “Login” is visible
CustomKeywords.'login.LoginValidationsKeywords.verifyRequiredMessage'(findTestObject('Object Repository/Page_OrangeHRM/Logout/header_Login'), 
    'Login')

// Validation 3 : Verify the text “Login” is visible diferent method
TestObject textMessageObject = findTestObject('Object Repository/Page_OrangeHRM/Logout/header_Login')

WebUI.verifyElementText(textMessageObject, 'Login')

