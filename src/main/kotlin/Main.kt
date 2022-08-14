package Main

import Manager

class Properties(var pathForInputLogs: String, var pathForOutputFiles: String) {
}

fun main() {
    val pathForInputLogs = "M:\\tasks\\task_01_20220804_log_parser\\log.txt"
    // каталог писать в конце
    val pathForOutputFiles = "M:\\tasks\\output_files"

    val properties = Properties(pathForInputLogs, pathForOutputFiles)


    val exitCode = Manager(properties).start()
    println()
    if (exitCode == -1) {
        println("Wrong paths or path")
    } else {
        println("Successful")
        println("Wrong logs = $exitCode")
    }
}




