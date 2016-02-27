package katas.com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (checkMinQuality(i)) {
					if (!isSulfuras(i)) {
						items[i].quality = items[i].quality - 1;
					}
				}
			} else {
				if (checkMaxQuality(i)) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

	public boolean isSulfuras(int i) {
		return items[i].name.equals("Sulfuras, Hand of Ragnaros");
	}

	public boolean checkMaxQuality(int i) {
		return items[i].quality < 50;
	}

	public boolean checkMinQuality(int i) {
		return items[i].quality > 0;
	}
}
