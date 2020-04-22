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
import pages.Matches;
import utility.BaseTest;



public class MatchesTest extends BaseTest{
	
	public static String baseurl;
	public static Properties properties,properties5;
	public WebElement readRep;
	
	
	public MatchesTest()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
		properties.load(fis);
		properties5=new Properties();
		FileInputStream inboxs = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Matches.properties"));
		properties5.load(inboxs);
	}	
	/*@BeforeMethod
    public void startUp()
    {
    	 System.setProperty("webdriver.gecko.driver", "C:\\Mohan\\geckodriver.exe");
 		  driver = new FirefoxDriver();	
    }
	  */

@Test
	public  void inboxTest() throws Exception{
	
	test=extent.createTest("Inbox Test");
	test.info("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("Inbox");
		for (int i = 3; i <=3; i++) {
			baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
			driver.navigate().to(baseurl);	
			test.info("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			String username = sheet1.getRow(i).getCell(1).getStringCellValue();
			String password = sheet1.getRow(i).getCell(2).getStringCellValue();
			test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
			test.info("UserName is Valid :"+username);
			test.info("Password is Valid : *******");						
			BussinessFunctions.login(driver,properties, username, password);
			Thread.sleep(2000);
			test.info("Login Button Clicked");						
			System.out.println("Login Successfully...");												
															
										//BussinessFunctions.intermidatePages(driver,properties);
			/////////////////////////////////////////////////////////////////////////////////////////////////
			try {
				WebElement mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"));
				
				if (mobile_verify.isDisplayed()) {
					//test.pass("This ID need to verify Mobile Number");
					break;
					
				}
				
				
			} catch (Exception e) {
				e.getMessage();
			} 
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
			
			//////////////////////////////////////////////////////////////////////////////////////////////////
							Thread.sleep(3000);
							test.info("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");										    																		
												
							BussinessFunctions.matches_PPmouseAction(driver, properties);
							Thread.sleep(4000);
							test.pass("PartnerPreference Page Testing Started...");
							
							
							Thread.sleep(2000);
							driver.findElement(By.cssSelector("#show_partner > a")).click();
							
						//	Thread.sleep(2000);
						//	Matches.martialStatus_ChBox(driver, properties5.getProperty("martialStatus_ChBox")).click();
							Thread.sleep(2000);
							
							WebElement ageFrom=Matches.ageFroms(driver, properties5.getProperty("age_from_ddown"));
							Select ageFr = new Select(ageFrom);
							ageFr.selectByIndex(6);
							Thread.sleep(2000);

							WebElement ageTo=Matches.ageFroms(driver, properties5.getProperty("age_to_ddown"));
							Select ageToo = new Select(ageTo);
							ageToo.selectByIndex(15);
							Thread.sleep(2000);
							
							
							WebElement hgtFrom=Matches.ageFroms(driver, properties5.getProperty("height_from_ddown"));
							Select hgtFr = new Select(hgtFrom);
							hgtFr.selectByIndex(6);
							
							WebElement hgtTo=Matches.ageFroms(driver, properties5.getProperty("height_to_ddown"));
							Select hgtToo = new Select(hgtTo);
							hgtToo.selectByIndex(13);
							
						//	Matches.phyStatus(driver, properties5.getProperty("physicalStatus_radio")).click();
							driver.findElement(By.xpath("//*[@id=\"physicalStatus0\"]")).click();
							test.pass("PhysicalStatus : Selected ");
							
							//WebElement motherTong=Matches.motherTongues(driver, properties5.getProperty("motherTong_ddown"));
						//	motherTong.click();
							Thread.sleep(3000);
							WebElement motherTong = driver.findElement(By.id("motherTongue"));
							Select mtong=new Select(motherTong);
							mtong.selectByIndex(15);
						try {	
							WebElement cast=Matches.castes(driver, properties5.getProperty("caste_ddown"));
							cast.click();
							Select caste=new Select(cast);
							caste.selectByIndex(5);
						} catch (Exception e) {
							System.out.println("No caste field");
						}
							WebElement subcast=Matches.subCaste(driver, properties5.getProperty("subcaste_ddown"));
						//	subcast.click();
							Select subcaste=new Select(subcast);
							subcaste.selectByIndex(5);
							
							WebElement star=Matches.stars(driver, properties5.getProperty("star_ddown"));
					//		star.click();
							Select stars=new Select(star);
							stars.selectByIndex(5);
							try {
							WebElement gothram=Matches.gothras(driver, properties5.getProperty("gothra_ddown"));
						//	gothram.click();
							Select gothrams=new Select(gothram);
							gothrams.selectByIndex(5);
							} catch (Exception e) {
								System.out.println("No Dosham field");
							}
							driver.findElement(By.id("manglik3")).click();
							//Matches.mangliks(driver, properties5.getProperty("Manglik_radio")).click();
							test.pass("Mangliks : Selected ");
						//	Matches.educations(driver, properties5.getProperty("education")).click();
							driver.findElement(By.id("educationTempradio2")).click();
							test.pass("Education : Selected ");
							WebElement occupation=Matches.occupations(driver, properties5.getProperty("occupation_ddown"));
							//occupation.click();
							Select occupations=new Select(occupation);
							occupations.selectByIndex(5);
							
							WebElement citizenship=Matches.citizenships(driver, properties5.getProperty("citizenship_ddown"));
						//	citizenship.click();
							Select citizen=new Select(citizenship);
							citizen.selectByIndex(5);
							
							WebElement country=Matches.countryLivingIn(driver, properties5.getProperty("countryLivingin_ddown"));
						//	country.click();
							Select count=new Select(country);
							count.selectByIndex(5);
							try {
								WebElement residing_state = driver.findElement(By.id("residingIndia"));
								Select state = new Select(residing_state);
								state.selectByIndex(15);
								
								Thread.sleep(2000);
								WebElement residing_city = driver.findElement(By.id("residingIndia"));
								Select city = new Select(residing_city);
								city.selectByIndex(15);
							} catch (Exception e) {
								System.out.println("Not residing in India");
							}
							
						//	Matches.foodHabits(driver, properties5.getProperty("FoodHabits_chBox")).click();
							driver.findElement(By.id("eatingHabits0")).click();
						//	Matches.smokingHabits(driver, properties5.getProperty("smokingHabits_chBox")).click();
							driver.findElement(By.id("smokingHabits1")).click();
						//	Matches.drinkingHabits(driver, properties5.getProperty("drinkingHabits_chBox")).click();
							driver.findElement(By.id("drinkingHabits1")).click();
						
							try {
								WebElement Annual_income = driver.findElement(By.id("fromIncomeINR"));
								Select income = new Select(Annual_income);
								income.selectByIndex(0);
							} catch (Exception e) {
								System.out.println("No Annual Income field");
							}
							
							Matches.saveBtn(driver, properties5.getProperty("ppsave_btn")).click();
							
							Thread.sleep(3000);
							//driver.findElement(By.)
							
						//	WebElement successMessage=Matches.successMsg(driver, properties5.getProperty("sucessMessage"));
						//	test.pass(successMessage.getText());
													
							//Matches Page...
							
							
							
}
}
	

}
