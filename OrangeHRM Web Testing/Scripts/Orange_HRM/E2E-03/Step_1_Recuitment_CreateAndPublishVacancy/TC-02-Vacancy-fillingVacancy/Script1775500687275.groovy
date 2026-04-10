/**
 * =====================================================
 * Test Case : 1.2  Fill Job Title, Vacancy Name, Hiring Manager, Positions = 1; Save; set Status = Active.
 * Module    : Recruitment
 * Purpose   : Validate that a recruiter can create an active vacancy
 *
 * Preconditions:
 * - User is logged in
 * - Recruitment module is accessible
 *
 * Author    : Liliana Fajardo
 * Created   : 2026-04-09
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

// Step 1: Create vacancy
recruitmentPage.createVacancy("QA-Auto-GDL-2026")

// Step 2: Configure vacancy details
recruitmentPage.selectOption(OptionType.JOBTITLE_INPUT, "QA Engineer")
recruitmentPage.selectOption(OptionType.HIRINGMANAGER_INPUT, "Ranga Akunuri")
recruitmentPage.selectOption(OptionType.POSITION_INPUT, "1")

// Step 3: Ensure vacancy is active
recruitmentPage.selectOption(OptionType.ACTIVE_CHECKBOX, "")

// Step 4: Save vacancy
recruitmentPage.clickButton(ButtonAction.SAVE)

// ==============================
// Expected Result
// ==============================
// ✅ Vacancy is created and displayed as Active