package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher;
import util.DBUtil;

public class TeacherDao {

    public static DBUtil dbUtil = new DBUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";

    public static int saveData(Teacher t) {
        int status = 0;

        sql = "insert into teacher(name, department, gender) "
                + "values(?,?,?)";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDepartment());
            ps.setString(3, t.getGender());

            status = ps.executeUpdate();
            System.out.println(status);

            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<Teacher> viewAllTeacher() {
        List<Teacher> tcList = new ArrayList<>();

        sql = "select * from teacher";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Teacher t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("gender")
                    );
                tcList.add(t);
            }

            rs.close();
            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tcList;
    }
    
    public static Teacher  getById(int id) {

        Teacher t = null;
        sql = "select * from teacher where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("gender")
                        
                );

                ps.close();
                DBUtil.getCon().close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public static void updateTeacher(Teacher t) {

        sql = "update teacher set name=?, department=?, gender=? where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDepartment());
            ps.setString(3, t.getGender());
            ps.setInt(4, t.getId());

            ps.executeUpdate();
            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void deleteTeacher(Teacher t) {

        sql = "delete from teacher where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);

            ps.setInt(1, t.getId());

            ps.executeUpdate();

            ps.close();
            DBUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
