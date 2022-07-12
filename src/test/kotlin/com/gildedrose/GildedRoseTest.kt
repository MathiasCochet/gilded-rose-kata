package com.gildedrose

import com.gildedrose.items.base.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayListOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        val firstItem = app.items.first()
        assertEquals("foo", firstItem.name)
    }

}


