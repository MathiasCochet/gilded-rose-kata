package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DwindlingItemUpdater : BaseItemUpdater() {
    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.quality = maxOf(item.quality - 2, MIN_QUALITY)
    }
}