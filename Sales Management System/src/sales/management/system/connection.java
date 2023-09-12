package sales.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Statement;

public class connection {
    Statement statement;
    Connection connection;

    String url="jdbc:mysql://localhost:3306/SalesManagementSystem";
    String username="root";
    String password="";
    public connection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


