package hard

fun runDynamicTest(name: String, test: () -> Unit) {
    try {
        test()
        println("Test $name passed")
    } catch (e: AssertionError) {
        println("Test $name failed: ${e.message}")
    }
}
