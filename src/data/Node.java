package data;

public class Node extends BasicNode {

    private int x, y;

    public static final int MAX_X = 160, MAX_Y = 120;

    public Node(int x, int y) {
        if (x < 0 || x > MAX_X ||
            y < 0 || y > MAX_Y) {
            throw new IllegalArgumentException("Coordinates not within bounds (" + MAX_X + ", " + MAX_Y + ").");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}