package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import katas.TennisGame.Points;

public class TennisGameTest {
	TennisGame game;

	@Before
	public void setUp() {
		game = new TennisGame();
	}

	@After
	public void tearDown() {
		game = null;
	}

	@Test
	public void getScoresOnePlayerZero() {
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.ZERO);
	}

	@Test
	public void getScoresTwoPlayersZero() {
		Points pointsPlayerOne = game.getPlayerOneScore();
		Points pointsPlayerTwo = game.getPlayerTwoScore();
		assertTrue(pointsPlayerOne == Points.ZERO && pointsPlayerTwo == Points.ZERO);
	}

	@Test
	public void getScoresOnePlayerScoreFifteen() {
		game.playerOneScore();
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.FIFTEEN);
	}

	@Test
	public void getScoresTwoPlayerScoreFifteen() {
		game.playerTwoScore();
		Points points = game.getPlayerTwoScore();
		assertTrue(points == Points.FIFTEEN);
	}

	@Test
	public void getScoresOnePlayerScoreThirty() {
		game.playerOneScore();
		game.playerOneScore();
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.THIRTY);
	}

	@Test
	public void getScoresTwoPlayerScoreThirty() {
		game.playerTwoScore();
		game.playerTwoScore();
		Points points = game.getPlayerTwoScore();
		assertTrue(points == Points.THIRTY);
	}

	@Test
	public void getScoresOnePlayerScoreForty() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.FORTY);
	}

	@Test
	public void getScoresTwoPlayerScoreForty() {
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();
		Points points = game.getPlayerTwoScore();
		assertTrue(points == Points.FORTY);
	}

	@Test
	public void getWinnerIsNotFinishedMatch() {
		boolean finish = game.isFinished();
		assertFalse(finish);
	}

	@Test
	public void getWinnerOnePlayerIsFinishedMatch() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();
		boolean finish = game.isFinished();
		assertTrue(finish);
	}

	@Test
	public void getStatusNotFinisher() {
		TennisGame.Status status = game.status();
		assertTrue(status == TennisGame.Status.NOTFINISHED);
	}

	@Test
	public void getStatusStartOnePlayerDeuce() {
		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();

		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();

		TennisGame.Status status = game.status();
		assertTrue(status == TennisGame.Status.DEUCE);
	}

	@Test
	public void getStatusStartTwoPlayerDeuce() {
		game.playerTwoScore();
		game.playerTwoScore();
		game.playerTwoScore();

		game.playerOneScore();
		game.playerOneScore();
		game.playerOneScore();

		TennisGame.Status status = game.status();
		assertTrue(status == TennisGame.Status.DEUCE);
	}

}
