package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deleteParticipant extends JFrame implements ActionListener {

    JLabel lable1,label2;
    JTextField textField,textField1;
    JButton button1,button2;

    deleteParticipant(){
        super("Delete Participant");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(180, 5, 100, 100);
        add(image);


        lable1 = new JLabel("Enter User Name:");
        lable1.setForeground(Color.darkGray);
        lable1.setFont(new Font("AvantGrade", Font.BOLD, 16));
        lable1.setBounds(50, 150, 450, 40);
        add(lable1);

        textField = new JTextField();
        textField.setForeground(Color.darkGray);
        textField.setBackground(new Color(206, 235, 241));
        textField.setBounds(200,155,170,30);
        textField.setFont(new Font("poppins",Font.PLAIN,14));
        add(textField);

        label2 = new JLabel("Enter Email id:");
        label2.setForeground(Color.darkGray);
        label2.setFont(new Font("AvantGrade", Font.BOLD, 16));
        label2.setBounds(50, 200, 450, 40);
        add(label2);

        textField1 = new JTextField();
        textField1.setForeground(Color.darkGray);
        textField1.setBackground(new Color(206, 235, 241));
        textField1.setBounds(200,205,170,30);
        textField1.setFont(new Font("poppins",Font.PLAIN,14));
        add(textField1);

        button1 = new JButton("Delete user");
        button1.setFont(new Font("poppins", Font.BOLD, 16));
        button1.setForeground(new Color(0x464646));
        button1.setBackground(new Color(153, 191, 211));
        button1.setBounds(250, 300, 120, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Dashboard");
        button2.setFont(new Font("poppins", Font.BOLD, 16));
        button2.setForeground(new Color(0x464646));
        button2.setBackground(new Color(153, 191, 211));
        button2.setBounds(70, 300, 120, 30);
        button2.addActionListener(this);
        add(button2);



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground3.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(500, 480, Image.SCALE_SMOOTH);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image2 = new JLabel(iii3);
        image2.setBounds(0, 0, 500, 480);
        add(image2);


        setLayout(null);
        setSize(500, 480);
        setLocation(470, 180);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new deleteParticipant();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username="";
        String mailid="";

        String s1 = textField.getText();
        String s2 = textField1.getText();

        try{

        String s = "select * from registration where name='" + s1 + "'&& mail = '" + s2 + "'";
        con con1 = new con();
        ResultSet rs = con1.statement.executeQuery(s);

        while (rs.next()) {
            username = rs.getString("name");
            mailid = rs.getString("mail");
        }

            if(e.getSource()==button1) {

                if(s1.equals("") || s2.equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill both boxes");

                }else if(s1.equals(username) && (s2.equals(mailid))){
                String q = "delete from registration where name = '"+s1+"' and mail = '"+s2+"'";
                con1.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Deleted successfully");
                new Admin("");
                setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null,"Incorrect Credintials");
            }

            } else if (e.getSource()==button2) {
                new Admin("");
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
