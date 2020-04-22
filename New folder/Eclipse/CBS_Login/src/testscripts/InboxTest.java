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
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.InboxPage;
import utility.BaseTest;

public class InboxTest extends BaseTest {
	public static String baseurl;
	public static Properties properties,properties1;
	public WebElement readRep;
	
	
	public InboxTest()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
		properties.load(fis);
		properties1=new Properties();
		FileInputStream inbox = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\inbox.properties"));
		properties1.load(inbox);
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
	
	test=extent.createTest("Communication Module Test");
	test.info("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("login");
		for (int i = 34; i <=34; i++) {
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
			BussinessFunctions.cmLogin(driver,properties, username, password);
			Thread.sleep(2000);
			test.info("Login Button Clicked");						
			System.out.println("Login Successfully...");												
															
									//	BussinessFunctions.intermidatePages(driver,properties);
							Thread.sleep(2000);
							try {
								WebElement suspendid = driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));

								if (suspendid.isDisplayed()) {
									test.pass("This ID was Blocked/Suspended");
									break;
								}
							} catch (Exception e) {
								e.getMessage();
							}
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
								e.getMessage();
							}
							
							
							try {
								WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
								if (skip_matches.isDisplayed()) {
									skip_matches.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							try {
								WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
								if (element.isDisplayed()) {
									element.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							try {
								WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
								if (divorcee_intermediate_skip.isDisplayed()) {
									divorcee_intermediate_skip.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							
							test.info("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");	
							
							driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
												
							BussinessFunctions.inboxMouseAction(driver, properties1);
							Thread.sleep(2000);
							test.pass("Unread Page Testing Started...");
						
						//	WebElement unreadLink=InboxPage.unread_link(driver, properties1.getProperty("unread_link"));
						//	test.pass(" Unread Link Text : "+unreadLink.getText());
						//	Thread.sleep(1000);
							
							test.pass(InboxPage.accepted_link(driver, properties1.getProperty("accepted_link")).getText());							
						
							test.pass(InboxPage.replied_link(driver, properties1.getProperty("replied_link")).getText());
							
							test.pass(InboxPage.declined_link(driver, properties1.getProperty("declined_link")).getText());		
									
						//	WebElement page1=InboxPage.unread_Page1(driver, properties1.getProperty("unread_page1"));
							WebElement page2=InboxPage.unread_Page2(driver, properties1.getProperty("unread_page2"));
							WebElement page3=InboxPage.unread_Page3(driver, properties1.getProperty("unread_page3"));
							WebElement page4=InboxPage.unread_Page4(driver, properties1.getProperty("unread_page4"));
							WebElement page5=InboxPage.unread_Page5(driver, properties1.getProperty("unread_page5"));
							//WebElement pageNext=InboxPage.unread_PageNext(driver, properties1.getProperty("unread_pageNext"));
							Thread.sleep(3000);	
							
							//WebElement readreplyBtn1=InboxPage.read_reply_btn(driver, properties1.getProperty("read_reply_btn"));
							try{
							 readRep=	InboxPage.read_reply_btn(driver, properties1.getProperty("read_reply_btns"));										
															Thread.sleep(3000);								
								readRep.click();
								Thread.sleep(1000);		}
							catch(Exception e){ e.getMessage(); }
																				  
								try{							
							 if(readRep.isDisplayed())
							{								
								if(page2.isDisplayed())
								{
									Thread.sleep(2000);	
								page2.click();
								Thread.sleep(2000);								
								driver.findElement(By.linkText("Read & Reply")).click();								
								}
													
								else if(page3.isDisplayed())
								{
									Thread.sleep(2000);	
								page3.click();
								Thread.sleep(2000);								
								driver.findElement(By.linkText("Read & Reply")).click();
								
								}
								else if(page4.isDisplayed())
								{
									Thread.sleep(2000);	
								page4.click();
								Thread.sleep(2000);
							
								driver.findElement(By.linkText("Read & Reply")).click();
								
								}
								else 
								{
								page5.click();
								Thread.sleep(2000);
								
								driver.findElement(By.linkText("Read & Reply")).click();
								
								}
							}
								}catch(Exception e){ e.getMessage(); } 
																	
							BussinessFunctions.unreadPageAction(driver, properties1);
							Thread.sleep(2000);
							System.out.println(" Unread Working .......");
							
				test.pass("Read Page Testing Started...");
				Thread.sleep(4000);
				
				
				//TOMMAROW TRY WITH 
				//JavaScriptExecutor ex = (IJavaScriptExecutor)Driver;
				//ex.ExecuteScript("arguments[0].click();", elementToClick);
				//InboxPage.read_link(driver, properties1.getProperty("read_link")).click();
				// Find an element

				WebElement element = driver.findElement(By.xpath(".//*[@id='RMREAD1']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);			
				
				Thread.sleep(2000);
				
				WebElement rpage1=InboxPage.read_Page1(driver, properties1.getProperty("read_page1"));
				WebElement rpage2=InboxPage.read_Page2(driver, properties1.getProperty("read_page2"));
				WebElement rpage3=InboxPage.read_Page3(driver, properties1.getProperty("read_page3"));
				WebElement rpage4=InboxPage.read_Page4(driver, properties1.getProperty("read_page4"));
				WebElement rpage5=InboxPage.read_Page5(driver, properties1.getProperty("read_page5"));
				WebElement rpageNext=InboxPage.read_PageNext(driver, properties1.getProperty("read_pageNext"));
				Thread.sleep(2000);
				if(rpage1.isDisplayed())
				{
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(1000);
				}
				else if(rpage2.isDisplayed())
				{
					rpage2.click();
					Thread.sleep(1000);
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(2000);			
				}
				else if(rpage3.isDisplayed())
				{
					rpage3.click();
					Thread.sleep(1000);
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(2000);
				}
				else if(rpage4.isDisplayed())
				{
					rpage4.click();
					Thread.sleep(1000);
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(2000);
				}
				else if(rpage5.isDisplayed())
				{
					rpage5.click();
					Thread.sleep(1000);
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(2000);
				}
				else
				{
					rpageNext.click();
					Thread.sleep(1000);
					BussinessFunctions.readingMail( driver, properties1);
					Thread.sleep(2000);
				}
				
				System.out.println("functioning");
														
					
						Thread.sleep(4000);
							System.out.println("Read Working....");
							
					//	test.pass(" Unread Link Text : "+unreadLink.getText());
						
						test.pass(InboxPage.accepted_link(driver, properties1.getProperty("accepted_link")).getText());							
						
						test.pass(InboxPage.replied_link(driver, properties1.getProperty("replied_link")).getText());
						
						test.pass(InboxPage.declined_link(driver, properties1.getProperty("declined_link")).getText());		
						
							Thread.sleep(3000);
						//sent mails unread test started.......
							
							InboxPage.unreadSent_link(driver, properties1.getProperty("unreadSent_link")).click();
							//InboxPage.commHistory(driver, properties1.getProperty("commHistory")).click();
							//Thread.sleep(2000);
							//InboxPage.commHistory_clsBtn(driver, properties1.getProperty("commHistory_clsBtn"));
							Thread.sleep(2000);
							InboxPage.sentReminder(driver,properties1.getProperty("sendRemind")).click();
							Thread.sleep(2000);
							
							try{
							InboxPage.sentReminderClose_btn(driver, properties1.getProperty("sendRemindClose_btn")).click();
							}catch(Exception e){ e.getMessage(); }
							Thread.sleep(2000);
							
							try{
							InboxPage.readSent_link(driver, properties1.getProperty("readSent_link")).click();
							}catch(Exception e){ 
								e.getMessage(); 
							}
		
							InboxPage.sentReminder(driver,properties1.getProperty("sendRemind")).click();
							
							try{
							InboxPage.sentReminderClose_btn(driver, properties1.getProperty("sendRemindClose_btn")).click();
							}catch(Exception e ){ e.getMessage(); }
							
							Thread.sleep(2000);
							test.pass(InboxPage.acceptedSent_link(driver, properties1.getProperty("acceptedSent_link")).getText());
							test.pass(InboxPage.repliedSent_link(driver,  properties1.getProperty("repliedSent_link")).getText());
							test.pass(InboxPage.declinedSent_link(driver, properties1.getProperty("declinedSent_link")).getText());
							
							Thread.sleep(3000);
							
							BussinessFunctions.cmLogout(driver,properties);
				Thread.sleep(4000);
				
				System.out.println("Logout Completed Successfully..");
				test.info("Application LogedOut Successfully...");				
			}			
		
/*@AfterMethod
public void tearDown()
{
	driver.close();
}	*/ 

}
}








