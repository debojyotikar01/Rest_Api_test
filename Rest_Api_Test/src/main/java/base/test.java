package base;

import java.io.IOException;

import org.testng.annotations.Test;

public class test {
	
	Test_Data excel_data=new Test_Data();
	
	@Test
	public void add() throws IOException
	{
		
		String Quote_number = excel_data.readExcel("data", "name");
		System.out.println(Quote_number);
		System.out.println(Quote_number);
		System.out.println(Quote_number);
	}
	

}
