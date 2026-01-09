package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import java.util.*;

public class TaskManager {
    private final Queue<Task> upcoming = new LinkedList<>();
    private final Stack<Task> completed = new Stack<>();
    public void addTask(Task task) { /* TODO */
        upcoming.add(task);
    }
    public Task executeNextTask() {

        if(upcoming.isEmpty()){return null;}
        Task nextTask=upcoming.remove();
        completed.push(nextTask);
       return nextTask; }
    public Task undoLastTask() {

        if(completed.isEmpty()){return null;}
        Task task = completed.pop();
        upcoming.add(task);
       return task;}
    public int remainingTaskCount() {
        if(upcoming.isEmpty()){return 0;}
        return upcoming.size()-1; }
}
