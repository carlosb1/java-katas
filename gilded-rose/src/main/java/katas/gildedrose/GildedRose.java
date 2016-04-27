package katas.gildedrose;

class GildedRose {
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!isAgedBrie(i) && !isBackstagePasses(i)) {
				if (checkMinQuality(i)) {
					if (!isSulfuras(i)) {
						decrementQuality(i);
					}
				}
			} else {
				if (checkMaxQuality(i)) {
					incrementQuality(i);

					if (isBackstagePasses(i)) {
						if (items[i].sellIn <= 10) {
							if (checkMaxQuality(i)) {
								incrementQuality(i);
							}
						}

						if (items[i].sellIn <= 5) {
							if (checkMaxQuality(i)) {
								incrementQuality(i);
							}
						}
					}
				}
			}

			if (!isSulfuras(i)) {
				decrementSellIn(i);
			}

			if (checkMinSellIn(i)) {
				if (!isAgedBrie(i)) {
					if (!isBackstagePasses(i)) {
						if (checkMinQuality(i)) {
							if (!isSulfuras(i)) {
								decrementQuality(i);
							}
						}
					} else {
						decrementQualityForBackstagePasses(i);
					}
				} else {
					if (checkMaxQuality(i)) {
						incrementQuality(i);
					}
				}
			}

		}
	}

	private void decrementQualityForBackstagePasses(int i) {
		items[i].quality = items[i].quality - items[i].quality;
	}

	private void decrementSellIn(int i) {
		items[i].sellIn = items[i].sellIn - 1;
	}

	private void incrementQuality(int i) {
		items[i].quality = items[i].quality + 1;
	}

	private void decrementQuality(int i) {
		items[i].quality = items[i].quality - 1;
	}

	private boolean checkMinSellIn(int i) {
		return items[i].sellIn < 0;
	}

	private boolean isBackstagePasses(int i) {
		return items[i].name.equals(BACKSTAGE_PASSES);
	}

	private boolean isAgedBrie(int i) {
		return items[i].name.equals(AGED_BRIE);
	}

	private boolean isSulfuras(int i) {
		return items[i].name.equals(SULFURAS);
	}

	private boolean checkMaxQuality(int i) {
		return items[i].quality < MAX_QUALITY;
	}

	private boolean checkMinQuality(int i) {
		return items[i].quality > MIN_QUALITY;
	}
}
