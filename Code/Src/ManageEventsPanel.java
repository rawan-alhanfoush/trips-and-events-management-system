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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ManageEventsPanel extends JPanel {

    private JTable eventTable;
    private DefaultTableModel tableModel;

    public ManageEventsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 220, 255));

        Color fgColor = new Color(102, 0, 153);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 20);

        JLabel title = new JLabel("Manage Events", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(fgColor);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        String[] columns = {"Event Name", "Location", "Date"};
        Object[][] data = {
            {"Riyadh Season", "Riyadh", "2025-04-10"},
            {"Diving Trips", "Jeddah", "2025-04-15"},
            {"Rock climbing", "AlUla", "2025-04-22"},
        };

        tableModel = new DefaultTableModel(data, columns);
        eventTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(eventTable);

        JButton deleteBtn = new JButton("Delete Selected Event");
        deleteBtn.setBackground(fgColor);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = eventTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an event to delete.");
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(getBackground());
        bottomPanel.add(deleteBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
