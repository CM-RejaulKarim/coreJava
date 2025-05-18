package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.DatabaseUtil;

public class CustomerDao {

    DatabaseUtil du = new DatabaseUtil();
    PreparedStatement ps;

    public void saveCustomer(String name, String email, String cell, String address, JTable jt) {
        String sql = "insert into student(name, cell, address, email) values(?,?,?,?)";

        try {
            ps = du.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, cell);
            ps.setString(3, address);
            ps.setString(4, email);

            ps.executeUpdate();

            ps.close();
            du.getCon().close();
            
            JOptionPane.showMessageDialog(null, "New Customer Details Saved Successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Customer Details not Saved");
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
