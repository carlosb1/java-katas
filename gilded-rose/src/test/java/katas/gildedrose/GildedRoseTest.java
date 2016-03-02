package katas.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testAddItem() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals("foo", app.items[0].name);
	}

	@Test
	public void testAddItemDecrementDoubleQuality() {
		Item[] items = new Item[] { new Item("foo", 0, 5) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(3, app.items[0].quality);
	}

	@Test
	public void testAddMultipleItemsUpdateQuality() {
		Item[] items = new Item[] { new Item("foo", 1, 1), new Item("foo", 1, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items[0].quality);
		Assert.assertEquals(1, app.items[1].quality);
	}

	@Test
	public void testUpdateQualityDecrementQuality() {
		Item[] items = new Item[] { new Item("foo", 3, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(2, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityInDecrementSellIn() {
		Item[] items = new Item[] { new Item("foo", 3, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(2, app.items[0].sellIn);
	}

	@Test
	public void testUpdateQualityInDecrementDoubleQuality() {
		Item[] items = new Item[] { new Item("foo", 0, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(1, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityNotNegativeQuality() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items[0].quality);
	}

	@Test
	public void testAddAgedBrieUpdateQualityIncrementQuality() {
		Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
		GildedRose app = new GildedRose(items);
		// triangule values
		app.updateQuality();
		Assert.assertEquals(4, app.items[0].quality);
		app.updateQuality();
		Assert.assertEquals(6, app.items[0].quality);
	}

	@Test
	public void testAddAgedBrieUpdateQualityGreaterFiftyIsNotAdded() {
		Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items[0].sellIn);
		Assert.assertEquals(50, app.items[0].quality);
	}

	@Test
	public void testSulfurasUpdateQualityNotDecrement() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(1, app.items[0].sellIn);
		Assert.assertEquals(40, app.items[0].quality);

	}

	@Test
	public void testBackstagePassesUpdateQuality() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 40) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(43, app.items[0].quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityNotIncrement() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(50, app.items[0].quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementQuality() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 17, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(4, app.items[0].quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementDoubleQuality() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementTripleQuality() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(6, app.items[0].quality);
	}

}
