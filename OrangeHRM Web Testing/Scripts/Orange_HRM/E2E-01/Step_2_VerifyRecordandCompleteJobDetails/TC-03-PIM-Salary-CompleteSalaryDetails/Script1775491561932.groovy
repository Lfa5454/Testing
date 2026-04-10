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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import pages.PIM_SearchEmployeeAndEdit

//2.3  Salary tab: set Pay Grade, Pay Frequency, Currency, Amount; Save.

// ========== Object References ==========
PIM_SearchEmployeeAndEdit searchEmployeeAndEdit = new PIM_SearchEmployeeAndEdit()


// ============ Test Steps ===========

// 4. Open Salary Tab
searchEmployeeAndEdit.openMenu("salary")

// 5. Add new salary record
searchEmployeeAndEdit.clickButton("addsalary")

// 6. Fill salary component

searchEmployeeAndEdit.selectOption("salarytab","1")

// 7. Select Pay Grade
searchEmployeeAndEdit.selectOption("paygrade",GlobalVariable.payGrade)
// 8. Select Pay Frequency´
searchEmployeeAndEdit.selectOption("payfrequency",GlobalVariable.payFrequency)

// 9. Select Currency
searchEmployeeAndEdit.selectOption("currency",GlobalVariable.currency)

// 10. Enter salary amount
searchEmployeeAndEdit.selectOption("amount",GlobalVariable.salaryAmount)

// 11. Save salary record
searchEmployeeAndEdit.clickButton("save")

// 12. Verify save notification
// ============ Validation ===========

searchEmployeeAndEdit.verifyNotification("save")