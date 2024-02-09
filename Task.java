package taskmaster;

import java.util.Date;

// Abstract class representing a generic Task with common attributes and behaviors
public abstract class Task implements Displayable, Comparable<Task> {
    private String title;        // Title of the task
    private String description;  // Description of the task
    private int priority;        // Priority of the task
    private boolean isDone;      // Indicating whether the task is done or not
    private boolean started;     // Indicating whether the task has been started or not

    // Constructor to initialize the common attributes of a task
    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDone = false;      // A new task is initialized as not done
        this.started = false;     // A new task is initialized as not started
    }

    // Getter method to check if the task has been started
    public boolean isStarted() {
        return started;
    }

    // Setter method to update the started status of the task
    public void setStarted(boolean started) {
        this.started = started;
    }

    // Getter method to check if the task is done
    public boolean isDone() {
        return isDone;
    }

    // Method to mark the task as done
    public void markAsDone() {
        isDone = true;
    }

    // Method to display details of the task
    public void displayTaskDetails() {
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + (isDone ? "Done" : "Pending"));
    }

    // Implementation of the Comparable interface to compare tasks based on priority
    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(otherTask.priority, this.priority);
    }

    // Override toString method to provide a string representation of the task
    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nPriority: " + priority +
                "\nStatus: " + (isDone ? "Done" : "Pending");
    }

    // Setter method to update the title of the task
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter method to update the description of the task
    public void setDescription(String description) {
        this.description = description;
    }

    // Setter method to update the priority of the task
    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Getter method to retrieve the title of the task
    public String getTitle() {
        return title;
    }
}
