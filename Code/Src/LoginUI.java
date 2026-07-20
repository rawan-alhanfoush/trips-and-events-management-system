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
import java.awt.event.*;

public class LoginUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(420, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        Color bgColor = new Color(240, 220, 255);
        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 14);

        frame.getContentPane().setBackground(bgColor);

        // الصورة الكبيرة في الأعلى
        ImageIcon icon = new ImageIcon("imagee/user.jpg"); // تأكدي من المسار
        Image img = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(img));
        iconLabel.setBounds(150, 10, 120, 120);
        frame.add(iconLabel);

//        JLabel titleLabel = new JLabel("Welcome!");
//        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
//        titleLabel.setForeground(fgColor);
//        titleLabel.setBounds(145, 100, 200, 30);
//        frame.add(titleLabel);
           ImageIcon useIcon = new ImageIcon("imagee/username.png");
        Image useImg = useIcon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        useIcon = new ImageIcon(useImg);
           
        JLabel nameLabel = new JLabel("Username:", useIcon, JLabel.LEFT);
        nameLabel.setBounds(50, 140, 100, 25);
        nameLabel.setForeground(fgColor);
        nameLabel.setFont(font);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 140, 180,25);
        frame.add(nameField);
         ImageIcon passIcon = new ImageIcon("imagee/pass.png");
        Image passImg = passIcon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        passIcon = new ImageIcon(passImg);
        JLabel passwordLabel = new JLabel("Password:", passIcon, JLabel.LEFT);
        passwordLabel.setBounds(50, 170, 100, 25);
        passwordLabel.setForeground(fgColor);
        passwordLabel.setFont(font);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 170, 180, 25);
        frame.add(passwordField);

        JLabel roleLabel = new JLabel("Login as:");
        roleLabel.setBounds(50, 200, 100, 25);
        roleLabel.setForeground(fgColor);
       roleLabel.setFont(font);
        frame.add(roleLabel);

        String[] roles = {"Customer", "Admin", "Organizer"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(150, 200, 180, 25);
        frame.add(roleBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(115, 240, 150, 30);
        loginButton.setBackground(fgColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        loginButton.setFocusPainted(false);
        frame.add(loginButton);

        JLabel registerLabel = new JLabel("Don't have an account?");
        registerLabel.setBounds(90, 280, 200, 25);
        registerLabel.setForeground(fgColor);
        frame.add(registerLabel);

        JButton registerButton = new JButton("Create one");
        registerButton.setBounds(115, 310, 150, 30);
        registerButton.setBackground(fgColor);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createLineBorder(fgColor));
        frame.add(registerButton);

        registerButton.addActionListener(e -> new RegisterUI());

        loginButton.addActionListener(e -> {
            String username = nameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) roleBox.getSelectedItem();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (role.equals("Customer")) {
                new Mainy();
                frame.dispose();
            } else if (role.equals("Organizer")) {
                new OrganizerDashboard();
                frame.dispose();
            } else if (role.equals("Admin")) {
                new AdminDashboard();
                frame.dispose();}
        });

        frame.setVisible(true);
    }
}