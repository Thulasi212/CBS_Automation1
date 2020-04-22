package com.app.Android_App;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest{
	
	public static ExtentReports reports;
    public static ExtentTest test;
    
    String html =  Math.floor(Math.random() * 143) + "AndroidReport.html";
    WebDriver driver;
    
    
    public void click(WebElement element) {	
		element.click();

	}
	 
	 public void clear(WebElement element) {	
			element.clear();
	 }
			
	 public void typeData(WebElement element, String Value) {
		element.sendKeys(Value);

	}
	 
	 public void dropdown(WebElement element, String Value) {
		 org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(element);
		s.selectByValue(Value);
	 }
	
	@BeforeSuite
	public void htmlReport() {
		
		
	   //  reporter = new ExtentHtmlReporter("C:\\Users\\amuthan\\eclipse-workspace\\com.mobile\\ScreenShot");
       
		 reports=new ExtentReports("D:\\Android HTML Report\\"+html,true);
    	 reports.loadConfig(new File("C:\\Users\\Jyothi\\.eclipse\\Android_App\\extent\\extentreports-java-2.41.2\\extent-config.xml"));
    	 //test=reports.startTest("Android Registeration Test");
         
	}
	
	
	public static List<HashMap<String, String>> readValueFromExcelSheet()  throws NullPointerException  {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		try {
			File excelLocaltion = new File("C:\\Users\\Jyothi\\.eclipse\\Android_App\\Excel\\saidata1.xlsx");

			String sheetName = "sheet1";

			FileInputStream f = new FileInputStream(
					excelLocaltion.getAbsolutePath());
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								currentCell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								String.valueOf(currentCell
										.getNumericCellValue()));

						break;

					}
				}

				mapDatasList.add(mapDatas);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return mapDatasList;

	}

@AfterSuite
public void reportflush()
{
		   	
	final String username = "mohantest.mm@gmail.com";
    final String password = "mohanmmteam";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    Message message = new MimeMessage(session);

    try {
       
        message.setFrom(new InternetAddress("mohantest.mm@gmail.com"));

        message.setSubject("CBS Android Automation Report ");
     
        message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("cbsautomationreport@gmail.com"));
           //,thanikachalam.thirunanasambandan@matrimony.com                        
        Multipart multipart = new MimeMultipart();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("CBS Android Automation Report");
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();       
      

        String file = "D:\\Android HTML Report\\"+html;

        String fileName = "CBS-Android-Automation-Report";
        DataSource source = new FileDataSource(file);
       // messageBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName("AndroidReport.html");
      
       
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        System.out.println("Sending....");

        Transport.send(message);

        System.out.println("Mail Sent Successfully");

    } catch (MessagingException e) {
        e.printStackTrace();
    }  
    
    
	
}  
public static String takeScreenShot(String methodName,WebDriver driver) {
	
    String path ="D:\\Android HTML Report\\Screenshot-Fails\\"+ Math.floor(Math.random() * 14) +"Android.png";
    try {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(path));
    } catch (Exception e) {
     
    }
    return path;
} 


public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = "D:\\Android HTML Report\\Screenshot-Fails\\"+screenshotName+dateName+".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
	 }

}


/*@AfterMethod

public void getResult(ITestResult result){
if(result.getStatus() == ITestResult.FAILURE){
test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());

String screenshotPath = "D:\\Android HTML Report\\Screenshot-Fails\\";
//To add it in the extent report 
test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));



}
else if(result.getStatus() == ITestResult.SKIP){
test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
}
}
}
*/

