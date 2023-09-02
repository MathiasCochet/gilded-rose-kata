package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class AgingItemUpdater : BaseItemUpdater() {

    override fun updateItem(item: Item) {
        super.updateItem(item)

        if (item.quality < MAX_QUALITY) {
            item.quality += 1
        }
    }
}