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

public class OrganizerReviewPanel extends JPanel {

    private JTextArea reviewsArea;
    private Image backgroundImage;

    public OrganizerReviewPanel() {
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // عدلي اسم الصورة حسب صورتك

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Customer Reviews", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.DARK_GRAY); // أبيض عشان يوضح فوق الخلفية
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        reviewsArea = new JTextArea();
        reviewsArea.setEditable(false);
        reviewsArea.setOpaque(false); // شفافية
        reviewsArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        reviewsArea.setForeground(Color.DARK_GRAY);
        reviewsArea.setText(getFormattedReview());
        reviewsArea.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JScrollPane scrollPane = new JScrollPane(reviewsArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
    }

    private String getFormattedReview() {
        if (ReviewData.latestReview == null || ReviewData.latestReview.isEmpty()) {
            return "No reviews received yet.";
        } else {
            return "- " + ReviewData.latestReview;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}