package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import utility.BaseTest;

public class PaymentPageScenario2 extends BaseTest{
	public static String baseurl;
	public static Properties properties,properties5;
	public WebElement readRep;
	
	
	public PaymentPageScenario2()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
		properties.load(fis);
		
	}	
	/*@BeforeMethod
    public void startUp()
    {
    	 System.setProperty("webdriver.gecko.driver", "C:\\Mohan\\geckodriver.exe");
 		  driver = new FirefoxDriver();	
    }
	  */
	
	

@Test
	public  void paymentTest() throws Exception{
	
	test=extent.createTest("Payment Test Scenario-2");
	test.pass("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("LoginTestData");
		for (int i = 9; i <=9; i++) {
			baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
			
			driver.navigate().to(baseurl);	
			test.pass("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			String username = sheet1.getRow(i).getCell(1).getStringCellValue();
			String password = sheet1.getRow(i).getCell(2).getStringCellValue();
			test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
			test.pass("UserName is Valid :"+username);
			test.pass("Password is Valid : *******");	
			//driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			BussinessFunctions.login(driver,properties, username, password);
			Thread.sleep(2000);
			test.pass("Login Button Clicked");						
			System.out.println("Login Successfully...");												
															
										BussinessFunctions.intermidatePages(driver,properties);
							Thread.sleep(3000);
							test.pass("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");								    																		
																												
							
							
							//Scenario-2 through addPhoto Menu
							BussinessFunctions.upgradeAccounts_LogoutMenu(driver, properties);
							Thread.sleep(3000);
							test.info("Scenario-2 Through Upgrade in Menu Bar....");
							String parent=driver.getWindowHandle();
							 System.out.println("Parent Window ID is  "+parent);
							 Thread.sleep(1000);
					
							
							Set<String> winHandles=driver.getWindowHandles();
							int count=winHandles.size();
							System.out.println("Window Count is : "+count);
							for (String winHandle : winHandles) { 
							    driver.switchTo().window(winHandle);
							    // switch focus of WebDriver to the next found window handle (that's your newly opened window)
							    System.out.println("window Handle Id :"+winHandle);
							    Thread.sleep(3000);
							}
						
									BussinessFunctions.selectOfferAmount_gold6Months(driver);	
															
							test.pass("Membership Plan Offer Button Clicked");	
													
							BussinessFunctions.addOnPacks(driver);
							WebDriverWait wait = new WebDriverWait(driver, 20);	
							test.pass("AddOn Packs Selected");
						
							try{
							WebElement offerAmountElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div[5]/div[2]/div[1]")));
							String offerAmount=offerAmountElement.getText();
							test.pass("MemeberShip Offer Amount : "+offerAmount);
							WebElement addOnPacks_ProfileHilighterElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content_120']/div")));
							String addOnPacks1_ProfileHighlighter=addOnPacks_ProfileHilighterElement.getText();
							test.pass("AddOnPacks : "+addOnPacks1_ProfileHighlighter);
						
							WebElement addOnPacks_TopPlacmentElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content_125']/div")));	
							String addOnPacks1_TopPlacement=addOnPacks_TopPlacmentElement.getText();
							test.pass("AddOnPacks : "+addOnPacks1_TopPlacement);
						
							WebElement addOnPacks_AstroMatchElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content_111']/div")));	
							String addOnPacks1_AstroMatch=addOnPacks_AstroMatchElement.getText();
							test.pass("AddOnPacks: "+addOnPacks1_AstroMatch);
							
							//Special Check Out offer
							WebElement addOnPacks_SpecialOfferEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='splCheckoutAddon']/div/div[1]/div")));	
							String addOnPacks1_SpecialOffer=addOnPacks_SpecialOfferEle.getText();
							test.pass("AddOnPacks- Special CheckOut Offer : "+addOnPacks1_SpecialOffer);
							
							//total saving worth
							WebElement totalSavingWorthEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='no_save_worth']/span")));	
							String totalSavingWorth=totalSavingWorthEle.getText();
							test.pass("AddOnPacks- Total Saving Worth : "+totalSavingWorth);
														
							WebElement addOnPacks_TotalAmountEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div[5]/div[2]/div[6]/span")));	
							String addOnPacks_TotalAmount=addOnPacks_TotalAmountEle.getText();
							test.pass("AddOnPacks- Total Amount : "+addOnPacks_TotalAmount);
							}catch(Exception e ){ e.getMessage(); }
							
							Thread.sleep(2000);
							
							BussinessFunctions.netBanking_Actions(driver);
							
							driver.close();
	                        driver.switchTo().window(parent);
												
						BussinessFunctions.Logout(driver,properties);

			            Thread.sleep(2000);
			            System.out.println("Successfully logged out ");
			            test.pass("Application Logged Out Successfully...");							 
																		
							
														
}

}
}
