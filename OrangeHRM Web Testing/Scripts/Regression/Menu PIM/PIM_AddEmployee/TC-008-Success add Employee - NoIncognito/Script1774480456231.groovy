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
import java.util.Random as Random
import org.openqa.selenium.Keys as Keys

// ========== Pre-Condition ==========
CustomKeywords.'login.LoginKeywords.loginToOrangeHRM'(GlobalVariable.adminUsername, GlobalVariable.adminPass)

// ========== Object Repository References ==========
TestObject menuPIM = findTestObject('Page_OrangeHRM/PIM/Common/menu_PIM')

TestObject addEmployeeBtn = findTestObject('Page_OrangeHRM/PIM/Add/button_AddEmployee')

TestObject firstNameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_FirstName')

TestObject lastNameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_LastName')

TestObject employeeIdInput = findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/input_EmployeeId_active')

TestObject createLoginDetailsCheckbox = findTestObject('Page_OrangeHRM/PIM/Add/CreateLoginDetailsCheckbox')

TestObject usernameInput = findTestObject('Page_OrangeHRM/PIM/Add/input_Username')

TestObject enabledToggle = findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/span_Enabled')

TestObject passwordInput = findTestObject('Page_OrangeHRM/PIM/Add/input_Password')

TestObject confirmPasswordInput = findTestObject('Page_OrangeHRM/PIM/Add/input_PasswordConfirm')

TestObject usernameAlreadyExistInput = findTestObject('Page_OrangeHRM/PIM/Add/input_UsernameAlreadyExist')

TestObject saveButton = findTestObject('Page_OrangeHRM/PIM/Add/button_Save')

TestObject personalDetailsHeader = findTestObject('Page_OrangeHRM/PIM/Add/text_PersonalsDetails')

// ============ Test Steps ===========
WebUI.click(menuPIM)

WebUI.click(addEmployeeBtn)

// Input Employee Data
WebUI.setText(firstNameInput, GlobalVariable.employeeName)

WebUI.setText(lastNameInput, GlobalVariable.employeeLastName)

// Generate and set Employee ID
String newId = CustomKeywords.'helpers.helpersKeywords.clearAndSetEmployeeId'(employeeIdInput)

GlobalVariable.employeeID = newId

// Enable login details
WebUI.click(createLoginDetailsCheckbox)

WebUI.waitForElementClickable(usernameInput, 1)

WebUI.setText(usernameInput, GlobalVariable.username)

WebUI.click(enabledToggle)

WebUI.setEncryptedText(passwordInput, GlobalVariable.pass)

WebUI.setEncryptedText(confirmPasswordInput, GlobalVariable.pass)

// Log that the user already exists
CustomKeywords.'helpers.helpersKeywords.checkIfUserExists'(usernameAlreadyExistInput)

// Save button
WebUI.click(saveButton)
String actualText = WebUI.getText(findTestObject('Object Repository/Page_OrangeHRM/PIM/Add/popupNotification_SuccessfullySaved'))
println("Texto encontrado: [" + actualText + "]")

// =========== Validation ============
// 1: employee saved
CustomKeywords.'helpers.helperNotifications.verifyNotification'("save")

// Assert : Redirect to Personal Details page
WebUI.waitForElementVisible(personalDetailsHeader, 5)

CustomKeywords.'helpers.helpersKeywords.verifyTextDisplayed'(personalDetailsHeader, 'Personal Details')

