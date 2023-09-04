package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.*
import com.gildedrose.itemupdaters.base.ItemType
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ItemUpdaterFactoryTest {

    @Test
    fun `When an item is Aged brie the AgingItemUpdater should be returned`() {
        val item = Item(ItemType.AGED_BRIE, 10, 10)

        val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)

        assertTrue(itemUpdater is AgingItemUpdater)
    }

    @Test
    fun `When an item is a Backstage pass the EventItemUpdater should be returned`() {
        val item = Item(ItemType.BACKSTAGE_PASSES, 10, 10)

        val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)

        assertTrue(itemUpdater is EventItemUpdater)
    }

    @Test
    fun `When an item is Sulfuras the TimelessItemUpdater should be returned`() {
        val item = Item(ItemType.SULFURAS, 10, 10)

        val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)

        assertTrue(itemUpdater is TimelessItemUpdater)
    }

    @Test
    fun `When an item is a Conjured item the DwindlingItemUpdater should be returned`() {
        val item = Item(ItemType.CONJURED, 10, 10)

        val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)

        assertTrue(itemUpdater is DwindlingItemUpdater)
    }

    @Test
    fun `When an item is an unknown item the DefaultItemUpdater should be returned`() {
        val item = Item("Default Item", 10, 10)

        val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)

        assertTrue(itemUpdater is DefaultItemUpdater)
    }

}