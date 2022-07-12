package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.items.base.Item

class LegendaryItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {

    override fun calculateItemSellIn(){
        //Legendary items don't degrade.
    }

    override fun calculateItemQuality() {
        //test
    }
}