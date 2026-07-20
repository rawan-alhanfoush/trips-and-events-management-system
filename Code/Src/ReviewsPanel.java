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
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ReviewsPanel extends JPanel {
    private Image backgroundImage;

    private JComboBox<String> rateBox;
    private JTextArea reviewTextArea;
    private JLabel selectedRateLabel, resultLabel, dateLabel;
    private JButton saveButton;

    public ReviewsPanel() {
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // صورة الخلفية
        setLayout(new GridBagLayout());
        setOpaque(false); // شفافية اللوحة عشان الخلفية تبان

        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 16);

        // البطاقة الشفافة
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(new Color(255, 255, 255, 210)); // خلفية شفافة
        cardPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        cardPanel.setPreferredSize(new Dimension(500, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // العنوان: Rate
        ImageIcon rateIcon = new ImageIcon("imagee/Rate.png");
        rateIcon = new ImageIcon(rateIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel rateLabel = new JLabel(" Please rate your experience:", rateIcon, JLabel.LEFT);
        rateLabel.setFont(font);
        rateLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        cardPanel.add(rateLabel, gbc);

        // النجوم
        String[] stars = {"★", "★★", "★★★", "★★★★", "★★★★★"};
        rateBox = new JComboBox<>(stars);
        rateBox.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 0;
        cardPanel.add(rateBox, gbc);

        // عرض التقييم المختار
        selectedRateLabel = new JLabel("Selected Rate: None");
        selectedRateLabel.setForeground(fgColor);
        selectedRateLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        cardPanel.add(selectedRateLabel, gbc);
        gbc.gridwidth = 1;

        rateBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectedRateLabel.setText("Selected Rate: " + rateBox.getSelectedItem());
            }
        });

        // العنوان: رأيك يهمنا
        ImageIcon revIcon = new ImageIcon("imagee/Rev.png");
        revIcon = new ImageIcon(revIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel opinionLabel = new JLabel("Your opinion matters to us:", revIcon, JLabel.LEFT);
        opinionLabel.setFont(font);
        opinionLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        cardPanel.add(opinionLabel, gbc);

        // صندوق النص
        reviewTextArea = new JTextArea(5, 20);
        reviewTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(reviewTextArea);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        cardPanel.add(scroll, gbc);
        gbc.gridwidth = 1;

        // زر الحفظ
        saveButton = new JButton("Save");
        saveButton.setFont(font);
        saveButton.setBackground(fgColor);
        saveButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 4;
        cardPanel.add(saveButton, gbc);

        // نتيجة الحفظ
        resultLabel = new JLabel("");
        resultLabel.setForeground(fgColor);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        cardPanel.add(resultLabel, gbc);

        // التاريخ
        String today = LocalDate.now().toString();
        dateLabel = new JLabel("Date: " + today);
        dateLabel.setForeground(fgColor);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        cardPanel.add(dateLabel, gbc);

        add(cardPanel); // أضف البطاقة للواجهة

        // حدث الضغط على "Save"
        saveButton.addActionListener(e -> {
            String reviewText = reviewTextArea.getText();
            try (FileWriter writer = new FileWriter("userdata.txt", true)) {
                writer.write("Date: " + today + "\n");
                writer.write("Rate: " + rateBox.getSelectedItem() + "\n");
                writer.write("Review: " + reviewText + "\n\n");
                resultLabel.setText("Saved successfully!");
                reviewTextArea.setText("");
            } catch (IOException ex) {
                resultLabel.setText("Error saving.");
                ex.printStackTrace();
            }
        });
    }

    // رسم الخلفية
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}