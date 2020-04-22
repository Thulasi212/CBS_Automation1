package com.cm.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
/**
 * 
 * @author Thulasi
 *
 */
public class ViewProfileS2Test extends BaseTest {
    public ViewProfileS2Test()throws Throwable{
		HomePage.loadProperties();
	}	
    //***Login>>Listing Page>>view profile>>check Next& Prev buttons
	@Test
	public void viewProfiletest() throws Throwable{
		test=extent.createTest("View profile Scenorio2 Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		HomePage.matchesLink().click();
		test.pass("clicked on matches");
		try{
		HomePage.viewFullprofile().get(0).click();
		test.pass("clicked on View Profile");
		test.info("Passing the Driver control to child Window");
		Set<String> set=driver.getWindowHandles();
	    Iterator<String> it=set.iterator();
	    it.next();
	    String cId=it.next();
	    driver.switchTo().window(cId);
	    test.pass("driver Control is Successfully Passed to child Window");
	    Thread.sleep(6000);
		for(int i=0;i<=HomePage.nextLable().size()-1;i++){
			Thread.sleep(5000);
			if(HomePage.nextLable().get(i).isDisplayed()){
				test.pass("Next Label is Availble for profile "+(i+1));
			}
		    else{
			    test.pass("Next Label is not available for profile "+(i+1));
			}
			test.info("clicking on Next Button.......");
			HomePage.nextButton().get(i).click();
			test.pass("clicked on Next Button" );
			Thread.sleep(5000);
			if(HomePage.prevLable().get(i).isDisplayed()){
				test.pass("Prev Label is Availble for profile "+(i+1));
			}
		    else{
			    test.pass("prev Label is not available for profile "+(i+1));
			}	
			if(i==24){
				test.pass("clicked on Next Link");
			    HomePage.nextLink().click();
			}
		}
		}catch(Exception e){e.getMessage();}
		test.pass("Next Buttons And Prev buttons in View Profile Are successfully Verified ");
		driver.quit();
		test.pass("driver closed Successfully");
	}

}
