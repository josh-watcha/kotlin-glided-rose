package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            when (item.name) {
                AGED_BRIE -> {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
                BACKSTAGE_PASSES_TICKET -> {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1

                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                    }
                }
                SULFURAS -> {

                }
                else -> {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1
                    }
                }
            }

            if (item.name == SULFURAS) {

            } else {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                when (item.name) {
                    AGED_BRIE -> {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                    BACKSTAGE_PASSES_TICKET -> {
                        item.quality = item.quality - item.quality
                    }
                    SULFURAS -> {

                    }
                    else -> {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val AGED_BRIE = "Aged Brie"
        private const val BACKSTAGE_PASSES_TICKET = "Backstage passes to a TAFKAL80ETC concert"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    }
}

