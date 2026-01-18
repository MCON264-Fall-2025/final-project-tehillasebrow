package edu.course.eventplanner.service;

import edu.course.eventplanner.model.*;

import java.util.*;

public class SeatingPlanner {
    private final Venue venue;

    public SeatingPlanner(Venue venue) {
        this.venue = venue;
    }

    public Map<Integer, List<Guest>> generateSeating(List<Guest> guests) {
        Map<String, Queue<Guest>> groupQueues = new LinkedHashMap<>();
// We use a LinkedHashMap to preserve the order of groups
        for (Guest guest : guests) {
            groupQueues.computeIfAbsent(guest.getGroupTag(), k -> new LinkedList<>()).add(guest);
        }


//goes through the guest list and adds them to the right queue according to their tag

        int tablesctr = venue.getTables();
        int seatsPerTablectr = venue.getSeatsPerTable();
        int capacity = venue.getCapacity();


        Map<Integer, List<Guest>> map = new TreeMap<>();
//goes through the family list and adds them to the tables first. Table 10 fills up first, then table 9 ect...
        for (Queue<Guest> queue : groupQueues.values()) {
            while (!queue.isEmpty()) {
                map.computeIfAbsent(tablesctr, k -> new ArrayList<>()).add(queue.remove());
                seatsPerTablectr--;
                if (seatsPerTablectr == 0 && tablesctr > 0) {
                    tablesctr--;
                    seatsPerTablectr = venue.getSeatsPerTable();
                }
            }

        }

        return map;
    }
}
//put comments in the code