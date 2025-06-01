/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
    ResultSet rs;
    
    StockDao stockDao = new StockDao();

    public void getAllStockInSaleTable(JTable jt) {

        String[] columnsName = {"Category", "Product Name", "Quantity"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
        jt.setModel(tableModel);

        sql = "select * from stock where quantity > 0 order by quantity desc, productName";

        try {
            ps = util.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

//                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                float quantity = rs.getFloat("quantity");
                String category = rs.getString("category");

                Object[] rowData = {category, productName, quantity};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public Void selectItemsForSale(String productName, float Quantity, float unitPrice, JTable jt) {
//        sql="";
//    }
    
    public void saleProductSelected(String productName, float quantity, float unitPrice, float totalPrice, JTable jt) {
        String sql = "insert into sale(productName, unitPrice, quantity, totalPrice) values(?,?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, productName);
            ps.setFloat(2, unitPrice);
            ps.setFloat(3, quantity);
            ps.setFloat(4, totalPrice);

            ps.executeUpdate();

            ps.close();
            util.getCon().close();

            //JOptionPane.showMessageDialog(null, "Product Added");
            // showAllCategory(jt);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Product Not Added");
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void loadProductInSellCombo(JComboBox<String> comboproductList) {
        comboproductList.removeAllItems();

        List<Stock> productList = stockDao.getProductForSale();

        if (productList.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "No Product Found");
            System.out.println("No Product Found");
            return;
        }
        for (Stock s : productList) {

            comboproductList.addItem(s.getProductName());
        }

    }

//    public void showAllSoldProduct(JTable jt) {
//
//        String[] columnsName = {"ID", "Product Name", "Unit Price", "Quantity", "Total Price"};
//        DefaultTableModel tableModel = new DefaultTableModel(columnsName, 0);
//        jt.setModel(tableModel);
//
//        String sql = "select * from sale";
//
//        try {
//            ps = util.getCon().prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String productName = rs.getString("productName");
//                float unitPrice = rs.getFloat("unitPrice");
//                float quantity = rs.getFloat("quantity");
//                float totalPrice = rs.getFloat("totalPrice");
//
//                Object[] rowData = {id, productName, unitPrice, quantity, totalPrice};
//                tableModel.addRow(rowData);
//
//            }
//            rs.close();
//            ps.close();
//            util.getCon().close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
