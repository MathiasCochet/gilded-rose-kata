package com.gildedrose.items

import com.gildedrose.Actions
import com.gildedrose.increaseQualityBy
import com.gildedrose.items.base.Item
import com.gildedrose.reduceSellInDate

class TicketItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality), Actions {
    override fun calculateItemSellIn() {
        reduceSellInDate(this, 1)
    }

    override fun calculateItemQuality() {
        if (sellIn < 0) quality = 0
        else increaseQualityBy(this, calculateIncrement());
    }

    private fun calculateIncrement(): Int {
        return when {
            sellIn > 10 -> 1
            sellIn in 10 downTo 6 -> 2
            sellIn in 5 downTo 0 -> 3
            else -> throw IllegalStateException("This function cannot be called with a negative sellIn value");
        }
    }
}