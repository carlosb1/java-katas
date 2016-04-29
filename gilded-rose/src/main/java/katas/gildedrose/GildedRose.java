package katas.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private final List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public GildedRose(Item[] items) {
		this(Arrays.asList(items));
	}

	public GildedRose(List<Item> items) {
		this();
		for (Item item : items) {
			this.items.add(item);
		}
	}

	public GildedRose() {
		this.items = new ArrayList<Item>();
	}

	public GildedRose addItem(Item item) {
		this.items.add(item);
		return this;
	}

	public void updateQuality() {
		for (Item item : items) {

			/* BackstagePasses */
			if (isBackstagePasses(item)) {
				if (checkMaxQuality(item)) {
					incrementQuality(item);
				}

				if (checkMinSellIn(item)) {
					item.quality = item.quality - item.quality;
				}

				if (item.sellIn <= 10) {
					if (checkMaxQuality(item)) {
						incrementQuality(item);
					}
				}

				if (item.sellIn <= 5) {
					if (checkMaxQuality(item)) {
						incrementQuality(item);
					}
				}
			}
			/* sulfurs */
			if (!isSulfuras(item)) {
				decrementSellIn(item);
			}

			/* agedBrie */
			if (isAgedBrie(item)) {
				if (checkMinSellIn(item)) {
					if (checkMaxQuality(item)) {
						incrementQuality(item);
					}
				}
				if (checkMaxQuality(item)) {
					incrementQuality(item);
				}
			}

			/* other types */
			if (!isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item)) {
				if (checkMinSellIn(item) && checkMinQuality(item)) {
					decrementQuality(item);
				}
				if (checkMinQuality(item)) {
					decrementQuality(item);
				}
			}

		}

	}

	private void decrementSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void incrementQuality(Item item) {
		item.quality = item.quality + 1;
	}

	private void decrementQuality(Item item) {
		item.quality = item.quality - 1;
	}

	private boolean checkMinSellIn(Item item) {
		return item.sellIn < 0;
	}

	private boolean isBackstagePasses(Item item) {
		return item.name.equals(BACKSTAGE_PASSES);
	}

	private boolean isAgedBrie(Item item) {
		return item.name.equals(AGED_BRIE);
	}

	private boolean isSulfuras(Item item) {
		return item.name.equals(SULFURAS);
	}

	private boolean checkMaxQuality(Item item) {
		return item.quality < MAX_QUALITY;
	}

	private boolean checkMinQuality(Item item) {
		return item.quality > MIN_QUALITY;
	}
}
