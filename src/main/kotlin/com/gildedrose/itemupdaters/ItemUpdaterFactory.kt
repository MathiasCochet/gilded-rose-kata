package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemType
import com.gildedrose.itemupdaters.base.ItemUpdater

object ItemUpdaterFactory {

    fun getItemUpdater(item: Item): ItemUpdater {
        return when (item.name) {
            ItemType.AGED_BRIE -> AgingItemUpdater()
            ItemType.BACKSTAGE_PASSES -> EventItemUpdater()
            ItemType.SULFURAS -> TimelessItemUpdater()
            ItemType.CONJURED -> DwindlingItemUpdater()
            else -> DefaultItemUpdater()
        }
    }

}