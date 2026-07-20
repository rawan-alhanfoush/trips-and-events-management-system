/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.interfacess;

/**
 *
 * @author she5o
 */
import javax.swing.*;
import java.awt.*;

public class AdminHomePanel extends JPanel {

    public AdminHomePanel(AdminDashboard dashboard) {
        setLayout(null);
        setBackground(new Color(240, 220, 255));

        Color mainColor = new Color(102, 0, 153);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel welcomeLabel = new JLabel("Welcome, Admin!", JLabel.CENTER);
        welcomeLabel.setFont(titleFont);
        welcomeLabel.setForeground(mainColor);
        welcomeLabel.setBounds(200, 30, 400, 30);
        add(welcomeLabel);

        JButton usersButton = new JButton("Manage Users");
        usersButton.setBounds(300, 100, 200, 40);
        usersButton.setBackground(mainColor);
        usersButton.setForeground(Color.WHITE);
        usersButton.setFont(buttonFont);
        usersButton.setFocusPainted(false);
        usersButton.addActionListener(e -> dashboard.showPanel("users"));
        add(usersButton);

        JButton notifyButton = new JButton("Send Notifications");
        notifyButton.setBounds(300, 160, 200, 40);
        notifyButton.setBackground(mainColor);
        notifyButton.setForeground(Color.WHITE);
        notifyButton.setFont(buttonFont);
        notifyButton.setFocusPainted(false);
        notifyButton.addActionListener(e -> dashboard.showPanel("notify"));
        add(notifyButton);

        JLabel quoteLabel = new JLabel("\"One dashboard to manage it all.\"", JLabel.CENTER);
        quoteLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        quoteLabel.setForeground(Color.DARK_GRAY);
        quoteLabel.setBounds(200, 230, 400, 30);
        add(quoteLabel);
    }
}