package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import utility.BaseTest;

public class Url extends BaseTest {

	public static String baseurl;
	public static Properties properties;

	public Url() throws Exception {

		properties = new Properties();
		FileInputStream fis = new FileInputStream(new File(
				"C:\\\\Users\\\\amuthan\\\\eclipse-workspace\\\\CM_Desktop\\\\ObjectRepository\\\\Login.properties"));
		this.properties.load(fis);
	}
	/*
	 * @BeforeMethod public void startUp() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\lib\\chromedriver.exe");
	 * driver = new ChromeDriver(); }
	 */

	@Test
	public void loginTest() throws Exception {

		test = extent.createTest("Url Test");
		test.pass("Browser Opened ");

		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan2222.xlsx"));
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 1; i <=339; i++) {
			baseurl = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(baseurl);
			test.pass("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String domain = driver.getCurrentUrl();
			test.pass("Domain Name====>" + domain);
			System.out.println("====>" + domain);

	
		        //Convert web driver object to TakeScreenshot		
			TakesScreenshot scrShot =((TakesScreenshot)driver);


			
			//Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination
		                File DestFile=new File("path");

	                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);
		                
		       

		    }
	
}

}


