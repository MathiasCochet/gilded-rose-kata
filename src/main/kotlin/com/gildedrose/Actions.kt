package com.gildedrose

import com.gildedrose.items.base.Item

interface Actions {
    fun calculateItemSellIn()

    fun calculateItemQuality()
}

fun reduceSellInDate(item: Item, amount: Int) {
    item.sellIn -= amount
}

fun sellInDatePassed(sellIn: Int) = sellIn < 0

//q 1 amount 2
fun reduceQualityBy(item: Item, amount: Int) {
    if(item.quality - amount >= 0) item.quality -= amount
}
fun increaseQualityBy(item: Item, amount: Int) {
    if(item.quality + amount <= 50) item.quality += amount
}