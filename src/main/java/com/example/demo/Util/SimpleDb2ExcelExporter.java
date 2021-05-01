package com.example.demo.Util;

import java.io.*;
import java.sql.*;
import java.util.List;

import com.example.demo.bean.Stock;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * A simple Java program that exports data from database to Excel file.
 * @author Nam Ha Minh
 * (C) Copyright codejava.net
 */
public class SimpleDb2ExcelExporter {

//    public static void main(String[] args) {
//        new SimpleDb2ExcelExporter().export();
//    }

//    public void export() {
//        String jdbcURL = "jdbc:mysql://localhost:3306/gmao";
//        String username = "root";
//        String password = "";
//
//        String excelFilePath = "Reviews-export.xlsx";
//
//        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
//            String sql = "SELECT * FROM stock";
//
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery(sql);
//
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("Reviews");
//
//            writeHeaderLine(sheet);
//
//            writeDataLines(result, workbook, sheet);
//
//            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
//            workbook.write(outputStream);
//            workbook.close();
//
//            statement.close();
//
//        } catch (SQLException e) {
//            System.out.println("Datababse error:");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("File IO error:");
//            e.printStackTrace();
//        }
//    }
//
//    private void writeHeaderLine(XSSFSheet sheet) {
//
//        Row headerRow = sheet.createRow(0);
//
//        Cell headerCell = headerRow.createCell(0);
//        headerCell.setCellValue("Id");
//
//        headerCell = headerRow.createCell(1);
//        headerCell.setCellValue("qte");
//
//        headerCell = headerRow.createCell(2);
//        headerCell.setCellValue("magasin");
//
//        headerCell = headerRow.createCell(3);
//        headerCell.setCellValue("material");
//
////        headerCell = headerRow.createCell(4);
////        headerCell.setCellValue("Comment");
//    }
//
//    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
//                                XSSFSheet sheet) throws SQLException {
//        int rowCount = 1;
//
//        while (result.next()) {
//            String courseName = result.getString("id");
//            double studentName = result.getDouble("qte");
//            float rating = result.getFloat("magasin");
////            Timestamp timestamp = result.getTimestamp("timestamp");
//            String comment = result.getString("material");
//
//            Row row = sheet.createRow(rowCount++);
//
//            int columnCount = 0;
//            Cell cell = row.createCell(columnCount++);
//            cell.setCellValue(courseName);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(studentName);
//
////            cell = row.createCell(columnCount++);
//
////            CellStyle cellStyle = workbook.createCellStyle();
////            CreationHelper creationHelper = workbook.getCreationHelper();
////            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
////            cell.setCellStyle(cellStyle);
////
////            cell.setCellValue(timestamp);
//
//          cell = row.createCell(columnCount++);
//            cell.setCellValue(rating);
//
//            cell = row.createCell(columnCount);
//            cell.setCellValue(comment);
//
//        }
//    }


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "qte", "MagasinReference", "ProduitReference" };
    static String SHEET = "Stocks";

    public static ByteArrayInputStream StocksToExcel(List<Stock> Stocks) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Stock stock : Stocks) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(stock.getId());
                row.createCell(1).setCellValue(stock.getQte());
                row.createCell(2).setCellValue(stock.getMagasin().getReference());
                row.createCell(3).setCellValue(stock.getMaterial().getReference());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
