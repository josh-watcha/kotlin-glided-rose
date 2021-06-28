package com.gildedrose

class GildedRose(private val items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            val originalSellIn = item.sellIn

            if (item.name != SULFURAS) {
                item.decreaseItemSellIn(1)
            }

            val isNotRemainingSellIn = item.sellIn < 0

            when (item.name) {
                AGED_BRIE -> {
                    val increaseQuality = if (isNotRemainingSellIn) 2 else 1
                    item.increaseItemQuality(increaseQuality)
                }
                BACKSTAGE_PASSES_TICKET -> {
                    when {
                        isNotRemainingSellIn -> item.resetQuality()
                        originalSellIn < 6 -> item.increaseItemQuality(3)
                        originalSellIn in 6..10 -> item.increaseItemQuality(2)
                        else -> item.increaseItemQuality(1)
                    }
                }
                SULFURAS -> {

                }
                else -> {
                    val decreaseQuality = if (isNotRemainingSellIn) 2 else 1
                    item.decreaseItemQuality(decreaseQuality)
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

