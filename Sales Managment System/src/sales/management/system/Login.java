package sales.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2 , label3;
    JTextField textField1;
    JPasswordField passwordField;
    JButton button1,button2,button3, exit;

    JCheckBox testPassword;

    Login(){
        super("Sales Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/iconv3.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,140,100);
        add(image);

        label1 = new JLabel("LOGIN TO ACCOUNT: ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Login:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.white);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField1 = new JTextField(15);
        textField1.setBounds(325,190,230,30);
        textField1.setFont(new Font("Arial",Font.BOLD,14));
        add(textField1);

        label3 = new JLabel("Password:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.white);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325,250,230,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField);

        testPassword = new JCheckBox("View Password");
        testPassword.setBounds(567,257,115,15);
        testPassword.addActionListener(this);
        testPassword.setBackground(Color.black);
        testPassword.setForeground(Color.white);
        add(testPassword);

        button1 = new JButton("SIGN IN");
        button1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button1.setFont(new Font("Arial", Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.darkGray);
        button1.setBounds(300,300,100,35);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button2.setFont(new Font("Arial", Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.darkGray);
        button2.setBounds(430,300,100,35);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button3.setFont(new Font("Arial", Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.darkGray);
        button3.setBounds(300,350,230,35);
        button3.addActionListener(this);
        add(button3);

        exit = new JButton("EXIT");
        exit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exit.setFont(new Font("Arial", Font.BOLD,14));
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.darkGray);
        exit.setBounds(700,50,100,35);
        exit.addActionListener(this);
        add(exit);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0,0,850,480);
        add(iimage);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if(testPassword.isSelected()){
            passwordField.setEchoChar((char)0);
        }
        else{
            passwordField.setEchoChar('*');
        }

        try {
            if(e.getSource() == button1){
                connection c = new connection();
                String login = textField1.getText();
                String pass = passwordField.getText();
                String q = "select * from login where login = '"+login+"' and password = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    JOptionPane.showMessageDialog(null,"Login succesfully");
                    setVisible(false);
                    new AddProduct(login);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid login or password");
                }

            }else if(e.getSource() == button2){
                textField1.setText("");
                passwordField.setText("");

            }else if (e.getSource() == button3){
                new SignUp();
                setVisible(false);
            }
            else if(e.getSource() == exit){
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Login();
    }
}
