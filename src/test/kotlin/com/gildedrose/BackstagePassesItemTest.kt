package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackstagePassesItemTest {

    @Test
    fun `sellIn이 0보다 크고 6보다 작으면 quality가 3 증가한다`() {
        // given
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(9, item.quality)
    }

    @Test
    fun `sellIn이 6보다 크고 11다 작으면 quality가 2 증가한다`() {
        // given
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 8, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(8, item.quality)
    }

    @Test
    fun `sellIn이 11보다 크고 50보다 작으면 quality가 1 증가한다`() {
        // given
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 14, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(7, item.quality)
    }

    @Test
    fun `sellIn이 0이면 quality가 0이 된다`() {
        // given
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(0, item.quality)
    }

    @Test
    fun `sellIn이 0보다 작으면 quality가 0이 된다`() {
        // given
        val item = Item("Backstage passes to a TAFKAL80ETC concert", -1, 6)
        val items = arrayOf(item)
        val app = GildedRose(items)

        // when
        app.updateQuality()

        // then
        assertEquals(0, item.quality)
    }
}


