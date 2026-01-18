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
        System.out.println("Event Planner!");
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
you have to ask the user for input!!!!!!!
you should call the generator after getting number of guests but before the loop.
In the loop you should order a user to add a guest or remove a guest, not generate a list of guests.
The requirement is that that guest list is provided to the program and in the interactive mode user will add/remove individual guests.
*/


        Scanner sc = new Scanner(System.in);
        GuestListManager guestListManager = new GuestListManager();
        TaskManager taskManager = new TaskManager();
        VenueSelector venueSelector = new VenueSelector(Generators.generateVenues());
        Venue selectedVenue = null;
        SeatingPlanner seatingPlanner = null;
        System.out.println("How many guests do you want to add?");
        int guests = sc.nextInt();
        sc.nextLine();

        for (Guest g : Generators.GenerateGuests(guests)) {
            guestListManager.addGuest(g);
        }
        System.out.println("Guests added.");

        boolean running = true;
        while (running) {
            System.out.println("---------------------------");
            System.out.println("Welcome to the Event Planner!");
            System.out.print("Press 1 to display the menu, or any other key to exit: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); //
                continue;
            }
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    addGuest(sc, guestListManager);
                    break;
                case 3:
                    removeGuest(sc, guestListManager);
                    break;
                case 4:
                    selectedVenue = getVenue(sc, venueSelector);
                    seatingPlanner = getSeatingPlanner(selectedVenue);
                    break;
                case 5:
                    generateSeatingChart(selectedVenue, guestListManager, seatingPlanner);


                    break;
                case 6:
                    addTask(sc, taskManager);
                    break;
                case 7:
                    executeTask(taskManager);
                    break;
                case 8:

                    undoTasks(taskManager);
                    break;
                case 9:
                    eventSum(guestListManager, selectedVenue);

                    break;
                case 10:
                    running = isRunning();
                    break;
                default:
                    System.out.println("Invalid option-Try again");
                    break;

            }

        }


    }

    static boolean isRunning() {
        System.out.println("Goodbye!");
        return false;
    }

    static void eventSum(GuestListManager guestListManager, Venue selectedVenue) {
        System.out.println("Event Summary:");
        System.out.println("Total guest count: " + guestListManager.getGuestCount());
        System.out.println("Selected venue: " + (selectedVenue == null ? "None" : selectedVenue.getName()));
    }

 public static void undoTasks(TaskManager taskManager) {
     Task  unTask =taskManager.undoLastTask();
        if (unTask== null) {
            System.out.println("No tasks to undo");
        }else{
        System.out.println("Task " + unTask.getDescription() + " was undone");}
    }

    public static void executeTask(TaskManager taskManager) {
        Task task = taskManager.executeNextTask();
        if (task != null) {
            System.out.println("Task executed successfully.");
        } else {
            System.out.println("No task found");
        }
    }

    public static void addTask(Scanner sc, TaskManager taskManager) {
        System.out.println("Enter task description:");
        String taskDescription = sc.nextLine();
        taskManager.addTask(new Task(taskDescription));
        System.out.println("Task added.");
    }

    public static void generateSeatingChart(Venue selectedVenue, GuestListManager guestListManager, SeatingPlanner seatingPlanner) {
        if (selectedVenue == null) {
            System.out.println("Please select a venue first!");
        } else {
            List<Guest> allGuests = guestListManager.getAllGuests();
            Map<Integer, List<Guest>> chart = seatingPlanner.generateSeating(allGuests);
            for (Map.Entry<Integer, List<Guest>> entry : chart.entrySet()) {
                System.out.println("Table " + entry.getKey() + ": ");
                for (Guest g : entry.getValue()) {
                    System.out.println(g.getName() + " " + g.getGroupTag());
                }

            }
        }
    }

public static SeatingPlanner getSeatingPlanner(Venue selectedVenue) {
        SeatingPlanner seatingPlanner;
        if (selectedVenue != null) {
            System.out.println("Selected venue: " + selectedVenue.getName());
            seatingPlanner = new SeatingPlanner(selectedVenue);
        } else {
            System.out.println("No suitable venue found.");
            seatingPlanner = null;
        }
        return seatingPlanner;
    }

    public static Venue getVenue(Scanner sc, VenueSelector venueSelector) {
        Venue selectedVenue;
        System.out.print("Enter max budget: ");
        double budget = sc.nextDouble();
        System.out.print("Enter estimated guest count: ");
        int count = sc.nextInt();
        sc.nextLine();
        selectedVenue = venueSelector.selectVenue(budget, count);
        return selectedVenue;
    }

   public  static void removeGuest(Scanner sc, GuestListManager guestListManager) {
        System.out.print("Enter name of guest to remove: ");
        String removeName = sc.nextLine();
        boolean removed = guestListManager.removeGuest(removeName);
        if (removed) {
            System.out.println("Guest removed");
        } else {
            System.out.println("Guest not found");
        }
    }

  public  static void addGuest(Scanner sc, GuestListManager guestListManager) {
        System.out.println("Enter guest name:");
        String name = sc.nextLine();
        System.out.println("Enter group (family, friends, neighbors, coworkers): ");
        String group = sc.nextLine();
        Guest g = new Guest(name, group);
        guestListManager.addGuest(g);
        System.out.println("Guest added!");
    }

    public static void displayMenu() {
        System.out.println("Welcome to the Event Planner!");
        System.out.println("1. Display Menu");
        System.out.println("2. Add Guest");
        System.out.println("3. Remove Guest");
        System.out.println("4. Select Venue");
        System.out.println("5. Generate seating chart");
        System.out.println("6. Add preparation task");
        System.out.println("7. Execute next task");
        System.out.println("8. Undo last task");
        System.out.println("9. Print event summary");
        System.out.println("10. Exit");
    }
}

