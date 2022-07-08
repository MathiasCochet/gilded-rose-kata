package com.gildedrose

interface Actions {

    fun calculateItemSellIn(item: Item) {
        item.sellIn--
    }

    fun calculateItemQuality(item: Item) {
        if(item.sellIn > 0) {
            if(item.quality > 0) {
                item.quality--
            }
        }else {
            if(item.quality > 1) {
                item.quality -= 2
            }
        }
    }
}