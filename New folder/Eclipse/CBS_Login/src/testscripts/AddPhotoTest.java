package testscripts;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage2;
import utility.BaseTest;
import utility.WebDriverWaitLib;


public class AddPhotoTest extends BaseTest{
    public static Properties properties;
    
    public AddPhotoTest()throws Throwable{
    	HomePage.loadProperties();
    }
		@Test
		public void addPhotoTest1() throws Throwable{
			test=extent.createTest("Add Photo Scenorio1 Test");
			LoginPage2.login();
			LoginPage2.intermediate_Popups();
			Thread.sleep(2000);
			boolean status=true;
			HomePage.profileIcon().click();
			test.pass("clicked on Profile Icon");
			status=false;
			test.pass("Uploading the Photo..............");
			Thread.sleep(5000);
			try{
				HomePage.addPhotoNow().click();
				test.pass("clicked on Add Photo");
				WebDriverWaitLib.waitElementToPresent(HomePage.addPhotoNow());
				try{
				HomePage.addPhotoNow().click();
				test.pass("clicked on Add Photo");
				}catch(Exception e){e.getMessage();}
				Thread.sleep(2000);
				test.pass("Triggering Autoit code for Photo Uploading.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
				test.pass("photo uploaded successfully");
				Thread.sleep(2000);
				    
			}catch(Exception e){e.getMessage();}
				
			try{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			it.next();
			String cId=it.next();
			driver.switchTo().window(cId);
			test.pass("driver Control is Successfully Passed to child Window");
			Thread.sleep(3000);
		    HomePage.addPhotoNow().click();
		    test.pass("clicked on Add Photo");
		    test.pass("Triggering Autoit code for Photo Uploading.........");
		    Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
			Thread.sleep(3000);
			test.pass("photo uploaded successfully");
			Thread.sleep(2000);
			}catch(Exception e){e.getMessage();}
			Dimension d=HomePage.image().getSize();
		    test.pass("Image size: "+d);
			int imageHeight=d.getHeight();
			test.pass("Image Height: "+imageHeight);
			int imageWidth=d.getWidth();
			test.pass("Image Width: "+imageWidth);
			if(status){
			test.pass("This profile is having a Photo");
			}
			
		}
		@Test
		public void addPhotoTest2() throws Throwable{
			test=extent.createTest("Add Photo Scenorio2 Test");
			LoginPage2.login();
			LoginPage2.intermediate_Popups();
			Thread.sleep(1000);
			boolean status=true;
			HomePage.profileIcon().click();
			test.pass("clicked on Profile Icon.");
			test.pass("Updating the Photo..............");
			Thread.sleep(5000);	
			try{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			it.next();
			String cId=it.next();
			driver.switchTo().window(cId);
			test.pass("driver Control is Successfully Passed to child Window");
			Thread.sleep(3000);
			if(HomePage.AddPhotoList().size()>0){
				HomePage.AddPhotoList().get(0).click();
				test.pass("clicked on Add Photo from List");
				status=false;
			}
		    test.pass("Triggering Autoit code for Photo Uploading.........");
		    Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
			Thread.sleep(3000);
			test.pass("photo updated successfully");
			Dimension d=HomePage.image().getSize();
		    test.pass("Image size: "+d);
			int imageHeight=d.getHeight();
			test.pass("Image Height: "+imageHeight);
			int imageWidth=d.getWidth();
			test.pass("Image Width: "+imageWidth);
			}catch(Exception e){e.getMessage();}
			if(status){
				test.pass("Add Photo Reached max. of Photos");
			}
			
			driver.close();
		}
}
		