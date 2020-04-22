package utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest11 {
	
	 public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    protected static WebDriver driver;
	 

	

	public static void setText(WebElement element, String string) {
		//cleartextbox(element);
		element.sendKeys(string);

	}
	
	
	public static void cleartextbox(WebElement element) {
		element.clear();

	}

	public static void btnclick(WebElement element) {
		element.click();
	}

	public static void closeApp(WebDriver driver) {
		driver.close();

	}
	public static String getAttri(WebElement element,String value) {
		return element.getAttribute(value);
		
		

	}
	 public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{



         TakesScreenshot scrShot =((TakesScreenshot)driver);



                 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);



                 File DestFile=new File("C:\\Users\\Vijay\\workspace\\bmPwa\\screenshot"+fileWithPath+".png");



                 FileUtils.copyFile(SrcFile, DestFile);

     }

	 public static void setAttributeValue(WebElement elem, String value){
		 JavascriptExecutor    js = (JavascriptExecutor) driver; 

		    String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";

		    js.executeScript(scriptSetAttrValue, elem, "value", value);

		}
/*	public static void drbdwnvalueselect(WebElement element, String name) {

		Select s = new Select(element);
		//s.selectByValue(name);
s.selectByVisibleText(name);
	}  */

	public static void radioButton(WebElement element) {
		element.click();
	}
	public static String gettext(WebElement element ) {
		 
		return element.getText();

	}


	// public static String getdata(int rownum, int cellno) throws Throwable{
	//
	// File excellocation=new
	// File("G:\\Santhosh\\Workspace\\HelloMaven\\Excel\\excel.xlsx");
	// FileInputStream stream=new FileInputStream(excellocation);
	//
	// Workbook book=new XSSFWorkbook(stream);
	// Sheet sheet = book.getSheet("datas");
	// int rowcount = sheet.getPhysicalNumberOfRows();
	// Row row=sheet.getRow(rowcount);
	// int countCells = row.getPhysicalNumberOfCells();
	// for (int i = 0; i < countCells; i++) {
	//
	// Cell cell = row.getCell(i);
	// int k=cell.getCellType();
	// if(k==1) {
	// String name= cell.getStringCellValue();
	// }else if(k==0) {
	//
	// double d = cell.getNumericCellValue();
	// long l = (long) d;
	// name =String .valueOf(l) ;
	// }
	// }
	//
	//
	// return name;

	// }
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
	         String message="FAIL : CBS-Login-Desktop-Adyar,Chennai";
	         		
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

	public static List<HashMap<String, String>> readValueFromExcelSheet()  throws NullPointerException  {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		try {
			File excelLocaltion = new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginDesktop.xlsx");

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


public static List<HashMap<String, String>> readValueFromExcelSheet1()  throws NullPointerException  {
	List<HashMap<String, String>> mapDatasList = new ArrayList();
	try {
		File excelLocaltion = new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginDesktop.xlsx");

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


}



