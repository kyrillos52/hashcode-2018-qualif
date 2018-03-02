package riviera.coderz;

public class Ride {

    /**
     * the row of the start intersection
     */
    int a = 0;

    /**
     * the column of the start intersection
     */
    int b = 0;

    /**
     * the row of the finish intersection
     */
    int x = 0;

    /**
     * the column of the finish intersection
     */
    int y = 0;

    /**
     * the earliest start
     */
    int s = 0;

    /**
     * the latest finish
     */
    int f = 0;

    /**
     * Number ride
     */
    int nbRide = 0;

    /**
     * The distance for a coordinate to reach the ride
     * @param x X coordinate to start
     * @param y Y coordinate to start
     * @return Distance to the ride
     */
    public int getDistanceToRide(int x, int y) {
        return Math.abs(x-a)+Math.abs(y-b);
    }

    /**
     * The distance to reach the destination from the starting point
     * @return The distance to reach the destination from the starting point
     */
    public int getDistanceToFinishRide() {
        return Math.abs(a-x)+Math.abs(b-y);
    }

    /**
     * The time to start the ride
     * It can be the current time if we have already reached the start
     * or the start
     * @param currentTime Current time
     * @return
     */
    public int getTimeToStartRide(int currentTime) {
        return  Math.max(currentTime, s);
    }
}
