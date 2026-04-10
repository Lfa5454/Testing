package config

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

@Keyword
class ConfigLoader {

	/**
	 * Loads configuration values from a CSV file and assigns them to GlobalVariable.
	 *
	 * @param csvPath Relative path to the CSV file
	 */
	static void loadFromCsv(String csvPath) {

		def csvFile = new File(csvPath)

		if (!csvFile.exists()) {
			KeywordUtil.markFailedAndStop(
				"Config CSV not found at path: ${csvPath}"
			)
		}

		def lines = csvFile.readLines()
		lines.remove(0) // remove header (key,value)

		lines.each { line ->
			def (key, value) = line.split(",", 2)

			if (key && value) {
				GlobalVariable."${key}" = value
				KeywordUtil.logInfo(
					"✅ GlobalVariable.${key} set from CSV"
				)
			}
		}
	}
}