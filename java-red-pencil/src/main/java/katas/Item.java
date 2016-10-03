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
		// TODO best method to avoid this null
		this.previousPrice = -1.0;
		this.daysWithoutChanges = 0;

	}

	public double getPrice() {
		return price;
	}

	public void applyPromotion(double price) {
		double percentage = percentagePromotion(price);
		// TODO refactor this condition
		// TODO add guards
		if (percentage >= 0.05 && percentage <= 0.3 && this.daysWithoutChanges >= 30) {
			this.isPromoted = true;
			this.daysWithoutChanges = 0;
			this.previousPrice = this.price;
		}
		this.price = price;
	}

	public boolean isPromotion() {
		return this.isPromoted;
	}

	public void incrementDays(int days) {
		this.daysWithoutChanges += days;
	}

}
