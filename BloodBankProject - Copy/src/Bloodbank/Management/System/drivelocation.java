package Bloodbank.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class drivelocation extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox1,comboBox2;
    JButton button,button1, button2;
    JLabel label1,label2,label3,label4;
    JDateChooser dateChooser;

    drivelocation(){

        super("Update Drive Location");

        label1 = new JLabel("Add Drive Location");
        label1.setBackground(new Color(0xFF6666));
        label1.setForeground(new Color(0xFF6666));
        label1.setBounds(300,150,500,46);
        label1.setFont(new Font("poppins",Font.BOLD,30));
        add(label1);

        String[] location = {"<---Select-->","Noida","Delhi","Gurugram","Ghaziabad"};
        comboBox = new JComboBox(location);
        comboBox.setBounds(420,255,150,40);
        comboBox.setBackground(new Color(240,250,252));
        comboBox.setFont(new Font("Poppins", Font.BOLD, 14));
        comboBox.addActionListener(this);
        add(comboBox);

        label2 = new JLabel("Select Location    : ");
        label2.setBounds(230, 250, 600, 40);
        label2.setFont(new Font("poppins",Font.BOLD,18));
        label2.setBackground(new Color(166,182,181));
        label2.setForeground(new Color(166,182,181));
        add(label2);

        label3 = new JLabel("Select Date            : ");
        label3.setBounds(230, 320, 600, 40);
        label3.setFont(new Font("poppins",Font.BOLD,18));
        label3.setBackground(new Color(166,182,181));
        label3.setForeground(new Color(166,182,181));
        add(label3);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(420, 322, 150, 40);
//        dateChooser.setFont(new Font("poppins",Font.BOLD,18));
        add(dateChooser);


//        String[] bloodtype = {"O+","O-","B+","B-","A+","A-","AB+","AB-"};
//        comboBox1 = new JComboBox(bloodtype);
//        comboBox1.setBounds(420,342,150,40);
//        comboBox1.setBackground(new Color(240,250,252));
//        comboBox1.setFont(new Font("Poppins", Font.BOLD, 14));
//        comboBox1.addActionListener(this);
//        add(comboBox1);

//        label3 = new JLabel("Select Blood type : ");
//        label3.setBounds(230, 340, 600, 40);
//        label3.setFont(new Font("poppins",Font.BOLD,18));
//        label3.setBackground(new Color(166,182,181));
//        label3.setForeground(new Color(166,182,181));
//        add(label3);

        button = new JButton("Add date");
        button.setFont(new Font("poppins", Font.BOLD, 18));
        button.setForeground(new Color(244,252,252));
        button.setBackground(new Color(0xFF6666));
        button.setBounds(200, 450, 150, 40);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Delete date");
        button1.setFont(new Font("poppins", Font.BOLD, 18));
        button1.setForeground(new Color(244,252,252));
        button1.setBackground(new Color(0xFF6666));
        button1.setBounds(420, 450, 150, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Dashboard");
        button2.setFont(new Font("poppins", Font.BOLD, 18));
        button2.setForeground(new Color(244,252,252));
        button2.setBackground(new Color(0xFF6666));
        button2.setBounds(320, 550, 150, 40);
        button2.addActionListener(this);
        add(button2);


        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image ii1 = ii.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon ii2 = new ImageIcon(ii1);
        JLabel ii3 = new JLabel(ii2);
        ii3.setBounds(620,45,150,150);
        add(ii3);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground1.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel  image2 = new JLabel(iii3);
        image2.setBounds(0,0 , 850, 800);
        add(image2);

        setSize(850, 800);
        setLayout(null);
        setUndecorated(true);
        setLocation(360, 10);
        setVisible(true);


    }

    public static void main(String[] args) {

        new drivelocation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String ct = (String) comboBox.getSelectedItem();
        String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        try{
            if(e.getSource()==button){

                if(ct.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select city");
                } else if (date.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please select date");

                }else{
                    con con3 = new con();
                    String q = "insert into drive values('" + ct + "', '" + date + "')";
                    con3.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Date added successfully"+date);
                    new Admin("");
                    setVisible(false);
                }


            } else if (e.getSource()==button1) {

                String loc1="";
                String date1="";

                if(ct.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select city");
                } else if (date.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please select date");

                }else{
                    String s = "select * from drive where loc='" + ct + "'&& datee = '" + date + "'";
                    con con2 = new con();
                    ResultSet rs = con2.statement.executeQuery(s);

                    while (rs.next()) {
                        loc1 = rs.getString("loc");
                        date1 = rs.getString("datee");
                    }
                    if(!loc1.equals(ct) && !date1.equals(date)){
                        JOptionPane.showMessageDialog(null,"Invalid drive location and date");
                    }else{
                        con con3 = new con();
                        String q = "DELETE FROM drive WHERE datee = '"+date+"' and loc = '"+ct+"'";
                        con3.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Deleted Drive date "+date);
                        new Admin("");
                        setVisible(false);

                    }
                }

            } else if (e.getSource() == button2) {
                new Admin("");
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
