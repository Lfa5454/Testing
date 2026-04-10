/**
 * =====================================================
 * Test Case : 3.4  Advance → Offer; generate offer from 'Standard Offer' template; Save.
 * Module    : Recruitment
 * Purpose   : Validate that a job offer can be sent to a candidate
 *
 * Preconditions:
 * - Interview has been passed
 * - Candidate detail page is open
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-09
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

// Step 1: Execute workflow action (Offer Job) and added note
recruitmentPage.executeCandidateWorkflowActionAndSave(
	ButtonAction.OFFER_JOB,
	"Job offer approved"
)

// ==============================
// Validation
// ==============================

recruitmentPage.assertCandidateStatus("Status: Job Offered")

// ==============================
// Expected Result
// ==============================
// ✅ Candidate status updated to Job Offered