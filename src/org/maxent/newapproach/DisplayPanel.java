package org.maxent.newapproach;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;

	public DisplayPanel() {
		width = SimulationFrame.DEFAULT_WIDTH;
		height = (int) (0.75D * SimulationFrame.DEFAULT_HEIGHT);

		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

}
