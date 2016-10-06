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
		promotionManager.updatePrice(itemTest, -1.1);
		assertTrue(itemTest.getPrice() == 1.0);
	}

	@Test
	public void updatePriceWithoutPromotionOk() {
		promotionManager.updatePrice(itemTest, 2.0);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 2.0);
	}

	@Test
	public void decrementPriceNotActivatedPromotion() {
		promotionManager.updatePrice(itemTest, 1.1);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.1);
	}

	@Test
	public void increasePriceActivePromotionFails() {
		promotionManager.updatePrice(itemTest, 0.9);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 0.9);
	}

	// TODO most tests for this condition
	@Test
	public void decrementPriceAndDecrementDaysActivatePromotion() {
		itemTest.incrementDays(30);
		promotionManager.updatePrice(itemTest, 0.9);
		assertTrue(itemTest.getPreviousPromotionPrice() == 1.0);
		assertTrue(itemTest.getPrice() == 0.9);
	}

	@Test
	public void stopPromotionWithMoreThirstyDaysOk() {
		itemTest.incrementDays(30);
		promotionManager.updatePrice(itemTest, 0.9);
		itemTest.incrementDays(30);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.0);
	}

	@Test
	public void goUpPriceItIsNotPromotionOk() {
		itemTest.incrementDays(30);
		promotionManager.updatePrice(itemTest, 0.9);
		promotionManager.updatePrice(itemTest, 1.1);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.1);
	}

	@Test
	public void decrementPriceTwoTimesPromotionNotChangesOk() {
		// TODO automatise this promotion use case
		itemTest.incrementDays(30);
		promotionManager.updatePrice(itemTest, 0.9);
		itemTest.incrementDays(15);
		promotionManager.updatePrice(itemTest, 0.8);
		assertTrue(itemTest.getPreviousPromotionPrice() == 1.0);
		assertTrue(itemTest.getPrice() == 0.8);
		itemTest.incrementDays(15);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
	}

}
