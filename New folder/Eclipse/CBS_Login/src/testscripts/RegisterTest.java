package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import utility.BaseTest;

public class RegisterTest extends BaseTest{	
	public static String baseurl,matriid;
	public static Properties properties,properties1,properties2;
			
	public RegisterTest()throws Exception{
		properties=new Properties();
		FileInputStream objectsinput1 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Registration.properties"));
		properties.load(objectsinput1);
			}	
		
	@Test	
	public static void registerTest() throws Exception{
	test=extent.createTest("Register Module -Test");
				
		FileInputStream file1 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\RegisterTestData1.xlsx")); 
		Workbook workbook1 = WorkbookFactory.create(file1);
		Sheet sheet1 = workbook1.getSheetAt(0);
		FileInputStream file2 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\RegisterTestData2.xlsx")); 
		Workbook workbook2 = WorkbookFactory.create(file2);
		Sheet sheet2 = workbook2.getSheetAt(0);
		for (int i=5; i<=5; i++) {
		
			driver.navigate().to("https://www.Agarwalmatrimony.com/");
			test.pass("Application Launched Successfully");
						
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
				//registerPage1 test data from excel file 1
		//	driver.findElement(By.xpath("//*[@id=\"home-register\"]/div/div/nav/ul/li[2]/a")).click();
					String communitysite=sheet1.getRow(i).getCell(0).getStringCellValue();
					String profileby=sheet1.getRow(i).getCell(1).getStringCellValue();
										
					String name=sheet1.getRow(i).getCell(2).getStringCellValue();
					String gender=sheet1.getRow(i).getCell(3).getStringCellValue();
					String date1=sheet1.getRow(i).getCell(4).getStringCellValue();
					String month=sheet1.getRow(i).getCell(5).getStringCellValue();
					String year=sheet1.getRow(i).getCell(6).getStringCellValue();
					String martial=sheet1.getRow(i).getCell(7).getStringCellValue();
					String relgion=sheet1.getRow(i).getCell(20).getStringCellValue();
					String denominations=sheet1.getRow(i).getCell(8).getStringCellValue();
					String denominationText=sheet1.getRow(i).getCell(9).getStringCellValue();
					String div_cast=sheet1.getRow(i).getCell(10).getStringCellValue();
					String div_cast_ifOther=sheet1.getRow(i).getCell(11).getStringCellValue();
					String sub_cast=sheet1.getRow(i).getCell(12).getStringCellValue();
					String sub_castifSC=sheet1.getRow(i).getCell(13).getStringCellValue();
					String Sub_cast_IfOther=sheet1.getRow(i).getCell(14).getStringCellValue();
					String mothertongue=sheet1.getRow(i).getCell(15).getStringCellValue();
					String country=sheet1.getRow(i).getCell(16).getStringCellValue();
					String ccode=sheet1.getRow(i).getCell(17).getStringCellValue();
					String mobileno=sheet1.getRow(i).getCell(18).getStringCellValue()+Math.round(Math.random()*998);
					System.out.println(mobileno);
					String loginpwd=sheet1.getRow(i).getCell(19).getStringCellValue();
					
				//registerPage2 test data from excel file 2
					String mail = sheet2.getRow(i).getCell(0)
                            .getStringCellValue()+ Math.floor(Math.random() * 143231)
                            + "@gmail.com";
					String aboutme=sheet2.getRow(i).getCell(1).getStringCellValue();
					String NoOfChilds=sheet2.getRow(i).getCell(35).getStringCellValue();
					String childLiving=sheet2.getRow(i).getCell(36).getStringCellValue();
					String height=sheet2.getRow(i).getCell(2).getStringCellValue();
					String physicalStatus=sheet2.getRow(i).getCell(3).getStringCellValue();
					String residestate=sheet2.getRow(i).getCell(4).getStringCellValue();
					String residecity=sheet2.getRow(i).getCell(5).getStringCellValue();
					String citizen=sheet2.getRow(i).getCell(6).getStringCellValue();
					String commsite=sheet2.getRow(i).getCell(34).getStringCellValue();
					String division=sheet2.getRow(i).getCell(7).getStringCellValue();
					String relgiousValues=sheet2.getRow(i).getCell(9).getStringCellValue();
					String readQuran=sheet2.getRow(i).getCell(8).getStringCellValue();
					
					String star=sheet2.getRow(i).getCell(22).getStringCellValue();
					String rasi=sheet2.getRow(i).getCell(23).getStringCellValue();
					String gothram=sheet2.getRow(i).getCell(24).getStringCellValue();
					String dosham=sheet2.getRow(i).getCell(25).getStringCellValue();
					String doshamType=sheet2.getRow(i).getCell(26).getStringCellValue();
					String hours=sheet2.getRow(i).getCell(27).getStringCellValue();
					String mins=sheet2.getRow(i).getCell(28).getStringCellValue();
					String mridiem=sheet2.getRow(i).getCell(29).getStringCellValue();
					String cbirth=sheet2.getRow(i).getCell(30).getStringCellValue();
					String sbirth=sheet2.getRow(i).getCell(31).getStringCellValue();
					String citybirth=sheet2.getRow(i).getCell(32).getStringCellValue();
					String chartstyle=sheet2.getRow(i).getCell(33).getStringCellValue();
					
					String highestEdu=sheet2.getRow(i).getCell(10).getStringCellValue();
					String addEdu=sheet2.getRow(i).getCell(11).getStringCellValue();
					String prof=sheet2.getRow(i).getCell(12).getStringCellValue();
					String occupation=sheet2.getRow(i).getCell(13).getStringCellValue();
					String income1=sheet2.getRow(i).getCell(14).getStringCellValue();
					String annualCurrency=sheet2.getRow(i).getCell(15).getStringCellValue();
					String annualIncome=sheet2.getRow(i).getCell(16).getStringCellValue();
					String parentContact=sheet2.getRow(i).getCell(17).getStringCellValue();
					String familyValue=sheet2.getRow(i).getCell(18).getStringCellValue();
					String familyType=sheet2.getRow(i).getCell(19).getStringCellValue();
					String familyStatus=sheet2.getRow(i).getCell(20).getStringCellValue();
					String ethnicity=sheet2.getRow(i).getCell(21).getStringCellValue();
					String cllgName=sheet2.getRow(i).getCell(37).getStringCellValue();
					String eduInDetails=sheet2.getRow(i).getCell(38).getStringCellValue();
					String fatherOccup=sheet2.getRow(i).getCell(39).getStringCellValue();
					String motherOccup=sheet2.getRow(i).getCell(40).getStringCellValue();
					String aboutMyfamily=sheet2.getRow(i).getCell(43).getStringCellValue();
					String netWorths=sheet2.getRow(i).getCell(44).getStringCellValue();

										
BussinessFunctions.registrationPage1( driver, properties, communitysite, profileby, name,gender,date1, month, year, martial, relgion,denominations, 
					denominationText, div_cast,div_cast_ifOther, sub_cast,sub_castifSC,Sub_cast_IfOther,mothertongue,country, ccode, 
					mobileno,  loginpwd);
			Thread.sleep(3000);	
			//driver.findElement(By.id("caste")).sendKeys("Iyer");
		//	driver.findElement(By.id("subCaste")).sendKeys("vadama");
			test.pass("Registration with ===> "+communitysite);
			test.info("Reading test data from repository excel...for all fields");
			Thread.sleep(4000);
		//	driver.findElement(By.id("complete")).click();
			
			System.out.println("Completion Button Clicked");
			test.pass("****Registration Page--1 Completed Successfully****");
			
			
BussinessFunctions.registrationPage2(driver,properties,communitysite,mail, aboutme,martial,NoOfChilds,childLiving, height, physicalStatus,residestate, residecity, citizen, commsite,division, relgiousValues,readQuran,
		star, rasi, gothram, dosham,doshamType, hours, mins, mridiem, cbirth, sbirth, citybirth, chartstyle, highestEdu, addEdu, prof,  occupation,income1, annualCurrency,
		annualIncome, parentContact, familyValue, familyType,familyStatus, ethnicity, netWorths  );
			 Thread.sleep(2000);
			 
			 //driver.findElement(By.xpath("//*[@id=\"complete\"]")).click();
			 
		
			test.pass("****Registration Page--2 Completed Successfully****");
			//PIN Verification.....
			if(communitysite.equals("brahminmatrimony.com")||communitysite.equals("christianmatrimony.com")||communitysite.equals("muslimmatrimony.com"))
			{
			WebElement element1 = driver.findElement(By.xpath(".//*[@id='frmRegister']/div/div[2]/div[2]"));
	        String text = element1.getText();	        
	        matriid = text.substring(19,30);
	        System.out.println(matriid);
	        test.info("Newly Registered Matri ID is - : "+matriid);
			}
			else
			{
				WebElement element1 = driver.findElement(By.xpath(".//*[@id='frmRegister']/div/div[2]/div[2]"));
		        String text = element1.getText();	        
		        matriid = text.substring(19,29);
		        System.out.println(matriid);
		        test.info("Newly Registered Matri ID is - : "+matriid);
			}
			
		}driver.quit();
	        // For opening new tab
	       
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	//       System.out.println("New tab opened");	        
//        Thread.sleep(9000);	      
	//        driver.navigate().to("https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriid);    
	        //https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriid
//	        //driver.navigate().back();
//			WebElement element = driver.findElement(By.xpath("/html/body/pre"));
//			String pinnotext = element.getText();
//			driver.navigate().back();
//			System.out.println("PIN : "+pinnotext);			
//			System.out.println("Success...");    
//			test.pass("Mobile Activation Started.....");	                      
//	       Thread.sleep(1000);	        
//	        String pinNum=pinnotext.substring(24,31);
//	        System.out.println(pinNum);
//	        test.pass("Mobile Recivied PIN Number is :  ****** ");	        
//	        Thread.sleep(1000);	     
//	       
//	        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w"); 
//	       // driver.switchTo().window(pwh);
//	       // driver.navigate().back(); 
//	        Thread.sleep(1000);
//	        driver.findElement(By.id("pinNo")).sendKeys(pinNum);
//	        driver.findElement(By.id("Verify")).click();
//	        Thread.sleep(1000);
//	        WebElement mobileAlert=driver.findElement(By.xpath(".//*[@id='alertresult']"));
//	        String mobileAlertMessage=mobileAlert.getText();
//	        test.pass(mobileAlertMessage);
//	        driver.findElement(By.xpath(".//*[@id='popupphoneverified']/div/div/div/div[1]/div[3]/a")).click();
//	        test.pass("Mobile POPUP Closed");	        
//	        Thread.sleep(1000);
//	        driver.findElement(By.xpath(".//*[@id='skippage']")).click();	        
//	        Thread.sleep(1000);
//	        driver.findElement(By.xpath(".//*[@id='conform']/div/div/div/a[1]")).click();
//	        test.pass("AddPhoto Page - Skipped");
//	        driver.findElement(By.xpath(".//*[@id='reason1']")).click();
//	        Thread.sleep(1000);
//	        driver.findElement(By.xpath(".//*[@id='skipphotoclick']")).click();
//	        Thread.sleep(2000);
//	       // driver.findElement(By.linkText("Skip to Home")).click();
//	       // Thread.sleep(2000);
//	       // driver.findElement(By.linkText("I'll do this later")).click();
//	       // test.pass("Partner Preference Page - Skipped");
//	        Thread.sleep(1000);
//	        driver.findElement(By.xpath(".//*[@id='frm']/div[18]/div[4]/a")).click();
//	        test.pass("Personel Details Page - Skipped");
//	        //Thread.sleep(2000);
//	        driver.findElement(By.linkText("skip »")).click();
//	        test.pass("Payment Page - Skipped");
//	        Thread.sleep(2000);
//	        System.out.println("Payment Page Skipped");
//	      	        try{	        		        
//	       Alert leavePage=driver.switchTo().alert();
//	       leavePage.accept();
//	        }catch(Exception e)
//	        {
//	        	e.getMessage();
//	        }      
	}

	
}
	       	     
//Logout Action
//BussinessFunctions.Logout(driver,properties);
//Thread.sleep(4000);
//
//System.out.println("Logout Completed Successfully..");
//test.pass("Application Loged Out Successfully...");		
//	}
//		
	//	driver.close();

	                          


//	@AfterMethod
//    public void tearDown()
//    {
//    	driver.close();
//    }
//}
//

		
	


