package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            when (item.name) {
                AGED_BRIE -> {
                    item.increaseItemQuality()
                }
                BACKSTAGE_PASSES_TICKET -> {
                    item.increaseItemQuality()

                    if (item.sellIn < 11) {
                        item.increaseItemQuality()
                    }
                    if (item.sellIn < 6) {
                        item.increaseItemQuality()
                    }
                }
                SULFURAS -> {

                }
                else -> {
                    item.decreaseItemQuality()
                }
            }

            if (item.name == SULFURAS) {

            } else {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                when (item.name) {
                    AGED_BRIE -> {
                        item.increaseItemQuality()
                    }
                    BACKSTAGE_PASSES_TICKET -> {
                        item.resetQuality()
                    }
                    SULFURAS -> {

                    }
                    else -> {
                        item.decreaseItemQuality()
                    }
                }
            }
        }
    }


    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASSES_TICKET = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    }
}

