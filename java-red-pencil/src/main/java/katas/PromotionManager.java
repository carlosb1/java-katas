package katas;

import java.util.LinkedList;
import java.util.Queue;

public class PromotionManager {
	private static final double MIN_PERCENTAGE = 0.05;
	private static final double MAX_PERCENTAGE = 0.3;
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
		double percentage = calculatePercPromotion(price, item.getPrice());
		if (item.areWeInAPromotion()) {

			if (price > item.getPreviousPromotionPrice()) {
				item.disablePromotion();
				item.setPrice(price);
				return;
			}

			if (calculatePercPromotion(price, item.getPreviousPromotionPrice()) > MAX_PERCENTAGE) {
				item.disablePromotion();
				return;
			}
			if (IsACorrectPromotion(percentage)) {
				this.historialOfPromotions.offer(price);
				return;
			}
		}

		if (IsACorrectPromotion(percentage) && item.getDaysWithoutChanges() >= MAX_DAYS_WITHOUT_CHANGES) {
			item.setPromotion();
		}
		item.setPrice(price);
	}

	private boolean IsACorrectPromotion(double percentage) {
		return percentage >= MIN_PERCENTAGE && percentage <= MAX_PERCENTAGE;
	}

	private double calculatePercPromotion(double newPrice, double oldPrice) {
		return (1.0 - ((1.0 * newPrice) / oldPrice));
	}

	public void addDays(int days) {
		this.item.addDaysWithoutChanges(days);
		if (item.areWeInAPromotion() && item.getDaysWithoutChanges() >= MAX_DAYS_PROMOTION) {
			item.disablePromotion();
		}
		if (item.getDaysWithoutChanges() >= MAX_DAYS_WITHOUT_CHANGES && !this.historialOfPromotions.isEmpty()) {
			double newPrice = this.historialOfPromotions.poll();
			this.updatePrice(newPrice);
		}

	}

}
