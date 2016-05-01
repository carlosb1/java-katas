package katas.gildedrose.updaters;

import katas.gildedrose.Item;

public abstract class Updater {
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;

	public abstract void checkSellIn(Item item);

	public abstract void checkQuality(Item item);

	protected final void decrementSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	protected final void incrementQuality(Item item) {
		item.quality = item.quality + 1;
	}

	protected final void decrementQuality(Item item) {
		item.quality = item.quality - 1;
	}

	protected final boolean checkMaxQuality(Item item) {
		return item.quality < MAX_QUALITY;
	}

	protected final boolean checkMinQuality(Item item) {
		return item.quality > MIN_QUALITY;
	}

	protected final boolean checkMinSellIn(Item item) {
		return item.sellIn < 0;
	}

}
