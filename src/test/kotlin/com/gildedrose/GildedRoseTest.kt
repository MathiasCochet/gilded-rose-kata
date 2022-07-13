package com.gildedrose

import com.gildedrose.items.base.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    private val initialItems = listOf(
        Item("+5 Dexterity Vest", 10, 20),
        Item("Aged Brie", 2, 0),
        Item("Elixir of the Mongoose", 5, 7),
        Item("Sulfuras, Hand of Ragnaros", 0, 80),
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
        Item("Backstage passes to a TAFKAL80ETC concert", 3, 48),
        Item("Conjured Mana Cake", 3, 6)
    )
    private val app = GildedRose()


    @Test
    fun `Test with running through 5 days with a list of items`() {
        val days = 5
        var updatedItems = initialItems.toList()

        for (i in 0 until days) {
            updatedItems = app.updateQuality(updatedItems)
        }

        //NORMAL ITEM
        assertEquals(5, updatedItems[0].sellIn)
        assertEquals(15, updatedItems[0].quality)

        //AGING ITEM
        assertEquals(-3, updatedItems[1].sellIn)
        assertEquals(5, updatedItems[1].quality)

        //NORMAL ITEM
        assertEquals(0, updatedItems[2].sellIn)
        assertEquals(2, updatedItems[2].quality)

        //LEGENDARY ITEM
        assertEquals(0, updatedItems[3].sellIn)
        assertEquals(80, updatedItems[3].quality)

        assertEquals(-1, updatedItems[4].sellIn)
        assertEquals(80, updatedItems[4].quality)

        //TICKET ITEM
        assertEquals(10, updatedItems[5].sellIn)
        assertEquals(26, updatedItems[5].quality) // (21, 22, 23, 24, 26)

        assertEquals(5, updatedItems[6].sellIn)
        assertEquals(36, updatedItems[6].quality) // (27, 29, 31, 33, 36)

        assertEquals(-2, updatedItems[7].sellIn)
        assertEquals(0, updatedItems[7].quality) // (50, 50, 50, 0, 0)

        //CONJURED ITEM
        assertEquals(-2, updatedItems[8].sellIn)
        assertEquals(0, updatedItems[8].quality) // (4, 2, 0, 0, 0)

    }

    @Test
    fun `Test with running through 10 days with a list of items`() {
        val days = 10
        var updatedItems = initialItems.toList()

        for (i in 0 until days) {
            updatedItems = app.updateQuality(updatedItems)
        }

        //NORMAL ITEM
        assertEquals(0, updatedItems[0].sellIn)
        assertEquals(10, updatedItems[0].quality)

        //AGING ITEM
        assertEquals(-8, updatedItems[1].sellIn)
        assertEquals(10, updatedItems[1].quality)

        //NORMAL ITEM
        assertEquals(-5, updatedItems[2].sellIn)
        assertEquals(0, updatedItems[2].quality)

        //LEGENDARY ITEM
        assertEquals(0, updatedItems[3].sellIn)
        assertEquals(80, updatedItems[3].quality)

        assertEquals(-1, updatedItems[4].sellIn)
        assertEquals(80, updatedItems[4].quality)

        //TICKET ITEM
        assertEquals(5, updatedItems[5].sellIn)
        assertEquals(37, updatedItems[5].quality) // (21, 22, 23, 24, 26, 28, 30, 32, 34, 37)

        assertEquals(0, updatedItems[6].sellIn)
        assertEquals(50, updatedItems[6].quality) // (27, 29, 31, 33, 36, 39, 42, 45, 48, 50)

        assertEquals(-7, updatedItems[7].sellIn)
        assertEquals(0, updatedItems[7].quality) // (50, 50, 50, 0, 0, 0, 0, 0, 0, 0)

        //CONJURED ITEM
        assertEquals(-7, updatedItems[8].sellIn)
        assertEquals(0, updatedItems[8].quality) // (4, 2, 0, 0, 0, 0, 0, 0, 0, 0)

    }

}


