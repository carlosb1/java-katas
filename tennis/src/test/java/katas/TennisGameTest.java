package katas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import katas.TennisGame.Points;

public class TennisGameTest {
	@Test
	public void getScoresOnePlayerItisZero() {
		TennisGame game = new TennisGame();
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.ZERO);
	}

	@Test
	public void getScoresTwoPlayersItisZero() {
		// TODO add refactorization for this problem
		TennisGame game = new TennisGame();
		Points pointsPlayerOne = game.getPlayerOneScore();
		Points pointsPlayerTwo = game.getPlayerTwoScore();
		assertTrue(pointsPlayerOne == Points.ZERO && pointsPlayerTwo == Points.ZERO);
	}
}
