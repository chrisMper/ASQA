package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilities {
    public static Object[][] getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();

            // Skip the header row by starting from row index 1
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Object[] rowData = new Object[1]; // Only one column

                    Cell cell = row.getCell(0); // Get the single column cell

                    // Read the cell value as a string
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        rowData[0] = cell.getStringCellValue().trim(); // Store as string
                    } else {
                        rowData[0] = ""; // Default to empty string if cell is empty
                    }

                    // Add rowData to data if it has a valid string value
                    if (!rowData[0].toString().isEmpty())
                        data.add(rowData);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert List<Object[]> to Object[][] for DataProvider compatibility
        return data.toArray(new Object[0][0]);
    }
}
