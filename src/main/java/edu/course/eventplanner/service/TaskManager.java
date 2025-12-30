package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import java.util.*;

public class TaskManager {
    private final Queue<Task> upcoming = new LinkedList<>();
    private final Stack<Task> completed = new Stack<>();
    public void addTask(Task task) { /* TODO */
    upcoming.add(task);}
    public Task executeNextTask() {
        System.out.println("Executing next task");
        completed.push(upcoming.remove());
       return completed.peek(); }
    public Task undoLastTask() {
        System.out.println("Undoing last task");
        Task task = completed.pop();
        upcoming.add(task);
       return task;}
    public int remainingTaskCount() { return upcoming.size(); }
}
