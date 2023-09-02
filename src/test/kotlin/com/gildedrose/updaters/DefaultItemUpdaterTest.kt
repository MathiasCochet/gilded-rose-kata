package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.DefaultItemUpdater
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DefaultItemUpdaterTest {

    private lateinit var defaultItemUpdater: DefaultItemUpdater

    @BeforeEach
    fun setUp() {
        defaultItemUpdater = DefaultItemUpdater()
    }

    @Test
    fun `When running the updateItem function for a default item the sellIn should decrease by 1`() {
        val item = Item("Default Item", 10, 10)

        defaultItemUpdater.updateItem(item)

        Assertions.assertEquals(9, item.sellIn)
    }

    @Test
    fun `When running the updateItem function for a default item the quality should decrease by 1 when the sellIn is positive`() {
        val item = Item("Default Item", 10, 10)

        defaultItemUpdater.updateItem(item)

        Assertions.assertEquals(9, item.quality)
    }

    @Test
    fun `When running the updateItem function for a default item with a negative sellIn the quality should decrease by 2`() {
        val item = Item("Default Item", -2, 10)

        defaultItemUpdater.updateItem(item)

        Assertions.assertEquals(8, item.quality)
    }

    @Test
    fun `When running the updateItem function for a default item the quality should decrease up until a quality of 0 is reached`() {
        val item = Item("Default Item", 10, 0)

        defaultItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }

    @Test
    fun `When running the updateItem function for a default item that is past its sellIn the quality should decrease up until a quality of 0 is reached`() {
        val item = Item("Default Item", -1, 1)

        defaultItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }
}