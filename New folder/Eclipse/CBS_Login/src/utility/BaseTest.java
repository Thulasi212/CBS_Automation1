package utility;


	
	import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


	public class BaseTest {
	
	    public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    protected static WebDriver driver;
	    
	    public static void sendVFSms1() throws Exception {
	         String message="PASS : CBS-Login-Desktop-Adyar,Chennai";
	         String mobileno="918098882244,916302165648,";
	         String[] s = mobileno.split(",");
	         for (int i = 0; i < s.length; i++) {


	         String url = 
	"http://api.myvaluefirst.com/psms/servlet/psms.Eservice2";
	         URL obj = new URL(url);
	         HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	         //add reuqest header
	         con.setRequestMethod("POST");
	         //con.setRequestProperty("User-Agent", USER_AGENT);
	         con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	         String urlParameters = "data=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE MESSAGE SYSTEM \"http://127.0.0.1/psms/dtd/message.dtd\" ><MESSAGE><USER USERNAME=\"matrimony2\" PASSWORD=\"matrimony02\"/><SMS UDH=\"0\" CODING=\"1\" TEXT=\""+message+"\" PROPERTY=\"0\" ID=\"1\"><ADDRESS FROM=\"CMATRI\" TO=\""+s[i]+"\" SEQ=\"1\" TAG=\"some clientside random data\" /></SMS></MESSAGE>&action=send";

	         // Send post request
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(urlParameters);
	         wr.flush();
	         wr.close();

	         int responseCode = con.getResponseCode();
	         System.out.println("\nSending 'POST' request to URL : " + url);
	         System.out.println("Post parameters : " + urlParameters);
	         System.out.println("Response Code : " + responseCode);

	         BufferedReader in = new BufferedReader(
	                 new InputStreamReader(con.getInputStream()));
	         String inputLine;
	         StringBuffer response = new StringBuffer();

	         while ((inputLine = in.readLine()) != null) {
	             response.append(inputLine);
	         }
	         in.close();

	         //print result
	         System.out.println(response.toString());

	     } 
	  }
	  public static void sendVFSms() throws Exception {
	         String message="FAIL : CBS_Login-Desktop-Adyar,Chennai";
	         		
	         String mobileno="918098882244,916302165648";
	         String[] s = mobileno.split(",");
	         for (int i = 0; i < s.length; i++) {
	         String url ="http://api.myvaluefirst.com/psms/servlet/psms.Eservice2";
	         URL obj = new URL(url);
	         HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	         //add reuqest header
	         con.setRequestMethod("POST");
	         //con.setRequestProperty("User-Agent", USER_AGENT);
	         con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	         String urlParameters = "data=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE MESSAGE SYSTEM \"http://127.0.0.1/psms/dtd/message.dtd\" ><MESSAGE><USER USERNAME=\"matrimony2\" PASSWORD=\"matrimony02\"/><SMS UDH=\"0\" CODING=\"1\" TEXT=\""+message+"\" PROPERTY=\"0\" ID=\"1\"><ADDRESS FROM=\"CMATRI\" TO=\""+s[i]+"\" SEQ=\"1\" TAG=\"some clientside random data\" /></SMS></MESSAGE>&action=send";

	         // Send post request
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(urlParameters);
	         wr.flush();
	         wr.close();

	         int responseCode = con.getResponseCode();
	         System.out.println("\nSending 'POST' request to URL : " + url);
	         System.out.println("Post parameters : " + urlParameters);
	         System.out.println("Response Code : " + responseCode);

	         BufferedReader in = new BufferedReader(
	                 new InputStreamReader(con.getInputStream()));
	         String inputLine;
	         StringBuffer response = new StringBuffer();

	         while ((inputLine = in.readLine()) != null) {
	             response.append(inputLine);
	         }
	         in.close();

	         //print result
	         System.out.println(response.toString());

	     }
	     }

	  

      //////////    Excel    COde   ///////////////////////

public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
String data = row.getCell(colNum).getStringCellValue();
wb.close();
return data;
}


public static int getExcelRandomRowNum(String sheetName) throws Throwable{
FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Random rand = new Random();
int rowNum = rand.nextInt(sh.getLastRowNum());
return rowNum;
}
public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
wb.write(fos);
wb.close();
}
public static int getRowCount(String sheetName) throws Throwable {
FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rowIndex = wb.getSheet(sheetName).getLastRowNum();
return rowIndex;
}

public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,int data) throws Throwable{
FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("C:\\Users\\amuthan\\eclipse-workspace\\Sample_Project\\Excel\\SMSTEST.xlsx");
wb.write(fos);
wb.close();

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                  ///////////////////   Mail   COde    /////////////////////////////


public static void reportflush()
{
	extent.flush();    	
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

        message.setSubject("CBS Desktop Automation Report ");
     
        message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("cbsautomationreport@gmail.com"));
           //,thanikachalam.thirunanasambandan@matrimony.com                        
        Multipart multipart = new MimeMultipart();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("CBS Automation Report");
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();       
      

        String file = "C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\test-output\\MyOwnReport.html";

        String fileName = "CBS-AutomationReport-Desktop";
        DataSource source = new FileDataSource(file);
       // messageBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName("MyOwnReport.html");
      
       
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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

public static List<HashMap<String, String>> readValueFromExcelSheet1()  throws NullPointerException  {
	List<HashMap<String, String>> mapDatasList = new ArrayList();
	try {
		File excelLocaltion = new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx");

		String sheetName = "Sheet1";

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
	 
	    @BeforeSuite
	    public void reportConfig(){
	    		    
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	                
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
	        htmlReporter.config().setReportName("My Own Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);  
	        //htmlReporter.getEndTime();
	       // htmlReporter.getStartTime();
	       // htmlReporter.getRunDuration();    
	       
	    }          
	    @BeforeMethod
	    public void startUp()
	    {
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--disable-notifications");
	    	options.addArguments("--disable-features=VizDisplayCompositor");
	    	//System.setProperty("webdriver.chrome.driver", "C:\\Mohan\\chromedriver_win32\\chromedriver.exe");
	 		 // driver = new ChromeDriver(options);	
	 		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\dri\\chromedriver.exe");
			  driver = new ChromeDriver(options);	
	    }
	   
	    @AfterSuite
	    public void getResult(ITestResult result)throws IOException
	    {
	        	
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        
	            test.log(Status.FAIL,"Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getMethodName(),driver)));
	                   
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//	            test.pass(result.getThrowable());
		        
	       //     test.log(Status.PASS,"Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getMethodName(),driver)));
	        
	        }
	        
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	     
	      }     
	        
	    
	  
	        
	public static String takeScreenShot(String methodName,WebDriver driver) {
	    	
	        String path ="C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Screenshot\\"+methodName+".png";
	      //  String path1="C:\\Mohan\\screenshots\\"+methodName+".png";
	        try {
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(screenshotFile, new File(path));
	        } catch (Exception e) {
	         
	        }
	        return path;
	    }

	     
	    
	}



