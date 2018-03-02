package riviera.coderz.model;

/**
 * Class representing a point
 */
public class Point {

    /**
     * X coordinate
     */
    int x;

    /**
     * Y coordinate
     */
    int y;

    public Point(int x, int y) {
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
