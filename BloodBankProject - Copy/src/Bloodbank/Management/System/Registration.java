package Bloodbank.Management.System;


import Bloodbank.Management.System.con;
import Bloodbank.Management.System.startpage;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Registration extends JFrame implements ActionListener {
    static JComboBox comboBox;
    JButton button,button1;
    JRadioButton r1,r2, r3;
    JDateChooser dateChooser;
    JTextField textName, email, address, password;
    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L) +1000L;
    String first = " " + Math.abs(first4);
    String loginType;
    Registration(String loginType){
        super("Registration Page");

        this.loginType = startpage.loginType;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,5,120,120);
        add(image);
        JLabel lable1 = new JLabel("REGISTRATION PAGE" );
        lable1.setBounds(260, 60, 600, 40);
        lable1.setFont(new Font("Raleway",Font.BOLD,30));
        lable1.setForeground(Color.DARK_GRAY);
        add(lable1);
        JLabel lable2 = new JLabel("Full Name" );
        lable2.setBounds(100, 200, 600, 40);
        lable2.setFont(new Font("poppins",Font.BOLD,18));
        lable2.setForeground(Color.DARK_GRAY);
        add(lable2);
        textName = new JTextField();
        textName.setFont(new Font("Poppins", Font.PLAIN, 14));
        textName.setBounds(280, 202, 400, 30);
        add(textName);
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
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(280, 322, 400, 30);
//        dateChooser.setFont(new Font("poppins",Font.BOLD,18));
        add(dateChooser);

        JLabel lable5 = new JLabel("Address" );
        lable5.setBounds(100, 380, 600, 40);
        lable5.setFont(new Font("poppins",Font.BOLD,18));
        lable5.setForeground(Color.DARK_GRAY);
        add(lable5);
        address = new JTextField();
        address.setFont(new Font("Poppins", Font.PLAIN, 14));
        address.setBounds(280, 382, 400, 30);
        add(address);
        JLabel lable6 = new JLabel("Blood Type" );
        lable6.setBounds(100, 440, 600, 40);
        lable6.setFont(new Font("poppins",Font.BOLD,18));
        lable6.setForeground(Color.DARK_GRAY);
        add(lable6);

        String[] bloodtype = {"O+","O-","B+","B-","A+","A-","AB+","AB-"};
        comboBox = new JComboBox(bloodtype);
        comboBox.setBounds(280,440,120,30);
        comboBox.setFont(new Font("Poppins", Font.BOLD, 14));
//        comboBox.addActionListener(this);
        add(comboBox);


        JLabel lable7 = new JLabel("Gender" );
        lable7.setBounds(100, 500, 600, 40);
        lable7.setFont(new Font("Poppins",Font.BOLD,18));
        lable7.setForeground(Color.DARK_GRAY);
        add(lable7);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Poppins", Font.BOLD, 14));
        r1.setBounds(280, 500, 100, 30);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Poppins", Font.BOLD, 14));
        r2.setBounds(380, 500, 100, 30);
        add(r2);
        r3 = new JRadioButton("Others");
        r3.setFont(new Font("Poppins", Font.BOLD, 14));
        r3.setBounds(500, 500, 100, 30);
        add(r3);
        ButtonGroup buttonGroup1= new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup1.add(r3);

        JLabel lable8 = new JLabel("Create Password" );
        lable8.setBounds(100, 560, 600, 40);
        lable8.setFont(new Font("Poppins",Font.BOLD,18));
        lable8.setForeground(Color.DARK_GRAY);
        add(lable8);
        password = new JTextField();
        password.setFont(new Font("Poppins", Font.PLAIN, 14));
        password.setBounds(280, 562, 400, 30);
        add(password);

        button = new JButton("Submit");
        button.setFont(new Font("poppins", Font.BOLD, 15));
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.lightGray);
        button.setBounds(380, 650, 100, 30);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("<-- Back");
        button1.setFont(new Font("poppins", Font.BOLD, 15));
        button1.setForeground(Color.DARK_GRAY);
        button1.setBackground(Color.lightGray);
        button1.setBounds(200, 650, 100, 30);
        button1.addActionListener(this);
        add(button1);

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

    public static void main(String[] args) {
        new Registration("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String mail = email.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String addr = address.getText();
        String bloodType = (String) comboBox.getSelectedItem();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }else if(r3.isSelected()){
            gender = "Other";
        }
        String passw = password.getText();

        try{
            if(e.getSource()==button){
                if(textName.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else if (password.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else if (email.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else if (address.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else  {
                    String vmail="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z])*(\\.[A-Za-z]{2,})$";
                    Pattern p1=Pattern.compile(vmail);
                    Matcher m1=p1.matcher(mail);
                    String valname="^[a-zA-Z]+([\\s'-][a-zA-Z]+)*$";
                    Pattern p2=Pattern.compile(valname);
                    Matcher m2=p2.matcher(name);
                    String valpass="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$";
                    Pattern p3=Pattern.compile(valpass);
                    Matcher m3=p3.matcher(passw);
                    if(m1.matches()==true && m2.matches()==true && m3.matches()==true) {
                        con con1 = new con();
                        String q = "insert into registration values('" + name + "', '" + mail + "', '" + dob + "', '" + addr + "', '" + bloodType + "', '" + gender + "', '" + passw + "','" + loginType + "' )";
                        con1.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Registration Successful. Please Login!");
                        new startpage();
                        setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Incorrect format for Name/Email/Password");
                    }
                }
            } else if (e.getSource()==button1) {
                new Login("");
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
 