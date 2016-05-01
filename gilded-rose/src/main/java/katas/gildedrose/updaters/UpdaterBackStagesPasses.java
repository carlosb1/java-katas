package katas.gildedrose.updaters;

import katas.gildedrose.Item;

public class UpdaterBackStagesPasses extends Updater {
	private void dropToZero(Item item) {
		item.quality = 0;
	}

	private boolean checSellInMinusTriple(Item item) {
		return item.sellIn <= 5;
	}

	private boolean checSellInIncrementDouble(Item item) {
		return item.sellIn <= 10;
	}

	@Override
	public void checkSellIn(Item item) {
		decrementSellIn(item);
		if (checkMinSellIn(item)) {
			dropToZero(item);
		}

	}

	@Override
	public void checkQuality(Item item) {
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

}
