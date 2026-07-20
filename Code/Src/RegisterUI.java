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

public class RegisterUI extends JFrame {
    public RegisterUI() {
        setTitle("Create Account");
        setSize(450, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        Color bgColor = new Color(240, 220, 255);
        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 14);

        getContentPane().setBackground(bgColor);

        JLabel title = new JLabel("Create a New Account");
        title.setBounds(110, 15, 250, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(fgColor);
        add(title);
             ImageIcon namecon = new ImageIcon("imagee/name.jpg");
        namecon = new ImageIcon(namecon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        
        JLabel fnameLabel = new JLabel("First Name:", namecon, JLabel.LEFT);
        fnameLabel.setBounds(50, 60, 100, 25);
        fnameLabel.setForeground(fgColor);
        add(fnameLabel);
        JTextField fnameField = new JTextField();
        fnameField.setBounds(160, 60, 200, 30);
        add(fnameField);
         ImageIcon nameicon = new ImageIcon("imagee/name.jpg");
        nameicon = new ImageIcon(nameicon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

        JLabel lnameLabel = new JLabel("Last Name:", nameicon, JLabel.LEFT);
        lnameLabel.setBounds(50, 100, 100, 25);
        lnameLabel.setForeground(fgColor);
        add(lnameLabel);
        JTextField lnameField = new JTextField();
        lnameField.setBounds(160, 100, 200, 30);
        add(lnameField);
          ImageIcon phicon = new ImageIcon("imagee/phone(2).png");
        phicon = new ImageIcon(phicon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        
        JLabel phoneLabel = new JLabel("Phone:", phicon, JLabel.LEFT);
        phoneLabel.setBounds(50, 140, 100, 25);
        phoneLabel.setForeground(fgColor);
        add(phoneLabel);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(160, 140, 200, 30);
        add(phoneField);
         ImageIcon usercon = new ImageIcon("imagee/username.png");
        usercon  = new ImageIcon(usercon .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JLabel userLabel = new JLabel("Username:", usercon , JLabel.LEFT);
        userLabel.setBounds(50, 180, 100, 25);
        userLabel.setForeground(fgColor);
        add(userLabel);
        JTextField userField = new JTextField();
        userField.setBounds(160, 180, 200, 30);
        add(userField);
          ImageIcon passcon = new ImageIcon("imagee/pass.png");
         passcon   = new ImageIcon( passcon  .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
       
        JLabel passLabel = new JLabel("Password:",  passcon  , JLabel.LEFT);
        passLabel.setBounds(50, 220, 100, 25);
        passLabel.setForeground(fgColor);
        add(passLabel);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(160, 220, 200, 30);
        add(passField);
        
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(50, 260, 150, 25);
        confirmPassLabel.setForeground(fgColor);
        add(confirmPassLabel);
        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setBounds(160, 260, 200, 30);
        add(confirmPassField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 300, 100, 25);
        roleLabel.setForeground(fgColor);
        add(roleLabel);
        String[] roles = {"Customer", "Admin", "Organizer"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(160, 300, 200, 30);
        add(roleBox);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(160, 360, 120, 40);
        registerBtn.setBackground(fgColor);
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        registerBtn.setFocusPainted(false);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String fn = fnameField.getText().trim();
            String ln = lnameField.getText().trim();
            String phone = phoneField.getText().trim();
            String user = userField.getText().trim();
            String pass = new String(passField.getPassword());
            String confirmPass = new String(confirmPassField.getPassword());
            String role = (String) roleBox.getSelectedItem();

            if (fn.isEmpty()||ln.isEmpty()||phone.isEmpty()||pass.isEmpty() || confirmPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!pass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                JOptionPane.showMessageDialog(this, "Account created successfully for " + role + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterUI();
    }
}