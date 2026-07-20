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

public class TripBookingPanel extends JPanel {
    private Image backgroundImage;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JComboBox<String> from, to;
    private JLabel resultLabel;

    public TripBookingPanel() {
        backgroundImage = new ImageIcon("imagee/air.jpg").getImage(); // صورة الخلفية

        setLayout(new GridBagLayout());
        setOpaque(false); // خلفية اللوحة شفافة لتظهر الصورة

        // Panel شفاف يحتوي كل العناصر (يشبه بطاقة شفافة)
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(255, 255, 255, 200)); // أبيض شفاف
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Color fgColor = new Color(80, 0, 90); // لون بنفسجي غامق وواضح
        Font uiFont = new Font("Arial", Font.BOLD, 16);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Transport Label
        JLabel label1 = new JLabel("Transport:");
        label1.setFont(uiFont);
        label1.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(label1, gbc);

        // Transport Buttons
        ImageIcon planeIcon = new ImageIcon("imagee/plan.png");
        planeIcon = new ImageIcon(planeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon trainIcon = new ImageIcon("imagee/train.png");
        trainIcon = new ImageIcon(trainIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        radioButton1 = new JRadioButton(" Plane (Saudi Airlines)", planeIcon);
        radioButton2 = new JRadioButton(" Train (SAR)", trainIcon);
        ButtonGroup group = new ButtonGroup();

        JPanel transportPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        transportPanel.setOpaque(false);
        for (JRadioButton rb : new JRadioButton[]{radioButton1, radioButton2}) {
            rb.setFont(uiFont);
            rb.setForeground(fgColor);
            rb.setOpaque(false);
            group.add(rb);
            transportPanel.add(rb);
        }

        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPanel.add(transportPanel, gbc);

        // From Label
        ImageIcon frIcon = new ImageIcon("imagee/from.png");
        frIcon = new ImageIcon(frIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel labelFrom = new JLabel("From:", frIcon, JLabel.LEFT);
        labelFrom.setFont(uiFont);
        labelFrom.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(labelFrom, gbc);

        from = new JComboBox<>();
        from.setFont(uiFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(from, gbc);

        // To Label
        ImageIcon toIcon = new ImageIcon("imagee/to.png");
        toIcon = new ImageIcon(toIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel labelTo = new JLabel("To:", toIcon, JLabel.LEFT);
        labelTo.setFont(uiFont);
        labelTo.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(labelTo, gbc);

        to = new JComboBox<>();
        to.setFont(uiFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(to, gbc);

        // Date
        ImageIcon calendarIcon = new ImageIcon("imagee/تنزيل.png");
        calendarIcon = new ImageIcon(calendarIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel dateLabel = new JLabel("Date:", calendarIcon, JLabel.LEFT);
        dateLabel.setFont(uiFont);
        dateLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(dateLabel, gbc);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2024", "2025", "2026"};

        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);

        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.setOpaque(false);
        datePanel.add(dayBox);
        datePanel.add(monthBox);
        datePanel.add(yearBox);
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPanel.add(datePanel, gbc);

        // Time
        ImageIcon tiIcon = new ImageIcon("imagee/time.png");
        tiIcon = new ImageIcon(tiIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel timeLabel = new JLabel("Time:", tiIcon, JLabel.LEFT);
        timeLabel.setFont(uiFont);
        timeLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(timeLabel, gbc);

        String[] hours = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] minutes = {"00", "15", "30", "45"};
        String[] ampm = {"AM", "PM"};

        JComboBox<String> hourBox = new JComboBox<>(hours);
        JComboBox<String> minuteBox = new JComboBox<>(minutes);
        JComboBox<String> ampmBox = new JComboBox<>(ampm);

        JPanel timePanel = new JPanel(new FlowLayout());
        timePanel.setOpaque(false);
        timePanel.add(hourBox);
        timePanel.add(minuteBox);
        timePanel.add(ampmBox);
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPanel.add(timePanel, gbc);

        // Book Button
        JButton book = new JButton("Book");
        book.setFont(uiFont);
        book.setBackground(fgColor);
        book.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPanel.add(book, gbc);

        // Result
        resultLabel = new JLabel("");
        resultLabel.setFont(uiFont);
        resultLabel.setForeground(fgColor);
        gbc.gridx = 1;
        gbc.gridy = 6;
        contentPanel.add(resultLabel, gbc);

        add(contentPanel);

        // منطق تعبئة المدن
        String[] allCities = {"Riyadh", "Jeddah", "ALKhobar", "ALUla"};
        String[] trainCities = {"Riyadh", "ALKhobar"};

        ActionListener updateCities = e -> {
            from.removeAllItems();
            to.removeAllItems();
            if (radioButton2.isSelected()) {
                for (String city : trainCities) {
                    from.addItem(city);
                    to.addItem(city);
                }
            } else if (radioButton1.isSelected()) {
                for (String city : allCities) {
                    from.addItem(city);
                    to.addItem(city);
                }
            }
        };

        radioButton1.addActionListener(updateCities);
        radioButton2.addActionListener(updateCities);

        book.addActionListener(e -> {
            String fromCity = (String) from.getSelectedItem();
            String toCity = (String) to.getSelectedItem();
            String date = dayBox.getSelectedItem() + "/" + monthBox.getSelectedItem() + "/" + yearBox.getSelectedItem();
            String time = hourBox.getSelectedItem() + ":" + minuteBox.getSelectedItem() + " " + ampmBox.getSelectedItem();

            if (fromCity == null || toCity == null) {
                JOptionPane.showMessageDialog(this, "Please select both cities.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (fromCity.equals(toCity)) {
                JOptionPane.showMessageDialog(this, "From and To cities must be different.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                resultLabel.setText("Trip booked!");
                JOptionPane.showMessageDialog(this,
                        "Trip booked from " + fromCity + " to " + toCity +
                                "\nDate: " + date +
                                "\nTime: " + time,"Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
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