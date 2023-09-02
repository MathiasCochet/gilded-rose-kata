package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class AgingItemUpdater : BaseItemUpdater() {

    override fun updateItem(item: Item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1
        }

        super.updateItem(item)
    }
}