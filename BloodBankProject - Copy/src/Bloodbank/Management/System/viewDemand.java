package Bloodbank.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewDemand extends JFrame implements ActionListener {

    JLabel  label1,label2,label3,label4,label5,label6,label7;

    JTable table1,table2;

    JScrollPane pg,pg1;

    Container cnt,cnt1;

    JButton button1;

    viewDemand(){

        JLabel lable1 = new JLabel("View Blood Demand" );
        lable1.setBounds(250, 60, 600, 40);
        lable1.setFont(new Font("Raleway",Font.BOLD,30));
        lable1.setForeground(new Color(0x07A983));
        add(lable1);



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
        table2.setBounds(80,225,700,300);
        cnt1.setLayout(null);
        cnt1.setBounds(80,225,700,300);
        cnt1.setBackground(new Color(224,238,236));


        pg1 = new JScrollPane(table2);
        pg1.setBounds(80,225,700,300);
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
        button1.setBounds(350,600,150,40);
        button1.addActionListener(this);
        add(button1);


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

    public static void main(String[] args) {
        new viewDemand();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()==button1){
                new Admin("");
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
