import Main.Properties
import org.slf4j.LoggerFactory
import java.io.File

class Manager(properties: Properties) {
    private val logger = LoggerFactory.getLogger(javaClass)

    private val pathForInputLogs = properties.pathForInputLogs
    private val pathForOutputFiles = properties.pathForOutputFiles
    final var fileNameLength = 20

    fun start(): Int {

        logger.info("Start program")

        if (!inputDataChecker(pathForInputLogs, pathForOutputFiles)) {
            return -1
        }
        var stringsCounter = 1

        val listOfBase64Elements = mutableMapOf<Int, String>()
        val logFile = File(pathForInputLogs).readLines()
        var currentString: String?
        logFile.forEach {
            currentString = Reader().reader(it)
            if (currentString != null) {
                listOfBase64Elements[stringsCounter] = currentString!!
            }
            stringsCounter++
        }
        var counterOfIncorrectFiles = 0
        for (element in listOfBase64Elements) {
            val base64 = Finder().finder(element.value)
            var fileName = ""
            for (j in 0..element.value.length) {
                if (element.value[j] == ' ') {
                    fileName = element.value.substring(j + 1, j + fileNameLength)
                    break
                }
            }

            if (Creator().creator(pathForOutputFiles, fileName, base64) == 1){
                counterOfIncorrectFiles++
                println("Wrong log at string: ${element.key}")
            }
        }
        return counterOfIncorrectFiles
    }


    private fun inputDataChecker(pathForInputLogs: String, pathForOutputFiles: String): Boolean {
        fun isFileExists(file: File): Boolean {
            return file.exists() && file.isFile
        }

        fun isDirectoryExists(file: File): Boolean {
            return file.exists() && file.isDirectory
        }

        val file = File(pathForInputLogs)
        val directory = File(pathForOutputFiles)
        if (isFileExists(file) && isDirectoryExists(directory)) {
            return true
        }
        return false
    }

}