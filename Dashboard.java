/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1366, 684);
        add(NewLabel);

        JLabel AirlineManagementSystem = new JLabel("Login Successful.");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(490, 95, 1000, 85);
        NewLabel.add(AirlineManagementSystem);
        
        JLabel AirlineManagementSystem2 = new JLabel("Welcome :)");
        AirlineManagementSystem2.setForeground(Color.WHITE);
        AirlineManagementSystem2.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem2.setBounds(545, 160, 1000, 85);
        NewLabel.add(AirlineManagementSystem2);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("HOTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
        AirlineSystem.add(FlightDetails);

        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
        menuBar.add(AirlineSystemHello);

        JMenuItem FlightDetailshello1 = new JMenuItem("ADD EMPLOYEE");
        AirlineSystemHello.add(FlightDetailshello1);

        FlightDetailshello1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddEmployee().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        JMenuItem FlightDetailshello2 = new JMenuItem("ADD ROOMS");
        AirlineSystemHello.add(FlightDetailshello2);

        FlightDetailshello2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRoom().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        FlightDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception();
            }
        });

        JMenuItem FlightDetailshello3 = new JMenuItem("ADD DRIVERS");
        AirlineSystemHello.add(FlightDetailshello3);

        FlightDetailshello3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddDrivers().setVisible(true);
                } catch (Exception e) {
                }
            }
        });
        
        JMenuItem Expenseman = new JMenuItem("EXPENSE MANAGER");
        AirlineSystemHello.add(Expenseman);
        
        Expenseman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new OpeningPage().setVisible(true);
                } 
                catch (Exception e) {
                }
            }
        });

        setSize(1373, 730);
        setVisible(true);
        setLocation(-4,2);
        getContentPane().setBackground(Color.WHITE);
    }
}
