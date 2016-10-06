package katas;

public class Item {
	public static final double NOT_PROMOTION = -1.0;
	private static final int MAX_DAYS_PROMOTION = 30;
	private double previousPromotionPrice;
	private int daysWithoutChanges;
	private double price;

	public int getDaysWithoutChanges() {
		return daysWithoutChanges;
	}

	public Item(double price) {
		this.price = price;
		this.previousPromotionPrice = NOT_PROMOTION;
		this.daysWithoutChanges = 0;

	}

	public double getPreviousPromotionPrice() {
		return previousPromotionPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void disablePromotion() {
		this.price = previousPromotionPrice;
		previousPromotionPrice = NOT_PROMOTION;
	}

	public void setPromotion() {
		this.daysWithoutChanges = 0;
		this.previousPromotionPrice = this.price;
	}

	public void addDaysWithoutChanges(int days) {
		this.daysWithoutChanges += days;
		// TODO add constants for these numbers
		// TODO move this logic
		if (this.daysWithoutChanges >= MAX_DAYS_PROMOTION) {
			if (areWeInAPromotion()) {
				disablePromotion();
			}
		}
	}

	private boolean areWeInAPromotion() {
		return previousPromotionPrice != -1;
	}

}
