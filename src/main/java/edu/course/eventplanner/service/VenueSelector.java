package edu.course.eventplanner.service;

import com.sun.source.tree.BinaryTree;
import edu.course.eventplanner.model.Venue;

import java.util.*;

public class VenueSelector {
    private final List<Venue> venues;

    public VenueSelector(List<Venue> venues) {
        this.venues = venues;
    }

    public Venue selectVenue(double budget, int guestCount) {
        TreeMap<Venue, Venue> map = new TreeMap<>(
                (v1, v2) -> {
                    int budgetComp = Double.compare(v1.getCost(), v2.getCost());
                    if (budgetComp == 0) {
                        return budgetComp;
                    }
                    return Integer.compare(v1.getCapacity(), v2.getCapacity());
                }
        );


        for (Venue venue : venues) {
            if (venue.getCost() <= budget && venue.getCapacity() >= guestCount) {
                map.put(venue, venue);
            }
        }
        if (map.isEmpty()) {
            return null; // Return null if no venue fits
        }

        return map.firstEntry().getValue();
    }
}

