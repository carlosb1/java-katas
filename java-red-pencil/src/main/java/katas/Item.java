package katas;

public class Item {
	private double previousPromotionPrice;

	private int daysWithoutChanges;
	private double price;

	public double calculatePercentagePromotion(double newPrice) {
		return (1.0 - ((1.0 * newPrice) / price));
	}

	public Item(double price) {
		this.price = price;
		this.previousPromotionPrice = -1.0;
		this.daysWithoutChanges = 0;

	}

	public double getPreviousPromotionPrice() {
		return previousPromotionPrice;
	}

	public double getPrice() {
		return price;
	}

	public void updatePrice(double price) {
		if (price < 0.0) {
			return;
		}
		if (isUpPrice(price)) {
			disablePromotion();
		}

		double percentage = calculatePercentagePromotion(price);
		if (isPromotion(percentage)) {
			setPromotion();
		}
		this.price = price;
	}

	private boolean isUpPrice(double price) {
		return previousPromotionPrice != -1 && price > this.previousPromotionPrice;
	}

	private void disablePromotion() {
		this.price = previousPromotionPrice;
		previousPromotionPrice = -1.0;
	}

	private void setPromotion() {
		this.daysWithoutChanges = 0;
		this.previousPromotionPrice = this.price;
	}

	private boolean isPromotion(double percentage) {
		return percentage >= 0.05 && percentage <= 0.3 && this.daysWithoutChanges >= 30;
	}

	public void incrementDays(int days) {
		this.daysWithoutChanges += days;
		// TODO add constants for these numbers
		if (this.daysWithoutChanges >= 30) {
			if (areWeInAPromotion()) {
				disablePromotion();
			}
		}
	}

	private boolean areWeInAPromotion() {
		return previousPromotionPrice != -1;
	}

}
