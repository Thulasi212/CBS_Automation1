package testscripts;


	


	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.KeyWordSearch;
import utility.BaseTest;


	public class KeyWordSearchTest  extends BaseTest {
		public static String baseurl;
		public static Properties properties,propertiesz;
		
		
		public KeyWordSearchTest()throws Exception{
			
			properties=new Properties();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
			properties.load(fis);
			
			propertiesz=new Properties();
			FileInputStream fiss=new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\KeySearch.properties"));
			propertiesz.load(fiss);
		}	
		
	@Test
		public  void loginTest() throws Exception{
		
		test=extent.createTest("KeyWord Search - Test");
		test.pass("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("login");
		Sheet searchs=workbook.getSheet("search");
		
		for (int i=12; i<=12; i++) {
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
								test.pass("Domain Name====>"+domain);							
								System.out.println("====>"+domain);						
							
							try{												
								WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));	
																										
								if(suspendid.isDisplayed()){    
									test.pass("This ID was Blocked/Suspended");
								break;
															}
							}catch(Exception e){ e.getMessage(); }						
								
							//	BussinessFunctions.intermidatePages(driver,properties);
								Thread.sleep(6000);
								////////////////////////////////////////////////////////////
								try {
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
								//////////////////////////////////////////////////////////////
								test.pass("Intermidate Pages are closed...Successfully");
								System.out.println("Intermidate Pages are closed...");					
									
								//RegularSearch.....	
								BussinessFunctions.keywordSearchMouseAction(driver, propertiesz);
								Thread.sleep(1000);
								
								test.info("KeyWord Search Testing Started.....");
								
								WebElement ageFrom=KeyWordSearch.ageFroms(driver, propertiesz.getProperty("ageFrom"));
								Select ageFr=new Select(ageFrom);
								ageFr.selectByIndex(1);
								test.pass("Age From : "+ageFr.getFirstSelectedOption().getText());
								
								WebElement ageTo=KeyWordSearch.ageTos(driver, propertiesz.getProperty("ageTo"));
								Select ageto=new Select(ageTo);
								ageto.selectByIndex(20);
								test.pass("Age To : " + ageto.getFirstSelectedOption().getText());
								
								WebElement heightFrom=KeyWordSearch.heightFroms(driver, propertiesz.getProperty("heightFrom"));
								Select heightFr=new Select(heightFrom);
								heightFr.selectByIndex(11);
								test.pass("heightFrom : "+heightFr.getFirstSelectedOption().getText());
								
								WebElement heightTo=KeyWordSearch.heightTos(driver, propertiesz.getProperty("heightTo"));
								Select heightto=new Select(heightTo);
								heightto.selectByIndex(21);
								test.pass("heightTo : "+heightto.getFirstSelectedOption().getText());
								Thread.sleep(2000);
								
							//	WebElement mstatus=KeyWordSearch.martialStatus_any(driver, propertiesz.getProperty("martialStatus_Any_chBox"));
							//	mstatus.click();
								test.pass("Martial Status : Selected");
								Thread.sleep(1000);
								try{
								WebElement dosham=KeyWordSearch.dosham_doesntMatter(driver, propertiesz.getProperty("Dosham_NotMatter_radio"));
								dosham.click();
								test.pass("Dosham : Selected ");
								Thread.sleep(2000);}catch(Exception e) { e.getCause(); }
								
								KeyWordSearch.keywordSearch_Text(driver, propertiesz.getProperty("keyWordSearch_Text")).sendKeys("Tamil");
								
								KeyWordSearch.showProfilesWith_Photos(driver,propertiesz.getProperty("showProfilesWith_photo_chBox")).click();
								test.pass("Show Profiles With Photo - Selected");
								Thread.sleep(3000);
								
								
							/*	KeyWordSearch.dontShow_Contacted(driver, propertiesz.getProperty("DontShowContacted_chBox")).click();
								KeyWordSearch.dontShow_Viewed(driver, propertiesz.getProperty("DontShowViewd_chBox")).click();
								KeyWordSearch.dontShow_shortlisted(driver, propertiesz.getProperty("DontShowShortlisted_chBox")).click();
								KeyWordSearch.dontShow_blocked(driver, propertiesz.getProperty("DontShowBlocked_chBox")).click();
								KeyWordSearch.dontShow_ignored(driver, propertiesz.getProperty("DontShowIgnored_chBox")).click();
								test.pass("Don't Show - Contacted,Viewed,Shortlisted,Blocked and Ignored  Profiles : Selected");*/
								Thread.sleep(3000);
								
								KeyWordSearch.search_btn(driver, propertiesz.getProperty("Search_btn")).click();
								
								
								test.pass("search button clicked");
								
								Thread.sleep(4000);
								
								BussinessFunctions.cmLogout(driver,properties);
						Thread.sleep(2000);
						
						System.out.println("Logout Completed Successfully..");
						test.pass("Application LogedOut Successfully...");			
					}	
	//	driver.close();
	}
	}



