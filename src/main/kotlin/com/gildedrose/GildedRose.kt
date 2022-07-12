package com.gildedrose

import com.gildedrose.items.base.Item
import com.gildedrose.items.base.update

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }
}

