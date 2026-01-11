package edu.course.eventplanner;
import edu.course.eventplanner.model.Venue;
import edu.course.eventplanner.service.VenueSelector;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class VenueSelectorTest {
@Test
    void testSelectVenueWithBudget(){
    Venue cheapPlace= new Venue("Cheap Place", 1000, 10, 10, 10);
    Venue mediumPlace= new Venue("Medium Place", 2000, 10, 10, 10);
    Venue expensivePlace= new Venue("Expensive Place", 3000, 10, 10, 10);
    List<Venue> venues= List.of(cheapPlace, mediumPlace, expensivePlace);
    VenueSelector selector= new VenueSelector(venues);
    Venue selectedVenue= selector.selectVenue(2500, 10);
    assertEquals(mediumPlace, selectedVenue);

    }
    @Test
    void testSelectVenueWithNoCapacity(){
        Venue cheapPlace= new Venue("Cheap Place", 1000, 10, 10, 10);
        Venue mediumPlace= new Venue("Medium Place", 2000, 10, 10, 10);
        Venue expensivePlace= new Venue("Expensive Place", 3000, 10, 10, 10);
        List<Venue> venues= List.of(cheapPlace, mediumPlace, expensivePlace);
        VenueSelector selector= new VenueSelector(venues);
        Venue selectedVenue= selector.selectVenue(2500, 20);
        assertNull(selectedVenue);
    }
    @Test
    void testSelectVenueWithNoCapacityAndNoBudget(){
        Venue cheapPlace= new Venue("Cheap Place", 1000, 10, 10, 10);
        Venue mediumPlace= new Venue("Medium Place", 2000, 10, 10, 10);
        Venue expensivePlace= new Venue("Expensive Place", 3000, 10, 10, 10);
        List<Venue> venues= List.of(cheapPlace, mediumPlace, expensivePlace);
        VenueSelector selector= new VenueSelector(venues);
        Venue selectedVenue= selector.selectVenue(0, 20);
        assertNull(selectedVenue);

    }

}
