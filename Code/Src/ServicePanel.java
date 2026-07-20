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

public class ServicePanel extends JPanel {
    private Image backgroundImage;
    private JLabel labe1;
    private JComboBox<String> serv;
    private JButton b1, b2;

    public ServicePanel() {
        backgroundImage = new ImageIcon("imagee/jed.jpg").getImage(); // صورة الخلفية
        setLayout(new GridBagLayout());
        setOpaque(false); // شفافية الخلفية

        Color fgColor = new Color(102, 0, 153);
        Font uiFont = new Font("Arial", Font.BOLD, 16);

        // بطاقة شفافة
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(255, 255, 255, 200)); // أبيض شفاف
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labe1 = new JLabel("Do you want additional services?");
        labe1.setFont(uiFont);
        labe1.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(labe1, gbc);

        b1 = new JButton("Yes");
        b1.setFont(uiFont);
        b1.setBackground(fgColor);
        b1.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPanel.add(b1, gbc);

        b2 = new JButton("No");
        b2.setFont(uiFont);
        b2.setBackground(fgColor);
        b2.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(b2, gbc);

        add(contentPanel);

        b1.addActionListener(e -> {
            JFrame comboFrame = new JFrame("Choose Option");
            comboFrame.setSize(350, 200);
            comboFrame.setLayout(new GridBagLayout());
            comboFrame.getContentPane().setBackground(new Color(255, 255, 255, 240));

            GridBagConstraints cb = new GridBagConstraints();
            cb.insets = new Insets(10, 10, 10, 10);

            JLabel label = new JLabel("Choose your service:");
            label.setFont(uiFont);
            label.setForeground(fgColor);

            String[] options = {"Photography Package 50SR", "VIP Transport 100SR"};
            serv = new JComboBox<>(options);
            serv.setFont(uiFont);

            JButton confirm = new JButton("Confirm");
            confirm.setFont(uiFont);
            confirm.setBackground(fgColor);
            confirm.setForeground(Color.WHITE);

            confirm.addActionListener(ev -> {
                String selected = (String) serv.getSelectedItem();

                if (selected.contains("50SR")) {
                    SharedData.totalAmount += 50;
                } else if (selected.contains("100SR")) {
                    SharedData.totalAmount += 100;
                }

                JOptionPane.showMessageDialog(comboFrame,
                        "Service selected: " + selected +
                                "\nAmount added to payment: " + SharedData.totalAmount + " SR");
                comboFrame.dispose();
            });

            cb.gridx = 0;
            cb.gridy = 0;
            comboFrame.add(label, cb);
            cb.gridy = 1;
            comboFrame.add(serv, cb);
            cb.gridy = 2;
            comboFrame.add(confirm, cb);

            comboFrame.setLocationRelativeTo(null);
            comboFrame.setVisible(true);
        });

        b2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ok! Thank you");
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