package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.DatabaseUtil;

public class CustomerDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;

    public void saveCustomer(String name, String email, String cell, String address, JTable jt) {
        String sql = "insert into customer(name, cell, address, email) values(?,?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, cell);
            ps.setString(3, address);
            ps.setString(4, email);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New Customer Details Saved Successfully");
            showAllCustomer(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Customer Details not Saved");
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllCustomer(JTable jt) {

        String[] columnsName = {"ID", "Name", "Email", "Cell", "Address"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
        jt.setModel(tableModel);

        String sql = "select * from customer";

        try {
            ps = util.getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cell = rs.getString("cell");
                String address = rs.getString("address");

                Object[] rowData = {id, name, email, cell, address};
                tableModel.addRow(rowData);

            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletecustomer(int id, JTable jt) {

        String sql = "Delete from customer where id = ?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "Customer Deleted Successfully");
            showAllCustomer(jt);

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCustomer(int id, String name, String email, String cell, String address, JTable jt) {
        String sql = "update customer set name=?, cell=?, address=?, email=? where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, cell);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setInt(5, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New Customer Details Edited Successfully");
            showAllCustomer(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Customer Details not Edited");
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[] findCustomerById(int id) {
        String sql = "select * from customer where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new Object[]{
                    rs.getString("name"),
                    rs.getString("cell"),
                    rs.getString("email"),
                    rs.getString("address")

                };
            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
