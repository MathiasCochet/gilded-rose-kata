package com.gildedrose.items

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class LegendaryItemTest {
    @Test
    fun `Test if legendary item sellIn date does not increase or decrease`() {
        val item = LegendaryItem("Sulfuras, Hand of Ragnaros", 1, quality = 80)

        Assertions.assertEquals(1, item.sellIn)

        item.calculateItemSellIn()

        Assertions.assertEquals(1, item.sellIn)
    }

    @Test
    fun `Test if legendary item quality never changes and is always 80`() {
        val item = LegendaryItem("Sulfuras, Hand of Ragnaros", 1, quality = 80)

        Assertions.assertEquals(80, item.quality)

        item.calculateItemSellIn()

        Assertions.assertEquals(80, item.quality)
    }

}