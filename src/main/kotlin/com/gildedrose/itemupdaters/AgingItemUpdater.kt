package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class AgingItemUpdater : BaseItemUpdater() {

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.quality = if (item.sellIn >= 0) {
            minOf(item.quality + 1, MAX_QUALITY)
        } else {
            minOf(item.quality + 2, MAX_QUALITY)
        }
    }
}