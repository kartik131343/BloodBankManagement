package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dashboard extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5;

    JLabel  label1,label2,label3;
    dashboard(){

        super("Dashboard");

        label1 = new JLabel("Welcome to Blood Bank Services");
        label1.setBackground(new Color(0xFF6666));
        label1.setForeground(new Color(0xFF6666));
        label1.setBounds(180,200,500,46);
        label1.setFont(new Font("poppins",Font.BOLD,30));
        add(label1);

        label2 = new JLabel("User:");
        label2.setBackground(new Color(0xFF6666));
        label2.setForeground(new Color(0x1C1C1C));
        label2.setBounds(125,70,500,46);
        label2.setFont(new Font("poppins",Font.BOLD,20));
        add(label2);

        String mail = Login.textField1.getText();
        String q = "select name,addr from registration where mail='"+mail+"'";
        con con1 = new con();
        String name = "";
        String Add = "";
        try {
            ResultSet rs = con1.statement.executeQuery(q);
            while(rs.next())
            {
                name = rs.getString("name");
                Add = rs.getString("addr");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        label3 = new JLabel(name);
        label3.setBackground(new Color(0xFF6666));
        label3.setForeground(new Color(0xFF6666));
        label3.setBounds(190,70,500,46);
        label3.setFont(new Font("poppins",Font.BOLD,20));
        add(label3);


        b2 = new JButton("Report Generation");
        b2.setFont(new Font("poppins",Font.BOLD,18));
        b2.setBackground(Color.white);
        b2.setForeground(new Color(0xFF6666));
        b2.setBounds(125,390,370,80);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Check Availability");
        b3.setFont(new Font("poppins",Font.BOLD,16));
        b3.setBackground(Color.white);
        b3.setForeground(new Color(0xFF6666));
        b3.setBounds(125,300,180,80);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Order Blood");
        b4.setFont(new Font("poppins",Font.BOLD,25));
        b4.setBackground(new Color(0xFF6666));
        b4.setForeground(Color.white);
        b4.setBounds(505,300,200,170);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Locate Drive");
        b5.setFont(new Font("poppins",Font.BOLD,18));
        b5.setBackground(Color.white);
        b5.setForeground(new Color(0xFF6666));
        b5.setBounds(315,300,180,80);
        b5.addActionListener(this);
        add(b5);

        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image ii1 = ii.getImage().getScaledInstance(170,170, Image.SCALE_SMOOTH);
        ImageIcon ii2 = new ImageIcon(ii1);
        JLabel ii3 = new JLabel(ii2);
        ii3.setBounds(620,45,170,170);
        add(ii3);



        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("img/baground1.jpg"));
        Image i1 = i.getImage().getScaledInstance(850,800, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,850,800);
        add(i3);



        setLayout(null);
        setSize(850,800);
        setLocation(360,10);
        setVisible(true);



    }


    public static void main(String[] args) {
        new dashboard();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()==b4)
            {
                new orderblood();
                setVisible(false);
            }
            else if(e.getSource()==b3)
            {
                new checkAvailability();
                setVisible(false);
            }
            else if(e.getSource()==b5)
            {
                new locatedrive();
                setVisible(false);

            } else if (e.getSource() == b2) {
                new report();
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
