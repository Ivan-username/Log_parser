import Main.Properties
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun main() {
        Manager(Properties("text.txt", System.getProperty("java.io.tmpdir"))).start()
    }
}