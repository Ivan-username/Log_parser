import Main.Reader
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun main() {
        val app = Reader();
        app.reader()
    }
}