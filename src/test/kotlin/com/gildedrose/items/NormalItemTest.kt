package com.gildedrose.items

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NormalItemTest {

    @Test
    fun `Test if the sellIn property goes down every time the function is called`() {
        val item = NormalItem("Normal Item", 10, quality = 10)

        assertEquals(10, item.sellIn)

        item.calculateItemSellIn()

        assertEquals(9, item.sellIn)
    }

    @Test
    fun `Test that the sellIn property can go negative`() {
        val item = NormalItem("Normal Item", 2, quality = 10)

        assertEquals(2, item.sellIn)

        item.calculateItemSellIn()

        assertEquals(1, item.sellIn)

        item.calculateItemSellIn()
        item.calculateItemSellIn()

        assertEquals(-1, item.sellIn)
    }

    @Test
    fun `Test if quality reduces by one if sellIn is positive`() {
        val item = NormalItem("Normal Item", 10, quality = 10)

        assertEquals(10, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        assertEquals(9, item.quality)
    }

    @Test
    fun `Test if quality is reduced by 2 if sellIn is negative`() {
        val item = NormalItem("Normal Item", -1, quality = 10)

        assertEquals(10, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        assertEquals(8, item.quality)
    }

    @Test
    fun `Test if sellIn reaches 0, the quality only reduces by 1`() {
        val item = NormalItem("Normal Item", 1, quality = 10)

        assertEquals(10, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        assertEquals(9, item.quality)
    }

    @Test
    fun `Test if quality does not become negative`() {
        val item = NormalItem("Normal Item", -1, quality = 2)

        assertEquals(2, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        assertEquals(0, item.quality)

        item.calculateItemSellIn()
        item.calculateItemQuality()

        assertEquals(0, item.quality)
    }
}