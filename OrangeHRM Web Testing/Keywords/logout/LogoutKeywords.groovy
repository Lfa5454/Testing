package logout

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import login.LoginKeywords

public class LogoutKeywords {
	// ======================================================
	// Dependencies
	// ======================================================

	def login = new LoginKeywords()
	// ======================================================
	// Objects
	// ======================================================

	TestObject userDropdown = findTestObject('Object Repository/Page_OrangeHRM/Logout/button_UserDropdown')
	TestObject logoutMenu   = findTestObject('Object Repository/Page_OrangeHRM/Logout/menuItem_Logout')
	TestObject loginHeader  = findTestObject('Object Repository/Page_OrangeHRM/Logout/header_Login')
	TestObject inputUserName  = findTestObject('Object Repository/Page_OrangeHRM/Logout/header_Login')
	
	// ====== Methods ======

	// ======================
	// 🔹 LOGOUT KEYWORD
	// ======================
	/**
	 * Performs logout and guarantees user is redirected to Login page.
	 */
	@Keyword
	def logout() {

		KeywordUtil.logInfo("Logging out current user")

		// ✅ Open user menu
		WebUI.waitForElementClickable(userDropdown, 10)
		WebUI.click(userDropdown)

		// ✅ Click Logout
		WebUI.waitForElementClickable(logoutMenu, 10)
		WebUI.click(logoutMenu)

		// ✅ Wait until login page is visible (functional logout)
		WebUI.waitForElementVisible(inputUserName, 10)

		// ✅ CRITICAL: Reset SPA state (OrangeHRM fix)
		WebUI.executeJavaScript(
				'''
        window.localStorage.clear();
        window.sessionStorage.clear();
        document.cookie.split(";").forEach(function(c) {
            document.cookie = c.replace(/^ +/, "")
                               .replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/");
        });
        ''',
				null
				)

		KeywordUtil.logInfo("✅ Logout successful and SPA session reset")
	}
	
    // ======================
    // 🔹 SWITCH USER (SAME BROWSER)
    // ======================
    @Keyword
    def switchUser(String username, String password) {

        // ✅ Call internal logout directly
        logout()
		// ✅ Cerrar browser (CRÍTICO)
		WebUI.closeBrowser()
		
        // ✅ Reset listener control
        GlobalVariable.loginDone = false

        // ✅ Login with another user
		login.login(username,	password)
		
        // ✅ Re-assign control
        GlobalVariable.loginDone = true
    }
	
}