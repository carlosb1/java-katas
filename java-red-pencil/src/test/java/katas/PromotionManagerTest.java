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
		itemTest = new Item(1.0);
		promotionManager = new PromotionManager(itemTest);
	}

	@After
	public void tearDown() {
		promotionManager = null;
		itemTest = null;
	}

	@Test
	public void checkNegativePriceFails() {
		promotionManager.updatePrice(-1.1);
		assertTrue(itemTest.getPrice() == 1.0);
	}

	@Test
	public void updatePriceWithoutPromotionOk() {
		promotionManager.updatePrice(2.0);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 2.0);
	}

	@Test
	public void decrementPriceNotActivatedPromotion() {
		promotionManager.updatePrice(1.1);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.1);
	}

	@Test
	public void increasePriceActivePromotionFails() {
		promotionManager.updatePrice(0.9);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 0.9);
	}

	// TODO most tests for this condition
	@Test
	public void decrementPriceAndDecrementDaysActivatePromotion() {
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		assertTrue(itemTest.getPreviousPromotionPrice() == 1.0);
		assertTrue(itemTest.getPrice() == 0.9);
	}

	@Test
	public void stopPromotionWithMoreThirstyDaysOk() {
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		promotionManager.addDays(30);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.0);
	}

	@Test
	public void goUpPriceItIsNotPromotionOk() {
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		promotionManager.updatePrice(1.1);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
		assertTrue(itemTest.getPrice() == 1.1);
	}

	@Test
	public void decrementPriceTwoTimesPromotionNotChangesOk() {
		// TODO automatise this promotion use case
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		promotionManager.addDays(15);
		promotionManager.updatePrice(0.8);
		assertTrue(itemTest.getPreviousPromotionPrice() == 1.0);
		assertTrue(itemTest.getPrice() == 0.9);
		promotionManager.addDays(15);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
	}

	@Test
	public void reduceDuringPromotionAndEndImmediatelyOk() {
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		promotionManager.updatePrice(0.5);
		assertTrue(itemTest.getPreviousPromotionPrice() == Item.NOT_PROMOTION);
	}

	@Test
	public void reduceDuringPromotionApplyAfterThirtytOk() {
		promotionManager.addDays(30);
		promotionManager.updatePrice(0.9);
		promotionManager.updatePrice(0.8);
		promotionManager.addDays(30);
		promotionManager.addDays(30);
		assertTrue(itemTest.getPrice() == 0.8);
		assertTrue(itemTest.getPreviousPromotionPrice() == 1.0);

	}

}
