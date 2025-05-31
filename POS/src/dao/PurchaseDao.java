package dao;

import entity.Category;
import entity.Stock;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.DatabaseUtil;

public class PurchaseDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;
    String sql;

    CategoryDao categoryDao = new CategoryDao();
    StockDao stockDao = new StockDao();

    public void loadProduct(JComboBox<String> comboproductList, String category) {
        comboproductList.removeAllItems();

        List<Stock> stockList = stockDao.getProductByCategory(category);

        if (stockList.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "No Product Found");
            System.out.println("No Product Found");
            return;
        }
        for (Stock s : stockList) {

            comboproductList.addItem(s.getProductName());
        }

    }

    public void loadCategory(JComboBox<String> comboCategoryList) {

        comboCategoryList.removeAllItems();

        List<Category> catList = categoryDao.getAllCategory();

        if (catList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Category Found");
            return;
        }
        for (Category cat : catList) {

            comboCategoryList.addItem(cat.getName());
        }
    }

    public void SavePurchase(String name, float unitPrice, float Quantity, float totalPrice, String category, String supplier) {

        sql = "insert into purchase(name, unitPrice, Quantity, totalPrice, category, supplier, date) "
                + "values(?,?,?,?,?,?,now())";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, name);
            ps.setFloat(2, unitPrice);
            ps.setFloat(3, Quantity);
            ps.setFloat(4, totalPrice);
            ps.setString(5, category);
            ps.setString(6, supplier);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
            JOptionPane.showMessageDialog(null, "Purchase Saved Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void purchaseReportByDate(Date from, Date to, JTable jt) {

        String[] columnsName = {"Product Name", "Unit Price", "Quantity", "Total Price", "Category", "Supplier", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
        jt.setModel(tableModel);

        sql = "select * from purchase where date between ? and ?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setDate(1, from);
            ps.setDate(2, to);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String productName = rs.getString("name");
                float unitPrice = rs.getFloat("unitPrice");
                float quantity = rs.getFloat("quantity");
                float totalPrice = rs.getFloat("totalPrice");
                String category = rs.getString("category");
                String supplier = rs.getString("supplier");
                Date date = rs.getDate("date");

                Object[] rowData = {productName, unitPrice, quantity, totalPrice, category, supplier, date};
                tableModel.addRow(rowData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
