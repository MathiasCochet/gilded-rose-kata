package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DefaultItemUpdater : BaseItemUpdater() {
    override fun updateItem(item: Item) {
        item.quality = if (item.sellIn >= 0) {
            maxOf(item.quality - 1, MIN_QUALITY)
        } else {
            maxOf(item.quality - 2, MIN_QUALITY)
        }

        super.updateItem(item)
    }
}