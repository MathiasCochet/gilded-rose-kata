package com.gildedrose.itemupdaters

import com.gildedrose.Item

abstract class BaseItemUpdater : ItemUpdater {

    override fun updateItem(item: Item) {
        decreaseSellIn(item)
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn -= 1
    }

}