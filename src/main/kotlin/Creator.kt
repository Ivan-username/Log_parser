import java.io.File
import java.util.Base64

class Creator {
    fun creator(pathForOutputFiles: String, fileName: String, base64: String) : Int{
        val path = "${pathForOutputFiles}\\${fileName.replace(' ', '_').replace(":", "")}.txt"
        val file = File(path)
        val decoder: Base64.Decoder = Base64.getDecoder()
        val bytes: ByteArray
        try {
            bytes = decoder.decode(base64.trim())
        } catch (e: Exception){
            println(e)
            return 1
        }
        file.createNewFile()
        file.writeBytes(bytes)
        return 0
    }
}