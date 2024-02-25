package Bloodbank.Management.System;

import org.faceless.pdf2.PDF;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import org.faceless.pdf2.*;

public class OrderBill extends JFrame implements ActionListener {
    static JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
    JButton button1,button2,button3;
    static String d,name,Add,bloodType,location,c;
    OrderBill(){
        super("Bill");

        label1 = new JLabel("Bill");
        label1.setForeground(new Color(0x07A983));
        label1.setBounds(280,30,500,30);
        label1.setFont(new Font("poppins",Font.BOLD,25));
        add(label1);
        label2 = new JLabel("Date              : ");
        label2.setForeground(new Color(0x07A983));
        label2.setBounds(120,100,150,30);
        label2.setFont(new Font("poppins",Font.BOLD,18));
        add(label2);

        d = DateFormat.getDateTimeInstance().format(new Date());
        label9 = new JLabel(d);
        label9.setBounds(260,100,300,30);
        label9.setFont(new Font("poppins",Font.BOLD,18));
        label9.setBackground(new Color(224,238,236));
        add(label9);

        label3 = new JLabel("Name            : ");
        label3.setForeground(new Color(0x07A983));
        label3.setBounds(120,170,150,30);
        label3.setFont(new Font("poppins",Font.BOLD,18));
        add(label3);
        String mail = Login.textField1.getText();
        String q = "select name,addr from registration where mail='"+mail+"'";
        con con1 = new con();
        name = "";
        Add = "";
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
        label7 = new JLabel(name);
        label7.setBounds(260,170,250,30);
        label7.setFont(new Font("poppins",Font.BOLD,18));
        label7.setBackground(new Color(224,238,236));
        add(label7);
        label4 = new JLabel("Blood Type  : ");
        label4.setForeground(new Color(0x07A983));
        label4.setBounds(120,240,120,30);
        label4.setFont(new Font("poppins",Font.BOLD,18));
        add(label4);
        bloodType = (String) orderblood.comboBox1.getSelectedItem();
        label11 = new JLabel(bloodType);
        label11.setBounds(260,240,200,30);
        label11.setFont(new Font("poppins",Font.BOLD,18));
        label11.setBackground(new Color(224,238,236));
        add(label11);


        label5 = new JLabel("Location      : ");
        label5.setForeground(new Color(0x07A983));
        label5.setBounds(120,310,150,30);
        label5.setFont(new Font("poppins",Font.BOLD,18));
        add(label5);

        location = (String) orderblood.comboBox.getSelectedItem();
        label10 = new JLabel(location);
        label10.setBounds(260,310,200,30);
        label10.setFont(new Font("poppins",Font.BOLD,18));
        label10.setBackground(new Color(224,238,236));
        add(label10);
        label6 = new JLabel("Address       : ");
        label6.setForeground(new Color(0x07A983));
        label6.setBounds(120,380,150,30);
        label6.setFont(new Font("poppins",Font.BOLD,18));
        add(label6);
        label8 = new JLabel(Add);
        label8.setBounds(260,380,300,30);
        label8.setFont(new Font("poppins",Font.BOLD,18));
        label8.setBackground(new Color(224,238,236));
        add(label8);
        label12 = new JLabel("Total Amount : ");
        label12.setForeground(new Color(0x07A983));
        label12.setBounds(120,450,150,30);
        label12.setFont(new Font("poppins",Font.BOLD,18));
        add(label12);

        String a = (String) orderblood.comboBox2.getSelectedItem();
        int b = Integer.parseInt(a);
        b=b*100;
        c = "Rs."+" "+Integer.toString(b);
        label13 = new JLabel(c);
        label13.setBounds(260,450,150,30);
        label13.setFont(new Font("poppins",Font.BOLD,18));
        label13.setBackground(new Color(224,238,236));
        add(label13);
        button1 = new JButton("Dashboard");
        button1.setFont(new Font("poppins", Font.BOLD, 18));
        button1.setForeground(new Color(244, 252, 252));
        button1.setBackground(new Color(0x07A983));
        button1.setBounds(100, 550, 150, 40);
        button1.addActionListener(this);
        add(button1);
        button2 = new JButton("Feedback");
        button2.setFont(new Font("poppins", Font.BOLD, 18));
        button2.setForeground(new Color(244, 252, 252));
        button2.setBackground(new Color(0x07A983));
        button2.setBounds(300, 550, 150, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Print");
        button3.setFont(new Font("poppins", Font.BOLD, 18));
        button3.setForeground(new Color(244, 252, 252));
        button3.setBackground(new Color(0x07A983));
        button3.setBounds(200,620,150,40);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground2.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(600,700, Image.SCALE_SMOOTH);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel  image2 = new JLabel(iii3);
        image2.setBounds(0,0 , 600, 700);
        add(image2);
        setSize(600, 700);
        setLayout(null);
        setLocation(500, 50);
        setVisible(true);
    }
    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                new dashboard();
                setVisible(false);
            }
            else if(e.getSource()==button2)
            {
                new feedback();
                setVisible(false);
            }
            else if(e.getSource()==button3)
            {
                new Bill();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
 