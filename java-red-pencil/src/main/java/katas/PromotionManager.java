package katas;

import java.util.LinkedList;
import java.util.Queue;

public class PromotionManager {
	private static final int MAX_DAYS_WITHOUT_CHANGES = 30;
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

		if (isPromotion(percentage, item.getDaysWithoutChanges())) {
			item.setPromotion();
		}
		item.setPrice(price);
	}

	// TODO add these days without
	private boolean isPromotion(double percentage, double daysWithoutChanges) {
		return percentage >= 0.05 && percentage <= 0.3 && daysWithoutChanges >= MAX_DAYS_WITHOUT_CHANGES;
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
		if (item.areWeInAPromotion()) {
			if (item.getDaysWithoutChanges() >= MAX_DAYS_PROMOTION) {
				item.disablePromotion();
			}
		} else {
			if (item.getDaysWithoutChanges() >= MAX_DAYS_WITHOUT_CHANGES && !this.historialOfPromotions.isEmpty()) {
				double newPrice = this.historialOfPromotions.poll();
				this.updatePrice(newPrice);
			}
		}

	}

}
