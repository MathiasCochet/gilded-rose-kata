package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DwindlingItemUpdater : BaseItemUpdater() {
    override fun updateItem(item: Item) {
        item.quality = maxOf(item.quality - 2, MIN_QUALITY)

        super.updateItem(item)
    }
}