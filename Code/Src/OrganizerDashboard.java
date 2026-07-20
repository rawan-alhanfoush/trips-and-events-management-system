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

public class OrganizerDashboard extends JFrame {

    private JPanel contentPanel;

    public OrganizerDashboard() {
        setTitle("Organizer Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color bgColor = new Color(240, 220, 255);
        Color sideColor = new Color(102, 0, 153);
        Color textColor = Color.WHITE;

        // الشريط العلوي - Home + Info
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        topPanel.setBackground(sideColor);

        ImageIcon homeIcon = new ImageIcon("imagee/H.png");
        homeIcon = new ImageIcon(homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JButton homeBtn = new JButton("Home", homeIcon);

        ImageIcon infoIcon = new ImageIcon("imagee/info.png");
        infoIcon = new ImageIcon(infoIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JButton infoButton = new JButton("Organizer Info", infoIcon);

        for (JButton btn : new JButton[]{homeBtn, infoButton}) {
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
        sidebar.setLayout(new GridLayout(3, 1, 0, 10));

        JButton eventsBtn = new JButton("Manage Events");
        JButton notificationsBtn = new JButton("Notifications");
        JButton reviewsBtn = new JButton("Reviews");

        for (JButton btn : new JButton[]{eventsBtn, notificationsBtn, reviewsBtn}) {
            btn.setBackground(sideColor);
            btn.setForeground(textColor);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            sidebar.add(btn);
        }

        // المحتوى
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(bgColor);

        // واجهة الهوم
        
        JPanel homePanel = new JPanel();
        homePanel.setBackground(bgColor);
        JLabel welcome = new JLabel("Welcome to Organizer Interface", JLabel.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcome.setForeground(sideColor);
        homePanel.add(welcome);

        // واجهة معلومات المنظم
        JPanel infoPanel = createOrganizerInfoPanel();

        JPanel eventsPanel = new ManageEventsPanel();
        JPanel notificationsPanel = new NotificationsPanel();
        JPanel reviewsPanel = new OrganizerReviewPanel();

        contentPanel.add(homePanel, "home");
        contentPanel.add(infoPanel, "info");
        contentPanel.add(eventsPanel, "events");
        contentPanel.add(notificationsPanel, "notifications");
        contentPanel.add(reviewsPanel, "reviews");

        homeBtn.addActionListener(e -> showPanel("home"));
        infoButton.addActionListener(e -> showPanel("info"));
        eventsBtn.addActionListener(e -> showPanel("events"));
        notificationsBtn.addActionListener(e -> showPanel("notifications"));
        reviewsBtn.addActionListener(e -> showPanel("reviews"));

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        showPanel("home");
        setVisible(true);
    }

    private void showPanel(String name) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, name);
    }

    // Organizer Info Panel مع خلفية ومعلومات
    private JPanel createOrganizerInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout()) {
            private Image bgImage = new ImageIcon("imagee/ros.jpg").getImage();
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        JLabel title = new JLabel("Organizer Information", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        panel.add(title, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        infoPanel.add(createInfoItem("Name: ", "Organizer Reem", new ImageIcon("imagee/username.png")));
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(createInfoItem("Email: ", "reem@trip.com", new ImageIcon("imagee/Emmail.png")));
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(createInfoItem("Phone: ", "0561122334", new ImageIcon("imagee/phone(2).png")));

        panel.add(infoPanel, BorderLayout.CENTER);
        return panel;
    }

    // العنصر الواحد داخل صفحة المعلومات
   private JPanel createInfoItem(String labelText, String valueText, Icon icon) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel.setBackground(new Color(255, 255, 255, 200));
    panel.setPreferredSize(new Dimension(500, 60)); // عرض وبطاقة أطول

    JLabel iconLabel = new JLabel();
    Image img = ((ImageIcon) icon).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // تصغير أيقونة
    iconLabel.setIcon(new ImageIcon(img));

    JLabel label = new JLabel(labelText);
    label.setFont(new Font("Segoe UI", Font.BOLD, 18)); // خط أكبر
    label.setForeground(new Color(102, 0, 153));

    JLabel value = new JLabel(valueText);
    value.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // خط أكبر
    value.setForeground(Color.DARK_GRAY);

    panel.add(iconLabel);
    panel.add(Box.createHorizontalStrut(15));
    panel.add(label);
    panel.add(value);

    return panel;
}
    public static void main(String[] args) {
        new OrganizerDashboard();
    }
}