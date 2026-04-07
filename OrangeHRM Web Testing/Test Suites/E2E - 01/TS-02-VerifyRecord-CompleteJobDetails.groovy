import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = true)
def setUp() {
    println "Starting Test Suite..."
    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com')
    // Restore cookies if you want continuity
    CustomKeywords.'browserConfig.CookieManager.loadCookiesFromFile'('Data/cookies.txt')
    WebUI.refresh()
}


/**
 * Clean test suites environment.
 */
@TearDown(skipped = true)
def tearDown() {
    println "Finishing Test Suite..."
    // Save cookies at the end of the suite
    CustomKeywords.'browserConfig.CookieManager.saveCookiesToFile'('Data/cookies.txt')
    WebUI.closeBrowser()
}


/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = true) // Please change skipped to be false to activate this method.

def setupTestCase() {
WebUI.callTestCase(findTestCase('Test Cases/Orange_HRM/E2E-01/Step_2_VerifyRecordandCompleteJobDetails/TC-01-PIM-VerifyRecordAdded'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Orange_HRM/E2E-01/Step_2_VerifyRecordandCompleteJobDetails/TC-02-PIM-JobTab-CompleteJobDetails'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Orange_HRM/E2E-01/Step_2_VerifyRecordandCompleteJobDetails/TC-02-PIM-JobTab-CompleteJobDetails'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Orange_HRM/E2E-01/Step_2_VerifyRecordandCompleteJobDetails/TC-04-Admin-Search_vramirez_UserName'), [:], FailureHandling.STOP_ON_FAILURE)
}



/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = true) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	// Put your code here.
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */