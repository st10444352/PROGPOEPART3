package easykanbanpoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class CreationMenu extends JFrame {
    private final EasyKanban3POE app;

    public CreationMenu(EasyKanban3POE app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        setTitle("Menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7, 1, 10, 10));

        JButton createTaskButton = new JButton("Create Task");
        createTaskButton.addActionListener((ActionEvent e) -> handleCreateTask());

        JButton showReportButton = new JButton("Display Report");
        showReportButton.addActionListener((ActionEvent e) -> handleShowReport());

        JButton longestTaskButton = new JButton("Display Longest Task");
        longestTaskButton.addActionListener((ActionEvent e) -> handleLongestTask());

        JButton searchDeveloperButton = new JButton("Search Task by Developer");
        searchDeveloperButton.addActionListener((ActionEvent e) -> handleSearchTaskByDeveloper());

        JButton deleteTaskButton = new JButton("Delete Task by Name");
        deleteTaskButton.addActionListener((ActionEvent e) -> handleDeleteTask());

        JButton logoutButton = new JButton("Signout");
        logoutButton.addActionListener((ActionEvent e) -> handleLogout());

        add(createTaskButton);
        add(showReportButton);
        add(longestTaskButton);
        add(searchDeveloperButton);
        add(deleteTaskButton);
        add(logoutButton);
    }

    private void handleCreateTask() {
        String input = JOptionPane.showInputDialog(this, "How many tasks are you adding?");
        try {
            int taskCount = Integer.parseInt(input);
            if (taskCount <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
                return;
            }

            int totalDuration = 0;
            for (int i = 0; i < taskCount; i++) {
                String taskName = JOptionPane.showInputDialog(this, "Enter Task " + (i + 1) + " Name:");
                String taskDescription = JOptionPane.showInputDialog(this, "Enter Task " + (i + 1) + " Description:");
                String developerDetails = JOptionPane.showInputDialog(this, "Enter Developer for Task " + (i + 1) + ":");
                int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Duration (hours) for Task " + (i + 1) + ":"));
                String[] statuses = {"To Do", "Doing", "Done"};
                String status = (String) JOptionPane.showInputDialog(this, "Select Status for Task " + (i + 1) + ":",
                        "Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

                app.createTask(taskName, taskDescription, developerDetails, duration, status);
                totalDuration += duration;
            }

            List<EasyKanban3POE.Task> tasks = app.getTasks();
            StringBuilder taskReport = new StringBuilder("Tasks Added:\n");
            for (EasyKanban3POE.Task task : tasks) {
                taskReport.append(task.toString()).append("\n");
            }
            taskReport.append("Total Duration: ").append(totalDuration).append(" hours");
            JOptionPane.showMessageDialog(this, taskReport.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for number of tasks or duration.");
        }
    }

    private void handleShowReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (EasyKanban3POE.Task task : app.getTasks()) {
            report.append(task.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, report.toString());
    }

    private void handleLongestTask() {
        EasyKanban3POE.Task longestTask = app.getTaskWithLongestDuration();
        if (longestTask != null) {
            JOptionPane.showMessageDialog(this, "Longest Task: " + longestTask.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No tasks available.");
        }
    }

    private void handleSearchTaskByDeveloper() {
        String developer = JOptionPane.showInputDialog(this, "Enter Developer Name to Search Tasks:");
        StringBuilder result = new StringBuilder("Tasks assigned to " + developer + ":\n");
        for (EasyKanban3POE.Task task : app.getTasks()) {
            if (task.getDeveloper().equalsIgnoreCase(developer)) {
                result.append(task.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    private void handleDeleteTask() {
        String taskName = JOptionPane.showInputDialog(this, "Enter Task Name to Delete:");
        boolean success = app.deleteTask(taskName);
        if (success) {
            JOptionPane.showMessageDialog(this, "Task Deleted Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Task not found.");
        }
    }

    private void handleLogout() {
        new LoggingIn(app).setVisible(true); 
        this.dispose();
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
