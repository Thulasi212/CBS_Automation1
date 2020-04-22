package testscripts;




import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage2;
import utility.BaseTest;
import utility.WebDriverWaitLib;


public class ViewProfileS2Test extends BaseTest {
    public ViewProfileS2Test()throws Throwable{
		HomePage.loadProperties();
	}	
	@Test
	public void viewProfiletest() throws Throwable{
		test=extent.createTest("View profile Scenorio2 Test");
		//LoginPage2.login();
		
		driver.get("https://www.communitymatrimony.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='idEmail']")).sendKeys("EZH710533");
		
		WebDriverWaitLib.waitElementToPresent(driver.findElement(By.id("passwordClear1")));
		driver.findElement(By.id("passwordClear1")).click();
		
 	   WebDriverWaitLib.waitPageToLoad();
 	driver.findElement(By.id("password1")).sendKeys("cbstest");
 	
 	WebDriverWaitLib.waitPageToLoad();
 	driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
 	
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		
		HomePage.matchesLink().click();
		test.pass("clicked on matches");
		
		try{
			Thread.sleep(2000);
		HomePage.viewFullprofile().get(0).click();
		test.pass("clicked on View Profile");
		test.info("Passing the Driver control to child Window");
		Thread.sleep(2000);
		Set<String> set=driver.getWindowHandles();
	    Iterator<String> it=set.iterator();
	    it.next();
	    String cId=it.next();
	    Thread.sleep(2000);
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
			Thread.sleep(2000);
			test.info("clicking on Next Button.......");
			HomePage.nextButton().get(i).click();
			
			test.pass("clicked on Next Button" );
			
			Thread.sleep(2000);
			if(HomePage.prevLable().get(i).isDisplayed()){
				test.pass("Prev Label is Availble for profile "+(i+1));
			}
		    else{
			    test.pass("prev Label is not available for profile "+(i+1));
			}	
			Thread.sleep(2000);
			if(i==24){
				test.pass("clicked on Next Link");
			    HomePage.nextLink().click();
			}
		}
		test.pass("Next Buttons And Prev buttons in View Profile Are successfully Verified ");
		}catch(Exception e){e.getMessage();}
		driver.close();
	}
	

}

