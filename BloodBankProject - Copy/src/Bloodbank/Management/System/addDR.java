package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDR extends JFrame implements ActionListener {
    JLabel lable1;
    JButton button1, button2;
    addDR(){
        super("Add Donor/Receiver");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(180, 5, 100, 100);
        add(image);


        lable1 = new JLabel("Select user as:");
        lable1.setForeground(Color.darkGray);
        lable1.setFont(new Font("AvantGrade", Font.BOLD, 22));
        lable1.setBounds(150, 100, 450, 40);
        add(lable1);

        button1 = new JButton("Donor");
        button1.setFont(new Font("poppins", Font.BOLD, 20));
        button1.setForeground(new Color(0x464646));
        button1.setBackground(new Color(153,211,201));
        button1.setBounds(80, 220, 120, 60);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Reciever");
        button2.setFont(new Font("poppins", Font.BOLD, 20));
        button2.setForeground(new Color(0x464646));
        button2.setBackground(new Color(153,211,201));
        button2.setBounds(270, 220, 120, 60);
        button2.addActionListener(this);
        add(button2);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground2.jpg"));
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
        new addDR();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            if(e.getSource()==button1){
                new addDonor();
                setVisible(false);

            }else if(e.getSource()==button2){
                new addReceiver();
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
}
