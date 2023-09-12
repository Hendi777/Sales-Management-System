package sales.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddProduct extends JFrame implements ActionListener {

    JLabel addp, ProductName , Quantity, Price, Company, id;
    JTextField ProductNameF, QuantityF, PriceF, CompanyF;

    JButton add,exit,show,delete,back;

    String login;
    AddProduct(String login){
        super("Sales Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/iconv3.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,140,100);
        add(image);

        addp = new JLabel("ADD PRODUCT: ");
        addp.setForeground(Color.white);
        addp.setFont(new Font("AvantGarde",Font.BOLD,38));
        addp.setBounds(270,120,450,40);
        add(addp);

        ProductName = new JLabel("Product: ");
        ProductName.setFont(new Font("Ralway",Font.BOLD,28));
        ProductName.setForeground(Color.white);
        ProductName.setBounds(200,180,375,30);
        add(ProductName);

        ProductNameF = new JTextField(15);
        ProductNameF.setBounds(330,184,230,30);
        ProductNameF.setFont(new Font("Arial",Font.BOLD,14));
        add(ProductNameF);

        Quantity = new JLabel("Quantity(kg): ");
        Quantity.setFont(new Font("Ralway",Font.BOLD,28));
        Quantity.setForeground(Color.white);
        Quantity.setBounds(200,230,375,30);
        add(Quantity);

        QuantityF = new JTextField(15);
        QuantityF.setBounds(385,233,230,30);
        QuantityF.setFont(new Font("Arial",Font.BOLD,14));
        add(QuantityF);

        Price = new JLabel("Price(zł): ");
        Price.setFont(new Font("Ralway",Font.BOLD,28));
        Price.setForeground(Color.white);
        Price.setBounds(200,280,375,30);
        add(Price);

        PriceF = new JTextField(15);
        PriceF.setBounds(330,283,230,30);
        PriceF.setFont(new Font("Arial",Font.BOLD,14));
        add(PriceF);

        Company = new JLabel("Buying Company: ");
        Company.setFont(new Font("Ralway",Font.BOLD,28));
        Company.setForeground(Color.white);
        Company.setBounds(200,330,375,30);
        add(Company);

        CompanyF = new JTextField(15);
        CompanyF.setBounds(453,333,230,30);
        CompanyF.setFont(new Font("Arial",Font.BOLD,14));
        add(CompanyF);

        id = new JLabel("User: " + login);
        id.setFont(new Font("Ralway",Font.BOLD,15));
        id.setForeground(Color.white);
        id.setBounds(750,450,375,15);
        add(id);

        add = new JButton("ADD");
        add.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        add.setFont(new Font("Arial", Font.BOLD,14));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.darkGray);
        add.setBounds(320,380,100,35);
        add.addActionListener(this);
        add(add);

        delete = new JButton("CLEAR");
        delete.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        delete.setFont(new Font("Arial", Font.BOLD,14));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.darkGray);
        delete.setBounds(430,380,100,35);
        delete.addActionListener(this);
        add(delete);


        exit = new JButton("EXIT");
        exit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exit.setFont(new Font("Arial", Font.BOLD,14));
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.darkGray);
        exit.setBounds(700,50,100,35);
        exit.addActionListener(this);
        add(exit);

        show = new JButton("PRODUCTS");
        show.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        show.setFont(new Font("Arial", Font.BOLD,14));
        show.setForeground(Color.WHITE);
        show.setBackground(Color.darkGray);
        show.setBounds(50,50,100,35);
        show.addActionListener(this);
        add(show);

        back = new JButton("LOGOUT");
        back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        back.setFont(new Font("Arial", Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.darkGray);
        back.setBounds(700,100,100,35);
        back.addActionListener(this);
        add(back);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0,0,850,480);
        add(iimage);

        setLayout(null);
        this.login = login;
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String ProductC = ProductNameF.getText();
        String QuantityC = QuantityF.getText();
        String PriceC = PriceF.getText();
        String CompanyC = CompanyF.getText();
        Date date = new Date();
        try {
            if (e.getSource() == add) {
                if (ProductC.equals("") || CompanyC.equals("") || QuantityC.equals("") || PriceC.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                } else {
                    connection c = new connection();
                    String q3 = "insert into addproduct values('" + login + "','" + ProductC + "' , '" + QuantityC + "' , '" + PriceC + "' , '" + CompanyC + "','" + date + "')";
                    c.statement.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null,"Product Added");
                }
            }
            else if(e.getSource() == exit){
                System.exit(0);
            }
            else if(e.getSource() == show){
                new ShowProducts(login);
                setVisible(false);
            }
            else if(e.getSource() == delete){
                ProductNameF.setText("");
                QuantityF.setText("");
                PriceF.setText("");
                CompanyF.setText("");
            }
            else if(e.getSource() == back){
                new Login();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new AddProduct("");
    }
}
