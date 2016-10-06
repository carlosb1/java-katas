package katas;

public class PromotionManager {
	public void updatePrice(Item item, double price) {
		if (price < 0.0) {
			return;
		}
		if (isUpPrice(price, item)) {
			item.disablePromotion();
		}

		double percentage = calculatePercentagePromotion(price, item);
		if (isPromotion(percentage, item)) {
			item.setPromotion();
		}
		item.setPrice(price);
	}

	// TODO add these days without
	private boolean isPromotion(double percentage, Item item) {
		return percentage >= 0.05 && percentage <= 0.3 && item.getDaysWithoutChanges() >= 30;
	}

	public double calculatePercentagePromotion(double newPrice, Item item) {
		return (1.0 - ((1.0 * newPrice) / item.getPrice()));
	}

	private boolean isUpPrice(double price, Item item) {
		double previousPromotionPrice = item.getPreviousPromotionPrice();
		return previousPromotionPrice != Item.NOT_PROMOTION && price > previousPromotionPrice;
	}
}
