import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import pages.PIM_SearchEmployeeAndEdit

// 2.2 Job tab: set Joined Date, Job Title, Job Category, Sub Unit, Location, Employee Status; Save.

// ========== Object References ==========
PIM_SearchEmployeeAndEdit searchEmployeeAndEdit = new PIM_SearchEmployeeAndEdit()

// ============ Test Steps ===========

// 3. Open Job Tab

searchEmployeeAndEdit.openMenu("job")

// 4. Set Joined Date
searchEmployeeAndEdit.setJoinedDate(GlobalVariable.joinDate) 

// 5. Select Job Title
searchEmployeeAndEdit.selectOption("jobtitle",GlobalVariable.jobTitle)

// 6. Select Job Title
searchEmployeeAndEdit.selectOption("jobtitle",GlobalVariable.jobCategory)
// 7. Save changes
searchEmployeeAndEdit.clickButton("save")

// ============ Validation ===========
searchEmployeeAndEdit.verifyNotification("update")