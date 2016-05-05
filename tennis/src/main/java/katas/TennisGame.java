package katas;

public class TennisGame {
	public enum Points {
		ZERO, FIFTEEN, THIRTY, WIN;
	}

	private Points playerOnePoints;
	private Points playerTwoPoints;

	public TennisGame() {
		this.playerOnePoints = Points.ZERO;
		this.playerTwoPoints = Points.ZERO;
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
		}
		return result;
	}

	public final void playerOneScore() {
		playerOnePoints = sumPoints(playerOnePoints);
	}

	public void playerTwoScore() {
		playerTwoPoints = sumPoints(playerTwoPoints);
	}

	public boolean isFinished() {
		return (playerOnePoints == Points.WIN || playerTwoPoints == Points.WIN);
	}

}
