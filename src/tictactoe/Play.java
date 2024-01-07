package tictactoe;

import java.util.Objects;
import java.util.Scanner;

import tictactoe.TicTacToe.Player;

public class Play {

	TicTacToe game = new TicTacToe();
	Scanner in = new Scanner(System.in);

	String player = null;
	Advesary advesary = new Advesary();

	Position position = new Position();

	boolean notValid = true;
	String input = null;

	public static void main(String[] args) {

		Play play = new Play();

		do {// get player info
			System.out.print("Pick Symbol(X or O): ");
			play.input = play.in.nextLine();
			if (play.input.equals("X") || play.input.equals("O")) {
				play.player = play.input;
				if (play.player.equals("X")) {
					play.advesary.setPlayer(Player.O);
				} else {
					play.advesary.setPlayer(Player.X);
					play.game.setX(false);
				}

				play.notValid = false;
			}

			System.out.println();
		} while (play.notValid);

		boolean isPlayer = true;

		do {// play game loop
			if (isPlayer) {
				play.playerMove();
			} else {
				play.computerMove();
			}

			isPlayer = !isPlayer;

			System.out.println();
		} while (!play.game.isEnd());

		if (Objects.nonNull(play.in)) {
			play.in.close();
		}
	}

	private void playerMove() {

		game.displayBoard();

		notValid = true;
		do {
			System.out.println();
			System.out.print("Position (1-9): ");
			input = in.nextLine();
			char key = input.charAt(0);
			if (key >= 49 && key <= 57) {
				position = position.keyToPosition(key);
				notValid = false;
			}
		} while (notValid);

		if (player.equals("X")) {
			try {
				game.move(Player.X, position.x, position.y);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (player.equals("O")) {
			try {
				game.move(Player.O, position.x, position.y);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void computerMove() {
		position = advesary.playPosition(game.getBoard());
		try {
			game.move(advesary.getPlayer(), position.x, position.y);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
