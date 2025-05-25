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
        saveOrganization("atik", "atik@gmail.com", 11);
        System.out.println("-------------------------------------------------");
        
        
        System.out.println("After save");
        showAllOrganization();       
         System.out.println("-------------------------------------------------");
         
        updateOrganization("Atikur Rahman", "atikur@gmail.com", 10, 1);
        System.out.println("After Update");
        showAllOrganization();
         System.out.println("-------------------------------------------------");
        
        
        deleteOrganization(1);
        System.out.println("After Delete");
        showAllOrganization();
         System.out.println("-------------------------------------------------");
        
        
    }

    public static void saveOrganization(String name, String headQuaters, int memberStates) {
        sql = "insert into organizations (name, headQuaters, memberStates) values(?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, headQuaters);
            ps.setInt(3, memberStates);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
            System.out.println("Organization Saved.");

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAllOrganization() {
        sql = "select * from organizations";

        try {
            ps = util.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String headQuaters = rs.getString("headQuaters");
                int memberStates = rs.getInt("memberStates");

                System.out.println("ID:" + id + ", Name:" + name + ", Email:" + headQuaters + ", Address:" + memberStates);

            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateOrganization(String name, String headQuaters, int memberStates, int id) {
        sql = "update organizations set name=?, headQuaters=?, memberStates=? where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, headQuaters);
            ps.setInt(3, memberStates);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TaskCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteOrganization(int id) {
        sql = "delete from organizations where id=?";

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
