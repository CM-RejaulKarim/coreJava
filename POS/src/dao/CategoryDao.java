package dao;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.DatabaseUtil;

public class CategoryDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;

    public void saveCategory(String name, JTable jt) {
        String sql = "insert into category(name) values(?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New Category Details Saved Successfully");
            showAllCategory(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Category Details not Saved");
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllCategory(JTable jt) {

        String[] columnsName = {"ID", "Name"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
        jt.setModel(tableModel);

        String sql = "select * from category";

        try {
            ps = util.getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Object[] rowData = {id, name};
                tableModel.addRow(rowData);

            }
            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(int id, JTable jt) {

        String sql = "Delete from category where id = ?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "Category Deleted Successfully");
            showAllCategory(jt);

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCategory(int id, String name, JTable jt) {
        String sql = "update category set name=?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);

            ps.setInt(2, id);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "New category Details Edited Successfully");
            showAllCategory(jt);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "New Category Details not Edited");
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Category> getAllCategory() {

        List<Category> categoryList = new ArrayList<>();

        String sql = "select * from category";

        try {
            ps = util.getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                categoryList.add(new Category(id, name));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoryList;
    }
}
