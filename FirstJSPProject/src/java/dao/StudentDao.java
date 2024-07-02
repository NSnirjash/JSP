
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbUtil;

/**
 *
 * @author User
 */
public class StudentDao {
//    static Student s = new Student();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = ""; 
    
    public static int saveData(Student s){
        int status = 0;
        
        sql = "insert into student(name, email, address, cell_no) "
                + "values(?,?,?,?)";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell_no());
            
            status = ps.executeUpdate();
            System.out.println(status);
            
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
}