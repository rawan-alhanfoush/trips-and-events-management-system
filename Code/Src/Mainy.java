/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.interfacess;

/**
 *
 * @author she5o
 * 
 */import javax.swing.*;
import java.awt.*;

public class Mainy extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Mainy() {
        setTitle("Customer Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color lightPurple = new Color(240, 220, 255);
        Color darkPurple = new Color(102, 0, 153);
        Font font = new Font("Arial", Font.BOLD, 16);

        // Top Panel (Home, About Us, User Info)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        topPanel.setBackground(darkPurple);

        ImageIcon homeIcon = new ImageIcon("imagee/H.png"); 
Image homeImg = homeIcon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        JButton homeBtnTop = new JButton(" Home", new ImageIcon(homeImg));
homeBtnTop.setFont(font);
homeBtnTop.setBackground(Color.WHITE);
homeBtnTop.setForeground(new Color(102, 0, 153));
homeBtnTop.setFocusPainted(false);
homeBtnTop.setHorizontalTextPosition(SwingConstants.RIGHT);
       ImageIcon aboutIcon = new ImageIcon("imagee/us.png"); 
Image aboutImg = aboutIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
JButton aboutBtnTop = new JButton(" About Us", new ImageIcon(aboutImg));
aboutBtnTop.setFont(font);
aboutBtnTop.setBackground(Color.WHITE);
aboutBtnTop.setForeground(new Color(102, 0, 153));
aboutBtnTop.setFocusPainted(false);
aboutBtnTop.setHorizontalTextPosition(SwingConstants.RIGHT);
       ImageIcon userIcon = new ImageIcon("imagee/info.png"); // تأكدي إن الصورة موجودة بهذا المسار
Image userImg = userIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
JButton userInfoBtnTop = new JButton(" User Info", new ImageIcon(userImg));
userInfoBtnTop.setFont(font);
userInfoBtnTop.setBackground(Color.WHITE);
userInfoBtnTop.setForeground(new Color(102, 0, 153));
userInfoBtnTop.setFocusPainted(false);
userInfoBtnTop.setHorizontalTextPosition(SwingConstants.RIGHT);

        topPanel.add(homeBtnTop);
        topPanel.add(aboutBtnTop);
        topPanel.add(userInfoBtnTop);

        // Sidebar
        JPanel sideBar = new JPanel(new GridLayout(6, 1, 10, 10));
        sideBar.setBackground(darkPurple);
        sideBar.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        // Main Panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(lightPurple);

        // Panels
        JPanel homePanel = new HomePanel();
        JPanel tripBookingPanel = new TripBookingPanel();
        JPanel tripEventPanel = new TripEventPanel();
        JPanel servicePanel = new ServicePanel();
        JPanel paymentPanel = new SimplePaymentPanel();
        JPanel reviewPanel = new ReviewsPanel();
        JPanel aboutPanel = new AboutUsPanel();
        JPanel userInfoPanel = new UserInfoPanel();

        // Add panels to card layout
        mainPanel.add(homePanel, "Home");
        mainPanel.add(tripBookingPanel, "TripBooking");
        mainPanel.add(tripEventPanel, "TripEvent");
        mainPanel.add(servicePanel, "Service");
        mainPanel.add(paymentPanel, "Payment");
        mainPanel.add(reviewPanel, "Reviews");
        mainPanel.add(aboutPanel, "About");
        mainPanel.add(userInfoPanel, "UserInfo");

        // Sidebar Buttons
        JButton tripBookingBtn = createSidebarButton("Trip Booking", font, darkPurple);
        JButton tripEventBtn = createSidebarButton("Trip Event", font, darkPurple);
        JButton serviceBtn = createSidebarButton("Services", font, darkPurple);
        JButton paymentBtn = createSidebarButton("Payment", font, darkPurple);
        JButton notifBtn = createSidebarButton("Notifications", font, darkPurple);
        JButton reviewBtn = createSidebarButton("Reviews", font, darkPurple);

        // Add buttons to sidebar
        sideBar.add(tripBookingBtn);
        sideBar.add(tripEventBtn);
        sideBar.add(serviceBtn);
        sideBar.add(paymentBtn);
        sideBar.add(notifBtn);
        sideBar.add(reviewBtn);

        // Actions
        tripBookingBtn.addActionListener(e -> cardLayout.show(mainPanel, "TripBooking"));
        tripEventBtn.addActionListener(e -> cardLayout.show(mainPanel, "TripEvent"));
        serviceBtn.addActionListener(e -> cardLayout.show(mainPanel, "Service"));
        paymentBtn.addActionListener(e -> cardLayout.show(mainPanel, "Payment"));
        reviewBtn.addActionListener(e -> cardLayout.show(mainPanel, "Reviews"));
        notifBtn.addActionListener(e -> {
            JPanel notificationPanel = new NotificationPanel();
            mainPanel.add(notificationPanel, "Notification");
            cardLayout.show(mainPanel, "Notification");
        });

        homeBtnTop.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        aboutBtnTop.addActionListener(e -> cardLayout.show(mainPanel, "About"));
        userInfoBtnTop.addActionListener(e -> cardLayout.show(mainPanel, "UserInfo"));

        // Assemble
        add(topPanel, BorderLayout.NORTH);
        add(sideBar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Home"); // default
        setVisible(true);
    }

    private JButton createSidebarButton(String text, Font font, Color bg) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bg);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private JButton createTopButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(102, 0, 153));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Mainy::new);
    }
}