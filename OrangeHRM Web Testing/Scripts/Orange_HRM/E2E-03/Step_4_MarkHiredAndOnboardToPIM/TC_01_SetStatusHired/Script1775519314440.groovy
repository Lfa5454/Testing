/**
 * =====================================================
 * Test Case : TC_Recruitment_HireCandidate
 * Module    : Recruitment
 * Purpose   : Validate that a candidate can be hired successfully
 *
 * Preconditions:
 * - User is logged in as admin
 * - Vacancy "QA-Auto-GDL-2026" exists
 * - Candidate status is "Job Offered"
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-09
 * =====================================================
 */

import pages.RecruitmentPage
import pages.PIM_SearchEmployeeAndEdit
import enums.OptionType
import enums.ButtonAction
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

// ==============================
// Test Setup
// ==============================

RecruitmentPage recruitmentPage = new RecruitmentPage()
PIM_SearchEmployeeAndEdit pimPage = new PIM_SearchEmployeeAndEdit()

// ==============================
// Test Steps
// ==============================

// Step 1: Navigate to Recruitment module
recruitmentPage.goToRecruitment()

// Step 2: Filter candidates by vacancy
recruitmentPage.selectOption(OptionType.VACANCY_INPUT,	"QA-Auto-GDL-2026")
recruitmentPage.clickButton(ButtonAction.SEARCH)

// Step 3: Verify candidate records exist (Custom Keyword)
boolean recordsExist =
	CustomKeywords.'helpers.helpersKeywords.verifyRecords'()

if (!recordsExist) {
	KeywordUtil.markFailedAndStop("No candidate records found for vacancy QA-Auto-GDL-2026.")
}

// Step 4: Validate current candidate status
pimPage.validateInputValue("Job Offered")

// Step 5: Open candidate details
recruitmentPage.clickButton(ButtonAction.EYE_CANDIDATE)

// Step 6: Hire candidate using generic workflow
recruitmentPage.executeCandidateWorkflowActionAndSave(
	ButtonAction.HIRE,
	"Candidate hired successfully"
)

// ==============================
// Validation
// ==============================

// Step 7: Validate candidate status updated
recruitmentPage.assertCandidateStatus("Status: Hired")

// ==============================
// Expected Result
// ==============================
// ✅ Candidate is successfully hired