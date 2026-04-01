package pages

import base.BasePage
import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class LeavePage extends BasePage {

	// ====== MENU ======
	TestObject leaveMenu       = findTestObject('Page_OrangeHRM/Admin/MyInfo/span_Leave')
	TestObject assignLeaveLink = findTestObject('Page_OrangeHRM/Admin/MyInfo/a_Assign Leave')
	TestObject leaveListMenu   = findTestObject('Page_OrangeHRM/Admin/MyInfo/li_Leave List')

	// ====== INPUTS ======
	TestObject employeeInput   = findTestObject('Page_OrangeHRM/Admin/MyInfo/input')
	TestObject leaveTypeInput  = findTestObject('Page_OrangeHRM/Admin/MyInfo/input_LeaveType')
	TestObject fromDateInput   = findTestObject('Page_OrangeHRM/Admin/MyInfo/input_From Date_oxd-input oxd-input--focus')
	TestObject toDateInput     = findTestObject('Page_OrangeHRM/Admin/MyInfo/input_To Date_oxd-input oxd-input--focus')

	// ====== BUTTONS ======
	TestObject assignButton    = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Assign')
	TestObject okButton        = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Ok')
	TestObject searchButton    = findTestObject('Page_OrangeHRM/Admin/MyInfo/button_Search')

	// ====== PERFORMANCE PAGE ======
	TestObject menuPerformance = findTestObject('Page_OrangeHRM/Admin/Page_Leave/a_Performance')
	TestObject dropdownArrow   = findTestObject('Page_OrangeHRM/Admin/Page_Leave/input_ShowLeaveWithStatus')
	TestObject resultRow       = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_2026-14-04Luiz Carlos AnjosCAN - Bereav_d323b8')
	TestObject employeeName    = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_Luiz Carlos Anjos')
	TestObject leaveAmount     = findTestObject('Page_OrangeHRM/Admin/Page_Leave/div_1.00')

	// ====== SIMPLE ACTIONS ======
	void openLeaveMenu() {
		click(leaveMenu)
	}
	void openAssignLeave() {
		click(assignLeaveLink)
	}
	void openLeaveList() {
		click(leaveListMenu)
	}

	void typeEmployee(String name) {
		type(employeeInput, name)
	}
	void openDropdown() {
		click(dropdownArrow)
	}
	void clickSearch() {
		click(searchButton)
	}

	void clickAssign() {
		click(assignButton)
	}
	void clickOk() {
		click(okButton)
	}

	void selectResultRow() {
		click(resultRow)
		click(employeeName)
		click(leaveAmount)
	}
}