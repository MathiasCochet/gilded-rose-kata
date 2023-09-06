package com.gildedrose

import com.gildedrose.itemupdaters.ItemUpdaterFactory

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            val itemUpdater = ItemUpdaterFactory.getItemUpdater(item)
            itemUpdater.updateItem(item)
        }
    }

}

