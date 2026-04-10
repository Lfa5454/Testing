package pages
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import internal.GlobalVariable
import helpers.helpersKeywords
import enums.ButtonAction
import enums.OptionType

/**
 * RecruitmentPage
 * -----------------------
 * Page Object Model class that encapsulates
 * all locators and behaviors related to the Recruitment module
 * in OrangeHRM.
 *
 * Responsibilities:
 * - Navigation within Recruitment sections
 * - Vacancy creation and validation
 * - Candidate management
 * - Interview workflow actions
 * - Status and file assertions
 *
 * Note:
 * This class does NOT contain test logic,
 * only reusable UI actions and validations.
 */



class RecruitmentPage {


	// ======================================================
	// Dependencies
	// ======================================================

	def helpers = new helpersKeywords()

	// ======================================================
	// Navigation & Menus
	// ======================================================
	private TestObject menuRecruitment = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/Menu_Recruitment')
	private TestObject menuCandidates = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/li_Candidates')
	private TestObject selectEmployeeDropdown =	findTestObject('Object Repository/Page_OrangeHRM/Admin/MyInfo/input_NameDropdown')

	// ======================================================
	// Vacancy Management
	// ======================================================
	private TestObject listVacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/list_vacancy')
	private TestObject buttonAddVacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add_1')
	private TestObject inputVacancyName = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_VacancyName')
	private TestObject dropdownJobTitle = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/dropDown_JobTitle')
	private TestObject inputHiringManager = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input')
	private TestObject inputPositions = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_NumberOfPositions')
	private TestObject checkboxActive = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_checkbox')
	private TestObject vacancyAlreadyExistsMessage = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_VacancyNameAlreadyExists')
	private TestObject buttonSaveVacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save')

	// ======================================================
	// Candidate Management
	// ======================================================

	private TestObject buttonAddCandidate = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add')
	private TestObject inputCandidateFirstName = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Candidate_firstName')
	private TestObject inputCandidateLastName = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Candidate_lastName')
	private TestObject dropdownCandidateVacancy = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/dropDown_Vacancy')
	private TestObject inputCandidateEmail = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Email')

	private TestObject inputCandidateContact = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_ContactNumber')
	private TestObject textareaNotes = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_AddNotes')

	// ======================================================
	// Resume Management
	// ======================================================

	private TestObject uploadResumeInput = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_TypeFile')
	private TestObject resumeNameLabel = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_PDFResume')
	private TestObject resumeDownloadLabel = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_PDFDownloadResume')
	private TestObject resumeDownloadIcon = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Download')
	// ======================================================
	// Workflow Buttons
	// ======================================================

	private TestObject buttonSave = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save')
	private TestObject buttonSearch = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Search')
	private TestObject buttonEye = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_BiEye')
	private TestObject buttonShortlist = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Shortlist')
	private TestObject buttonScheduleInterview = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Schedule Interview')
	private TestObject buttonMarkInterviewPassed = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Mark Interview Passed')
	private TestObject buttonOfferJob = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Offer Job')
	private TestObject buttonHire = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Hire')

	// ===========================
	// 🔹 Interview Management
	// ===========================

	private TestObject inputInterviewTitle = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_InterviewTitle')
	private TestObject inputInterviewer = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Interviewer')
	private TestObject inputInterviewDate = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Date_oxd-input oxd-input--active')
	private TestObject inputInterviewTime = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Time_oxd-input oxd-input--active')


	// ===========================
	// 🔹 Status Labels
	// ===========================
	TestObject status_applicationInitiated = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_StatusApplicationInitiated')
	TestObject status_interviewScheduled   = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Interview Scheduled')
	TestObject status_interviewPassed      = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Status Interview Passed')
	TestObject status_jobOffered           = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Job Offered')
	TestObject status_hired                = findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Hired')

	// ======================================================
	// Navigation Actions
	// ======================================================

	/**
	 * Navigates to the Recruitment module.
	 * Execution stops if navigation fails.
	 */
	void goToRecruitment() {
		WebUI.click(menuRecruitment)

		String currentUrl = WebUI.getUrl()
		if (!currentUrl.contains('/recruitment')) {
			KeywordUtil.markFailedAndStop(
					"Failed to navigate to Recruitment module. Current URL: $currentUrl"
					)
		}
	}

	// ======================================================
	// Vacancy Actions
	// ======================================================

	/**
	 * Creates a vacancy and validates uniqueness.
	 */
	void createVacancy(String vacancyName) {

		WebUI.click(listVacancy)
		WebUI.click(buttonAddVacancy)
		WebUI.setText(inputVacancyName, vacancyName)

		if (WebUI.verifyElementPresent(vacancyAlreadyExistsMessage, 3, FailureHandling.OPTIONAL)) {
			KeywordUtil.markFailedAndStop("Vacancy already exists: $vacancyName")
		}
	}

	// ======================================================
	// Candidate Actions
	// ======================================================

	/**
	 * Initializes candidate creation with basic data.
	 */
	void addCandidateBasicInfo(String firstName, String lastName) {

		WebUI.click(menuCandidates)
		WebUI.click(buttonAddCandidate)

		WebUI.setText(inputCandidateFirstName, firstName)
		WebUI.setText(inputCandidateLastName, lastName)
	}

	// ======================================================
	// Option Dispatcher (Type-safe)
	// ======================================================

	/**
	 * Handles UI option interactions using enum-based dispatch.
	 */
	void selectOption(OptionType option, String value) {

		switch (option) {

			case OptionType.JOBTITLE_INPUT:
				WebUI.click(dropdownJobTitle)
				helpers.selectDropdownOption(value)
				break

			case OptionType.HIRINGMANAGER_INPUT:
				helpers.selectEmployee(inputHiringManager, selectEmployeeDropdown, value)
				break

			case OptionType.POSITION_INPUT:
				helpers.setInputByXpath(inputPositions, value)
				break

			case OptionType.ACTIVE_CHECKBOX:
				ensureCheckboxIsActive()
				break

			case OptionType.VACANCY_INPUT:
				WebUI.click(dropdownCandidateVacancy)
				helpers.selectDropdownOption(value)
				break

			case OptionType.CANDIDATE_EMAIL_INPUT:
				WebUI.setText(inputCandidateEmail, value)
				break

			case OptionType.CANDIDATE_CONTACTNUMBER:
				WebUI.setText(inputCandidateContact, value)
				break

			case OptionType.ADD_NOTES:
				WebUI.setText(textareaNotes, value)
				break

			default:
				KeywordUtil.markFailed("Unsupported OptionType: $option")
		}
	}

	// ======================================================
	// Button Actions (Enum-based)
	// ======================================================

	/**
	 * Executes a UI button action based on the provided ButtonAction enum.
	 *
	 * This method centralizes all button interactions related to
	 * the Recruitment workflow and prevents test cases from
	 * accessing UI elements directly.
	 *
	 * @param action The button action to execute
	 */

	void clickButton(ButtonAction action) {

		switch (action) {

			case ButtonAction.SAVE:
				performSave()
				break

			case ButtonAction.SEARCH:
				WebUI.waitForElementClickable(buttonSearch, 10)
				WebUI.click(buttonSearch)
				break

			case ButtonAction.EYE_CANDIDATE:
				WebUI.waitForElementClickable(buttonEye, 10)
				WebUI.click(buttonEye)
				break

			case ButtonAction.SHORTLIST:
				WebUI.waitForElementClickable(buttonShortlist, 10)
				WebUI.click(buttonShortlist)
				break

			case ButtonAction.SCHEDULE_INTERVIEW:
				WebUI.waitForElementClickable(buttonScheduleInterview, 10)

				WebUI.click(buttonScheduleInterview)
				break

			case ButtonAction.MARK_INTERVIEW_PASSED:
				WebUI.waitForElementClickable(buttonMarkInterviewPassed, 10)
				WebUI.click(buttonMarkInterviewPassed)
				break

			case ButtonAction.OFFER_JOB:
				WebUI.waitForElementClickable(buttonOfferJob, 10)
				WebUI.click(buttonOfferJob)
				break

			case ButtonAction.HIRE:
				WebUI.waitForElementClickable(buttonHire, 10)
				WebUI.click(buttonHire)
				break

			default:
				KeywordUtil.markFailed("Unsupported ButtonAction: $action")
		}
	}

	// ======================================================
	// Resume Actions
	// ======================================================

	/**
	 * Uploads a resume file and saves the candidate record.
	 *
	 * Preconditions:
	 * - GlobalVariable.resumePath must be configured
	 * - Candidate creation/edit page must be open
	 */

	@Keyword
	void attachResumeAndSave() {

		String filePath = GlobalVariable.resumePath.trim()
		validateFileExists(filePath)

		// Step 1: Upload file
		WebUI.uploadFile(uploadResumeInput, filePath)

		// Step 2: Verify file was attached (robust UI check)
		verifyResumeWasAttached(filePath)

		// Step 3: Save
		performSave()
	}

	/**
	 * Validates that the candidate status matches the expected value.
	 *
	 * @param optionText Expected candidate status text
	 */

	@Keyword
	def assertCandidateStatus(String optionText) {
		// Stage check
		WebUI.waitForElementPresent(status_applicationInitiated, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyMatch(WebUI.getText(status_applicationInitiated).trim(),optionText.trim(), false)
	}

	/**
	 * Validates that the attached resume:
	 * - Matches the expected file name
	 * - Is a PDF file
	 * - Is downloadable
	 *
	 * @param expectedFileName Expected resume file name
	 */

	@Keyword
	void assertResumeIsPdfAndDownloadable(String expectedFileName) {
		// Locate the resume name element
		String fileName = WebUI.getText(resumeDownloadLabel).trim()

		// Validate file name matches expected and ends with .pdf
		if (!fileName.equalsIgnoreCase(expectedFileName) || !fileName.toLowerCase().endsWith(".pdf")) {
			KeywordUtil.markFailed("❌ Resume is not a PDF: " + fileName)
		}

		// Validate the title attribute also ends with .pdf
		String titleAttr = WebUI.getAttribute(resumeDownloadLabel, "title")
		if (!titleAttr.toLowerCase().endsWith(".pdf")) {
			KeywordUtil.markFailed("❌ Resume title is not a PDF: " + titleAttr)
		}

		// Validate download icon is present
		boolean iconPresent = WebUI.verifyElementPresent(resumeDownloadIcon, 5, FailureHandling.OPTIONAL)

		if (!iconPresent) {
			KeywordUtil.markFailed("❌ Resume is not downloadable, download icon not found")
		} else {
			KeywordUtil.markPassed("✅ Resume is a PDF and downloadable: " + fileName)
		}
	}

	// ======================================================
	// Private Helpers
	// ======================================================

	/**
	 * Ensures the vacancy "Active" checkbox is checked.
	 * Activates it only if it is currently unchecked.
	 */

	private void ensureCheckboxIsActive() {

		boolean isActive = helpers.verifyActiveCheckbox(checkboxActive)

		if (!isActive) {
			WebUI.click(checkboxActive)
			WebUI.verifyElementChecked(checkboxActive, 5)
		}
	}

	/**
	 * Performs a save action and logs a warning
	 * if the success message is not displayed.
	 */


	/**
	 * Performs a robust Save action handling DOM re-rendering and stale elements.
	 */
	private void performSave() {

		int attempts = 0
		boolean clicked = false

		while (attempts < 3 && !clicked) {
			try {
				// Re-wait for the Save button every attempt
				WebUI.waitForElementVisible(buttonSave, 10)
				WebUI.waitForElementClickable(buttonSave, 10)

				// Scroll into view (important for Chrome 146+)
				WebUI.scrollToElement(buttonSave, 5)

				// ✅ JS click to avoid stale reference
				JavascriptExecutor js =	(JavascriptExecutor) DriverFactory.getWebDriver()
				js.executeScript("arguments[0].click();", WebUI.findWebElement(buttonSave, 5))

				clicked = true
			} catch (Exception e) {
				attempts++
				KeywordUtil.logInfo(
						"Retrying Save click due to DOM refresh (attempt ${attempts})"
						)
				WebUI.delay(1)
			}
		}

		if (!clicked) {
			KeywordUtil.markFailedAndStop(
					"Unable to click Save button after multiple attempts due to DOM refresh."
					)
		}

		// Optional success verification
		WebUI.delay(1)
		WebUI.verifyTextPresent(
				'Successfully Saved',
				false,
				FailureHandling.OPTIONAL
				)
	}



	/**
	 * Validates that the provided file path exists.
	 * Stops execution if the file is not found.
	 */

	private void validateFileExists(String path) {

		if (!path || !new File(path).exists()) {
			KeywordUtil.markFailedAndStop("Resume file not found at path: $path")
		}
	}
	/**
	 * Verifies that the resume file was successfully attached to the candidate.
	 *
	 * @param filePath Full path of the uploaded resume
	 */
	private void verifyResumeWasAttached(String filePath) {

		// Extract expected file name
		String expectedFileName = filePath.substring(
				filePath.lastIndexOf(File.separator) + 1
				)

		// Wait until resume label appears
		WebUI.waitForElementVisible(resumeNameLabel, 10)

		// Get displayed file name
		String actualFileName = WebUI.getText(resumeNameLabel).trim()

		// Normalize spaces (important for UI inconsistencies)
		actualFileName = actualFileName.replaceAll("\\s+", " ")

		if (!actualFileName.equalsIgnoreCase(expectedFileName)) {
			KeywordUtil.markFailedAndStop(
					"Resume upload failed. Expected file: ${expectedFileName}, but found: ${actualFileName}"
					)
		}
	}
	// ======================================================
	// Interview Workflows
	// ======================================================

	/**
	 * Sets interview-related fields based on the provided OptionType.
	 *
	 * @param option Interview field to configure
	 * @param value  Value to be set
	 */
	void scheduleInterview(OptionType option, String value) {

		switch(option) {

			case OptionType.INTERVIEW_TITLE:
				helpers.setInputByXpath(inputInterviewTitle, value)
				break

			case OptionType.DATE:
				helpers.setDateInput(inputInterviewDate, value)
				break

			case OptionType.INTERVIEWER:
				helpers.selectEmployee(inputInterviewer, selectEmployeeDropdown, value)
				break

			default:
				KeywordUtil.markFailed(
				"Unsupported interview option: $option"
				)
		}
	}


	/**
	 * Schedules an interview for a candidate and saves the information.
	 *
	 * Preconditions:
	 * - Candidate detail page is open
	 * - Candidate has been shortlisted
	 *
	 * @param title Interview title
	 * @param date Interview date (yyyy-MM-dd)
	 * @param interviewer Interviewer name
	 * @param notes Additional notes for the interview
	 */
	/**
	 * Sets interview-related fields based on the provided OptionType.
	 *
	 * @param option Interview field to configure
	 * @param value  Value to be set
	 */


	void scheduleInterviewAndSave(
			String title,
			String date,
			String interviewer,
			String notes
	) {
		// Open Schedule Interview form
		clickButton(ButtonAction.SCHEDULE_INTERVIEW)

		// Fill interview details
		scheduleInterview(OptionType.INTERVIEW_TITLE, title)
		scheduleInterview(OptionType.DATE, date)
		scheduleInterview(OptionType.INTERVIEWER, interviewer)

		// Add notes if provided
		if (notes) {
			selectOption(OptionType.ADD_NOTES, notes)
		}

		// Save interview
		clickButton(ButtonAction.SAVE)
	}

	// ======================================================
	// Candidate Workflow Actions
	// ======================================================

	/**
	 * Executes a candidate workflow action (e.g. Interview Passed, Offer Job, Hire)
	 * and saves the result.
	 *
	 * Preconditions:
	 * - Candidate detail page is open
	 * - Action is available for the current candidate status
	 *
	 * @param action Workflow action to execute
	 * @param notes Optional notes to be added before saving
	 */
	void executeCandidateWorkflowActionAndSave(ButtonAction action,	String notes = null) {

		// Execute workflow action (button click)
		clickButton(action)

		// Add notes if provided
		if (notes) {
			selectOption(OptionType.ADD_NOTES, notes)
		}
		WebUI.delay(2)
		// Save changes
		clickButton(ButtonAction.SAVE)
	}
}