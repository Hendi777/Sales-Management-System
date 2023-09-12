package sales.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ShowProducts extends JFrame implements ActionListener {

    JLabel id;

    JTable show;

    JButton showproducts,exit,add,back,delete;
    
    String login;

//    JScrollPane pane;

    public ShowProducts(String login){
        super("Sales Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/iconv3.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,140,100);
        add(image);

        showproducts = new JButton("SHOW");
        showproducts.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        showproducts.setFont(new Font("Arial", Font.BOLD,14));
        showproducts.setForeground(Color.WHITE);
        showproducts.setBackground(Color.darkGray);
        showproducts.setBounds(50,50,100,35);
        showproducts.addActionListener(this);
        add(showproducts);

        add = new JButton("ADD");
        add.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        add.setFont(new Font("Arial", Font.BOLD,14));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.darkGray);
        add.setBounds(50,100,100,35);
        add.addActionListener(this);
        add(add);


        show = new JTable();
        show.setBounds(170,155,650,270);
        show.setBackground(Color.white);
        show.setForeground(Color.black);
        show.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        add(show);

        exit = new JButton("EXIT");
        exit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exit.setFont(new Font("Arial", Font.BOLD,14));
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.darkGray);
        exit.setBounds(700,50,100,35);
        exit.addActionListener(this);
        add(exit);

        back = new JButton("LOGOUT");
        back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        back.setFont(new Font("Arial", Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.darkGray);
        back.setBounds(700,100,100,35);
        back.addActionListener(this);
        add(back);

//        delete = new JButton("DELETE");
//        delete.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
//        delete.setFont(new Font("Arial", Font.BOLD,14));
//        delete.setForeground(Color.WHITE);
//        delete.setBackground(Color.darkGray);
//        delete.setBounds(50,200,100,35);
//        delete.addActionListener(this);
//        add(delete);

        id = new JLabel("User: " + login);
        id.setFont(new Font("Ralway",Font.BOLD,15));
        id.setForeground(Color.white);
        id.setBounds(750,450,375,15);
        add(id);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0,0,850,480);
        add(iimage);
        
        this.login = login;
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            connection con5 = new connection();
            String query = "select * from addproduct";
            ResultSet rs = con5.statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) show.getModel();

//            int cols = rsmd.getColumnCount();
//            String[] colName = new String[cols];
//            for(int i = 0; i < cols; i++)
//                colName[i] = rsmd.getColumnName(i+1);
//            model.setColumnIdentifiers(colName);

            model.addColumn("login");
            model.addColumn("product");
            model.addColumn("quantity");
            model.addColumn("price");
            model.addColumn("company");
            model.addColumn("date");

            show.getColumnModel().getColumn(0).setPreferredWidth(30);
            show.getColumnModel().getColumn(1).setPreferredWidth(30);
            show.getColumnModel().getColumn(2).setPreferredWidth(30);
            show.getColumnModel().getColumn(3).setPreferredWidth(30);
            show.getColumnModel().getColumn(4).setPreferredWidth(30);


            String login = null,product,quantity,price,company,date;
            while(rs.next()){
                login = rs.getString(1);
                product = rs.getString(2);
                quantity = rs.getString(3);
                price = rs.getString(4);
                company = rs.getString(5);
                date = rs.getString(6);
                String[] row = {login,product,quantity,price,company,date};
                model.addRow(row);

            }

            if(e.getSource()== exit){
                System.exit(0);
            }
            else if(e.getSource() == add){
                new AddProduct(login);
                setVisible(false);
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
        new ShowProducts("");
    }
}
