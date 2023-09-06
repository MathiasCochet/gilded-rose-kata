package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemFactory.agedItems
import com.gildedrose.itemupdaters.base.ItemFactory.dwindlingItems
import com.gildedrose.itemupdaters.base.ItemFactory.eventItems
import com.gildedrose.itemupdaters.base.ItemFactory.timelessItems
import com.gildedrose.itemupdaters.base.ItemUpdater

object ItemUpdaterFactory {

    fun getItemUpdater(item: Item): ItemUpdater {
        return when {
            agedItems.contains(item.name) -> AgingItemUpdater()
            eventItems.contains(item.name) -> EventItemUpdater()
            timelessItems.contains(item.name) -> TimelessItemUpdater()
            dwindlingItems.contains(item.name) -> DwindlingItemUpdater()
            else -> DefaultItemUpdater()
        }
    }

}