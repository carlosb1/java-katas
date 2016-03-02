package katas.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!isAgedBrie(i) && !isBackstagePasses(i)) {
				if (checkMinQuality(i)) {
					if (!isSulfuras(i)) {
						items[i].quality = items[i].quality - 1;
					}
				}
			} else {
				if (checkMaxQuality(i)) {
					items[i].quality = items[i].quality + 1;

					if (isBackstagePasses(i)) {
						if (items[i].sellIn < 11) {
							if (checkMaxQuality(i)) {
								items[i].quality = items[i].quality + 1;
							}
						}

						if (items[i].sellIn < 6) {
							if (checkMaxQuality(i)) {
								items[i].quality = items[i].quality + 1;
							}
						}
					}
				}
			}

			if (!isSulfuras(i)) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (checkMinSellIn(i)) {
				if (!isAgedBrie(i)) {
					if (!isBackstagePasses(i)) {
						if (checkMinQuality(i)) {
							if (!isSulfuras(i)) {
								items[i].quality = items[i].quality - 1;
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
					if (checkMaxQuality(i)) {
						items[i].quality = items[i].quality + 1;
					}
				}
			}
		}
	}

	private boolean checkMinSellIn(int i) {
		return items[i].sellIn < 0;
	}

	private boolean isBackstagePasses(int i) {
		return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isAgedBrie(int i) {
		return items[i].name.equals("Aged Brie");
	}

	private boolean isSulfuras(int i) {
		return items[i].name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean checkMaxQuality(int i) {
		return items[i].quality < 50;
	}

	private boolean checkMinQuality(int i) {
		return items[i].quality > 0;
	}
}
