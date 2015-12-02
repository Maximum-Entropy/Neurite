import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private static final long serialVersionUID = -8059655900101336627L;

	private final int WIDTH = 800;
	private final int boxX = 21;
	private final int HEIGHT = 800;
	private final int boxY = 21;

	private int boxWidth;
	private int boxHeight;

	private JFrame frame;

	private Pawn pawn;

	public DisplayPanel(Pawn p) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		centerFrame();

		pawn = p;

		boxWidth = WIDTH / boxX;
		boxHeight = HEIGHT / boxY;

		setBackground(Color.WHITE);
		frame.setVisible(true);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		for (int boxXNum = 0; boxXNum < boxX; boxXNum++)
			for (int boxYNum = 0; boxYNum < boxY; boxYNum++) {
				g.drawRect(boxXNum * boxWidth, boxYNum * boxHeight, boxWidth, boxHeight);
			}

		int pawnX = (int) ((pawn.getPos().getX() + boxX / 2) * boxWidth) + boxWidth / 2;
		int pawnY = (int) ((pawn.getPos().getY() + boxY / 2) * boxHeight) + boxHeight / 2;
		g.setColor(Color.BLACK);
		g.fillOval(pawnX - boxWidth / 2, pawnY - boxHeight / 2, boxWidth, boxHeight);
		g.setColor(Color.RED);
		g.drawLine(pawnX, pawnY, (int) getSightPos(pawnX, pawnY).getX(), (int) getSightPos(pawnX, pawnY).getY());
	}

	private Point getSightPos(int pawnX, int pawnY) {
		while (pawn.getDirection() < 0)
			pawn.setDirection(pawn.getDirection() + 360);
		switch (pawn.getDirection() % 360) {
		case 0: // facing right
			return new Point(pawnX + boxWidth, pawnY);
		case 90: // facing up
			return new Point(pawnX, pawnY - boxHeight);
		case 180: // facing left
			return new Point(pawnX - boxWidth, pawnY);
		case 270: // facing down
			return new Point(pawnX, pawnY + boxHeight);
		}
		return null;
	}

	private void centerFrame() {
		GraphicsEnvironment screen = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Dimension effectiveScreenSize = screen.getMaximumWindowBounds().getSize();
		Dimension frameSize = frame.getSize();
		Point preferredNW = new Point((effectiveScreenSize.width - frameSize.width) / 2,
				(effectiveScreenSize.height - frameSize.height) / 2);
		frame.setLocation(preferredNW);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
