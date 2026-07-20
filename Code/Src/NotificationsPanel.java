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

public class NotificationsPanel extends JPanel {

    private Image backgroundImage;

    public NotificationsPanel() {
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // تأكدي من اسم الصورة

        setLayout(new BorderLayout());

        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 16);

        // العنوان
        ImageIcon notIcon = new ImageIcon("imagee/not.png");
        notIcon = new ImageIcon(notIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JLabel title = new JLabel("Notifications", notIcon, JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.DARK_GRAY);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // منطقة النص
        JTextArea notificationArea = new JTextArea();
        notificationArea.setText(
            "Type: Reminder\n" +
            "Title: Upcoming Event\n" +
            "Message: You have a scheduled event this week.\n" +
            "Date: 2025-04-04"
        );
        notificationArea.setEditable(false);
        notificationArea.setOpaque(false);
        notificationArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        notificationArea.setForeground(Color.DARK_GRAY);
        notificationArea.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JScrollPane scrollPane = new JScrollPane(notificationArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}