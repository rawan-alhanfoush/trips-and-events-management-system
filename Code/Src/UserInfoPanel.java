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

public class UserInfoPanel extends JPanel {
    private Image backgroundImage;

    public UserInfoPanel() {
        setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // صورة الخلفية

        // العنوان
        JLabel title = new JLabel("User Information", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 25));
        title.setForeground(Color.WHITE); // أبيض أوضح فوق الخلفية
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        title.setOpaque(false);
        add(title, BorderLayout.NORTH);

        // لوحة المعلومات
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        infoPanel.add(createInfoItem("Name: ", "Customer User", "imagee/user.jpg"));
        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(createInfoItem("Email: ", "user@example.com", "imagee/Emmail.png"));
        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(createInfoItem("Phone: ", "0501234567", "imagee/phone(2).png"));

        add(infoPanel, BorderLayout.CENTER);
    }

    private JPanel createInfoItem(String labelText, String valueText, String iconPath) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(255, 255, 255, 180)); // خلفية شفافة فاتحة

        ImageIcon icon = new ImageIcon(iconPath);
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel iconLabel = new JLabel(icon);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label.setForeground(new Color(102, 0, 153)); // بنفسجي واضح على الفاتح

        JLabel value = new JLabel(valueText);
        value.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        value.setForeground(Color.DARK_GRAY);

        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(label);
        panel.add(value);

        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}