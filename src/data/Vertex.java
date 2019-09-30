package data;

public class Vertex extends BasicVertex {

    private int x, y;

    public static final int MAX_X = 160, MAX_Y = 120;

    public Vertex(int x, int y) {
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