package Bloodbank.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewUser extends JFrame implements ActionListener {

    JTable table1,table2;
    JScrollPane scrollPane1,scrollPane2;
    Container c1,c2;
    JButton button;

    viewUser(){

        super("View Donor Details");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,5,120,120);
        add(image);

        JLabel lable1 = new JLabel("View Users Details" );
        lable1.setBounds(250, 60, 600, 40);
        lable1.setFont(new Font("Raleway",Font.BOLD,30));
        lable1.setForeground(Color.DARK_GRAY);
        add(lable1);

        JLabel lable2 = new JLabel("View Donors detail" );
        lable2.setBounds(80, 180, 300, 40);
        lable2.setFont(new Font("Raleway",Font.BOLD,16));
        lable2.setForeground(Color.DARK_GRAY);
        add(lable2);

        DefaultTableModel model1 = new DefaultTableModel();
        c1 = this.getContentPane();
        table1 = new JTable(model1);
        model1.addColumn("Name");
        model1.addColumn("Email");
        model1.addColumn("Date of Birth");
        model1.addColumn("Address");
        model1.addColumn("BloodType");
        model1.addColumn("Gender");

        String d = "donor";
        con con1 = new con();
        String s = "select * from registration where logintype = '"+d+"'";
        try {
            ResultSet rs = con1.statement.executeQuery(s);
            while(rs.next()){
                String Name1 = rs.getString("name");
                String Email1 = rs.getString("mail");
                String DOB1 = rs.getString("dob");
                String Address1 = rs.getString("addr");
                String BT = rs.getString("bloodType");
                String Gender1 = rs.getString("gender");

                model1.addRow(new Object[]{Name1,Email1,DOB1,Address1,BT,Gender1});

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table1.setBackground(new Color(0xCBCBCB));
        table1.setFont(new Font("poppins",Font.BOLD,12));
        table1.setBounds(80,225,700,200);
        c1.setLayout(null);
        c1.setBounds(80,225,700,200);
        c1.setBackground(new Color(0xCBCBCB));
        scrollPane1 = new JScrollPane(table1);
        scrollPane1.setBounds(80,225,700,200);
        scrollPane1.setBackground(new Color(0xCBCBCB));
        c1.add(scrollPane1);
        this.pack();



        JLabel lable3 = new JLabel("View Reciever detail" );
        lable3.setBounds(80, 460, 300, 40);
        lable3.setFont(new Font("Raleway",Font.BOLD,16));
        lable3.setForeground(Color.DARK_GRAY);
        add(lable3);

        DefaultTableModel model2 = new DefaultTableModel();
        c2 = this.getContentPane();
        table2 = new JTable(model2);
        model2.addColumn("Name");
        model2.addColumn("Email");
        model2.addColumn("Date of Birth");
        model2.addColumn("Address");
        model2.addColumn("BloodType");
        model2.addColumn("Gender");

        String r = "reciever";
        con con2 = new con();
        String q = "select * from registration where logintype = 'reciever'";
        try {
            ResultSet rs1 = con2.statement.executeQuery(q);
            while(rs1.next()){
                String Name1 = rs1.getString("name");
                String Email1 = rs1.getString("mail");
                String DOB1 = rs1.getString("dob");
                String Address1 = rs1.getString("addr");
                String BT = rs1.getString("bloodType");
                String Gender1 = rs1.getString("gender");

                model2.addRow(new Object[]{Name1,Email1,DOB1,Address1,BT,Gender1});

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table2.setBackground(new Color(0xCBCBCB));
        table2.setFont(new Font("poppins",Font.BOLD,12));
        table2.setBounds(80,500,700,200);
        c2.setLayout(null);
        c2.setBounds(80,500,700,200);
        c2.setBackground(new Color(0xCBCBCB));
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(80,500,700,200);
        scrollPane2.setBackground(new Color(0xCBCBCB));
        c2.add(scrollPane2);
        this.pack();

        button = new JButton("Dashboard");
        button.setFont(new Font("poppins", Font.BOLD, 15));
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.lightGray);
        button.setBounds(350, 720, 150, 30);
        button.addActionListener(this);
        add(button);





        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel  image2 = new JLabel(iii3);
        image2.setBounds(0,0 , 850, 800);
        add(image2);


//        getContentPane().setBackground(new Color(146,168,254));
        setSize(850, 800);
        setLayout(null);
        setLocation(360, 10);
        setVisible(true);

    }

    public static void main(String[] args) {
        new viewUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()==button){
                new Admin("");
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
