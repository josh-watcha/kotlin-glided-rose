package com.gildedrose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Aged Brie의 sellIn이 0보다 크면 updateQuality 호출 시 quality가 1 증가한다`() {
        val originQuality = 2
        val additionalQuality = 1
        val item = Item("Aged Brie", 1, originQuality)

        // 업데이트를 한다는 의미에 집중 GildedRose 생성하여 호출한다는 의미가 이부분에 필요할까 싶었음
//        GildedRose(arrayOf(item)).updateQuality()
        updateQuality(item)

        //
        assertEquals(originQuality + additionalQuality, item.quality)
    }

    @Test
    fun `Aged Brie의 sellIn이 0보다 작거나 같으면 updateQuality 호출 시 quality가 2 증가한다`() {
        val originQuality = 2
        val additionalQuality = 2
        val item = Item("Aged Brie", 0, originQuality)

        updateQuality(item)

        //  호출 시 quality가 2 증가한다 라는 의미를 additionalQuality 고정 값으로 표현해봄
        assertEquals(originQuality + additionalQuality, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 sellIn이 0보다 작거나 같으면 updateQuality 호출 시 quality가 0이된다`() {
        val originQuality = 999

        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0, originQuality)

        updateQuality(item)

        //  호출 시 quality가 2 증가한다 라는 의미를 additionalQuality 고정 값으로 표현해봄
        assertEquals(0, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 quality가 49보다 작고 sellIn이 0보다 크고 6보다 작으면 updateQuality 호출 시 quality가 3 증가한다`() {
        val originQuality = 2
        val additionalQuality = 3
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 3, originQuality)

        updateQuality(item)

        //  호출 시 quality가 2 증가한다 라는 의미를 additionalQuality 고정 값으로 표현해봄
        assertEquals(originQuality + additionalQuality, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 quality가 49보다 작고 sellIn이 5보다 크고 11보다 작으면 updateQuality 호출 시 quality가 2 증가한다`() {
        val originQuality = 2
        val additionalQuality = 2
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 6, originQuality)

        updateQuality(item)

        //  호출 시 quality가 2 증가한다 라는 의미를 additionalQuality 고정 값으로 표현해봄
        assertEquals(originQuality + additionalQuality, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 quality가 50보다 작고 sellIn이 11보다 크면 updateQuality 호출 시 quality가 1 증가한다`() {
        val originQuality = 49
        val additionalQuality = 1
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 11, originQuality)

        updateQuality(item)

        assertEquals(originQuality + additionalQuality, item.quality)
    }


    // quality == 49, quality > 49
    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 quality가 49이면 updateQuality 호출 시 quality가 1 증가한다`() {
        val originQuality = 49
        val additionalQuality = 1
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 6, originQuality)

        updateQuality(item)

        assertEquals(originQuality + additionalQuality, item.quality)
    }

    @Test
    fun `Backstage passes to a TAFKAL80ETC concert의 quality가 50보다 같거나 크면 updateQuality 호출 시 quality 50을 넘을 수 없다`() {
        val originQuality = 50
        val additionalQuality = 0
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 6, originQuality)

        updateQuality(item)

        assertEquals(originQuality + additionalQuality, item.quality)
    }

    private fun updateQuality(item: Item) {
        GildedRose(arrayOf(item)).updateQuality()
    }
}