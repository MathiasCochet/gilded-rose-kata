package com.gildedrose

import com.gildedrose.items.base.Item
import com.gildedrose.items.base.map
import com.gildedrose.items.base.update

class GildedRose {
    fun updateQuality(items: List<Item>): List<Item> = items.map { item -> item.map().also { it.update() } }
}

