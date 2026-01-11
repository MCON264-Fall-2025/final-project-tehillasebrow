package edu.course.eventplanner;
import edu.course.eventplanner.model.Task;
import edu.course.eventplanner.service.TaskManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskManagerTest {
    @Test
    void testAddTask(){
        TaskManager manager=new TaskManager();
        Task task=new Task("Task 1");
        manager.addTask(task);
        assertEquals(1,manager.remainingTaskCount());


    }
    @Test
    void testExecuteNextTask(){
        Task task=new Task("Task 1");
        TaskManager manager=new TaskManager();
        manager.addTask(task);
        assertEquals(task,manager.executeNextTask());
        assertEquals(0,manager.remainingTaskCount());
        assertNull(manager.executeNextTask());

    }
    @Test
    void testUndoLastTask(){
        Task task=new Task("Task 1");
        TaskManager manager=new TaskManager();
        manager.addTask(task);
        manager.executeNextTask();
        assertEquals(task,manager.undoLastTask());
        assertEquals(1,manager.remainingTaskCount());
        assertNull(manager.undoLastTask());

    }
    @Test
    void testRemainingTaskCount(){
        TaskManager manager=new TaskManager();
        assertEquals(0,manager.remainingTaskCount());
        manager.addTask(new Task("Task 1"));
        assertEquals(1,manager.remainingTaskCount());
        manager.executeNextTask();
        assertEquals(0,manager.remainingTaskCount());
    }

    @Test
    void testMixedExecuteAndUndo(){
        TaskManager manager=new TaskManager();
        manager.addTask(new Task("Task 1"));
        manager.addTask(new Task("Task 2"));
        manager.executeNextTask();
        manager.undoLastTask();
        assertEquals(2,manager.remainingTaskCount());
        manager.executeNextTask();
        assertEquals(1,manager.remainingTaskCount());
        manager.undoLastTask();
        assertEquals(2,manager.remainingTaskCount());

    }
    @Test
    void testUndoWithNoCompletedTasks(){
        TaskManager manager=new TaskManager();
        manager.addTask(new Task("Task 1"));
        manager.undoLastTask();
        assertEquals(1,manager.remainingTaskCount());




    }
    @Test
    void testExecuteWithNoTasks(){
        TaskManager manager=new TaskManager();
        assertNull(manager.executeNextTask());
        assertEquals(0,manager.remainingTaskCount());

    }


}
