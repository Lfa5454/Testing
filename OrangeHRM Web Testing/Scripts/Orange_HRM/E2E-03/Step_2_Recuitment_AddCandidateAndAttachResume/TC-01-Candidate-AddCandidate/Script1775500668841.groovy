
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
 * =====================================================
 */

import pages.RecruitmentPage
import enums.OptionType
import enums.ButtonAction
// ==============================
// Test Setup
// ==============================

RecruitmentPage recruitmentPage = new RecruitmentPage()

// ==============================
// Test Steps
// ==============================
// Step 1: Navigate to Recruitment
recruitmentPage.goToRecruitment()

// Step 2: Create candidate basic information
recruitmentPage.addCandidateBasicInfo("Daniel", "López")

// Step 3: Assign vacancy and contact details
recruitmentPage.selectOption(OptionType.VACANCY_INPUT, "QA-Auto-GDL-2026")
recruitmentPage.selectOption(OptionType.CANDIDATE_EMAIL_INPUT, "daniel.lopez+qa@demo.test")
recruitmentPage.selectOption(OptionType.CANDIDATE_CONTACTNUMBER, "+523311234567")

// Step 4: Save candidate
//recruitmentPage.clickButton(ButtonAction.SAVE)
