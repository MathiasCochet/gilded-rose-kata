package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.DwindlingItemUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DwindlingItemUpdaterTest {

    private lateinit var dwindlingItemUpdater: DwindlingItemUpdater

    @BeforeEach
    fun setUp() {
        dwindlingItemUpdater = DwindlingItemUpdater()
    }

    @Test
    fun `When running the updateItem function for a dwindling item the sellIn should decrease by 1`() {
        val item = Item("Dwindling Item", 10, 10)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(9, item.sellIn)
    }

    @Test
    fun `When running the updateItem function for a dwindling item the quality should decrease by 2`() {
        val item = Item("Dwindling Item", 10, 10)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(8, item.quality)
    }

    @Test
    fun `When running the updateItem function for a dwindling item the quality should decrease up until a quality of 0 is reached`() {
        val item = Item("Dwindling Item", 10, 0)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }

    @Test
    fun `When running the updateItem function for a dwindling item the quality should decrease up until a quality of 0 is reached, even when decrease amount is less then 2`() {
        val item = Item("Dwindling Item", -1, 1)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }
}