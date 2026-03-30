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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType


import org.openqa.selenium.Keys as Keys
// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(
	GlobalVariable.adminUsername,
	GlobalVariable.adminPass
)

// ========== Object Repository References ==========
TestObject menuPIM = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')
TestObject employeeNameInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeName')
TestObject employeeIdInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/input_EmployeeId')
TestObject statusDropdown = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/dropdown_EmployeeStatus')
TestObject searchButton = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/button_Search')
TestObject employeeNameOnList = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/textonList_EmployeeName')
TestObject employeeLastNameOnList = findTestObject('Object Repository/Page_OrangeHRM/PIM/Search/textonList_EmployeeLastName')

// ============ Test Steps ===========
WebUI.click(menuPIM)

// Search Employee
CustomKeywords.'helpers.helpersKeywords.searchEmployeeByCriteria'(
    employeeNameInput,   // nameInput
    employeeIdInput,     // idInput
    statusDropdown,      // statusDropdown
    searchButton,        // searchButton
    '',                  // firstName
    '',                  // lastName
    GlobalVariable.employeeID,    // employeeId
    ''                   // status
)

// =========== Validation ============
CustomKeywords.'helpers.helpersKeywords.verifyRecords'()

// Verify the Employee Name and Last Name appear in the list
CustomKeywords.'helpers.helpersKeywords.validateEmployeeId'(GlobalVariable.employeeID)



// ============ End Test =============
WebUI.closeBrowser()