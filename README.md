<h1 align="center">OrangeHRM Web Automation Testing using Katalon</h1>

Katalon Studio is the automation testing tool I use to create end-to-end web test automation for the OrangeHRM application.

---

## 📑 Table of Contents
- [Getting Started](#-getting-started)
- [Base URL](#-base-url-orangehrm-application)
- [Features](#-features)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Requirements Traceability Matrix](#-requirements-traceability-matrix)
- [Detailed Test Cases](#-detailed-test-cases)
- [Reports](#-reports)



---

## 🚀 Getting Started

To get started with the testing project, follow the steps below:

1. **Clone this repo** to your computer.
   ```bash
   git clone https://github.com/Lfa5454/Testing.git

2. **Open the Test Case Documentation**  
   Review the `Test Cases/Orange_HRM` folder to understand all test scenarios.

3. **Download and install Katalon Studio**  
   👉 [Katalon Studio Download](https://katalon.com/download)

4. **Open the project using Katalon Studio**  
   - Navigate to the cloned project folder  
   - Open it in Katalon Studio  

5. **Wait for all plugins and dependencies to load**  
   Katalon will automatically install required plugins and dependencies.

6. **Run Test Suites**  
   - Navigate to `Test Suites/Orange_HRM_Suites`  
   - Select the test suite you need  
   - Click **Run ▶** using your preferred browser (Chrome, Edge, Firefox)  

## 🌐 Base URL OrangeHRM Application

[https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)

---

## ✨ Features

- Modular test cases with reusable keywords  
- Centralized object repository  
- Cookie persistence for session reuse  
- Automated create employee record and interview scheduling  
- Robust error handling and logging  

---

## 📖 Usage

- Run test suites directly from Katalon Studio.  
- Use the `TestListener.groovy` for open browser, cookie management and failure handling.  
- Reports are generated automatically under `/Reports`.  

---

## 📂 Project Structure
├── Test Cases/Orange_HRM
├── Test Suites/Orange_HRM_Suites
├── Object Repository
├── Include/scripts/groovy
├── Reports
└── README.md

---

## 📑 Requirements Traceability Matrix (RTM)

| Requirement ID | Description | Associated Test Cases | Validation Status |
|----------------|-------------|-----------------------|------------------|
| RQ-01          | Create employee record with login enabled | TC-01 | Pending |
| RQ-02          | Complete Job and Salary details; validate in Employee List | TC-02, TC-03, TC-04 | Pending |
| RQ-03          | ESS user updates personal/contact information | TC-05 | Pending |
| RQ-04          | HR assigns leave correctly | TC-06, TC-07 | Pending |
| RQ-05          | Dashboard reflects employees on leave | TC-08 | Pending |

---

## 🧪 Detailed Test Cases

### TC-01 · Create employee with login enabled
- **Requirement:** RQ-01  
- **Steps:**  
  - PIM → Add Employee → enter First Name = Valeria, Last Name = Ramírez; keep auto ID.  
  - Enable "Create Login Details": Username = vramirez, Status = Enabled, Password = V@l_2026!; Save.  
- **ASSERT:** Redirects to Personal Details page; employee record is Active.

---

### TC-02 · Validate employee in Employee List
- **Requirement:** RQ-02  
- **Steps:**  
  - PIM → Employee List → search "Valeria Ramírez".  
- **ASSERT:** Exactly one Active record exists.

---

### TC-03 · Complete Job and Salary details
- **Requirement:** RQ-02  
- **Steps:**  
  - Job tab: set Joined Date, Job Title, Job Category, Sub Unit, Location, Employee Status; Save.  
  - Salary tab: set Pay Grade, Pay Frequency, Currency, Amount; Save.  
- **ASSERT:** Data saved successfully.

---

### TC-04 · Validate ESS user in User Management
- **Requirement:** RQ-02  
- **Steps:**  
  - Admin → User Management → Users → search "vramirez".  
- **ASSERT:** ESS user exists; no duplicates.

---

### TC-05 · ESS updates personal/contact information
- **Requirement:** RQ-03  
- **Steps:**  
  - Open new private browser session; log in as vramirez.  
  - My Info → Personal Details: set Marital Status = Single; Save.  
  - My Info → Contact Details: Mobile = +52 33 1234 5678, Address = Av. Patria 123; Save.  
- **ASSERT:** Green success banner on each save; values persist after page refresh.

---

### TC-06 · HR assigns leave
- **Requirement:** RQ-04  
- **Steps:**  
  - HR Admin → Leave → Assign Leave.  
  - Employee: Valeria Ramírez | Type: Annual Leave | From: Mar 18 | To: Mar 19, 2026; Submit.  
- **ASSERT:** Status = Scheduled.

---

### TC-07 · Validate Leave List
- **Requirement:** RQ-04  
- **Steps:**  
  - Leave → Leave List: filter by employee + date range.  
- **ASSERT:** 2 working days scheduled; weekends not counted.

---

### TC-08 · Dashboard reflects employees on leave
- **Requirement:** RQ-05  
- **Steps:**  
  - Dashboard → "Employees on Leave Today" widget (Mar 18).  
- **ASSERT:** Valeria Ramírez appears in widget list.  
  - Widget data matches Leave module; no stale cache beyond SLA.

---
## 📊 Reports

- **Location:** All execution reports are generated automatically under the `/Reports` directory.  
- **Contents:** Each report includes:
  - Pass/Fail status for every test case
  - Execution logs with timestamps
  - Screenshots captured at failure points
  - Environment and browser details
- **Format:** Reports are available in HTML, PDF, and CSV formats depending the Katalon configuration.  
- **Integration:** Reports can be uploaded and tracked in **Katalon TestOps** for:
  - Requirement coverage analysis
  - Historical trend reporting
  - Team dashboards and analytics
- **Usage Tip:** Use TestOps integration to link each test case (TC-01, TC-02, etc.) with its requirement (RQ-01, RQ-02, etc.) for live traceability.