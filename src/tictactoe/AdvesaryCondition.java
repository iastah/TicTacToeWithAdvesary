package tictactoe;

import java.util.ArrayList;
import java.util.List;

import tictactoe.TicTacToe.Player;

public class AdvesaryCondition {

	private List<Condition> conditions = null;
	private Player player;
	private char[][] board;

	public AdvesaryCondition(Player player, char[][] board) {
		conditions = new ArrayList<>();
		conditions.add(new Row1());
		conditions.add(new Row2());
		conditions.add(new Row3());
		conditions.add(new Col1());
		conditions.add(new Col2());
		conditions.add(new Col3());
		conditions.add(new Slash());
		conditions.add(new BackSlash());

		this.player = player;
		this.board = board;

		for (Condition c : conditions) {
			c.calcCondition();
		}
	}

	class Row1 implements Condition {

		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int x = 0; x < board.length; x++) {
				if (board[0][x] != 'O' && board[0][x] != 'X') {
					result.x = x;
					result.y = 0;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int x = 0; x < board.length; x++) {
				if (board[0][x] != 'X' && board[0][x] != 'O') {

				} else {
					if (board[0][x] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}

	}

	class Row2 implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int x = 0; x < board.length; x++) {
				if (board[1][x] != 'O' && board[1][x] != 'X') {
					result.x = x;
					result.y = 1;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int x = 0; x < board.length; x++) {
				if (board[1][x] != 'X' && board[1][x] != 'O') {

				} else {
					if (board[1][x] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class Row3 implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int x = 0; x < board.length; x++) {
				if (board[2][x] != 'O' && board[2][x] != 'X') {
					result.x = x;
					result.y = 2;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int x = 0; x < board.length; x++) {
				if (board[2][x] != 'X' && board[2][x] != 'O') {

				} else {
					if (board[2][x] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class Col1 implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int y = 0; y < board.length; y++) {
				if (board[y][0] != 'O' && board[y][0] != 'X') {
					result.x = 0;
					result.y = y;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int y = 0; y < board.length; y++) {
				if (board[y][0] != 'X' && board[y][0] != 'O') {

				} else {
					if (board[y][0] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class Col2 implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int y = 0; y < board.length; y++) {
				if (board[y][1] != 'O' && board[y][1] != 'X') {
					result.x = 1;
					result.y = y;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int y = 0; y < board.length; y++) {
				if (board[y][1] != 'X' && board[y][1] != 'O') {

				} else {
					if (board[y][1] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class Col3 implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			for (int y = 0; y < board.length; y++) {
				if (board[y][2] != 'O' && board[y][2] != 'X') {
					result.x = 2;
					result.y = y;
					break;
				}
			}
			return result;
		}

		@Override
		public void calcCondition() {
			for (int y = 0; y < board.length; y++) {
				if (board[y][2] != 'X' && board[y][2] != 'O') {

				} else {
					if (board[y][2] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class Slash implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			int x = 2;
			int y = 0;

			while (x >= 0 && y < 3) {
				if (board[y][x] != 'O' && board[y][x] != 'X') {
					result.x = x;
					result.y = y;
					break;
				}
				x--;
				y++;
			}

			return result;
		}

		@Override
		public void calcCondition() {

			int x = 2;
			int y = 0;

			while (x >= 0 && y < 3) {
				if (board[y][x] != 'O' && board[y][x] != 'X') {

				} else {
					if (board[y][x] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
				x--;
				y++;
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	class BackSlash implements Condition {
		int value = 0;

		@Override
		public Position findAdvesaryResult() {
			Position result = new Position();

			int x = 0;
			int y = 0;

			while (x < 3 && y < 3) {
				if (board[y][x] != 'O' && board[y][x] != 'X') {
					result.x = x;
					result.y = y;
					break;
				}
				x++;
				y++;
			}

			return result;
		}

		@Override
		public void calcCondition() {

			int x = 0;
			int y = 0;

			while (x < 3 && y < 3) {
				if (board[y][x] != 'O' && board[y][x] != 'X') {

				} else {
					if (board[y][x] == player.toString().charAt(0)) {
						value++;
					} else {
						value--;
					}
				}
				x++;
				y++;
			}
		}

		@Override
		public int getValue() {
			return value;
		}
	}

	public List<Condition> getConditions() {
		List<Condition> newConditions = new ArrayList<>(conditions);
		return newConditions;
	}
}
