package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.Item

class LegendaryItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {

    override fun calculateItemSellIn(item: Item){
        //Legendary items don't degrade.
    }

    override fun calculateItemQuality(item: Item) {
        //test
    }
}