package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteStock extends JFrame implements ActionListener {

    static JComboBox comboBox, comboBox1, comboBox2;

    JButton button, button1;
    JTextField textField;
    JLabel label1, label2, label3, label4;

    deleteStock() {
        super("Stock Module");

        label1 = new JLabel("Delete Blood Packets");
        label1.setBackground(new Color(0xFF6666));
        label1.setForeground(new Color(0xFF6666));
        label1.setBounds(280, 100, 500, 46);
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


        String[] bloodtype = {"O+", "O-", "B+", "B-", "A+", "A-", "AB+", "AB-"};
        comboBox1 = new JComboBox(bloodtype);
        comboBox1.setBounds(420, 275, 150, 40);
        comboBox1.setBackground(new Color(240, 250, 252));
        comboBox1.setFont(new Font("Poppins", Font.BOLD, 14));
        comboBox1.addActionListener(this);
        add(comboBox1);

        label3 = new JLabel("Select Blood type : ");
        label3.setBounds(230, 270, 600, 40);
        label3.setFont(new Font("poppins", Font.BOLD, 18));
        label3.setBackground(new Color(166, 182, 181));
        label3.setForeground(new Color(166, 182, 181));
        add(label3);

        label4 = new JLabel("Select Quantity     : ");
        label4.setBounds(230, 340, 600, 40);
        label4.setFont(new Font("poppins", Font.BOLD, 18));
        label4.setBackground(new Color(166, 182, 181));
        label4.setForeground(new Color(166, 182, 181));
        add(label4);

        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        comboBox2 = new JComboBox(numbers);
        comboBox2.setBounds(420, 345, 150, 40);
        comboBox2.setBackground(new Color(240, 250, 252));
        comboBox2.setFont(new Font("Poppins", Font.BOLD, 14));
        comboBox2.addActionListener(this);
        add(comboBox2);

//        textField = new JTextField();
//        textField.setBounds(420, 345, 150, 40);
//        textField.setBackground(new Color(240, 250, 252));
//        textField.setFont(new Font("Poppins", Font.BOLD, 14));
//        textField.addActionListener(this);
//        add(textField);


        button = new JButton("Dashboard");
        button.setFont(new Font("poppins", Font.BOLD, 18));
        button.setForeground(new Color(244, 252, 252));
        button.setBackground(new Color(0xFF6666));
        button.setBounds(230, 450, 140, 40);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Delete Packet");
        button1.setFont(new Font("poppins", Font.BOLD, 18));
        button1.setForeground(new Color(244, 252, 252));
        button1.setBackground(new Color(0xFF6666));
        button1.setBounds(400, 450, 170, 40);
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
        new deleteStock();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s1 = (String) comboBox.getSelectedItem();
        String s2 = (String) comboBox1.getSelectedItem();
        String s3 = (String) comboBox2.getSelectedItem();

        String a = (String) comboBox2.getSelectedItem();
        int c = Integer.parseInt(a);
        int b = 0;


        String s = "select noOfPackets from availability where loc='" + s1 + "' && btype ='" + s2 + "'";


        con con = new con();
        try {
            ResultSet rs = con.statement.executeQuery(s);

            while (rs.next()) {
                b = rs.getInt("noOfPackets");
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if (e.getSource() == button1) {
            {
                if (s1.equals("<---Select-->") || s2.equals("<---Select-->") || s3.equals("<---Select-->")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields!");
                } else if (b < c) {
                    JOptionPane.showMessageDialog(null, "Insufficient packets!");
                } else {
                    String q = "update availability set noOfPackets='" + (b - c) + "'where loc='" + s1 + "' && btype ='" + s2 + "'";
                    JOptionPane.showMessageDialog(null, "No. of Packets:" + (b - c));
                    new deleteStock();
                    setVisible(false);

                    try {
                        con.statement.executeUpdate(q);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } else if (e.getSource()==button) {
            new Admin("");
            setVisible(false);

        }
    }
}
