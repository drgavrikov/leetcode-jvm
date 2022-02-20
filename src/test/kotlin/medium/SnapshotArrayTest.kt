package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class SnapshotArrayTest : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {

        return listOf(
            DynamicTest.dynamicTest("test1") {
                val snapshotArray = SnapshotArray(3)
                snapshotArray.set(0, 5)
                Assertions.assertThat(snapshotArray.snap()).isEqualTo(0)
                snapshotArray.set(0, 6)
                Assertions.assertThat(snapshotArray.snap()).isEqualTo(1)
                snapshotArray.set(1, 7)
                Assertions.assertThat(snapshotArray.get(0, 0)).isEqualTo(5)
                Assertions.assertThat(snapshotArray.snap()).isEqualTo(2)
                snapshotArray.set(2, 10)
                Assertions.assertThat(snapshotArray.get(1, 2)).isEqualTo(7)
                Assertions.assertThat(snapshotArray.snap()).isEqualTo(3)
            },
        )
    }
}
