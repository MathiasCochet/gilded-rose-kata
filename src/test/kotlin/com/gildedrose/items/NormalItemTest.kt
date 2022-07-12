package com.gildedrose.items

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NormalItemTest {

    @Test
    fun `test if sell in progresses the amount of days`() {
        val item = NormalItem("Normal Item", 10, quality = 10)

        assertEquals(10, item.sellIn)

        item.calculateItemSellIn()

        assertEquals(9, item.sellIn)
    }

}