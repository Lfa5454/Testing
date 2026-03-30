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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(
    GlobalVariable.adminUsername,
    GlobalVariable.adminPass
)

// ========== Object Repository References ==========
TestObject menuPIM            = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')
TestObject employeeNameInput  = findTestObject('Page_OrangeHRM/PIM/Search/input_EmployeeName')
TestObject employeeIdInput    = findTestObject('Page_OrangeHRM/PIM/Search/input_EmployeeId')
TestObject statusDropdown     = findTestObject('Page_OrangeHRM/PIM/Search/dropdown_Status')
TestObject searchButton       = findTestObject('Page_OrangeHRM/PIM/Search/button_Search')
TestObject salaryTab          = findTestObject('Page_OrangeHRM/PIM/Edit/salary_Tab')
TestObject addButton          = findTestObject('Page_OrangeHRM/PIM/Edit/button_Add')
TestObject salaryComponent    = findTestObject('Page_OrangeHRM/PIM/Edit/input_SalaryComponent')
TestObject payGradeDropdown   = findTestObject('Page_OrangeHRM/PIM/Edit/txt_PayGrade')
TestObject payGradeSelected   = findTestObject('Page_OrangeHRM/PIM/Edit/payGrade_SelectedText')
TestObject payFrequencyDropdown = findTestObject('Page_OrangeHRM/PIM/Edit/txt_PayFrequency')
TestObject currencyDropdown   = findTestObject('Page_OrangeHRM/PIM/Edit/txt_Currency')
TestObject currencySelected   = findTestObject('Page_OrangeHRM/PIM/Edit/currency_SelectedText')
TestObject amountInput        = findTestObject('Page_OrangeHRM/PIM/Edit/input_Amount')
TestObject saveButton         = findTestObject('Page_OrangeHRM/PIM/Edit/button_Save')
TestObject notificationSaved = findTestObject('Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved')

// ============ Test Steps ===========

// 1. Go to PIM module
WebUI.waitForElementClickable(menuPIM, 10)
WebUI.click(menuPIM)

// 2. Search employee
CustomKeywords.'helpers.helpersKeywords.searchEmployeeByCriteria'(
    employeeNameInput,
    employeeIdInput,
    statusDropdown,
    searchButton,
    GlobalVariable.employeeName,
    GlobalVariable.employeeLastName,
    '',   // optional employeeId
    ''    // optional status
)

TestObject empObj = CustomKeywords.'helpers.helpersKeywords.validateEmployeeId'(GlobalVariable.employeeName)
WebUI.waitForElementClickable(empObj, 10)
WebUI.click(empObj)

// 3. Open Salary tab
WebUI.waitForElementClickable(salaryTab, 10)
WebUI.click(salaryTab)

// 4. Add new salary record
WebUI.waitForElementClickable(addButton, 10)
WebUI.click(addButton)

// 5. Fill salary component
WebUI.setText(salaryComponent, '1')

// 6. Select Pay Grade
WebUI.waitForElementClickable(payGradeDropdown, 10)
WebUI.click(payGradeDropdown)
CustomKeywords.'helpers.helpersKeywords.selectDropdownOption'("Grade 2")
// 7. Select Pay Frequency´
WebUI.waitForElementClickable(payFrequencyDropdown, 10)
WebUI.click(payFrequencyDropdown)
CustomKeywords.'helpers.helpersKeywords.selectDropdownOption'("Bi Weekly")

// 8. Select Currency
WebUI.waitForElementClickable(currencyDropdown, 10)
WebUI.click(currencyDropdown)
CustomKeywords.'helpers.helpersKeywords.selectDropdownOption'("United States Dollar")

// 9. Enter salary amount
WebUI.setText(amountInput, '44000')

// 10. Save salary record
WebUI.waitForElementClickable(saveButton, 10)
WebUI.click(saveButton)

// 11. Verify save notification
// ============ Validation ===========
WebUI.waitForElementVisible(notificationSaved, 10)
CustomKeywords.'helpers.helperNotifications.verifyNotification'("save")

