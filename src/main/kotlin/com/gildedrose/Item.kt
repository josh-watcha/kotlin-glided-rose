package com.gildedrose

import kotlin.math.max
import kotlin.math.min

data class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int
) {

    fun resetQuality() {
        quality = 0
    }

    fun decreaseItemQuality(decreaseQuality: Int) {
        quality = max(quality - decreaseQuality, MIN_QUALITY)
    }

    fun increaseItemQuality(increaseQuality: Int) {
        quality = min(quality + increaseQuality, MAX_QUALITY)
    }

    fun decreaseItemSellIn(decreaseSellIn: Int) {
        sellIn -= decreaseSellIn
    }

    companion object {
        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 50
    }
}