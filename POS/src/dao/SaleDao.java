/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import entity.Customer;
import entity.Stock;
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

/**
 *
 * @author user
 */
public class SaleDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;
    String sql;

    CategoryDao categoryDao = new CategoryDao();
    StockDao stockDao = new StockDao();
    CustomerDao customerDao = new CustomerDao();

    public void loadCustomerInSale(JComboBox<String> comboCustomerList) {
        comboCustomerList.removeAllItems();

        List<Customer> customerList = customerDao.getAllCustomer();

        if (customerList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Customer Found");
            System.out.println("No Customer Found");
            return;
        }
        for (Customer c : customerList) {
            comboCustomerList.addItem(c.getName());
        }

    }

    public void loadProductInSale(JComboBox<String> comboproductList, String category) {
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

    public void loadCategoryInSale(JComboBox<String> comboCategoryList) {

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
    public void verifyAndUpdateStockBeforeSale(String productName, float quantity){
        
        sql = "update stock set quantity = quantity-? where productName=?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setFloat(1, quantity);
            ps.setString(2, productName);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    public void saveSale(String customerName,String productName, float unitPrice, float quantity, float totalPrice) {

        sql = "insert into sale(customerName, productName, unitPrice, quantity, totalPrice) values(?,?,?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, customerName);
            ps.setString(2, productName);
            ps.setFloat(3, unitPrice);
            ps.setFloat(4, quantity);
            ps.setFloat(5, totalPrice);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            JOptionPane.showMessageDialog(null, "Product sold");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Product not sold");
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
