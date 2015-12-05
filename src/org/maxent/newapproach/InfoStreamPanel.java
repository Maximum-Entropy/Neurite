package org.maxent.newapproach;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class InfoStreamPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_FONT = "Monospaced";
	private static final int DEFAULT_FONT_SIZE = 14;

	private int width;
	private int height;

	public JTextArea textbox;

	public InfoStreamPanel() {
		width = SimulationFrame.DEFAULT_WIDTH;
		height = (int) (0.25D * SimulationFrame.DEFAULT_HEIGHT);

		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.black));

		textbox = new JTextArea();
		textbox.setEditable(false);
		textbox.setLineWrap(true);
		textbox.setBackground(Color.WHITE);
		setItalic(false);

		JScrollPane scrollPane = new JScrollPane(textbox);
		scrollPane.setPreferredSize(new Dimension(width - 20, height - 12));
		scrollPane.setBorder(null);
		add(scrollPane);

		DefaultCaret caret = (DefaultCaret) textbox.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

	public void setItalic(boolean bool) {
		textbox.setFont(new Font(DEFAULT_FONT, (bool) ? Font.ITALIC : Font.PLAIN, DEFAULT_FONT_SIZE));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

}
