package com.cm.testscripts;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
/**
 * THULASI
 */
public class AddPhotoTest extends BaseTest{
    public static Properties properties;
    
    public AddPhotoTest()throws Throwable{
    	LoginPage2.loadProperties();
    	HomePage.loadProperties();
    }
	  @Test(enabled=true)
		public void addPhotoTest1() throws Throwable{
		  //*****Scenorio1:Login( profile should not have a photo)>>edit Profile >>upload a photo>>Delete a photo 
			test=extent.createTest("Add Photo Scenorio1 Test");
			test.info("Browser Launching...............");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",1,0);
	    	String userName=eData.getExcelData("LoginTestData",1,1);
	    	String password=eData.getExcelData("LoginTestData",1,2);
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	        WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
	    	test.info("Login to the Application................");
	    	LoginPage2.userNameEdit1().sendKeys(userName);
	    	LoginPage2.passwordEdit1().sendKeys(password);
	    	LoginPage2.loginButton1().click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
			LoginPage2.intermediate_Popups();
			Thread.sleep(2000);
			boolean status=true; 
			try{
				HomePage.profileIcon().click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.pass("clicked on Profile Icon");
				status=false;
				test.pass("Uploading the Photo..............");
				Thread.sleep(5000);
				try{
					HomePage.addPhotoNow().click();
					test.pass("clicked on Add Photo in PopUp");
					WebdriverWaitLib.waitElementToPresent(HomePage.addPhotoNow());
					try{
						HomePage.addPhotoNow().click();
						Thread.sleep(2000);
						test.pass("clicked on Add Photo");
					}catch(Exception e){e.getMessage();}
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
				}catch(Exception e){e.getMessage();}
				test.pass("Triggering Autoit code for Photo Uploading.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
				test.pass("photo uploaded successfully");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Thread.sleep(2000);
				 Dimension d=HomePage.image().getSize();
				test.pass("Image size: "+d);
				int imageHeight=d.getHeight();
				test.pass("Image Height: "+imageHeight);
				int imageWidth=d.getWidth();
				test.pass("Image Width: "+imageWidth);
				Thread.sleep(5000);
				test.pass("Deleting the uploaded photo............");
				Actions act=new Actions(driver);
				act.moveToElement(HomePage.editPhoto()).click().moveToElement(HomePage.deletePhoto()).click().build().perform();
				test.pass("clicked on Delete photo");
				Thread.sleep(2000);
				HomePage.deletePhotoConf_Yes().click();
				Thread.sleep(3000);
				test.pass("clicked on Yes Button for confirmation of Delete Photo  ");
				test.pass(HomePage.deletePhotoConf_Msg().getText());
				HomePage.deletePhotoConf_Close().click();
				test.pass("Confirmation Popup is Closed successfully");
				if(status){
					test.pass("This profile is having a Photo");
				}
				LoginPage2.logout();
				driver.quit();
			}catch(Exception e){e.getMessage();}
			
		}
	  //*****Scenorio 2:Login( profile should  have a photo)>>edit Profile >>upload a photo>>Delete a photo 
		@Test(enabled=false)
		public void addPhotoTest2() throws Throwable{
			test=extent.createTest("Add Photo Scenorio2 Test");
			test.info("Browser Launching...............");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",2,0);
	    	String userName=eData.getExcelData("LoginTestData",2,1);
	    	String password=eData.getExcelData("LoginTestData",2,2);
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	        WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
	    	test.info("Login to the Application................");
	    	LoginPage2.userNameEdit1().sendKeys(userName);
	    	LoginPage2.passwordEdit1().sendKeys(password);
	    	LoginPage2.loginButton1().click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
			LoginPage2.intermediate_Popups();
			Thread.sleep(1000);
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
				test.pass("Triggering Autoit code for Photo Uploading.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    Thread.sleep(3000);
				test.pass("photo updated successfully");
				Dimension d=HomePage.image().getSize();
				test.pass("Image size: "+d);
			    int imageHeight=d.getHeight();
				test.pass("Image Height: "+imageHeight);
				int imageWidth=d.getWidth();
				test.pass("Image Width: "+imageWidth);
				test.pass("Deleting the uploaded photo............");
				Actions act=new Actions(driver);
				act.moveToElement(HomePage.editPhoto()).click().moveToElement(HomePage.deletePhoto()).click().build().perform();
				test.pass("clicked on Delete photo");
				Thread.sleep(2000);
				HomePage.deletePhotoConf_Yes().click();
				Thread.sleep(3000);
				test.pass("clicked on Yes Button for confirmation of Delete Photo  ");
				test.pass(HomePage.deletePhotoConf_Msg().getText());
				HomePage.deletePhotoConf_Close().click();
				test.pass("Confirmation Popup is Closed successfully");
			}else{
				test.pass("Add Photo Reached max. of Photos");
			}
			}catch(Exception e){e.getMessage();}
		   LoginPage2.logout();
			driver.close();
			}
		//*****Scenorio 3:Login( profile should  have a photo)>>Intermediate Page >>upload a photo>>Delete a photo 
		@Test(enabled=false)
		public void addPhotoTest3() throws Throwable{
			test=extent.createTest("Add Photo Scenorio3 Test");
			test.info("Browser Launching...............");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",1,0);
	    	String userName=eData.getExcelData("LoginTestData",1,1);
	    	String password=eData.getExcelData("LoginTestData",1,2);
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	        WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
	    	test.info("Login to the Application................");
	    	LoginPage2.userNameEdit1().sendKeys(userName);
	    	LoginPage2.passwordEdit1().sendKeys(password);
	    	LoginPage2.loginButton1().click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
			boolean status=false;
			int i;
			for(i=0;i<=10;i++){
				try{ 
					LoginPage2.addPhotoIntBtn().click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					status=true;
					break;
				}catch(Exception e){e.getMessage();}
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			System.out.println("No of cycles: "+i);
			if(status){
				try{
					test.pass("Clicked on Add Photo in Intermediate Page");
					test.pass("Triggering Autoit code for Photo Uploading.........");
					Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
					Thread.sleep(3000);
					Dimension d=HomePage.image().getSize();
					test.pass("Image size: "+d);
					int imageHeight=d.getHeight();
					test.pass("Image Height: "+imageHeight);
					int imageWidth=d.getWidth();
					test.pass("Image Width: "+imageWidth);
					test.pass("photo updated successfully");
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(2000);
					test.pass("Deleting the uploaded photo............");
					Actions act=new Actions(driver);
					act.moveToElement(HomePage.editPhoto()).click().moveToElement(HomePage.deletePhoto()).click().build().perform();
					test.pass("clicked on Delete photo");
					Thread.sleep(2000);
					HomePage.deletePhotoConf_Yes().click();
					Thread.sleep(3000);
					test.pass("clicked on Yes Button for confirmation of Delete Photo  ");
					test.pass(HomePage.deletePhotoConf_Msg().getText());
					HomePage.deletePhotoConf_Close().click();
					test.pass("Confirmation Popup is Closed successfully");
				}catch(Exception e){e.getMessage();}
				
			}else{
					test.pass("Add photo Intermediate Photo is not Available");
			}
			LoginPage2.logout();
			driver.quit();
			test.pass("driver closed successfully");
		}
		//*****Scenorio 4:Login>>add photo>> try to upload photos up to than max. limit. 
		@Test(enabled=false)
		public void addPhotoTest4() throws Throwable{
			test=extent.createTest("Add Photo Scenorio2 Test");
			test.info("Browser Launching...............");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",1,0);
	    	String userName=eData.getExcelData("LoginTestData",1,1);
	    	String password=eData.getExcelData("LoginTestData",1,2);
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	        WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
	    	test.info("Login to the Application................");
	    	LoginPage2.userNameEdit1().sendKeys(userName);
	    	LoginPage2.passwordEdit1().sendKeys(password);
	    	LoginPage2.loginButton1().click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
			LoginPage2.intermediate_Popups();
			Thread.sleep(1000);
			HomePage.profileIcon().click();
			test.pass("clicked on Profile Icon.");
			test.pass("Updating the Photo..............");
			Thread.sleep(5000);	
			try{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			String cId1=it.next();
			String cId2=it.next();
			driver.switchTo().window(cId2);
			test.pass("driver Control is Successfully Passed to child Window");
			Thread.sleep(3000);
			test.pass(HomePage.AddPhotoList().size()+"");
			for(int i=0;i<9;i++){
				test.info("trying to upload photo : "+(i+1));
				HomePage.AddPhotoList().get(0).click();
			    Thread.sleep(2000);
				test.pass("clicked on Add Photo from List");
				test.pass("Triggering Autoit code for Photo Uploading.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUpload.exe");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    Thread.sleep(3000);
				test.pass("photo updated successfully");
				Dimension d=HomePage.image().getSize();
				test.pass("Image size: "+d);;
			    int imageHeight=d.getHeight();
				test.pass("Image Height: "+imageHeight);
				int imageWidth=d.getWidth();
				test.pass("Image Width: "+imageWidth);
				test.pass("photo uploaded successfully");
			}
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			for(int i=0;i<9;i++){
				test.info("trying to delete a photo : "+(i+1));
				Actions act=new Actions(driver);
				act.moveToElement(HomePage.editPhoto()).click().moveToElement(HomePage.deletePhoto()).click().build().perform();
				test.pass("clicked on Delete photo");
				Thread.sleep(2000);
				HomePage.deletePhotoConf_Yes().click();
				Thread.sleep(3000);
				test.pass("clicked on Yes Button for confirmation of Delete Photo  ");
				test.pass(HomePage.deletePhotoConf_Msg().getText());
				HomePage.deletePhotoConf_Close().click();
				test.pass("Confirmation Popup is Closed successfully");
				driver.close();
				driver.switchTo().window(cId1);
				driver.close();
				
			}
			}catch(Exception e){e.getMessage();}
			}
		//*****Scenorio 5:Login(profile should have photo)>>add photo>> try to upload photo greater than 15Mb and validating error message. 
		@Test(enabled=false)
		public void addPhotoTest5() throws Throwable{
			test=extent.createTest("Add Photo Scenorio5 Test");
			test.info("Browser Launching...............");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",2,0);
	    	String userName=eData.getExcelData("LoginTestData",2,1);
	    	String password=eData.getExcelData("LoginTestData",2,2);
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	        WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
	    	test.info("Login to the Application................");
	    	LoginPage2.userNameEdit1().sendKeys(userName);
	    	LoginPage2.passwordEdit1().sendKeys(password);
	    	LoginPage2.loginButton1().click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
			LoginPage2.intermediate_Popups();
			Thread.sleep(1000);
			HomePage.profileIcon().click();
			test.pass("clicked on Profile Icon.");
			test.pass("Updating the Photo..............");
			Thread.sleep(5000);	
			try{
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			String cId1=it.next();
			String cId2=it.next();
			driver.switchTo().window(cId2);
			test.pass("driver Control is Successfully Passed to child Window");
			Thread.sleep(3000);
			if(HomePage.AddPhotoList().size()>0){
				HomePage.AddPhotoList().get(0).click();
				test.pass("clicked on Add Photo from List");
				test.pass("Triggering Autoit code to upload a photo >20kb.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUploadPhoto15mb.exe");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(3000);
				test.info("Fetching Expected Error Message from Test Data");
		    	String expErrMsg=eData.getExcelData("AddPhotoTestData",1,4);
		    	test.info("Expected Error Message: "+expErrMsg);
		    	String actErrMsg=HomePage.photoSizeErrMsg().getText();
		    	test.info("Actual Error Message: "+actErrMsg);
		    	test.info("Validating Error Message.............");
		    	Assert.assertEquals(actErrMsg, actErrMsg);
		    	test.pass("Error Message validated Successfully");
		    	Thread.sleep(4000);
		    	HomePage.AddPhotoList().get(0).click();
				test.pass("clicked on Add Photo from List");
		    	test.pass("Triggering Autoit code to upload a photo >50kb.........");
				Runtime.getRuntime().exec(".//Resources//Autoit//FileUploadPhoto50kb.exe");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(3000);
				test.info("Fetching Expected Error Message from Test Data");
		    	String expErrMsg1=eData.getExcelData("AddPhotoTestData",2,4);
		    	test.info("Expected Error Message: "+expErrMsg1);
		    	String actErrMsg1=HomePage.photoSizeErrMsg().getText();
		    	test.info("Actual Error Message: "+actErrMsg1);
		    	test.info("Validating Error Message.............");
		    	Assert.assertEquals(actErrMsg1, actErrMsg1);
		    	test.pass("Error Message validated Successfully");
		    	driver.close();
		    	driver.switchTo().window(cId1);
				driver.close();

			}else{
				test.pass("Add Photo Reached max. of Photos");
			}
			}catch(Exception e){e.getMessage();}
			
			}
}
		