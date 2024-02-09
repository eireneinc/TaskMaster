// TaskMaster.java
package taskmaster;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskMaster {

    private static final List<Task> tasks = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        customizeLookAndFeel();

        // Load your logo.png using the provided absolute path
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\raile\\OneDrive\\Documents\\NetBeansProjects\\TaskMaster\\src\\taskmaster\\logo.png");

        // Create a smaller version of the logo
        ImageIcon smallLogoIcon = new ImageIcon(logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        // Create a panel for the first dialog
        JPanel panel = new JPanel(new BorderLayout());

        // Add the "Enter Your Name" label to the panel
        JLabel enterNameLabel = new JLabel("Enter Your Name:");
        enterNameLabel.setHorizontalAlignment(JLabel.CENTER);
        Font labelFont = new Font("Sans-serif", Font.BOLD, 18); // Adjusted font size
        enterNameLabel.setFont(labelFont);
        enterNameLabel.setForeground(Color.WHITE);
        panel.add(enterNameLabel, BorderLayout.SOUTH);

        // Add the logo to the panel
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(logoLabel, BorderLayout.CENTER);

        // Prompt the user for their name
        String username = (String) JOptionPane.showInputDialog(
                null,
                panel,
                "TaskMaster",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");

        if (username == null) {
            System.exit(0);
        }
 
        String dateToday = getDateToday();
        String welcomeMessage = String.format(
                "<html><div style='text-align: center; margin: 10px;'>Welcome to TASKMASTER, %s!<br>"
                + "<font color='orange'>Today is %s.</font><br>"
                + "This Java-based task manager system is created for students.<br>"
                + "This program enables users to create and manage various task categories, such as <br> <font color='blue'>School Tasks,</font> <font color='yellow'>Home Tasks,</font> and <font color='red'>Personal Tasks.</font></div></html>",
                username, dateToday);
        JLabel welcomeLabel = new JLabel(welcomeMessage);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        Font welcomeFont = new Font("Sans-serif", Font.BOLD, 14); // Adjusted font size
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);

        // Create a panel for the second welcome dialog
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.setBackground(new Color(105, 105, 105)); // Dim Gray color

        // Add the welcome label to the center of the panel
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the logo label to the south of the panel
        welcomePanel.add(logoLabel, BorderLayout.NORTH);

        Object[] options = {"How does TaskMaster work?", "Continue to TaskMaster", "Exit"};
        int welcomeChoice = JOptionPane.showOptionDialog(
                null,
                welcomePanel,
                "TaskMaster",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (welcomeChoice == 0) {
            displayHowItWorks();
        } else if (welcomeChoice == 1) {
            showTasksButtons();
        } else {
            // Exit the program when the user selects "Exit"
            System.exit(0);
        }
    }

// Method to display a dialog explaining how TaskMaster works
    private static void displayHowItWorks() {
        String howItWorksMessage = "<html>"
                + "<div style='text-align: left; margin: 10px;'>"
                + "<font color='orange'>Task Creation:</font><br>"
                + "    - Users can add tasks categorized as School, Home, or Personal tasks.<br>"
                + "    - Each category prompts the user for specific details related to that task type (e.g., due date for School tasks, location for Home tasks).<br>"
                + "    - After gathering information, the program creates an instance of the appropriate task type (e.g., SchoolTask, HomeTask) and adds it to the list of tasks.<br>"
                + "<br>"
                + "<font color='orange'>Task Editing:</font><br>"
                + "    - Users can edit existing tasks from the list.<br>"
                + "    - The program displays a list of tasks, and the user selects the task to edit by entering the corresponding task number.<br>"
                + "    - Users can then modify the title, description, or priority of the selected task.<br>"
                + "<br>"
                + "<font color='orange'>Task Marking as Done:</font><br>"
                + "    - Users can mark tasks as done, removing them from the list.<br>"
                + "    - The program displays a list of tasks, and the user selects the task to mark as done by entering the corresponding task number.<br>"
                + "    - The selected task is displayed, marked as done, and removed from the task list.<br>"
                + "<br>"
                + "<font color='orange'>Display All Tasks with Filters:</font><br>"
                + "    - Users can choose to display all tasks and filter them by pending or finished tasks.<br>"
                + "    - The program provides options to view 'Pending Tasks' or 'Finished Tasks'.<br>"
                + "<br>"
                + "<font color='orange'>Filter Tasks by Category:</font><br>"
                + "    - Users can filter tasks based on the chosen category (School, Home, or Personal).<br>"
                + "    - The program displays a list of tasks within the selected category, or informs the user if there are no tasks in the chosen category.<br>"
                + "<br>"
                + "<font color='orange'>Delete Task:</font><br>"
                + "    - Users can delete tasks from the list.<br>"
                + "    - The program displays a list of pending tasks, and the user selects the task to delete by entering the corresponding task number.<br>"
                + "    - The selected task is removed from the task list.<br>"
                + "<br>"
                + "<font color='orange'>View Calendar:</font><br>"
                + "    - Users can view a calendar that displays due dates and reminder dates for tasks.<br>"
                + "    - The program checks each task's type (School, Home) to determine the appropriate date to display.<br>"
                + "    - For School tasks, it displays the due date, and for Home tasks, it displays the reminder date.<br>"
                + "    - The calendar includes all tasks, both pending and finished, sorted by their respective dates.<br>"
                + "    - Users can quickly check upcoming events and deadlines with this calendar feature.<br>"
                + "<br>"
                + "<font color='orange'>Exit Option:</font><br>"
                + "    - Users can choose to exit the program, ending the loop that allows them to perform various tasks."
                + "</div></html>";

        int userChoice = JOptionPane.showOptionDialog(
                null,
                howItWorksMessage,
                "How TaskMaster Works",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK"
        );

        if (userChoice == JOptionPane.OK_OPTION) {
            showTasksButtons();
        }
    }

// Method to customize the look and feel of the GUI
    private static void customizeLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Font customFont = new Font("Sans-serif", Font.BOLD, 12);
            UIManager.put("OptionPane.messageFont", customFont);
            UIManager.put("OptionPane.buttonFont", customFont);
            UIManager.put("OptionPane.minimumSize", new Dimension(400, 200)); // Adjusted minimum size
            UIManager.put("OptionPane.background", new Color(169, 169, 169)); // French Gray
            UIManager.put("OptionPane.messageForeground", Color.WHITE); // White color
            UIManager.put("Panel.background", new Color(105, 105, 105)); // Dim Gray color
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// Method to get the current date in the specified format
    private static String getDateToday() {
        Date date = new Date();
        return dateFormat.format(date);

    }

// Method to display the main menu with task-related options
    private static void showTasksButtons() {
        boolean continueAddingTasks = true;

        while (continueAddingTasks) {
            String[] taskOptions = {
                "Add a School Task", "Add a Home Task", "Add a Personal Task", "Edit a Task", "Mark a Task as Done",
                "Display All Tasks", "Filter Tasks by Category", "Delete Task", "View Calendar", "Exit"
            };

            JPanel panel = new JPanel(new GridLayout(0, 2, 20, 20)); // Increased horizontal and vertical spacing

            // Add empty borders for margins
            panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

            for (String option : taskOptions) {
                JButton button = new JButton(option);
                button.addActionListener(e -> handleButtonClick(button.getText()));

                // Set button colors and font size
                button.setBackground(new Color(105, 105, 105)); // DimGray
                button.setForeground(new Color(105, 105, 105)); // White
                button.setFont(new Font("Sans-serif", Font.BOLD, 16)); // Adjusted font size

                panel.add(button);
            }

            // Add logo to the panel
            ImageIcon logoIcon = new ImageIcon("C:\\Users\\raile\\OneDrive\\Documents\\NetBeansProjects\\TaskMaster\\src\\taskmaster\\logo.png");
            JButton logoButton = new JButton(logoIcon);
            logoButton.setBorderPainted(false);
            logoButton.setContentAreaFilled(false);
            logoButton.setFocusPainted(false);
            logoButton.setOpaque(false);

            // Create a Box to center-align the logo
            Box logoBox = Box.createHorizontalBox();
            logoBox.add(Box.createHorizontalGlue());
            logoBox.add(logoButton);
            logoBox.add(Box.createHorizontalGlue());

            panel.add(logoBox);

            // Create a custom dialog without an "OK" button
            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("TaskMaster");
            dialog.setModal(true);

            // Set a minimum size for the dialog
            dialog.setMinimumSize(new Dimension(500, 100));

            // Center align the panel
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);

            dialog.add(panel);
            dialog.setIconImage(logoIcon.getImage());

            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            if (!dialog.isDisplayable()) {
                continueAddingTasks = false; // Exit the loop if the user closes the dialog
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "<html><div style='text-align: center; margin: 10px;'><font color='yellow'>Best of luck on all of your tasks - </font>"
                + "believe in yourself and let your hard work shine!</div></html>",
                "Good Luck!",
                JOptionPane.PLAIN_MESSAGE
        );

        System.exit(0);
    }

// Method to handle button clicks in the main menu
    private static void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "Add a School Task":
                createAndDisplayTask("School");
                break;
            case "Add a Home Task":
                createAndDisplayTask("Home");
                break;
            case "Add a Personal Task":
                createAndDisplayTask("Personal");
                break;
            case "Edit a Task":
                editTask();
                break;
            case "Mark a Task as Done":
                markTaskAsDone();
                break;
            case "Display All Tasks":
                displayAllTasks();
                break;
            case "Filter Tasks by Category":
                filterTasksByCategory();
                break;
            case "Delete Task":
                deleteTask();
                break;
            case "View Calendar":
                viewCalendar();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
                break;
        }
    }

// Method to create and display a new task based on the task type
    private static void createAndDisplayTask(String taskType) {
        String title = JOptionPane.showInputDialog("Enter Title:");
        if (title == null) {
            return;
        }

        String description = JOptionPane.showInputDialog("Enter Description:");
        int priority = Integer.parseInt(JOptionPane.showInputDialog("Enter Priority [1 being the least priority]:"));

        if (taskType.equals("School")) {
            String dueDate = JOptionPane.showInputDialog("Enter Due Date:");
            String assignedTo = JOptionPane.showInputDialog("Enter Assigned To:");

            SchoolTask schoolTask = new SchoolTask(title, description, priority, dueDate, assignedTo);
            tasks.add(schoolTask);
            displayTaskDetails(schoolTask);
        } else if (taskType.equals("Home")) {
            String reminderDate = JOptionPane.showInputDialog("Enter Reminder Date:");
            String isUrgent = JOptionPane.showInputDialog("Is it Urgent? (yes/no):");

            HomeTask homeTask = new HomeTask(title, description, priority, reminderDate, isUrgent, dateFormat);
            tasks.add(homeTask);
            displayTaskDetails(homeTask);
        } else if (taskType.equals("Personal")) {
            String reminderDate = JOptionPane.showInputDialog("Enter Reminder Date:");
            String isFavorite = JOptionPane.showInputDialog("Is it a favorite task? (yes/no):");

            PersonalTask personalTask = new PersonalTask(title, description, priority, reminderDate, isFavorite);
            tasks.add(personalTask);
            displayTaskDetails(personalTask);
        }
    }

// Method to filter tasks based on the selected category
    private static void filterTasksByCategory() {
        String[] categories = {"School", "Home", "Personal"};
        String selectedCategory = (String) JOptionPane.showInputDialog(null, "Choose a category to filter tasks:", "Filter Tasks",
                JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);

        if (selectedCategory != null) {
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : tasks) {
                if ((task instanceof SchoolTask && selectedCategory.equals("School"))
                        || (task instanceof HomeTask && selectedCategory.equals("Home"))
                        || (task instanceof PersonalTask && selectedCategory.equals("Personal"))) {
                    filteredTasks.add(task);
                }
            }

            if (!filteredTasks.isEmpty()) {
                displayAllTasksWithStartButton(filteredTasks);
            } else {
                JOptionPane.showMessageDialog(null, "No tasks found in the selected category.");
            }
        }
    }

// Method to mark a task as done
    private static void markTaskAsDone() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to mark as done.");
            return;
        }

        StringBuilder tasksInfo = new StringBuilder("Pending Tasks:\n");
        List<Task> pendingTasks = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!task.isDone()) {
                tasksInfo.append(pendingTasks.size() + 1).append(": ").append(task).append("\n");
                pendingTasks.add(task);
            }
        }

        if (!pendingTasks.isEmpty()) {
            String userInput = JOptionPane.showInputDialog(null, tasksInfo.toString() + "Enter the number of the task to mark as done (or Cancel to exit):");

            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Marking task as done canceled.");
                return;
            }

            try {
                int taskNumber = Integer.parseInt(userInput);

                if (taskNumber >= 1 && taskNumber <= pendingTasks.size()) {
                    Task task = pendingTasks.get(taskNumber - 1);
                    task.markAsDone();
                    JOptionPane.showMessageDialog(null, "Task marked as done!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid task number. No task marked as done.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid task number.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No pending tasks to mark as done.");
        }
    }

// Method to view the calendar displaying due dates and reminder dates
    private static void viewCalendar() {
        StringBuilder calendarMessage = new StringBuilder("Due Dates and Reminder Dates:\n");

        for (Task task : tasks) {
            if (task instanceof DatedTask datedTask) {
                calendarMessage.append(datedTask.getFormattedDueDate()).append(": ").append(task.getTitle()).append("\n");
            } else if (task instanceof HomeTask homeTask) {
                calendarMessage.append(homeTask.getFormattedReminderDate()).append(": ").append(task.getTitle()).append("\n");
            }
        }

        if (calendarMessage.length() == 33) {
            calendarMessage.append("No tasks with due dates or reminder dates.");
        }

        JOptionPane.showMessageDialog(
                null,
                calendarMessage.toString(),
                "View Calendar",
                JOptionPane.PLAIN_MESSAGE
        );
    }

// Method to display all tasks with buttons for additional actions
    private static void displayAllTasksWithStartButton(List<Task> tasks) {
        Collections.sort(tasks, Collections.reverseOrder());

        StringBuilder tasksInfo = new StringBuilder("All Tasks Sorted by Priority:\n");
        for (int i = 0; i < tasks.size(); i++) {
            tasksInfo.append("Task ").append(i + 1).append(":\n");
            tasksInfo.append(tasks.get(i)).append("\n");
            if (tasks.get(i) instanceof SchoolTask) {
                tasksInfo.append("Due Date: ").append(((SchoolTask) tasks.get(i)).getDueDate()).append("\n");
                tasksInfo.append("Assigned To: ").append(((SchoolTask) tasks.get(i)).getAssignedTo()).append("\n\n");
            } else if (tasks.get(i) instanceof HomeTask) {
                tasksInfo.append("Location: ").append(((HomeTask) tasks.get(i)).getReminderDate()).append("\n");
                tasksInfo.append("Is it Urgent? ").append(((HomeTask) tasks.get(i)).getUrgent()).append("\n\n");
            } else if (tasks.get(i) instanceof PersonalTask) {
                tasksInfo.append("Reminder Date: ").append(((PersonalTask) tasks.get(i)).getReminderDate()).append("\n");
                tasksInfo.append("Is it a Favorite Task? ").append(((PersonalTask) tasks.get(i)).getFavorite()).append("\n\n");
            }
        }

        int userChoice = JOptionPane.showOptionDialog(
                null,
                tasksInfo.toString(),
                "All Tasks by Priority",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK"
        );
    }

// Method to display task details in a dialog
    private static void displayTaskDetails(Task task) {
        JOptionPane.showMessageDialog(null, "Task Details:\n" + task);
    }

// Method to edit an existing task
    private static void editTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to edit.");
            return;
        }

        StringBuilder tasksInfo = new StringBuilder("Tasks:\n");
        for (int i = 0; i < tasks.size(); i++) {
            tasksInfo.append(i + 1).append(": ").append(tasks.get(i)).append("\n");
        }

        String userInput = JOptionPane.showInputDialog(null, tasksInfo.toString() + "Enter the number of the task to edit (or Cancel to exit):");

        if (userInput == null) {
            JOptionPane.showMessageDialog(null, "Editing task canceled.");
            return;
        }

        try {
            int taskNumber = Integer.parseInt(userInput);

            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Task task = tasks.get(taskNumber - 1);

                String newTitle = JOptionPane.showInputDialog("Enter new Title (Press Enter to keep the current title):");
                if (newTitle != null) {
                    task.setTitle(newTitle);
                }

                String newDescription = JOptionPane.showInputDialog("Enter new Description (Press Enter to keep the current description):");
                if (newDescription != null) {
                    task.setDescription(newDescription);
                }

                String newPriority = JOptionPane.showInputDialog("Enter new Priority (Press Enter to keep the current priority):");
                if (newPriority != null) {
                    task.setPriority(Integer.parseInt(newPriority));
                }

                displayTaskDetails(task);
                JOptionPane.showMessageDialog(null, "Task Updated!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid task number. No task updated.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid task number.");
        }
    }

// Method to display all tasks with filter buttons
    private static void displayAllTasksWithFilterButtons(List<Task> tasks) {
        Collections.sort(tasks);

        StringBuilder tasksInfo = new StringBuilder("All Tasks Sorted by Priority:\n");
        for (int i = 0; i < tasks.size(); i++) {
            tasksInfo.append("Task ").append(i + 1).append(":\n");
            Task task = tasks.get(i);
            tasksInfo.append(getTaskInfoWithCategoryColors(task)).append("\n");
            if (task instanceof SchoolTask) {
                tasksInfo.append("Due Date: ").append(((SchoolTask) task).getDueDate()).append("\n");
                tasksInfo.append("Assigned To: ").append(((SchoolTask) task).getAssignedTo()).append("\n\n");
            } else if (task instanceof HomeTask) {
                tasksInfo.append("Location: ").append(((HomeTask) task).getReminderDate()).append("\n");
                tasksInfo.append("Is it Urgent? ").append(((HomeTask) task).getUrgent()).append("\n\n");
            } else if (task instanceof PersonalTask) {
                tasksInfo.append("Reminder Date: ").append(((PersonalTask) task).getReminderDate()).append("\n");
                tasksInfo.append("Is it a Favorite Task? ").append(((PersonalTask) task).getFavorite()).append("\n\n");
            }
        }

        int userChoice = JOptionPane.showOptionDialog(
                null,
                tasksInfo.toString(),
                "All Tasks by Priority",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK"
        );
    }

// Method to get task information with category colors
    private static String getTaskInfoWithCategoryColors(Task task) {
        String category = "";
        String categoryColor = "";

        if (task instanceof SchoolTask) {
            category = "School Task";
            categoryColor = "blue"; // Change to your desired color
        } else if (task instanceof HomeTask) {
            category = "Home Task";
            categoryColor = "yellow";
        } else if (task instanceof PersonalTask) {
            category = "Personal Task";
            categoryColor = "red";
        }

        return "<html><font color='" + categoryColor + "'>Category: " + category + "<br>" + task;

    }

// Method to get category color based on task category
    private static String getCategoryColor(String category) {
        // Define color codes for each category
        switch (category) {
            case "School Task":
                return "blue";
            case "Home Task":
                return "yellow";
            case "Personal Task":
                return "red";
            default:
                return "black";
        }
    }

// Method to display all tasks with various filter options
    private static void displayAllTasks() {
        Object[] options = {"Show All Tasks", "Show Pending Tasks", "Show Finished Tasks", "Cancel"};
        int filterChoice = JOptionPane.showOptionDialog(
                null,
                "Choose a filter option:",
                "Filter Tasks",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (filterChoice == 3) {
            return;
        }

        List<Task> filteredTasks = new ArrayList<>(tasks);

        switch (filterChoice) {
            case 1:
                filteredTasks.removeIf(Task::isDone);
                break;
            case 2:
                filteredTasks.removeIf(task -> !task.isDone());
                break;
        }

        displayAllTasksWithFilterButtons(filteredTasks);
    }

// Method to display pending tasks
    private static void displayPendingTasks(List<Task> tasks) {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isDone() && !task.isStarted()) {
                pendingTasks.add(task);
            }
        }

        if (!pendingTasks.isEmpty()) {
            displayAllTasksWithFilterButtons(pendingTasks);
        } else {
            JOptionPane.showMessageDialog(null, "No pending tasks found.");
        }
    }

// Method to delete a task
    private static void deleteTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to delete.");
            return;
        }

        StringBuilder tasksInfo = new StringBuilder("Pending Tasks:\n");
        List<Task> pendingTasks = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!task.isDone()) {
                tasksInfo.append(pendingTasks.size() + 1).append(": ").append(task).append("\n");
                pendingTasks.add(task);
            }
        }

        if (!pendingTasks.isEmpty()) {
            String userInput = JOptionPane.showInputDialog(null, tasksInfo.toString() + "Enter the number of the task to delete (or Cancel to exit):");

            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Deleting task canceled.");
                return;
            }

            try {
                int taskNumber = Integer.parseInt(userInput);

                if (taskNumber >= 1 && taskNumber <= pendingTasks.size()) {
                    Task task = pendingTasks.get(taskNumber - 1);
                    tasks.remove(task);

                    JOptionPane.showMessageDialog(null, "Task deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid task number. No task deleted.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid task number.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No pending tasks to delete.");
        }
    }
}
