package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.DailyMatchePage;
import utility.BaseTest;




	
	public class DailyMatches extends BaseTest{

		public static String baseurl;
		public static Properties properties,properties1,properties3;	
		
		public DailyMatches()throws Exception{
			
			properties=new Properties();
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
			properties.load(fis);
			properties1=new Properties();
			FileInputStream inbox = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\inbox.properties"));
			properties1.load(inbox);
			properties3=new Properties();
			FileInputStream fis2 = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\DailyMatch.properties"));
			properties3.load(fis2);
		}	
		/*@BeforeMethod
	    public void startUp()
	    {
	    	 System.setProperty("webdriver.gecko.driver", "C:\\Mohan\\geckodriver.exe");
	 		  driver = new FirefoxDriver();	
	    }
		  */

	@Test
		public  void loginTest() throws Exception{
		
		test=extent.createTest("DailyMatches -  Test");
		test.pass("Browser Opened ");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("login");
		for (int i=3; i<=3; i++) {
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
							//////////////////////////////////////////////////////////////
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
			
				 try {
					 
					 driver.findElement(By.xpath("(//a[@class='popupclose'])[2]")).click();
				 } catch (Exception e) {
					System.out.println("Accepted Interest pop up is not displayed	");
				}
			
			
			////////////////////////////////////////////////////////
				//	BussinessFunctions.intermidatePages(driver,properties);
								Thread.sleep(5000);
								test.pass("Intermidate Pages are closed...Successfully");
								System.out.println("Intermidate Pages are closed...");	
								
						//	BussinessFunctions.inboxMouseAction(driver, properties1);
					//		Thread.sleep(6000);
								//WebElement unreadSent=InboxPage.unreadSent_link(driver, properties1.getProperty("unreadSent_link"));
								//test.pass("UnRead Status in Sent Mail - Before Updation in DailyMatches : "+unreadSent.getText());
								Thread.sleep(5000);
								//Loop Starting..
								int count=0;
								for(int j=0;j<=0;j++)
								{
									Thread.sleep(5000);  
								
								//BussinessFunctions.dailyMatches_mouseOverAction(driver, properties3);
									
									
							//	driver.findElement(By.xpath(".//*[@id='topnav-login-menu']/div[2]/div[5]/a/span[2]")).click();
								test.pass(" Daily Match Page Testing Started");
								Thread.sleep(3000);
															
							//	DailyMatchePage.photo_link(driver, properties3.getProperty("photo_link")).click();
								
								js.executeScript("arguments[0].click();", driver.findElement(By.id("imgdiv1")));
							//	WebDriverWait wait = new WebDriverWait(driver, 30);
							//	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"imgdiv1\"]/img"))));
								//driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div")).click();
								System.out.println("Clicked");
								Thread.sleep(2000);
								
							//	WebElement matIDName=DailyMatchePage.matID_Name(driver, properties3.getProperty("matId"));
								//test.pass("MatId & Name : "+matIDName.getText()+"Count - "+j);
								test.pass("Clicked on Photo.......");
								DailyMatchePage.phtPage_liked_link(driver, properties3.getProperty("phtPage_liked_link")).click();
								Thread.sleep(3000);
								try{
								DailyMatchePage.phtPage_liked_cls1(driver, properties3.getProperty("phtPage_like_clsBtn1")).click();
								test.pass("liked link is working and send Interest");
								}catch(Exception e ){ e.getMessage(); }
								try{
									DailyMatchePage.phtPage_liked_cls2(driver, properties3.getProperty("phtPage_like_clsBtn2")).click();
								}catch(Exception e ){ e.getMessage(); 
								}
								
								Thread.sleep(2000);
								
								DailyMatchePage.photo_link(driver, properties3.getProperty("photo_link")).click();
								DailyMatchePage.phtPage_shtlisted_link(driver, properties3.getProperty("phtPage_shtlisted_link")).click();
								Thread.sleep(2000);
								js.executeScript("arguments[0].click();", driver.findElement(By.id("shortlistbottom")));
								Thread.sleep(2000);
								DailyMatchePage.phtPage_shtlisted_clsBtn(driver, properties3.getProperty("phtPage_shtlisted_clsBtn")).click();
														
								test.pass("ShotListed link is working and shortlist this memeber");
								//DailyMatchePage.photo_link(driver, properties3.getProperty("photo_link")).click();
								//DailyMatchePage.phtPage_sendEmail_link(driver, properties3.getProperty("phtPage_sendEmail_link")).click();
								//DailyMatchePage.phtPage_sendEmail_clsBtn(driver, properties3.getProperty("phtPage_sendEmail_clsBtn")).click();
								//Thread.sleep(2000);
								//test.pass("SendEmail link is working and sent Mail");
								
								//DailyMatchePage.photoPage_ClsBtn(driver, properties3.getProperty("photoPage_ClsBtn")).click();
								try{
								WebElement ageHgt=DailyMatchePage.ageHeight_text(driver, properties3.getProperty("ageHeight_text"));
								test.pass("Age & Height : "+ageHgt.getText());	
								}catch(Exception e){ e.getCause(); } 
								
								try{
								WebElement castDiv=DailyMatchePage.castDiv_text(driver, properties3.getProperty("castDiv_text"));
								test.pass("Cast & Division : "+castDiv.getText());
								}catch(Exception e){ e.getCause(); } 
								try{
								WebElement educationTxt=DailyMatchePage.education_text(driver, properties3.getProperty("education_text"));
								test.pass("Education : "+educationTxt.getText());
								}catch(Exception e) { e.getCause(); } 
								
								try{
																	
								WebElement subCast=DailyMatchePage.subCast_text(driver, properties3.getProperty("subCast_text"));
								test.pass("SubCast : "+subCast.getText());
								}catch(Exception e){ e.getMessage(); }
								WebElement locat=DailyMatchePage.location_text(driver, properties3.getProperty("location_text"));
								test.pass("locat : "+locat.getText());  
								
								Thread.sleep(3000);
								//DailyMatchePage.interested_yes_btn(driver, properties3.getProperty("interested_yes_btn")).click();
								//Thread.sleep(2000);
								/*try{
									
								DailyMatchePage.yes_btn_cls(driver, properties3.getProperty("yes_btn_cls")).click();
								test.pass(" Interest Request Sent - Updated Sent Mails ");
								}catch(Exception e) { e.getMessage(); } */
							
								try{
								DailyMatchePage.interested_skip_btn(driver, properties3.getProperty("interested_skip_btn")).click();
								}catch(Exception e) { e.getMessage(); }
								Thread.sleep(4000);
								/*WebElement visitMsg=DailyMatchePage.visit_TmrMsg(driver, properties3.getProperty("visitTmrMsg"));
								if(visitMsg.isDisplayed())
								{
									test.pass(visitMsg.getText());
								}*/
								
							//	BussinessFunctions.inboxMouseAction(driver, properties1);
							//	driver.findElement(By.id("senttab")).click();
								Thread.sleep(3000);
								//WebElement unreadSent2=InboxPage.unreadSent_link(driver, properties1.getProperty("unreadSent_link"));
								//test.pass("Unread Status in Sent Mail - After Updation in Daily Matches : "+unreadSent2.getText());
								count++;
								Thread.sleep(2000);
								
								}
								
								test.pass("Total No. of MatId's Testing : "+ count);   
								
								
								//////////////////////////////////////////////
								Thread.sleep(2000);
								driver.findElement(By.xpath("//*[@id=\"topnav-login-menu\"]/div[2]/div[3]")).click();
								
								Thread.sleep(2000);
								js.executeScript("arguments[0].click();", driver.findElement(By.id("senttab")));
							//	driver.findElement(By.id("senttab")).click();
								
								Thread.sleep(2000);
								List<WebElement> sent = driver.findElements(By.xpath("//div[@class='fleft ']"));
								for (int j = 0; j < sent.size(); j++) {
									String A = sent.get(j).getText();
									System.out.println("The Daily Matches Sent Interest ID's are " +A);
									
								}
								
								
								
								/////////////////////////////////////////////////////
								
								
								//loop Ending..
								Thread.sleep(3000);
								BussinessFunctions.dailyMatch_Logout(driver, properties);
					Thread.sleep(2000);
					
					System.out.println("Logout Completed Successfully..");
					test.pass("Application LogedOut Successfully...");				
				}		
//		driver.close();
			}
	



	}






