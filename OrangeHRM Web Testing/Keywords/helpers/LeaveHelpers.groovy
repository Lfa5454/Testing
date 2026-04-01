package helpers

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class LeaveHelpers {

    void selectDropdownTwice(TestObject dropdown) {
        WebUI.click(dropdown)
        WebUI.click(dropdown)
    }

    void setDate(TestObject input, String day) {
        WebUI.click(input)
        WebUI.click(findTestObject("Page_OrangeHRM/Admin/MyInfo/div_${day}"))
    }
}