package com.gildedrose.items

import com.gildedrose.items.base.Item
import com.gildedrose.items.base.map
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemTest {

    private val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        Item("Conjured Mana Cake", 3, 6)
    )

    @Test
    fun `Item to subclass mapper test`(){
        val mappedItemList = items.map { it.map() }
        val ticketItemCount = mappedItemList.count { it is TicketItem }
        val legendaryItemCount = mappedItemList.count{ it is LegendaryItem }

        assertEquals("+5 Dexterity Vest", mappedItemList.first().name)
        assertEquals(10, mappedItemList.first().sellIn)
        assertEquals(20, mappedItemList.first().quality)

        assertEquals(NormalItem::class.java, mappedItemList.first().javaClass)
        assertEquals(AgingItem::class.java, mappedItemList[1].javaClass)

        assertEquals(3, ticketItemCount)
        assertEquals(2, legendaryItemCount)
    }
}