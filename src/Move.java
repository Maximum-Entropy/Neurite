
public class Move implements Node {

	private String nextPort;

	public Move(String port) {
		this.nextPort = port;
	}

	@Override
	public String execute(Pawn pawn, int option) {
		switch (option) {
		case 1: // right
			pawn.move(1, 0);
			break;
		case 2: // up
			pawn.move(0, -1);
			break;
		case 3: // left
			pawn.move(-1, 0);
			break;
		case 4: // down
			pawn.move(0, 1);
			break;
		}

		System.out.println("Moved " + option);
		Main.updateDisplay();
		return nextPort;
	}

	public String toString() {
		return "Move -> " + nextPort;
	}
}
