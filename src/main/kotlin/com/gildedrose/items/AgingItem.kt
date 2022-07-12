package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.items.base.Item
import com.gildedrose.reduceSellInDate

class AgingItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {
    override fun calculateItemSellIn() {}

    override fun calculateItemQuality() {}
}