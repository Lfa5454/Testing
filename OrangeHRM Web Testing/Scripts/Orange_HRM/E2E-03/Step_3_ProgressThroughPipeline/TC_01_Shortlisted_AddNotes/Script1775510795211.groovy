


/**
 * =====================================================
 * Test Case : 3.1  Advance → Shortlisted; add recruiter notes.
 * Module    : Recruitment
 * Purpose   : Validate that a candidate can be shortlisted successfully
 *
 * Preconditions:
 * - User is logged in
 * - Vacancy "QA-Auto-GDL-2026" exists
 * - Candidate is available in the list
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-03
 * =====================================================
 */


import pages.RecruitmentPage
import pages.PIM_SearchEmployeeAndEdit
import enums.OptionType
import enums.ButtonAction
import com.kms.katalon.core.util.KeywordUtil


// ==============================
// Test Setup
// ==============================

RecruitmentPage recruitmentPage = new RecruitmentPage()
PIM_SearchEmployeeAndEdit pimPage = new PIM_SearchEmployeeAndEdit()

// ==============================
// Test Steps
// ==============================

// Step 1: Navigate to Recruitment
recruitmentPage.goToRecruitment()

// Step 2: Filter candidates by vacancy
recruitmentPage.selectOption(OptionType.VACANCY_INPUT, "QA-Auto-GDL-2026")
recruitmentPage.clickButton(ButtonAction.SEARCH)


// Step 3: Verify candidate records using Custom Keyword
boolean recordsExist = CustomKeywords.'helpers.helpersKeywords.verifyRecords'()

// Step 4: Decide test flow
if (!recordsExist) {
    KeywordUtil.markFailedAndStop("No candidate records found for the selected vacancy."
    )
}

// Step 5: Validate initial candidate status
pimPage.validateInputValue("Application Initiated")

// Step 6: Open candidate details
recruitmentPage.clickButton(ButtonAction.EYE_CANDIDATE)

// Step 7: Shortlist candidate
recruitmentPage.clickButton(ButtonAction.SHORTLIST)
recruitmentPage.selectOption(OptionType.ADD_NOTES, "test_lili")
recruitmentPage.clickButton(ButtonAction.SAVE)

// ==============================
// Expected Result
// ==============================
// ✅ Candidate is shortlisted successfully
