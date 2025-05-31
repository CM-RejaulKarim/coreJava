/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Purchase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.DatabaseUtil;

/**
 *
 * @author user
 */
public class ReportDao {

    DatabaseUtil util = new DatabaseUtil();
    PreparedStatement ps;
    String sql;
    ResultSet rs;

    CategoryDao categoryDao = new CategoryDao();
    StockDao stockDao = new StockDao();

    public List<Purchase> purchaseReportByDate(Date from, Date to, JTable jt) {
        List<Purchase> purchaseList = new ArrayList<>();

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

                Purchase p = new Purchase(
                        rs.getString("name"),
                        rs.getFloat("unitPrice"),
                        rs.getFloat("quantity"),
                        rs.getFloat("totalPrice"),
                        rs.getString("category"),
                        rs.getString("supplier"),
                        rs.getDate("date")
                );

                purchaseList.add(p);

                Object[] rowData = {p.getName(), p.getUnitPrice(), p.getQuantity(),
                    p.getTotalPrice(), p.getCategory(), p.getSupplier(), p.getDate()};
                tableModel.addRow(rowData);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchaseList;
    }

    public void generatePDFReportForPurchase(Date from, Date to, JTable jt) {

        List<Purchase> purchases = purchaseReportByDate(from, to, jt);
        
        long mill = System.currentTimeMillis();
        LocalTime curTime= LocalTime.of(0, 0);
        LocalDate currentDate = LocalDate.now();

        try {
            //create pdf document
            Document document = new Document(PageSize.A4);
            String filePath = "Purchase Report " + currentDate +"_"+ mill + ".pdf"; //Save to root directory
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            //Title for the doc
            Font titleFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18);
            Paragraph title = new Paragraph("Purchase Report", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);
            
            //Title for the doc
            Font subTitleFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16);
            Paragraph subTitle = new Paragraph("Report Generated: "+currentDate, subTitleFont);
            subTitle.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(subTitle);

            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            float[] columnWidths = {2.5f, 2.5f, 2f, 1.5f, 1.5f, 2f, 2f};
            table.setWidths(columnWidths);

            String[] headers = {"Product Name", "Unit Price", "Quantity", "Total Price", "Category", "Supplier", "Date"};
            Font headerFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setBackgroundColor(BaseColor.BLACK.LIGHT_GRAY);
                table.addCell(headerCell);
            }

            Font dataFont = FontFactory.getFont(FontFactory.TIMES, 10);

            for (Purchase p : purchases) {

                table.addCell(new PdfPCell(new Phrase(p.getName(), dataFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(p.getUnitPrice()), dataFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(p.getQuantity()), dataFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(p.getTotalPrice()), dataFont)));
                table.addCell(new PdfPCell(new Phrase(p.getCategory(), dataFont)));
                table.addCell(new PdfPCell(new Phrase(p.getSupplier(), dataFont)));
                table.addCell(new PdfPCell(new Phrase(p.getDate().toString(), dataFont)));
            }

            document.add(table);
            document.close();
            JOptionPane.showMessageDialog(null, "Report Generated Successfully");

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReportDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
