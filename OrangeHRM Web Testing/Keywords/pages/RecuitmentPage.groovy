package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testobject.ObjectRepository as OR
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
	TestObject add_notes           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_AddNotes')
	TestObject button_eye     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_BiEye')

	// ===========================
	// 🔹 Navigation
	// ===========================
	TestObject menu_recruitment   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/Menu_Recruitment')
	TestObject menu_pim           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_PIM')
	TestObject menu_admin         = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_Admin')
	TestObject navigate_candidates = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/li_Candidates')
	TestObject selectEmployee     = findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_NameDropdown')


	// ===========================
	// 🔹 Vacancy Management
	// ===========================
	TestObject list_vacancy       = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/list_vacancy')
	TestObject button_add_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add_1')
	TestObject input_vacancy_name = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_VacancyName')
	TestObject dropdown_job_title = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/dropDown_JobTitle')
	TestObject input_hiring_manager = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input')
	TestObject input_positions    = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_NumberOfPositions')
	TestObject checkbox_active    = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_checkbox')
	TestObject vacancy_active_label = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Active')
	TestObject vacancy_exists_message = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_VacancyNameAlreadyExists')
	TestObject button_save_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save')

	// ===========================
	// 🔹 Candidate Management
	// ===========================
	TestObject button_add_candidate = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add')
	TestObject input_candidate_firstName = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Candidate_firstName')
	TestObject input_candidate_lastName  = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Candidate_lastName')
	TestObject dropdown_candidate_vacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/dropDown_Vacancy')
	TestObject input_candidate_email     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Email')
	TestObject input_candidate_contact   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_ContactNumber')
	TestObject upload_Resume_button   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_TypeFile')
	TestObject resume_pdf_downloable   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_PDFResume')
	TestObject resume_icon_downloable   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Download')

	// ===========================
	// 🔹 Interview Management
	// ===========================
	TestObject button_scheduleInterview = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Schedule Interview')
	TestObject input_interviewTitle     = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_InterviewTitle')
	TestObject input_interviewer        = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Interviewer')
	TestObject input_date               = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Date_oxd-input oxd-input--active')
	TestObject input_time               = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Time_oxd-input oxd-input--active')

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
	TestObject status_applicationInitiated = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_StatusApplicationInitiated')
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
	// Success validations
	TestObject notificationUpdate = findTestObject('Object Repository/Page_OrangeHRM/PIM/Edit/popupNotification_SuccessfullyUpdated')
	TestObject notificationSaved = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/popupNotification_SuccessfullySaved')
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


		if (WebUI.verifyElementPresent(vacancy_exists_message, 3, FailureHandling.OPTIONAL)) {
			KeywordUtil.markFailedAndStop("⚠ Vacancy already exists: " + name)
		} else {
			println("✅ Vacancy created successfully: " + name)
		}
	}
	void candidateManagement(String fristName, String lastName) {
		WebUI.click(navigate_candidates)
		WebUI.click(button_add_candidate)
		WebUI.click(input_candidate_firstName)
		WebUI.setText(input_candidate_firstName, fristName)
		WebUI.click(input_candidate_lastName)
		WebUI.setText(input_candidate_lastName, lastName)
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
				new helpersKeywords().selectEmployee(input_hiring_manager, selectEmployee, optionText)
				break

			case "position_input":
				new helpersKeywords().setInputByXpath(input_positions, optionText)

				break
			case "active_checkbox":
				boolean status = new helpersKeywords().verifyActiveCheckbox(checkbox_active)

				if (status) {
					WebUI.comment("Checkbox is active, continue workflow")
				} else {
					WebUI.comment("Checkbox is inactive, activating it now...")
					WebUI.click(checkbox_active)   // this active the checkbox if it is inactive
					WebUI.verifyElementChecked(checkbox_active, 5)
					WebUI.comment("Checkbox has been activated")
				}
				break
			case "vacancy_input":
				WebUI.waitForElementClickable(dropdown_candidate_vacancy, 10)
				WebUI.click(dropdown_candidate_vacancy)
			// Call your custom keyword to select the option
				new helpersKeywords().selectDropdownOption(optionText)
				break
			case "candidate_email_input":
				WebUI.waitForElementClickable(input_candidate_email, 10)
				WebUI.click(input_candidate_email)
				WebUI.setText(input_candidate_email, optionText)
				break
			case "candidate_contactnumber":
				WebUI.waitForElementClickable(input_candidate_contact, 10)
				WebUI.click(input_candidate_contact)
				WebUI.setText(input_candidate_contact, optionText)
				break

			case "add_notes":
			WebUI.delay(2)
				WebUI.waitForElementClickable(add_notes, 10)
				WebUI.click(add_notes)
				WebUI.setText(add_notes, optionText)
				break
			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}


	def clickOnSaveButton() {
		// Clic en el botón de guardar
		WebUI.click(button_save_vacancy)

		// Validar la notificación de "save"
		// new helpersKeywords().verifyNotification("save")
	}

	def clickButton(String optionType) {
		switch(optionType.toLowerCase()) {
			case "save":


			// Step 1: Click Save
				WebUI.click(button_save)

			// Step 2: Verify success message
				WebUI.delay(2)
				boolean saved = WebUI.verifyTextPresent("Successfully Saved", false, FailureHandling.OPTIONAL)

				if (saved) {
					KeywordUtil.logInfo("✅ Resume attached and saved successfully.")
				} else {
					KeywordUtil.markWarning("❌ Resume was not saved correctly.")
				}
				break

			case "search":
			// Step 1: Click search button
				WebUI.waitForElementClickable(button_search, 10)
				WebUI.click(button_search)

				break

			case "eye_candidate":
			// Step 1: Click on eye button
				WebUI.waitForElementClickable(button_eye, 10)
				WebUI.click(button_eye)

				break
			case "shortlist_button":
			// Step 1: Click shortlist button
				WebUI.waitForElementClickable(button_shortlist, 10)
				WebUI.click(button_shortlist)
				break

			case "schedule_interview":
			// Step 1: Click schedule interview button
				WebUI.waitForElementClickable(button_scheduleInterview, 10)
				WebUI.click(button_scheduleInterview)
				break
			case "markinterviewpassed":
			// Step 1: Click interview passed button
				WebUI.waitForElementClickable(button_markInterviewPassed, 10)
				WebUI.click(button_markInterviewPassed)
				break
			case "offerjob":
			// Step 1: Click offer job button
				WebUI.waitForElementClickable(button_offerJob, 10)
				WebUI.click(button_offerJob)
				break
			case "hire":
			// Step 1: Click hire button
				WebUI.waitForElementClickable(button_hire, 10)
				WebUI.click(button_hire)
				break
			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}

	@Keyword
	def attachResumeAndSave() {
		// Get file path from GlobalVariable
		String filePath = GlobalVariable.resumePath.trim()

		// Validate that the file exists
		File resumeFile = new File(filePath)
		if (!resumeFile.exists()) {
			KeywordUtil.markFailed("❌ File does not exist at path: " + filePath)
			return
		}


		// Step 1: Upload file
		WebUI.uploadFile(upload_Resume_button, filePath)


		// Step 2: Click Save
		WebUI.click(button_save)

		// Step 3: Verify success message
		WebUI.delay(2)
		boolean saved = WebUI.verifyTextPresent("Successfully Saved", false, FailureHandling.OPTIONAL)
		if (saved) {
			KeywordUtil.logInfo("✅ Resume attached and saved successfully.")
		} else {
			KeywordUtil.markWarning("❌ Resume was not saved correctly.")
		}
	}

	@Keyword
	def assertCandidateStatus(String optionText) {
		// Stage check
		WebUI.waitForElementPresent(status_applicationInitiated, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(status_applicationInitiated).trim(),optionText.trim(), false)
	}
	@Keyword
	def assertResumeIsPdfAndDownloadable(String expectedFileName) {
		// Locate the resume name element
		String fileName = WebUI.getText(resume_pdf_downloable).trim()

		// Validate file name matches expected and ends with .pdf
		if (!fileName.equalsIgnoreCase(expectedFileName) || !fileName.toLowerCase().endsWith(".pdf")) {
			KeywordUtil.markFailed("❌ Resume is not a PDF: " + fileName)
		}

		// Validate the title attribute also ends with .pdf
		String titleAttr = WebUI.getAttribute(resume_pdf_downloable, "title")
		if (!titleAttr.toLowerCase().endsWith(".pdf")) {
			KeywordUtil.markFailed("❌ Resume title is not a PDF: " + titleAttr)
		}

		// Validate download icon is present
		boolean iconPresent = WebUI.verifyElementPresent(resume_icon_downloable, 5, FailureHandling.OPTIONAL)

		if (!iconPresent) {
			KeywordUtil.markFailed("❌ Resume is not downloadable, download icon not found")
		} else {
			KeywordUtil.markPassed("✅ Resume is a PDF and downloadable: " + fileName)
		}
	}

	def scheduleInterview(String optionType, String optionText) {
		switch(optionType.toLowerCase()) {

			case "interviewer":
				new helpersKeywords().selectEmployee(input_interviewer, selectEmployee, optionText)
				break

			case "interview_title":
				new helpersKeywords().setInputByXpath(input_interviewTitle, optionText)
				break

			case "date":
				new helpersKeywords().setDateInput(input_date,optionText)
				break

			default:
				KeywordUtil.markFailed("Unsupported option type: " + optionType)
				break
		}
	}
}



