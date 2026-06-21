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
        Object[][] data = null;
        XSSFWorkbook workbook = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            XSSFRow row = sheet.getRow(0);
            int colCount = row.getLastCellNum();

            // Initialize array excluding the header row
            data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                XSSFRow currentRow = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = currentRow.getCell(j);
                    // Formats cell value to String regardless of data type
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
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