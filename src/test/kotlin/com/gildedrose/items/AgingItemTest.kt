package com.gildedrose.items

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AgingItemTest {
    @Test
    fun `Test if the sellIn property goes down every time the function is called`() {
        val item = AgingItem("Aging Brie", 10, quality = 10)

        Assertions.assertEquals(10, item.sellIn)

        item.calculateItemSellIn()

        Assertions.assertEquals(9, item.sellIn)
    }

    @Test
    fun `Test that the sellIn property can go negative`() {
        val item = AgingItem("Aging Brie", 2, quality = 10)

        Assertions.assertEquals(2, item.sellIn)

        item.calculateItemSellIn()

        Assertions.assertEquals(1, item.sellIn)

        item.calculateItemSellIn()
        item.calculateItemSellIn()

        Assertions.assertEquals(-1, item.sellIn)
    }


    @Test
    fun `Test if aging item increases in price with time`() {
        val item = AgingItem("Aging Brie", 10, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        Assertions.assertEquals(1, item.quality)
    }

    @Test
    fun `Test if aging can't increase over a quality of 50`() {
        val item = AgingItem("Aging Brie", 10, quality = 49)

        Assertions.assertEquals(49, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        Assertions.assertEquals(50, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        Assertions.assertEquals(50, item.quality)
    }



}