package tictactoe;

public interface Condition {
	public Position findAdvesaryResult();

	public void calcCondition();

	public int getValue();
}
