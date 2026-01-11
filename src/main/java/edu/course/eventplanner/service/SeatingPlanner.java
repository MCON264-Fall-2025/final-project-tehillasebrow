package edu.course.eventplanner.service;

import edu.course.eventplanner.model.*;

import java.util.*;

public class SeatingPlanner {
    private final Venue venue;

    public SeatingPlanner(Venue venue) {
        this.venue = venue;
    }

    public Map<Integer, List<Guest>> generateSeating(List<Guest> guests) {

        Queue<Guest> famQueue = new LinkedList<>();
        Queue<Guest> frndQueue = new LinkedList<>();
        Queue<Guest> nbrQueue = new LinkedList<>();
        Queue<Guest> cwrkrQueue = new LinkedList<>();

//goes through the guest list and adds them to the right queue according to their tag
        for (Guest guest : guests) {
            if (Objects.equals(guest.getGroupTag(), "family")) {
                famQueue.add(guest);
            }
            if (Objects.equals(guest.getGroupTag(), "friends"))
                frndQueue.add(guest);
            if (Objects.equals(guest.getGroupTag(), "neighbors"))
                nbrQueue.add(guest);
            if (Objects.equals(guest.getGroupTag(), "coworkers"))
                cwrkrQueue.add(guest);
        }
        int tablesctr = venue.getTables();
        int seatsPerTablectr = venue.getSeatsPerTable();
        int capacity = venue.getCapacity();



        Map<Integer, List<Guest>> map = new TreeMap<>();
//goes through the family list and adds them to the tables first. Table 10 fills up first, then table 9 ect...

        while (!famQueue.isEmpty()) {
            map.computeIfAbsent(tablesctr, k -> new ArrayList<>()).add(famQueue.remove());
            seatsPerTablectr--;
            if (seatsPerTablectr == 0 && tablesctr > 0) {//when the seats get to 0, we decrease the table number and add seats back to the seats per table ctr
                tablesctr--;
                seatsPerTablectr = venue.getSeatsPerTable();
            }
            if (tablesctr == 0) {//if the table number is 0, we return the map because we have filled all the tables

                return map;
            }
        }

        while (!frndQueue.isEmpty()) {
            map.computeIfAbsent(tablesctr, k -> new ArrayList<>()).add(frndQueue.remove());
            seatsPerTablectr--;
            if (seatsPerTablectr == 0 && tablesctr >0) {
                tablesctr--;
                seatsPerTablectr = venue.getSeatsPerTable();

            }
            if (tablesctr == 0) {

                return map;
            }
        }
        while (!nbrQueue.isEmpty()) {
            map.computeIfAbsent(tablesctr, k -> new ArrayList<>()).add(nbrQueue.remove());
            seatsPerTablectr--;
            if (seatsPerTablectr == 0 && tablesctr > 0) {
                tablesctr--;
                seatsPerTablectr = venue.getSeatsPerTable();

            }
            if (tablesctr == 0) {

                return map;
            }
        }
        while (!cwrkrQueue.isEmpty()) {
            map.computeIfAbsent(tablesctr, k -> new ArrayList<>()).add(cwrkrQueue.remove());
            seatsPerTablectr--;
            if (seatsPerTablectr == 0 && tablesctr > 0) {
                tablesctr--;
                seatsPerTablectr = venue.getSeatsPerTable();

            }
            if (tablesctr == 0) {

                return map;
            }
        }


        return map;
    }
}
//put comments in the code