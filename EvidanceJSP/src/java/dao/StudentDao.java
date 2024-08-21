/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DBUtil;


public class StudentDao {
    public static DBUtil dbUtil = new DBUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    public static int saveData(Student s){
        int status=0;
        
         sql = "insert into student(name, email, address, gender, subject) "
                + "values(?,?,?,?,?)";
         
        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getSubject());
            
            status = ps.executeUpdate();
            System.out.println(status);

            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return status;        
    }

     
      public static List<Student> viewAllStudent() {
        List<Student> stList = new ArrayList<>();

        sql = "select * from student";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getString("email"), 
                        rs.getString("Address"), 
                        rs.getString("gender"),
                        rs.getString("subject")
                );
                        

                stList.add(s);
            }

            rs.close();
            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stList;
    }
      
     public static Student  getById(int id) {

        Student s = null;
        sql = "select * from student where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getString("subject")
                );

                ps.close();
                DBUtil.getCon().close();
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
     
     public static void updateStudent(Student s) {

        sql = "update student set name=?, email=?, address=?, gender=?, subject=? where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getSubject());
            ps.setInt(6, s.getId());

            ps.executeUpdate();
            ps.close();
            DBUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void deleteStudent(Student s) {

        sql = "delete from student where id=?";

        try {
            ps = DBUtil.getCon().prepareStatement(sql);

            ps.setInt(1, s.getId());

            ps.executeUpdate();

            ps.close();
            DBUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
