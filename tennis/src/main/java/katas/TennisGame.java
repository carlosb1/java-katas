package katas;

public class TennisGame {
	public enum Points {
		ZERO(0);

		private int points;

		Points(int points) {
			this.points = points;
		}
	}

	// TODO add final classes
	public Points getPlayerOneScore() {
		return Points.ZERO;
	}

	public Points getPlayerTwoScore() {
		return Points.ZERO;
	}

}
