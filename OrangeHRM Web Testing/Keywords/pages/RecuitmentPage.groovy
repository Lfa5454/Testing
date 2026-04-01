package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS



import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import com.kms.katalon.core.util.KeywordUtil
import helpers.helpersKeywords
class RecruitmentPage {
	// ===========================
	// 🔹 Locators
	// ===========================

	// ===========================
	// 🔹 Navigation
	// ===========================
	TestObject menu_recruitment   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/Menu_Recruitment')
	TestObject menu_pim           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_PIM')
	TestObject menu_admin         = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_Admin')
	TestObject navigate_candidates = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/li_Candidates')

	// ===========================
	// 🔹 Vacancy Management
	// ===========================
	TestObject list_vacancy       = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/list_vacancy')
	TestObject button_add_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add_1')
	TestObject input_vacancy_name = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_VacancyName')
	TestObject dropdown_job_title = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Job Title-- Select --_1')
	TestObject input_hiring_manager = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input')
	TestObject input_positions    = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Number of Positions_oxd-input oxd-inp_b37faf')
	TestObject checkbox_active    = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_checkbox')
	TestObject vacancy_active_label = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Active')
	TestObject vacancy_exists_message = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Vacancy NameAlready exists')
	TestObject button_save_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save')

	// ===========================
	// 🔹 Candidate Management
	// ===========================
	TestObject button_add_candidate = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add')
	TestObject input_candidate_firstName = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Full Name_firstName')
	TestObject input_candidate_lastName  = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Full Name_lastName')
	TestObject dropdown_candidate_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Vacancy-- Select --_1')
	TestObject input_candidate_email     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Email_oxd-input oxd-input--focus')
	TestObject input_candidate_contact   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Contact Number_oxd-input oxd-input--focus')

	// ===========================
	// 🔹 Interview Management
	// ===========================
	TestObject button_scheduleInterview = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Schedule Interview')
	TestObject input_interviewTitle     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Interview Title_oxd-input oxd-input--focus')
	TestObject input_interviewer        = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_1_2')
	TestObject input_date               = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Date_oxd-input oxd-input--active')
	TestObject input_time               = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Time_oxd-input oxd-input--active')
	TestObject textarea_notes           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/textarea_Notes_oxd-textarea oxd-textarea--f_0ce0e8')
	TestObject textarea_notes2          = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/textarea_Notes_oxd-textarea oxd-textarea--f_0ce0e8_1')

	// ===========================
	// 🔹 Workflow Buttons
	// ===========================
	TestObject button_shortlist         = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Shortlist')
	TestObject button_markInterviewPassed = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Mark Interview Passed')
	TestObject button_offerJob          = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Offer Job')
	TestObject button_hire              = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Hire')

	// ===========================
	// 🔹 Status Labels
	// ===========================
	TestObject status_applicationInitiated = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Application Initiated')
	TestObject status_interviewScheduled   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Interview Scheduled')
	TestObject status_interviewPassed      = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Status Interview Passed')
	TestObject status_jobOffered           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Job Offered')
	TestObject status_hired                = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Hired')

	// ===========================
	// 🔹 Common Buttons & Messages
	// ===========================
	TestObject button_save        = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save')
	TestObject button_search      = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Search')
	TestObject success_saved      = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_SuccessSuccessfully Saved')

	// ===========================
	// 🔹 Candidate Records
	// ===========================
	TestObject candidate_row      = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Daniel LopezQA Engineer')
	TestObject candidate_name     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/h6_Daniel Lopez')

	// ===========================
	// 🔹 Methods by requirement steps
	// ===========================

	// Methods
	void goToRecruitment() {
		WebUI.click(menu_recruitment)
		String currentUrl = WebUI.getUrl()
		if (currentUrl.contains("/recruitment/viewCandidates")) {
			println("✅ Browser opened Recruitment Candidates page successfully.")
		} else {
			println("⚠ Navigation failed. Current URL: " + currentUrl)
		}
	}

	void createVacancy(String name) {
		WebUI.click(list_vacancy)
		WebUI.click(button_add_vacancy)
		WebUI.click(input_vacancy_name)
		WebUI.setText(input_vacancy_name, name)
		//WebUI.click(button_save)

		if (WebUI.verifyElementPresent(vacancy_exists_message, 3, FailureHandling.OPTIONAL)) {
			println("⚠ Vacancy already exists: " + name)
		} else {
			println("✅ Vacancy created successfully: " + name)
		}
	}

	def selectOption(String optionType, String optionText) {
		switch(optionType.toLowerCase()) {
			case "jobtitle_input":
				WebUI.waitForElementClickable(dropdown_job_title, 10)
				WebUI.click(dropdown_job_title)
			// Call your custom keyword to select the option
				new helpersKeywords().selectDropdownOption(optionText)
				break

			case "hiringmanager_input":
				new helpersKeywords().setInputByXpath(input_hiring_manager, optionText)
				//WebUI.waitForElementClickable("", 10)
				
				break

			case "paygrade":
				WebUI.waitForElementClickable(payGradeDropdown, 10)
				WebUI.click(payGradeDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "payfrequency":
				WebUI.waitForElementClickable(payFrequencyDropdown, 10)
				WebUI.click(payFrequencyDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "currency":
				WebUI.waitForElementClickable(currencyDropdown, 10)
				WebUI.click(currencyDropdown)
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "amount":
				WebUI.waitForElementClickable(amountInput, 10)
				WebUI.setText(amountInput, optionText)
				WebUI.verifyMatch(WebUI.getAttribute(amountInput, 'value'), optionText, false)
				break
			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}
}

