package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            updateQuality(item)
            decreaseSellIn(item)
            updateQualityWhenSellOut(item)
        }
    }

    private fun updateQuality(item: Item) {
        when (item.name) {
            NAME_AGED_BRIE -> {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
            NAME_BACKSTAGE_PASSES -> {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }

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
            NAME_SULFURAS -> {

            }
            else -> {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }
        }
    }

    private fun decreaseSellIn(item: Item) {
        when (item.name) {
            NAME_SULFURAS -> {
            }
            else -> {
                item.sellIn = item.sellIn - 1
            }
        }
    }

    private fun updateQualityWhenSellOut(item: Item) {
        when (item.name) {
            NAME_AGED_BRIE -> {
                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
            NAME_BACKSTAGE_PASSES -> {
                if (item.sellIn < 0) {

                    item.quality = item.quality - item.quality
                }
            }
            NAME_SULFURAS -> {
            }
            else -> {
                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1
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

