package Bloodbank.Management.System;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class report extends JFrame implements ActionListener {

    JLabel  label1,label2,label3,label4,label5,label6,label7;

    JTable table1,table2;

    JScrollPane pg,pg1;

    static Container cnt,cnt1;

    JButton button1,button3;
    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L) +1000L;
    String first = " " + Math.abs(first4);

    static String s,id1;

    report(){
        super("Report Generation");

//        this.loginType = loginType;

        label1 = new JLabel("Report ");
        label1.setForeground(new Color(0x07A983));
        label1.setBounds(370,30,500,46);
        label1.setFont(new Font("poppins",Font.BOLD,30));
        add(label1);


        label2 = new JLabel("Date                             :");
        label2.setForeground(new Color(0x07A983));
        label2.setBounds(80,100,500,46);
        label2.setFont(new Font("poppins",Font.BOLD,18));
        add(label2);

        s = new Date().toLocaleString();
        label6 = new JLabel(s);
        label6.setBounds(280,100,300,46);
        label6.setFont(new Font("poppins",Font.BOLD,16));
        add(label6);


        label3 = new JLabel("Report ID       :");
        label3.setForeground(new Color(0x07A983));
        label3.setBounds(540,100,500,46);
        label3.setFont(new Font("poppins",Font.BOLD,18));
        add(label3);


        id1 = "Bld/bnk/"+first;
        label5 = new JLabel(id1);
        label5.setBounds(670,100,200,46);
        label5.setFont(new Font("poppins",Font.BOLD,18));
        add(label5);

        label4 = new JLabel("Availability by city :");
        label4.setForeground(new Color(0x07A983));
        label4.setBounds(490,180,500,46);
        label4.setFont(new Font("poppins",Font.BOLD,18));
        add(label4);




        DefaultTableModel model = new DefaultTableModel();
        cnt = this.getContentPane();
        table1 = new JTable(model);
        model.addColumn("Location");
        model.addColumn("Blood type");
        model.addColumn(("No of packets"));

        con db = new con();
        String q = "select * from availability";
        ResultSet rs = null;
        try {
            rs = db.statement.executeQuery(q);
            while(rs.next())
            {
                String l = rs.getString("loc");
                String bt = rs.getString("btype");
                int no = rs.getInt("noOfPackets");

                model.addRow(new Object[]{l,bt,no});
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        table1.setBackground(new Color(224,238,236));
        table1.setFont(new Font("poppins",Font.BOLD,12));
        table1.setBounds(490,225,300,300);
        cnt.setLayout(null);
        cnt.setBounds(490,225,300,300);
        cnt.setBackground(new Color(224,238,236));

        pg = new JScrollPane(table1);
        pg.setBounds(490,225,300,300);
        pg.setBackground(new Color(224,238,236));
        cnt.add(pg);
        this.pack();

        DefaultTableModel model1 = new DefaultTableModel();
        cnt1 = this.getContentPane();
        table2 = new JTable(model1);
        model1.addColumn("Location");
        model1.addColumn("Blood type");
        model1.addColumn(("No of packets"));
        String q1 = "select * from demand";
        con db1 = new con();
        ResultSet rs1 = null;
        try {
            rs1 = db1.statement.executeQuery(q1);

            while(rs1.next())
            {
                String l = rs1.getString("location");
                String bt = rs1.getString("bloodtype");
                int no = rs1.getInt("packets");
                model1.addRow(new Object[]{l,bt,no});
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        table2.setBackground(new Color(224,238,236));
        table2.setFont(new Font("poppins",Font.BOLD,12));
        table2.setBounds(80,225,300,300);
        cnt1.setLayout(null);
        cnt1.setBounds(80,225,300,300);
        cnt1.setBackground(new Color(224,238,236));


        pg1 = new JScrollPane(table2);
        pg1.setBounds(80,225,300,300);
        pg1.setBackground(new Color(224,238,236));
        pg1.setForeground(new Color(224,238,236));
        cnt1.add(pg1);
        this.pack();


        label5 = new JLabel("Demand                      :");
        label5.setForeground(new Color(0x07A983));
        label5.setBounds(80,180,500,46);
        label5.setFont(new Font("poppins",Font.BOLD,18));
        add(label5);


        button1 = new JButton("Dashboard");
        button1.setBackground(new Color(224,238,236));
        button1.setFont(new Font("poppins",Font.BOLD,14));
        button1.setBounds(400,600,150,40);
        button1.addActionListener(this);
        add(button1);

        button3 = new JButton("Print");
        button3.setFont(new Font("poppins", Font.BOLD, 14));
        button3.setBackground(new Color(224,238,236));
        button3.setBounds(200,600,150,40);
        button3.addActionListener(this);
        add(button3);


        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("img/baground2.jpg"));
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


    public static void main(String[] args)throws PrintException, IOException {

        new report();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {
            if (startpage.loginType.equals("admin")) {
                new Admin("");
                setVisible(false);
            }
            else {
                new dashboard();
                setVisible(false);
            }
        }
        else if(e.getSource()==button3)
        {
            try {
                new reportSlip();
                setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
