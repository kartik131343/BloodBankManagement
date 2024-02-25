package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Appointment extends JFrame implements ActionListener {

    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
    JButton button1,button2,button3;

    static String date,name,location,location1,bloodType;


    Appointment(){
        super("Appointment Slip");



        label1 = new JLabel("Appointment Slip");
        label1.setForeground(new Color(0x07A983));
        label1.setBounds(190,30,500,30);
        label1.setFont(new Font("poppins",Font.BOLD,25));
        add(label1);

        label2 = new JLabel("Appointment Date  : ");
        label2.setForeground(new Color(0x07A983));
        label2.setBounds(110,260,500,30);
        label2.setFont(new Font("poppins",Font.BOLD,18));
        add(label2);

        date = ((JTextField) locatedrive.dateChooser.getDateEditor().getUiComponent()).getText();

        label9 = new JLabel(date);
        label9.setBounds(330,260,500,30);
        label9.setFont(new Font("poppins",Font.BOLD,18));
        label9.setBackground(new Color(224,238,236));
        add(label9);


        label3 = new JLabel("Name                         : ");
        label3.setForeground(new Color(0x07A983));
        label3.setBounds(110,100,500,30);
        label3.setFont(new Font("poppins",Font.BOLD,18));
        add(label3);

        String mail = Login.textField1.getText();
        String q = "select name,addr from registration where mail='"+mail+"'";
        con con1 = new con();
        name = "";
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
        location = (String) locatedrive.comboBox.getSelectedItem();
        location1=null;

        if(location.equals("Noida")){
            location1 = "<html>We Work – Co Working<br/> Sector-16B, Noida, U.P</html>";

        } else if (location.equals("Delhi")) {
            location1 = "<html>Yuwa Shakti,</br> Manch Karampura, Delhi</html>";

        } else if (location.equals("Gurugram")) {
            location1 = "<html>Sector 10 A,</br> Khandsa Road, Gurgaon</html>";

        }else if(location.equals("Ghaziabad")){
            location1 = "<html>Judges Enclave, Ahinsa</br> Khand 2, Indirapuram, Ghaziabad</html?";
        }

//        name = Login.textField1.getText();
        label7 = new JLabel(name);
        label7.setBounds(330,100,500,30);
        label7.setFont(new Font("poppins",Font.BOLD,18));
        label7.setBackground(new Color(224,238,236));
        add(label7);

        label4 = new JLabel("Blood Type              : ");
        label4.setForeground(new Color(0x07A983));
        label4.setBounds(110,180,500,30);
        label4.setFont(new Font("poppins",Font.BOLD,18));
        add(label4);

        bloodType = (String) locatedrive.comboBox1.getSelectedItem();
        label11 = new JLabel(bloodType);
        label11.setBounds(330,180,500,30);
        label11.setFont(new Font("poppins",Font.BOLD,18));
        label11.setBackground(new Color(224,238,236));
        add(label11);




        label5 = new JLabel("Location                   : ");
        label5.setForeground(new Color(0x07A983));
        label5.setBounds(110,340,500,30);
        label5.setFont(new Font("poppins",Font.BOLD,18));
        add(label5);


        label10 = new JLabel(location);
        label10.setBounds(330,340,500,30);
        label10.setFont(new Font("poppins",Font.BOLD,18));
        label10.setBackground(new Color(224,238,236));
        add(label10);

        label6 = new JLabel("Address                    : ");
        label6.setForeground(new Color(0x07A983));
        label6.setBounds(110,420,500,30);
        label6.setFont(new Font("poppins",Font.BOLD,18));
        add(label6);

        label8 = new JLabel(location1);
        label8.setBounds(330,420,500,60);
        label8.setFont(new Font("poppins",Font.BOLD,16));
        label8.setBackground(new Color(224,238,236));
        add(label8);


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
        new Appointment();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if(e.getSource()==button1){
                new dashboard();
                setVisible(false);
            }
            else if(e.getSource()==button2)
            {
                new feedback();
                setVisible(false);

            } else if (e.getSource()==button3) {
                new AppointmentSlip();
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
