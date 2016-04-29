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
			/* BackstagePasses */
			if (isBackstagePasses(item)) {
				/* SellIn Control */
				decrementSellIn(item);
				if (checkMinSellIn(item)) {
					dropToZero(item);
				}

				/* Quality Control */
				if (checkMaxQuality(item)) {
					incrementQuality(item);
				}

				if (checkMaxQuality(item)) {
					if (checSellInIncrementDouble(item)) {
						incrementQuality(item);
					}
					if (checSellInMinusTriple(item)) {
						incrementQuality(item);
					}

				}

			}
			/* agedBrie */
			if (isAgedBrie(item)) {

				// Sell In control
				decrementSellIn(item);

				/* Quality control */
				if (checkMinSellIn(item) && checkMaxQuality(item)) {
					incrementQuality(item);
				}
				if (checkMaxQuality(item)) {
					incrementQuality(item);
				}
			}

			/* other types */
			if (!isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item)) {
				/* Sell in control */
				decrementSellIn(item);

				/* Quality control */
				if (checkMinSellIn(item) && checkMinQuality(item)) {
					decrementQuality(item);
				}
				if (checkMinQuality(item)) {
					decrementQuality(item);
				}
			}

		}

	}

	private void dropToZero(Item item) {
		item.quality = 0;
	}

	private boolean checSellInMinusTriple(Item item) {
		return item.sellIn <= 5;
	}

	private boolean checSellInIncrementDouble(Item item) {
		return item.sellIn <= 10;
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
