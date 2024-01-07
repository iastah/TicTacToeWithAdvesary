package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tictactoe.TicTacToe.Player;

public class Advesary {

	private Player player = null;

	public Position playPosition(char[][] board) {
		Position result = null;

		if (!isCenterTaken(board)) {
			result = new Position(1, 1);
		} else {
			AdvesaryCondition condition = new AdvesaryCondition(player, board);
			result = playWin(condition);
			if (Objects.nonNull(result)) {
				return result;
			}

			result = playLose(condition);
			if (Objects.nonNull(result)) {
				return result;
			}

			result = playDefense(board);

		}
		return result;
	}

	private Position playWin(AdvesaryCondition condition) {
		Position result = null;

		List<Condition> conditions = condition.getConditions();
		for (Condition c : conditions) {
			if (c.getValue() == 2) {
				result = c.findAdvesaryResult();
				break;
			}
		}

		return result;
	}

	private Position playLose(AdvesaryCondition condition) {
		Position result = null;

		List<Condition> conditions = condition.getConditions();
		for (Condition c : conditions) {
			if (c.getValue() == -2) {
				result = c.findAdvesaryResult();
				break;
			}
		}

		return result;
	}

	private Position playDefense(char[][] board) {
		Position result = null;

		List<List<AdvesaryState>> stateRank = createStateRank(board);

		for (int i = 0; i < stateRank.size(); i++) {
			if (!stateRank.get(i).isEmpty()) {
				int randomIndex = (int) (Math.random() * stateRank.get(i).size());
				result = stateRank.get(i).get(randomIndex).getResult();
				break;
			}
		}

		return result;
	}

	private List<List<AdvesaryState>> createStateRank(char[][] board) {

		List<List<AdvesaryState>> stateRank = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			List<AdvesaryState> list = new ArrayList<>();
			stateRank.add(list);
		}

		List<AdvesaryState> states = createStates(board);

		for (AdvesaryState state : states) {
			int count = 0;
			AdvesaryCondition condition = new AdvesaryCondition(player, state.getBoard());
			for (Condition c : condition.getConditions()) {
				if (c.getValue() == -3) {
					count++;
				}
			}
			stateRank.get(count).add(state);
		}

		return stateRank;
	}

	private boolean isCenterTaken(char[][] board) {
		if (board[1][1] != 'X' && board[1][1] != 'O') {
			return false;
		}
		return true;
	}

	private List<AdvesaryState> createStates(char[][] board) {
		List<AdvesaryState> stateList = new ArrayList<>();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] != 'X' && board[y][x] != 'O') {
					stateList.add(createState(board, x, y));
				}
			}
		}
		return stateList;
	}

	private AdvesaryState createState(char[][] board, int x, int y) {
		char[][] newBoard = copyBoard(board);
		editBoard(x, y, newBoard);
		fillBoard(newBoard);

		AdvesaryState advesaryState = new AdvesaryState();
		advesaryState.setResult(new Position(x, y));
		advesaryState.setBoard(newBoard);

		return advesaryState;
	}

	private char[][] copyBoard(char[][] board) {
		char[][] newBoard = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	private void editBoard(int x, int y, char[][] board) {
		if (player == Player.X) {
			board[y][x] = 'X';
		} else if (player == Player.O) {
			board[y][x] = 'O';
		}
	}

	private void fillBoard(char[][] board) {
		char value = 'x';
		if (player == Player.X) {
			value = 'O';
		} else if (player == Player.O) {
			value = 'X';
		}

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] != 'X' && board[y][x] != 'O') {
					board[y][x] = value;
				}
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
