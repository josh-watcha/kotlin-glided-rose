package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AgedBrieItemTest {

    @Test
    fun `updateQuality 호출 시 sellIn이 0보다 크면 quality가 1 증가한다`() {
        // given
        val item = Item("Aged Brie", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(7, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 1보다 크면 quality가 1 증가한다`() {
        // given
        val item = Item("Aged Brie", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(7, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 0이면 quality가 2 증가한다`() {
        // given
        val item = Item("Aged Brie", 0, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(8, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 0보다 작으면면 quality가 2 증가한다`() {
        // given
        val item = Item("Aged Brie", -1, 6)
        val app = GildedRose(arrayOf(item))

        // when
        app.updateQuality()

        // then
        assertEquals(8, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 quality는 50보다 커지지 않는다`() {
        // given
        val item = Item("Aged Brie", -1, 50)
        val app = GildedRose(arrayOf(item))

        // when
        app.updateQuality()

        // then
        assertEquals(50, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 1 감소한다`() {
        // given
        val item = Item("Aged Brie", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(0, item.sellIn)
    }
}


