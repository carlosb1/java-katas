package katas;

public class TennisGame {

	public enum Status {
		DEUCE, ONEPLAYER_WIN, TWOPLAYER_WIN, NOTFINISHED, ONEPLAYER_ADVANCE, TWOPLAYER_ADVANCE;
	}

	public enum Points {
		ZERO, FIFTEEN, THIRTY, WIN, FORTY, ADVANCED
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

	private Points sumPoints(Points points) {
		Points result = Points.ZERO;
		if (points == Points.ZERO) {
			result = Points.FIFTEEN;
		} else if (points == Points.FIFTEEN) {
			result = Points.THIRTY;
		} else if (points == Points.THIRTY) {
			result = Points.FORTY;
		} else if (points == Points.FORTY) {
			if (status == Status.DEUCE) {
				result = Points.ADVANCED;
			} else {
				result = Points.WIN;
			}
		} else if (points == Points.ADVANCED) {
			result = Points.WIN;
		}
		return result;

	}

	public final void playerOneScore() {
		playerOnePoints = sumPoints(playerOnePoints);
		isDeuce();
		updateOnePlayer();
	}

	public void playerTwoScore() {
		playerTwoPoints = sumPoints(playerTwoPoints);
		isDeuce();
		updateTwoPlayer();
	}

	private void updateOnePlayer() {
		if (playerOnePoints == Points.ADVANCED) {
			status = Status.ONEPLAYER_ADVANCE;
		}
		if (playerOnePoints == Points.WIN) {
			status = Status.ONEPLAYER_WIN;
		}
	}

	private void isDeuce() {
		if (playerOnePoints == Points.FORTY && playerTwoPoints == Points.FORTY) {
			status = Status.DEUCE;
		}
	}

	private void updateTwoPlayer() {
		if (playerTwoPoints == Points.ADVANCED) {
			status = Status.TWOPLAYER_ADVANCE;
		}

		if (playerTwoPoints == Points.WIN) {
			status = Status.TWOPLAYER_WIN;
		}
	}

	public boolean isFinished() {
		return (playerOnePoints == Points.WIN || playerTwoPoints == Points.WIN);
	}

	public Status status() {
		return status;
	}

}
