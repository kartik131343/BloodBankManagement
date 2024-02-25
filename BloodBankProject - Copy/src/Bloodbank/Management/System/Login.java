package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {

    JLabel lable1, lable2, lable3;

    static JTextField textField1;
    JPasswordField passwordField1;
    JButton button1, button2, button3, button4;
    String loginType;
    Login(String loginType){

        super("BLOOD BANK MANAGEMENT SYSTEM");

        this.loginType = loginType;




        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,120,120);
        add(image);


        lable1 = new JLabel("BLOOD-BANK MANAGEMENT SYSTEM");
        lable1.setForeground(Color.darkGray);
        lable1.setFont(new Font("AvantGrade", Font.BOLD,22));
        lable1.setBounds(220, 125, 450, 40);
        add(lable1);

        lable2 = new JLabel("Email id :");
        lable2.setFont(new Font("poppins", Font.BOLD, 18));
        lable2.setForeground(Color.gray);
        lable2.setBounds(100, 220, 375, 30);
        add(lable2);

        textField1 = new JTextField(15);
        textField1.setBounds(200,220,260,30);
        textField1.setFont(new Font("poppins",Font.PLAIN,14));
        add(textField1);

        lable3 = new JLabel(("Password :"));
        lable3.setForeground(Color.gray);
        lable3.setFont(new Font("poppins", Font.BOLD, 18));
        lable3.setBounds(100, 260, 375, 30);
        add(lable3);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(200,260,260,30);
        passwordField1.setFont(new Font("poppins",Font.PLAIN,15));
        add(passwordField1);


        button1 = new JButton("Log In");
        button1.setFont(new Font("poppins", Font.BOLD, 12));
        button1.setForeground(Color.DARK_GRAY);
        button1.setBackground(Color.lightGray);
        button1.setBounds(200, 320, 80, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Forget Password");
        button2.setFont(new Font("poppins", Font.BOLD, 12));
        button2.setForeground(Color.DARK_GRAY);
        button2.setBackground(Color.lightGray);
        button2.setBounds(300, 320, 150, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Register User");
        button3.setFont(new Font("poppins", Font.BOLD, 12));
        button3.setForeground(Color.DARK_GRAY);
        button3.setBackground(Color.lightGray);
        button3.setBounds(200, 370, 250, 30);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("<--  Back");
        button4.setFont(new Font("poppins", Font.BOLD, 12));
        button4.setForeground(Color.DARK_GRAY);
        button4.setBackground(Color.lightGray);
        button4.setBounds(20, 30, 100, 30);
        button4.addActionListener(this);
        add(button4);






        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("img/bgvector.png"));
        Image ii2 = ii1.getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel  image1 = new JLabel(ii3);
        image1.setBounds(500,180 , 300, 250);
        add(image1);



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel  image2 = new JLabel(iii3);
        image2.setBounds(0,0 , 850, 480);
        add(image2);



        setLayout(null);
        setSize(850, 480);
        setUndecorated(true);
        setLocation(420, 180);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Login("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String username="";
        String password="";
        String loginType1 = "";

        try {
            if (e.getSource()==button1){

               String id = textField1.getText();
               String pin = String.valueOf(passwordField1.getPassword());

                String q1 = "select loginType from registration where mail = '"+id+"' and passw = '"+pin+"'";
                con con3 = new con();
                ResultSet rs2 = con3.statement.executeQuery(q1);
                while (rs2.next()){
                    loginType1 = rs2.getString("loginType");
                }

                if (id.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                }

                else {

                    String s = "select * from registration where mail='" + id + "'&& passw = '" + pin + "'";
                    con con2 = new con();
                    ResultSet rs = con2.statement.executeQuery(s);

                    while (rs.next()) {
                        username = rs.getString("mail");
                        password = rs.getString("passw");
                    }


                    if(id.equals(username) && pin.equals(password) && loginType1.equals(loginType) && loginType.equals("admin"))
                    {
                        JOptionPane.showMessageDialog(null,"Login Successful");
//                        con con1 = new con();
//                        String q = "update registration set loginType = '" + loginType + "' where mail = '" + username + "' && passw = '"+password+"'";
//                        con1.statement.executeUpdate(q);
                        new Admin("");
                        setVisible(false);

                    }else if(id.equals(username) && pin.equals(password) && loginType1.equals(loginType)) {
                        JOptionPane.showMessageDialog(null,"Login Successful");
//                        con con1 = new con();
//                        String q = "update registration set loginType = '" + loginType1 + "' where mail = '" + username + "' && passw = '"+password+"'";
//                        con1.statement.executeUpdate(q);
                        new dashboard();
                        setVisible(false);

                    }else if(id.equals(username) && pin.equals(password) && loginType1.equals(loginType))
                    {
                        JOptionPane.showMessageDialog(null,"Login Successful");
//                        con con1 = new con();
//                        String q = "update registration set loginType = '" + loginType1 + "' where mail = '" + username + "' && passw = '"+password+"'";
//                        con1.statement.executeUpdate(q);
                        new dashboard();
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect Credentials");
                    }
                }




            }else if (e.getSource()==button2){
                textField1.setText("");
                passwordField1.setText("");
                new forget();
                setVisible(false);

            } else if (e.getSource()==button3) {
                if (startpage.loginType.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Cannot register as Admin");
                } else {
                    textField1.setText("");
                    passwordField1.setText("");
                    new Registration(loginType1);
                    setVisible(false);
                }

            }else if (e.getSource()==button4){

                new startpage();
                setVisible(false);

            }else{
                new Login("");
                setVisible(false);
            }



        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
