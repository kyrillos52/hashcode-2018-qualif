package riviera.coderz;

import riviera.coderz.model.Point;

import java.util.*;

/**
 * Hash Code Input data
 */
public class InputData {

    /**
     * START Parser input info
     */

    /**
     * number of rows of the grid
     */
    int r = 0;

    /**
     * – number of columns of the grid
     */
    int c = 0;

    /**
     * number of vehicles in the fleet
     */
    int f = 0;

    /**
     * number of rides
     */
    int n = 0;

    /**
     * per-ride bonus for starting the ride on time
     */
    int b = 0;

    /**
     *  number of steps in the simulation
     */
    int t = 0;

    /**
     * Rides
     */
    List<Ride> rides = new ArrayList<>();

    /**
     * END Parser input info
     */

    /**
     * Find the ride with the max latest finish
     * @return Get the ride with the max latest finish
     */
    public int getLatestEnd() {
        return sortLatestEnd().get(rides.size()-1).f;
    }

    /**
     * Sort the input ride list with the latest finish
     * @return ride list sorted with the latest finish
     */
    public List<Ride> sortLatestEnd() {
        List<Ride> newRide = new ArrayList<>(rides);
        Collections.sort(newRide, new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                return o1.f - o2.f;
            }
        });
        return newRide;
    }

    /**
     * Sort the rides with the shortest time to start a ride
     * First, we remove all ride where the time to reach the end of the ride will be more than the latest finish time
     * Then we sort the rides with the closest starting time considering the time to reach the target
     * @param rides List of rides
     * @param currentTime The current time in the selected timeline
     * @param currentPosition The current position of the car
     * @return List of rides sorted
     */
    public List<Ride> getShortestStartRides(List<Ride> rides, int currentTime, Point currentPosition) {
        List<Ride> newRide = new ArrayList<>(rides);
        Iterator<Ride> iterator = newRide.iterator();
        while (iterator.hasNext()) {
            Ride ride = iterator.next();
            if(ride.getTimeToStartRide(currentTime + ride.getDistanceToRide(currentPosition.getX(), currentPosition.getY())) + ride.getDistanceToFinishRide() > ride.f) {
                iterator.remove();
            }
        }
        Collections.sort(newRide, new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                int timeToStart1 = o1.getTimeToStartRide(currentTime + o1.getDistanceToRide(currentPosition.getX(), currentPosition.getY())) ;
                int timeToStart2 = o2.getTimeToStartRide(currentTime + o2.getDistanceToRide(currentPosition.getX(), currentPosition.getY()));

                if(timeToStart1 == timeToStart2) {
                    return  (currentTime - o2.s) - (currentTime - o1.s);
                } else {
                    return timeToStart1 - timeToStart2;
                }
            }
        });
        return newRide;
    }

}
