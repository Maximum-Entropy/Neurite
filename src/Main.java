
public class Main {

	private static DisplayPanel display;
	private static int frame;
	private static int cutoff;

	public static void main(String args[]) {
		frame = 0;
		cutoff = 20;

		Pawn derk = new Pawn();
		initialize(derk);
		display = new DisplayPanel(derk);

		runSim(derk);

	}

	private static void initialize(Pawn p) {
		p.addNode(new Move("1,1")); // 0
		p.addNode(new Turn("2,2")); // 1
		p.addNode(new Move("3,2")); // 2
		p.addNode(new Turn("0,1")); // 3
	}

	private static void runSim(Pawn p) {
		String nextOpt = p.executeNode("0,0");
		while (frame < cutoff) {
			nextOpt = p.executeNode(nextOpt);
			frame++;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateDisplay() {
		display.repaint();
	}

}
