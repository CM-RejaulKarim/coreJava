package trashcrudproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.trashCrudDbUtil;

public class TrashCRUDProject {

    static PreparedStatement ps;
    static trashCrudDbUtil util = new trashCrudDbUtil();
    static String sql;
    static ResultSet rs;

    public static void main(String[] args) {
        saveTeacher("Emran", "Class Teacher", "emran@mail.com");
        showAllTeacher();
        System.out.println("After Save");
        System.out.println("=======================================");

        updateTeacher("Muhammad Emran Hossain", "Teacher", "emranhss@mail.com", 1);
        showAllTeacher();
        System.out.println("After update");
        System.out.println("=======================================");
        deleteTeacher(1);
        showAllTeacher();
        System.out.println("After Delete");

    }

    public static void saveTeacher(String name, String post, String email) {
        sql = "insert into teachers(name, post, email) values(?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, post);
            ps.setString(3, email);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TrashCRUDProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAllTeacher() {

        sql = "select * from teachers";

        try {
            ps = util.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String post = rs.getString("post");
                String email = rs.getString("email");

                System.out.println("ID:" + id + ", Name:" + name + ", Post:" + post + ", Email:" + email);
            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TrashCRUDProject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateTeacher(String name, String post, String email, int id) {
        sql = "update teachers set name=?, post=?, email=? where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, post);
            ps.setString(3, email);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TrashCRUDProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteTeacher(int id) {
        sql = "delete from teachers where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(TrashCRUDProject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
