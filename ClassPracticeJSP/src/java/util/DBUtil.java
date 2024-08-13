
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil {
    public static String url="jdbc:mysql://localhost:3306/dbcrud";
    public static String user="root";
    public static String password="";
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static Connection con=null;
    
     public static Connection getCon(){
         try {
             Class.forName(driver);
             con = DriverManager.getConnection(url, user, password);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
         }
         return con;
    }
}
