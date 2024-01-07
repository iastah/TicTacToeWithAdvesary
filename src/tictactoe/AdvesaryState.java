package tictactoe;

public class AdvesaryState {
	private char[][] board;
	private Position result;

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public Position getResult() {
		return result;
	}

	public void setResult(Position result) {
		this.result = result;
	}

}
