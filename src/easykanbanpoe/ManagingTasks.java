package easykanbanpoe;

import javax.swing.*;
import java.awt.*;

class ManagingTasks extends JFrame {
    private final EasyKanban3POE app;

    public ManagingTasks(EasyKanban3POE app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        setTitle("Task Management");
        setLayout(new FlowLayout());

        JButton createTaskButton = new JButton("Create Task");
        createTaskButton.addActionListener(e -> handleCreateTask());

        JButton deleteTaskButton = new JButton("Delete Task");
        deleteTaskButton.addActionListener(e -> handleDeleteTask());

        JButton searchTaskButton = new JButton("Search Task by Name");
        searchTaskButton.addActionListener(e -> handleSearchTask());

        add(createTaskButton);
        add(deleteTaskButton);
        add(searchTaskButton);

        setSize(100, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void handleCreateTask() {
        String name = JOptionPane.showInputDialog(this, "Enter Task Name:");
        String description = JOptionPane.showInputDialog(this, "Enter Task Description:");
        String developerDetails = JOptionPane.showInputDialog(this, "Assigned Developer:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Duration (hours):"));
        String[] statuses = {"To Do", "Doing", "Done"};
        String status = (String) JOptionPane.showInputDialog(this, "Select Task Status:", "Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

        app.createTask(name, description, developerDetails, duration, status);
        JOptionPane.showMessageDialog(this, "Task Created Successfully!");
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

    private void handleSearchTask() {
        String taskName = JOptionPane.showInputDialog(this, "Enter Task Name to Search:");

        EasyKanban3POE.Task task = app.searchTaskByName(taskName);

        if (task != null) {
            JOptionPane.showMessageDialog(this, task.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Task not found.");
        }
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
