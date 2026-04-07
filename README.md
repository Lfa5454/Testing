<h1 align="center">OrangeHRM Web Automation Testing using Katalon</h1>

Katalon Studio is the automation testing tool I use to create end-to-end web test automation for the OrangeHRM application.

📑 Table of Contents

Getting Started

Base URL

Features

Usage

Project Structure

🚀 Getting Started

To get started with the testing project, follow the steps below:

Clone this repo to your computer.

git clone https://github.com/Lfa5454/Testing.git

Open the Test Case DocumentationReview the Test Case OrangeHRM file to understand all test scenarios.

Open the project using Katalon Studio

Download and install Katalon Studio.

Open the project folder.

Wait for all plugins and dependencies to load.

Run Test SuitesOpen the Test Suites folder → Select the test suite you need → Click Run ▶ using your preferred browser (Chrome/Edge/Firefox).

🌐 Base URL OrangeHRM Application

https://opensource-demo.orangehrmlive.com/

✨ Features

Modular test cases with reusable keywords

Centralized object repository

Cookie persistence for session reuse

Automated interview scheduling

Robust error handling and logging

📖 Usage

Run test suites directly from Katalon Studio.

Use the TestListener for cookie management and failure handling.

Reports are generated automatically under /Reports.

📂 Project Structure

OrangeHRM-Web-Automation-Testing-using-Katalon-Studio/
├── Data/
│   └── cookies/                # Cookie persistence (cookies.json per role if needed)
│
├── Keywords/
│   ├── helpers/                # Generic reusable keywords (FormHelpers, DateHelpers, etc.)
│   └── pages/                  # Page-specific keywords (RecruitmentPage, LoginPage, etc.)
│
├── Test Cases/
│   └── Orange_HRM/
│       ├── E2E-01/               # End-to-End flow 01: Employee Records
│       │   ├── Step_1_CreateEmployeeRecords/
│       │   │   ├── TC-01-PIM-AddEmployeeRecord
│       │   │   ├── TC-02-PIM-EnableCreateLoginDetails
│       │   │   └── TC-03-PIM-ValidateEmployeeStatus
│       │   ├── Step_2_VerifyRecordandCompleteJobDetails/
│       │   │   ├── TC-01-PIM-VerifyRecordAdded
│       │   │   ├── TC-02-PIM-JobTab-CompleteJobDetails
│       │   │   ├── TC-03-PIM-Salary-CompleteSalaryDetails
│       │   │   └── TC-04-Admin-Search_vramirez_UserName
│       │   ├── Step_3_ESS_SelfServiceSession/
│       │   │   ├── TC-01-LoginWithUsernameCreated
│       │   │   ├── TC-02-MyInfo-MaritalStatus
│       │   │   └── TC-03-MyInfo-ContactDetails
│       │   ├── Step_4_HRAssignsLeave/
│       │   │   ├── TC-01-AssignLeavePage
│       │   │   ├── TC-02-AssignLeave
│       │   │   └── TC-03-FilterByEmployee
│       │   └── Step_5_DashboardConsistencyCheck/
│       │       ├── TC-01-EmployeesOnLeaveToday
│       │       └── TC-02-ASSERTWidgetDataMatchesLeaveModule
│       │
│       └── E2E-03/               # End-to-End flow 03: Recruitment
│           ├── Step_1_Recruitment_CreateAndPublishVacancy/
│           │   ├── TC-01-RecruitmentTab
│           │   └── TC-02-Vacancy-fillingVacancy
│           ├── Step_2_Recruitment_AddCandidateAndAttachResume/
│           │   ├── TC-01-Candidate-AddCandidate (disabled/commented)
│           │   ├── TC-02-AttachResume
│           │   └── TC-03-Assert
│           ├── Step_3_ProgressThroughPipeline/
│           │   ├── TC-01-Shortlisted_AddNotes
│           │   ├── TC-02-ScheduleInterview (disabled/commented)
│           │   ├── TC-03-InterviewPassed
│           │   └── TC-04-OfferJob
│           └── Step_4_MarkHiredAndOnboardToPIM/
│               └── TC-01-SetStatusHired
│
├── Test Suites/
│   └── Orange_HRM_Suites/
│       ├── E2E-01/
│       │   ├── TS-01-CreateEmployeeRecord
│       │   ├── TS-02-VerifyRecord-CompleteJobDetails
│       │   ├── TS-03-ESS-SelfServiceSession
│       │   ├── TS-04-HRAssignsLeave
│       │   └── TS-05-DashboardConsistencyCheck
│       └── E2E-03/
│           ├── TS-01-CreateAndPublishVacancy
│           ├── TS-02-AddCandidateAndAttachResume
│           └── TS-03-ProgressThroughPipeline
│
├── Data Files/                   # External test data (CSV, Excel, JSON)
├── Reports/                      # Auto-generated test execution reports
├── TestListener.groovy           # Global listener (login, cookies, failure handling)
├── .gitignore                    # Ignore bin/, Reports/, cookies.json, etc.
└── README.md                     # Professional documentation