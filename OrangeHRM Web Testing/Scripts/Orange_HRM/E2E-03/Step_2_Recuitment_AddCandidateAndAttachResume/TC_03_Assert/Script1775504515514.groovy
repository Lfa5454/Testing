/**
 * =====================================================
 * Test Case : ASSERT: candidate in 'Application Initiated' stage; PDF downloadable.
 * Module    : Recruitment
 * Purpose   : Validate candidate initial status and attached resume attributes
 *
 * Preconditions:
 * - User is logged in
 * - Candidate has been created
 * - Resume has been uploaded previously
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-07
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

// Step 1: Validate candidate status
recruitmentPage.assertCandidateStatus("Status: Application Initiated")

// Step 2: Validate resume format and download availability
recruitmentPage.assertResumeIsPdfAndDownloadable("DLopez_QA_Resume.pdf")

// ==============================
// Expected Result
// ==============================
// ✅ Candidate status is correct
// ✅ Resume is a valid PDF and downloadable