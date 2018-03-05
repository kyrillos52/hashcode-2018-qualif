Riviera Coderz solution for the HashCode 2018 competition
======================
Description of the algorithm used (AlgorithmHashCode2018.java)
1. We create a roadbook per vehicule
2. Then, we loop from the time T 0 to the rides latest finish f. 
For each counter time, we loop over the roadbook of each vehicule available (not driving at the current time) and find the ride with the shortest starting ride (it includes the distance to go to the ride from the vehicule current position and the earliest time s). Once the ride selected, we set the next available time and remove the ride from the list of rides to perform.
