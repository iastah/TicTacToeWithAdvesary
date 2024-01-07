package tictactoe;

public class TicTacToe {

	private char[][] board = { { '7', '8', '9' }, { '4', '5', '6' }, { '1', '2', '3' } };
	private boolean isX = true;

	public char[][] getBoard() {
		char[][] newBoard = new char[3][3];
		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard.length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public void move(Player p, int x, int y) throws Exception {

		if (!(isX ^ p.toString().equals("X"))) {
			if (x >= 0 && x < 3 && y >= 0 && y < 3) {
				if (board[y][x] != 'X' && board[y][x] != 'O') {
					board[y][x] = p.toString().charAt(0);
					isX = !isX;
					Position position = new Position(x, y);
					System.out
							.println("Player " + p.toString() + " takes position " + position.positionToKey(position));
				} else {
					throw new Exception("Position is taken.");
				}
			} else {
				throw new Exception("Move not on board.");
			}
		} else {
			throw new Exception("Not player " + p.toString() + "'s turn.");
		}
	}

	public boolean isEnd() {
		int draw = 9;
		int[] verticalX = { 3, 3, 3 };
		int[] verticalO = { 3, 3, 3 };
		int diagonalXRight = 3;
		int diagonalXLeft = 3;
		int diagonalORight = 3;
		int diagonalOLeft = 3;
		for (int i = 0; i < board.length; i++) {
			int horizontalX = 3;
			int horizontalO = 3;
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X' || board[i][j] == 'O') {
					if (--draw == 0) {
						System.out.println("Draw");
						return true;
					}
				}
				if (board[i][j] == 'X') {
					if (--horizontalX == 0) {
						System.out.println("X Wins");
						return true;
					}
					if (--verticalX[j] == 0) {
						System.out.println("X Wins");
						return true;
					}
					if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
						if (--diagonalXRight == 0) {
							System.out.println("X Wins");
							return true;
						}
					}
					if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
						if (--diagonalXLeft == 0) {
							System.out.println("X Wins");
							return true;
						}
					}

				}
				if (board[i][j] == 'O') {
					if (--horizontalO == 0) {
						System.out.println("O Wins");
						return true;
					}
					if (--verticalO[j] == 0) {
						System.out.println("O Wins");
					}
					if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
						if (--diagonalORight == 0) {
							System.out.println("O Wins");
							return true;
						}
					}
					if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
						if (--diagonalOLeft == 0) {
							System.out.println("O Wins");
							return true;
						}
					}
				}
			}

		}
		return false;
	}

	public void setX(boolean isX) {
		this.isX = isX;
	}

	enum Player {
		X, O
	}

}
