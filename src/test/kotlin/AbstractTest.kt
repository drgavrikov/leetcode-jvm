import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
abstract class AbstractTest {
    @TestFactory
    fun runDynamicTests(): Collection<DynamicTest> = dynamicTests()

    abstract fun dynamicTests(): Collection<DynamicTest>
}
