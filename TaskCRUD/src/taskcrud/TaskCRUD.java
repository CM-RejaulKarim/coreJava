package taskcrud;

import dbutiltask.TaskDbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskCRUD {

    static TaskDbUtil util = new TaskDbUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static void main(String[] args) {
        saveStudent("atik", "atik@gmail.com", "m.pur");
        System.out.println("-------------------------------------------------");
        
        
        System.out.println("After save");
        showAllStudent();       
         System.out.println("-------------------------------------------------");
         
        updateStudent("Atikur Rahman", "atikur@gmail.com", "demra", 1);
        System.out.println("After Update");
        showAllStudent();
         System.out.println("-------------------------------------------------");
        
        
        deleteStudent(1);
        System.out.println("After Delete");
        showAllStudent();
         System.out.println("-------------------------------------------------");
        
        
    }

    public static void saveStudent(String name, String email, String address) {
        sql = "insert into ccsl (name, email, address) values(?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
            System.out.println("Student Saved.");

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAllStudent() {
        sql = "select * from ccsl";

        try {
            ps = util.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");

                System.out.println("ID:" + id + ", Name:" + name + ", Email:" + email + ", Address:" + address);

            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent(String name, String email, String address, int id) {
        sql = "update ccsl set name=?, email=?, address=? where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteStudent(int id) {
        sql = "delete from ccsl where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
