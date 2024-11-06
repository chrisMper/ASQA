package utilities;

import org.testng.annotations.DataProvider;

public class PriceFilterDataProvider {
    @DataProvider(name = "priceRanges")
    public Object[][] getPriceRanges() {
        String filePath = "F:\\UNIVERSITY\\Sem_07\\IS4102_ASQA\\1assignmentexampe\\Assignment\\categories.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtilities.getExcelData(filePath, sheetName);
    }
}

