package org.sprute.oldapproach;

public class Turn implements Node {

	private String nextPort;

	public Turn(String port) {
		this.nextPort = port;
	}

	@Override
	public String execute(Pawn pawn, int option) {
		switch (option) {
		case 1:
			pawn.turn("right");
			break;
		case 2:
			pawn.turn("left");
			break;
		}

		System.out.println("Turned " + option);
		OldMain.updateDisplay();
		return nextPort;
	}

	public String toString() {
		return "Turn -> " + nextPort;
	}
}
