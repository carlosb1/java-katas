package katas;

public class TennisGame {
	public enum Points {
		ZERO(0);

		private int points;

		Points(int points) {
			this.points = points;
		}
	}

	public Points getPlayerOneScore() {
		return Points.ZERO;
	}

}
