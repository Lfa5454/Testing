import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import pages.RecruitmentPage
import helpers.helpersKeywords

// ========== Object References ==========
RecruitmentPage recruitmentPage = new RecruitmentPage()

recruitmentPage.goToRecruitment()

/*



WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/i_No file selected_oxd-icon bi-upload oxd-f_21640a'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/form_Application StageNameDaniel  LopezVaca_1ae52d'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_StatusApplicationInitiated'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Shortlist'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/Menu_Recruitment'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_1'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Candidate Name'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_1'), 'Daniel')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Search'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_QA-Auto-GDL-2026Daniel  LopezRahul  Das_e8c0e0'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/i_Shortlisted_oxd-icon bi-eye-fill'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Schedule Interview'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Candidate'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Interview Title'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Schedule InterviewCandidateVacancyHirin_bd7d94'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_InterviewTitle'), 
    'test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Interviewer'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Schedule InterviewCandidateVacancyHirin_bd7d94_1'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Interviewer'), 'char')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Interviewer'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Date'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_DateRequired'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Date_oxd-input oxd-input--active'), 
    '2026-31-03')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Time'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Time_oxd-input oxd-input--active'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Date_1'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Time_oxd-input oxd-input--active'), 
    '05:00 PM')

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/text_AddNotes'), 
    'test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Notes'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Interview Scheduled'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Mark Interview Passed'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Notes_1'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/textarea_Notes_oxd-textarea oxd-textarea--f_0ce0e8_1'), 
    'test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Status Interview Passed'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Offer Job'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Notes_1_2'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Notes_1'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/textarea_Notes_oxd-textarea oxd-textarea--f_0ce0e8_1'), 
    'test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/form_Application StageNameDaniel  LopezVaca_b64688'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Job Offered'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Hire'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/textarea_Notes_oxd-textarea oxd-textarea--f_0ce0e8_1'), 
    'test')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Application StageNameDaniel  LopezVacan_d461cc'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/p_Status Hired'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_PIM'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_1_2_3'), 'daniel lopez')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Search'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Daniel LopezQA Engineer'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/h6_Daniel Lopez'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/a_Admin'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Add_1'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2_3_4_5_6'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_1_2_3_4'), 'Daniel')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2_3_4_5_6_7'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Username_oxd-input oxd-input--focus'), 
    'dlopez')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/i_-- Select --_oxd-icon bi-caret-up-fill ox_627fec_1_2_3_4_5_6'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_Add UserUser RoleAdminEmployee NameStat_53e430'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Password_oxd-input oxd-input--focus'), 
    'kZVZQDpdH5yb9tO01+6lfw==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Confirm Password_oxd-input oxd-input--active'), 
    'kZVZQDpdH5yb9tO01+6lfw==')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_SuccessSuccessfully Saved'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/input_Username_oxd-input oxd-input--focus_1'), 
    'dlopez')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/button_Search'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/Admin/Page_Recuitment/div_dlopezAdminDaniel LopezEnabled'))
*/
