package katas;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	private Item item;

	@Before
	public void setUp() {
		item = new Item(1.0);
	}

	@After
	public void tearDown() {
		item = null;
	}

	@Test
	public void checkPriceCorrectly() {
		assertTrue(item.getPrice() == 1.0);
	}

	// TODO Is it possible update price without promotion
	@Test
	public void updatePriceWithoutPromotionOk() {
		item.applyPromotion(2.0);
		assertTrue(item.getPrice() == 2.0);
	}

	@Test
	public void isNotActivatedPromotionOk() {
		assertTrue(item.isPromotion() == false);
	}

	// TODO test, for small increasing
	@Test
	public void decrementPriceNotActivatedPromotion() {
		item.applyPromotion(1.1);
		assertTrue(item.isPromotion() == false);
	}

	// TODO first days
	@Test
	public void increasePriceNotActivatedPromotion() {
		item.applyPromotion(0.9);
		assertTrue(item.isPromotion() == false);
	}

	// TODO most tests for this condition
	@Test
	public void decrementPriceAndDecrementDaysActivatePromotion() {
		item.incrementDays(30);
		item.applyPromotion(0.9);
		assertTrue(item.isPromotion() == true);
	}

}
