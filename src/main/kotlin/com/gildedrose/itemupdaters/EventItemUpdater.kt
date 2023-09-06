package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class EventItemUpdater : BaseItemUpdater() {
    override fun updateItem(item: Item) {
        super.updateItem(item)

        when {
            item.sellIn < 0 -> item.quality = MIN_QUALITY
            item.sellIn < 5 -> item.quality = minOf(item.quality + 3, MAX_QUALITY)
            item.sellIn < 10 -> item.quality = minOf(item.quality + 2, MAX_QUALITY)
            else -> item.quality = minOf(item.quality + 1, MAX_QUALITY)
        }

    }
}