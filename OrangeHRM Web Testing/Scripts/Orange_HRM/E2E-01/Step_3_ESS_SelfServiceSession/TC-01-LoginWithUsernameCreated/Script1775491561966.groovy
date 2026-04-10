
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
//import logout.LogoutKeywords

// ======================================================
// Dependencies
// ======================================================

//def logout = new LogoutKeywords()

// ==============================
// 🔹 Switch user for this test
// ==============================

// Step 1: Logout admin and login with user created

CustomKeywords.'logout.LogoutKeywords.switchUser'(GlobalVariable.employeeUsername, GlobalVariable.employeePassword)


// ==============================
// ✅ Validations
// ==============================

// ✅ Validation should be role-agnostic or employee-specific
WebUI.verifyElementVisible(
	findTestObject('Object Repository/Page_OrangeHRM/Login/header_Dashboard')
)
