package com.gildedrose.items.base

import com.gildedrose.items.*

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}


fun Item.map(): Item{
    return when(this.name) {
        "Aged Brie" -> AgingItem(this.name, this.sellIn, this.quality)
        "Sulfuras, Hand of Ragnaros" -> LegendaryItem(this.name, this.sellIn, this.quality)
        "Backstage passes to a TAFKAL80ETC concert" -> TicketItem(this.name, this.sellIn, this.quality)
        "Conjured Mana Cake" -> ConjuredItem(this.name, this.sellIn, this.quality)
        else -> NormalItem(this.name, this.sellIn, this.quality)
    }
}
