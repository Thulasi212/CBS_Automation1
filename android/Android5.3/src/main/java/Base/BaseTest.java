package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	public static ExtentReports reports;
    public static ExtentTest test;
    String html =  "AndroidReport.html";
    AndroidDriver driver;
    
    
    
    
    
    public static void click(WebElement element) {	
  		element.click();

  	}
  	 
  	 public static void clear(WebElement element) {	
  			element.clear();
  	 }
  			
  	 public static void typeData(WebElement element, String Value) {
  		element.sendKeys(Value);

  	}
  	
  	 
  	 
  	 
  	
  	 
  	public static List<HashMap<String, String>> readValueFromExcelSheet()  throws NullPointerException  {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		try {
			File excelLocaltion = new File("Android5.3\\Excel\\multiple_login.xlsx");

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
  

  	public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream("F:\\CBS-Automation-master\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
      Workbook wb = WorkbookFactory.create(fis);
      Sheet sh = wb.getSheet(sheetName);
      Row row = sh.getRow(rowNum);
      String data = row.getCell(colNum).getStringCellValue();
    //  ((FileInputStream) wb).close();
		return data;
	}
  	
  	/*public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
  	    FileInputStream fis = new FileInputStream("C:\\Users\\Jyothi\\.eclipse\\Android5.3\\Excel\\city_values.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	 Sheet sh = wb.getSheet(sheetName);
  	 Row row = sh.getRow(rowNum);
  	 String data = row.getCell(colNum).getStringCellValue();
  	//  wb.close();
  	    return data;
  	}*/


  	public static int getExcelRandomRowNum(String sheetName) throws Throwable{
  	    FileInputStream fis = new FileInputStream("E:\\workspaceN\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	 Sheet sh = wb.getSheet(sheetName);
  	 Random rand = new Random();
  	 int rowNum = rand.nextInt(sh.getLastRowNum());
  	 return rowNum;
  	}
  	public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
  	    FileInputStream fis = new FileInputStream("E:\\workspaceN\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	 Sheet sh = wb.getSheet(sheetName);
  	 Row row = sh.getRow(rowNum);
  	 Cell cel = row.createCell(colNum);
  	 cel.setCellValue(data);
  	 FileOutputStream fos = new FileOutputStream("E:\\workspaceN\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	    wb.write(fos);
  	    ((FileInputStream) wb).close();
  	}
  	public static int getRowCount(String sheetName) throws Throwable {
  	    FileInputStream fis = new FileInputStream("F:\\CBS-Automation-master\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	 int rowIndex = wb.getSheet(sheetName).getLastRowNum();
  	 return rowIndex;
  	}

  	public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,int data) throws Throwable{
  	    FileInputStream fis = new FileInputStream("F:\\CBS-Automation-master\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	 Sheet sh = wb.getSheet(sheetName);
  	 Row row = sh.getRow(rowNum);
  	 Cell cel = row.createCell(colNum);
  	 cel.setCellValue(data);
  	 FileOutputStream fos = new FileOutputStream("F:\\CBS-Automation-master\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	    wb.write(fos);
  	    ((FileInputStream) wb).close();

  	}


  	public static int getCellCount(String sheetName) throws Throwable {
  	    FileInputStream fis = new FileInputStream("F:\\CBS-Automation-master\\Android\\Android5.3\\Excel\\multiple_login.xlsx");
  	 Workbook wb = WorkbookFactory.create(fis);
  	Sheet sh = wb.getSheet(sheetName);
  	Row row = sh.getRow(0);
  	int cell = row.getLastCellNum();
  	return cell;
  	}


  	
  	
  	
  	
  	
  	
  	
  	@AfterMethod
	public void screenShot(ITestResult result) {
  		
  	

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				//String path = "C:\\Users\\amuthan\\eclipse-workspace\\CBS_Android\\Screenshot\\"+ result.getName()+".png";
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("C:\\Users\\amuthan\\eclipse-workspace\\CBS_Android\\Screenshot\\"+ result.getName()+".png"));
					//	"C:\\Users\\amuthan\\eclipse-workspace\\CBS_Android\\Screenshot\\"+ result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");


			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}

	
}