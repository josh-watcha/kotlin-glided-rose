package com.gildedrose

data class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int
) {

    fun resetQuality() {
        quality = 0
    }

    fun decreaseItemQuality() {
        if (quality > MIN_QUALITY) {
            quality -= 1
        }
    }

    fun increaseItemQuality() {
        if (quality < MAX_QUALITY) {
            quality += 1
        }
    }

    companion object {
        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 1
    }
}