package katas.servicetables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OneLunchServiceTest {
	private OneLunchService oneLunchService;

	@Test
	public void lunchWithOnlyOneForkNotwork() {
		oneLunchService = new OneLunchService(1);
		assertFalse(oneLunchService.tryGetForks(1));
	}

	@Test
	public void lunchWithIncorrectIndexTryGetForkNotwork() {
		oneLunchService = new OneLunchService(1);
		assertFalse(oneLunchService.tryGetForks(-1));
	}

	@Test
	public void lunchWithTwoForkNotwork() {
		oneLunchService = new OneLunchService(2);
		assertTrue(oneLunchService.tryGetForks(1));
	}

	@Test
	public void lunchWithSameForksNotWork() {
		oneLunchService = new OneLunchService(2);
		oneLunchService.tryGetForks(1);
		assertFalse(oneLunchService.tryGetForks(1));
	}

	@Test
	public void lunchAndReleaseWithOneForkCorrectlWorks() {
		oneLunchService = new OneLunchService(2);
		oneLunchService.tryGetForks(1);
		assertTrue(oneLunchService.tryReleaseForks(1));
	}

}
