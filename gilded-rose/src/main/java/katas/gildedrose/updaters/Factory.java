package katas.gildedrose.updaters;

import katas.gildedrose.Item;

//TODO add test for factory
public class Factory {
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

	public Updater makeUpdater(Item item) {
		Updater updater;
		switch (item.name) {
		case SULFURAS:
			updater = new UpdaterSulfuras();
			break;
		case AGED_BRIE:
			updater = new UpdaterAgedBrie();
			break;
		case BACKSTAGE_PASSES:
			updater = new UpdaterBackStagesPasses();
			break;
		default:
			updater = new UpdaterOthers();
			;

		}
		return updater;
	}

}
