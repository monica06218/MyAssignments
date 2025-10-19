package week6.marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readdata {
	
	public static String readData() throws IOException {
		// TODO Auto-generated method stub
		// XSSFWorkbook- Open the Workbook
				XSSFWorkbook wb=new XSSFWorkbook("./Data/sample.xlsx");
			
				//Open the worksheet
				//wb.getSheet("Sheet1");
				XSSFSheet ws = wb.getSheetAt(0);
				
				//To count the number of rows - excluding the header
				int rowCount = ws.getLastRowNum();
				System.out.println("The row count is: "+rowCount);
				
				//To count the number of rows - including the header
				int physicalNumberOfRows = ws.getPhysicalNumberOfRows();
				System.out.println("The row "+physicalNumberOfRows);
				
				//To count the number of columns
				int columnCount = ws.getRow(0).getLastCellNum();
				System.out.println("The column count is: "+columnCount);
				
				//To retrieve the data - Monica
				
				String row1Cell1Data = ws.getRow(1).getCell(0).getStringCellValue();
				String data=row1Cell1Data;
				
				return data;
			
			}
	
	
	}



