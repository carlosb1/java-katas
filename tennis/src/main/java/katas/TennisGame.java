package katas;

public class TennisGame {
	public enum Points {
		ZERO(0), FIFTEEN(15), THIRTY(30);

		private int points;

		Points(int points) {
			this.points = points;
		}
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

	public final void playerOneScore() {
		if (this.playerOnePoints == Points.ZERO) {
			this.playerOnePoints = Points.FIFTEEN;
		} else if (this.playerOnePoints == Points.FIFTEEN) {
			this.playerOnePoints = Points.THIRTY;
		}
	}

	public void playerTwoScore() {
		this.playerTwoPoints = Points.FIFTEEN;
	}

}
