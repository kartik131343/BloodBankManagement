package Bloodbank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkAvailability extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox1,comboBox2;

    JButton button,button1;

    JLabel label1,label2,label3,label4;


    checkAvailability(){
        super("Check Availability");

        label1 = new JLabel("Check Availability");
        label1.setBackground(new Color(0xFF6666));
        label1.setForeground(new Color(0xFF6666));
        label1.setBounds(320,100,500,46);
        label1.setFont(new Font("poppins",Font.BOLD,30));
        add(label1);

        String[] location = {"<---Select-->","Noida","Delhi","Gurugram","Ghaziabad"};
        comboBox = new JComboBox(location);
        comboBox.setBounds(420,205,150,40);
        comboBox.setBackground(new Color(240,250,252));
        comboBox.setFont(new Font("Poppins", Font.BOLD, 14));
        comboBox.addActionListener(this);
        add(comboBox);

        label2 = new JLabel("Select Location    : ");
        label2.setBounds(230, 200, 600, 40);
        label2.setFont(new Font("poppins",Font.BOLD,18));
        label2.setBackground(new Color(166,182,181));
        label2.setForeground(new Color(166,182,181));
        add(label2);


        String[] bloodtype = {"O+","O-","B+","B-","A+","A-","AB+","AB-"};
        comboBox1 = new JComboBox(bloodtype);
        comboBox1.setBounds(420,275,150,40);
        comboBox1.setBackground(new Color(240,250,252));
        comboBox1.setFont(new Font("Poppins", Font.BOLD, 14));
        comboBox1.addActionListener(this);
        add(comboBox1);

        label3 = new JLabel("Select Blood type : ");
        label3.setBounds(230, 270, 600, 40);
        label3.setFont(new Font("poppins",Font.BOLD,18));
        label3.setBackground(new Color(166,182,181));
        label3.setForeground(new Color(166,182,181));
        add(label3);




        button = new JButton("Submit");
        button.setFont(new Font("poppins", Font.BOLD, 18));
        button.setForeground(new Color(244,252,252));
        button.setBackground(new Color(0xFF6666));
        button.setBounds(450,400, 120, 40);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Dashboard");
        button1.setFont(new Font("poppins", Font.BOLD, 18));
        button1.setForeground(new Color(244,252,252));
        button1.setBackground(new Color(0xFF6666));
        button1.setBounds(200,400, 150, 40);
        button1.addActionListener(this);
        add(button1);



        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("img/logo1.png"));
        Image ii1 = ii.getImage().getScaledInstance(170,170, Image.SCALE_SMOOTH);
        ImageIcon ii2 = new ImageIcon(ii1);
        JLabel ii3 = new JLabel(ii2);
        ii3.setBounds(620,45,170,170);
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
        new checkAvailability();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = (String) comboBox.getSelectedItem();
        String s2 = (String) comboBox1.getSelectedItem();




        int b=0;



        String s = "select noOfPackets from availability where loc='"+s1+"' && btype ='"+s2+"'";

        con con = new con();
        try {
            ResultSet rs =  con.statement.executeQuery(s);

            while(rs.next())
            {
                b=rs.getInt("noOfPackets");
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }



        if(e.getSource()==button)
        {
            if(s1.equals("<---Select-->") || s2.equals("<---Select-->"))
            {
                JOptionPane.showMessageDialog(null,"Please fill all fields!");
            }

            else {
                JOptionPane.showMessageDialog(null,"No. of Packets Available : "+b);
                new dashboard();
                setVisible(false);
            }
        } else if (e.getSource() == button1) {
            new dashboard();
            setVisible(false);
        }


    }
}
