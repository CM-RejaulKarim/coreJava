package advjvcrud;

import crudutil.DatabaseUtilPracCrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvJvCRUD {

    static DatabaseUtilPracCrud util = new DatabaseUtilPracCrud();
    static PreparedStatement ps;
    static String sql;

    public static void main(String[] args) {

        addStudent("Atik", "atik@mail.com", "Demra");
        showAllStudents();
        System.out.println("==============================");

        System.out.println("After Update.");
        updateStudent("Atikur", "atikur@mail.com", "shk", 1);
        showAllStudents();

        System.out.println("==============================");

        System.out.println("After delete.");
        deleteStudent(1);
        showAllStudents();

        System.out.println("==============================");

    }

    public static void addStudent(String name, String email, String address) {

        sql = "insert into ccsl(name, email, address) values(?,?,?)";

        try {
            ps = util.getcon().prepareCall(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

            System.out.println("Add Student Done.");

        } catch (SQLException ex) {
            Logger.getLogger(AdvJvCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAllStudents() {

        sql = "select * from ccsl";

        try {
            ps = util.getcon().prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Address: " + address);
            }

            rs.close();
            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJvCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent(String name, String email, String address, int id) {
        sql = "update ccsl set name=?, email=?, address=? where id =?";

        try {
            ps = util.getcon().prepareCall(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJvCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteStudent(int id) {
        sql = "delete from ccsl where id =?";
        try {
            ps = util.getcon().prepareCall(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJvCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
