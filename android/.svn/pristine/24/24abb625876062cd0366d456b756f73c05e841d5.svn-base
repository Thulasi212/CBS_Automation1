package Base1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseBrahmin {
	
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
		List<HashMap<String, String>> mapDatasList = new ArrayList<HashMap<String, String>>();
		try {
			File excelLocaltion = new File("C:\\Users\\amuthan\\eclipse-workspace\\CBS_Android\\Excel\\Test data.xlsx");

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
  	
   /* public void horizontalScroll()
    {
        Dimension size = driver.manage().window().getSize();
        int x_start=(int)(size.width*0.60);
        int x_end=(int)(size.width*0.30);
        int y=130;
        driver.swipe(x_start,y,x_end,y,4000);
    }*/
	

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

	
