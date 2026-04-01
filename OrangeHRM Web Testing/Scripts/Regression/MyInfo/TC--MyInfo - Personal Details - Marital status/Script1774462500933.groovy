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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(GlobalVariable.adminUsername, GlobalVariable.adminPass)

WebUI.click(findTestObject('Page_OrangeHRM/Admin/MyInfo/span_Leave'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/span_More_1'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/a_Assign Leave'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input'), 'A')

// TestObject dinámico para la primera opción del autocomplete
TestObject firstOption = new TestObject('firstOption')

firstOption.addProperty('xpath', ConditionType.EQUALS, '(//div[@class=\'oxd-autocomplete-text-input--after\'])[1]')

// Esperar que aparezca y hacer click
WebUI.waitForElementVisible(firstOption, 10)

WebUI.click(firstOption)

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_NameDropdown'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_From Date_oxd-input oxd-input--focus'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_25'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_To Date_oxd-input oxd-input--focus'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_26'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_-- Select --'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/button_Assign'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/button_Assign'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_Confirm Leave AssignmentEmployee does n_e5d0d7'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/button_Ok'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_SuccessSuccessfully Saved'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/li_More'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/li_Leave List'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2_3'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2_3'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/button_Search'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/div_2026-25-03 to 2026-26-03A8DCo 4Ys 010ZC_e7d9cd'))

