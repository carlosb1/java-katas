package katas;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PromotionManagerTest {
	private PromotionManager promotionManager;
	private Item itemTest;

	@Before
	public void setUp() {
		promotionManager = new PromotionManager();
		itemTest = new Item(1.0);
	}

	@After
	public void tearDown() {
		promotionManager = null;
		itemTest = null;
	}

	@Test
	public void checkNegativePriceFails() {
		promotionManager.updatePrice(itemTest, -1.0);
		assertTrue(itemTest.getPrice() == 1.0);
	}

	@Test
	public void updatePriceWithoutPromotionOk() {
		item.updatePrice(2.0);
		assertTrue(item.getPreviousPromotionPrice() == -1);
		assertTrue(item.getPrice() == 2.0);
	}

	@Test
	public void decrementPriceNotActivatedPromotion() {
		item.updatePrice(1.1);
		assertTrue(item.getPreviousPromotionPrice() == -1);
		assertTrue(item.getPrice() == 1.1);
	}

	@Test
	public void increasePriceActivePromotionFails() {
		item.updatePrice(0.9);
		assertTrue(item.getPreviousPromotionPrice() == -1);
		assertTrue(item.getPrice() == 0.9);
	}

	// TODO most tests for this condition
	@Test
	public void decrementPriceAndDecrementDaysActivatePromotion() {
		item.incrementDays(30);
		item.updatePrice(0.9);
		assertTrue(item.getPreviousPromotionPrice() == 1.0);
		assertTrue(item.getPrice() == 0.9);
	}

	@Test
	public void stopPromotionWithMoreThirstyDaysOk() {
		item.incrementDays(30);
		item.updatePrice(0.9);
		item.incrementDays(30);
		assertTrue(item.getPreviousPromotionPrice() == -1.0);
		assertTrue(item.getPrice() == 1.0);
	}

	@Test
	public void goUpPriceItIsNotPromotionOk() {
		item.incrementDays(30);
		item.updatePrice(0.9);
		item.updatePrice(1.1);
		assertTrue(item.getPreviousPromotionPrice() == -1.0);
		assertTrue(item.getPrice() == 1.1);
	}

	@Test
	public void decrementPriceTwoTimesPromotionNotChangesOk() {
		// TODO automatise this promotion use case
		item.incrementDays(30);
		item.updatePrice(0.9);
		item.incrementDays(15);
		item.updatePrice(0.8);
		assertTrue(item.getPreviousPromotionPrice() == 1.0);
		assertTrue(item.getPrice() == 0.8);
		item.incrementDays(15);
		assertTrue(item.getPreviousPromotionPrice() == -1);
	}

}
