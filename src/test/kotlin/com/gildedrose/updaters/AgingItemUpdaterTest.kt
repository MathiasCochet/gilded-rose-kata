package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.AgingItemUpdater
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AgingItemUpdaterTest {

    private lateinit var agingItemUpdater: AgingItemUpdater

    @BeforeEach
    fun setUp() {
        agingItemUpdater = AgingItemUpdater()
    }

    @Test
    fun `When running the updateItem function for an aging item the sellIn should decrease by 1`() {
        val item = Item("Aging Item", 10, 10)

        agingItemUpdater.updateItem(item)

        assertEquals(9, item.sellIn)
    }

    @Test
    fun `When running the updateItem function for an aging item the quality should increase by 1`() {
        val item = Item("Aging Item", 10, 10)

        agingItemUpdater.updateItem(item)

        assertEquals(11, item.quality)
    }

    @Test
    fun `When running the updateItem function for an aging item with a negative sellIn the quality should  increase by 2`() {
        val item = Item("Aging Item", -2, 10)

        agingItemUpdater.updateItem(item)

        assertEquals(12, item.quality)
    }

    @Test
    fun `When running the updateItem function for an aging item with a negative sellin the quality should increase by 2 up until a quality of 50 is reached`() {
        val item = Item("Aging Item", -2, 49)

        agingItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When running the updateItem function for an aging item the quality should increase by 1 up until a quality of 50 is reached`() {
        val item = Item("Aging Item", 10, 50)

        agingItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

}