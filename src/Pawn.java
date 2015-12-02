import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pawn {

	private List<Node> nodes;

	private Point pos;
	private int direction;

	public Pawn() {
		nodes = new ArrayList<>();
		pos = new Point(0, 0);
		direction = 360;
	}

	public void addNode(Node newNode) {
		nodes.add(newNode);
	}

	public void move(int x, int y) {
		// switch (direction % 360) {
		// case 0: // facing right
		// pos.setLocation(pos.x + y, pos.y - x);
		// break;
		// case 90: // facing up
		// pos.setLocation(pos.x + x, pos.y + y);
		// break;
		// case 180: // facing left
		// pos.setLocation(pos.x - y, pos.y + x);
		// break;
		// case 270: // facing down
		// pos.setLocation(pos.x - x, pos.y - y);
		// break;
		// }
		pos.setLocation(pos.x + x, pos.y + y);
	}

	public String executeNode(String optData) {
		String[] optDataset = optData.split(",");
		return nodes.get(Integer.parseInt(optDataset[0])).execute(this, Integer.parseInt(optDataset[1]));
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void turn(String dir) {
		switch (dir) {
		case "left":
			direction += 90;
			break;
		case "right":
			direction += -90;
			break;
		}
	}

}
