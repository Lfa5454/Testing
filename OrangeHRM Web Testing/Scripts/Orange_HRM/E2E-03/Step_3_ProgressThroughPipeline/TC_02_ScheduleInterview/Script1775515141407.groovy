/**
 * =====================================================
 * Test Case : 3.2  Schedule Interview: set date/time; attach interviewer feedback form.
 * Module    : Recruitment
 * Purpose   : Validate that an interview can be scheduled for a candidate
 *
 * Preconditions:
 * - User is logged in
 * - Candidate has been shortlisted
 * - Candidate detail page is open
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-03
 * =====================================================
 */

import pages.RecruitmentPage

// ==============================
// Test Setup
// ==============================

RecruitmentPage recruitmentPage = new RecruitmentPage()

// ==============================
// Test Steps
// ==============================

// Step 1: Navigate to Recruitment module
//recruitmentPage.goToRecruitment()

// Step 2: Schedule interview using workflow
recruitmentPage.scheduleInterviewAndSave(
	"Technical Interview",
	"2026-06-04",
	"Ranga  Akunuri",
	"test_lili"
)

// ==============================
// Validation
// ==============================

// Step 3: Validate interview status
recruitmentPage.assertCandidateStatus("Status: Interview Scheduled")

// ==============================
// Expected Result
// ==============================
// ✅ Interview is scheduled successfully
// ✅ Candidate status is updated to "Interview Scheduled"