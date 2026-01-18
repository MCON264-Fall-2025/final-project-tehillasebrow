package edu.course.eventplanner;

import edu.course.eventplanner.util.Generators;
import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorsTest {
    @Test
    void testGenerateGuests() {

        List<Guest> guests = Generators.GenerateGuests(5);
        assertEquals(5, guests.size());


        assertEquals("friends", guests.get(4).getGroupTag());
    }

    @Test
    void testGenerateVenues() {

        List<Venue> venues = Generators.generateVenues();
        assertFalse(venues.isEmpty());
        assertEquals("Community Hall", venues.get(0).getName());
    }
}