package easykanbanpoe;

import java.awt.GridLayout;
import javax.swing.*;
 
public class LookUpTask extends JFrame {
    private JTextField searchField;
    private final EasyKanbanPOE app;

    public LookUpTask(EasyKanbanPOE app) {
        this.app = app;
        setTitle("Search Task");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(2, 1));

        add(new JLabel("Task Name to Search:"));
        searchField = new JTextField();
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchTask());
        add(searchButton);
    }
    
        private void searchTask() {
        String taskName = searchField.getText();
        app.searchTask(taskName);
        JOptionPane.showMessageDialog(this, "Search completed.");
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
