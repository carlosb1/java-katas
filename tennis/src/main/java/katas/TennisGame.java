package katas;

public class TennisGame {
	public enum Points {
		ZERO(0), FIFTEEN(15);

		private int points;

		Points(int points) {
			this.points = points;
		}
	}

	private Points playerOnePoints;

	public TennisGame() {
		this.playerOnePoints = Points.ZERO;

	}

	public final Points getPlayerOneScore() {
		return playerOnePoints;
	}

	public final Points getPlayerTwoScore() {
		return Points.ZERO;
	}

	public final void playerOneScore() {
		this.playerOnePoints = Points.FIFTEEN;
	}

}
