package dao;

import entity.Category;
import entity.Stock;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
            System.out.println("No Category Found");
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
}
