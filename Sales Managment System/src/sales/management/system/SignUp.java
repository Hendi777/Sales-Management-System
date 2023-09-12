package sales.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Random;
import java.security.SecureRandom;


public class SignUp extends JFrame implements ActionListener {

    JLabel signup ,name, surname;
        JTextField nameF, surnameF;

        JButton submit,delete,back,exit;
        SignUp(){


            super("Sales Management System");
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/iconv3.png"));
            Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350,10,140,100);
            add(image);

            signup = new JLabel("SIGN UP: ");
            signup.setForeground(Color.white);
            signup.setFont(new Font("AvantGarde",Font.BOLD,38));
            signup.setBounds(340,125,450,40);
            add(signup);

            name = new JLabel("Name:");
            name.setFont(new Font("Ralway",Font.BOLD,28));
            name.setForeground(Color.white);
            name.setBounds(150,190,375,30);
            add(name);

            nameF = new JTextField(15);
            nameF.setBounds(325,190,230,30);
            nameF.setFont(new Font("Arial",Font.BOLD,14));
            nameF.addActionListener(this);
            add(nameF);

            surname = new JLabel("Surname:");
            surname.setFont(new Font("Ralway",Font.BOLD,28));
            surname.setForeground(Color.white);
            surname.setBounds(150,250,375,30);
            add(surname);

            surnameF = new JTextField(15);
            surnameF.setBounds(325,250,230,30);
            surnameF.setFont(new Font("Arial",Font.BOLD,14));
            surnameF.addActionListener(this);
            add(surnameF);

            submit = new JButton("SUBMIT");
            submit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            submit.setFont(new Font("Arial", Font.BOLD,14));
            submit.setForeground(Color.WHITE);
            submit.setBackground(Color.darkGray);
            submit.setBounds(300,300,100,35);
            submit.addActionListener(this);
            add(submit);

            delete = new JButton("CLEAR");
            delete.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            delete.setFont(new Font("Arial", Font.BOLD,14));
            delete.setForeground(Color.WHITE);
            delete.setBackground(Color.darkGray);
            delete.setBounds(430,300,100,35);
            delete.addActionListener(this);
            add(delete);

            back = new JButton("LOGIN");
            back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            back.setFont(new Font("Arial", Font.BOLD,14));
            back.setForeground(Color.WHITE);
            back.setBackground(Color.darkGray);
            back.setBounds(50,50,100,35);
            back.addActionListener(this);
            add(back);

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

            getContentPane().setBackground(new Color(222,255,228));
            setLayout(null);
            setSize(850,480);
            setLocation(450,200);
            setUndecorated(true);
            setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

            String nameC = nameF.getText();
            String surnameC = surnameF.getText();
        Random ran = new Random();
        int lg = ((1 + ran.nextInt(2)) * 10000 + ran.nextInt(10000));
        String login = " " + Math.abs(lg);
        String pass = generate(8);


        try{
            connection c10 = new connection();
            String q10 = "select * from signup where name = '"+nameC+"' and surname = '"+surnameC+"'";
            ResultSet rs = c10.statement.executeQuery(q10);

            if(e.getSource() == submit){
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null , "This user already exist");
                }
                else if(nameC.equals("") || surnameC.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }
                else {
                    connection c1 = new connection();
                    String q1 = "insert into signup values('"+nameC+"', '"+surnameC+"' , '"+login+"' , '"+pass+"')";
                    String q2 = "insert into login values('"+login+"' , '"+pass+"')";

                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);


                    JOptionPane.showMessageDialog(null, "Login :" + login + "\n Password : " + pass);
                    new AddProduct(login);
                    setVisible(false);
                }
            }
            else if(e.getSource() == back){
                new Login();
                setVisible(false);
            }
            else if(e.getSource() == delete){
                nameF.setText("");
                surnameF.setText("");
            }
            else if(e.getSource() == exit){
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    private static final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }

        public static void main(String[] args){
            new SignUp();
        }

}
