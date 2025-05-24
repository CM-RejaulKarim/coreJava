package praccrudforexam;

import dbutil.PracCrudDbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PracCrudForExam {

    static PreparedStatement ps;
    static PracCrudDbUtil util = new PracCrudDbUtil();
    static ResultSet rs;
    static String sql;

    public static void main(String[] args) {
        saveStudent("A.Rahim", "ar@g.c", "rampura");
        System.out.println("=======================================");
        System.out.println("After Save");
        showAllStudent();

        System.out.println("=======================================");
        updateStudent("Abdur Rahim", "ar@mail.com", "rampura", 1);
        System.out.println("After update");
        showAllStudent();

        System.out.println("=======================================");
        deleteStudent(1);
        System.out.println("After Delete");
        showAllStudent();

    }

    public static void saveStudent(String name, String email, String address) {

        sql = "insert into ccsl(name, email, address) values (?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
            System.out.println("Student Saved Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(PracCrudForExam.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PracCrudForExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteStudent(int id) {
        sql = "delete from ccsl where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(PracCrudForExam.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PracCrudForExam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
