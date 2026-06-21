package com.simplilearn.PizzaHut.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        // 1. Initialize to an empty 2D array instead of null to prevent TestNG engine crashes
        Object[][] data = new Object[0][0];
        XSSFWorkbook workbook = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.err.println("Error: Sheet name '" + sheetName + "' not found in the Excel file!");
                return new Object[0][0];
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount <= 1) {
                System.err.println("Warning: Excel sheet is empty or only contains headers!");
                return new Object[0][0];
            }

            XSSFRow row = sheet.getRow(0);
            int colCount = row.getLastCellNum();

            data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                XSSFRow currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = currentRow.getCell(j);
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file at path: " + filePath + " -> " + e.getMessage());
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}