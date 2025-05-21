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

public class SupplierDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;

    public void saveSupplier(String name, String email, String cell, String address, String contactPerson, JTable jt) {
        String sql = "insert into suppliers(name, address, cell, email, contactPerson) values(?,?,?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, cell);
            ps.setString(4, email);
            ps.setString(5, contactPerson);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New Supplier Details Saved Successfully");
            showAllSupplier(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Supplier Details not Saved");
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllSupplier(JTable jt) {

        String[] columnsName = {"ID", "Name", "Address", "Cell", "Email", "contactPerson"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
        jt.setModel(tableModel);

        String sql = "select * from suppliers";

        try {
            ps = util.getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cell = rs.getString("cell");
                String address = rs.getString("address");
                String contactPerson = rs.getString("contactPerson");

                Object[] rowData = {id, name, address, cell, email, contactPerson};
                tableModel.addRow(rowData);

            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSupplier(int id, JTable jt) {

        String sql = "Delete from suppliers where id = ?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "Supplier Deleted Successfully");
            showAllSupplier(jt);

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editSupplier(int id, String name, String email, String cell, String address, String contactPerson, JTable jt) {
        String sql = "update suppliers set name=?, address=?, cell=?, email=?, contactPerson =? where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, cell);
            ps.setString(4, email);
            ps.setString(5, contactPerson);
            ps.setInt(6, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New supplier Details Edited Successfully");
            showAllSupplier(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Supplier Details not Edited");
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
