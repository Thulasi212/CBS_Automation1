package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.AdvSearchPage;
import utility.BaseTest;



public class AdvSearchTest extends BaseTest {
	public static String baseurl;
	public static Properties properties,propertiesy;
	
	
	public AdvSearchTest()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
		properties.load(fis);
		
		propertiesy=new Properties();
		FileInputStream fiss=new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\AdvSearch.properties"));
		propertiesy.load(fiss);
	}	
	
@Test
	public  void loginTest() throws Exception{
	
	test=extent.createTest("AdvancedSearch - Test");
	test.info("Browser Opened ");

	FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet1 = workbook.getSheet("login");
	//Sheet searchs=workbook.getSheet("search");
	
	for (int i=3; i<=3; i++) {
		baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
		driver.navigate().to(baseurl);	
		test.info("Application Launched Successfully");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		String username = sheet1.getRow(i).getCell(1).getStringCellValue();
		String password = sheet1.getRow(i).getCell(2).getStringCellValue();
		test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
		test.info("UserName is Valid :"+username);
		test.info("Password is Valid : *******");						
		BussinessFunctions.login(driver,properties, username, password);
		Thread.sleep(1000);
		test.pass("Login Button Clicked");						
		System.out.println("Login Successfully...");															
																					
							String domain=driver.getCurrentUrl();							
							test.pass("Domain Name====>"+domain);							
							System.out.println("====>"+domain);						
					//////////////////////////////////////////////////////////////////////////////////	
						try{												
							WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));	
																									
							if(suspendid.isDisplayed()){    
								test.pass("This ID was Blocked/Suspended");
							break;
														}
						}catch(Exception e){ e.getMessage(); }		
						Thread.sleep(1000);
						try {
							WebElement mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"));
							
							if (mobile_verify.isDisplayed()) {
								//test.pass("This ID need to verify Mobile Number");
								break;
								
							}
							
							
						} catch (Exception e) {
							e.getMessage();
						} 
						
						Thread.sleep(1000);
						try {
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
							
						Thread.sleep(1000);
							try {
								WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
								if (skip_matches.isDisplayed()) {
									skip_matches.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							Thread.sleep(1000);
							try {
								WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
								if (element.isDisplayed()) {
									element.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							Thread.sleep(1000);
							try {
								WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
								if (divorcee_intermediate_skip.isDisplayed()) {
									divorcee_intermediate_skip.click();
									
								}
							} catch (Exception e) {
								System.out.println("Intermediate pages handled");
							}
							
							
							// AD Pages
							Thread.sleep(1000);
							 try {
								 driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
							} catch (Exception e) {
								System.out.println("ADs Closed Successfully");
							}
						/////////////////////////////////////////////////////////////////////////////////	
						//	BussinessFunctions.intermidatePages(driver,properties);
							Thread.sleep(4000);
							test.pass("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");					
								
							//Advanced Search.....	
							BussinessFunctions.advancedSearchMouseAction(driver, propertiesy);
							Thread.sleep(1000);
							
							WebElement agefrom = AdvSearchPage.ageFrom(driver, propertiesy.getProperty("ageFr"));
							Select ageFrom=new Select(agefrom);
							ageFrom.selectByIndex(2);
							test.pass("Age From : "+ageFrom.getFirstSelectedOption().getText());
														
							WebElement ageto = AdvSearchPage.ageTo(driver, propertiesy.getProperty("ageTo"));
							Select ageTo=new Select(ageto);
							ageTo.selectByIndex(20);
							test.pass("Age To : "+ageTo.getFirstSelectedOption().getText());
							
							WebElement heightfrom= AdvSearchPage.heightFrom(driver, propertiesy.getProperty("heightFr"));
							Select heightFrom=new Select(heightfrom);
							heightFrom.selectByIndex(6);
							test.pass("heightfrom : "+heightFrom.getFirstSelectedOption().getText());
							
							WebElement heightto = AdvSearchPage.heightTo(driver, propertiesy.getProperty("heightTo"));
							Select heightTo=new Select(heightto);
							heightTo.selectByIndex(16);
							test.pass("heightto : "+heightTo.getFirstSelectedOption().getText());
							
							
							Thread.sleep(1000);
							WebElement martialStatus=AdvSearchPage.martialStatus_any(driver, propertiesy.getProperty("martial_any_chBox"));
							martialStatus.click();
							Thread.sleep(2000);
							martialStatus.click();
							/*
					
							WebElement caste=driver.findElement(By.xpath(".//*[@id='casteTemp']"));
							Select s1=new Select(caste);
							List<WebElement> dropdownvaluescount1=s1.getOptions();
							 for(int x=0;x<dropdownvaluescount1.size();x++)
							 {
								 String value = dropdownvaluescount1.get(x).getText();
								 System.out.println(value);
							 }
							
							 WebElement subcaste=driver.findElement(By.xpath(".//*[@id='casteTemp']"));
								Select s2=new Select(subcaste);
								List<WebElement> dropdownvaluescount2=s2.getOptions();
								 for(int x=0;x<dropdownvaluescount2.size();x++)
								 {
									 String value = dropdownvaluescount2.get(x).getText();
									 System.out.println(value);
								 }
							
							AdvSearchPage.cast_Box(driver, propertiesy.getProperty("cast_box")).click();
							WebElement castOption=AdvSearchPage.cast_options(driver,propertiesy.getProperty("cast_option"));
							Actions castOptions=new Actions(driver);
							Thread.sleep(2000);
							castOptions.doubleClick(castOption).build().perform();
							Thread.sleep(2000);
							test.pass("Cast : Selected ");
							
							AdvSearchPage.subCast_box(driver, propertiesy.getProperty("subCast_box")).click();
							WebElement subcastOption=AdvSearchPage.subcast_options(driver,propertiesy.getProperty("subCast_option"));
							Actions subcastOptions=new Actions(driver);
							subcastOptions.doubleClick(subcastOption).build().perform();						
							Thread.sleep(2000);
							test.pass("SubCast : Selected");
							
							AdvSearchPage.motherTongue_box(driver, propertiesy.getProperty("motherTongue_box")).click();
							WebElement mTongueOption=AdvSearchPage.motherTOngue_options(driver,propertiesy.getProperty("motherTOngue_option"));
							Actions mTongueOptions=new Actions(driver);
							Thread.sleep(2000);
							mTongueOptions.doubleClick(mTongueOption).build().perform();
							Thread.sleep(5000);
							test.pass("MotherTongue : Selected");
							
							//AdvSearchPage.physicalStatus_Doesnot(driver, propertiesy.getProperty("physicalStatus_DoesNot_radio")).click();
							
							/*AdvSearchPage.gothra_box(driver, propertiesy.getProperty("gothram_box")).click();
							WebElement gothraOption=AdvSearchPage.gothra_options(driver,propertiesy.getProperty("gothram_option"));
							Actions gothraOptions=new Actions(driver);
							Thread.sleep(2000);
							gothraOptions.doubleClick(gothraOption).build().perform();
							Thread.sleep(4000);
							test.pass("Gothram : Selected");
							
							AdvSearchPage.star_box(driver, propertiesy.getProperty("star_box")).click();
							WebElement starOption=AdvSearchPage.star_options(driver,propertiesy.getProperty("star_option"));
							Actions starOptions=new Actions(driver);
							Thread.sleep(4000);
							starOptions.doubleClick(starOption).build().perform();
							Thread.sleep(2000);
							test.pass("Star : Selected");
							
							//AdvSearchPage.dosham_doesnot(driver,propertiesy.getProperty("dosham_doesnot_radio")).click();
							
							AdvSearchPage.country_box(driver, propertiesy.getProperty("country_Box")).click();
							WebElement countryOption=AdvSearchPage.country_option(driver, propertiesy.getProperty("country_option"));
							Actions countryOptions=new Actions(driver);
							countryOptions.doubleClick(countryOption).build().perform();
							Thread.sleep(6000);
							
							AdvSearchPage.state_box(driver, propertiesy.getProperty("state_box")).click();
							WebElement stateOption=AdvSearchPage.state_options(driver, propertiesy.getProperty("state_option"));
							Actions stateOptions=new Actions(driver);
							Thread.sleep(5000);
							stateOptions.doubleClick(stateOption).build().perform();
							Thread.sleep(2000);
							test.pass("State : Selected");
							
							residential_any(driver, propertiesy.getProperty("resident_any_radio")).click();		
							test.pass("Residential Status : Selected");
							
							/*AdvSearchPage.education_box(driver, propertiesy.getProperty("education_box")).click();
							WebElement eduOption=AdvSearchPage.education_options(driver, propertiesy.getProperty("education_option"));
							Actions eduOptions=new Actions(driver);
							eduOptions.doubleClick(eduOption).build().perform();
							Thread.sleep(3000);
							
							AdvSearchPage.occupation_box(driver, propertiesy.getProperty("occup_box")).click();
							WebElement occupOption=AdvSearchPage.occupation_options(driver, propertiesy.getProperty("occup_option"));
							Actions occupOptions=new Actions(driver);
							Thread.sleep(2000);
							occupOptions.doubleClick(occupOption).build().perform();
							Thread.sleep(2000);
							test.pass("Occupation : Selected");*/
							
							//driver.findElement(By.xpath(".//*[@id='casteTemp']")).click();
						/*	WebElement castElement =driver.findElement(By.xpath(".//*[@id='casteTemp']/option[1]"));
							Actions castaction=new Actions(driver);
							castaction.moveToElement(castElement).doubleClick().build().perform();  
							Thread.sleep(2000);  */
							
							//driver.findElement(By.xpath(".//*[@id='subcasteTemp']")).click();
							WebElement subcastElement =driver.findElement(By.xpath("//*[@id=\"subcasteTemp\"]/option[2]"));
							String A = subcastElement.getText();
							Actions subcastaction=new Actions(driver);
							subcastaction.doubleClick(subcastElement).build().perform();
							System.out.println(A);
							Thread.sleep(2000);
							
							//driver.findElement(By.xpath(".//*[@id='motherTongueTemp']")).click();
							WebElement motherTongElement =driver.findElement(By.xpath(".//*[@id='motherTongueTemp']/option[1]"));
							String B = motherTongElement.getText();
							Actions motherTongueaction=new Actions(driver);
							motherTongueaction.doubleClick(motherTongElement).build().perform();
							System.out.println(B);
							Thread.sleep(2000);
							
							
							WebElement annualIncome=AdvSearchPage.annualIncomes(driver,propertiesy.getProperty("annualIncomes"));
							Select annIncome=new Select(annualIncome);
							annIncome.selectByIndex(5);		
							test.pass("Annual Income  : "+annIncome.getFirstSelectedOption().getText());
							
							AdvSearchPage.eatichHabits_any(driver, propertiesy.getProperty("eatinghabits_any_chBox")).click();
							AdvSearchPage.drinking_Light(driver,propertiesy.getProperty("driniking_Light_Chbox")).click();
							AdvSearchPage.smoking_Non(driver, propertiesy.getProperty("smoking_Non_Chbox")).click();
							test.pass("Eating,Drinking,Smoking Habits : Selected");
							
							AdvSearchPage.showProfiles_Photo(driver, propertiesy.getProperty("showProfiles_photo")).click();
							
							AdvSearchPage.search_btn(driver, propertiesy.getProperty("search_btn")).click();
							test.pass("Search Button Clicked");
							Thread.sleep(4000);
							BussinessFunctions.cmLogout(driver,properties);
					Thread.sleep(4000);
					
					System.out.println("Logout Completed Successfully..");
					test.pass("Application LogedOut Successfully...");				
				}		
	//driver.close();

}

}
