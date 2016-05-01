package katas.gildedrose.updaters;

import katas.gildedrose.Item;

public class UpdaterOthers extends Updater {

	@Override
	public void checkSellIn(Item item) {
		decrementSellIn(item);

	}

	@Override
	public void checkQuality(Item item) {
		/* Quality control */
		if (checkMinSellIn(item) && checkMinQuality(item)) {
			decrementQuality(item);
		}
		if (checkMinQuality(item)) {
			decrementQuality(item);
		}

	}

}
