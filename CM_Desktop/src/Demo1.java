import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo1 {
	
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream(".//Resources\\RegisterTestData1.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheetAt(0);
        for(int i=1;i<=1;i++){
        	String value= sh.getRow(i).getCell(2).getStringCellValue();
        	System.out.println(value);
        }
        
        
	}

}
