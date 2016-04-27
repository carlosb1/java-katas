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
	List<Item> items;

	// TODO pending to refactor text test fixture
	public GildedRose(Item[] newItems) {
		items = Arrays.asList(newItems);
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
			if (!isAgedBrie(item) && !isBackstagePasses(item)) {
				if (checkMinQuality(item)) {
					if (!isSulfuras(item)) {
						decrementQuality(item);
					}
				}
			} else {
				if (checkMaxQuality(item)) {
					incrementQuality(item);

					if (isBackstagePasses(item)) {
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
				}
			}

			if (!isSulfuras(item)) {
				decrementSellIn(item);
			}

			if (checkMinSellIn(item)) {
				if (!isAgedBrie(item)) {
					if (!isBackstagePasses(item)) {
						if (checkMinQuality(item)) {
							if (!isSulfuras(item)) {
								decrementQuality(item);
							}
						}
					} else {
						item.quality = item.quality - item.quality;
					}
				} else {
					if (checkMaxQuality(item)) {
						incrementQuality(item);
					}
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
