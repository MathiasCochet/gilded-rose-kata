package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.Item

class ConjuredItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {

    override fun calculateItemQuality(item: Item) {
        //calc
    }

}