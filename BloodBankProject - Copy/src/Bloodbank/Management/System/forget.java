package Bloodbank.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class forget extends JFrame implements ActionListener {
    JLabel lable1,lable2, lable3, lable4;
    JPasswordField passwordField2,passwordField1;
    JTextField textField1;
    JButton button1,button2;
    forget(){
        super("Reset Password");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,120,120);
        add(image);

        lable1 = new JLabel("Reset Password");
        lable1.setForeground(Color.darkGray);
        lable1.setFont(new Font("AvantGrade", Font.BOLD,22));
        lable1.setBounds(320, 130, 450, 40);
        add(lable1);

        lable2 = new JLabel("Email id :");
        lable2.setFont(new Font("poppins", Font.BOLD, 18));
        lable2.setForeground(Color.gray);
        lable2.setBounds(200, 200, 375, 30);
        add(lable2);

        textField1 = new JTextField(15);
        textField1.setBounds(500,200,260,30);
        textField1.setFont(new Font("poppins",Font.PLAIN,14));
        add(textField1);

        lable3 = new JLabel(("Password :"));
        lable3.setForeground(Color.gray);
        lable3.setFont(new Font("poppins", Font.BOLD, 18));
        lable3.setBounds(200, 250, 375, 30);
        add(lable3);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(500,250,260,30);
        passwordField1.setFont(new Font("poppins",Font.PLAIN,15));
        add(passwordField1);

        lable4 = new JLabel(("Confirm Password :"));
        lable4.setForeground(Color.gray);
        lable4.setFont(new Font("poppins", Font.BOLD, 18));
        lable4.setBounds(200, 300, 375, 30);
        add(lable4);

        passwordField2 = new JPasswordField(15);
        passwordField2.setBounds(500,300,260,30);
        passwordField2.setFont(new Font("poppins",Font.PLAIN,15));
        add(passwordField2);

        button1 = new JButton("Submit");
        button1.setFont(new Font("poppins", Font.BOLD, 12));
        button1.setForeground(Color.DARK_GRAY);
        button1.setBackground(Color.lightGray);
        button1.setBounds(500, 350, 80, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Back -->");
        button2.setFont(new Font("poppins", Font.BOLD, 12));
        button2.setForeground(Color.DARK_GRAY);
        button2.setBackground(Color.lightGray);
        button2.setBounds(650, 350, 100, 30);
        button2.addActionListener(this);
        add(button2);

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
        new forget();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String email ="";
        String mail = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        String confirmpass = String.valueOf(passwordField2.getPassword());
        String valpass="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$";
        Pattern p1 = Pattern.compile(valpass);
        Matcher m1 = p1.matcher(password);
        Matcher m2 = p1.matcher(confirmpass);
        try {
            if (e.getSource() == button1) {
                String s = "select * from registration where mail='"+ mail +"'";
                con con2 = new con();
                ResultSet rs =con2.statement.executeQuery(s);
                while(rs.next())
                {
                    email=rs.getString("mail");
                }
                if(mail.equals(email)) {
                    if (password.equals("") || confirmpass.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please fill both password!");

                    }
                    else if(m1.matches()==true && m2.matches()==true)
                    {
                        if (password.equals(confirmpass))
                        {
                            JOptionPane.showMessageDialog(null, "Password changed Successfully!");
                            con con3 = new con();
                            String q = "update registration set passw = '" + confirmpass + "' where mail = '" + mail + "'";
                            con3.statement.executeUpdate(q);
                            new Login("");
                            setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please fill same password in both fields!");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect password format!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Email Incorrect!");
                }
            } else if (e.getSource() == button2) {
                new Login("");
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
 