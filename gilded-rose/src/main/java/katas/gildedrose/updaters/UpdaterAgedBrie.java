package katas.gildedrose.updaters;

import katas.gildedrose.Item;

public class UpdaterAgedBrie extends Updater {
	public void checkSellIn(Item item) {
		decrementSellIn(item);

	}

	public void checkQuality(Item item) {
		if (checkMinSellIn(item) && checkMaxQuality(item)) {
			incrementQuality(item);
		}
		if (checkMaxQuality(item)) {
			incrementQuality(item);
		}

	}

}
