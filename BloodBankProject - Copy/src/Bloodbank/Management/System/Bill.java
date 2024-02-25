package Bloodbank.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import org.faceless.pdf2.*;

import javax.swing.*;


public class Bill extends JFrame implements ActionListener {

    JButton button;
    JLabel label1;

    public Bill() throws IOException {

        super("PDF");

        PDF pdf = new PDF();

        PDFPage page = pdf.newPage("A4");

        PDFStyle mystyle = new PDFStyle();
        mystyle.setFont(new StandardFont(StandardFont.HELVETICABOLD), 16);
        mystyle.setFillColor(Color.black);


        page.setStyle(mystyle);
        page.drawText("                          Bill \n\n\n\nDate               :          " + OrderBill.d + "\n\nName             :          " + OrderBill.name + "\n\nBloodType     :          " + OrderBill.bloodType +
                "\n\nLocation        :          " + OrderBill.location + "\n\nAddress         :          " + OrderBill.Add + "\n\nTotal Amount :          " + OrderBill.c + "", 100, page.getHeight() - 100);

        OutputStream out = new FileOutputStream("C:\\Users\\kk131\\Downloads\\OrderBill.pdf");
        pdf.render(out);
        out.close();

        label1 = new JLabel("PDF created Successfully");
        label1.setBackground(new Color(184, 212, 207));
        label1.setBounds(150, 100, 300, 40);
        label1.setFont(new Font("poppins", Font.BOLD, 16));
        add(label1);


        button = new JButton("Feedback");
        button.setBackground(new Color(184, 212, 207));
        button.setBounds(180, 250, 150, 40);
        button.setFont(new Font("poppins", Font.BOLD, 16));
        button.addActionListener((ActionListener) this);
        add(button);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("img/baground1.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image2 = new JLabel(iii3);
        image2.setBounds(0, 0, 500, 480);
        add(image2);

        setSize(500, 480);
        setLocation(470, 180);
        setVisible(true);

    }


    public static void main(String[] args) throws IOException {


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new feedback();
            setVisible(false);
        }
    }
}

