package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import java.util.*;

public class TaskManager {
    private final Queue<Task> upcoming = new LinkedList<>();
    private final Stack<Task> completed = new Stack<>();
    public void addTask(Task task) { /* TODO */
        this.upcoming.add(task);
    }
    public Task executeNextTask() {

        if(this.upcoming.isEmpty()){return null;}
        Task nextTask=this.upcoming.remove();
        this.completed.push(nextTask);
       return nextTask; }
    public Task undoLastTask() {

        if(this.completed.isEmpty()){return null;}
        Task task = this.completed.pop();
        this.upcoming.add(task);
       return task;}
    public int remainingTaskCount() {

        return this.upcoming.size(); }
}
