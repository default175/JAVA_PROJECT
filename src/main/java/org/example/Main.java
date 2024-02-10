package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame implements ActionListener{

    Main() {
        setSize(1366, 700);
        setLocation(100, 100);
        ImageIcon i1 = new ImageIcon("C:\\\\items\\\\Hilton2.jpg");
        Image i2 = i1.getImage().getScaledInstance(1366, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        JLabel text = new JLabel("Hilton Managment System");
        text.setBounds(20,550,900,90);
        text.setForeground(Color.cyan);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        JButton button = new JButton("Next");
        button.setBounds(1150,565,150,50);
        button.addActionListener(this);
        image.add(button);

        setVisible(true);

        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }



    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) {
        new Main();

    }
}