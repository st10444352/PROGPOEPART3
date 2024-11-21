package easykanbanpoe;

import java.awt.GridLayout;
import javax.swing.*;

public class MakeATask extends JFrame {
    private JTextField taskNameField, taskDescriptionField;
    private JTextField developerField, durationField;
    private JComboBox<String> statusComboBox;

    private final EasyKanbanPOE app;

    public MakeATask(EasyKanbanPOE app) {
        this.app = app;
        setTitle("Create Task");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Task Name:"));
        taskNameField = new JTextField();
        add(taskNameField);

        add(new JLabel("The Description:"));
        taskDescriptionField = new JTextField();
        add(taskDescriptionField);

        add(new JLabel("The Developer:"));
        developerField = new JTextField();
        add(developerField);

        add(new JLabel("Duration Length:"));
        durationField = new JTextField();
        add(durationField);

        add(new JLabel("The Status:"));
        String[] statuses = {"To Do", "Doing", "Done"};
        statusComboBox = new JComboBox<>(statuses);
        add(statusComboBox);

        JButton createButton = new JButton("Create Task");
        createButton.addActionListener(e -> createTask());
        add(createButton);
    }
    private void createTask() {
        String taskName = taskNameField.getText();
        String description = taskDescriptionField.getText();
        String developer = developerField.getText();
        int duration = Integer.parseInt(durationField.getText());
        String status = (String) statusComboBox.getSelectedItem();
        
        app.createTask(taskName, description, developer, duration, status);
        JOptionPane.showMessageDialog(this, "Task created successfully.");
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
