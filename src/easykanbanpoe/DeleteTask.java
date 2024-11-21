package easykanbanpoe;

import java.awt.GridLayout;
import javax.swing.*;

public class DeleteTask extends JFrame {
    private JTextField taskNameField;
    private final EasyKanbanPOE app;

    public DeleteTask(EasyKanbanPOE app) {
        this.app = app;
        setTitle("Delete Task");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(2, 1));

        add(new JLabel("Enter The Task Name You Wish To Remove:"));
        taskNameField = new JTextField();
        add(taskNameField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteTask());
        add(deleteButton);
    }
    

    private void deleteTask() {
        String taskName = taskNameField.getText();
        app.deleteTaskByName(taskName);
        JOptionPane.showMessageDialog(this, "Task has been deleted.");
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
