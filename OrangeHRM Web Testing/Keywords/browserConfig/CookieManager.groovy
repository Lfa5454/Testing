package browserConfig

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver

class CookieManager {

	@Keyword
	def saveCookiesToFile(String filePath) {
		File file = new File(filePath)
		if (!file.exists()) {
			file.parentFile.mkdirs()   // create folder if missing
			file.createNewFile()       // create empty file
		}
		WebDriver driver = DriverFactory.getWebDriver()
		Set<Cookie> cookies = driver.manage().getCookies()
		file.withWriter { writer ->
			cookies.each { cookie ->
				writer.writeLine("${cookie.getName()}=${cookie.getValue()}")
			}
		}
	}



	@Keyword
	def loadCookiesFromFile(String filePath) {
		File file = new File(filePath)
		if (!file.exists()) {
			println "Cookie file not found, creating empty file..."
			file.parentFile.mkdirs()
			file.createNewFile()
			return
		}
		// lógica para leer cookies...
	}
}