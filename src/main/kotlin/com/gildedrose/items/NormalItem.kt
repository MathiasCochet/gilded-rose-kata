package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.items.base.Item

class NormalItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {
    override fun calculateItemSellIn() {
        sellIn--
    }

    override fun calculateItemQuality(item: Item) {
        TODO("Not yet implemented")
    }
}