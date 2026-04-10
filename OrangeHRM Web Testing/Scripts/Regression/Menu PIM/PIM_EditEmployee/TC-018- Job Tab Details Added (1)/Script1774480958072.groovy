import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRMIncognito'(
	GlobalVariable.adminUsername,
	GlobalVariable.adminPassword
)

// ========== Object Repository References ==========
TestObject menuPIM            = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')
TestObject employeeNameInput  = findTestObject('Page_OrangeHRM/PIM/Search/input_EmployeeName')
TestObject employeeIdInput    = findTestObject('Page_OrangeHRM/PIM/Search/input_EmployeeId')
TestObject statusDropdown     = findTestObject('Page_OrangeHRM/PIM/Search/dropdown_Status')
TestObject usernameInput      = findTestObject('Page_OrangeHRM/Admin/Search/input_Username')
TestObject searchButton       = findTestObject('Page_OrangeHRM/PIM/Search/button_Search')
TestObject jobTab             = findTestObject('Page_OrangeHRM/PIM/Edit/job_Tab')
TestObject joinedDateInput    = findTestObject('Page_OrangeHRM/PIM/Edit/input_JoinedDate')
TestObject jobTitleInput      = findTestObject('Page_OrangeHRM/PIM/Edit/txt_JobTitle')
TestObject saveButton         = findTestObject('Page_OrangeHRM/PIM/Edit/button_Save')
TestObject notificationUpdate = findTestObject('Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')

// ============ Test Steps ===========
// Search Employee
CustomKeywords.'helpers.helpersKeywords.searchEmployeeByCriteria'(
    employeeNameInput,   // nameInput
    employeeIdInput,     // idInput
    statusDropdown,      // statusDropdown
	usernameInput,        // usernameInput
	searchButton,		// searchButton
    GlobalVariable.employeeFirstName,   // firstName
    '',                  // lastName
    '',                  // employeeId
    '',                  // status
	'' 					 // username
	
)

// 1. Go to PIM module
WebUI.waitForElementClickable(menuPIM, 10)
WebUI.click(menuPIM)

// 2. Search employee
CustomKeywords.'helpers.helpersKeywords.searchEmployeeByCriteria'(
	employeeNameInput,
	employeeIdInput,
	statusDropdown,
	searchButton,
	GlobalVariable.employeeFirstName,
	GlobalVariable.employeeLastName,
	'',   // optional employeeId
	''    // optional status
)

TestObject empObj = CustomKeywords.'helpers.helpersKeywords.validateEmployeeId'(GlobalVariable.employeeFirstName)
WebUI.waitForElementClickable(empObj, 10)
WebUI.click(empObj)

// 3. Open Job Tab
WebUI.waitForElementClickable(jobTab, 10)
WebUI.click(jobTab)

// 4. Set Joined Date
WebUI.waitForElementClickable(joinedDateInput, 10)
WebUI.clearText(joinedDateInput)
WebUI.setText(joinedDateInput, GlobalVariable.joinDate)
WebUI.verifyMatch(WebUI.getAttribute(joinedDateInput, 'value'), GlobalVariable.joinDate, false)

// 5. Select Job Title
WebUI.waitForElementClickable(jobTitleInput, 10)
WebUI.click(jobTitleInput)
CustomKeywords.'helpers.helpersKeywords.selectDropdownOption'("QA Engineer")

// 6. Save changes
WebUI.waitForElementClickable(saveButton, 10)
WebUI.click(saveButton)

// ============ Validation ===========
WebUI.waitForElementVisible(notificationUpdate, 10)
CustomKeywords.'helpers.helperNotifications.verifyNotification'("update")