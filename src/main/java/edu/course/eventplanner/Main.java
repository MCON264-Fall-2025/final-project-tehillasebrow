package edu.course.eventplanner;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Task;
import edu.course.eventplanner.service.GuestListManager;
import edu.course.eventplanner.service.SeatingPlanner;
import edu.course.eventplanner.service.TaskManager;
import edu.course.eventplanner.service.VenueSelector;
import edu.course.eventplanner.model.Venue;
import edu.course.eventplanner.util.*;

import java.util.Map;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Event Planner Mini — see README for instructions.");
        /* Required Console Menu
Load sample data
Add guest
Remove guest
Select venue
Generate seating chart
Add preparation task
Execute next task
Undo last task
Print event summary
you have to ask the user for input!!!!!!!*/


    Scanner sc=new Scanner(System.in);
    GuestListManager  guestListManager=new GuestListManager();
    TaskManager taskManager = new TaskManager();
    VenueSelector venueSelector= new VenueSelector(Generators.generateVenues());
    Venue selectedVenue = null;
    SeatingPlanner seatingPlanner = null;

   boolean running=true;
while(running) {
    System.out.println("---------------------------");
    System.out.println("Welcome to the Event Planner!");
    System.out.print("\n 1. Load Sample Data\n 2. Add Guest \n 3. Remove Guest \n4. Select Venue\n 5.Generate seating chart\n" +
            "6. Add preparation task\n" +
            "7. Execute next task\n" +
            "8. Undo last task\n" +
            "9. Print event summary\n 10. Exit");
    if (!sc.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number.");
        sc.next(); //
        continue;}
   int num=sc.nextInt();
    sc.nextLine();
    switch (num) {
        case 1:
            System.out.println("How many guests do you want to add?");
            int guests = sc.nextInt();
            sc.nextLine();

            for (Guest g : Generators.GenerateGuests(guests)) {
                guestListManager.addGuest(g);
            }
            System.out.println("Guests added.");
            break;
        case 2:
            System.out.println("Enter guest name:");
            String name = sc.nextLine();
            System.out.println("Enter group (family, friends, neighbors, coworkers): ");
            String group = sc.nextLine();
            Guest g = new Guest(name, group);
            guestListManager.addGuest(g);
            break;
        case 3:
            System.out.print("Enter name of guest to remove: ");
            String removeName = sc.nextLine();
            boolean removed = guestListManager.removeGuest(removeName);
            if (removed) {
                System.out.println("Guest removed");
            } else {
                System.out.println("Guest not found");
            }
            break;
        case 4:
            System.out.print("Enter max budget: ");
            double budget = sc.nextDouble();
            System.out.print("Enter estimated guest count: ");
            int count = sc.nextInt();
            sc.nextLine();
            selectedVenue = venueSelector.selectVenue(budget, count);
            if (selectedVenue != null) {
                System.out.println("Selected venue: " + selectedVenue.getName());
                seatingPlanner = new SeatingPlanner(selectedVenue);
            } else {
                System.out.println("No suitable venue found.");
                selectedVenue = null;
                seatingPlanner = null;
            }
            break;
        case 5:
            if (selectedVenue == null || seatingPlanner == null) {
                System.out.println("Please select a venue first!");
            } else {
                List<Guest> allGuests = guestListManager.getAllGuests();
                Map<Integer, List<Guest>> chart = seatingPlanner.generateSeating(allGuests);
                for (Map.Entry<Integer, List<Guest>> entry : chart.entrySet()) {
                    System.out.println("Table " + entry.getKey() + ": " + entry.getValue());
                }
            }


            break;
        case 6:
            System.out.println("Enter task description:");
            String taskDescription = sc.nextLine();
            taskManager.addTask(new Task(taskDescription));
            System.out.println("Task added.");
            break;
        case 7:
            taskManager.executeNextTask();
            System.out.println("Task "+ taskManager.executeNextTask() +"executed.");
            break;
        case 8:

            System.out.println("Task "+ taskManager.undoLastTask() +" was undone");
            break;
        case 9:
            System.out.println("Event Summary:");
            System.out.println("Total guest count: " + guestListManager.getGuestCount());
            System.out.println("Selected venue: " + (selectedVenue == null ? "None" : selectedVenue.getName()));

            break;
        case 10:
            System.out.println("Goodbye!");
            running = false;
            break;
        default:
            System.out.println("Invalid option-Try again");
            break;

    }

}




    }}

