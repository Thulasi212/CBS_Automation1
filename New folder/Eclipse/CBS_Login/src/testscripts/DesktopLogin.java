package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import utility.BaseTest11;

public class DesktopLogin extends BaseTest11{
	
	
	public static String baseurl;
	public static Properties properties;

	public void LoginTest() throws Exception {

		properties = new Properties();
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\amuthan\\eclipse-workspace\\CM_Desktop\\ObjectRepository\\Login.properties"));
		this.properties.load(fis);
	}
	

	@Test
	public void loginTest() throws Exception {

		test = extent.createTest("Login Test");
		test.pass("Browser Opened ");

		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx"));
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 1; i <= 1; i++) {
			baseurl = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(baseurl);
			test.pass("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			InetAddress ip = InetAddress.getByName(new URL(baseurl)
                    .getHost());
             System.out.println("Public IP Address of: " + ip);
             test.pass("Public IP Address of: " + ip); 
             System.out.println("Public IP Address of: \" + ip");
			String username = sheet.getRow(i).getCell(1).getStringCellValue();
			String password = sheet.getRow(i).getCell(2).getStringCellValue();
			test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
			test.pass("UserName is Valid :" + username);
			test.pass("Password is Valid : *******");
			// communitymatrimony login ---------------
			BussinessFunctions.cmLogin(driver, properties, username, password);
			// direct community login--------------
			// BussinessFunctions.login(driver, properties, username, password);
			Thread.sleep(2000);
			test.pass("Login Button Clicked");
			System.out.println("Login Successfully...");

			String randomID = BussinessFunctions.randomSelection(driver);
		    System.out.println("Selected randomID : " + randomID);
			test.pass("Selected ID is : " + randomID);
			Thread.sleep(3000);
			test.pass("Randomaly Selected the Community ID");
			System.out.println("randomaly Selected");
			String domain = driver.getCurrentUrl();
			test.pass("Domain Name====>" + domain);
			System.out.println("====>" + domain);

			try {
				WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));

				if (suspendid.isDisplayed()) {
					test.pass("This ID was Blocked/Suspended");
					break;
				}
			} catch (Exception e) {
				e.getMessage();
			}
			try {
				WebElement mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"));
				
				if (mobile_verify.isDisplayed()) {
					test.pass("This ID need to verify Mobile Number");
					break;
					
				}
				
				
			} catch (Exception e) {
				e.getMessage();
			}

			
			
			try {
				WebElement photo_add = driver.findElement(By.xpath("/html/body/div[2]/a"));
				if (photo_add.isDisplayed()) {
					photo_add.click();
					driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]")).click();
					driver.findElement(By.xpath("//*[@id=\"reason3\"]")).click();
					driver.findElement(By.xpath("//*[@id=\"skipphotoclick\"]")).click();
					
				}
				
			} catch (Exception e) {
				e.getMessage();
			}
			
			
			try {
				WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
				if (skip_matches.isDisplayed()) {
					skip_matches.click();
					
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
			try {
				WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
				if (element.isDisplayed()) {
					element.click();
					
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
			try {
				WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
				if (divorcee_intermediate_skip.isDisplayed()) {
					divorcee_intermediate_skip.click();
					
				}
			} catch (Exception e) {
				e.getMessage();
			} 
			

		
			Thread.sleep(6000);
			test.pass("Intermidate Pages are closed...Successfully");
			System.out.println("Intermidate Pages are closed...");



			System.out.println("Logout Completed Successfully..");
			test.pass("Application LogedOut Successfully...");
		}
		//driver.close();
	}
	
	
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws Exception {
   	 if (testResult.getStatus()==2) {
           BaseTest11.sendVFSms();
            System.out.println("intial fail");
        } else if(testResult.getStatus()==1){
            String text = BaseTest11.readValueFromExcelSheet1().get(1).get("Result");
            System.out.println(text);
            if(text.equals("2.0")){
            	BaseTest11.sendVFSms1();
                System.out.println("status change");
            }else{

            }

        }



        System.out.println(testResult.getStatus());
        FileInputStream file = new 
   FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginDesktop.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
   XSSFSheet sheet = workbook.getSheet("Sheet1");


        //Update the value of cell
       Cell cell = sheet.getRow(1).getCell(0);
        cell.setCellValue(testResult.getStatus());

        file.close();

        FileOutputStream outFile =new FileOutputStream(new 
   File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginDesktop.xlsx"));
        workbook.write(outFile);
        outFile.close();

   
	/*	if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Tech\\workspace\\BM-PWA-LOGIN\\screenshot\\Login.png"));
			System.out.println("sadfhgh");
		String capture = test.addScreenCapture("C:\\Users\\Tech\\workspace\\BM-PWA-LOGIN\\screenshot\\Login.png");
	
		test.log(LogStatus.FAIL, "negative methoed fail",capture);  */
		 
      
   
		
  }
		
	/*	report.endTest(logger);
		report.flush(); */
		
	   //driver.quit();

}
   




