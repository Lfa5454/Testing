/**
 * =====================================================
 * Test Case : 1.1  Recruitment → Vacancies → Add.
 * Module    : Recruitment
 * Purpose   : Validate that the user can navigate to the Recruitment module
 *
 * Preconditions:
 * - User is logged in
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-05
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
recruitmentPage.goToRecruitment()

// ==============================
// Expected Result
// ==============================
// ✅ Recruitment page is displayed successfully

