// HomeTask.java
package taskmaster;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeTask extends Task {
    private String reminderDate;
    private String urgent;
    private SimpleDateFormat dateFormat;  // Add this line to store the SimpleDateFormat

    // Constructor for creating a HomeTask
    public HomeTask(String title, String description, int priority, String reminderDate, String urgent, SimpleDateFormat dateFormat) {
        super(title, description, priority);
        this.reminderDate = reminderDate;
        this.urgent = urgent;
        this.dateFormat = dateFormat;  // Initialize dateFormat in the constructor
    }

    // Override method to display detailed information about the HomeTask
    @Override
    public void displayTaskDetails() {
        super.displayTaskDetails();  // Call the superclass method
        System.out.println("Reminder Date: " + reminderDate);
        System.out.println("Is it Urgent? " + urgent);
    }

    // Getter method for retrieving the reminder date
    public String getReminderDate() {
        return reminderDate;
    }

    // Getter method for retrieving whether it is urgent
    public String getUrgent() {
        return urgent;
    }

    // Setter method for updating the reminder date
    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    // Override method to get a formatted version of the reminder date
    public String getFormattedReminderDate() {
        try {
            // Parse the reminderDate as Date before formatting
            Date date = dateFormat.parse(reminderDate);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Date";
        }
    }
}
