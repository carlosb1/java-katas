package katas.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testAddItem() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals("fixme", app.items[0].name);
	}

}
