package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name == NAME_AGED_BRIE || item.name == NAME_BACKSTAGE_PASSES) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name == NAME_BACKSTAGE_PASSES) {
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
            } else {
                if (item.quality > 0) {
                    if (item.name == NAME_SULFURAS) {
                    } else {
                        item.quality = item.quality - 1
                    }
                }
            }

            if (item.name == NAME_SULFURAS) {
            } else {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name == NAME_AGED_BRIE) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                } else {
                    if (item.name == NAME_BACKSTAGE_PASSES) {
                        item.quality = item.quality - item.quality
                    } else {
                        if (item.quality > 0) {
                            if (item.name == NAME_SULFURAS) {
                            } else {
                                item.quality = item.quality - 1
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val NAME_AGED_BRIE = "Aged Brie"
        private const val NAME_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

}

