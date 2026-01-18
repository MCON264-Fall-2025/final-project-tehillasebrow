package edu.course.eventplanner;

import edu.course.eventplanner.model.*;
import edu.course.eventplanner.service.GuestListManager;
import edu.course.eventplanner.service.*;
import edu.course.eventplanner.util.Generators;
import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    @Test
    void testDisplayMenu() {
        Main.displayMenu();
    }

    @Test
    void testAddGuest() {

        GuestListManager manager = new GuestListManager();
        Scanner sc = new Scanner("Jake\nfriends\n");

        Main.addGuest(sc, manager);

        assertEquals(1, manager.getGuestCount());
    }


    @Test
    void testRemoveGuest() {
        GuestListManager manager = new GuestListManager();
        Scanner sc = new Scanner("Jake\nfriends\n");
        Main.addGuest(sc, manager);
        Scanner s = new Scanner("Jake");
        Main.removeGuest(s, manager);
        assertEquals(0, manager.getGuestCount());
        Scanner scnr = new Scanner("Jakes");
        assertNull(manager.findGuest("Jakes"));
    }

    @Test
    void testGuestNotFound() {
        GuestListManager manager = new GuestListManager();
        Scanner sc = new Scanner("Jake\nfriends\n");
        Main.addGuest(sc, manager);
        Scanner s = new Scanner("Jakes");
        Main.removeGuest(s, manager);
        assertEquals(1, manager.getGuestCount());
    }

    @Test
    void testAddTask() {
        TaskManager manager = new TaskManager();
        Scanner s = new Scanner("Do my makeup");
        Main.addTask(s, manager);
        assertEquals(1, manager.remainingTaskCount());
        assertEquals("Do my makeup", manager.executeNextTask().getDescription());
    }

    @Test
    void testExecuteNextTask() {
        TaskManager manager = new TaskManager();
        Scanner s = new Scanner("Task 1");
        Main.addTask(s, manager);
        assertEquals(1, manager.remainingTaskCount());
        s = new Scanner("Task 2");
        Main.addTask(s, manager);
        assertEquals(2, manager.remainingTaskCount());
        Main.executeTask(manager);
        assertEquals(1, manager.remainingTaskCount());
    }

    @Test
    void testUndoLastTask() {
        TaskManager manager = new TaskManager();
        Task t1 = new Task("Task 1");
        manager.addTask(t1);
        assertEquals(1, manager.remainingTaskCount());
        manager.addTask(new Task("Task 2"));
        assertEquals(2, manager.remainingTaskCount());
        manager.executeNextTask();
        assertEquals(1, manager.remainingTaskCount());
        assertEquals(t1, manager.undoLastTask());
    }

    @Test
    void testRemainingTaskCount() {
        TaskManager manager = new TaskManager();
        assertEquals(0, manager.remainingTaskCount());
        manager.addTask(new Task("Task 1"));
        assertEquals(1, manager.remainingTaskCount());
    }

    @Test
    void testGetVenue() {

        VenueSelector selector =
                new VenueSelector(Generators.generateVenues());

        Scanner sc = new Scanner("5000\n50\n");

        Venue venue = Main.getVenue(sc, selector);

        assertNotNull(venue);


    }

    @Test
    void testSeatingPlanner() {
        Venue venue = new Venue("Hall", 10, 1000, 10, 10);
        SeatingPlanner planner = new SeatingPlanner(venue);
        assertNotNull(planner);


    }

    @Test
    void testGenerateSeatingChartnoVenue() {
        GuestListManager manager = new GuestListManager();
        Main.generateSeatingChart(null, manager, null);
    }

    @Test
    void testGenerateSeatingChartwithVenue() {
        Venue venue = new Venue("Hall", 10, 1000, 10, 10);
        SeatingPlanner planner = new SeatingPlanner(venue);
        GuestListManager manager = new GuestListManager();
        manager.addGuest(new Guest("Yaakov", "friends"));
        Main.generateSeatingChart(venue, manager, planner);
    }


    @Test
    void testEventSummary() {
        GuestListManager manager = new GuestListManager();
        manager.addGuest(new Guest("Abie", "family"));
        Venue venue = new Venue("Hall", 50, 3000, 10, 10);
        Main.eventSum(manager, venue);
        assertEquals(1, manager.getGuestCount());
        assertEquals(10, venue.getTables());//table 10 is the right table because the last one fills up first
        assertEquals("Hall", venue.getName());

    }

    @Test
    void testIsRunning() {
        assertFalse(Main.isRunning());

    }

    @Test
    void testUndoTasksBranches() {
        TaskManager manager = new TaskManager();

        Main.undoTasks(manager);

        manager.addTask(new Task("Final Exam"));
        manager.executeNextTask();
        Main.undoTasks(manager);
        assertEquals(1, manager.remainingTaskCount());
    }

    @Test
    void testExecuteTaskEmpty() {
        TaskManager manager = new TaskManager();
        Main.executeTask(manager);
    }

    @Test
    void testGetSeatingPlanner() {
        assertNull(Main.getSeatingPlanner(null));
        Venue v = new Venue("Sands", 100, 10, 1, 10);
        assertNotNull(Main.getSeatingPlanner(v));
    }
}
