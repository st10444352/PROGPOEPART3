package easykanbanpoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Registering extends JFrame {
    private final EasyKanban3POE app;  // Reference to the main app
    private JTextField firstNameField, lastNameField, usernameField;
    private JPasswordField passwordField;

    public Registering(EasyKanban3POE app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        setTitle("Register");
        setSize(200, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the UI components
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel firstNameLabel = new JLabel("Name:");
        firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Surname:");
        lastNameField = new JTextField();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener((ActionEvent e) -> handleRegister());

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
    }

    private void handleRegister() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        boolean success = app.registerUser(firstName, lastName, username, password);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Welcome to EasyKanban!");
            new LoggingIn(app).setVisible(true); 
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists.");
        }
    }

    public static void main(String[] args) {
        EasyKanban3POE app = new EasyKanban3POE();
        new Registering(app).setVisible(true); 
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