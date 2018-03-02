package riviera.coderz;

import riviera.coderz.model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * A car roadbook
 */
public class Roadbook {

    /**
     * Rides numbers
     */
    List<Integer> rides = new ArrayList<>();

    /**
     * Next available time for the vehicule
     */
    int nextAvailableTime = 0;

    /**
     * The vehicule latest position
     * @param inputData Input data object
     * @return Latest coordinates of the vehicule
     */
    public Point getLatestPosition(InputData inputData) {
        if(rides.isEmpty()) {
            return new Point(0,0);
        } else {
            Ride ride = inputData.rides.get(rides.get(rides.size()-1));
            return new Point(ride.x, ride.y);
        }
    }
}
