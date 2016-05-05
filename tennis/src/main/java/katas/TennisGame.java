package katas;

public class TennisGame {
	public enum Status {
		DEUCE, ONEPLAYER_WIN, TWOPLAYER_TWO, NOTFINISHED, ONEPLAYER_ADVANCE;
	}

	public enum Points {
		ZERO, FIFTEEN, THIRTY, WIN, FORTY;
	}

	// TODO split users in two clases
	private Points playerOnePoints;
	private Points playerTwoPoints;
	private Status status;

	public TennisGame() {
		this.playerOnePoints = Points.ZERO;
		this.playerTwoPoints = Points.ZERO;
		this.status = Status.NOTFINISHED;
	}

	public final Points getPlayerOneScore() {
		return playerOnePoints;
	}

	public final Points getPlayerTwoScore() {
		return playerTwoPoints;
	}

	// TODO add test for isFinshed
	private Points sumPoints(Points points) {
		Points result = Points.ZERO;
		if (points == Points.ZERO) {
			result = Points.FIFTEEN;
		} else if (points == Points.FIFTEEN) {
			result = Points.THIRTY;
		} else if (points == Points.THIRTY) {
			result = Points.FORTY;
		} else if (points == Points.FORTY && status != Status.DEUCE) {
			result = Points.WIN;
		}
		return result;
	}

	public final void playerOneScore() {
		playerOnePoints = sumPoints(playerOnePoints);
		/*
		 * if (playerOnePoints == Points.FORTY && status == Status.DEUCE) {
		 * status = Status.ONEPLAYER_ADVANCE; }
		 */

	}

	public void playerTwoScore() {
		/*
		 * if (playerTwoPoints == Points.FORTY && status == Status.DEUCE) {
		 * status = Status.ONEPLAYER_ADVANCE; }
		 */
		playerTwoPoints = sumPoints(playerTwoPoints);
	}

	public boolean isFinished() {
		return (playerOnePoints == Points.WIN || playerTwoPoints == Points.WIN);
	}

	public Status status() {
		if (playerOnePoints == Points.WIN) {
			status = Status.ONEPLAYER_WIN;
		}
		if (playerTwoPoints == Points.WIN) {
			status = Status.TWOPLAYER_TWO;
		}

		if (playerOnePoints == Points.FORTY && playerTwoPoints == Points.FORTY) {
			status = Status.DEUCE;
		}

		return status;
	}

}
