package katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testAddItem() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 0, 0));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals("foo", app.items.get(0).name);
	}

	@Test
	public void testAddItemDecrementDoubleQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 0, 5));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(3, app.items.get(0).quality);
	}

	@Test
	public void testAddMultipleItemsUpdateQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 1, 1));
				add(new Item("foo", 1, 2));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items.get(0).quality);
		Assert.assertEquals(1, app.items.get(1).quality);
	}

	@Test
	public void testUpdateQualityDecrementQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 3, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(2, app.items.get(0).quality);
	}

	@Test
	public void testUpdateQualityInDecrementSellIn() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 3, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(2, app.items.get(0).sellIn);
	}

	@Test
	public void testUpdateQualityInDecrementDoubleQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 0, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(1, app.items.get(0).quality);
	}

	@Test
	public void testUpdateQualityNotNegativeQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("foo", 0, 0));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items.get(0).quality);
	}

	@Test
	public void testAddAgedBrieUpdateQualityIncrementQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Aged Brie", 0, 2));
			}
		};
		GildedRose app = new GildedRose(items);
		// triangule values
		app.updateQuality();
		Assert.assertEquals(4, app.items.get(0).quality);
		app.updateQuality();
		Assert.assertEquals(6, app.items.get(0).quality);
	}

	@Test
	public void testAddAgedBrieUpdateQualityGreaterFiftyIsNotAdded() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Aged Brie", 1, 50));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(0, app.items.get(0).sellIn);
		Assert.assertEquals(50, app.items.get(0).quality);
	}

	@Test
	public void testSulfurasUpdateQualityNotDecrement() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Sulfuras, Hand of Ragnaros", 1, 40));
			}
		};

		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(1, app.items.get(0).sellIn);
		Assert.assertEquals(40, app.items.get(0).quality);

	}

	@Test
	public void testBackstagePassesUpdateQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 40));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(43, app.items.get(0).quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityNotIncrement() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(50, app.items.get(0).quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Backstage passes to a TAFKAL80ETC concert", 17, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(4, app.items.get(0).quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementDoubleQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(5, app.items.get(0).quality);
	}

	@Test
	public void testBackstagePassesUpdateQualityIncrementTripleQuality() {
		List<Item> items = new ArrayList<Item>() {
			{
				add(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 3));
			}
		};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals(6, app.items.get(0).quality);
	}

}
