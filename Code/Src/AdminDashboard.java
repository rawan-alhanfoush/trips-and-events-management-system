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
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends JFrame {
    private JPanel contentPanel;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color bgColor = new Color(240, 220, 255);
        Color sideColor = new Color(102, 0, 153);
        Color textColor = Color.WHITE;

        // الشريط العلوي - Home و Admin Info
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        topPanel.setBackground(sideColor);

        ImageIcon homeIcon = new ImageIcon("imagee/H.png");
        homeIcon = new ImageIcon(homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JButton homeBtn = new JButton("Home", homeIcon);

        ImageIcon infoIcon = new ImageIcon("imagee/info.png");
        infoIcon = new ImageIcon(infoIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JButton adminInfoBtn = new JButton("Admin Info", infoIcon);

        for (JButton btn : new JButton[]{homeBtn, adminInfoBtn}) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(sideColor);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            topPanel.add(btn);
        }

        add(topPanel, BorderLayout.NORTH);

        // الشريط الجانبي
        JPanel sidebar = new JPanel();
        sidebar.setBackground(sideColor);
        sidebar.setPreferredSize(new Dimension(200, getHeight()));
        sidebar.setLayout(new GridLayout(2, 1, 0, 10));

        JButton usersBtn = new JButton("Users");
        JButton notifyBtn = new JButton("Notifications");

        for (JButton btn : new JButton[]{usersBtn, notifyBtn}) {
            btn.setBackground(sideColor);
            btn.setForeground(textColor);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            sidebar.add(btn);
        }

        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(bgColor);

        JPanel homePanel = new JPanel() {
            Image bg = new ImageIcon("imagee/ros.jpg").getImage();
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        homePanel.setLayout(new GridBagLayout());
        JLabel homeLabel = new JLabel("Welcome to Admin interface");
        homeLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        homeLabel.setForeground(Color.DARK_GRAY);
        homePanel.add(homeLabel);

        JPanel adminInfoPanel = createAdminInfoPanel();
        JPanel usersPanel = createUsersPanel();
        JPanel notifyPanel = createNotifyPanel();

        contentPanel.add(homePanel, "home");
        contentPanel.add(adminInfoPanel, "info");
        contentPanel.add(usersPanel, "users");
        contentPanel.add(notifyPanel, "notify");

        homeBtn.addActionListener(e -> showPanel("home"));
        adminInfoBtn.addActionListener(e -> showPanel("info"));
        usersBtn.addActionListener(e -> showPanel("users"));
        notifyBtn.addActionListener(e -> showPanel("notify"));

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        showPanel("home");
        setVisible(true);
    }

    void showPanel(String name) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, name);
    }

    private JPanel createAdminInfoPanel() {
    JPanel panel = new JPanel(new BorderLayout()) {
        private Image bgImage = new ImageIcon("imagee/ros.jpg").getImage();
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
    };

    panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

    JLabel title = new JLabel("Admin Information", JLabel.CENTER);
    title.setFont(new Font("Segoe UI", Font.BOLD, 20));
    title.setForeground(Color.BLACK);
    panel.add(title, BorderLayout.NORTH);

    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setOpaque(false);

    infoPanel.add(createInfoItem("Name: ", "Admin User", new ImageIcon("imagee/username.png")));
    infoPanel.add(Box.createVerticalStrut(10));
    infoPanel.add(createInfoItem("Email: ", "admin@exampel.com", new ImageIcon("imagee/Emmail.png")));
    infoPanel.add(Box.createVerticalStrut(10));
    infoPanel.add(createInfoItem("Phone: ", "0550000000", new ImageIcon("imagee/phone(2).png")));

    panel.add(infoPanel, BorderLayout.CENTER);
    return panel;
}

   private JPanel createInfoItem(String labelText, String valueText, ImageIcon icon) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel.setBackground(new Color(255, 255, 255, 180)); // خلفية شفافة

    // تعديل حجم الأيقونة
    Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // <-- هنا يتحكم بالحجم
    JLabel iconLabel = new JLabel(new ImageIcon(img));

    JLabel label = new JLabel(labelText);
    label.setFont(new Font("Segoe UI", Font.BOLD, 16));
    label.setForeground(new Color(102, 0, 153));

    JLabel value = new JLabel(valueText);
    value.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    value.setForeground(Color.DARK_GRAY);

    panel.add(iconLabel);
    panel.add(Box.createHorizontalStrut(10));
    panel.add(label);
    panel.add(value);

    return panel;
}
   private JPanel createUsersPanel() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(new Color(240, 220, 255));

    JLabel title = new JLabel("Registered Users", JLabel.CENTER);
    title.setFont(new Font("Segoe UI", Font.BOLD, 18));
    title.setForeground(new Color(102, 0, 153));

    String[] columns = {"Username", "Role", "Email"};
    String[][] data = {
        {"sara01", "Customer", "sara@example.com"},
        {"ali_admin", "Admin", "ali@example.com"},
        {"reem_org", "Organizer", "reem@example.com"},
    };

    DefaultTableModel model = new DefaultTableModel(data, columns);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);

    // الأزرار
    JButton addBtn = new JButton("Add User");
    JButton editBtn = new JButton("Edit User");
    JButton deleteBtn = new JButton("Delete User");

    addBtn.setBackground(new Color(102, 0, 153));
    addBtn.setForeground(Color.WHITE);
    editBtn.setBackground(new Color(102, 0, 153));
    editBtn.setForeground(Color.WHITE);
    deleteBtn.setBackground(new Color(102, 0, 153));
    deleteBtn.setForeground(Color.WHITE);

    // أحداث الأزرار
    addBtn.addActionListener(e -> {
        JTextField usernameField = new JTextField();
        JTextField roleField = new JTextField();
        JTextField emailField = new JTextField();
        Object[] fields = {
            "Username:", usernameField,
            "Role:", roleField,
            "Email:", emailField
        };
        int result = JOptionPane.showConfirmDialog(panel, fields, "Add New User", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            model.addRow(new Object[]{
                usernameField.getText(),
                roleField.getText(),
                emailField.getText()
            });
        }
    });

    editBtn.addActionListener(e -> {
        int row = table.getSelectedRow();
        if (row >= 0) {
            String currentUser = (String) model.getValueAt(row, 0);
            String currentRole = (String) model.getValueAt(row, 1);
            String currentEmail = (String) model.getValueAt(row, 2);

            JTextField usernameField = new JTextField(currentUser);
            JTextField roleField = new JTextField(currentRole);
            JTextField emailField = new JTextField(currentEmail);
            Object[] fields = {
                "Username:", usernameField,
                "Role:", roleField,
                "Email:", emailField
            };
            int result = JOptionPane.showConfirmDialog(panel, fields, "Edit User", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                model.setValueAt(usernameField.getText(), row, 0);
                model.setValueAt(roleField.getText(), row, 1);
                model.setValueAt(emailField.getText(), row, 2);
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Please select a user to edit.");
        }
    });

    deleteBtn.addActionListener(e -> {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(panel, "Please select a user to delete.");
        }
    });

    // لوحة الأزرار السفلية
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(240, 220, 255));
    buttonPanel.add(addBtn);
    buttonPanel.add(editBtn);
    buttonPanel.add(deleteBtn);

    panel.add(title, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.SOUTH);

    return panel;
}

    private JPanel createNotifyPanel() {
        JPanel panel = new JPanel(null) {
            Image bg = new ImageIcon("imagee/ros.jpg").getImage();
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };

        Color fgColor = new Color(102, 0, 153);
        Font font = new Font("Segoe UI", Font.BOLD, 16);
         ImageIcon notcon = new ImageIcon("imagee/not.png");
        notcon  = new ImageIcon( notcon  .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JLabel pageTitle = new JLabel("Send Notification to Users", notcon,JLabel.CENTER);
        pageTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        pageTitle.setForeground(fgColor);
        pageTitle.setBounds(0, 10, 800, 30);
        panel.add(pageTitle);
        
        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(30, 60, 100, 25);
        typeLabel.setFont(font);
        typeLabel.setForeground(fgColor);
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Reminder", "Alert", "Info"});
        typeCombo.setBounds(130, 60, 200, 25);
        ImageIcon ticon = new ImageIcon("imagee/t.png");
      ticon   = new ImageIcon( ticon   .getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JLabel titleLabel = new JLabel("Title:", ticon,JLabel.LEFT);
        titleLabel.setBounds(30, 100, 100, 25);
        titleLabel.setFont(font);
        titleLabel.setForeground(fgColor);
        JTextField titleField = new JTextField();
        titleField.setBounds(130, 100, 200, 25);
         ImageIcon mscon = new ImageIcon("imagee/msg.png");
      mscon  = new ImageIcon( mscon .getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
     
        JLabel messageLabel = new JLabel("Message:", mscon,JLabel.LEFT);
        messageLabel.setBounds(30, 140, 100, 25);
        messageLabel.setFont(font);
        messageLabel.setForeground(fgColor);
        JTextField messageField = new JTextField();
        messageField.setBounds(130, 140, 200, 25);
         ImageIcon calIcon = new ImageIcon("imagee/تنزيل.png");
        calIcon = new ImageIcon(calIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
 
        JLabel dateLabel = new JLabel("Date:", calIcon, JLabel.LEFT);
        dateLabel.setBounds(30, 180, 100, 25);
        dateLabel.setFont(font);
        dateLabel.setForeground(fgColor);
        JTextField dateField = new JTextField();
        dateField.setBounds(130, 180, 200, 25);

        JButton sendButton = new JButton("Send Notification");
        sendButton.setBounds(130, 230, 200, 35);
        sendButton.setBackground(fgColor);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sendButton.setFocusPainted(false);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(100, 280, 400, 25);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        statusLabel.setForeground(fgColor);

        sendButton.addActionListener(e -> {
            NotificationData.type = (String) typeCombo.getSelectedItem();
            NotificationData.title = titleField.getText();
            NotificationData.message = messageField.getText();
            NotificationData.date = dateField.getText();

            if (NotificationData.title.isEmpty() || NotificationData.date.isEmpty()) {
                statusLabel.setText("Please fill all fields before sending.");
            } else {
                statusLabel.setText("Notification sent to user successfully!");
                titleField.setText("");
                messageField.setText("");
                dateField.setText("");
            }
        });

        panel.add(typeLabel); panel.add(typeCombo);
        panel.add(titleLabel); panel.add(titleField);
        panel.add(messageLabel); panel.add(messageField);
        panel.add(dateLabel); panel.add(dateField);
        panel.add(sendButton); panel.add(statusLabel);

        return panel;
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}