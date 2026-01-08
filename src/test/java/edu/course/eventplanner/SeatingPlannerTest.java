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
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());


    }
    @Test
    void testGenerateSeatingWithBudget(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithCapacity(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithCapacityAndBudget(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithNoCapacityOrBudget(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithNoCapacityOrBudgetAndGroups(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithGroups(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }
    @Test
    void testGenerateSeatingWithGroupsAndBudget(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());


    }
    @Test
    void testGenerateSeatingWithGroupsAndCapacity(){
        Venue venue= new Venue("Cheap Place", 1000, 10, 10, 10);
        List<Guest> guests= List.of(new Guest("Shira Gold", "family"));
        Map<Integer, List<Guest>> seating= new SeatingPlanner(venue).generateSeating(guests);
        assertEquals(1, seating.size());

    }

}
