package com.cm.testscripts;
import com.cm.Utility.*;
import com.cm.businessFunctions.BussinessFunctions;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	public static String baseurl;
	public static Properties properties;

	public LoginTest()throws Exception{
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Login.properties"));
		properties.load(fis);
	}	

@Test
	public  void loginTest() throws Exception{
	
	test=extent.createTest("Login Test");
	test.pass("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Mohan\\CM_Desktop_TestData\\LoginTestData.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 1; i <=1; i++) {
			baseurl = sheet.getRow(i).getCell(0).getStringCellValue();			
			driver.navigate().to(baseurl);	
			test.pass("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			String username = sheet.getRow(i).getCell(1).getStringCellValue();
			String password = sheet.getRow(i).getCell(2).getStringCellValue();
			test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
			test.pass("UserName is Valid :"+username);
			test.pass("Password is Valid : *******");						
			BussinessFunctions.cmLogin(driver,properties, username, password);
			Thread.sleep(2000);
			test.pass("Login Button Clicked");						
			System.out.println("Login Successfully...");															
						
							String randomID=BussinessFunctions.randomSelection(driver);
							System.out.println("Selected randomID : "+randomID);
							test.pass("Selected ID is : "+randomID);
							Thread.sleep(3000);
							test.pass("Randomaly Selected the Community ID");						
							System.out.println("randomaly Selected");														
							String domain=driver.getCurrentUrl();							
							test.pass("Domain Name====>"+domain);							
							System.out.println("====>"+domain);						
						
						try{												
							WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));	
																									
							if(suspendid.isDisplayed()){    
								test.pass("This ID was Blocked/Suspended");
							break;
														}
						}catch(Exception e){ e.getMessage(); }						
							
							BussinessFunctions.intermidatePages(driver,properties);
							Thread.sleep(6000);
							test.pass("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");							
													
							BussinessFunctions.cmLogout(driver,properties);
				Thread.sleep(4000);
				
				System.out.println("Logout Completed Successfully..");
				test.pass("Application LogedOut Successfully...");				
			}			
		}
/*@AfterMethod
public void tearDown()
{
	driver.close();
}	*/ 




}


