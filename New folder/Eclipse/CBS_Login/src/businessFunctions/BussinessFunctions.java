package businessFunctions;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AdvSearchPage;

//import com.cm.pages.AdvSearchPage;

import pages.DailyMatchePage;
import pages.DeleteProfilePage;
import pages.EditProfilePage;
import pages.FaceBookPage;
import pages.InboxPage;
import pages.KeyWordSearch;
import pages.LoginPage;
import pages.RegisterPage1;
import pages.RegisterPage2;
import pages.Search;
import pages.ViewProfilesPage;
import utility.ActionDrivers;
public class BussinessFunctions extends ActionDrivers{
	static long timeOutInSeconds=30;
	
	public static void cmLogin(WebDriver driver, Properties properties,String username, String password)throws Exception{
	
		type(LoginPage.username1(driver, properties.getProperty("cmusername")),username);
		click(LoginPage.passwordLabel(driver,properties.getProperty("cmpasswordclr")));
		type(LoginPage.password1(driver,properties.getProperty("cmpassword")), password);
		click(LoginPage.logIn(driver,properties.getProperty("cmlogin_click")));	
				
	}
	public static void divLogin(WebDriver driver, Properties properties,String username, String password)throws Exception{
		
		type(LoginPage.username1(driver, properties.getProperty("Div_username")),username);
		WebElement passw=driver.findElement(By.id("passwordClear1"));
		//Thread.sleep(3000);
		WebDriverWait wwait = new WebDriverWait(driver, 300);
		wwait.until(ExpectedConditions.visibilityOf(passw));
	//	WebElement passw=driver.findElement(By.id("passwordClear1"));
		passw.sendKeys("cbstest");
//		click(LoginPage.passwordLabel(driver,properties.getProperty("Div_passwordclr")));
//		type(LoginPage.password1(driver,properties.getProperty("Div_password")), password);
		click(LoginPage.logIn(driver,properties.getProperty("Div_loginbtn")));	
	}
	public static void login(WebDriver driver, Properties properties,String username1,String password1)throws Exception{
		type(LoginPage.username(driver, properties.getProperty("username")),username1);
		click(LoginPage.passwordclr(driver, properties.getProperty("passwordClr")));
		type(LoginPage.password1(driver,properties.getProperty("password")), password1);
		click(LoginPage.logIn(driver,properties.getProperty("login_click")));	
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[2]/input[3]")).click();
	}

	public static  String  randomSelection(WebDriver driver){
		
		List<WebElement> links = driver.findElements(By.cssSelector("html body div.innerdiv.margin-reset div.bgclr2 div.pad7 div.bgclr5.pad10.smalltxt form dl.nomargpad dd.fleft.padb5.mediumhdrtxt.domainlist a.clr4"));
		List<WebElement> visited = new ArrayList<WebElement>();
		WebElement random = links.get(new Random().nextInt(links.size()));
					String randomId=random.getText();
		System.out.println("No.of ID's.. "+links.size());
		if( !visited.contains(random))
		{ 
		  random.click();
		   visited.add(random);
		    //driver.navigate().back();
		}
		return randomId;				
	}
	
	public static void intermidatePages(WebDriver driver,Properties properties)throws Exception{
		/*try {
			WebElement mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"));
			
			if (mobile_verify.isDisplayed()) {
				//test.pass("This ID need to verify Mobile Number");
				break;
				
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}*/  try {
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
	}
	/*	try{
			click(IntermidatePages.dailyMatches_inter(driver, properties.getProperty("dailyMatches")));
			Thread.sleep(1000);
			} catch(Exception e) { e.getMessage(); }
			try{
				click(IntermidatePages.skipMatrimony_inter(driver, properties.getProperty("skipMatrimony")));
				Thread.sleep(1000);
			}catch(Exception e) { e.getMessage();   }
				
		try{
			Thread.sleep(1000);
		click(IntermidatePages.addPhoto_inter(driver, properties.getProperty("addphoto")));
		
		} catch(Exception e) { e.getMessage(); }
		
		try{
		click(IntermidatePages.dailyMatches_inter(driver, properties.getProperty("dailyMatches")));
		Thread.sleep(1000);
		} catch(Exception e) { e.getMessage(); }
		try{
			click(IntermidatePages.skipMatrimony_inter(driver, properties.getProperty("skipMatrimony")));
			Thread.sleep(1000);
		}catch(Exception e) { e.getMessage();   }
			
				try{
		click(IntermidatePages.areyousure_inter(driver, properties.getProperty("areyousure")));
		Thread.sleep(1000);
		}
		catch(Exception e){ e.getMessage(); }
				try{
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id='reason1']")).click();
			        Thread.sleep(1000);
			        driver.findElement(By.xpath(".//*[@id='skipphotoclick']")).click();
			        Thread.sleep(1000);
				}catch(Exception e) { e.getMessage(); }
		
		try{
		click(IntermidatePages.profilehighlighter_inter(driver, properties.getProperty("profilehighlighter")));
		Thread.sleep(1000); } catch(Exception e){
			e.getMessage();
		}
		
		try{
			click(IntermidatePages.strategicComm(driver,properties.getProperty("strategicComm")));
			Thread.sleep(1000);}
		catch(Exception e){ e.getMessage(); } 
		
		}	*/
		
	public static void cmLogout(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(2000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 
		
 		String Logout_Click=properties.getProperty("Logout_click");
 		String LogoutCompletel_click=properties.getProperty("LogoutCompletely_click");
 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(2000);
		click(LoginPage.Logout_Click1(driver,Logout_Click));
		Thread.sleep(3000);
		//click(LoginPage.Louout_Comploetely1(driver,LogoutCompletel_click));
		//Thread.sleep(3000);
				
	}  
	public static void dailyMatch_Logout(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(2000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 
		
 		String Logout_Click=properties.getProperty("Logout_click");
 		String LogoutCompletel_click=properties.getProperty("LogoutCompletely_click");
 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(2000);
		click(LoginPage.Logout_Click1(driver,Logout_Click));
		Thread.sleep(1000);
		//click(LoginPage.Louout_Comploetely1(driver,LogoutCompletel_click));
		//Thread.sleep(1000);				
	}							
	
	public static void inboxMouseAction(WebDriver driver, Properties properties1)throws Exception
	{
		String mouseoverLogout2=properties1.getProperty("Inbox1"); 
 		String Logout_Click2=properties1.getProperty("inbox");
 		 		
		Actions actions = new Actions(driver);
		WebElement mouseover=InboxPage.Inbox(driver, mouseoverLogout2);
		actions.moveToElement(mouseover).build().perform();
		click(InboxPage.inbox(driver,Logout_Click2));
		Thread.sleep(2000);
	}
	public static void RegularSearchMouseAction(WebDriver driver, Properties propertiesX)throws Exception
	{
		String mouseoverLogout2=propertiesX.getProperty("search_mouseoverAction"); 
 		String Logout_Click2=propertiesX.getProperty("regSearch_mouseClick");
 		 		
		Actions actions = new Actions(driver);
		WebElement mouseover=Search.search_mouseoverActions(driver, mouseoverLogout2);
		actions.moveToElement(mouseover).build().perform();
		click(Search.regSearch_mouseClicks(driver,Logout_Click2));
		Thread.sleep(2000);
	}
	public static void advancedSearchMouseAction(WebDriver driver, Properties propertiesy)throws Exception
	{
		String mouseoverLogout2=propertiesy.getProperty("search_mouseAction"); 
 		String Logout_Click2=propertiesy.getProperty("advancedsearch_mouseAction");
 		 		
		Actions actions = new Actions(driver);
		WebElement mouseover=AdvSearchPage.Search_Action(driver, mouseoverLogout2);
		actions.moveToElement(mouseover).build().perform();
		click(AdvSearchPage.advancedSearch_action(driver,Logout_Click2));
		Thread.sleep(2000);
	}
	public static void keywordSearchMouseAction(WebDriver driver, Properties propertiesz)throws Exception
	{
		String mouseoverLogout2=propertiesz.getProperty("search_mouseOverAction"); 
 		String Logout_Click2=propertiesz.getProperty("keywordSearch_link");
 		 		
		Actions actions = new Actions(driver);
		WebElement mouseover=KeyWordSearch.Keysearch_mouseoverActions(driver, mouseoverLogout2);
		actions.moveToElement(mouseover).build().perform();
		click(KeyWordSearch.keyWordSearch_actions(driver,Logout_Click2));
		Thread.sleep(2000);
	}
	
	public static void matches_PPmouseAction(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(2000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 		
 		String ppMouseAction=properties.getProperty("partnerPreference_mouse");	 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(2000);
		click(LoginPage.ppMouseActions(driver,ppMouseAction));
		Thread.sleep(1000);			
	}
	public static void payments_MatchesPagelink(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(2000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 		
 		String ppMouseAction=properties.getProperty("payment_Matcheslink");	 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(2000);
		click(LoginPage.ppMouseActions(driver,ppMouseAction));
		Thread.sleep(1000);			
	}
	
	public static void payments_MouseAction(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(1000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 		
 		String ppMouseAction=properties.getProperty("upgradeMouseAction");	 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(1000);
		click(LoginPage.ppMouseActions(driver,ppMouseAction));
		Thread.sleep(1000);			
	}
	//Upgrade
	public static void selectOfferAmount_gold3Months(WebDriver driver)throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement gold3MonthsEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category_1")));
				gold3MonthsEle.click();
			}
	public static void selectOfferAmount_gold6Months(WebDriver driver)throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement gold6MonthsEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category_172")));
				gold6MonthsEle.click();
	}
	public static void selectOfferAmount_diamond6Months(WebDriver driver)throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='category_2173']")).click();
	}
	public static void selectOfferAmount_diamond3Months(WebDriver driver)throws Exception{
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='category_2']")).click();
		driver.findElement(By.id("specialOffer120")).click();
		
	}
	
	public static void selectOfferAmount_platinum3Months(WebDriver driver)throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='category_14']")).click();
	}
	public static void selectOfferAmount_platinum6Months(WebDriver driver)throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='category_14156']")).click();
	}
	public static void selectOfferAmount_tillUMarry(WebDriver driver)throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='category_8']")).click();
	}
	
	
	public static void addOnPacks(WebDriver driver)throws Exception{
		
		
		driver.findElement(By.xpath(".//*[@id='specialOffer120']")).click();
		WebElement check1=driver.findElement(By.xpath((".//*[@id='spn_display_addon120']/label/div[2]/div[1]")));
		WebElement amount1=driver.findElement(By.xpath(".//*[@id='spn_display_addon120']/label/div[2]/div[2]/span"));
	//	test.pass(check1.getText()+" "+amount1.getText());
		driver.findElement(By.xpath(".//*[@id='specialOffer125']")).click();
		WebElement check2=driver.findElement(By.xpath((".//*[@id='spn_display_addon125']/label/div[2]/div[1]")));
		WebElement amount2=driver.findElement(By.xpath(".//*[@id='spn_display_addon125']/label/div[2]/div[2]/span"));
		//test.pass(check2.getText()+" "+amount2.getText());
		try{
		driver.findElement(By.xpath(".//*[@id='specialOffer110']")).click();
		//WebElement check3=driver.findElement(By.xpath((".//*[@id='spn_display_addon111']/label/div[2]/div[1]")));
		//WebElement amount3=driver.findElement(By.xpath(".//*[@id='spn_display_addon111']/label/div[2]/div[2]/span"));
		//test.pass(check3.getText()+" "+amount3.getText());
		}catch(Exception e){ e.getMessage(); } 
		
		try{
			driver.findElement(By.xpath(".//*[@id='specialOffer111']")).click();
			//WebElement check3=driver.findElement(By.xpath((".//*[@id='spn_display_addon111']/label/div[2]/div[1]")));
			//WebElement amount3=driver.findElement(By.xpath(".//*[@id='spn_display_addon111']/label/div[2]/div[2]/span"));
			//test.pass(check3.getText()+" "+amount3.getText());
			}catch(Exception e){ e.getMessage(); } 
		Thread.sleep(1000);
		}
	public static void upgradeAccounts_LogoutMenu(WebDriver driver,Properties properties)throws Exception
	{
		Thread.sleep(2000);
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 		
 		String ppMouseAction=properties.getProperty("upgradeAccountAction");	 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		Thread.sleep(2000);
		click(LoginPage.ppMouseActions(driver,ppMouseAction));
		Thread.sleep(1000);			
	}
	
	
	public static void unreadPageAction(WebDriver driver, Properties properties1)	{
		
		/*try{
			InboxPage.accept_btn(driver, properties1.getProperty("accept_btn")).click();
			WebElement acceptLink=InboxPage.accepted_link(driver, properties.getProperty("accepted_link"));
			
			
			InboxPage.acceptMsgBox_clsBtn(driver, properties1.getProperty("acceptMsgBox_clsBtn")).click();
			 
		}catch(Exception e ){ e.getMessage(); }*/
				
								
		
		/*try
		{
			WebElement replylink = InboxPage.replied_link(driver, properties.getProperty("replied_link"));
			test.pass("Before Reply - Link Text"+replylink.getText());
					InboxPage.reply_btn(driver, properties1.getProperty("reply_btn")).click();							 
					Thread.sleep(2000);
			InboxPage.replyMsgbox_clsBtn(driver, properties1.getProperty("replyMsgbox_clsBtn")).click();
			 test.pass("After Reply - link Text" + replylink.getText());
		}catch(Exception e ){ e.getMessage(); }
		*/
		
		try{
			InboxPage.Ddecline_btn(driver, properties1.getProperty("decline_btn")).click();
													
			Thread.sleep(2000);
			InboxPage.declineAcceptMsgBox_clsBtn(driver, properties1.getProperty("declineAcceptMsgBox_clsBtn")).click();
			Thread.sleep(2000);
			
			} catch(Exception e) { e.getMessage(); }
	}
	
	public static void netBanking_Actions(WebDriver driver) throws Exception{
		
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement netBankingEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabNetBank")));
		netBankingEle.click();
		
		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		WebElement netBankingOptionEle=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html.regpack_active body.regpack_active div.payment-mode-bg div.wrapper-max div#payment_options.fleft div.padt15 div.pay-mode-tab-detailbox-outer div.pad15 div#net_bank_form_ri.padt15.padl15 div#pay-frm div#divNetBankFormRi form#frmNetBankingRi dl dd.padt10 div.NetBankList.padb5 ol li label input#SBI.fleft.radio")));
		netBankingOptionEle.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		WebElement paySecurlyBtn=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id(".//*[@id='frmNetBankingRi']/dl[2]/dd/div/input")));
		paySecurlyBtn.click();
		
		//Select bankType=new Select(driver.findElement(By.xpath(".//*[@id='netBankingCards']")));
		//bankType.selectByValue("HDFC Bank");
		
		Thread.sleep(2000);
	}
	
			
	public static void readingMail(WebDriver driver,Properties properties1)throws Exception
	{											
								
		/*try{
			InboxPage.accept_btn(driver, properties1.getProperty("accept_btn")).click();						
				
			InboxPage.acceptMsgBox_clsBtn(driver, properties1.getProperty("acceptMsgBox_clsBtn")).click();
			
				}catch(Exception e ){ e.getMessage(); }*/
			
		/*try
		{				InboxPage.read_reply_btn(driver, properties1.getProperty("reply_btn")).click();							 
					Thread.sleep(2000);
			InboxPage.replyMsgbox_clsBtn(driver, properties1.getProperty("replyMsgbox_clsBtn")).click();
		
		}catch(Exception e1 ){ e1.getMessage(); }*/
		
		
		try
		{
				InboxPage.Ddecline_btn(driver, properties1.getProperty("decline_btn")).click();							
											Thread.sleep(2000);
			InboxPage.declieReplyMsgBox_clsBtn(driver,properties1.getProperty("declieReplyMsgBox_clsBtn")).click();
			
		}catch(Exception e2 ){ e2.getMessage(); }	
	}
			
	
	public static void Logout(WebDriver driver,Properties properties)throws Exception
	{
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 
 		String Logout_Click=properties.getProperty("Logout_click");
 		String LogoutCompletel_click=properties.getProperty("LogoutCompletely_click");
 		
		Actions actions = new Actions(driver);
		WebElement mouseover=LoginPage.mouseoverLogout1(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		click(LoginPage.Logout_Click1(driver,Logout_Click));
		Thread.sleep(2000);
		
					
	}
	/*public static void Logout2(WebDriver driver,Properties properties)throws Exception
	{
		String mouseoverLogout1=properties.getProperty("mouseoverLogout"); 
 		String Logout_Click=properties.getProperty("Logout_click");
 		String LogoutCompletel_click=properties.getProperty("LogoutCompletely_click");
 		
		Actions actions = new Actions(driver);
		WebElement mouseover=RegisterPage2.mouseoverLogout2(driver, mouseoverLogout1);
		actions.moveToElement(mouseover).build().perform();
		click(RegisterPage2.mouseoverLogout2(driver,Logout_Click));
		Thread.sleep(2000);
		
					
	}*/
	
	public static void dailyMatches_mouseOverAction(WebDriver driver, Properties properties3)throws Exception
	{
		Actions dailyMatch=new Actions(driver);
		WebElement dailyMatchEle=DailyMatchePage.dailyMatch_MouseOvers(driver, properties3.getProperty("dailyMatch_MouseOver"));
		dailyMatch.moveToElement(dailyMatchEle).click();
		Thread.sleep(2000);
		
	}
	
	public static void facebookPage(WebDriver driver, Properties properties,String fbusername,String fbpassword)throws Exception{
			
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		 // click some link that opens a new window
		click(FaceBookPage.fb_Link(driver, properties.getProperty("facebook_link")));

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		type(FaceBookPage.fbusername(driver, properties.getProperty("fbusername1")),fbusername);
		click(FaceBookPage.fbpassword(driver, properties.getProperty("fbpassword1")));
		type(FaceBookPage.fbpassword(driver, properties.getProperty("fbpassword1")),fbpassword);
		click(FaceBookPage.fbLogin_btn(driver, properties.getProperty("fbLogin_btn")));
		Thread.sleep(3000);

		//code to do something on new window

		//driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); 
		
			}
		
	public static void registrationPage1(WebDriver driver,Properties properties, String communitysite, String profileby,String name,String gender,
			String date,String month,String year,String martial,String relgion,String denominations,String denominationText,String div_cast,String div_cast_ifOther,String sub_cast,
			String sub_castifSC,String Sub_cast_IfOther,String mothertongue,String country,String ccode,String mobileno,String loginpwd)throws Exception{
		
//	try {
//		selectElementByVisibleText(RegisterPage1.communitsites(driver,properties.getProperty("communitysites_dropdown")),communitysite);
//	} catch (Exception e) {
//		e.getMessage();
//	}
		
		selectElementByVisibleText(RegisterPage1.profilecreateBy(driver,properties.getProperty("profilecreatedby_dropdown")),profileby);
		type(RegisterPage1.name(driver,properties.getProperty("Name")),name);
		
		if(gender.equals("Male")){
		click(RegisterPage1.male(driver, properties.getProperty("maleRadio_btn")));
		}
		else{
		click(RegisterPage1.female(driver,properties.getProperty("femaleRadio_btn")));
		}
		
		selectElementByVisibleText(RegisterPage1.dob_day(driver, properties.getProperty("dob_date_dropdown")),date);
	
		Thread.sleep(1000);
		selectElementByVisibleText(RegisterPage1.dob_month(driver,properties.getProperty("dob_Month_dropdown")),month);
		Thread.sleep(2000);
		
		selectElementByVisibleText(RegisterPage1.dob_year(driver, properties.getProperty("dob_Year_dropdown")),year);
				
		//selectElementByVisibleText(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_dropdown")),martial);
		

		if(martial.equals("Awaiting Divorce")){
			click(RegisterPage1.martialStatus(driver, properties.getProperty("MaritalStatus_Awaiting Divorce")));
			}
			else if(martial.equals("Divorced")){
			click(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_Divorced")));
			}
			else if (martial.equals("Widow / Widower")) {
				click(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_Widowed")));	
			}
			else if (martial.equals("Annulled")) {
				click(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_Annulled")));
				
			}
			else if (martial.equals("Never Married")) {
				click(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_Never Married")));
				
			}
		
		   selectElementByVisibleText(RegisterPage1.relgion_dd(driver,properties.getProperty("relgion_dropdown")),relgion);
		   
		   try{
				
				selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
				
				}catch(Exception e){ e.getMessage();}
		
		
//		if(martial.equals("Unmarried")){
//			click(RegisterPage1.martialStatus(driver, properties.getProperty("MaritalStatus_unmarried")));
//			}
//			else if(martial.equals("Divorced")){
//			click(RegisterPage1.martialStatus(driver,properties.getProperty("MaritalStatus_Divorced")));
//			}
//		
		
		
		if(communitysite.equals("brahminmatrimony"))
		{
			BussinessFunctions.castBrhamin(driver, properties, div_cast, sub_castifSC);
		}
		else if(communitysite.equals("muslimmatrimony"))
		{
			BussinessFunctions.castMuslim(driver, properties, denominations, div_cast);
		}
		else if(communitysite.equals("christianmatrimony"))
		{
			BussinessFunctions.castChristian(driver, properties, denominations,div_cast,sub_cast);
		}
		else if(communitysite.equals("jainmatrimony"))
		{
			BussinessFunctions.castJain(driver, properties, denominations,div_cast, sub_castifSC);
		}
		else if(communitysite.equals("agarwalmatrimony"))
		{
			BussinessFunctions.castAgarwal(driver, properties, relgion, sub_castifSC);
		}
		else if(communitysite.equals("aryavysyamatrimony")){
			BussinessFunctions.castAryaVysya(driver, properties, sub_castifSC);
		}
		else
		{
			BussinessFunctions.castForCommon(driver, properties, sub_castifSC);
		}
		
		//WebElement ms=driver.findElement(By.xpath(".//*[@id='maritalStatus']"));
		//Select s = new Select(ms);
		//s.selectByVisibleText(martial);
	
		//Cast fields for multiple communities
	//---	BussinessFunctions.casteSelection(driver, properties, communitysite, div_cast_ifOther, denominations, relgion);
		/*try{
			selectElementByVisibleText(RegisterPage1.relgion_dd(driver, properties.getProperty("relgion_dropdown")),relgion);
		}catch(Exception e){ e.getMessage(); }
		try{
		selectElementByVisibleText(RegisterPage1.denomination(driver, properties.getProperty("deonominaton_dropdown")),denominations);
		}
		catch(Exception e){ e.getMessage();}
		try{
	type(RegisterPage1.denominationText(driver, properties.getProperty("deonominanationTextifOthers")),denominationText);
		
		}catch(Exception e){ e.getMessage();}
		try{
		
		selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
		
		}catch(Exception e){ e.getMessage();}
		try{
	type(RegisterPage1.division_castIfOthers(driver, properties.getProperty("divcastIfOthers")),div_cast_ifOther);
		
	
		}catch(Exception e){ e.getMessage();}*/
		//Cast for Single community like brhamin
		/*---selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
		
		SubCaste for multiple communities......
		*try{
		type(RegisterPage1.subcast(driver, properties.getProperty("subcast_text")),sub_cast);
		
		}catch(Exception e){ e.getMessage();}
		try{
	selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcastifSC")),sub_castifSC);
	
		}catch(Exception e){ e.getMessage();}
		try{
	type(RegisterPage1.subcastIfOthers(driver,properties.getProperty("subcastOthers")),Sub_cast_IfOther);
		
		
		}catch(Exception e){ e.getMessage();}*/
		//Subcast for Single communities....
		//selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcaste")),sub_castifSC);
		
		selectElementByVisibleText(RegisterPage1.motherTongue(driver,properties.getProperty("MotherTongue_dropdown")),mothertongue);
		
		selectElementByVisibleText(RegisterPage1.country(driver,properties.getProperty("Country_drowpdown")),country);
		Thread.sleep(3000);
		
		//selectElementByVisibleText(RegisterPage1.country_mobilecode(driver,properties.getProperty("MobileNo_Countrycode_dropdown")),ccode);
		//System.out.println("Country Code is : "+ccode);
		
		Select ccodeEle=new Select(RegisterPage1.country_mobilecode(driver,properties.getProperty("MobileNo_Countrycode_dropdown")));
		ccodeEle.selectByIndex(2);
			System.out.println("CountryCode : "+ccodeEle);
		
		Thread.sleep(3000);
		
		type(RegisterPage1.mobuleNum(driver,properties.getProperty("MobileNo_TextField")),mobileno);
		//driver.findElement(By.xpath("MobileNo_TextField")).sendKeys(mobileno);
		
		type(RegisterPage1.loginPassword(driver,properties.getProperty("LoginPassword_TextField")),loginpwd);
		click(RegisterPage1.registerNowBtn(driver,properties.getProperty("RegisterNow_btn")));
		Thread.sleep(1000);					
	}
	
		private static void castBrhamin(WebDriver driver,Properties properties,String div_cast,String sub_castifSC) throws Exception
		{
			//Thread.sleep(3000);
			selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
			Thread.sleep(1000);
			selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcastes")),sub_castifSC);

		}
		private static void castMuslim(WebDriver driver,Properties properties,String denominations,String div_cast ) throws Exception
		{
			selectElementByVisibleText(RegisterPage1.denomination(driver, properties.getProperty("deonominaton_dropdown")),denominations);
			Thread.sleep(2000);
			selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
		}
		private static void castChristian(WebDriver driver, Properties properties,String denominations,String div_cast,String sub_cast) throws Exception
		{
			selectElementByVisibleText(RegisterPage1.denomination(driver, properties.getProperty("deonominaton_dropdown")),denominations);
			Thread.sleep(1000);
			selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
			Thread.sleep(1000);
			type(RegisterPage1.subcast(driver, properties.getProperty("subcast_text")),sub_cast);
		}
		private static void castJain(WebDriver driver, Properties properties,String denominations,String div_cast,String sub_castifSC) throws Exception
		{
			selectElementByVisibleText(RegisterPage1.denomination(driver, properties.getProperty("deonominaton_dropdown")),denominations);
			Thread.sleep(1000);
			selectElementByVisibleText(RegisterPage1.division_cast(driver, properties.getProperty("division_dropdown")),div_cast);
			Thread.sleep(1000);
			selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcastes")),sub_castifSC);
		}
		private static void castAgarwal(WebDriver driver,Properties properties,String relgion,String sub_castifSC) throws Exception
		{
			selectElementByVisibleText(RegisterPage1.relgion_dd(driver, properties.getProperty("relgion_dropdown")),relgion);
			Thread.sleep(1000);
		//	selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcastes")),sub_castifSC);
			driver.findElement(By.id("subCaste")).click();
			
		}
		private static void castForCommon(WebDriver driver,Properties properties,String sub_castifSC) throws Exception
		{
			selectElementByVisibleText(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcastes")),sub_castifSC);
		}
		private static void castAryaVysya(WebDriver driver,Properties properties,String sub_castifSC) throws Exception
		{
			type(RegisterPage1.subcastIfSC(driver, properties.getProperty("subcast_text")),sub_castifSC);
		}
				
	//Registration Page2
	
	public static void registrationPage2(WebDriver driver,Properties properties,String communitysite,String mail,String aboutme,String martial,String NoOfChilds,String childLiving,String height,String physicalStatus,
			String residestate,String residecity,String citizen,String commsite,String division,String relgiousValues,String readQuran,
			String star,String rasi,String gothram,String dosham,String doshamType,String hours,String mins,String mridiem,String cbirth,String sbirth,String citybirth,
			String chartstyle, String highestEdu, String addEdu,String prof, String occupation,String income1,String annualCurrency,
			String annualIncome, String parentContact,String familyValue,String familyType,String familyStatus,String ethnicity,String netWroths)
					throws Exception{
		//Personel Information
	
		type(RegisterPage2.mail_Text(driver, properties.getProperty("mail_TextField")),mail);
			
		type(RegisterPage2.Aboutme_Text(driver, properties.getProperty("Aboutme_TextField")),aboutme);
		Thread.sleep(1000);
		//Number of Childs.....
		//if MartialStatus is 'UnMarried' then you need not read this code (only for like martialStatus are Married,Divorced and Widow,Separated
		BussinessFunctions.noOfChilds_ExceptUnMarried(driver, properties, martial, NoOfChilds, childLiving);
					
		Thread.sleep(1000);
		selectElementByVisibleText(RegisterPage2.height_dd(driver, properties.getProperty("Height_dropdown")),height);		
		if(physicalStatus.equals("Normal")){
		click(RegisterPage2.physicalStatus_Normal_radiobtn(driver, properties.getProperty("physicalStatus_Normal_radiobtn")));
		}else{
		click(RegisterPage2.physicalStatus_PH_radiobtn(driver, properties.getProperty("physicalStatus_PH_radiobtn")));
		} 		
		
		//Location Information	
		selectElementByVisibleText(RegisterPage2.ResidingState_dropdown(driver, properties.getProperty("ResidingState_dropdown")),residestate);
		Thread.sleep(1000);
		
		selectElementByVisibleText(RegisterPage2.ResidingCity_dropdown(driver, properties.getProperty("ResidingCity_dropdown")),residecity);
		Thread.sleep(1000);
		
		selectElementByVisibleText(RegisterPage2.citizenship(driver, properties.getProperty("citizenship")),citizen);
				
		// Religious Information	
		if(commsite.equals("jainmatrimony.com")){
			relgiousJainInfo( driver, properties, division, hours, mins, mridiem, cbirth, sbirth, citybirth,chartstyle );
		}
					
		else if(commsite.equals("brahminmatrimony.com")||commsite.equals("divorceematrimony.com")||commsite.equals("iyermatrimony.com")){
		relgiousBrahminAndDivoreceInfo( driver, properties, division, star, rasi, gothram, dosham,  doshamType, hours, mins, mridiem,  cbirth,  sbirth, citybirth, chartstyle);
		}		
		else if(commsite.equals("christianmatrimony.com")){
			relgiousChristianInfo( driver, properties, division, relgiousValues);
		}
		else if(commsite.equals("muslimmatrimony.com")){
			relgiousMuslimInfo( driver,  properties, division,readQuran,relgiousValues);
		}
		else if(commsite.equals("aryavysyamatrimony.com"))
		{
			relgiousAryaVysyaInfo(driver, properties, star, rasi, gothram, dosham, doshamType, hours, mins, mridiem, cbirth, sbirth, citybirth, chartstyle);
		}
		else 
		{
			relgiousCommonInfo( driver,properties,division,star,rasi,gothram,dosham,doshamType,hours,mins,mridiem,cbirth,sbirth,citybirth,chartstyle);
		}
		Thread.sleep(1000);
		
		//Education&Information
selectElementByVisibleText(RegisterPage2.HighestEducation_dd(driver, properties.getProperty("HighestEducation_dropdown")),highestEdu);
		
		try{
		selectElementByVisibleText(RegisterPage2.AdditionalEducation_dropdown(driver, properties.getProperty("AdditionalEducation_dropdown")),addEdu);
		}catch(Exception e){
		e.getMessage();
						}
		if(prof.equals("Government")){		
		click(RegisterPage2.EmployeeIn_Government_radiobtn(driver, properties.getProperty("EmployeeIn_Government_radiobtn")));
		profession(driver,properties,occupation,income1,annualCurrency,annualIncome);
		}
		else if(prof.equals("Defence")){
		click(RegisterPage2.EmployeeIn_Defence_radiobtn(driver, properties.getProperty("EmployeeIn_Defence_radiobtn")));
		profession(driver,properties,occupation,income1,annualCurrency,annualIncome);
		}
		else if(prof.equals("Private")){
		click(RegisterPage2.EmployeeIn_Private_radiobtn(driver, properties.getProperty("EmployeeIn_Private_radiobtn")));
		profession(driver,properties,occupation,income1,annualCurrency,annualIncome);
		}
		else if(prof.equals("Business")){
		click(RegisterPage2.EmployeeIn_Business_radiobtn(driver, properties.getProperty("EmployeeIn_Business_radiobtn")));
		profession(driver,properties,occupation,income1,annualCurrency,annualIncome);
		}
		else if(prof.equals("Self Employed")){
		click(RegisterPage2.EmployeeIn_Self_radiobtn(driver, properties.getProperty("EmployeeIn_Self_radiobtn")));
		profession(driver,properties,occupation,income1,annualCurrency,annualIncome);
		}
		else{
		click(RegisterPage2.EmployeeIn_NotWorking_radiobtn(driver, properties.getProperty("EmployeeIn_NotWorking_radiobtn")));
		
		}
		Thread.sleep(1000);
		
		//FamilyInformation
		type(RegisterPage2.ParentContact_Text(driver, properties.getProperty("ParentContact_Text")),parentContact);
		//family Value radio buttons
		if(familyValue.equals("Orthodox"))
		{
			click(RegisterPage2.FamilyValue_Orthodox_radiobtn(driver, properties.getProperty("FamilyValue_Orthodox_radiobtn")));
		}
		else if(familyValue.equals("Traditional"))
		{
			click(RegisterPage2.FamilyValue_Traditional_radiobtn(driver, properties.getProperty("FamilyValue_Traditional_radiobtn")));
		}
		else if(familyValue.equals("Moderate"))
		{
			click(RegisterPage2.FamilyValue_Moderate_radiobtn(driver,properties.getProperty("FamilyValue_Moderate_radiobtn")));
		}
		else {
			click(RegisterPage2.FamilyValue_liberal_radiobtn(driver, properties.getProperty("FamilyValue_liberal_radiobtn")));
		}
		
		//family Type radiobuttons
		if(familyType.equals("Joint family"))
		{
			click(RegisterPage2.FamilyType_JointFamily_radiobtn(driver,properties.getProperty("FamilyType_JointFamily_radiobtn")));
		}
		else 
		{
			click(RegisterPage2.FamilyType_NuclerFamily_radiobtn(driver, properties.getProperty("FamilyType_NuclerFamily_radiobtn")));
		}
		
		//family Status radion button
		
		if(familyStatus.equals("Middle class")){
			click(RegisterPage2.FamilyStatus_Middle_radiobtn(driver, properties.getProperty("FamilyStatus_Middle_radiobtn")));
		}
		else if(familyStatus.equals("Upper middle class"))
		{
			click(RegisterPage2.FamilyStatus_Upper_radiobtn(driver, properties.getProperty("FamilyStatus_Upper_radiobtn")));
		}
		else
		{
			click(RegisterPage2.FamilyStatus_Rich_radiobtn(driver, properties.getProperty("FamilyStatus_Rich_radiobtn")));
		}
		
		if(communitysite.equals("muslimmatrimony.com")||communitysite.equals("christianmatrimony.com"))
		{
		selectElementByVisibleText(RegisterPage2.Ethnicity_dropdown(driver, properties.getProperty("Ethnicity_dropdown")),ethnicity);
		}else if(communitysite.equals("kapumatrimony.com"))
		{
			type(RegisterPage2.netWorthValues(driver, properties.getProperty("netWorthValue")),netWroths);
		}
		
		else
		{
			System.out.println("Ethncity&NetWorth is not applicable to this domain : "+communitysite);
		}
		
		click(RegisterPage2.CompleteRegistration_btn(driver, properties.getProperty("CompleteRegistration_btn")));
		Thread.sleep(1000);
		 // Selecting the matriid
        
					}
	
	//Sub Functions
	
	private static void noOfChilds_ExceptUnMarried(WebDriver driver,Properties properties,String martial,String NoOfChilds,String childLiving) throws Exception
	{
		if(martial.equals("Unmarried"))
		{
			System.out.println("Martial Status : "+martial);
		}
		else if (martial.equals("Divorced")&&martial.equals("Separated")&&martial.equals("Widow / Widower"))
		{
			if(NoOfChilds.equals("None"))
			{
			click(RegisterPage2.NoOfChildren0_radio(driver, properties.getProperty("NoofChildren0_radio")));			
				}else if (NoOfChilds.equals("1")){
					click(RegisterPage2.NoOfChildren1_radio(driver, properties.getProperty("NoofChildren1_radio")));
					childLiving_ExceptUnMarried(driver, properties, childLiving);
				}else if(NoOfChilds.equals("2"))
				{
					click(RegisterPage2.NoOfChildren2_radio(driver, properties.getProperty("NoofChildren2_radio")));
					childLiving_ExceptUnMarried(driver, properties, childLiving);			
				}else if (NoOfChilds.equals("3")){
					click(RegisterPage2.NoOfChildren3_radio(driver, properties.getProperty("NoofChildren3_radio")));
					childLiving_ExceptUnMarried(driver, properties, childLiving);			
				}
				else
				{			click(RegisterPage2.NoOfChildren4_radio(driver, properties.getProperty("NoofChildren4_radio")));
				childLiving_ExceptUnMarried(driver, properties, childLiving);			
				}
		}
	}	
	private static void childLiving_ExceptUnMarried(WebDriver driver,Properties properties,String childLiving) throws Exception
	{
		
		if(childLiving.equals("Living with me")){
			click(RegisterPage2.childLivingwithme_radio(driver, properties.getProperty("childLivingwithme_radio")));
		}
		else
		{
			click(RegisterPage2.childLivingNotwithme_radio(driver, properties.getProperty("childLivingNotWithme_radio")));
		}
		}

	private static void profession(WebDriver driver,Properties properties,String occupation,String income1,String annualCurrency,String annualIncome )
	throws Exception{
		selectElementByVisibleText(RegisterPage2.Occupation_dropdown(driver, properties.getProperty("Occupation_dropdown")),occupation);
		selectElementByVisibleText(RegisterPage2.AnnualCurrency_dropdown(driver, properties.getProperty("AnnualCurrency_dropdown")),annualCurrency);		
		selectElementByVisibleText(RegisterPage2.AnnualIncome_Text(driver, properties.getProperty("AnnualIncome_Text")),annualIncome);
//		if(income1.equals("Monthly")){
//			click(RegisterPage2.Income_Monthly_radiobtn(driver, properties.getProperty("Income_Monthly_radiobtn")));
//		
//		}
//		if (condition) {
//			
//		}
//		else{
//			click(RegisterPage2.Income_Annual_radiobtn(driver, properties.getProperty("Income_Annual_radiobtn")));
//		}
//		selectElementByVisibleText(RegisterPage2.AnnualCurrency_dropdown(driver, properties.getProperty("AnnualCurrency_dropdown")),annualCurrency);		
//		selectElementByVisibleText(RegisterPage2.AnnualIncome_Text(driver, properties.getProperty("AnnualIncome_Text")),annualIncome);
//					
	}
	
	
private static void relgiousCommonInfo(WebDriver driver,Properties properties,String division,String star,String rasi,String gothram,String dosham, String doshamType,
		String hours,String mins,String mridiem, String cbirth, String sbirth,String citybirth,String chartstyle)throws Exception{
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_star_dd(driver, properties.getProperty("star_dd")),star);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_rasi_dd(driver, properties.getProperty("rassi_dd")),rasi);
	type(RegisterPage2.brahminRelgious_gothram_dd(driver, properties.getProperty("gothram_Text")),gothram);
	

	 Thread.sleep(1000);
	if(dosham.equals("Yes"))
	{
		click(RegisterPage2.brahminRelgious_doshamYes_radio(driver, properties.getProperty("dosham_Yes_radio")));
		if(doshamType.equals("Kethu Dosh")){
			click(RegisterPage2.brahminRelgious_Kuja_Cb(driver, properties.getProperty("dosham_kethu_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Naga_Cb(driver, properties.getProperty("dosham_naga_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_KalaSarpa_Cb(driver, properties.getProperty("dosham_kalasarp_cb")));
		} else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Rahu_Cb(driver, properties.getProperty("dosham_rahu_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Kethu_Cb(driver, properties.getProperty("dosham_kethu_cb")));
		}else{
			click(RegisterPage2.brahminRelgious_Kalthra_Cb(driver, properties.getProperty("dosham_kalathra_cb")));
		}
	}else if(dosham.equals("No")){
	click(RegisterPage2.brahminRelgious_doshamNo_radio(driver, properties.getProperty("dosham_No_radio")));
	}else{
	click(RegisterPage2.brahminRelgious_doshamdntKnow_radio(driver, properties.getProperty("dosham_dontKnow_radio")));
	}
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Hours_dd(driver, properties.getProperty("TimeofBirth_hours_dd")),hours);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Mins_dd(driver, properties.getProperty("TimeofBirth_mins_dd")),mins);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_Meridiem_dd(driver, properties.getProperty("meridiem_dd")),mridiem);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_CountryBirth_dd(driver, properties.getProperty("countryofBirth_dd")),cbirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_StateBirth_dd(driver, properties.getProperty("stateofBirth_dd")),sbirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgiou_CityBirth_dd(driver, properties.getProperty("cityofBirth_dd")),citybirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ChartStyle(driver, properties.getProperty("chartStyle_dd")),chartstyle);
				
	}

	
private static void relgiousChristianInfo(WebDriver driver, Properties properties,String division,String relgiousValues)throws Exception{
	
	if(division.equals("Willing to marry from the same division")){
		click(RegisterPage2.Division_radiobtn1(driver, properties.getProperty("Division_radiobtn1")));}
		else{
		click(RegisterPage2.Division_radiobtn2(driver, properties.getProperty("Division_radiobtn2")));}
	selectElementByVisibleText(RegisterPage2.RelgiousValues_dd(driver, properties.getProperty("RelgiousValues_dropdown")),relgiousValues);
		
		
	}
private static void relgiousMuslimInfo(WebDriver driver, Properties properties,String division,String readQuran,String relgiousValues)throws Exception{
	if(division.equals("Willing to marry from the same division")){
		click(RegisterPage2.Division_radiobtn1(driver, properties.getProperty("Division_radiobtn1")));}
		else{
		click(RegisterPage2.Division_radiobtn2(driver, properties.getProperty("Division_radiobtn2")));}
	
	if(readQuran.equals("Regularly")){
		click(RegisterPage2.readQuran_Reg_radio(driver, properties.getProperty("readquran_regularly_rdio")));
				}
	else if(readQuran.equals("Occasionally"))
	{
		click(RegisterPage2.readQuran_Ocas_radio(driver, properties.getProperty("readquran_occasionaly_rdio")));
	}
	else if(readQuran.equals("Only jummah/Friday"))
	{
		click(RegisterPage2.readQuran_Only_radio(driver,properties.getProperty("readquran_only_rdio")));
	}
	else
	{
		click(RegisterPage2.readQuran_never_radio(driver, properties.getProperty("readquran_never_rdio")));
	}
	selectElementByVisibleText(RegisterPage2.RelgiousValues_dd(driver, properties.getProperty("RelgiousValues_dropdown")),relgiousValues);
		
	}
private static void relgiousBrahminAndDivoreceInfo(WebDriver driver,Properties properties,String division,String star,String rasi,String gothram,String dosham, String doshamType,
		String hours,String mins,String mridiem, String cbirth, String sbirth,String citybirth,String chartstyle)throws Exception{
	
	
		if(division.equals("Willing to marry from other subcaste also")){
		click(RegisterPage2.Division_radiobtn1(driver, properties.getProperty("Division_radiobtn1")));}
		else{
		click(RegisterPage2.Division_radiobtn2(driver, properties.getProperty("Division_radiobtn2")));}
	
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_star_dd(driver, properties.getProperty("star_dd")),star);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_rasi_dd(driver, properties.getProperty("rassi_dd")),rasi);
	Thread.sleep(1000);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_gothram_dd(driver, properties.getProperty("gothram_dd")),gothram);
	
	if(dosham.equals("Yes"))
	{
		click(RegisterPage2.brahminRelgious_doshamYes_radio(driver, properties.getProperty("dosham_Yes_radio")));
		if(doshamType.equals("Kuja Dosham")){
			click(RegisterPage2.brahminRelgious_Kuja_Cb(driver, properties.getProperty("dosham_Kuja_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Naga_Cb(driver, properties.getProperty("dosham_naga_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_KalaSarpa_Cb(driver, properties.getProperty("dosham_kalasarp_cb")));
		} else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Rahu_Cb(driver, properties.getProperty("dosham_rahu_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Kethu_Cb(driver, properties.getProperty("dosham_kethu_cb")));
		}else{
			click(RegisterPage2.brahminRelgious_Kalthra_Cb(driver, properties.getProperty("dosham_kalathra_cb")));
		}
	}else if(dosham.equals("No")){
		click(RegisterPage2.brahminRelgious_doshamNo_radio(driver, properties.getProperty("dosham_No_radio")));
	}else{
		click(RegisterPage2.brahminRelgious_doshamdntKnow_radio(driver, properties.getProperty("dosham_dontKnow_radio")));
	}	
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Hours_dd(driver, properties.getProperty("TimeofBirth_hours_dd")),hours);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Mins_dd(driver, properties.getProperty("TimeofBirth_mins_dd")),mins);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_Meridiem_dd(driver, properties.getProperty("meridiem_dd")),mridiem);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_CountryBirth_dd(driver, properties.getProperty("countryofBirth_dd")),cbirth);
	Thread.sleep(2000);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_StateBirth_dd(driver, properties.getProperty("stateofBirth_dd")),sbirth);
	Thread.sleep(2000);
	selectElementByVisibleText(RegisterPage2.brahminRelgiou_CityBirth_dd(driver, properties.getProperty("cityofBirth_dd")),citybirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ChartStyle(driver, properties.getProperty("chartStyle_dd")),chartstyle);
			
	}
private static void relgiousAryaVysyaInfo(WebDriver driver,Properties properties,String star,String rasi,String gothram,String dosham, String doshamType,
		String hours,String mins,String mridiem, String cbirth, String sbirth,String citybirth,String chartstyle)throws Exception{
	
				
	selectElementByVisibleText(RegisterPage2.brahminRelgious_star_dd(driver, properties.getProperty("star_dd")),star);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_rasi_dd(driver, properties.getProperty("rassi_dd")),rasi);
	Thread.sleep(1000);
	type(RegisterPage2.brahminRelgious_gothram_dd(driver, properties.getProperty("gothram_Text")),gothram);
	
	if(dosham.equals("Yes"))
	{
		click(RegisterPage2.brahminRelgious_doshamYes_radio(driver, properties.getProperty("dosham_Yes_radio")));
		if(doshamType.equals("Kuja Dosham")){
			click(RegisterPage2.brahminRelgious_Kuja_Cb(driver, properties.getProperty("dosham_Kuja_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Naga_Cb(driver, properties.getProperty("dosham_naga_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_KalaSarpa_Cb(driver, properties.getProperty("dosham_kalasarp_cb")));
		} else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Rahu_Cb(driver, properties.getProperty("dosham_rahu_cb")));
		}else if(doshamType.equals("")){
			click(RegisterPage2.brahminRelgious_Kethu_Cb(driver, properties.getProperty("dosham_kethu_cb")));
		}else{
			click(RegisterPage2.brahminRelgious_Kalthra_Cb(driver, properties.getProperty("dosham_kalathra_cb")));
		}
	}else if(dosham.equals("No")){
		click(RegisterPage2.brahminRelgious_doshamNo_radio(driver, properties.getProperty("dosham_No_radio")));
	}else{
		click(RegisterPage2.brahminRelgious_doshamdntKnow_radio(driver, properties.getProperty("dosham_dontKnow_radio")));
	}
	
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Hours_dd(driver, properties.getProperty("TimeofBirth_hours_dd")),hours);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Mins_dd(driver, properties.getProperty("TimeofBirth_mins_dd")),mins);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_Meridiem_dd(driver, properties.getProperty("meridiem_dd")),mridiem);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_CountryBirth_dd(driver, properties.getProperty("countryofBirth_dd")),cbirth);
	Thread.sleep(2000);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_StateBirth_dd(driver, properties.getProperty("stateofBirth_dd")),sbirth);
	Thread.sleep(2000);
	selectElementByVisibleText(RegisterPage2.brahminRelgiou_CityBirth_dd(driver, properties.getProperty("cityofBirth_dd")),citybirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ChartStyle(driver, properties.getProperty("chartStyle_dd")),chartstyle);
			
	}
private static void relgiousJainInfo(WebDriver driver,Properties properties,String division,String hours,String mins,String mridiem,String cbirth,String sbirth,String citybirth,
		String chartstyle )throws Exception{
	if(division.equals("Willing to marry from the same division")){
		click(RegisterPage2.Division_radiobtn1(driver, properties.getProperty("Division_radiobtn1")));}
		else{
		click(RegisterPage2.Division_radiobtn2(driver, properties.getProperty("Division_radiobtn2")));}
	
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Hours_dd(driver, properties.getProperty("TimeofBirth_hours_dd")),hours);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ToB_Mins_dd(driver, properties.getProperty("TimeofBirth_mins_dd")),mins);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_Meridiem_dd(driver, properties.getProperty("meridiem_dd")),mridiem);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_CountryBirth_dd(driver, properties.getProperty("countryofBirth_dd")),cbirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_StateBirth_dd(driver, properties.getProperty("stateofBirth_dd")),sbirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgiou_CityBirth_dd(driver, properties.getProperty("cityofBirth_dd")),citybirth);
	selectElementByVisibleText(RegisterPage2.brahminRelgious_ChartStyle(driver, properties.getProperty("chartStyle_dd")),chartstyle);
	
	}


public static void mouseOverActionForViewProfile(WebDriver driver,Properties properties)throws Exception
{
	String mouseoverLogout2=properties.getProperty("mouseoverLogout"); 
	Actions actions = new Actions(driver);
	
	WebElement mouseover=driver.findElement(By.xpath(mouseoverLogout2));
	actions.moveToElement(mouseover).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='userpop']/div[2]/div/div[1]/a/span[1]")).click(); 
	Thread.sleep(3000);
		 			}
public static void mouseOverActionForEditProfile(WebDriver driver,Properties properties)throws Exception
{
	String mouseoverLogout2=properties.getProperty("mouseoverLogout"); 
	Actions actions = new Actions(driver);
	
	WebElement mouseover=driver.findElement(By.xpath(mouseoverLogout2));
	actions.moveToElement(mouseover).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='userpop']/div[2]/div/div[3]/div[1]/ul/li[1]/a")).click(); 
	Thread.sleep(3000);
		 			}

public static void viewProfiles_WindowHandles(WebDriver driver,Properties properties)throws Exception
{	
	    String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.close();
		click(ViewProfilesPage.addPhoto_link(driver, properties.getProperty("loadProfileValues4")));
		click(ViewProfilesPage.viewProfile_Back(driver, properties.getProperty("viewProfile_Back")));
		driver.switchTo().window(parentHandle).close(); 				
		Thread.sleep(3000);		
}

public static void editProfiles_Edit(WebDriver driver,Properties properties2)throws Exception{
	
		click(EditProfilePage.editProfile_lin(driver, properties2.getProperty("editProfile_link")));
		Thread.sleep(5000);
	/*click(EditProfilePage.addPhoto_btn(driver, properties.getProperty("addPhoto_btn")));
	Thread.sleep(3000);
	System.out.println("Photo link opened");
	
	click(EditProfilePage.addPhoto_Pagelink(driver, properties.getProperty("addPhoto_Pagelink")));
	Thread.sleep(3000);
	String fileloc=" C:\\Mohan\\err.png";
	type(EditProfilePage.addPhoto_Pagelink(driver, properties.getProperty("addPhoto_Pagelink")),fileloc);	
	Thread.sleep(2000);
	System.out.println("Photos Uploded Successfully");*/	
		
}

public static void editProfiles_noOfChildren(WebDriver driver,Properties properties,String noOfChilds)throws Exception{
	
	
	if(noOfChilds.equals("1"))
	{
		click(EditProfilePage.NoOfChild0(driver,properties.getProperty("NoOfChild1")));
	}
	else if(noOfChilds.equals("2"))
	{
		click(EditProfilePage.NoOfChild0(driver,properties.getProperty("NoOfChild2")));
	}
	else if(noOfChilds.equals("3"))
	{
		click(EditProfilePage.NoOfChild0(driver,properties.getProperty("NoOfChild3")));
	}
	else if(noOfChilds.equals("4"))
	{
		click(EditProfilePage.NoOfChild0(driver,properties.getProperty("NoOfChild4")));
	}
	else
	{
		click(EditProfilePage.NoOfChild0(driver,properties.getProperty("NoOfChild0")));
	}
	
}

public static void deleteProfiles(WebDriver driver,Properties prop2,String passwrd) throws Exception
{
	Thread.sleep(1000);
	//click(DeleteProfilePage.settingScreen(driver, prop2.getProperty("settingsScreen")));
	//Thread.sleep(1000);
	Actions movingforSettings = new Actions(driver);
	movingforSettings.moveToElement(DeleteProfilePage.settingScreen(driver, prop2.getProperty("settingsScreen"))).build().perform();
	Thread.sleep(1000);
	click(DeleteProfilePage.accountSettings(driver, prop2.getProperty("accountSettings")));

	click(DeleteProfilePage.deleteProfile(driver, prop2.getProperty("deleteProfile")));

	click(DeleteProfilePage.otherReasons(driver, prop2.getProperty("otherReasons")));
	
	click(DeleteProfilePage.notSpecifyRadioBtns(driver, prop2.getProperty("notSpecifyRadioBtn")));
	
	click(DeleteProfilePage.submitBtn(driver, prop2.getProperty("submitBtn")));

	type(DeleteProfilePage.passwordforDelete(driver, prop2.getProperty("password")),passwrd);
	
	click(DeleteProfilePage.deleteBtn(driver, prop2.getProperty("deleteProfileBtn")));
	
	click(DeleteProfilePage.areUSureYes(driver, prop2.getProperty("areUSure_Yes")));
	
	System.out.println("Profile Deleted  : ");
		
}

public static void navigationURL(WebDriver driver,Properties properties,String username,String passwrd) throws Exception
{
	driver.navigate().to("https://communitymatrimony.com");	
	
	driver.manage().window().maximize();			
	
}

public static void register2page1(WebDriver driver,Properties properties,String communitysite) throws Exception
{
	
//domain fieldText 
	WebElement domainSelect=driver.findElement(By.xpath(".//*[@id='hpreg']/div/dl[1]/dt/label"));
	if((domainSelect.getText()).equals("Community Sites")&& domainSelect.isDisplayed())
	{
		System.out.println("Text of domainLabel : "+domainSelect.getText());
		System.out.println("FieldText of domainsites : "+domainSelect.getTagName());
		System.out.println("Color FieldText : "+domainSelect.getCssValue("color"));
		System.out.println("Size of FieldText domainSites" + domainSelect.getSize());
		
	}
	//domain Values --Postive Flow
		WebElement ddAll=driver.findElement(By.xpath(".//*[@id='domainName']"));
			Select selectAll= new Select (ddAll);
			List<WebElement> communityAll= selectAll.getOptions();
			System.out.println("size of Communitysite field DropDown"+communityAll.size());
			System.out.println("Input-Community is : "+communitysite);
			for(int i=0;i<communityAll.size();i++)
			{
				if((communityAll.get(i).getText()).equals(communitysite))
				{
					click(RegisterPage1.communitsites(driver, properties.getProperty("communitysites_dropdown")));
					selectAll.selectByVisibleText(communityAll.get(i).getText());
					System.out.println("Selected Element is : "+i+" "+communityAll.get(i).getText());
	
				}
			}
			System.out.println("Size of Element : "+ddAll.getSize());
			System.out.println("TagName of Element : "+ddAll.getTagName());
			for(int j=0;j<=0;j++)
			{
				System.out.println("Text of Element : "+j+""+ddAll.getText());
			}
			System.out.println("Location of Element : "+ddAll.getLocation());
			System.out.println("TextColor is "+ddAll.getCssValue("color"));

	//Negative Testing for communitySite field
			WebElement domainErrMsg=driver.findElement(By.xpath((".//*[@id='domainErr']")));
			System.out.println("Domain ErrMessage : "+domainErrMsg.getText());
			assertTrue(domainErrMsg.isDisplayed());

}
}
