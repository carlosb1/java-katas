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

	// TODO Change name for test
	@Test
	public void checkPriceOk() {
		assertTrue(item.getPrice() == 1.0);
	}

	@Test
	public void setPriceOk() {
		item.setPrice(1.1);
		assertTrue(item.getPrice() == 1.1);
	}

	@Test
	public void isNotActivatedPromotionOk() {
		assertTrue(item.getPreviousPromotionPrice() == -1.0);
	}

}
