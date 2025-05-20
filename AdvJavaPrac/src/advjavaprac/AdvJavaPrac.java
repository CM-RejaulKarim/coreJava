package advjavaprac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

public class AdvJavaPrac {

    static DbUtil util = new DbUtil();
    static PreparedStatement ps;
    static String sql = "";

    public static void main(String[] args) {
        System.out.println("=========CRUD Operation========");
        saveEmp("atik", "atik@gmail.com", 5000);

        System.out.println("<<<<<<<<<<<<After Save>>>>>>>>>>>>");
        showAllEmp();
        System.out.println("========================");

        updateEmp("Atik", "Atik@gmail.com", 6000, 1);
        System.out.println("<<<<<<<<<<<Updated Successfully>>>>>>>>>>>>>");

        showAllEmp();
        System.out.println("========================");

        deleteEmp(1);
        System.out.println("<<<<<<<<<<<After Delete>>>>>>>>>>>");

        showAllEmp();
        System.out.println("========================");
        
        //After delete you Have to Truncate Table in MySql...

    }

    public static void saveEmp(String name, String email, double salary) {
        sql = "insert into emp(name,email,salary) values(?,?,?)";

        try {
            ps = util.getcon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();
            System.out.println("Save Done");

        } catch (SQLException ex) {
            Logger.getLogger(AdvJavaPrac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showAllEmp() {
        sql = "select * from emp";

        try {
            ps = util.getcon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id + ", \nName: " + name
                        + ", \nEmail: " + email + ", \nSalary: " + salary);
            }

            rs.close();
            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJavaPrac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateEmp(String name, String email, double salary, int id) {
        sql = "update emp set name=?, email =?, salary =? where id =?";

        try {
            ps = util.getcon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJavaPrac.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteEmp(int id) {
        sql = "delete from emp where id =?";

        try {
            ps = util.getcon().prepareStatement(sql);

            ps.setInt(1, 1);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvJavaPrac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
