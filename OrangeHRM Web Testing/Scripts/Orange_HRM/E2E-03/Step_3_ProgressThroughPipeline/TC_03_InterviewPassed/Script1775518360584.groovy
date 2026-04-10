

/**
 * =====================================================
 * Test Case : 3.3  Record outcome = Interview Passed; add comments.
 * Module    : Recruitment
 * Purpose   : Validate that an interview can be marked as passed
 *
 * Preconditions:
 * - Interview has been scheduled
 * - Candidate detail page is open
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-02
 * =====================================================
 */

import pages.RecruitmentPage
import enums.ButtonAction

// ==============================
// Test Setup
// ==============================

RecruitmentPage recruitmentPage = new RecruitmentPage()

// ==============================
// Test Steps
// ==============================

// Step 1: Execute workflow action (Interview Passed) and added a note 
recruitmentPage.executeCandidateWorkflowActionAndSave(
	ButtonAction.MARK_INTERVIEW_PASSED,
	"Interview passed successfully"
)

// ==============================
// Validation
// ==============================

recruitmentPage.assertCandidateStatus("Status: Interview Passed")

// ==============================
// Expected Result
// ==============================
// ✅ Interview status updated to Passed
