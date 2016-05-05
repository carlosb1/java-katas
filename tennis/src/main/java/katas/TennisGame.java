package katas;

public class TennisGame {
	public class Player {
		private Points points;

		public Player() {
			points = Points.ZERO;
		}

		public Points getPoints() {
			return points;
		}

		public void score(Status status) {
			if (points == Points.ZERO) {
				points = Points.FIFTEEN;
			} else if (points == Points.FIFTEEN) {
				points = Points.THIRTY;
			} else if (points == Points.THIRTY) {
				points = Points.FORTY;
			} else if (points == Points.FORTY) {
				if (status == Status.DEUCE) {
					points = Points.ADVANCED;
				} else {
					points = Points.WIN;
				}
			} else if (points == Points.ADVANCED) {
				points = Points.WIN;
			}
		}
	}

	public enum Status {
		DEUCE, ONEPLAYER_WIN, TWOPLAYER_WIN, NOTFINISHED, ONEPLAYER_ADVANCE, TWOPLAYER_ADVANCE;
	}

	public enum Points {
		ZERO, FIFTEEN, THIRTY, WIN, FORTY, ADVANCED
	}

	private Status status;

	private final Player player1;
	private final Player player2;

	public TennisGame() {
		this.player1 = new Player();
		this.player2 = new Player();

		this.status = Status.NOTFINISHED;
	}

	public final Points getPlayerOneScore() {
		return player1.getPoints();
	}

	public final Points getPlayerTwoScore() {
		return player2.getPoints();
	}

	public final void playerOneScore() {
		player1.score(status);
		updateOnePlayer();
		isDeuce();

	}

	public void playerTwoScore() {
		player2.score(status);
		updateTwoPlayer();
		isDeuce();
	}

	private void updateOnePlayer() {
		if (player1.getPoints() == Points.ADVANCED) {
			status = Status.ONEPLAYER_ADVANCE;
		}
		if (player1.getPoints() == Points.WIN) {
			status = Status.ONEPLAYER_WIN;
		}
	}

	private void isDeuce() {
		if (player1.getPoints() == Points.FORTY && player2.getPoints() == Points.FORTY) {
			status = Status.DEUCE;
		}
	}

	private void updateTwoPlayer() {
		if (player2.getPoints() == Points.ADVANCED) {
			status = Status.TWOPLAYER_ADVANCE;
		}

		if (player2.getPoints() == Points.WIN) {
			status = Status.TWOPLAYER_WIN;
		}
	}

	public boolean isFinished() {
		return (player1.getPoints() == Points.WIN || player2.getPoints() == Points.WIN);
	}

	public Status status() {
		return status;
	}

}
