package base

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

class BasePage {

    void click(TestObject to) {
        WebUI.waitForElementClickable(to, 10)
        WebUI.click(to)
    }

    void type(TestObject to, String text) {
        WebUI.waitForElementVisible(to, 10)
        WebUI.setText(to, text)
    }

    void waitVisible(TestObject to) {
        WebUI.waitForElementVisible(to, 10)
    }

    void log(String message) {
        KeywordUtil.logInfo(message)
    }
}