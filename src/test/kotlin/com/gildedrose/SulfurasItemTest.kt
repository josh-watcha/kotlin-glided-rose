package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SulfurasItemTest {

    @Test
    fun `updateQuality 호출이 되더라도 quality가 변하지 않는다`() {
        // given
        val item = Item("Sulfuras, Hand of Ragnaros", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(6, item.quality)
    }

    @Test
    fun `updateQuality 호출이 되더라도 sellIn이 변하지 않는다`() {
        // given
        val item = Item("Sulfuras, Hand of Ragnaros", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(1, item.sellIn)
    }
}


