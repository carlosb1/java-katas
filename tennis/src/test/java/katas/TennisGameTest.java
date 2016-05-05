package katas;

import junit.framework.TestCase;
import katas.TennisGame.Points;

public class TennisGameTest extends TestCase {
	public void getScoresItisZero() {
		TennisGame game = new TennisGame();
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.ZERO);
	}
}
