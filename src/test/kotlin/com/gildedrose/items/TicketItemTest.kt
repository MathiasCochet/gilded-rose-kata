package com.gildedrose.items

import com.gildedrose.items.base.update
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TicketItemTest {
    @Test
    fun `Test if the sellIn property goes down every time the function is called`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 10, quality = 10)

        Assertions.assertEquals(10, item.sellIn)

        item.update()

        Assertions.assertEquals(9, item.sellIn)
    }

    @Test
    fun `Test that the sellIn property can go negative`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 2, quality = 10)

        Assertions.assertEquals(2, item.sellIn)

        item.update()

        Assertions.assertEquals(1, item.sellIn)

        item.update()
        item.update()

        Assertions.assertEquals(-1, item.sellIn)
    }

    @Test
    fun `Test that quality goes up by 1 if sellIn is between 50 and 10`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 30, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(11, item.quality)
    }

    @Test
    fun `Test that quality goes up by 1 if sellIn is between 10 and 5`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 9, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(12, item.quality)
    }

    @Test
    fun `Test that quality goes up by 1 if sellIn is between 5 and 0`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 4, quality = 10)

        Assertions.assertEquals(10, item.quality)

        item.update()

        Assertions.assertEquals(13, item.quality)
    }

    @Test
    fun `Test that quality can't be more than 50`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 4, quality = 49)

        Assertions.assertEquals(49, item.quality)

        item.update()

        Assertions.assertEquals(50, item.quality)
    }

    @Test
    fun `Test that quality becomes 0 if sellIn date is passed`() {
        val item = TicketItem("Backstage passes to a TAFKAL80ETC concert", 1, quality = 10)

        Assertions.assertEquals(10, item.quality)
        Assertions.assertEquals(1, item.sellIn)

        item.update()

        Assertions.assertEquals(13, item.quality)
        Assertions.assertEquals(0, item.sellIn)

        item.update()

        Assertions.assertEquals(0, item.quality)
        Assertions.assertEquals(-1, item.sellIn)
    }
}