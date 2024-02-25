package Bloodbank.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.sql.ResultSet;
import java.sql.SQLException;

    public class Stock extends JFrame implements ActionListener {

        JComboBox comboBox, comboBox1, comboBox2;

        JButton button,button1;

        JLabel label1, label2, label3, g1, g2, g3, g4, g5, g6, g7, g8;
        JTextField j1, j2, j3, j4, j5, j6, j7, j8;


        public Stock() {
            super("Stock");

            label1 = new JLabel("STOCK");
            label1.setBackground(new Color(0xFF6666));
            label1.setForeground(new Color(0xFF6666));
            label1.setBounds(320, 100, 500, 46);
            label1.setFont(new Font("poppins", Font.BOLD, 30));
            add(label1);

            String[] location = {"<---Select-->", "Noida", "Delhi", "Gurugram", "Ghaziabad"};
            comboBox = new JComboBox(location);
            comboBox.setBounds(420, 205, 150, 40);
            comboBox.setBackground(new Color(240, 250, 252));
            comboBox.setFont(new Font("Poppins", Font.BOLD, 14));
            comboBox.addActionListener(this);
            add(comboBox);

            label2 = new JLabel("Select Location    : ");
            label2.setBounds(230, 200, 600, 40);
            label2.setFont(new Font("poppins", Font.BOLD, 18));
            label2.setBackground(new Color(166, 182, 181));
            label2.setForeground(new Color(166, 182, 181));
            add(label2);

            label3 = new JLabel("Blood type ");
            label3.setBounds(400, 270, 600, 40);
            label3.setFont(new Font("poppins", Font.BOLD, 20));
            label3.setForeground(new Color(0xFF6666));
            add(label3);
            //blood group
            g1 = new JLabel("A+");
            g1.setBounds(230, 320, 50, 40);
            g1.setFont(new Font("poppins", Font.BOLD, 18));
            g1.setBackground(new Color(166, 182, 181));
            g1.setForeground(new Color(166, 182, 181));
            add(g1);
            j1 = new JTextField("0");
            j1.setBounds(300, 320, 50, 40);
            j1.setBackground(new Color(240, 250, 252));
            j1.setFont(new Font("Poppins", Font.BOLD, 14));
            j1.addActionListener(this);
            add(j1);


            g2 = new JLabel("A-");
            g2.setBounds(530, 320, 50, 40);
            g2.setFont(new Font("poppins", Font.BOLD, 18));
            g2.setBackground(new Color(166, 182, 181));
            g2.setForeground(new Color(166, 182, 181));
            add(g2);
            j2 = new JTextField("0");
            j2.setBounds(600, 320, 50, 40);
            j2.setBackground(new Color(240, 250, 252));
            j2.setFont(new Font("Poppins", Font.BOLD, 14));
            j2.addActionListener(this);
            add(j2);

            g3 = new JLabel("B+");
            g3.setBounds(230, 380, 50, 40);
            g3.setFont(new Font("poppins", Font.BOLD, 18));
            g3.setBackground(new Color(166, 182, 181));
            g3.setForeground(new Color(166, 182, 181));
            add(g3);
            j3 = new JTextField("0");
            j3.setBounds(300, 380, 50, 40);
            j3.setBackground(new Color(240, 250, 252));
            j3.setFont(new Font("Poppins", Font.BOLD, 14));
            j3.addActionListener(this);
            add(j3);


            g4 = new JLabel("B- ");
            g4.setBounds(530, 380, 50, 40);
            g4.setFont(new Font("poppins", Font.BOLD, 18));
            g4.setBackground(new Color(166, 182, 181));
            g4.setForeground(new Color(166, 182, 181));
            add(g4);
            j4 = new JTextField("0");
            j4.setBounds(600, 380, 50, 40);
            j4.setBackground(new Color(240, 250, 252));
            j4.setFont(new Font("Poppins", Font.BOLD, 14));
            j4.addActionListener(this);
            add(j4);


            g5 = new JLabel("AB+");
            g5.setBounds(230, 440, 50, 40);
            g5.setFont(new Font("poppins", Font.BOLD, 18));
            g5.setBackground(new Color(166, 182, 181));
            g5.setForeground(new Color(166, 182, 181));
            add(g5);
            j5 = new JTextField("0");
            j5.setBounds(300, 440, 50, 40);
            j5.setBackground(new Color(240, 250, 252));
            j5.setFont(new Font("Poppins", Font.BOLD, 14));
            j5.addActionListener(this);
            add(j5);

            g6 = new JLabel("AB-");
            g6.setBounds(530, 440, 50, 40);
            g6.setFont(new Font("poppins", Font.BOLD, 18));
            g6.setBackground(new Color(166, 182, 181));
            g6.setForeground(new Color(166, 182, 181));
            add(g6);
            j6 = new JTextField("0");
            j6.setBounds(600, 440, 50, 40);
            j6.setBackground(new Color(240, 250, 252));
            j6.setFont(new Font("Poppins", Font.BOLD, 14));
            j6.addActionListener(this);
            add(j6);


            g7 = new JLabel("O+");
            g7.setBounds(230, 500, 50, 40);
            g7.setFont(new Font("poppins", Font.BOLD, 18));
            g7.setBackground(new Color(166, 182, 181));
            g7.setForeground(new Color(166, 182, 181));
            add(g7);
            j7 = new JTextField("0");
            j7.setBounds(300, 500, 50, 40);
            j7.setBackground(new Color(240, 250, 252));
            j7.setFont(new Font("Poppins", Font.BOLD, 14));
            j7.addActionListener(this);
            add(j7);


            g8 = new JLabel("O-");
            g8.setBounds(530, 500, 50, 40);
            g8.setFont(new Font("poppins", Font.BOLD, 18));
            g8.setBackground(new Color(166, 182, 181));
            g8.setForeground(new Color(166, 182, 181));
            add(g8);
            j8 = new JTextField("0");
            j8.setBounds(600, 500, 50, 40);
            j8.setBackground(new Color(240, 250, 252));
            j8.setFont(new Font("Poppins", Font.BOLD, 14));
            j8.addActionListener(this);
            add(j8);


            button = new JButton("Update Stock");
            button.setFont(new Font("poppins", Font.BOLD, 18));
            button.setForeground(new Color(244, 252, 252));
            button.setBackground(new Color(0xFF6666));
            button.setBounds(220, 650, 180, 40);
            button.addActionListener(this);
            add(button);

            button1 = new JButton("Dashboard");
            button1.setFont(new Font("poppins", Font.BOLD, 18));
            button1.setForeground(new Color(244, 252, 252));
            button1.setBackground(new Color(0xFF6666));
            button1.setBounds(480, 650, 180, 40);
            button1.addActionListener(this);
            add(button1);


            ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
            Image ii1 = ii.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            ImageIcon ii2 = new ImageIcon(ii1);
            JLabel ii3 = new JLabel(ii2);
            ii3.setBounds(620, 45, 170, 170);
            add(ii3);


            ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground1.jpg"));
            Image iii2 = iii1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
            ImageIcon iii3 = new ImageIcon(iii2);
            JLabel image2 = new JLabel(iii3);
            image2.setBounds(0, 0, 850, 800);
            add(image2);

            setSize(850, 800);
            setLayout(null);
            setUndecorated(true);
            setLocation(360, 10);
            setVisible(true);


        }


        public static void main(String[] args) {

            new Stock();

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = (String) comboBox.getSelectedItem();
            String bg1 = j1.getText();
            String bg2 = j2.getText();
            String bg3 = j3.getText();
            String bg4 = j4.getText();
            String bg5 = j5.getText();
            String bg6 = j6.getText();
            String bg7 = j7.getText();
            String bg8 = j8.getText();

            String A1 = "A+";
            String A2 = "A-";
            String B1 = "B+";
            String B2 = "B-";
            String AB1 = "AB+";
            String AB2 = "AB-";
            String O1 = "O+";
            String O2 = "O-";



            if (e.getSource() == button) {
                con con = new con();
                if (s1.equals("<---Select-->")) {
                    JOptionPane.showMessageDialog(null, "Please Select Location");

                } else {

                    //first
                    String first = "select noOfPackets from availability where btype='" + A1 + "' and loc='" + s1 + "'";
                    String d1 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(first);
                        while (rs.next()) {
                            d1 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    int p1 = Integer.parseInt(bg1) + Integer.parseInt(d1);
                    if (p1 < 0) {
                        JOptionPane.showMessageDialog(null, "Invalid option");
                        setVisible(false);
                        new Stock();
                    }
                    String f1 = (String.valueOf(p1));
                    String q1 = "update availability set noOfPackets ='" + f1 + "' where btype='" + A1 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q1);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    //second
                    String second = "select noOfPackets from availability where btype='" + A2 + "' and loc='" + s1 + "'";
                    String d2 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(second);
                        while (rs.next()) {
                            d2 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p2 = Integer.parseInt(bg2) + Integer.parseInt(d2);
                    String f2 = (String.valueOf(p2));
                    String q2 = "update availability set noOfPackets ='" + f2 + "' where btype='" + A2 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q2);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //third
                    String third = "select noOfPackets from availability where btype='" + B1 + "' and loc='" + s1 + "'";
                    String d3 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(third);
                        while (rs.next()) {
                            d3 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p3 = Integer.parseInt(bg3) + Integer.parseInt(d3);
                    String f3 = (String.valueOf(p3));
                    String q3 = "update availability set noOfPackets ='" + f3 + "' where btype='" + B1 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q3);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //fourth
                    String fourth = "select noOfPackets from availability where btype='" + B2 + "' and loc='" + s1 + "'";
                    String d4 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(fourth);
                        while (rs.next()) {
                            d4 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p4 = Integer.parseInt(bg4) + Integer.parseInt(d4);
                    String f4 = (String.valueOf(p4));
                    String q4 = "update availability set noOfPackets ='" + f4 + "' where btype='" + B2 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q4);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //fifth
                    String five = "select noOfPackets from availability where btype='" + AB1 + "' and loc='" + s1 + "'";
                    String d5 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(five);
                        while (rs.next()) {
                            d5 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p5 = Integer.parseInt(bg5) + Integer.parseInt(d5);
                    String f5 = (String.valueOf(p5));
                    String q5 = "update availability set noOfPackets ='" + f5 + "' where btype='" + AB1 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q5);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //sixth
                    String six = "select noOfPackets from availability where btype='" + AB2 + "' and loc='" + s1 + "'";
                    String d6 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(six);
                        while (rs.next()) {
                            d6 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p6 = Integer.parseInt(bg6) + Integer.parseInt(d6);
                    String f6 = (String.valueOf(p6));
                    String q6 = "update availability set noOfPackets ='" + f6 + "' where btype='" + AB2 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q6);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //seventh
                    String sev = "select noOfPackets from availability where btype='" + O1 + "' and loc='" + s1 + "'";
                    String d7 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(sev);
                        while (rs.next()) {
                            d7 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p7 = Integer.parseInt(bg7) + Integer.parseInt(d7);
                    String f7 = (String.valueOf(p7));
                    String q7 = "update availability set noOfPackets ='" + f7 + "' where btype='" + O1 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q7);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //eighth
                    String eig = "select noOfPackets from availability where btype='" + O2 + "' and loc='" + s1 + "'";
                    String d8 = "";
                    try {
                        ResultSet rs = con.statement.executeQuery(eig);
                        while (rs.next()) {
                            d8 = rs.getString("noOfPackets");


                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    int p8 = Integer.parseInt(bg8) + Integer.parseInt(d8);
                    String f8 = (String.valueOf(p8));
                    String q8 = "update availability set noOfPackets ='" + f8 + "' where btype='" + O2 + "' and loc='" + s1 + "'";
                    try {
                        con.statement.executeUpdate(q8);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    JOptionPane.showMessageDialog(null, "Stock updated");

                    new Admin("");
                    setVisible(false);
                }
            } else if (e.getSource() == button1) {
            new Admin("");
            setVisible(false);
            }
        }
    }
