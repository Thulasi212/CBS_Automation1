package utility;


	
	import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


	public class BaseTest {
	
	    public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    protected static WebDriver driver;
	   
	    public static String domain;
	    public static String error;
	    public static String expt,ex,exp,e,expti,exptio,status;
	    String html =  "MyReport.html";
		

		public static void click(WebElement element) {
			element.click();
		}

		
		public static void clear(WebElement element) {
			element.clear();
		}

		
		public static void typeData(WebElement element, String Value) {
			element.sendKeys(Value);
		}
		////////////////Drop Down Base//////////////////
		
		public static void select_string(WebElement element, String Value) {
			Select s = new Select(element);
			s.selectByValue(Value);
		}
		
		
		public static void select_index(WebElement element, int Value) {
			Select s = new Select(element);
			s.selectByIndex(Value);	
		}
		
		
		public static void select_text(WebElement element, String text) {
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
		
		
		//////////////////////    Screen SHot    //////////////////////////////////////
		

	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
	public static String getScreenshot(String screenshotName, WebDriver driver) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names 
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = "C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\ScreenShot\\" +screenshotName+".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	                //Returns the captured file path
	 return destination;
	}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                                          /////   SMS    CODE   ////
		
		 public static void sendVFSms1() throws Exception {
	         String message="PASS : Comunity_Registeration_Desktop-Adyar,Chennai";
	         String mobileno="918098882244,916302165648";
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
		 
		 
	  public static void sendVFSms(String domain , String error , String expt) throws Exception {
	         String message= "Level 1 " +"\n" + "Module : "+ status +"\n"+"Platform : Desktop" +"\n"+ "Error on : "+error + "\n" + "Error Description : " + expt +"\n" + "Domain Name : " + domain + "\n"+"Location : Adayar-Chennai" + "\n" +"" ;
	         	//"FAIL : Divorcee_Login_Desktop-Adyar,Chennai  "+"\n"+"Domain : "+domain+"\n" + "Error on "+error+"\n"+ " Error Reason : " + expt + "";
	        		 // " Level 1 " +"\n" + "Error on : Login Test " + "\n" + "Error Description : " + error + "\n"  + " Reported to : No Response " +"\n" + "Domain Name : " + domain + "\n" + test.getStartedTime() +"" ;
	         String mobileno="918098882244";
	        		 //,916302165648,919840870629";
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
		
		
		
		/////
	  
	  
	  public static void sendVFSms2(String domain , String error , String expt) throws Exception {
	      String message="Level 2 " +"\n" + "Module : "+status +"\n"+"Platform : Desktop" +"\n"+ "Error on : "+error + "\n" + "Error Description : " + expt +"\n" + "Domain Name : " + domain + "\n"+"Location : Adayar-Chennai" + "\n"  +"";
	      		
	      String mobileno="917010752043";
	    		  //,919840870629,"919789352793",919840870629,919841165519,919444086906,919952119197,917299972503,919092343056";
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
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  
	  
	                         //////////    Excel    COde   ///////////////////////
	  
	  public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
			FileInputStream fis = new FileInputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);
	      Row row = sh.getRow(rowNum);
	      String data = row.getCell(colNum).getStringCellValue();
	      wb.close();
			return data;
		}
		
		
		public static int getExcelRandomRowNum(String sheetName) throws Throwable{
			FileInputStream fis = new FileInputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);
	      Random rand = new Random();
	      int rowNum = rand.nextInt(sh.getLastRowNum());
	      return rowNum;
		}
		public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
			FileInputStream fis = new FileInputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);
	      Row row = sh.getRow(rowNum);
	      Cell cel = row.createCell(colNum);
	      cel.setCellValue(data);
	      FileOutputStream fos = new FileOutputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
			wb.write(fos);
			wb.close();
		}
		public static int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis = new FileInputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
	      int rowIndex = wb.getSheet(sheetName).getLastRowNum();
	      return rowIndex;
		}
		
		public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,int data) throws Throwable{
			FileInputStream fis = new FileInputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);
	      Row row = sh.getRow(rowNum);
	      Cell cel = row.createCell(colNum);
	      cel.setCellValue(data);
	      FileOutputStream fos = new FileOutputStream("C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Excel\\SMSTEST.xlsx");
			wb.write(fos);
			wb.close();
	  
		}
		
		

		public static  String  randomSelection(WebDriver driver){
			
			List<WebElement> links = driver.findElements(By.cssSelector("html body div.innerdiv.margin-reset div.bgclr2 div.pad7 div.bgclr5.pad10.smalltxt form dl.nomargpad dd.fleft.padb5.mediumhdrtxt.domainlist a.clr4"));
			List<WebElement> visited = new ArrayList<WebElement>();
			WebElement random = links.get(new Random().nextInt(links.size()));
						String randomId=random.getText();
			System.out.println("No.of ID's.. "+links.size());
			if( !visited.contains(random))
			{ 
			  random.click();
			   visited.add(random);
			    //driver.navigate().back();
			}
			return randomId;		
		}
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		                     ///////////////////     Mail Base Code               //////////////////////////////
		
		
		public static void reportflush(String a , String b , String c)
		{
			extent.flush();    	
			final String username = "cbsautomationreport@gmail.com";
		    final String password = "cbstest123";

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
		       
		        message.setFrom(new InternetAddress("cbsautomationreport@gmail.com"));

		        message.setSubject("[CBS-QA-ALERT-LEVEL 1]["+ status + " :  FAIL]");
		     
		        message.setRecipients(Message.RecipientType.TO,
		                    InternetAddress.parse("cbsautomationreport@gmail.com,amukural@gmail.com "));
		           //,thanikachalam.thirunanasambandan@matrimony.com                        
		        Multipart multipart = new MimeMultipart();

		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        messageBodyPart.setText("Level 1 " +"\n" + "Module : "+status +"\n"+"Platform : Desktop" +"\n"+ "Error on : "+error + "\n" + "Error Description : " + expt +"\n" + "Domain Name : " + domain + "\n"+"Location : Adayar-Chennai" + "\n"  +"");
		        MimeBodyPart attachmentBodyPart = new MimeBodyPart();       
		       // " Level 1 " +"\n" + "Error on : Login Test " + "\n" + "Error Description : " + error + "\n"  + " Reported to : No Response " +"\n" + "Domain Name : " + domain + "\n" + test.getStartedTime() +"" ;
	             //CBS Automation Report - Mail for Script Failed With Resson"+"\n"+ "Domain : " +domain+"\n"+"Error on : " +error+ "\n"+ " Error Reason : " + expt + "
		        String file = "C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Report\\MyReport.html";

		        String fileName = "CBS-AutomationReport-Desktop";
		        DataSource source = new FileDataSource(file);
		       // messageBodyPart.setDataHandler(new DataHandler(source));
		        attachmentBodyPart.setDataHandler(new DataHandler(source));
		        attachmentBodyPart.setFileName("MyReport.html");
		      
		       
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
		    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    
		    
		    
		    public static void reportflush1(String a , String b , String c)
			{
				extent.flush();    	
				final String username = "cbsautomationreport@gmail.com";
			    final String password = "cbstest123";

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
			       
			        message.setFrom(new InternetAddress("cbsautomationreport@gmail.com"));

			        message.setSubject("[CBS-QA-ALERT-LEVEL 2]["+ status + " :  FAIL]");
			     
			        message.setRecipients(Message.RecipientType.TO,
			                    InternetAddress.parse("amudhan.nagarajan@matrimony.com,amukural@gmail.com"));
			                    		//,thanikachalam.thirunanasambandan@matrimony.com,ashokkumar@bharatmatrimony.com,dhanapal@bharatmatrimony.com,kalanithi@bharatmatrimony.com,senthilnath.subramani@matrimony.com, raja.sekar@matrimony.com,kalanithi@bharatmatrimony.com"));
			           //,thanikachalam.thirunanasambandan@matrimony.com                        
			        Multipart multipart = new MimeMultipart();

			        MimeBodyPart messageBodyPart = new MimeBodyPart();
			        messageBodyPart.setText("Level 2 " +"\n" + "Module : "+status +"\n"+"Platform : Desktop" +"\n"+ "Error on : "+error + "\n" + "Error Description : " + expt +"\n" + "Domain Name : " + domain + "\n"+"Location : Adayar-Chennai" +"\n"  +"");
			        MimeBodyPart attachmentBodyPart = new MimeBodyPart();       
			       // " Level 1 " +"\n" + "Error on : Login Test " + "\n" + "Error Description : " + error + "\n"  + " Reported to : No Response " +"\n" + "Domain Name : " + domain + "\n" + test.getStartedTime() +"" ;
		             //CBS Automation Report - Mail for Script Failed With Resson"+"\n"+ "Domain : " +domain+"\n"+"Error on : " +error+ "\n"+ " Error Reason : " + expt + "
			        String file = "C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\Report\\MyReport.html";

			        String fileName = "CBS-AutomationReport-Desktop";
			        DataSource source = new FileDataSource(file);
			       // messageBodyPart.setDataHandler(new DataHandler(source));
			        attachmentBodyPart.setDataHandler(new DataHandler(source));
			        attachmentBodyPart.setFileName("MyReport.html");
			      
			       
			        multipart.addBodyPart(messageBodyPart);
			        multipart.addBodyPart(attachmentBodyPart);

			        message.setContent(multipart);

			        System.out.println("Sending....");

			        Transport.send(message);

			        System.out.println("Mail Sent Successfully");

			    } catch (MessagingException e) {
			        e.printStackTrace();
			    }      
			    
			    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    

			
		}    

		
	 
	    @BeforeSuite
	    public void reportConfig(){
	    		    
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Report/MyReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	                
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Community Registeration Test");
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
	    	//System.setProperty("webdriver.chrome.driver", "C:\\Mohan\\chromedriver_win32\\chromedriver.exe");
	 		 // driver = new ChromeDriver(options);	
	 		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\CBS\\eclipse-workspace\\CBS_registeration1\\lib\\chromedriver.exe");
			  driver = new ChromeDriver(options);	
	    }
	   


	     
	    
	}



