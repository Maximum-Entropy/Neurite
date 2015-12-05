package org.maxent.newapproach;
public class Simulation implements Runnable {

	private final int INITIAL_POPULATION_SIZE = 10;
	private final String POSITIONING_SCHEME = "random";

	private SimulationFrame frame;

	public Simulation() {
		frame = new SimulationFrame();
	}

	@Override
	public void run() {
		frame.println("Generating initial population of " + INITIAL_POPULATION_SIZE + " individuals ...");
		frame.println(" └─> " + "Positioning scheme: " + POSITIONING_SCHEME);
	}

	public static void main(String[] args) {
		new Simulation().run();
	}
}
