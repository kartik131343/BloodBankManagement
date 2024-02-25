package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin extends JFrame implements ActionListener {

    JButton button1,button2,button3,button4,button5,button6,button7,button8;
    JLabel  label1, label2,label3,label4,label5,label6;
    String loginType;

    Admin(String loginType){

            super("Admin Services Services");

            this.loginType = loginType;
//            label1 = new JLabel("Dashboard:");
//            label1.setForeground(new Color(0x545454));
//            label1.setBounds(100,120,500,30);
//            label1.setFont(new Font("poppins",Font.BOLD,22));
//            add(label1);

            label2 = new JLabel("Admin Services");
            label2.setForeground(new Color(0xFF6666));
            label2.setBounds(320,180,500,30);
            label2.setFont(new Font("poppins",Font.BOLD,22));
            add(label2);

            label5 = new JLabel("User:");
            label5.setBackground(new Color(0xFF6666));
            label5.setForeground(new Color(0x1C1C1C));
            label5.setBounds(125,70,500,46);
            label5.setFont(new Font("poppins",Font.BOLD,20));
            add(label5);

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

            label6 = new JLabel(name);
            label6.setBackground(new Color(0xFF6666));
            label6.setForeground(new Color(0xFF6666));
            label6.setBounds(190,70,500,46);
            label6.setFont(new Font("poppins",Font.BOLD,20));
            add(label6);

            label3 = new JLabel("Donor Module:");
            label3.setForeground(new Color(0x545454));
            label3.setBounds(125,240,500,30);
            label3.setFont(new Font("poppins",Font.BOLD,18));
            add(label3);

            button1 = new JButton("Add Donor/Receiver");
            button1.setFont(new Font("poppins",Font.BOLD,16));
            button1.setBackground(Color.white);
            button1.setForeground(new Color(0xFF6666));
            button1.setBounds(125,300,200,50);
            button1.addActionListener(this);
            add(button1);

            button2 = new JButton("Delete donor detail");
            button2.setFont(new Font("poppins",Font.BOLD,16));
            button2.setBackground(Color.white);
            button2.setForeground(new Color(0xFF6666));
            button2.setBounds(125,370,200,50);
            button2.addActionListener(this);
            add(button2);

            button3 = new JButton("Update donor detail");
            button3.setFont(new Font("poppins",Font.BOLD,16));
            button3.setBackground(Color.white);
            button3.setForeground(new Color(0xFF6666));
            button3.setBounds(125,440,200,50);
            button3.addActionListener(this);
            add(button3);

            button4 = new JButton("View user detail");
            button4.setFont(new Font("poppins",Font.BOLD,16));
            button4.setBackground(new Color(0xFF6666));
            button4.setForeground(Color.white);
            button4.setBounds(125,510,200,50);
            button4.addActionListener(this);
            add(button4);


            label4 = new JLabel("Stock Module:");
            label4.setForeground(new Color(0x545454));
            label4.setBounds(475,240,500,30);
            label4.setFont(new Font("poppins",Font.BOLD,18));
            add(label4);

            button5 = new JButton("Update drive location");
            button5.setFont(new Font("poppins",Font.BOLD,16));
            button5.setBackground(Color.white);
            button5.setForeground(new Color(0xFF6666));
            button5.setBounds(475,300,200,50);
            button5.addActionListener(this);
            add(button5);

            button6 = new JButton("Manage Stock");
            button6.setFont(new Font("poppins",Font.BOLD,16));
            button6.setBackground(Color.white);
            button6.setForeground(new Color(0xFF6666));
            button6.setBounds(475,370,200,50);
            button6.addActionListener(this);
            add(button6);

            button7 = new JButton("Report");
            button7.setFont(new Font("poppins",Font.BOLD,16));
            button7.setBackground(Color.white);
            button7.setForeground(new Color(0xFF6666));
            button7.setBounds(475,440,200,50);
            button7.addActionListener(this);
            add(button7);

            button8 = new JButton("Show demand");
            button8.setFont(new Font("poppins",Font.BOLD,16));
            button8.setBackground(new Color(0xFF6666));
            button8.setForeground(Color.white);
            button8.setBounds(475,510,200,50);
            button8.addActionListener(this);
            add(button8);






            ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
            Image ii1 = ii.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
            ImageIcon ii2 = new ImageIcon(ii1);
            JLabel ii3 = new JLabel(ii2);
            ii3.setBounds(620,45,150,150);
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
        new Admin("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            try{
                    if(e.getSource()==button5){
                            new drivelocation();
                            setVisible(false);

                    }else if(e.getSource()==button6) {
//                            new addStock();
                            new Stock();
                            setVisible(false);

                    }else if(e.getSource()==button1){
                            new addDR();
                            setVisible(false);

                    }else if(e.getSource()==button2){
                            new deleteParticipant();
                            setVisible(false);

                    }else if(e.getSource()==button3){
                            new updateParticipant();
                            setVisible(false);

                    } else if (e.getSource()==button4) {
                            new viewUser();
                            setVisible(false);

                    } else if (e.getSource() == button7) {
                            new report();
                            setVisible(false);

                    } else if (e.getSource() == button8) {
                            new viewDemand();
                            setVisible(false);
                    }

            }catch (Exception E){
                E.printStackTrace();
            }


    }
}
