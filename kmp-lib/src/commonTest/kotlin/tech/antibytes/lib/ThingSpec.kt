package tech.antibytes.lib

import tech.antibytes.kmock.KMock
import tech.antibytes.kmock.KMockExperimental
import tech.antibytes.kmock.verification.verify
import kotlin.js.JsName
import kotlin.test.Test
import tech.antibytes.util.test.mustBe

@OptIn(KMockExperimental::class)
@KMock(Dependency::class)
class ThingSpec {
    @Test
    @JsName("fn0")
    fun `A Thing exists`() {
        // Given
        val mock: DependencyMock = kmock()
        mock._doSomethingElse returns "jada"

        val subjectUnderTest = Thing(mock)

        // When
        val actual = subjectUnderTest.doSomething()

        // Then
        actual mustBe 42
        verify {
            mock._doSomethingElse.hasBeenCalled()
        }
    }
}
