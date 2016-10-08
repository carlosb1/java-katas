package katas;

import java.util.LinkedList;
import java.util.Queue;

public class PromotionManager {
	private static final int MAX_DAYS_PROMOTION = 30;
	private final Queue<Double> historialOfPromotions;
	private Item item;

	public PromotionManager(Item item) {
		this.item = item;
		this.historialOfPromotions = new LinkedList<Double>();
	}

	public void updatePrice(double price) {
		if (price < 0.0) {
			return;
		}
		if (isUpPrice(price, item)) {
			item.disablePromotion();
			item.setPrice(price);
			return;
		}

		// TODO test for error not promotion case
		if (item.getPreviousPromotionPrice() != Item.NOT_PROMOTION && calculatePercPromotion(price, item.getPreviousPromotionPrice()) > 0.3) {
			item.disablePromotion();
			return;
		}

		double percentage = calculatePercPromotion(price, item.getPrice());

		if (item.getPreviousPromotionPrice() != Item.NOT_PROMOTION && percentage >= 0.05 && percentage <= 0.3) {
			this.historialOfPromotions.offer(price);
			return;
		}

		if (isPromotion(percentage, item)) {
			item.setPromotion();
		}
		item.setPrice(price);
	}

	// TODO add these days without
	// TODO pass days without changes not all the objects
	private boolean isPromotion(double percentage, Item item) {
		return percentage >= 0.05 && percentage <= 0.3 && item.getDaysWithoutChanges() >= 30;
	}

	private double calculatePercPromotion(double newPrice, double oldPrice) {
		return (1.0 - ((1.0 * newPrice) / oldPrice));
	}

	private boolean isUpPrice(double price, Item item) {
		double previousPromotionPrice = item.getPreviousPromotionPrice();
		return previousPromotionPrice != Item.NOT_PROMOTION && price > previousPromotionPrice;
	}

	public void addDays(int days) {
		this.item.addDaysWithoutChanges(days);
		// TODO refactor this if
		if (item.getDaysWithoutChanges() >= MAX_DAYS_PROMOTION) {
			if (item.areWeInAPromotion()) {
				item.disablePromotion();
				return;
			}
		}
		// TODO add variable to specify this 30
		if (item.getDaysWithoutChanges() >= 30) {
			if (!item.areWeInAPromotion() && !this.historialOfPromotions.isEmpty()) {
				double newPrice = this.historialOfPromotions.poll();
				this.updatePrice(newPrice);
				return;
			}

		}

	}

}
