package com.gildedrose

import com.gildedrose.items.base.Item

interface Actions {
    fun calculateItemSellIn()

    fun calculateItemQuality(item: Item)
}