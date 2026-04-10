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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys as Keys

//2.4  Admin → User Management → Users → search 'vramirez'.
// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(
	GlobalVariable.adminUsername,
	GlobalVariable.adminPassword
)

// ========== Object Repository References ==========
TestObject adminMenu          = findTestObject('Page_OrangeHRM/Admin/Common/Admin_Menu')
TestObject employeeNameInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName')
TestObject employeeIdInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeId')
TestObject usernameInput      = findTestObject('Page_OrangeHRM/Admin/Search/input_Username')
TestObject statusDropdown = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/dropdown_Status')
TestObject searchButton       = findTestObject('Page_OrangeHRM/Admin/Search/button_Search')
TestObject recordFoundText    = findTestObject('Page_OrangeHRM/Admin/Search/text_Record Found')
TestObject employeeEnabled    = findTestObject('Page_OrangeHRM/Admin/Search/text_employeeEnabled')
TestObject usernameDisplayed  = findTestObject('Page_OrangeHRM/Admin/Search/text_vramirezDisplayed')

// ============ Test Steps ===========

// 1. Go to Admin module
WebUI.waitForElementClickable(adminMenu, 10)
WebUI.click(adminMenu)

// 2. Search employee by username
CustomKeywords.'helpers.helpersKeywords.searchEmployeeByCriteria'(
	employeeNameInput,   // nameInput
	employeeIdInput,     // idInput
	statusDropdown,      // statusDropdown
	usernameInput,        // usernameInput
	searchButton,		// searchButton
	'',   // firstName
	'',                  // lastName
	'',                  // employeeId
	'',                  // status
	GlobalVariable.employeeUsername					 // username
	
)
// 3. Verify record found
CustomKeywords.'helpers.helpersKeywords.verifyRecords'()

// 4. Select user record
WebUI.waitForElementVisible(employeeEnabled, 10)
WebUI.verifyElementVisible(employeeEnabled)

// 5. Click on username in results
WebUI.waitForElementVisible(usernameDisplayed, 10)
WebUI.verifyElementVisible(usernameDisplayed)

// 6. Verify username is unique in results no duplicated
CustomKeywords.'helpers.helpersKeywords.verifyUniqueUsername'(usernameDisplayed, GlobalVariable.employeeUsername)
