package katas.com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		Assert.assertEquals("foo", app.items[0].name);
	}

}
