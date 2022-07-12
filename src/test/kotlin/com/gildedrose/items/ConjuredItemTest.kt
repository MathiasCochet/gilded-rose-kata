package com.gildedrose.items

import com.gildedrose.items.base.update
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredItemTest {
    @Test
    fun `Test if the sellIn property goes down every time the function is called`() {
        val item = ConjuredItem("Conjured Mana Cake", 10, quality = 10)

        Assertions.assertEquals(10, item.sellIn)

        item.update()

        Assertions.assertEquals(9, item.sellIn)
    }

    @Test
    fun `Test that the sellIn property can go negative`() {
        val item = AgingItem("Conjured Mana Cake", 2, quality = 10)

        Assertions.assertEquals(2, item.sellIn)

        item.update()

        Assertions.assertEquals(1, item.sellIn)

        item.update()
        item.update()

        Assertions.assertEquals(-1, item.sellIn)
    }

    @Test
    fun `Test if quality reduces by two if sellIn is positive`() {
        val item = AgingItem("Conjured Mana Cake", 2, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(8, item.quality)
    }

    @Test
    fun `Test if quality is reduced by 4 if sellIn is negative`() {
        val item = AgingItem("Conjured Mana Cake", -1, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(6, item.quality)
    }

    @Test
    fun `Test if sellIn reaches 0, the quality only reduces by 2`() {
        val item = AgingItem("Conjured Mana Cake", 1, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(8, item.quality)
    }

    @Test
    fun `Test if quality does not become negative`() {
        val item = AgingItem("Conjured Mana Cake", -1, quality = 4)

        Assertions.assertEquals(4, item.quality)

        item.update()

        Assertions.assertEquals(0, item.quality)

        item.update()

        Assertions.assertEquals(0, item.quality)
    }

}