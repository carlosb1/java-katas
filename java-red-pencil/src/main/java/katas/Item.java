package katas;

public class Item {
	private double previousPrice;

	private int daysWithoutChanges;
	private double price;
	private boolean isPromoted;

	public double percentagePromotion(double newPrice) {
		return (1.0 - ((1.0 * newPrice) / price));
	}

	public Item(double price) {
		this.isPromoted = false;
		this.price = price;
		this.previousPrice = -1.0;
		this.daysWithoutChanges = 0;

	}

	public double getPreviousPrice() {
		return previousPrice;
	}

	public double getPrice() {
		return price;
	}

	public void applyPromotion(double price) {
		double percentage = percentagePromotion(price);
		if (isFirstCondition(percentage)) {
			setPromotion();
		}
		this.price = price;
	}

	private void setPromotion() {
		this.isPromoted = true;
		this.daysWithoutChanges = 0;
		this.previousPrice = this.price;
	}

	private boolean isFirstCondition(double percentage) {
		return percentage >= 0.05 && percentage <= 0.3 && this.daysWithoutChanges >= 30;
	}

	public boolean isPromotion() {
		return this.isPromoted;
	}

	public void incrementDays(int days) {
		this.daysWithoutChanges += days;
		// TODO creates a variable
		if (this.daysWithoutChanges >= 30) {
			this.isPromoted = false;
		}
	}

}
