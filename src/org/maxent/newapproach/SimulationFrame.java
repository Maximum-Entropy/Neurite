package org.maxent.newapproach;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

public class SimulationFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 700;

	private DisplayPanel display;
	private InfoStreamPanel stream;

	public SimulationFrame() {
		display = new DisplayPanel();
		stream = new InfoStreamPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(display, BorderLayout.CENTER);
		getContentPane().add(stream, BorderLayout.SOUTH);
		pack();

		setTitle("Neuraphite by Maximum-Entropy - v1.0.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		moveToCenter();
		setVisible(true);
	}

	public void print(String outputText) {
		stream.textbox.append(outputText);
	}

	public void println(String outputText) {
		stream.textbox.append(outputText + "\n");
	}

	private void moveToCenter() {
		GraphicsEnvironment screen = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Dimension effectiveScreenSize = screen.getMaximumWindowBounds().getSize();
		Dimension frameSize = getSize();
		Point preferredNW = new Point((effectiveScreenSize.width - frameSize.width) / 2,
				(effectiveScreenSize.height - frameSize.height) / 2);
		setLocation(preferredNW);
	}

}
