// PersonalTask.java
package taskmaster;

import java.text.SimpleDateFormat;

public class PersonalTask extends Task implements DatedTask {
    private String reminderDate;
    private String favorite;

    // Constructor for creating a PersonalTask
    public PersonalTask(String title, String description, int priority, String reminderDate, String favorite) {
        super(title, description, priority);
        this.reminderDate = reminderDate;
        this.favorite = favorite;
    }

    // Override method to display detailed information about the PersonalTask
    @Override
    public void displayTaskDetails() {
        super.displayTaskDetails();  // Call the superclass method
        System.out.println("Reminder Date: " + reminderDate);
        System.out.println("Is it a Favorite Task? " + favorite);
    }

    // Getter method for retrieving the reminder date
    public String getReminderDate() {
        return reminderDate;
    }

    // Getter method for retrieving whether it is a favorite task
    public String getFavorite() {
        return favorite;
    }

    // Override method to get a formatted version of the reminder date
    @Override
    public String getFormattedDueDate() {
        return reminderDate;
    }

    // Override method to get the title of the PersonalTask
    @Override
    public String getTitle() {
        return super.getTitle();
    }

    // Not implemented yet; needs to be defined in a subclass
    @Override
    public Object getDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
