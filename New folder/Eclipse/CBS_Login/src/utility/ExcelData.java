package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Thulasi
 *
 */
public class ExcelData {

	public String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream(".//Resources//LoginTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        String data = row.getCell(colNum).getStringCellValue();
        wb.close();
		return data;
	}
	
	
	public int getExcelRandomRowNum(String sheetName) throws Throwable{
		FileInputStream fis = new FileInputStream(".//Resources//LoginTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Random rand = new Random();
        int rowNum = rand.nextInt(sh.getLastRowNum());
        return rowNum;
	}
	public void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
		FileInputStream fis = new FileInputStream(".//Resources//LoginTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        Cell cel = row.createCell(colNum);
        cel.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(".//Resources//LoginTestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(".//Resources//LoginTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        int rowIndex = wb.getSheet(sheetName).getLastRowNum();
        return rowIndex;
	}
	
	
}



