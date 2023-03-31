package Excel_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {
	
	public static FileInputStream file;
	public static XSSFWorkbook Excel;
	public static Object [][] ExcelData(String Sheet_Name) throws IOException {
		
		file = new FileInputStream("C:\\Users\\Sakas\\eclipse-workspace\\akash_test\\src\\main\\resources\\Excel_Folder\\Read_Selenium_excel.xlsx");
		
		
	    Excel = new XSSFWorkbook(file);
		Sheet Excel_Sheet = Excel.getSheet(Sheet_Name);
		Object obj[][] = new Object[Excel_Sheet.getLastRowNum()][Excel_Sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<Excel_Sheet.getLastRowNum(); i++) {
			for(int j=0; j<Excel_Sheet.getRow(0).getLastCellNum(); j++) {
				
				obj[i][j] = Excel_Sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return obj;
	}
	
	

}
