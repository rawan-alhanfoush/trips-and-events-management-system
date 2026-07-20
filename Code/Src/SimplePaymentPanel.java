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

public class SimplePaymentPanel extends JPanel {
    private Image backgroundImage;
    private JTextField cardNumberField, cvvField;
    private JComboBox<String> monthBox, yearBox;
    private JLabel selectedMethodLabel;
    private JPanel formPanel;
    private JLabel amountLabel;

    public SimplePaymentPanel() {
        backgroundImage = new ImageIcon("imagee/ros.jpg").getImage(); // صورة الخلفية
        setLayout(new GridBagLayout());
        setOpaque(false); // شفافية الخلفية

        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Arial", Font.BOLD, 16);

        // بطاقة شفافة
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(255, 255, 255, 210)); // أبيض شفاف
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // العنوان
        ImageIcon pIcon = new ImageIcon("imagee/payment.png");
        pIcon = new ImageIcon(pIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel header = new JLabel("Payment", pIcon, JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(header, gbc);

        // أيقونات الدفع
        JPanel iconPanel = new JPanel(new FlowLayout());
        iconPanel.setOpaque(false);
        ImageIcon cardIcon = new ImageIcon(new ImageIcon("imagee/pay.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon paypalIcon = new ImageIcon(new ImageIcon("imagee/paypal.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon cashIcon = new ImageIcon(new ImageIcon("imagee/cach.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        JButton cardBtn = new JButton(cardIcon);
        JButton paypalBtn = new JButton(paypalIcon);
        JButton cashBtn = new JButton(cashIcon);
        for (JButton btn : new JButton[]{cardBtn, paypalBtn, cashBtn}) {
            btn.setBackground(Color.WHITE);
            btn.setFocusPainted(false);
            iconPanel.add(btn);
        }

        gbc.gridy = 1;
        contentPanel.add(iconPanel, gbc);

        // طريقة الدفع
        selectedMethodLabel = new JLabel("Selected: None");
        selectedMethodLabel.setForeground(fgColor);
        selectedMethodLabel.setFont(font);
        gbc.gridy = 2;
        contentPanel.add(selectedMethodLabel, gbc);

        // المبلغ
        amountLabel = new JLabel("Amount to Pay: " + SharedData.totalAmount + " SR");
        amountLabel.setFont(font);
        amountLabel.setForeground(fgColor);
        gbc.gridy = 3;
        contentPanel.add(amountLabel, gbc);

        // نموذج البطاقة
        formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setOpaque(false);
        cardNumberField = new JTextField();
        cvvField = new JTextField();
        monthBox = new JComboBox<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
        yearBox = new JComboBox<>(new String[]{"2024", "2025", "2026", "2027"});

        formPanel.add(new JLabel("Card Number:"));
        formPanel.add(cardNumberField);
        formPanel.add(new JLabel("Expiration:"));
        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.setOpaque(false);
        datePanel.add(monthBox);
        datePanel.add(yearBox);
        formPanel.add(datePanel);

        ImageIcon cvvIcon = new ImageIcon(new ImageIcon("imagee/cvv.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        formPanel.add(new JLabel("CVV:", cvvIcon, JLabel.LEFT));
        formPanel.add(cvvField);

        gbc.gridy = 4;
        contentPanel.add(formPanel, gbc);

        // الأزرار
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.
setOpaque(false);
        JButton confirmButton = new JButton("Confirm");
        JButton backButton = new JButton("Back");

        confirmButton.setBackground(fgColor);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(font);

        backButton.setBackground(new Color(180, 180, 180));
        backButton.setFont(font);

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        gbc.gridy = 5;
        contentPanel.add(buttonPanel, gbc);

        add(contentPanel);

        // أحداث الضغط
        cardBtn.addActionListener(e -> handleMethodSelection("Card"));
        paypalBtn.addActionListener(e -> handleMethodSelection("PayPal"));
        cashBtn.addActionListener(e -> handleMethodSelection("Cash"));

        confirmButton.addActionListener(e -> {
            if (formPanel.isVisible()) {
                String card = cardNumberField.getText();
                String cvv = cvvField.getText();
                if (card.isEmpty() || cvv.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Payment Confirmed!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void handleMethodSelection(String method) {
        selectedMethodLabel.setText("Selected: " + method);
        formPanel.setVisible(!method.equalsIgnoreCase("Cash"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        amountLabel.setText("Amount to Pay: " + SharedData.totalAmount + " SR");
    }
}