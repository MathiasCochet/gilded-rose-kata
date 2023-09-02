package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.TimelessItemUpdater
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TimelessItemUpdaterTest {

    private lateinit var timelessItemUpdater: TimelessItemUpdater

    @BeforeEach
    fun setUp() {
        timelessItemUpdater = TimelessItemUpdater()
    }

    @Test
    fun `When running the updateItem function for a timeless item the sellIn should not change`() {
        val item = Item("Timeless Item", 10, 80)

        timelessItemUpdater.updateItem(item)

        assertEquals(10, item.sellIn)
    }

    @Test
    fun `When running the updateItem function for a timeless item the quality should not change`() {
        val item = Item("Timeless Item", 10, 80)

        timelessItemUpdater.updateItem(item)

        assertEquals(80, item.quality)
    }

}