package com.cm.testscripts;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.MarkAsViewedPage;

public class SearchTest extends BaseTest{
	public SearchTest() throws Throwable{
		LoginPage2.loadProperties();
		HomePage.loadProperties();
		MarkAsViewedPage.loadProperties();
	}
	/*@Test
	public static void CheckboxSearchTest() throws Throwable{
		test=extent.createTest("Checkbox In Search Test");
		//LoginPage2.login();
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",0,0);
    	String userName=eData.getExcelData("LoginTestData",0,1);
    	String password=eData.getExcelData("LoginTestData",0,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
		LoginPage2.intermediate_Popups();
		HomePage.searchLink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on search Link");
		test.info("Scenorio1: Unselecting All the check boxes and Feching All profiles .................");
		if(MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass("profiles already contacted checkbox is unselected");
		}
		if(MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is unselected");
			
		}
		if(MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is unselected");
			
		}
		if(MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is unselected");	
		}
		if(MarkAsViewedPage.profIHaveIgnoredCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveIgnoredCheckbox().click();
			test.pass("profiles i have Ignored checkbox is unselected");	
		}
		Thread.sleep(1000);
		MarkAsViewedPage.searchBtn().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on Search Button");
		int icount=0;
		test.pass("Fetching Not contacted profiles............");
		Thread.sleep(7000);
		for(int i=0;i<10;i++){
			String s=MarkAsViewedPage.interestedInHerOrHim().get(i).getText();
			if(s.contains("Interested in")){
				icount++;
			}
		}
		test.pass("Not contacted profiles count: "+icount);
		int iFCount=0;
		test.info("Fetching Already contacted profiles.........");
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.awaitingRespnse().get(i).getText();
				if(s.contains("Awaiting response from")){
					iFCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest sent(Free Id)-awaiting for Respose- profiles count: "+iFCount);
		int iPCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.remaindInterest().get(i).getText();
				if(s.contains("of your interest?")){
					iPCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest sent(Paid Id)-Remaind her/him of your interest-profiles count: "+iPCount);
		int mPCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.yetToReceiveReply().get(i).getText();
				if(s.contains("You are yet to receive a reply from")){
					mPCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Message sent-yet to reply from her/him- profiles count: "+mPCount);
		int mDcdCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.messageDeclined().get(i).getText();
				if(s.contains("Your message was declined !")){
					mDcdCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Messade Declined-profiles count: "+mDcdCount);
		int iDcdCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.interestDeclined().get(i).getText();
				if(s.contains("Your interest was declined !")){
					iDcdCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest Declined-profiles count: "+iDcdCount);
		test.pass("Total contacted Profiles count: "+(iFCount+iPCount+mPCount+mDcdCount+iDcdCount));
		test.pass("Fetching  Not Viewed profiles................");
		int notViewedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.markedAsViewed().get(i).getText();
				if(m.contains("Mark as Viewed")){
					notViewedcount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Not Viewed profiles  count: "+notViewedcount);
		test.info("Fetching Already viewed profiles.........");
		int viewedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.viewedOn().get(i).getText();
				if(m.contains("Viewed on"))viewedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Viewed profiles  count: "+viewedcount);
		test.info("Fetching Not Shortlisted profiles............");
		int shortlistcount=0;
		try{
			for(int i=0;i<10;i++){
				if(MarkAsViewedPage.shortlistIconList().get(i).isDisplayed())shortlistcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Not Shortlisted profiles count: "+shortlistcount);
		test.info("Fetching already shortlisted profiles..........");
		int shortlistedcount=0;
		try{
			for(int i=0;i<10;i++){
				if(MarkAsViewedPage.shortlistedIconList().get(i).isDisplayed())shortlistedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Shortlisted profiles count: "+shortlistedcount);
		test.info("Feching Blocked profiles.............");
		int blockedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromBlockList().get(i).getText();
				if(m.contains("Remove from Block List"))blockedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("blocked profiles  count: "+blockedcount);
		test.info("Fetching Ignored profiles.................");
		int ingnoredcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromIgnoreList().get(i).getText();
				if(m.contains("Remove from Ignore List"))ingnoredcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Ignored profiles  count: "+ingnoredcount);
		Thread.sleep(1000);
		test.info("Scenorio2: Selecting contacted checkbox and verifying Not contacted profiles...........");
		if(!MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass(" contacted checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		test.pass("clicked on submit button");
		Thread.sleep(7000);
		int count=0;
		for(int i=0;i<10;i++){
			String s=MarkAsViewedPage.interestedInHerOrHim().get(i).getText();
			if(s.contains("Interested in")){
				count++;
			}
		}
		test.pass("Interested in him/her? count: "+count);
		if(count==10){
			test.pass("contacted profiles are verified successfully ");
		}
		else{
			test.fail(" contacted profiles are not  related to search ");
		}
		Thread.sleep(2000);
		test.info("Scenorio3: Selecting viewed check box and verifying Not viewed profiles...........");
		if(MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass("profiles already contacted checkbox is unselected");
		}
		if(!MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		test.pass("clicked on submit button");
		Thread.sleep(7000);
		int count2=0;
		for(int i=0;i<10;i++){
			String m=MarkAsViewedPage.markedAsViewed().get(i).getText();
			if(m.contains("Mark as Viewed")){
				count2++;
			}
		}
		test.pass("Mark As viewed  count: "+count2);
		if(count2==10){
			test.pass("Mark as viewed  profiles are related to search");
		}
		else{
			test.fail("Mark as viewed profiles are not related to search");
		}
		Thread.sleep(2000);
		test.info("Scenorio4: selecting shortlisted check box and verifying Not shorlisted profiles........");
		if(MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is unselected");
		}
		if(!MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int count3=0;
		for(int i=0;i<10;i++){
			if(MarkAsViewedPage.shortlistIconList().get(i).isDisplayed())count3++;
		}
		test.pass("Not shortlisted profiles count: "+count3);
		if(count3==10){
			test.pass("Shorlist option profiles are related to search");
		}
		else{
			test.fail("shortlist option profiles are not related to search");
		}
		test.info("Scenorio5: selecting Blocked check box and verifying blocked profiles are present or not ........");
		if(MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is unselected");
		}
		if(!MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is selected");	
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int bCount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromBlockList().get(i).getText();
				if(m.contains("Remove from Block List")){
					bCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("blocked profiles  count: "+bCount);
		if(bCount==0){
			test.pass("Blocked profiles are not present in the list");
		}
		else{
			test.fail("Blocked profiles are present in the list");
		}
		test.info("Scenorio5: selecting Ignored check box and verifying Ignored profiles are present or not ........");
		if(MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is unselected");	
		}
		if(!MarkAsViewedPage.profIHaveIgnoredCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveIgnoredCheckbox().click();
			test.pass("profiles i have Ignored checkbox is selected");	
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int ingcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromIgnoreList().get(i).getText();
				if(m.contains("Remove from Ignore List"))ingcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Ignored profiles  count: "+ingcount);
		if(ingcount==0){
			test.pass("Igonred profiles are not present in the list");
		}
		else{
			test.fail("Igonred profiles are  present in the list");
		}
		LoginPage2.logout();
		driver.close();
	}*/
	@Test
	public static void CheckboxInLatestMatchesTest() throws Throwable{
		test=extent.createTest("Checkbox In LatestMatches Regular Search Test");
		//LoginPage2.login();
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",0,0);
    	String userName=eData.getExcelData("LoginTestData",0,1);
    	String password=eData.getExcelData("LoginTestData",0,2);
    	Actions act=new Actions(driver);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
		LoginPage2.intermediate_Popups();
		act.moveToElement(HomePage.matchesLink()).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage.latestMatches().click();
		test.info("Scenorio1: Unselecting All the check boxes and Feching All profiles .................");
		if(MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass("profiles already contacted checkbox is unselected");
		}
		if(MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is unselected");
			
		}
		if(MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is unselected");
			
		}
		if(MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is unselected");	
		}
		if(MarkAsViewedPage.profIHaveIgnoredCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveIgnoredCheckbox().click();
			test.pass("profiles i have Ignored checkbox is unselected");	
		}
		Thread.sleep(1000);
		MarkAsViewedPage.searchOptionSubmit().click();
		test.pass("clicked on submit button");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int icount=0;
		test.pass("Fetching Not contacted profiles............");
		Thread.sleep(7000);
		for(int i=0;i<10;i++){
			String s=MarkAsViewedPage.interestedInHerOrHim().get(i).getText();
			if(s.contains("Interested in")){
				icount++;
			}
		}
		test.pass("Not contacted profiles count: "+icount);
		int iFCount=0;
		test.info("Fetching Already contacted profiles.........");
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.awaitingRespnse().get(i).getText();
				if(s.contains("Awaiting response from")){
					iFCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest sent(Free Id)-awaiting for Respose- profiles count: "+iFCount);
		int iPCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.remaindInterest().get(i).getText();
				if(s.contains("of your interest?")){
					iPCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest sent(Paid Id)-Remaind her/him of your interest-profiles count: "+iPCount);
		int mPCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.yetToReceiveReply().get(i).getText();
				if(s.contains("You are yet to receive a reply from")){
					mPCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Message sent-yet to reply from her/him- profiles count: "+mPCount);
		int mDcdCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.messageDeclined().get(i).getText();
				if(s.contains("Your message was declined !")){
					mDcdCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Messade Declined-profiles count: "+mDcdCount);
		int iDcdCount=0;
		try{
			for(int i=0;i<10;i++){
				String s=MarkAsViewedPage.interestDeclined().get(i).getText();
				if(s.contains("Your interest was declined !")){
					iDcdCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Interest Declined-profiles count: "+iDcdCount);
		test.pass("Total contacted Profiles count: "+(iFCount+iPCount+mPCount+mDcdCount+iDcdCount));
		test.pass("Fetching  Not Viewed profiles................");
		int notViewedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.markedAsViewed().get(i).getText();
				if(m.contains("Mark as Viewed")){
					notViewedcount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Not Viewed profiles  count: "+notViewedcount);
		test.info("Fetching Already viewed profiles.........");
		int viewedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.viewedOn().get(i).getText();
				if(m.contains("Viewed on"))viewedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Viewed profiles  count: "+viewedcount);
		test.info("Fetching Not Shortlisted profiles............");
		int shortlistcount=0;
		try{
			for(int i=0;i<10;i++){
				if(MarkAsViewedPage.shortlistIconList().get(i).isDisplayed())shortlistcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Not Shortlisted profiles count: "+shortlistcount);
		test.info("Fetching already shortlisted profiles..........");
		int shortlistedcount=0;
		try{
			for(int i=0;i<10;i++){
				if(MarkAsViewedPage.shortlistedIconList().get(i).isDisplayed())shortlistedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Shortlisted profiles count: "+shortlistedcount);
		test.info("Feching Blocked profiles.............");
		int blockedcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromBlockList().get(i).getText();
				if(m.contains("Remove from Block List"))blockedcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("blocked profiles  count: "+blockedcount);
		test.info("Fetching Ignored profiles.................");
		int ingnoredcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromIgnoreList().get(i).getText();
				if(m.contains("Remove from Ignore List"))ingnoredcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Ignored profiles  count: "+ingnoredcount);
		Thread.sleep(1000);
		test.info("Scenorio2: Selecting contacted checkbox and verifying Not contacted profiles...........");
		if(!MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass(" contacted checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		test.pass("clicked on submit button");
		Thread.sleep(7000);
		int count=0;
		for(int i=0;i<10;i++){
			String s=MarkAsViewedPage.interestedInHerOrHim().get(i).getText();
			if(s.contains("Interested in")){
				count++;
			}
		}
		test.pass("Interested in him/her? count: "+count);
		if(count==10){
			test.pass("contacted profiles are verified successfully ");
		}
		else{
			test.fail(" contacted profiles are not  related to search ");
		}
		Thread.sleep(2000);
		test.info("Scenorio3: Selecting viewed check box and verifying Not viewed profiles...........");
		if(MarkAsViewedPage.profAlreadyContCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyContCheckbox().click();
			test.pass("profiles already contacted checkbox is unselected");
		}
		if(!MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		test.pass("clicked on submit button");
		Thread.sleep(7000);
		int count2=0;
		for(int i=0;i<10;i++){
			String m=MarkAsViewedPage.markedAsViewed().get(i).getText();
			if(m.contains("Mark as Viewed")){
				count2++;
			}
		}
		test.pass("Mark As viewed  count: "+count2);
		if(count2==10){
			test.pass("Mark as viewed  profiles are related to search");
		}
		else{
			test.fail("Mark as viewed profiles are not related to search");
		}
		Thread.sleep(2000);
		test.info("Scenorio4: selecting shortlisted check box and verifying Not shorlisted profiles........");
		if(MarkAsViewedPage.profAlreadyViewedCheckbox().isSelected()){
			MarkAsViewedPage.profAlreadyViewedCheckbox().click();
			test.pass("profiles already viewed checkbox is unselected");
		}
		if(!MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is selected");
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int count3=0;
		for(int i=0;i<10;i++){
			if(MarkAsViewedPage.shortlistIconList().get(i).isDisplayed())count3++;
		}
		test.pass("Not shortlisted profiles count: "+count3);
		if(count3==10){
			test.pass("Shorlist option profiles are related to search");
		}
		else{
			test.fail("shortlist option profiles are not related to search");
		}
		test.info("Scenorio5: selecting Blocked check box and verifying blocked profiles are present or not ........");
		if(MarkAsViewedPage.shortlistedProfilesCheckbox().isSelected()){
			MarkAsViewedPage.shortlistedProfilesCheckbox().click();
			test.pass("shortlisted profiles  checkbox is unselected");
		}
		if(!MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is selected");	
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int bCount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromBlockList().get(i).getText();
				if(m.contains("Remove from Block List")){
					bCount++;
				}
			}
		}catch(Exception e){e.getMessage();}
		test.pass("blocked profiles  count: "+bCount);
		if(bCount==0){
			test.pass("Blocked profiles are not present in the list");
		}
		else{
			test.fail("Blocked profiles are present in the list");
		}
		test.info("Scenorio5: selecting Ignored check box and verifying Ignored profiles are present or not ........");
		if(MarkAsViewedPage.profIHaveBlockedCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveBlockedCheckbox().click();
			test.pass("profiles i have blocked checkbox is unselected");	
		}
		if(!MarkAsViewedPage.profIHaveIgnoredCheckbox().isSelected()){
			MarkAsViewedPage.profIHaveIgnoredCheckbox().click();
			test.pass("profiles i have Ignored checkbox is selected");	
		}
		MarkAsViewedPage.searchOptionSubmit().click();
		Thread.sleep(7000);
		test.pass("clicked on submit button");
		int ingcount=0;
		try{
			for(int i=0;i<10;i++){
				String m=MarkAsViewedPage.removeFromIgnoreList().get(i).getText();
				if(m.contains("Remove from Ignore List"))ingcount++;
			}
		}catch(Exception e){e.getMessage();}
		test.pass("Ignored profiles  count: "+ingcount);
		if(ingcount==0){
			test.pass("Igonred profiles are not present in the list");
		}
		else{
			test.fail("Igonred profiles are  present in the list");
		}
		LoginPage2.logout();
		driver.close();
	}

}
