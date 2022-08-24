package tech.antibytes.lib

import tech.antibytes.util.test.fulfils
import kotlin.js.JsName
import kotlin.test.Test

class ThingSpec {
    @Test
    @JsName("fn0")
    fun `A Thing exists`() {
        Thing() fulfils Any::class
    }
}
