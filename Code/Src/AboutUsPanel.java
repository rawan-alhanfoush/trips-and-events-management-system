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

public class AboutUsPanel extends JPanel {
    private Image backgroundImage;  // هنا نخزن الصورة

    public AboutUsPanel() {
        setLayout(new BorderLayout());
        backgroundImage = new ImageIcon("imagee/ula.jpg").getImage(); // تحميل الخلفية

        setBackground(new Color(240, 220, 255));
JLabel title = new JLabel("About Us", JLabel.CENTER);
title.setFont(new Font("Segoe UI", Font.BOLD, 35)); // حجم أكبر
title.setForeground(Color.WHITE); // أبيض واضح
title.setBorder(BorderFactory.createEmptyBorder(40, 0, 30, 0)); // تباعد مريح
title.setOpaque(false);
add(title, BorderLayout.NORTH);

        // النص الرئيسي
        JLabel welcome = new JLabel("<html><div style='text-align: center;'>"
                + "Welcome to our Trip and Management App!<br><br>"
                + "Our goal is to facilitate the tourism sector in the Kingdom of Saudi Arabia.<br>"
                + "The lavender-inspired purple color represents the Kingdom's spirit."
                + "</div></html>");
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        welcome.setForeground(Color.WHITE);
        welcome.setHorizontalAlignment(JLabel.CENTER);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false); // شفافية عشان الخلفية تبين
        centerPanel.add(welcome);
        add(centerPanel, BorderLayout.CENTER);

        // أسفل: معلومات الاتصال
        JPanel contactPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        contactPanel.setOpaque(false);

        ImageIcon emailIcon = new ImageIcon("imagee/Emmail.png");
        Image emailImg = emailIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        emailIcon = new ImageIcon(emailImg);
        JLabel emailLabel = new JLabel("SaudyTrip2030@gmail.com", emailIcon, JLabel.LEFT);
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(Color.WHITE);

        ImageIcon phoneIcon = new ImageIcon("imagee/phone(2).png");
        Image phoneImg = phoneIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        phoneIcon = new ImageIcon(phoneImg);
        JLabel phoneLabel = new JLabel("01322839476", phoneIcon, JLabel.LEFT);
        phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneLabel.setForeground(Color.WHITE);

        contactPanel.add(emailLabel);
        contactPanel.add(phoneLabel);

        add(contactPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}