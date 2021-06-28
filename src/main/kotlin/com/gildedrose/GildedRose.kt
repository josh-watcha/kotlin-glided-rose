package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != SULFURAS) {
                item.decreaseItemSellIn(1)
            }
            
            when (item.name) {
                AGED_BRIE -> {
                    item.increaseItemQuality(1)
                }
                BACKSTAGE_PASSES_TICKET -> {
                    val increaseQuality = when {
                        item.sellIn < 6 -> 3
                        item.sellIn < 11 -> 2
                        else -> 1
                    }

                    item.increaseItemQuality(increaseQuality)
                }
                SULFURAS -> {

                }
                else -> {
                    item.decreaseItemQuality(1)
                }
            }


            val isNotRemainingSellIn = item.sellIn < 0
            if (isNotRemainingSellIn) {
                when (item.name) {
                    AGED_BRIE -> {
                        item.increaseItemQuality(1)
                    }
                    BACKSTAGE_PASSES_TICKET -> {
                        item.resetQuality()
                    }
                    SULFURAS -> {

                    }
                    else -> {
                        item.decreaseItemQuality(1)
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

