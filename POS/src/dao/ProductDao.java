/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import util.DatabaseUtil;

/**
 *
 * @author user
 */
public class ProductDao {
    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;
    String sql;
    ResultSet rs;
    
    CategoryDao categoryDao= new CategoryDao();
    
    public void loadCategoryToProductCombo(JComboBox<String> catList) {
        catList.removeAllItems();
        
        List<Category> categories= new ArrayList<>();
        
        categories= categoryDao.getAllCategory();
        
        for (Category c : categories) {
            catList.addItem(c.getName());
        }
        
        
    }
    
    
}
