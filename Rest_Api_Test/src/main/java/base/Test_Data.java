package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_Data {
	
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;


	public String readExcel(String Scenario_name,String header_name) throws IOException{
		
		File file = new File("F:\\test_data.xlsx");
		//File file = new File("C:\\NGQ_Oxygen_SeleniumAutomation\\NGQ_Master_Automation\\src\\test\\resources\\new_production.xlsx");
		String data = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error not able to open file input stream with Testing.xls file");
		}        

		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("Error not able to read Testing.xls file");
		}

		XSSFSheet sheet = wb.getSheet("Sheet1");

		int lastRowNum = sheet.getLastRowNum();
		//System.out.println("No of rows: "+lastRowNum);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		//System.out.println("No of columns: "+noOfColumns);
		
		
		for (int row_num=1; row_num<=lastRowNum; row_num++) {
			String scenario_name = sheet.getRow(row_num).getCell(0).toString();
			if(scenario_name.equalsIgnoreCase(Scenario_name)) {
				for(int col_num=0;col_num<noOfColumns; col_num++) {
					XSSFRow row = sheet.getRow(0);
					String header = row.getCell(col_num).getStringCellValue().toString();
					if(header.equalsIgnoreCase(header_name)) {
						data = sheet.getRow(row_num).getCell(col_num).toString();
					}
				}
				break;
			}
		
		}
		

		return data;
	}
}

	
	
	

