class Finder {
    var base64 = ""
    fun finder(string: String) : String {
        base64 = string.substringAfter("File in base64")
        return base64
    }
}