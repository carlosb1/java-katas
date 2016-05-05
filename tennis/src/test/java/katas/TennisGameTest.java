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

	private void scoreMultipleTimesOnePlayer(TennisGame game, int numberScores) {
		for (int i = 0; i < numberScores; i++) {
			game.playerOneScore();
		}
	}

	private void scoreMultipleTimesTwoPlayer(TennisGame game, int numberScores) {
		for (int i = 0; i < numberScores; i++) {
			game.playerTwoScore();
		}
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
		scoreMultipleTimesOnePlayer(game, 2);
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.THIRTY);
	}

	@Test
	public void getScoresTwoPlayerScoreThirty() {
		scoreMultipleTimesTwoPlayer(game, 2);
		Points points = game.getPlayerTwoScore();
		assertTrue(points == Points.THIRTY);
	}

	@Test
	public void getScoresOnePlayerScoreForty() {
		scoreMultipleTimesOnePlayer(game, 3);
		Points points = game.getPlayerOneScore();
		assertTrue(points == Points.FORTY);
	}

	@Test
	public void getScoresTwoPlayerScoreForty() {
		scoreMultipleTimesTwoPlayer(game, 3);
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
		scoreMultipleTimesOnePlayer(game, 4);
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
		scoreMultipleTimesOnePlayer(game, 3);
		scoreMultipleTimesTwoPlayer(game, 3);

		TennisGame.Status status = game.status();
		assertTrue(status == TennisGame.Status.DEUCE);
	}

	@Test
	public void getStatusStartTwoPlayerDeuce() {
		scoreMultipleTimesTwoPlayer(game, 3);
		scoreMultipleTimesOnePlayer(game, 3);

		TennisGame.Status status = game.status();
		assertTrue(status == TennisGame.Status.DEUCE);
	}

	@Test
	public void getStatusOnePlayerNotDeuce() {
		scoreMultipleTimesOnePlayer(game, 3);
		TennisGame.Status status = game.status();
		assertTrue(status != TennisGame.Status.DEUCE);
	}

	@Test
	public void oneTimeOnePlayer() {
		scoreMultipleTimesOnePlayer(game, 1);
		assertTrue(game.getPlayerOneScore() == Points.FIFTEEN);
	}

	@Test
	public void twoTimesOnePlayer() {
		scoreMultipleTimesOnePlayer(game, 2);
		assertTrue(game.getPlayerOneScore() == Points.THIRTY);
	}

	@Test
	public void threeTimesOnePlayer() {
		scoreMultipleTimesOnePlayer(game, 3);
		assertTrue(game.getPlayerOneScore() == Points.FORTY);
	}

	@Test
	public void fourTimesOnePlayer() {
		scoreMultipleTimesOnePlayer(game, 4);
		assertTrue(game.getPlayerOneScore() == Points.WIN);
	}

	@Test
	public void oneTimeTwoPlayer() {
		scoreMultipleTimesTwoPlayer(game, 1);
		assertTrue(game.getPlayerTwoScore() == Points.FIFTEEN);
	}

	@Test
	public void twoTimesTwoPlayer() {
		scoreMultipleTimesTwoPlayer(game, 2);
		assertTrue(game.getPlayerTwoScore() == Points.THIRTY);
	}

	@Test
	public void threeTimesTwoPlayer() {
		scoreMultipleTimesTwoPlayer(game, 3);
		assertTrue(game.getPlayerTwoScore() == Points.FORTY);
	}

	@Test
	public void fourTimesTwoPlayer() {
		scoreMultipleTimesTwoPlayer(game, 4);
		assertTrue(game.getPlayerTwoScore() == Points.WIN);
	}

}
