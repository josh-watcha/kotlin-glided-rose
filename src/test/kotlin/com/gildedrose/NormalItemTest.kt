package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NormalItemTest {

    @Test
    fun `updateQuality 호출 시 sellIn이 0보다 크면 quality가 1 감소한다`() {
        // given
        val name = "normal"
        val item = Item(name, 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(5, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 0이면 quality가 2 감소한다`() {
        // given
        val name = "normal"
        val item = Item(name, 0, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(4, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 0보다 작으면 quality가 2 감소한다`() {
        // given
        val name = "normal"
        val item = Item(name, -1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(4, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 quality가 0이면 quality가 감소하지 않는다`() {
        // given
        val name = "normal"
        val item = Item(name, 5, 0)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(0, item.quality)
    }

    @Test
    fun `updateQuality 호출 시 sellIn이 1 감소한다`() {
        // given
        val item = Item("normal", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(0, item.sellIn)
    }
}


