import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import pages.PIM_SearchEmployeeAndEdit
//2.4  Admin → User Management → Users → search 'vramirez'.
// ========== Pre-Condition ==========

// ========== Object References ==========
PIM_SearchEmployeeAndEdit searchEmployeeAndEdit = new PIM_SearchEmployeeAndEdit()
// ============ Test Steps ===========

// 1. Go to PIM module
searchEmployeeAndEdit.openMenu("pim")

// 2. Search employee
searchEmployeeAndEdit.searchEmployee(GlobalVariable.employeeName, GlobalVariable.employeeLastName, '', '', '')
//3 Validate employee

boolean recordsExist = CustomKeywords.'helpers.helpersKeywords.verifyRecords'()
if (recordsExist==true) {searchEmployeeAndEdit.validateInputValue(GlobalVariable.employeeName)
if (!recordsExist) {
	KeywordUtil.markFailed("No records found, step stoped.")
}
}

