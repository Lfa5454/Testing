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
import pages.Leave_AssignLeave


// ========== Object References ==========
Leave_AssignLeave leave_AssignLeave = new Leave_AssignLeave()

// ============ Test Steps ===========
leave_AssignLeave.performAction('leavemenu')

//leave_AssignLeave.performAction('searchleavelist')
leave_AssignLeave.SearchOption('employeename', [('firstName') : GlobalVariable.employeeName, ('lastName') : GlobalVariable.employeeLastName])

leave_AssignLeave.setDates(GlobalVariable.leave_FromDate, GlobalVariable.leave_ToDate)

leave_AssignLeave.SearchOption("showleavetaken", [:], "Taken")
//leave_AssignLeave.SearchOption("showleavescheduled")
leave_AssignLeave.clickButton('search')

////// Validation
leave_AssignLeave.EmployeeResult(GlobalVariable.employeeName, GlobalVariable.employeeLastName, '2')
