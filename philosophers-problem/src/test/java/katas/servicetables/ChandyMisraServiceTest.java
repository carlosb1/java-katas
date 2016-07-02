package katas.servicetables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChandyMisraServiceTest {
	private ChandyMisraService chandyMisraService;

	@Test
	public void lunchWithOnlyOneForkNotwork() {
		chandyMisraService = new ChandyMisraService(1, 1);
		assertFalse(chandyMisraService.tryGetForks(1));
	}

	@Test
	public void lunchWithIncorrectIndexTryGetForkNotwork() {
		chandyMisraService = new ChandyMisraService(1, 1);
		assertFalse(chandyMisraService.tryGetForks(-1));
	}

	@Test
	public void lunchWithTwoFork() {
		chandyMisraService = new ChandyMisraService(2, 1);
		assertTrue(chandyMisraService.tryGetForks(1));
	}

	@Test
	public void lunchWithSameForksNotWork() {
		chandyMisraService = new ChandyMisraService(2, 1);
		chandyMisraService.tryGetForks(1);
		assertTrue(chandyMisraService.tryGetForks(1));
	}

	@Test
	public void lunchAndReleaseWithOneForkCorrectlWorks() {
		chandyMisraService = new ChandyMisraService(2, 1);
		chandyMisraService.tryGetForks(1);
		assertTrue(chandyMisraService.tryReleaseForks(1));
	}

	@Test
	public void lunchTwoTimesSecondNotWork() {
		chandyMisraService = new ChandyMisraService(5, 5);
		chandyMisraService.tryGetForks(4);
		assertFalse(chandyMisraService.tryGetForks(5));
	}

	@Test
	public void lunchAndReleaseFirstFivePhilosophers() {
		chandyMisraService = new ChandyMisraService(5, 5);
		chandyMisraService.tryReleaseForks(2);
		assertTrue(chandyMisraService.tryGetForks(1));
	}

	@Test
	public void tryMultipleTimesWaitingWork() {
		chandyMisraService = new ChandyMisraService(5, 5);
		assertFalse(chandyMisraService.tryGetForks(1));
		assertFalse(chandyMisraService.tryGetForks(2));
		assertTrue(chandyMisraService.tryGetForks(1));
	}

	@Test
	public void tryMultipleTimesWaitingWorkReleaseAndGiveCorrectly() {
		chandyMisraService = new ChandyMisraService(5, 5);
		assertFalse(chandyMisraService.tryGetForks(2));
		assertFalse(chandyMisraService.tryGetForks(3));
		assertTrue(chandyMisraService.tryGetForks(2));
		assertFalse(chandyMisraService.tryGetForks(1));
		assertTrue(chandyMisraService.tryReleaseForks(2));
	}

	@Test
	public void tryReleaseIncorrectFork() {
		chandyMisraService = new ChandyMisraService(1, 1);
		assertFalse(chandyMisraService.tryReleaseForks(1));
	}

}
