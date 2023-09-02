package com.gildedrose.itemupdaters.base

import com.gildedrose.Item

abstract class BaseItemUpdater : ItemUpdater {

    internal companion object {
        const val MAX_QUALITY = 50
        const val MIN_QUALITY = 0
    }

    override fun updateItem(item: Item) {
        decreaseSellIn(item)
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn -= 1
    }

}