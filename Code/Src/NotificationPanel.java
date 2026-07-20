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
import java.time.LocalDate;

public class NotificationPanel extends JPanel {
    private Image backgroundImage;

    public NotificationPanel() {
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // صورة الخلفية
        setLayout(new GridBagLayout());
        setOpaque(false); // شفافية الخلفية

        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 16);

        // بطاقة شفافة
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255, 210)); // أبيض شفاف
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setPreferredSize(new Dimension(500, 350));

        // العنوان
        ImageIcon nIcon = new ImageIcon("imagee/not.png");
        Image nImg = nIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        nIcon = new ImageIcon(nImg);

        JLabel header = new JLabel("Customer Notification", nIcon, JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setForeground(fgColor);
        contentPanel.add(header, BorderLayout.NORTH);

        // محتوى الإشعار
        JTextArea notificationArea = new JTextArea(
                "Type: Reminder\n" +
                "Title: Don't Miss!\n" +
                "Message: Your trip is scheduled tomorrow at 10 AM.\n"
        );
        notificationArea.setWrapStyleWord(true);
        notificationArea.setLineWrap(true);
        notificationArea.setEditable(false);
        notificationArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        notificationArea.setBackground(new Color(255, 255, 255, 0)); // شفاف
        notificationArea.setForeground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(notificationArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // أسفل: التاريخ والزر
        JPanel southPanel = new JPanel();
        southPanel.setOpaque(false);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        String today = LocalDate.now().toString();
        JLabel dateLabel = new JLabel("Date: " + today);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateLabel.setForeground(fgColor);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton okButton = new JButton("OK");
        okButton.setBackground(fgColor);
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Notification viewed."));

        southPanel.add(Box.createVerticalStrut(10));
        southPanel.add(dateLabel);
        southPanel.add(Box.createVerticalStrut(10));
        southPanel.add(okButton);
        southPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(southPanel, BorderLayout.SOUTH);

        add(contentPanel); // نضيف البطاقة داخل اللوحة
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}