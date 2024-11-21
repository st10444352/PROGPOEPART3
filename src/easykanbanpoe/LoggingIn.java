package easykanbanpoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoggingIn extends JFrame {
    private final EasyKanban3POE app;

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoggingIn(EasyKanban3POE app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        setTitle("Login");
        setSize(200, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener((ActionEvent e) -> handleLogin());

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (app.loginUser(username, password)) {
            String fullName = app.getCurrentUser().getFullName();
            JOptionPane.showMessageDialog(this, "Welcome, " + fullName + ",! Happy to have you on board!");
            new CreationMenu(app).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username and/or password.");
        }
    }

    public static void main(String[] args) {
        EasyKanban3POE app = new EasyKanban3POE();
        new LoggingIn(app).setVisible(true);
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
