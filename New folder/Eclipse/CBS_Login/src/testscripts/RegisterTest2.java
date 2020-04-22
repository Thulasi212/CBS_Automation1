package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import utility.BaseTest;

public class RegisterTest2 extends BaseTest {
	
	public static String baseurl,matriid;
	public static Properties properties,properties1,properties2;
			
	public RegisterTest2()throws Exception{
		properties=new Properties();
		FileInputStream objectsinput1 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Registration.properties"));
		properties.load(objectsinput1);
			}	
		
	@Test	
	public static void registerTest() throws Exception{
	test=extent.createTest("Register Module -Test");
				
		FileInputStream file1 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\RegisterTestData1.xlsx")); 
		Workbook workbook1 = WorkbookFactory.create(file1);
		Sheet sheet1 = workbook1.getSheetAt(0);
		FileInputStream file2 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\RegisterTestData2.xlsx")); 
		Workbook workbook2 = WorkbookFactory.create(file2);
		Sheet sheet2 = workbook2.getSheetAt(0);
		
		for (int i=1; i<=1; i++) {
			String communitysite=sheet1.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to("https://www.communitymatrimony.com/");
			test.pass("Application Launched Successfully");
						
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			BussinessFunctions.register2page1(driver, properties,communitysite);
			
		
			

}
		//driver.close();
	}
	
}
