package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.Search;
import utility.BaseTest;



public class RegularSearch extends BaseTest{
	
	public static String baseurl;
	public static Properties properties,propertiesX;
	
	
	public RegularSearch()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
		properties.load(fis);
		
		propertiesX=new Properties();
		FileInputStream fiss=new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\regSearch.properties"));
		propertiesX.load(fiss);
	}	
	
@Test
	public  void loginTest() throws Exception{
	
	test=extent.createTest("RegularSearch - Test");
	test.info("Browser Opened ");

	FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet1 = workbook.getSheet("login");
	Sheet search=workbook.getSheet("search");
	
	for (int i=5; i<=5; i++) {
		baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
		driver.navigate().to(baseurl);	
		test.pass("Application Launched Successfully");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		String username = sheet1.getRow(i).getCell(1).getStringCellValue();
		String password = sheet1.getRow(i).getCell(2).getStringCellValue();
		test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
		test.pass("UserName is Valid :"+username);
		test.pass("Password is Valid : *******");						
		BussinessFunctions.login(driver,properties, username, password);
		Thread.sleep(1000);
		test.pass("Login Button Clicked");						
		System.out.println("Login Successfully...");															
																					
							String domain=driver.getCurrentUrl();							
							test.info("Domain Name====>"+domain);							
							System.out.println("====>"+domain);						
						
						try{												
							WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));	
																									
							if(suspendid.isDisplayed()){    
								test.pass("This ID was Blocked/Suspended");
							break;
														}
						}catch(Exception e){ e.getMessage(); }						
						
							BussinessFunctions.intermidatePages(driver,properties);
						Thread.sleep(6000);
						////////////////////////////////////////////////////////////
				/*		try {
							WebElement mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"));
							
							if (mobile_verify.isDisplayed()) {
								//test.pass("This ID need to verify Mobile Number");
								break;
								
							}
							
							
						} catch (Exception e) {
							e.getMessage();
						}  try {
								WebElement photo_add = driver.findElement(By.xpath("/html/body/div[2]/a"));
								if (photo_add.isDisplayed()) {
									photo_add.click();
									driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]")).click();
									driver.findElement(By.xpath("//*[@id=\"reason3\"]")).click();
									driver.findElement(By.xpath("//*[@id=\"skipphotoclick\"]")).click();
									
								}
								
							} catch (Exception e) {
								System.out.println("Photo Page Skipped");
							}
							
							
							try {
								WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
								if (skip_matches.isDisplayed()) {
									skip_matches.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							
							try {
								WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
								if (element.isDisplayed()) {
									element.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							
							try {
								WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
								if (divorcee_intermediate_skip.isDisplayed()) {
									divorcee_intermediate_skip.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							
							
							// AD Pages
							 
							 try {
								 driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
							} catch (Exception e) {
								System.out.println("ADs Closed Successfully");
							}
						
							 try {
								 
								 driver.findElement(By.xpath("(//a[@class='popupclose'])[2]")).click();
							 } catch (Exception e) {
								System.out.println("Accepted Interest pop up is not displayed	");
							}
						*/
						
						////////////////////////////////////////////////////////
											
							Thread.sleep(6000);
							test.pass("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");					
								
							//RegularSearch.....	
							BussinessFunctions.RegularSearchMouseAction(driver, propertiesX);
							Thread.sleep(3000);
														
		String agefrom = search.getRow(i).getCell(0).getStringCellValue();
		WebElement ageFrms=	Search.ageFroms(driver, propertiesX.getProperty("ageFrom"));
		Select ageFrm = new Select(ageFrms);
		ageFrm.selectByVisibleText(agefrom);
		
		Thread.sleep(2000);
		
		String ageto = search.getRow(i).getCell(1).getStringCellValue();
		WebElement ageTos=	Search.ageTos(driver, propertiesX.getProperty("ageTo"));
		Select ageTo = new Select(ageTos);
		ageTo.selectByVisibleText(ageto);	
		Thread.sleep(2000);
		String heightFroms = search.getRow(i).getCell(2).getStringCellValue();
		WebElement heightfrom=	Search.heightFroms(driver, propertiesX.getProperty("heigtFrom"));
		Select heightFrm = new Select(heightfrom);
		heightFrm.selectByVisibleText(heightFroms);	
		
		Thread.sleep(2000);
		String heightto = search.getRow(i).getCell(3).getStringCellValue();
		WebElement heightTos=Search.heightTos(driver, propertiesX.getProperty("heightTo"));
		Select heightToo = new Select(heightTos);
		heightToo.selectByVisibleText(heightto);	
		Thread.sleep(2000);
		
			WebElement martialstatus1=Search.martialStatus_Any_chBoxs(driver, propertiesX.getProperty("martialStatus_Any_chBox"));
		martialstatus1.click();
		Thread.sleep(1000);
		WebElement martialstatus2=Search.martialStatu_UnMarried_chBoxs(driver, propertiesX.getProperty("martialStatu_UnMarried_chBox"));
		martialstatus2.click();
		Thread.sleep(1000);
			
				try{
		WebElement noOfChild=Search.noOfChildrens(driver, propertiesX.getProperty("noofChildrens"));
		noOfChild.click();
		Thread.sleep(1000);
		}catch(Exception e ){ e.getMessage(); } 
			try{								
		WebElement cast=Search.cast_ScrollBoxs(driver, propertiesX.getProperty("cast_ScrollBox"));
		cast.click();
		WebElement option1=Search.cast_options(driver, propertiesX.getProperty("cast_click"));
		Actions castact=new Actions(driver);
		castact.doubleClick(option1).build().perform();
			}catch(Exception e ){ e.getMessage(); }
										
		Thread.sleep(1000);
			try{
		WebElement subcast=Search.subCast_ScrollBoxs(driver, propertiesX.getProperty("subcast_Scroll"));
		subcast.click();
		WebElement option2= Search.subCast_doubleClicks(driver,propertiesX.getProperty("subcast_click"));
		Actions subcastact=new Actions(driver);
		subcastact.doubleClick(option2).build().perform();
			}catch(Exception e){ e.getMessage(); }
				
		Thread.sleep(1000);
						
		WebElement mtongue=Search.motherTongue_doubleClicks(driver, propertiesX.getProperty("motherTongue_scroll"));
		mtongue.click();
		Actions mtone=new Actions(driver);
		WebElement option3=Search.motherTongue_scrollBoxs(driver, propertiesX.getProperty("motherTongue_click"));
		mtone.doubleClick(option3).build().perform();
		
		Thread.sleep(3000);
		
		try{
		
		WebElement country=Search.countr_scrollBoxs(driver, propertiesX.getProperty("country_scroll"));
		country.click();
				Actions country1=new Actions(driver);
				WebElement option4=Search.countr_doubleClick(driver, propertiesX.getProperty("country_click"));
		country1.doubleClick(option4).build().perform();
		}
		catch(Exception e) { e.getMessage(); }
			Thread.sleep(3000);
			
		try{
		WebElement educ=Search.education_doubleClicks(driver, propertiesX.getProperty("educations"));
		educ.click();
		Actions edu=new Actions(driver);
		WebElement option5=Search.education_scrollBoxs(driver, propertiesX.getProperty("education_click"));
		edu.doubleClick(option5).build().perform();
			}catch(Exception e) { e.getMessage(); } 
				Thread.sleep(2000);
			
		WebElement showProfilesWith=Search.showProfilesWith_Photo_chBoxs(driver, propertiesX.getProperty("showProfilesWith_Photo_chBox"));
		showProfilesWith.click();
		Thread.sleep(1000);		 
						
		WebElement profilesBlocked=Search.martialStatus_Any_chBoxs(driver, propertiesX.getProperty("showProfilesWith_Photo_chBox"));
		profilesBlocked.click();
		Thread.sleep(1000);
		
		WebElement profilesIgnored=Search.martialStatus_Any_chBoxs(driver, propertiesX.getProperty("showProfilesWith_Photo_chBox"));
		profilesIgnored.click();
		Thread.sleep(1000);
						
		WebElement search_btn=Search.search_btn(driver, propertiesX.getProperty("search_btn"));
		search_btn.click();
		Thread.sleep(3000);
		
						BussinessFunctions.Logout(driver, properties);
				Thread.sleep(4000);
				
				System.out.println("Logout Completed Successfully..");
				test.pass("Application LogedOut Successfully...");				
			}	
	//driver.close();

}

}
