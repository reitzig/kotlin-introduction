package org.kintro.goal

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test

interface Mockable {
    fun <T> mockMe(m: T) : String
}

class Foo(val m: Mockable) {
    fun bar() : String = "${m.mockMe("me")}, Amadeus!"
}

class SomeTest {
    @Test
    fun testBar() {
        val mock = mock<Mockable> {
            on { mockMe(any<String>()) } doReturn "Mock me"
        }

        val foo = Foo(mock)
        println(foo.bar())
        verify(mock).mockMe(any<String>())
    }
}