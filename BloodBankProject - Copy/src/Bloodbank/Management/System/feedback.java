package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class feedback extends JFrame implements ActionListener {
    JLabel label1, label2, label3, l1, l2, l3, contactus;
    JRadioButton r1, r2, r3, r4, r5, c1, c2, c3, c4, c5, sb1, sb2, sb3, sb4, sb5, da1, da2, da3, da4, da5;
    ButtonGroup bg, bc1, sb, da;
    JTextArea text3;
    JButton button, button1;

    feedback() {
        super("Feedback");
        label1 = new JLabel("Feedback Form");
        label1.setBackground(new Color(0xFF6666));
        label1.setForeground(new Color(0xFF6666));
        label1.setBounds(320, 100, 500, 46);
        label1.setFont(new Font("poppins", Font.BOLD, 30));
        add(label1);

        label2 = new JLabel("Portal Service:");
        label2.setBounds(100, 200, 200, 40);
        label2.setFont(new Font("poppins", Font.BOLD, 16));
        label2.setBackground(new Color(42, 42, 42));
        label2.setForeground(new Color(42, 42, 42));
        add(label2);

        r1 = new JRadioButton("1");
        r1.setBounds(300, 200, 50, 30);
        r1.setFont(new Font("poppins", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("2");
        r2.setBounds(370, 200, 50, 30);
        r2.setFont(new Font("poppins", Font.BOLD, 14));
        add(r2);

        r3 = new JRadioButton("3");
        r3.setBounds(440, 200, 50, 30);
        r3.setFont(new Font("poppins", Font.BOLD, 14));
        add(r3);

        r4 = new JRadioButton("4");
        r4.setBounds(510, 200, 50, 30);
        r4.setFont(new Font("poppins", Font.BOLD, 14));
        add(r4);

        r5 = new JRadioButton("5");
        r5.setBounds(580, 200, 50, 30);
        r5.setFont(new Font("poppins", Font.BOLD, 14));
        add(r5);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);

        l1 = new JLabel("Stock Availability:");
        l1.setBounds(100, 260, 200, 40);
        l1.setFont(new Font("poppins", Font.BOLD, 16));
        l1.setBackground(new Color(42, 42, 42));
        l1.setForeground(new Color(42, 42, 42));
        add(l1);

        c1 = new JRadioButton("1");
        c1.setBounds(300, 260, 50, 30);
        c1.setFont(new Font("poppins", Font.BOLD, 14));
        add(c1);

        c2 = new JRadioButton("2");
        c2.setBounds(370, 260, 50, 30);
        c2.setFont(new Font("poppins", Font.BOLD, 14));
        add(c2);

        c3 = new JRadioButton("3");
        c3.setBounds(440, 260, 50, 30);
        c3.setFont(new Font("poppins", Font.BOLD, 14));
        add(c3);

        c4 = new JRadioButton("4");
        c4.setBounds(510, 260, 50, 30);
        c4.setFont(new Font("poppins", Font.BOLD, 14));
        add(c4);

        c5 = new JRadioButton("5");
        c5.setBounds(580, 260, 50, 30);
        c5.setFont(new Font("poppins", Font.BOLD, 14));
        add(c5);

        bc1 = new ButtonGroup();
        bc1.add(c1);
        bc1.add(c2);
        bc1.add(c3);
        bc1.add(c4);
        bc1.add(c5);

        l2 = new JLabel("Appointment Availability:");
        l2.setBounds(100, 320, 200, 40);
        l2.setFont(new Font("poppins", Font.BOLD, 16));
        l2.setBackground(new Color(42, 42, 42));
        l2.setForeground(new Color(42, 42, 42));
        add(l2);

        sb1 = new JRadioButton("1");
        sb1.setBounds(300, 320, 50, 30);
        sb1.setFont(new Font("poppins", Font.BOLD, 14));
        add(sb1);

        sb2 = new JRadioButton("2");
        sb2.setBounds(370, 320, 50, 30);
        sb2.setFont(new Font("poppins", Font.BOLD, 14));
        add(sb2);

        sb3 = new JRadioButton("3");
        sb3.setBounds(440, 320, 50, 30);
        sb3.setFont(new Font("poppins", Font.BOLD, 14));
        add(sb3);

        sb4 = new JRadioButton("4");
        sb4.setBounds(510, 320, 50, 30);
        sb4.setFont(new Font("poppins", Font.BOLD, 14));
        add(sb4);

        sb5 = new JRadioButton("5");
        sb5.setBounds(580, 320, 50, 30);
        sb5.setFont(new Font("poppins", Font.BOLD, 14));
        add(sb5);

        sb = new ButtonGroup();
        sb.add(sb1);
        sb.add(sb2);
        sb.add(sb3);
        sb.add(sb4);
        sb.add(sb5);

        l3 = new JLabel("Rating (out of 5):");
        l3.setBounds(100, 380, 200, 40);
        l3.setFont(new Font("poppins", Font.BOLD, 16));
        l3.setBackground(new Color(42, 42, 42));
        l3.setForeground(new Color(42, 42, 42));
        add(l3);

        da1 = new JRadioButton("1");
        da1.setBounds(300, 380, 50, 30);
        da1.setFont(new Font("poppins", Font.BOLD, 14));
        add(da1);

        da2 = new JRadioButton("2");
        da2.setBounds(370, 380, 50, 30);
        da2.setFont(new Font("poppins", Font.BOLD, 14));
        add(da2);

        da3 = new JRadioButton("3");
        da3.setBounds(440, 380, 50, 30);
        da3.setFont(new Font("poppins", Font.BOLD, 14));
        add(da3);

        da4 = new JRadioButton("4");
        da4.setBounds(510, 380, 50, 30);
        da4.setFont(new Font("poppins", Font.BOLD, 14));
        add(da4);

        da5 = new JRadioButton("5");
        da5.setBounds(580, 380, 50, 30);
        da5.setFont(new Font("poppins", Font.BOLD, 14));
        add(da5);

        da = new ButtonGroup();
        da.add(da1);
        da.add(da2);
        da.add(da3);
        da.add(da4);
        da.add(da5);

        contactus = new JLabel("contact us : Mob - +11-2345-6789 / Email - blood_bank@gmail.com");
        contactus.setBounds(80, 700, 650, 40);
        contactus.setFont(new Font("poppins", Font.BOLD, 16));
        contactus.setBackground(new Color(42, 42, 42));
        contactus.setForeground(new Color(42, 42, 42));
        add(contactus);


        label3 = new JLabel("Any Suggestions");
        label3.setBounds(100, 550, 150, 40);
        label3.setFont(new Font("poppins", Font.BOLD, 16));
        label3.setBackground(new Color(42, 42, 42));
        label3.setForeground(new Color(42, 42, 42));
        add(label3);

        text3 = new JTextArea();
        text3.setBounds(250, 500, 400, 100);
        text3.setFont(new Font("poppins", Font.BOLD, 18));
        text3.setBackground(new Color(183, 211, 211));
        add(text3);

        button = new JButton("Submit");
        button.setFont(new Font("poppins", Font.BOLD, 18));
        button.setForeground(new Color(255, 247, 247));
        button.setBackground(new Color(246, 114, 124));
        button.setBounds(470, 640, 180, 40);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Dashboard");
        button1.setFont(new Font("poppins", Font.BOLD, 18));
        button1.setForeground(new Color(255, 247, 247));
        button1.setBackground(new Color(246, 114, 124));
        button1.setBounds(200, 640, 180, 40);
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
        new feedback();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        con con = new con();
        String sugg = text3.getText();
        String ser = null;
        String rate = null;
        String app = null;
        String st = null;

        if (e.getSource() == button) {
            if (r1.isSelected()) {
                ser = "poor";
            } else if (r2.isSelected()) {
                ser = "satisfactory";
            } else if (r3.isSelected()) {
                ser = "Average";
            } else if (r4.isSelected()) {
                ser = "Good";
            } else {
                ser = "Very Good";
            }

            if (da1.isSelected()) {
                rate = "poor";
            } else if (da2.isSelected()) {
                rate = "satisfactory";
            } else if (da3.isSelected()) {
                rate = "Average";
            } else if (da4.isSelected()) {
                rate = "good";
            } else {
                rate = "very good";
            }

            if (sb1.isSelected()) {
                app = "poor";
            } else if (sb2.isSelected()) {
                app = "satisfactory";
            } else if (sb3.isSelected()) {
                app = "Average";
            } else if (sb4.isSelected()) {
                app = "good";
            } else {
                app = "very good";
            }

            if (c1.isSelected()) {
                st = "poor";
            } else if (c2.isSelected()) {
                st = "satisfactory";
            } else if (c3.isSelected()) {
                st = "Average";
            } else if (c4.isSelected()) {
                st = "good";
            } else {
                st = "very good";
            }
            if ((r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected() || r5.isSelected()) && (da1.isSelected() || da2.isSelected() || da3.isSelected() || da4.isSelected() || da5.isSelected())
                    && (sb1.isSelected() || sb2.isSelected() || sb3.isSelected() || sb4.isSelected() || sb5.isSelected()) && (c1.isSelected() || c2.isSelected() || c3.isSelected() || c4.isSelected() || c5.isSelected())
                    && !sugg.equals("")) {
                String id = Login.textField1.getText();
                String q1 = "insert into feedback values ('" + id + "','" + ser + "','" + st + "','" + app + "','" + rate + "','" + sugg + "')";
                try {
                    con.statement.executeUpdate(q1);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Thank you for your Feedback. Redirecting to Dashboard!");
                new dashboard();
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Please select all fields!");
            }

        }else if (e.getSource() == button1) {
            new dashboard();
            setVisible(false);

        }
    }
}
 