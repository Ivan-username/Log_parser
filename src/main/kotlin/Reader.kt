class Reader {
    fun reader(currentString: String) : String?{
        if (currentString.contains("File in base64")) {
            return currentString
        }
        return null
    }
}