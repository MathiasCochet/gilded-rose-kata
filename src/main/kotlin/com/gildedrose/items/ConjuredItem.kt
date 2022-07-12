package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.items.base.Item
import com.gildedrose.reduceQualityBy
import com.gildedrose.reduceSellInDate
import com.gildedrose.sellInDatePassed

class ConjuredItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality), Actions {
    override fun calculateItemSellIn() {
        reduceSellInDate(this, 1)
    }

    override fun calculateItemQuality() {
        if (sellInDatePassed(sellIn)) {
            reduceQualityBy(this, 4)
        } else {
            reduceQualityBy(this, 2)
        }
    }

}