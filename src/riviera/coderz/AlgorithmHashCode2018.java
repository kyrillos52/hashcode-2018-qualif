package riviera.coderz;

import java.util.*;

/**
 * Final Hashcode algorithm
 */
public class AlgorithmHashCode2018 implements Algorithm {

    @Override
    public OutputData compute(InputData inputData) {
        OutputData outputData = new OutputData();

        List<Ride> newRideList = new ArrayList<>(inputData.rides);

        /**
         * We create a roadbook per vehicule
         */
        List<Roadbook> roadbooks = new ArrayList<>(inputData.f);
        for(int counterVehicule = 0; counterVehicule < inputData.f; counterVehicule++) {
            roadbooks.add(new Roadbook());
        }

        /**
         * We have a counter that will count the time from 0 to the latest end
         * For each vehicule available (not driving), we will take the ride the shortest start ride
         * And remove from the ride list with a vehicule not available until the distance to reach the ride and finish the ride
         */
        for (int counterTime = 0; counterTime < inputData.getLatestEnd(); counterTime++) {
            for(Roadbook roadbook : roadbooks) {
                if(roadbook.nextAvailableTime <= counterTime && !newRideList.isEmpty()) {
                    List<Ride> shortestRides = inputData.getShortestStartRides(newRideList, counterTime, roadbook.getLatestPosition(inputData));

                    if (!shortestRides.isEmpty()) {
                        Ride shortestRide = shortestRides.get(0);
                        if(!roadbook.rides.contains(shortestRide.nbRide)) {
                            roadbook.rides.add(shortestRide.nbRide);
                            roadbook.nextAvailableTime = shortestRide.getTimeToStartRide(counterTime) + shortestRide.getDistanceToFinishRide();
                        }
                        newRideList.remove(shortestRide);
                    }
                }
            }
        }
        outputData.roadbooks = roadbooks;
        return outputData;
    }


}
