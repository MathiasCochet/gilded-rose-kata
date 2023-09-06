package com.gildedrose.updaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.EventItemUpdater
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EventItemUpdaterTest {

    private lateinit var eventItemUpdater: EventItemUpdater

    @BeforeEach
    fun setUp() {
        eventItemUpdater = EventItemUpdater()
    }

    @Test
    fun `When running the updateItem function for an event item the sellIn should decrease by 1`() {
        val item = Item("Event Item", 10, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(9, item.sellIn)
    }

    @Test
    fun `When running the updateItem function for an event item and the sellIn is above 10 days the quality should increase by 1`() {
        val item = Item("Event Item", 11, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(11, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the sellIn is within 10 days the quality should increase by 2`() {
        val item = Item("Event Item", 11, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(11, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(13, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the sellIn is within 5 days the quality should increase by 3`() {
        val item = Item("Event Item", 6, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(12, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(15, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the sellIn is below 0 the quality should be 0`() {
        val item = Item("Event Item", 1, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(0, item.sellIn)
        assertEquals(13, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the and the sellIn is above 10 days should not increase by above 50`() {
        val item = Item("Event Item", 11, 50)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the and the sellIn is within 10 days should not increase by above 50`() {
        val item = Item("Event Item", 9, 49)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When running the updateItem function for an event item and the and the sellIn is within 5 days should not increase by above 50`() {
        val item = Item("Event Item", 4, 49)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

}