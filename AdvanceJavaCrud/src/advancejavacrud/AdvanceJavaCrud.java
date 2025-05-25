package advancejavacrud;

import dbutil.AdvJavaDataBaseUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvanceJavaCrud {

    static AdvJavaDataBaseUtil util=new AdvJavaDataBaseUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static void main(String[] args) {
        saveEmployee("Md. Hamidur Rahman", "Asst.Manager", 30000f);
        saveEmployee("Md. Tahmid", "Operator", 20000f);
        saveEmployee("Md. Sohel", "Employee", 25000f);
        System.out.println("---------------------After Save---------------------");
        
        showAllEmployee();

        
        updateEmployee("Md. Hamidur Rahman", "Manager", 45000f, 1);
        updateEmployee("Md. Tahmid", "Senior Operator", 32000f, 2);
        updateEmployee("Md. Sohel", "Employee", 33000f, 3);

        System.out.println("---------------------After Update---------------------");
        showAllEmployee();
        

        deleteEmployee(2);
        
        System.out.println("---------------------After Delete---------------------");
        showAllEmployee();


    }

    public static void saveEmployee(String name, String designation, float salary) {
        sql = "insert into employees(name, designation, salary) value(?,?,?)";

        try {
            ps = util.getcon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setFloat(3, salary);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();
            System.out.println("Employee Saved Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(AdvanceJavaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateEmployee(String name, String designation, float salary, int id) {
        sql = "update employees set name=?, designation=?, salary=? where id=?";

        try {
            ps = util.getcon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setFloat(3, salary);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvanceJavaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void showAllEmployee() {
        sql = "select * from employees";

        try {
            ps = util.getcon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String designation = rs.getString("designation");
                float salary = rs.getFloat("salary");

                System.out.println("\nID: " + id + ", \nName: " + name + ", \nDesignation: " + designation + ", \nSalary: " + salary);
            }

            rs.close();
            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvanceJavaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteEmployee(int id) {
        sql = "delete from employees where id=?";

        try {
            ps = util.getcon().prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getcon().close();

        } catch (SQLException ex) {
            Logger.getLogger(AdvanceJavaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
