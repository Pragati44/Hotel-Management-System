
package hotelBooking;
import java.sql.*;
import java.util.*;
import java.lang.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c =DriverManager.getConnection("jdbc:mysql://localhost:3306/ hotelmanagementsystem","root","Pragati25####");
        s=c.createStatement();
    }
    catch(Exception e){
        e.printStackTrace();
    }
        }
}
