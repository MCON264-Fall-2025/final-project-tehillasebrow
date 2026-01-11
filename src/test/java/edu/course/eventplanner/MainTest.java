package edu.course.eventplanner;

import edu.course.eventplanner.model.Task;
import edu.course.eventplanner.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest
{
    @Test
    void testMain() {

    }
    @Test
    void testLoadSampleData() {

    }

    @Test
    void testDisplayMenu() {
        Main.displayMenu();

    }
    @Test
    void testProcessUserInput() {


    }
    @Test
    void testRun() {

    }
    @Test
    void testExit() {

    }
    @Test
    void testAddGuest(){}
    @Test
    void testFindGuest(){}
    @Test
    void testRemoveGuest(){}

    @Test
    void testAddTask(){
        TaskManager manager=new TaskManager();
        manager.addTask(new Task("Task 1"));
        assertEquals(1,manager.remainingTaskCount());
    }
    @Test
    void testExecuteNextTask(){
        TaskManager manager=new TaskManager();
        manager.addTask(new Task("Task 1"));
        assertEquals(1,manager.remainingTaskCount());
        manager.addTask(new Task("Task 2"));
        assertEquals(2,manager.remainingTaskCount());
       Task t= manager.executeNextTask();
      assertEquals("Task 1",t.getDescription())  ;
        assertEquals(1,manager.remainingTaskCount());
    }
    @Test
    void testUndoLastTask(){}
    @Test
    void testRemainingTaskCount(){}
    @Test
    void testPrintTaskHistory(){}
    @Test
    void testPrintGuestList(){}
    @Test
  void testGetVenue(){}
    @Test
    void testSeatingPlanner(){}
    @Test
    void testGenerateSeatingChart(){}
    @Test
    void testEventSummary(){}
    @Test
    void testIsRunning(){}
}
