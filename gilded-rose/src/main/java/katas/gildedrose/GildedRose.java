package katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

import katas.gildedrose.updaters.Factory;
import katas.gildedrose.updaters.Updater;

class GildedRose {
	List<Item> items;
	// TODO change name
	private final Factory factory;

	public GildedRose(List<Item> items) {
		this.items = items;
		this.factory = new Factory();
	}

	public GildedRose() {
		this.items = new ArrayList<Item>();
		this.factory = new Factory();

	}

	public GildedRose addItem(Item item) {
		this.items.add(item);
		return this;
	}

	public void updateQuality() {
		for (Item item : items) {
			Updater updater = factory.makeUpdater(item);
			updater.checkSellIn(item);
			updater.checkQuality(item);
		}

	}

}
