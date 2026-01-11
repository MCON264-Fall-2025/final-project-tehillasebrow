package edu.course.eventplanner;
import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import edu.course.eventplanner.service.SeatingPlanner;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
public class SeatingPlannerTest {
    @Test
    void testGenerateSeating(){
        Venue venue= new Venue("Cheap Place", 1000, 300, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold1", "family")
                ,new Guest("Shira Gold2", "family"),
                new Guest("Shira Gold3", "family"),
                new Guest("Shira Gold4", "family"),
                new Guest("Shira Gold4", "family"),
                new Guest("Shira Gold5", "family"),
                new Guest("Shira Gold6", "family"),
                new Guest("Shira Gold7", "family"),
                new Guest("Shira Gold8", "family"),
                new Guest("Shira Gold9", "family"),
                new Guest("Shira Gold10", "family"),
                new Guest("Shira Gold11", "family"),
                new Guest("Shira Gold12", "coworker"),
                new Guest("Shira Gold13", "friends"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(2, seating.size());
        assertEquals(10, seating.get(10).size());//the tenth table should have 10 guests because it fills up first

    }
    @Test
    void testGenerateSeatingWithNoGuests(){
        Venue venue= new Venue("Cheap Place", 1000, 300, 10, 10);
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(List.of());
        assertEquals(0, seating.size());
    }
    @Test
    void testSeatingWith30Guests(){
        Venue venue= new Venue("Cheap Place", 1000, 300, 10, 10);
        List<Guest> guests = new java.util.ArrayList<>(List.of());
        Guest g;
                for(int i=0;i<30;i++){
                    g= new Guest("Shira Gold"+i, "family");
                    guests.add(g);
        }
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(3, seating.size()); //table size
        assertEquals(10, seating.get(10).size());
        assertFalse(seating.containsKey(3));//since i fill the tables backwards, table 3 shld not be there
        assertFalse(seating.containsKey(6));
        assertTrue(seating.containsKey(9));
        assertTrue(seating.containsKey(10));
        assertTrue(seating.containsKey(8));
        assertEquals(10, seating.get(9).size());
        assertEquals(10, seating.get(10).size());
    }

    @Test
    void testSeatingWith5Guests(){
        Venue venue = new Venue("Test", 0, 0, 10, 10);
        List<Guest> guests = List.of(
                new Guest("A","family"),
                new Guest("B","friends"),
                new Guest("C","coworkers"),
                new Guest("D","friends"),
                new Guest("E","neighbors")
        );

        Map<Integer, List<Guest>> seating =
                new SeatingPlanner(venue).generateSeating(guests);

        assertFalse(seating.isEmpty());
    }




}
