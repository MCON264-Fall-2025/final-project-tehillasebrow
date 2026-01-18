package edu.course.eventplanner;
import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.service.GuestListManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GuestListManagerTest {
    @Test
    public void testAddGuest(){
        GuestListManager guestListManager = new GuestListManager();
        Guest g=new Guest("Shira Gold", "family");
        guestListManager.addGuest(g);
        assertEquals(1,guestListManager.getGuestCount());
        assertEquals("Shira Gold", guestListManager.getAllGuests().getFirst().getName());
        assertEquals("family", guestListManager.getAllGuests().getFirst().getGroupTag());
    }
    @Test
    public void testRemoveGuest(){
        GuestListManager guestListManager = new GuestListManager();
        Guest g=new Guest("Shira Gold", "family");
        guestListManager.addGuest(g);
        guestListManager.removeGuest("Shira Gold");
        assertEquals(0,guestListManager.getGuestCount());
        assertEquals(0,guestListManager.getAllGuests().size());
        assertNull(guestListManager.findGuest("Shira Gold"));

    }
    @Test
    public void testFindGuest(){
        GuestListManager guestListManager = new GuestListManager();
        Guest g=new Guest("Shira Gold", "family");
        guestListManager.addGuest(g);
        assertEquals(g,guestListManager.findGuest("Shira Gold"));
        assertNull(guestListManager.findGuest("John Doe"));


    }
    @Test
    void testAddDuplicateGuest() {
        GuestListManager manager = new GuestListManager();
        Guest g = new Guest("DOUBLE TROUBLE", "family");

        manager.addGuest(g);
        manager.addGuest(g); // Try adding the same guest again

        // The count should still be 1, and the "else" branch should have been skipped
        assertEquals(1, manager.getGuestCount());
    }
}

