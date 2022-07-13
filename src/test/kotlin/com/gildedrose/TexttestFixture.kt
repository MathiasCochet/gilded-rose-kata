package com.gildedrose

import com.gildedrose.items.base.Item

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = listOf(
        Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 48),
            Item("Conjured Mana Cake", 3, 6))

    val app = GildedRose()

    var days = 6
    if (args.isNotEmpty()) {
        days = Integer.parseInt(args[0]) + 1
    }


    var updatedItems = items.toList()
    for (i in 0 until days) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in updatedItems) {
            println(item)
        }
        println()
        updatedItems = app.updateQuality(updatedItems)
    }


}
