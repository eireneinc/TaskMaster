// SchoolTask.java
package taskmaster;

public class SchoolTask extends Task implements DatedTask {
    private String dueDate;
    private String assignedTo;

    // Constructor for creating a SchoolTask
    public SchoolTask(String title, String description, int priority, String dueDate, String assignedTo) {
        super(title, description, priority);
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
    }

    // Override method to display detailed information about the SchoolTask
    @Override
    public void displayTaskDetails() {
        super.displayTaskDetails();  // Call the superclass method
        System.out.println("Due Date: " + dueDate);
        System.out.println("Assigned To: " + assignedTo);
    }

    // Getter method for retrieving the due date
    public String getDueDate() {
        return dueDate;
    }

    // Override method to get a formatted version of the due date
    @Override
    public String getFormattedDueDate() {
        // Adjust formatting of due date as needed...
        return getDueDate();
    }

    // Override method to get the title of the SchoolTask
    @Override
    public String getTitle() {
        return super.getTitle(); // Call the superclass method
    }

    // Getter method for retrieving the assigned person
    public String getAssignedTo() {
        return assignedTo;
    }

    // Not implemented yet; needs to be defined in a subclass
    @Override
    public Object getDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
