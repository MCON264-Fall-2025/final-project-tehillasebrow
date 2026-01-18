package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import java.util.*;

public class TaskManager {
    private final Deque<Task> upcoming = new LinkedList<>();
    private final Stack<Task> completed = new Stack<>();
    public void addTask(Task task) { /* TODO */
        upcoming.add(task);
    }
    public Task executeNextTask() {

        if(upcoming.isEmpty()){return null;}
        Task nextTask=upcoming.remove();
        completed.push(nextTask);
       return nextTask; }
    public Task undoLastTask() {//used a deque

        if(this.completed.isEmpty()){return null;}
        Task task = completed.pop();
       upcoming.addFirst(task);
       return task;}
    public int remainingTaskCount() {

        return upcoming.size(); }
}
