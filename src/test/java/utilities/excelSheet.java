package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelSheet {

	static Workbook workbook;

	public static void readDataFromExcel(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+filePath);
		workbook = new XSSFWorkbook(fis);
	}

	public static String getDataFromEcxel(int row, int coloumn) {
		return workbook.getSheetAt(0).getRow(row).getCell(coloumn).getStringCellValue();
	}

	public static void setDataToExcel(int row, int coloumn, String value) {
		workbook.getSheetAt(0).getRow(row).getCell(coloumn).setCellValue(value);
	}
	
	public static int lastRow() {
		return workbook.getSheetAt(0).getLastRowNum();
	}
}
