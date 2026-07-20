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

public class HomePanel extends JPanel {

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 220, 255)); // خلفية بنفسجي فاتح

        // topPanel يحتوي اللوقو والعنوان
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        // لوقو التطبيق
        ImageIcon icon = new ImageIcon("imagee/logo.jpg"); // عدلي اسم الصورة إذا تغير
        Image img = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // العنوان
        JLabel title = new JLabel("Trips and Events Management System");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(102, 0, 153));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(logoLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(title);

        add(topPanel, BorderLayout.NORTH);

       
       

        // اقتباس جميل تحت النص
        ImageIcon saudiIcon = new ImageIcon("imagee/saudy.png");
        Image saImg = saudiIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        saudiIcon = new ImageIcon(saImg);
    
        JLabel quote = new JLabel("\"Explore the beauty of Saudi Arabia — one trip at a time.\"", saudiIcon,  JLabel.CENTER);
        quote.setFont(new Font("Georgia", Font.ITALIC, 16));
        quote.setForeground(new Color(85, 0, 102));
        quote.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(quote, BorderLayout.SOUTH);

        // فوتر (ممكن نحطه تحت الاقتباس أو كجزء منه)
        JLabel footer = new JLabel("Made with love for Vision 2030", JLabel.CENTER);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        footer.setForeground(new Color(102, 0, 153));
        footer.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Panel لتجميع الاقتباس والفوتر
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);
        bottomPanel.add(quote);
        bottomPanel.add(footer);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}