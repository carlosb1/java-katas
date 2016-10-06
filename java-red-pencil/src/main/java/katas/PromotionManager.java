package katas;

public class PromotionManager {
	public void updatePrice(Item item, double price) {
		if (price < 0.0) {
			return;
		}
		if (isUpPrice(price, item)) {
			item.disablePromotion();
			item.setPrice(price);
			return;
		}

		if (item.getPreviousPromotionPrice() != Item.NOT_PROMOTION && calculatePercPromotion(price, item.getPreviousPromotionPrice()) > 0.3) {
			item.disablePromotion();
			return;
		}

		double percentage = calculatePercPromotion(price, item.getPrice());

		if (isPromotion(percentage, item)) {
			item.setPromotion();
		}
		item.setPrice(price);
	}

	// TODO add these days without
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
}
