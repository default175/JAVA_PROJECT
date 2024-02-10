package org.example;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user = new JLabel("Name");
        user.setBounds(40,20,100,30);
        add(user);
        JTextField username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        JTextField password2 = new JTextField();
        password2.setBounds(150,70,150,30);
        add(password2);
        JButton login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        setBounds(500, 200,600,300);
        setVisible(true);

    }
    public static void main(String[] args){
        new Login();
    }
}
