/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package a.interfacess;

/**
 *
 * @author she5o
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TripEventPanel extends JPanel {
    private Image backgroundImage;
    private JLabel yearLabel, mLabel, dLabel;
    private JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private JComboBox<String> year, mounth, day, box;
    private JComboBox<String> hourBox, minuteBox, amPmBox;
    private JButton bookButton;

    public TripEventPanel() {
        backgroundImage = new ImageIcon("imagee/ses.jpg").getImage(); // صورة الخلفية
        setLayout(new GridBagLayout());
        setOpaque(false); // شفافية الخلفية

        Color fgColor = new Color(102, 0, 153);
        Font uiFont = new Font("Arial", Font.BOLD, 16);

        // panel شفاف يجمع المحتوى
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(255, 255, 255, 200)); // بطاقة شفافة
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // City label
        ImageIcon cityIcon = new ImageIcon("imagee/city.png");
        cityIcon = new ImageIcon(cityIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel cityLabel = new JLabel("  City:", cityIcon, JLabel.LEFT);
        cityLabel.setFont(uiFont);
        cityLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(cityLabel, gbc);

        // City options
        radioButton1 = new JRadioButton("Riyadh");
        radioButton2 = new JRadioButton("Jeddah");
        radioButton3 = new JRadioButton("AlKhobar");
        radioButton4 = new JRadioButton("AlUla");
        ButtonGroup group = new ButtonGroup();

        JPanel cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cityPanel.setOpaque(false);
        for (JRadioButton rb : new JRadioButton[]{radioButton1, radioButton2, radioButton3, radioButton4}) {
            rb.setFont(uiFont);
            rb.setForeground(fgColor);
            rb.setOpaque(false);
            group.add(rb);
            cityPanel.add(rb);
        }
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPanel.add(cityPanel, gbc);

        // Date
        ImageIcon calIcon = new ImageIcon("imagee/تنزيل.png");
        calIcon = new ImageIcon(calIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel dateLabel = new JLabel("  Date:", calIcon, JLabel.LEFT);
        dateLabel.setFont(uiFont);
        dateLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(dateLabel, gbc);

        year = new JComboBox<>(new String[]{"2025", "2026", "2027"});
        mounth = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
        day = new JComboBox<>();
        for (int i = 1; i <= 31; i++) day.addItem(String.valueOf(i));

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.setOpaque(false);
        datePanel.add(year);
        datePanel.add(mounth);
        datePanel.add(day);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(datePanel, gbc);

        // Time
        ImageIcon timeIcon = new ImageIcon("imagee/time.png");
        timeIcon = new ImageIcon(timeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel timeLabel = new JLabel("  Time:", timeIcon, JLabel.LEFT);
        timeLabel.setFont(uiFont);
        timeLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(timeLabel, gbc);

        hourBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) hourBox.addItem(String.format("%02d", i));
        minuteBox = new JComboBox<>(new String[]{"00", "15", "30", "45"});
        amPmBox = new JComboBox<>(new String[]{"AM", "PM"});

        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timePanel.setOpaque(false);
        timePanel.add(hourBox);
        timePanel.add(new JLabel(":"));
        timePanel.add(minuteBox);
        timePanel.add(amPmBox);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(timePanel, gbc);

        // Selected date info
        yearLabel = new JLabel("Selected Year: None");
        mLabel = new JLabel("Selected Month: None");
        dLabel = new JLabel("Selected Day: None");
        for (JLabel label : new JLabel[]{yearLabel, mLabel, dLabel}) {
            label.setForeground(fgColor);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
        }

        JPanel selectedInfoPanel = new JPanel(new GridLayout(1, 3));
        selectedInfoPanel.setOpaque(false);
        selectedInfoPanel.add(yearLabel);
        selectedInfoPanel.add(mLabel);
        selectedInfoPanel.add(dLabel);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPanel.add(selectedInfoPanel, gbc);
        gbc.gridwidth = 1;

        // Activities
        ImageIcon actIcon = new ImageIcon("imagee/actt.png");
        actIcon = new ImageIcon(actIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel activityLabel = new JLabel("  Activities:", actIcon, JLabel.LEFT);
        activityLabel.setFont(uiFont);
        activityLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(activityLabel, gbc);

        box = new JComboBox<>();
        box.setFont(uiFont);
        box.setEnabled(false);
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPanel.add(box, gbc);

        // Book Button
        bookButton = new JButton("Book Now!");
        bookButton.setFont(uiFont);
        bookButton.setBackground(fgColor);
        bookButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPanel.add(bookButton, gbc);

        add(contentPanel);

        // Events
        year.addItemListener(e -> yearLabel.setText("Selected Year: " + year.getSelectedItem()));
        mounth.addItemListener(e -> mLabel.setText("Selected Month: " + mounth.getSelectedItem()));
        day.addItemListener(e -> dLabel.setText("Selected Day: " + day.getSelectedItem()));

        ActionListener radioListener = e -> {
            if (radioButton1.isSelected()) {
                box.setModel(new DefaultComboBoxModel<>(new String[]{"National Museum 10SR", "Riyadh Season 200SR"}));
            } else if (radioButton2.isSelected()) {
                box.setModel(new DefaultComboBoxModel<>(new String[]{"Diving Trips 365SR", "Historical City Tour 150SR"}));
            } else if (radioButton3.isSelected()) {
                box.setModel(new DefaultComboBoxModel<>(new String[]{"Ithra 35SR", "Escape Room 260SR"}));
            } else if (radioButton4.isSelected()) {
                box.setModel(new DefaultComboBoxModel<>(new String[]{"Rock Climbing 250SR", "Dadan & Mount Ikma Tour 60SR", "Maraya Hall Tour 90SR"}));
            }
            box.setEnabled(true);
        };

        for (JRadioButton rb : new JRadioButton[]{radioButton1, radioButton2, radioButton3, radioButton4}) {
            rb.addActionListener(radioListener);
        }

        bookButton.addActionListener(e -> {
            String city = null;
            if (radioButton1.isSelected()) city = "Riyadh";
            else if (radioButton2.isSelected()) city = "Jeddah";
            else if (radioButton3.isSelected()) city = "AlKhobar";
            else if (radioButton4.isSelected()) city = "AlUla";

            String activity = (String) box.getSelectedItem();
            String selectedDate = year.getSelectedItem() + "-" + mounth.getSelectedItem() + "-" + day.getSelectedItem();
            String selectedTime = hourBox.getSelectedItem() + ":" + minuteBox.getSelectedItem() + " " + amPmBox.getSelectedItem();

            if (activity != null) {
                if (activity.contains("10SR")) SharedData.totalAmount += 10;
                else if (activity.contains("200SR")) SharedData.totalAmount += 200;else if (activity.contains("250SR")) SharedData.totalAmount += 250;
                else if (activity.contains("365SR")) SharedData.totalAmount += 365;
                else if (activity.contains("150SR")) SharedData.totalAmount += 150;
                else if (activity.contains("35SR")) SharedData.totalAmount += 35;
                else if (activity.contains("260SR")) SharedData.totalAmount += 260;
                else if (activity.contains("60SR")) SharedData.totalAmount += 60;
                else if (activity.contains("90SR")) SharedData.totalAmount += 90;
            }

            if (city == null || activity == null) {
                JOptionPane.showMessageDialog(this, "Please select city and activity first", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Your trip has been booked!" +
                                "\nCity: " + city +
                                "\nActivity: " + activity +
                                "\nDate: " + selectedDate +
                                "\nTime: " + selectedTime +
                                "\n\nAmount added to payment: " + SharedData.totalAmount + " SR", "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
