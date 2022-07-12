package com.gildedrose

import com.gildedrose.items.base.Item
import com.gildedrose.items.base.map

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayListOf(
        Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 48),
            Item("Conjured Mana Cake", 3, 6))

    val mappedItems = items.map { it.map() }
    val app = GildedRose(mappedItems)

    var days = 6
    if (args.isNotEmpty()) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0 until days) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in mappedItems) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}
