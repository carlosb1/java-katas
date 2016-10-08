package katas;

public class Item {
	public static final double NOT_PROMOTION = -1.0;

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
		// TODO test to check this..
		this.daysWithoutChanges = 0;
	}

	public void setPromotion() {
		this.daysWithoutChanges = 0;
		this.previousPromotionPrice = this.price;
	}

	// FIXME, how to manage this function
	protected void addDaysWithoutChanges(int days) {
		this.daysWithoutChanges += days;
	}

	public boolean isPromoted() {
		return previousPromotionPrice != NOT_PROMOTION;
	}

}
