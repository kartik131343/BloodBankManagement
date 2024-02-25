package Bloodbank.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class updateParticipant extends JFrame implements ActionListener {

    JComboBox comboBox;
    JButton button;
    static JButton button1,button2;
    JRadioButton r1,r2, r3;
//    JDateChooser dateChooser;
static JTextField textName;
    static JTextField email;
    JTextField address;
    JTextField bloodtype;
    JTextField gender;
    JTextField date;
    Random ran = new Random();

    String loginType;


    updateParticipant(){

        super("Update User Details");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,5,120,120);
        add(image);

        JLabel lable1 = new JLabel("Update User Details" );
        lable1.setBounds(240, 60, 600, 40);
        lable1.setFont(new Font("Raleway",Font.BOLD,30));
        lable1.setForeground(Color.DARK_GRAY);
        add(lable1);

        JLabel lable2 = new JLabel("Full Name" );
        lable2.setBounds(100, 200, 600, 40);
        lable2.setFont(new Font("poppins",Font.BOLD,18));
        lable2.setForeground(Color.DARK_GRAY);
        add(lable2);


        JLabel lable3 = new JLabel("Email id" );
        lable3.setBounds(100, 260, 600, 40);
        lable3.setFont(new Font("poppins",Font.BOLD,18));
        lable3.setForeground(Color.DARK_GRAY);
        add(lable3);

        email = new JTextField();
        email.setFont(new Font("Poppins", Font.PLAIN, 14));
        email.setBounds(280, 262, 400, 30);
        add(email);

        JLabel lable4 = new JLabel("Date Of Birth" );
        lable4.setBounds(100, 320, 600, 40);
        lable4.setFont(new Font("poppins",Font.BOLD,18));
        lable4.setForeground(Color.DARK_GRAY);
        add(lable4);


        JLabel lable5 = new JLabel("Address" );
        lable5.setBounds(100, 380, 600, 40);
        lable5.setFont(new Font("poppins",Font.BOLD,18));
        lable5.setForeground(Color.DARK_GRAY);
        add(lable5);


        JLabel lable6 = new JLabel("Blood Type" );
        lable6.setBounds(100, 440, 600, 40);
        lable6.setFont(new Font("poppins",Font.BOLD,18));
        lable6.setForeground(Color.DARK_GRAY);
        add(lable6);


//        String[] bloodtype = {"O+","O-","B+","B-","A+","A-","AB+","AB-"};
//        comboBox = new JComboBox(bloodtype);
//        comboBox.setBounds(280,440,120,30);
//        comboBox.setFont(new Font("Poppins", Font.BOLD, 14));
//        comboBox.addActionListener(this);
//        add(comboBox);

//        bloodtype = new JTextField();
//        bloodtype.setBounds(280,440,120,30);
//        bloodtype.setFont(new Font("Poppins", Font.BOLD, 14));
//        bloodtype.addActionListener(this);
//        add(bloodtype);



        JLabel lable7 = new JLabel("Gender" );
        lable7.setBounds(100, 500, 600, 40);
        lable7.setFont(new Font("Poppins",Font.BOLD,18));
        lable7.setForeground(Color.DARK_GRAY);
        add(lable7);

//        gender = new JTextField();
//        gender.setBounds(280,500,120,30);
//        gender.setFont(new Font("Poppins", Font.BOLD, 14));
//        gender.addActionListener(this);
//        add(gender);




        button = new JButton("Update User");
        button.setFont(new Font("poppins", Font.BOLD, 15));
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.lightGray);
        button.setBounds(500, 650, 150, 30);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Load data");
        button1.setFont(new Font("poppins", Font.BOLD, 15));
        button1.setForeground(Color.DARK_GRAY);
        button1.setBackground(Color.lightGray);
        button1.setBounds(300, 650, 150, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Dashboard");
        button2.setFont(new Font("poppins", Font.BOLD, 15));
        button2.setForeground(Color.DARK_GRAY);
        button2.setBackground(Color.lightGray);
        button2.setBounds(100, 650, 150, 30);
        button2.addActionListener(this);
        add(button2);



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel  image2 = new JLabel(iii3);
        image2.setBounds(0,0 , 850, 800);
        add(image2);


//        getContentPane().setBackground(new Color(146,168,254));
        setSize(850, 800);
        setLayout(null);
        setUndecorated(true);
        setLocation(360, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String username="";
        String mailid="";
        String dob="";
        String address1="";
        String BloodType="";
        String gender1="";

        try{
            if (e.getSource()==button1) {

                String id = email.getText();


                String s = "select * from registration where mail = '" + id + "'";
                con con2 = new con();
                ResultSet rs = con2.statement.executeQuery(s);


                while (rs.next()) {
                    username = rs.getString("name");
                    mailid = rs.getString("mail");
                    dob = rs.getString("dob");
                    address1 = rs.getString("addr");
                    BloodType = rs.getString("bloodType");
                    gender1 = rs.getString("gender");
                }

                if(!mailid.equals(id)){
                    JOptionPane.showMessageDialog(null,"Invalid Email");
                }
                else{
                    textName = new JTextField(username);
                    textName.setFont(new Font("Poppins", Font.BOLD, 14));
                    textName.setBounds(280, 202, 400, 30);
                    add(textName);


                    date = new JTextField(dob);
                    date.setForeground(new Color(105, 105, 105));
                    date.setFont(new Font("Poppins", Font.BOLD, 14));
                    date.setBounds(280, 322, 400, 30);
                    add(date);

                    address = new JTextField(address1);
                    address.setFont(new Font("Poppins", Font.BOLD, 14));
                    address.setBounds(280, 382, 400, 30);
                    add(address);

                    bloodtype = new JTextField(BloodType);
                    bloodtype.setBounds(280,440,120,30);
                    bloodtype.setFont(new Font("Poppins", Font.BOLD, 14));
                    bloodtype.addActionListener(this);
                    add(bloodtype);

                    gender = new JTextField(gender1);
                    gender.setBounds(280,500,120,30);
                    gender.setFont(new Font("Poppins", Font.BOLD, 14));
                    gender.addActionListener(this);
                    add(gender);
                }




            }else if (e.getSource() == button) {

                String username1 = textName.getText();
                String mail1 = email.getText();
                String date1 = date.getText();
                String address2 = address.getText();
                String bloodtype1 = bloodtype.getText();
                String gender2 = gender.getText();


                if(username1.equals("") || mail1.equals("") || date1.equals("") || address2.equals("") || bloodtype1.equals("") || gender2.equals("") ){
                    JOptionPane.showMessageDialog(null,"Please Dont Leave Blank boxes");

                }else{
                    con con1 = new con();
                    String q = "update registration set name = '"+username1+"', dob = '"+date1+"', addr = '"+address2+"', bloodType = '"+bloodtype1+"', gender = '"+gender2+"' where mail = '"+ mail1 +"'";
                    con1.statement.executeUpdate(q);
                    new Admin("");
                    setVisible(false);
                }
            } else if (e.getSource() == button2) {
                new Admin("");
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new updateParticipant();

    }

}
