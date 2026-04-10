/**
 * =====================================================
 * Test Case : 2.2  Attach DLopez_QA_Resume.pdf; Save.
 * Module    : Recruitment
 * Purpose   : Validate that a resume can be attached and saved successfully
 *
 * Preconditions:
 * - User is logged in
 * - Candidate creation page is open
 * - GlobalVariable.resumePath is configured
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-08
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

// Step 1: Attach resume file and save candidate
recruitmentPage.attachResumeAndSave()

// ==============================
// Expected Result
// ==============================
// ✅ Resume is uploaded and saved successfully