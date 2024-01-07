package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Position {
	int x = -1;
	int y = -1;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position keyToPosition(char key) {

		Position position = null;

		Map<Character, String> dic = new HashMap<>();
		dic.put('1', "0,2");
		dic.put('2', "1,2");
		dic.put('3', "2,2");
		dic.put('4', "0,1");
		dic.put('5', "1,1");
		dic.put('6', "2,1");
		dic.put('7', "0,0");
		dic.put('8', "1,0");
		dic.put('9', "2,0");

		if (dic.containsKey(key)) {
			String[] arr = dic.get(key).split(",");
			position = new Position(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
		}
		return position;
	}

	public char positionToKey(Position position) {

		char key = 'x';

		String positionStr = position.x + "," + position.y;

		Map<String, Character> dic = new HashMap<>();
		dic.put("0,2", '1');
		dic.put("1,2", '2');
		dic.put("2,2", '3');
		dic.put("0,1", '4');
		dic.put("1,1", '5');
		dic.put("2,1", '6');
		dic.put("0,0", '7');
		dic.put("1,0", '8');
		dic.put("2,0", '9');

		if (dic.containsKey(positionStr)) {
			key = dic.get(positionStr);
		}
		return key;
	}
}
