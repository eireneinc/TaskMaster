// DatedTask.java
package taskmaster;

// Interface for tasks with date-related information
public interface DatedTask {
    String getFormattedDueDate();
    String getTitle();
    Object getDate();  // To be implemented by subclasses
}
