package com.cm.testscripts;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.businessFunctions.BussinessFunctions;
import com.cm.pages.LoginPage2;
import com.cm.pages.SpecificRegisterpage;
public class SpecificRegisterTest extends BaseTest {
	public static String url,matriid;
	public static Properties properties;
	public SpecificRegisterTest() throws Throwable{
		SpecificRegisterpage.loadProperties();
		LoginPage2.loadProperties();
		properties=new Properties();
		FileInputStream objectsinput1 = new FileInputStream(new File(".\\ObjectRepository\\Registration.properties"));
		properties.load(objectsinput1);
	}
@Test
public void bramhinRegisterTest() throws Throwable{
	test=extent.createTest("Bramhin Registration Test");
	test.pass("Browser Launching.................");
	ExcelData edata=new ExcelData();
    url=edata.getExcelData("SpecificRegister", 1, 0);
	test.pass("Navigating to the url........"+url);
	driver.get(url);
	test.pass("Application Launched successfully with Domain: "+url);
	test.pass("Registration started.......");
	String prof=edata.getExcelData("SpecificRegister", 1, 1);
	new Select(SpecificRegisterpage.profCreatedBy()).selectByVisibleText(prof);
	test.pass("profile Created By: "+prof);
	String name=edata.getExcelData("SpecificRegister", 1, 2);
	SpecificRegisterpage.name().sendKeys(name);
	test.pass("Name: "+name);
	String gender=edata.getExcelData("SpecificRegister", 1, 3);
	if(gender.equalsIgnoreCase("Male")){
		SpecificRegisterpage.male().click();
		test.pass("clicked on male Button");
	}
	else{
		SpecificRegisterpage.female().click();
		test.pass("clicked on Female Button");
	}
	String day=edata.getExcelData("SpecificRegister", 1, 4);
	new Select(SpecificRegisterpage.birthDay()).selectByVisibleText(day);
	test.pass("Date of Birth-Date selected as: "+day);
	String month=edata.getExcelData("SpecificRegister", 1, 5);
	new Select(SpecificRegisterpage.birthMonth()).selectByVisibleText(month);
	test.pass("Date of Birth-Month selected as: "+month);
	String year=edata.getExcelData("SpecificRegister", 1, 6);
	new Select(SpecificRegisterpage.birthYear()).selectByVisibleText(year);
	test.pass("Date of Birth-Year  selected as: "+year);
	String mStatus=edata.getExcelData("SpecificRegister", 1, 7);
	boolean status=true;
	if(mStatus.equalsIgnoreCase("Unmarried")){
		SpecificRegisterpage.unmarried().click();
		status=false;
		test.pass("clicked on Unmarried");
	}else if (mStatus.contains("Window")) {
		SpecificRegisterpage.widowOrWidower().click();
		test.pass("clicked on Widow/widower");
	}else if (mStatus.equalsIgnoreCase("Divorced")) {
		SpecificRegisterpage.divorced().click();
		test.pass("clicked on Divorced");
	}else{
		SpecificRegisterpage.seperated().clear();
		test.pass("clicked on Seperated");
	}
	String caste=edata.getExcelData("SpecificRegister", 1, 8);
	new Select(SpecificRegisterpage.casteOrDivision()).selectByVisibleText(caste);
	test.pass("Selected Caste/Division: "+caste);
	String subCaste=edata.getExcelData("SpecificRegister", 1, 9);
	SpecificRegisterpage.subCaste().sendKeys(subCaste);
	test.pass("Selected SubCaste: "+subCaste);
	String mT=edata.getExcelData("SpecificRegister", 1, 10);
	new Select(SpecificRegisterpage.motherTongue()).selectByVisibleText(mT);
	test.pass("Selected Mother Tongue: "+mT);
	String countryLive=edata.getExcelData("SpecificRegister", 1, 11);
	new Select(SpecificRegisterpage.countryLivingIn()).selectByVisibleText(countryLive);
	test.pass("Selected Country Living In: "+countryLive);
	new Select(SpecificRegisterpage.mobNoCountryCode()).selectByIndex(2);
	test.pass("Selected Country Living In: United States of America");
	String mobNo=edata.getExcelData("SpecificRegister", 1, 13);
	SpecificRegisterpage.mobNo().sendKeys(mobNo);
	test.pass("Mobile No is Entered");
	String pw=edata.getExcelData("SpecificRegister", 1, 14);
	SpecificRegisterpage.loginPassword().sendKeys(pw);
	test.pass("password is entered");
	SpecificRegisterpage.rigisterNow().click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	String email=edata.getExcelData("SpecificRegister", 1, 15)+Math.floor(Math.random() * 143231)+ "@gmail.com";
	SpecificRegisterpage.email().sendKeys(email);
	test.pass("Email is entered");
	if(status){
		SpecificRegisterpage.noOfChildren().click();
		test.pass("clicked on No.of Children: None");
	}
	String height=edata.getExcelData("SpecificRegister", 1, 16);
	new Select(SpecificRegisterpage.height()).selectByVisibleText(height);
	test.pass("selected height: "+height);
	SpecificRegisterpage.physicalStatus_normal().click();
	test.pass("clicked on Physical status: Normal Button");
	String residingState=edata.getExcelData("SpecificRegister", 1, 18);
	new Select(SpecificRegisterpage.residingState()).selectByVisibleText(residingState);
	test.pass("selected Residing state: "+residingState);
	String residingCity=edata.getExcelData("SpecificRegister", 1, 19);
	new Select(SpecificRegisterpage.residingCity()).selectByVisibleText(residingCity);
	test.pass("selected Residing City: "+residingCity);
	String citizenship=edata.getExcelData("SpecificRegister", 1, 20);
	new Select(SpecificRegisterpage.citizenship()).selectByVisibleText(citizenship);
	test.pass("selected citizenship: "+citizenship);
	String willingToMarry=edata.getExcelData("SpecificRegister", 1, 40);
	if(willingToMarry.equalsIgnoreCase("same division")){
		SpecificRegisterpage.sameCasteOrDivision().click();
		test.pass("clicked on Same division");
	}else{
		SpecificRegisterpage.otherCasteorDivision().click();
		test.pass("clicked on Other Division Also");
	}
	String star=edata.getExcelData("SpecificRegister", 1, 21);
	new Select(SpecificRegisterpage.star()).selectByVisibleText(star);
	test.pass("Selected Star: "+star);
	new Select(SpecificRegisterpage.raasi()).selectByIndex(2);
	test.pass("selected Raasi : Kanya (Virgo)");
	String gothra=edata.getExcelData("SpecificRegister", 1, 23);
	new Select(SpecificRegisterpage.gothra()).selectByVisibleText(gothra);
	test.pass("Selected Raasi: "+gothra);
	SpecificRegisterpage.dosham_No().click();
	test.pass("clicked on Dosham-No ");
	String tobH=edata.getExcelData("SpecificRegister", 1, 24);
	new Select(SpecificRegisterpage.timeOfBirth_hours()).selectByVisibleText(tobH);
	test.pass("Selected Time of Birth_Hours: "+tobH);
	String tobM=edata.getExcelData("SpecificRegister", 1, 25);
	new Select(SpecificRegisterpage.timeOfBirth_mins()).selectByVisibleText(tobM);
	test.pass("Selected Time of Birth_Minutes: "+tobM);
	String tobMn=edata.getExcelData("SpecificRegister", 1, 26);
	new Select(SpecificRegisterpage.timeOfBirth_meridiem()).selectByVisibleText(tobMn);
	test.pass("Selected Time of Birth_Meridiem: "+tobMn);
	String cob=edata.getExcelData("SpecificRegister", 1, 27);
	new Select(SpecificRegisterpage.countryOfBirth()).selectByVisibleText(cob);
	test.pass("Selected Country of Birth: "+cob);
	String sob=edata.getExcelData("SpecificRegister", 1, 28);
	new Select(SpecificRegisterpage.stateOfBirth()).selectByVisibleText(sob);
	test.pass("Selected State of Birth: "+sob);
	String cityOfBirth=edata.getExcelData("SpecificRegister", 1, 29);
	new Select(SpecificRegisterpage.cityOfBirth()).selectByVisibleText(cityOfBirth);
	test.pass("Selected City of Birth: "+cityOfBirth);
	String cStyle=edata.getExcelData("SpecificRegister", 1, 30);
	new Select(SpecificRegisterpage.chartStyle()).selectByVisibleText(cStyle);
	test.pass("Selected Chart Style: "+cStyle);
	
	//*****Education Information**********************
	
	String hEdu=edata.getExcelData("SpecificRegister", 1, 31);
	new Select(SpecificRegisterpage.heighestEducation()).selectByVisibleText(hEdu);
	test.pass("Selected Heighest Education: "+hEdu);
	String employedIn=edata.getExcelData("SpecificRegister", 1, 35);
	if(employedIn.equalsIgnoreCase("Government")){
		SpecificRegisterpage.employedIn_govt().click();
		test.pass("Employed In: Government");
	}else if (employedIn.equalsIgnoreCase("Defence")) {
		SpecificRegisterpage.employedIn_defence().click();
		test.pass("Employed In: Defence");
	}
	else if (employedIn.equalsIgnoreCase("Private")) {
		SpecificRegisterpage.employedIn_private().click();
		test.pass("Employed In: Private");
	}else if (employedIn.equalsIgnoreCase("Business")){
		SpecificRegisterpage.employedIn_business().click();
		test.pass("Employed In: Business");
	}
    else if (employedIn.equalsIgnoreCase("Self Employed")){
	    SpecificRegisterpage.employesIn_selfEmployed().click();
	    test.pass("Employed In: Self Employed");
    }else{
    	SpecificRegisterpage.employedIn_notWorking().click();
    	test.pass("Employed In: Not working");
    }
	if(!employedIn.equalsIgnoreCase("Not Working")){
		String occ=edata.getExcelData("SpecificRegister", 1, 36);
		new Select(SpecificRegisterpage.occupaton()).selectByVisibleText(occ);
		test.pass("Selected Occupation: "+occ);
		String incomeType=edata.getExcelData("SpecificRegister", 1, 37);
		if(incomeType.equalsIgnoreCase("Monthly")){
			SpecificRegisterpage.income_monthly().click();
			test.pass("Income type: Monthly");
		}else{
			SpecificRegisterpage.income_annual().click();
			test.pass("Income Type: Annual");
		}
		String currency=edata.getExcelData("SpecificRegister", 1, 38);
		try{
			new Select(SpecificRegisterpage.anualCurrency()).selectByVisibleText(currency);
			test.pass("Selected Currency : "+currency);
		}catch(Exception e){e.getMessage();}
		String income=edata.getExcelData("SpecificRegister", 1, 39);
		SpecificRegisterpage.incomeTextbox().sendKeys(income);
		test.pass("Income: "+income);
	}
	
	//**********Famly Information**********************
	SpecificRegisterpage.famlyValue_traditional().click();
	test.pass("clicked on Famly Value: Traditional");
	SpecificRegisterpage.famlyType_nuclear().click();
	test.pass("clicked on Famly Type: Nuclear famly");
	SpecificRegisterpage.famlyStatus_middle().click();
	test.pass("clicked on Famly status: Middle class");
	
	//*****************About Me**********************
	String aMe=edata.getExcelData("SpecificRegister", 1, 32);
	SpecificRegisterpage.aboutMe().sendKeys(aMe);
	SpecificRegisterpage.completeRegister().click();
	test.pass("Clicked on Complete Registration");
	test.pass("Fetching Newly Registered Id..........");
	String s=SpecificRegisterpage.newlyRegisterId().getText();
	String matriId=s.substring(19, s.length());
	test.pass("Your Registered Id is - "+matriId);	
	
	        // For opening new tab
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");	        
	Thread.sleep(2000);	      
	driver.navigate().to("https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriId);  
	String pintext=SpecificRegisterpage.pinText().getText();  
	System.out.println(pintext);
	test.pass("Mobile Activation Started.....");	                      
	Thread.sleep(1000);	        
	String pinNum=pintext.substring(24,30);
	System.out.println(pinNum);
	test.pass("Mobile Recivied PIN Number is :  ****** ");	        
	Thread.sleep(1000);	     
	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w"); 
     // driver.switchTo().window(pwh);
     // driver.navigate().back();
	 Thread.sleep(1000);
	 SpecificRegisterpage.pinNoTextbox().sendKeys(pinNum);
	 SpecificRegisterpage.verifyBtn().click();
	 Thread.sleep(1000);
	 String mobileAlertMessage=SpecificRegisterpage.alertMsg().getText();
	 test.pass(mobileAlertMessage);
	 SpecificRegisterpage.alrtPop().click();
	 test.pass("Mobile POPUP Closed");	
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 Thread.sleep(2000);
	 try{
		 SpecificRegisterpage.skipPage().click();
	 }catch(Exception e){e.getMessage();}
     Thread.sleep(3000);
     try{
    	 SpecificRegisterpage.addPhoto().click();
         test.pass("AddPhoto Page - Skipped");
    	 SpecificRegisterpage.reason1().click();
         Thread.sleep(2000);
         SpecificRegisterpage.skipPhotoclick().click();
     }catch(Exception e){e.getMessage();}
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     Thread.sleep(2000);
     try{
    	 SpecificRegisterpage.skipToHome().click();
    	 Thread.sleep(2000);
     }catch(Exception e){e.getMessage();}
     try{
    	 SpecificRegisterpage.iWollDoThisLater().click();
         test.pass("Partner Preference Page - Skipped");
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         Thread.sleep(2000);
     }catch(Exception e){e.getMessage();}
     try{
    	 SpecificRegisterpage.personalDetailSkip().click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         test.pass("Personel Details Page - Skipped");
         Thread.sleep(2000);
     }catch(Exception e){e.getMessage();}
     try{
    	 SpecificRegisterpage.skip().click();
    	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	     test.pass("Payment Page - Skipped");
    	     Thread.sleep(2000);
    	     System.out.println("Payment Page Skipped");
     }catch(Exception e){e.getMessage();}
   	 try{	
   		 Alert leavePage=driver.switchTo().alert();
   		 leavePage.accept();
     }catch(Exception e) {e.getMessage();} 
   	BussinessFunctions.Logout(driver,properties);
	Thread.sleep(2000);
	driver.close();
}
/*@Test
public void muslimRegisterTest() throws Throwable{
	test=extent.createTest("Muslim Registration Test");
	test.pass("Browser Launching.................");
	ExcelData edata=new ExcelData();
    url=edata.getExcelData("SpecificRegister", 3, 0);
	test.pass("Navigating to the url........"+url);
	driver.get(url);
	test.pass("Application Launched successfully with Domain: "+url);
	test.pass("Registration started.......");
	String prof=edata.getExcelData("SpecificRegister", 3, 1);
	new Select(SpecificRegisterpage.profCreatedBy()).selectByVisibleText(prof);
	test.pass("profile Created By: "+prof);
	String name=edata.getExcelData("SpecificRegister", 3, 2);
	SpecificRegisterpage.name().sendKeys(name);
	test.pass("Name: "+name);
	String gender=edata.getExcelData("SpecificRegister", 3, 3);
	if(gender.equalsIgnoreCase("Male")){
		SpecificRegisterpage.male().click();
		test.pass("clicked on male Button");
	}
	else{
		SpecificRegisterpage.female().click();
		test.pass("clicked on Female Button");
	}
	String day=edata.getExcelData("SpecificRegister", 3, 4);
	new Select(SpecificRegisterpage.birthDay()).selectByVisibleText(day);
	test.pass("Date of Birth-Date selected as: "+day);
	String month=edata.getExcelData("SpecificRegister", 3, 5);
	new Select(SpecificRegisterpage.birthMonth()).selectByVisibleText(month);
	test.pass("Date of Birth-Month selected as: "+month);
	String year=edata.getExcelData("SpecificRegister", 3, 6);
	new Select(SpecificRegisterpage.birthYear()).selectByVisibleText(year);
	test.pass("Date of Birth-Year  selected as: "+year);
	String mStatus=edata.getExcelData("SpecificRegister", 3, 7);
//	JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0,1000)");
	boolean status=true;
	if(mStatus.equalsIgnoreCase("Unmarried")){
		SpecificRegisterpage.unmarried().click();
		status=false;
		test.pass("clicked on Unmarried");
	}else if (mStatus.contains("Widow")) {
		SpecificRegisterpage.widowOrWidower().click();
		test.pass("clicked on Widow/widower");
	}else if (mStatus.equalsIgnoreCase("Divorced")) {
		SpecificRegisterpage.divorced().click();
		test.pass("clicked on Divorced");
	}else{
		SpecificRegisterpage.seperated().click();
		test.pass("clicked on Seperated");
	}
	String sect=edata.getExcelData("SpecificRegister", 3, 34);
	new Select(SpecificRegisterpage.sect()).selectByVisibleText(sect);
	test.pass("Selected Division: "+sect);
	String division1=edata.getExcelData("SpecificRegister", 3, 8);
	new Select(SpecificRegisterpage.casteOrDivision()).selectByVisibleText(division1);
	test.pass("Selected Division: "+division1);
	String mT=edata.getExcelData("SpecificRegister", 3, 10);
	new Select(SpecificRegisterpage.motherTongue()).selectByVisibleText(mT);
	test.pass("Selected Mother Tongue: "+mT);
	String countryLive=edata.getExcelData("SpecificRegister", 3, 11);
	new Select(SpecificRegisterpage.countryLivingIn()).selectByVisibleText(countryLive);
	test.pass("Selected Country Living In: "+countryLive);
	new Select(SpecificRegisterpage.mobNoCountryCode()).selectByIndex(2);
	test.pass("Selected Country Living In: United States of America");
	String mobNo=edata.getExcelData("SpecificRegister", 3, 13);
	SpecificRegisterpage.mobNo().sendKeys(mobNo);
	test.pass("Mobile No is Entered");
	String pw=edata.getExcelData("SpecificRegister", 3, 14);
	SpecificRegisterpage.loginPassword().sendKeys(pw);
	test.pass("password is entered");
	SpecificRegisterpage.rigisterNow().click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	Thread.sleep(2000);
	String email=edata.getExcelData("SpecificRegister", 3, 15)+Math.floor(Math.random() * 143231)+ "@gmail.com";
	SpecificRegisterpage.email().sendKeys(email);
	test.pass("Email "+email+" is entered");
	if(status){
		SpecificRegisterpage.noOfChildren().click();
		test.pass("clicked on No.of Children: None");
	}
	String height=edata.getExcelData("SpecificRegister", 3, 16);
	new Select(SpecificRegisterpage.height()).selectByVisibleText(height);
	test.pass("selected height: "+height);
	String pStatus=edata.getExcelData("SpecificRegister", 3, 17);
	if(pStatus.equalsIgnoreCase("Normal")){
		SpecificRegisterpage.physicalStatus_normal().click();
		test.pass("clicked on Physical status: Normal Button");
	}else{
		SpecificRegisterpage.physicalStatus_pChallenged().click();
		test.pass("clicked on Physical status: Physically Challenged");
	}
	String residingState=edata.getExcelData("SpecificRegister", 3, 18);
	new Select(SpecificRegisterpage.residingState()).selectByVisibleText(residingState);
	test.pass("selected Residing state: "+residingState);
	String residingCity=edata.getExcelData("SpecificRegister", 3, 19);
	new Select(SpecificRegisterpage.residingCity()).selectByVisibleText(residingCity);
	test.pass("selected Residing City: "+residingCity);
	String citizenship=edata.getExcelData("SpecificRegister", 3, 20);
	new Select(SpecificRegisterpage.citizenship()).selectByVisibleText(citizenship);
	test.pass("selected citizenship: "+citizenship);
	String willingToMarry=edata.getExcelData("SpecificRegister", 3, 38);
	if(willingToMarry.equalsIgnoreCase("same division")){
		SpecificRegisterpage.sameCasteOrDivision().click();
		test.pass("clicked on Same division");
	}else{
		SpecificRegisterpage.otherCasteorDivision().click();
		test.pass("clicked on Other Division Also");
	}
	String wear=edata.getExcelData("SpecificRegister", 3, 42);
	try{
		if(wear.equalsIgnoreCase("Hijab")){
			SpecificRegisterpage.doYouWear_hijab().click();
			test.pass("Do You Wear Selected As: Hijab");
		}else if (wear.equalsIgnoreCase("Niqab")) {
			SpecificRegisterpage.doYouWear_niqab().click();
			test.pass("Do You Wear Selected As: Niqab");
		}
		else {
			SpecificRegisterpage.doYouWear_none().click();
			test.pass("Do You Wear Selected As: None");
		}
	}catch(Exception e){e.getMessage();}
	String readQuran=edata.getExcelData("SpecificRegister", 3, 41);
	if(readQuran.equalsIgnoreCase("Regularly")){
		SpecificRegisterpage.readQuran_regularly().click();
		test.pass("Read Quran: Regularly");
	}else if (readQuran.equalsIgnoreCase("Occasionally")) {
		SpecificRegisterpage.readQuran_occ().click();
		test.pass("Read Quran: occationally");
	}
	else if (readQuran.equalsIgnoreCase("Never read")) {
		SpecificRegisterpage.readQuran_never().click();
		test.pass("Read Quran: Never read");
	}else{
		SpecificRegisterpage.readQuran_only().click();
		test.pass("Read Quran: Only jummah/Friday");
	}
	new Select(SpecificRegisterpage.religiousValues()).selectByIndex(1);
	test.pass("selected Religious value: Islam is truth");
	//*****Education Information**********************
	
	String hEdu=edata.getExcelData("SpecificRegister", 3, 31);
	new Select(SpecificRegisterpage.heighestEducation()).selectByVisibleText(hEdu);
	test.pass("Selected Heighest Education: "+hEdu);
	String employedIn=edata.getExcelData("SpecificRegister", 3, 35);
	if(employedIn.equalsIgnoreCase("Government")){
		SpecificRegisterpage.employedIn_govt().click();
		test.pass("Employed In: Government");
	}else if (employedIn.equalsIgnoreCase("Defence")) {
		SpecificRegisterpage.employedIn_defence().click();
		test.pass("Employed In: Defence");
	}
	else if (employedIn.equalsIgnoreCase("Private")) {
		SpecificRegisterpage.employedIn_private().click();
		test.pass("Employed In: Private");
	}else if (employedIn.equalsIgnoreCase("Business")){
		SpecificRegisterpage.employedIn_business().click();
		test.pass("Employed In: Business");
	}
    else if (employedIn.equalsIgnoreCase("Self Employed")){
	    SpecificRegisterpage.employesIn_selfEmployed().click();
	    test.pass("Employed In: Self Employed");
    }else{
    	SpecificRegisterpage.employedIn_notWorking().click();
    	test.pass("Employed In: Not working");
    }
	if(!employedIn.equalsIgnoreCase("Not Working")){
		String occ=edata.getExcelData("SpecificRegister", 3, 36);
		new Select(SpecificRegisterpage.occupaton()).selectByVisibleText(occ);
		test.pass("Selected Occupation: "+occ);
		String incomeType=edata.getExcelData("SpecificRegister", 3, 37);
		if(incomeType.equalsIgnoreCase("Monthly")){
			SpecificRegisterpage.income_monthly().click();
			test.pass("Income type: Monthly");
		}else{
			SpecificRegisterpage.income_annual().click();
			test.pass("Income Type: Annual");
		}
		String currency=edata.getExcelData("SpecificRegister", 3, 38);
		try{
			new Select(SpecificRegisterpage.anualCurrency()).selectByVisibleText(currency);
			test.pass("Selected Currency : "+currency);
		}catch(Exception e){e.getMessage();}
		String income=edata.getExcelData("SpecificRegister", 3, 39);
		SpecificRegisterpage.incomeTextbox().sendKeys(income);
		test.pass("Income: "+income);
	}
	//**********Famly Information**********************
	SpecificRegisterpage.famlyValue_traditional().click();
	test.pass("clicked on Famly Value: Traditional");
	SpecificRegisterpage.famlyType_nuclear().click();
	test.pass("clicked on Famly Type: Nuclear famly");
	SpecificRegisterpage.famlyStatus_middle().click();
	test.pass("clicked on Famly status: Middle class");
	new Select(SpecificRegisterpage.ethnicity()).selectByIndex(2);
	test.pass("selected Ethnicity: Asian");
	//*****************About Me**********************
	String aMe=edata.getExcelData("SpecificRegister", 3, 32);
	SpecificRegisterpage.aboutMe().sendKeys(aMe);
	Thread.sleep(2000);
	SpecificRegisterpage.completeRegister().click();
	test.pass("Clicked on Complete Registration");
	test.pass("Fetching Newly Registered Id..........");
	String s=SpecificRegisterpage.newlyRegisterId().getText();
	String matriId=s.substring(19, s.length());
	test.pass("Your Registered Id is - "+matriId);	
    // For opening new tab
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");	        
	Thread.sleep(2000);	      
	driver.navigate().to("https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriId);  
	String pintext=SpecificRegisterpage.pinText().getText();  
	System.out.println(pintext);
	test.pass("Mobile Activation Started.....");	                      
	Thread.sleep(1000);	        
	String pinNum=pintext.substring(24,30);
	System.out.println(pinNum);
	test.pass("Mobile Recivied PIN Number is :  ****** ");	        
	Thread.sleep(1000);	     
	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w"); 
	// driver.switchTo().window(pwh);
	// driver.navigate().back();
	Thread.sleep(1000);
	SpecificRegisterpage.pinNoTextbox().sendKeys(pinNum);
	SpecificRegisterpage.verifyBtn().click();
	Thread.sleep(1000);
	String mobileAlertMessage=SpecificRegisterpage.alertMsg().getText();
	test.pass(mobileAlertMessage);
	SpecificRegisterpage.alrtPop().click();
	test.pass("Mobile POPUP Closed");	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	try{
		 SpecificRegisterpage.skipPage().click();
	 }catch(Exception e){e.getMessage();}
    Thread.sleep(3000);
    try{
   	 SpecificRegisterpage.addPhoto().click();
        test.pass("AddPhoto Page - Skipped");
   	 SpecificRegisterpage.reason1().click();
        Thread.sleep(2000);
        SpecificRegisterpage.skipPhotoclick().click();
    }catch(Exception e){e.getMessage();}
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Thread.sleep(2000);
    try{
   	 SpecificRegisterpage.skipToHome().click();
   	 Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.iWollDoThisLater().click();
        test.pass("Partner Preference Page - Skipped");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.personalDetailSkip().click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.pass("Personel Details Page - Skipped");
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.skip().click();
   	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	     test.pass("Payment Page - Skipped");
   	     Thread.sleep(2000);
   	     System.out.println("Payment Page Skipped");
    }catch(Exception e){e.getMessage();}
  	 try{	
  		 Alert leavePage=driver.switchTo().alert();
  		 leavePage.accept();
    }catch(Exception e) {
    	e.getMessage();
    } 
	test.pass("Registration is completed successfully");
	BussinessFunctions.Logout(driver,properties);
	driver.close();
}
@Test
public void christianRegisterTest() throws Throwable{
	test=extent.createTest("Christian Registration Test");
	test.pass("Browser Launching.................");
	ExcelData edata=new ExcelData();
	url=edata.getExcelData("SpecificRegister", 2, 0);
	test.pass("Navigating to the url........"+url);
	driver.get(url);
	test.pass("Application Launched successfully with Domain: "+url);
	test.pass("Registration started.......");
	String prof=edata.getExcelData("SpecificRegister", 2, 1);
	new Select(SpecificRegisterpage.profCreatedBy()).selectByVisibleText(prof);
	test.pass("profile Created By: "+prof);
	String name=edata.getExcelData("SpecificRegister", 2, 2);
	SpecificRegisterpage.name().sendKeys(name);
	test.pass("Name: "+name);
	String gender=edata.getExcelData("SpecificRegister", 2, 3);
	if(gender.equalsIgnoreCase("Male")){
		SpecificRegisterpage.male().click();
		test.pass("clicked on male Button");
	}else{
		SpecificRegisterpage.female().click();
		test.pass("clicked on Female Button");
	}
	String day=edata.getExcelData("SpecificRegister", 2, 4);
	new Select(SpecificRegisterpage.birthDay()).selectByVisibleText(day);
	test.pass("Date of Birth- selected as: "+day);
	String month=edata.getExcelData("SpecificRegister", 2, 5);
	new Select(SpecificRegisterpage.birthMonth()).selectByVisibleText(month);
	test.pass("Date of Month-  selected as: "+month);
	String year=edata.getExcelData("SpecificRegister", 2, 6);
	new Select(SpecificRegisterpage.birthYear()).selectByVisibleText(year);
	test.pass("Date of Year-  selected as: "+year);
	String mStatus=edata.getExcelData("SpecificRegister", 2, 7);
	boolean status=true;
	if(mStatus.equalsIgnoreCase("Unmarried")){
		SpecificRegisterpage.unmarried().click();
		status=false;
		test.pass("clicked on Unmarried");
	}else if (mStatus.contains("Window")) {
		SpecificRegisterpage.widowOrWidower().click();
		test.pass("clicked on Widow/widower");
	}else if (mStatus.equalsIgnoreCase("Divorced")) {
		SpecificRegisterpage.divorced().click();
		test.pass("clicked on Divorced");
	}else{
		SpecificRegisterpage.seperated().click();;
		test.pass("clicked on Seperated");
	}
	String denomination=edata.getExcelData("SpecificRegister", 2, 33);
	new Select(SpecificRegisterpage.denomination()).selectByVisibleText(denomination);
	test.pass("Selected Denomination: "+denomination);
	String division=edata.getExcelData("SpecificRegister", 2, 8);
	new Select(SpecificRegisterpage.casteOrDivision()).selectByVisibleText(division);
	test.pass("Selected Division: "+division);
	String subCaste=edata.getExcelData("SpecificRegister", 2, 9);
	SpecificRegisterpage.subCaste().clear();
	SpecificRegisterpage.subCaste().sendKeys(subCaste);
	test.pass("Selected SubCaste: "+subCaste);
	String mT=edata.getExcelData("SpecificRegister", 2, 10);
	new Select(SpecificRegisterpage.motherTongue()).selectByVisibleText(mT);
	test.pass("Selected Mother Tongue: "+mT);
	String countryLive=edata.getExcelData("SpecificRegister", 2, 11);
	new Select(SpecificRegisterpage.countryLivingIn()).selectByVisibleText(countryLive);
	test.pass("Selected Country Living In: "+countryLive);
	new Select(SpecificRegisterpage.mobNoCountryCode()).selectByIndex(2);
	test.pass("Selected Country Living In: United States of America");
	String mobNo=edata.getExcelData("SpecificRegister", 2, 13);
	SpecificRegisterpage.mobNo().sendKeys(mobNo);
	test.pass("Mobile No is Entered");
	String pw=edata.getExcelData("SpecificRegister", 2, 14);
	SpecificRegisterpage.loginPassword().sendKeys(pw);
	test.pass("password is entered");
	SpecificRegisterpage.rigisterNow().click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	String email=edata.getExcelData("SpecificRegister", 2, 15)+Math.floor(Math.random() * 143231)+ "@gmail.com";
	SpecificRegisterpage.email().sendKeys(email);
	test.pass("Email "+email+" is entered");
	if(status){
		SpecificRegisterpage.noOfChildren().click();
		test.pass("clicked on No.of Children: None");
	}
	String height=edata.getExcelData("SpecificRegister", 2, 16);
	new Select(SpecificRegisterpage.height()).selectByVisibleText(height);
	test.pass("selected height: "+height);
	String pStatus=edata.getExcelData("SpecificRegister", 3, 17);
	if(pStatus.equalsIgnoreCase("Normal")){
		SpecificRegisterpage.physicalStatus_normal().click();
		test.pass("clicked on Physical status: Normal Button");
	}else{
		SpecificRegisterpage.physicalStatus_pChallenged().click();
		test.pass("clicked on Physical status: Physically Challenged");
	}
	String residingState=edata.getExcelData("SpecificRegister", 2, 18);
	new Select(SpecificRegisterpage.residingState()).selectByVisibleText(residingState);
	test.pass("selected Residing state: "+residingState);
	String residingCity=edata.getExcelData("SpecificRegister", 2, 19);
	new Select(SpecificRegisterpage.residingCity()).selectByVisibleText(residingCity);
	test.pass("selected Residing City: "+residingCity);
	String citizenship=edata.getExcelData("SpecificRegister", 2, 20);
	new Select(SpecificRegisterpage.citizenship()).selectByVisibleText(citizenship);
	test.pass("selected citizenship: "+citizenship);
	String willingToMarry=edata.getExcelData("SpecificRegister", 3, 38);
	if(willingToMarry.equalsIgnoreCase("same division")){
		SpecificRegisterpage.sameCasteOrDivision().click();
		test.pass("clicked on Same division");
	}else{
		SpecificRegisterpage.otherCasteorDivision().click();
		test.pass("clicked on Other Division Also");
	}
	new Select(SpecificRegisterpage.religiousValues()).selectByIndex(3);
	test.pass("selected Religious value: sunday church Goer");
	//*****Education Information**********************
	
	String hEdu=edata.getExcelData("SpecificRegister", 2, 31);
	new Select(SpecificRegisterpage.heighestEducation()).selectByVisibleText(hEdu);
	test.pass("Selected Heighest Education: "+hEdu);
	String employedIn=edata.getExcelData("SpecificRegister", 2, 35);
	if(employedIn.equalsIgnoreCase("Government")){
		SpecificRegisterpage.employedIn_govt().click();
		test.pass("Employed In: Government");
	}else if (employedIn.equalsIgnoreCase("Defence")) {
		SpecificRegisterpage.employedIn_defence().click();
		test.pass("Employed In: Defence");
	}
	else if (employedIn.equalsIgnoreCase("Private")) {
		SpecificRegisterpage.employedIn_private().click();
		test.pass("Employed In: Private");
	}else if (employedIn.equalsIgnoreCase("Business")){
		SpecificRegisterpage.employedIn_business().click();
		test.pass("Employed In: Business");
	}
    else if (employedIn.equalsIgnoreCase("Self Employed")){
	    SpecificRegisterpage.employesIn_selfEmployed().click();
	    test.pass("Employed In: Self Employed");
    }else{
    	SpecificRegisterpage.employedIn_notWorking().click();
    	test.pass("Employed In: Not working");
    }
	if(!employedIn.equalsIgnoreCase("Not Working")){
		String occ=edata.getExcelData("SpecificRegister", 2, 36);
		new Select(SpecificRegisterpage.occupaton()).selectByVisibleText(occ);
		test.pass("Selected Occupation: "+occ);
		String incomeType=edata.getExcelData("SpecificRegister", 2, 37);
		if(incomeType.equalsIgnoreCase("Monthly")){
			SpecificRegisterpage.income_monthly().click();
			test.pass("Income type: Monthly");
		}else{
			SpecificRegisterpage.income_annual().click();
			test.pass("Income Type: Annual");
		}
		String currency=edata.getExcelData("SpecificRegister", 2, 38);
		try{
			new Select(SpecificRegisterpage.anualCurrency()).selectByVisibleText(currency);
			test.pass("Selected Currency : "+currency);
		}catch(Exception e){e.getMessage();}
		String income=edata.getExcelData("SpecificRegister", 2, 39);
		SpecificRegisterpage.incomeTextbox().sendKeys(income);
		test.pass("Income: "+income);
	}
	//**********Famly Information**********************
	SpecificRegisterpage.famlyValue_traditional().click();
	test.pass("clicked on Famly Value: Traditional");
	SpecificRegisterpage.famlyType_nuclear().click();
	test.pass("clicked on Famly Type: Nuclear famly");
	SpecificRegisterpage.famlyStatus_middle().click();
	test.pass("clicked on Famly status: Middle class");
	new Select(SpecificRegisterpage.ethnicity()).selectByIndex(2);
	test.pass("selected Ethnicity: Asian");
	//*****************About Me**********************
	String aMe=edata.getExcelData("SpecificRegister", 2, 32);
	SpecificRegisterpage.aboutMe().sendKeys(aMe);
	SpecificRegisterpage.completeRegister().click();
	test.pass("Clicked on Complete Registration");
	test.pass("Fetching Newly Registered Id..........");
	String s=SpecificRegisterpage.newlyRegisterId().getText();
	String matriId=s.substring(19, s.length());
	test.pass("Your Registered Id is - "+matriId);	
    // For opening new tab
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");	        
	Thread.sleep(2000);	      
	driver.navigate().to("https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriId);  
	String pintext=SpecificRegisterpage.pinText().getText();  
	System.out.println(pintext);
	test.pass("Mobile Activation Started.....");	                      
	Thread.sleep(1000);	        
	String pinNum=pintext.substring(24,30);
	System.out.println(pinNum);
	test.pass("Mobile Recivied PIN Number is :  ****** ");	        
	Thread.sleep(1000);	     
	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w"); 
	// driver.switchTo().window(pwh);
	// driver.navigate().back();
	Thread.sleep(1000);
	SpecificRegisterpage.pinNoTextbox().sendKeys(pinNum);
	SpecificRegisterpage.verifyBtn().click();
	Thread.sleep(1000);
	String mobileAlertMessage=SpecificRegisterpage.alertMsg().getText();
	test.pass(mobileAlertMessage);
	SpecificRegisterpage.alrtPop().click();
	test.pass("Mobile POPUP Closed");	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	try{
		 SpecificRegisterpage.skipPage().click();
	 }catch(Exception e){e.getMessage();}
    Thread.sleep(3000);
    try{
   	 SpecificRegisterpage.addPhoto().click();
        test.pass("AddPhoto Page - Skipped");
   	 SpecificRegisterpage.reason1().click();
        Thread.sleep(2000);
        SpecificRegisterpage.skipPhotoclick().click();
    }catch(Exception e){e.getMessage();}
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Thread.sleep(2000);
    try{
   	 SpecificRegisterpage.skipToHome().click();
   	 Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.iWollDoThisLater().click();
        test.pass("Partner Preference Page - Skipped");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.personalDetailSkip().click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.pass("Personel Details Page - Skipped");
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.skip().click();
   	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	     test.pass("Payment Page - Skipped");
   	     Thread.sleep(2000);
   	     System.out.println("Payment Page Skipped");
    }catch(Exception e){e.getMessage();}
  	 try{	
  		 Alert leavePage=driver.switchTo().alert();
  		 leavePage.accept();
    }catch(Exception e) {
    	e.getMessage();
    } 
	test.pass("Registration is completed successfully");
	BussinessFunctions.Logout(driver,properties);
	Thread.sleep(2000);
	driver.close();
}
@Test
public void keralaChristianRegisterTest() throws Throwable{
	test=extent.createTest("Kerala Christian Registration Test");
	test.pass("Browser Launching.................");
	ExcelData edata=new ExcelData();
	url=edata.getExcelData("SpecificRegister", 4, 0);
	test.pass("Navigating to the url........"+url);
	driver.get(url);
	test.pass("Application Launched successfully with Domain: "+url);
	test.pass("Registration started.......");
	String prof=edata.getExcelData("SpecificRegister", 4, 1);
	new Select(SpecificRegisterpage.profCreatedBy()).selectByVisibleText(prof);
	test.pass("profile Created By: "+prof);
	String name=edata.getExcelData("SpecificRegister", 4, 2);
	SpecificRegisterpage.name().sendKeys(name);
	test.pass("Name: "+name);
	String gender=edata.getExcelData("SpecificRegister", 4, 3);
	if(gender.equalsIgnoreCase("Male")){
		SpecificRegisterpage.male().click();
		test.pass("clicked on male Button");
	}else{
		SpecificRegisterpage.female().click();
		test.pass("clicked on Female Button");
	}
	String day=edata.getExcelData("SpecificRegister", 4, 4);
	new Select(SpecificRegisterpage.birthDay()).selectByVisibleText(day);
	test.pass("Date of Birth- selected as: "+day);
	String month=edata.getExcelData("SpecificRegister", 4, 5);
	new Select(SpecificRegisterpage.birthMonth()).selectByVisibleText(month);
	test.pass("Date of Month-  selected as: "+month);
	String year=edata.getExcelData("SpecificRegister", 4, 6);
	new Select(SpecificRegisterpage.birthYear()).selectByVisibleText(year);
	test.pass("Date of Year-  selected as: "+year);
	String mStatus=edata.getExcelData("SpecificRegister", 4, 7);
	boolean status=true;
	if(mStatus.equalsIgnoreCase("Unmarried")){
		SpecificRegisterpage.unmarried().click();
		status=false;
		test.pass("clicked on Unmarried");
	}else if (mStatus.contains("Window")) {
		SpecificRegisterpage.widowOrWidower().click();
		test.pass("clicked on Widow/widower");
	}else if (mStatus.equalsIgnoreCase("Divorced")) {
		SpecificRegisterpage.divorced().click();
		test.pass("clicked on Divorced");
	}else{
		SpecificRegisterpage.seperated().click();;
		test.pass("clicked on Seperated");
	}
	String denomination=edata.getExcelData("SpecificRegister", 4, 33);
	new Select(SpecificRegisterpage.keralaDenomination()).selectByVisibleText(denomination);
	test.pass("Selected Denomination: "+denomination);
	String diocese=edata.getExcelData("SpecificRegister", 4, 43);
	new Select(SpecificRegisterpage.diocese()).selectByVisibleText(diocese);
	test.pass("Selected Denomination: "+diocese);
	String countryLive=edata.getExcelData("SpecificRegister", 4, 11);
	new Select(SpecificRegisterpage.countryLivingIn()).selectByVisibleText(countryLive);
	test.pass("Selected Country Living In: "+countryLive);
	new Select(SpecificRegisterpage.mobNoCountryCode()).selectByIndex(2);
	test.pass("Selected Country Living In: United States of America");
	String mobNo=edata.getExcelData("SpecificRegister", 4, 13);
	SpecificRegisterpage.mobNo().sendKeys(mobNo);
	test.pass("Mobile No is Entered");
	String pw=edata.getExcelData("SpecificRegister", 4, 14);
	SpecificRegisterpage.loginPassword().sendKeys(pw);
	test.pass("password is entered");
	SpecificRegisterpage.rigisterNow().click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	String email=edata.getExcelData("SpecificRegister", 4, 15)+Math.floor(Math.random() * 143231)+ "@gmail.com";
	SpecificRegisterpage.email().sendKeys(email);
	test.pass("Email "+email+" is entered");
	if(status){
		SpecificRegisterpage.noOfChildren().click();
		test.pass("clicked on No.of Children: None");
	}
	String height=edata.getExcelData("SpecificRegister", 4, 16);
	new Select(SpecificRegisterpage.height()).selectByVisibleText(height);
	test.pass("selected height: "+height);
	String pStatus=edata.getExcelData("SpecificRegister", 4, 17);
	if(pStatus.equalsIgnoreCase("Normal")){
		SpecificRegisterpage.physicalStatus_normal().click();
		test.pass("clicked on Physical status: Normal Button");
	}else{
		SpecificRegisterpage.physicalStatus_pChallenged().click();
		test.pass("clicked on Physical status: Physically Challenged");
	}
	String residingState=edata.getExcelData("SpecificRegister", 4, 18);
	new Select(SpecificRegisterpage.residingState()).selectByVisibleText(residingState);
	test.pass("selected Residing state: "+residingState);
	String residingCity=edata.getExcelData("SpecificRegister", 4, 19);
	new Select(SpecificRegisterpage.residingCity()).selectByVisibleText(residingCity);
	test.pass("selected Residing City: "+residingCity);
	String citizenship=edata.getExcelData("SpecificRegister", 4, 20);
	new Select(SpecificRegisterpage.citizenship()).selectByVisibleText(citizenship);
	test.pass("selected citizenship: "+citizenship);
	new Select(SpecificRegisterpage.religiousValues()).selectByIndex(3);
	test.pass("selected Religious value: sunday church Goer");
	String parish=edata.getExcelData("SpecificRegister", 4, 44);
	SpecificRegisterpage.parishname().sendKeys(parish);
	test.pass("Parish Name: "+parish);
	//*****Education Information**********************
	String hEdu=edata.getExcelData("SpecificRegister", 4, 31);
	new Select(SpecificRegisterpage.heighestEducation()).selectByVisibleText(hEdu);
	test.pass("Selected Heighest Education: "+hEdu);
	String employedIn=edata.getExcelData("SpecificRegister", 4, 35);
	if(employedIn.equalsIgnoreCase("Government")){
		SpecificRegisterpage.employedIn_govt().click();
		test.pass("Employed In: Government");
	}else if (employedIn.equalsIgnoreCase("Defence")) {
		SpecificRegisterpage.employedIn_defence().click();
		test.pass("Employed In: Defence");
	}
	else if (employedIn.equalsIgnoreCase("Private")) {
		SpecificRegisterpage.employedIn_private().click();
		test.pass("Employed In: Private");
	}else if (employedIn.equalsIgnoreCase("Business")){
		SpecificRegisterpage.employedIn_business().click();
		test.pass("Employed In: Business");
	}
    else if (employedIn.equalsIgnoreCase("Self Employed")){
	    SpecificRegisterpage.employesIn_selfEmployed().click();
	    test.pass("Employed In: Self Employed");
    }else{
    	SpecificRegisterpage.employedIn_notWorking().click();
    	test.pass("Employed In: Not working");
    }
	if(!employedIn.equalsIgnoreCase("Not Working")){
		String occ=edata.getExcelData("SpecificRegister", 4, 36);
		new Select(SpecificRegisterpage.occupaton()).selectByVisibleText(occ);
		test.pass("Selected Occupation: "+occ);
		String incomeType=edata.getExcelData("SpecificRegister", 4, 37);
		if(incomeType.equalsIgnoreCase("Monthly")){
			SpecificRegisterpage.income_monthly().click();
			test.pass("Income type: Monthly");
		}else{
			SpecificRegisterpage.income_annual().click();
			test.pass("Income Type: Annual");
		}
		String currency=edata.getExcelData("SpecificRegister", 4, 38);
		try{
			new Select(SpecificRegisterpage.anualCurrency()).selectByVisibleText(currency);
			test.pass("Selected Currency : "+currency);
		}catch(Exception e){e.getMessage();}
		String income=edata.getExcelData("SpecificRegister", 4, 39);
		SpecificRegisterpage.incomeTextbox().sendKeys(income);
		test.pass("Income: "+income);
	}
	//**********Famly Information**********************
	String fatherName=edata.getExcelData("SpecificRegister", 4, 45);
	SpecificRegisterpage.fathersName().sendKeys(fatherName);
	test.pass("Father's Name: "+fatherName+" is Entered");
	String fatherNativePlace=edata.getExcelData("SpecificRegister", 4, 46);
	SpecificRegisterpage.fatherNativePlace().sendKeys(fatherNativePlace);
	test.pass("Father Native Place: "+fatherNativePlace+" is Entered");
	String motherName=edata.getExcelData("SpecificRegister", 4, 47);
	SpecificRegisterpage.mothersName().sendKeys(motherName);
	test.pass("Mother Name: "+motherName+" is Entered");
	String mothersNativePlace=edata.getExcelData("SpecificRegister", 4, 48);
	SpecificRegisterpage.mothersNativePlace().sendKeys(mothersNativePlace);
	test.pass("Mothers Native Place: "+mothersNativePlace+" is Entered");
	SpecificRegisterpage.famlyValue_traditional().click();
	test.pass("clicked on Famly Value: Traditional");
	SpecificRegisterpage.famlyType_nuclear().click();
	test.pass("clicked on Famly Type: Nuclear famly");
	SpecificRegisterpage.famlyStatus_middle().click();
	test.pass("clicked on Famly status: Middle class");
	String fathersHouseName=edata.getExcelData("SpecificRegister", 4, 49);
	SpecificRegisterpage.fathersHouseName().sendKeys(fathersHouseName);
	test.pass("Father's House Name: "+fathersHouseName+" is Entered");
	String mothersHouseName=edata.getExcelData("SpecificRegister", 4, 50);
	SpecificRegisterpage.mothersHouseName().sendKeys(mothersHouseName);
	test.pass("Father's Name: "+mothersHouseName+" is Entered");
	//*****************About Me**********************
	String aMe=edata.getExcelData("SpecificRegister", 4, 32);
	SpecificRegisterpage.aboutMe().sendKeys(aMe);
	Thread.sleep(2000);
	SpecificRegisterpage.completeRegister().click();
	test.pass("Clicked on Complete Registration");
	test.pass("Fetching Newly Registered Id..........");
	String s=SpecificRegisterpage.newlyRegisterId().getText();
	String matriId=s.substring(19, s.length());
	test.pass("Your Registered Id is - "+matriId);	
   // For opening new tab
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");	        
	Thread.sleep(2000);	      
	driver.navigate().to("https://admin:lRqW6WNT@communitymatrimony.com/api/webservicecall.php?filename=getSmsPin&MatriId="+matriId);  
	String pintext=SpecificRegisterpage.pinText().getText();  
	System.out.println(pintext);
	test.pass("Mobile Activation Started.....");	                      
	Thread.sleep(1000);	        
	String pinNum=pintext.substring(24,30);
	System.out.println(pinNum);
	test.pass("Mobile Recivied PIN Number is :  ****** ");	        
	Thread.sleep(1000);	     
	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w"); 
	// driver.switchTo().window(pwh);
	// driver.navigate().back();
	Thread.sleep(1000);
	SpecificRegisterpage.pinNoTextbox().sendKeys(pinNum);
	SpecificRegisterpage.verifyBtn().click();
	Thread.sleep(1000);
	String mobileAlertMessage=SpecificRegisterpage.alertMsg().getText();
	test.pass(mobileAlertMessage);
	SpecificRegisterpage.alrtPop().click();
	test.pass("Mobile POPUP Closed");	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(2000);
	try{
		 SpecificRegisterpage.skipPage().click();
	 }catch(Exception e){e.getMessage();}
    Thread.sleep(3000);
    try{
   	 SpecificRegisterpage.addPhoto().click();
        test.pass("AddPhoto Page - Skipped");
   	 SpecificRegisterpage.reason1().click();
        Thread.sleep(2000);
        SpecificRegisterpage.skipPhotoclick().click();
    }catch(Exception e){e.getMessage();}
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Thread.sleep(2000);
    try{
   	 SpecificRegisterpage.skipToHome().click();
   	 Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.iWollDoThisLater().click();
        test.pass("Partner Preference Page - Skipped");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.personalDetailSkip().click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.pass("Personel Details Page - Skipped");
        Thread.sleep(2000);
    }catch(Exception e){e.getMessage();}
    try{
   	 SpecificRegisterpage.skip().click();
   	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   	     test.pass("Payment Page - Skipped");
   	     Thread.sleep(2000);
   	     System.out.println("Payment Page Skipped");
    }catch(Exception e){e.getMessage();}
  	 try{	
  		 Alert leavePage=driver.switchTo().alert();
  		 leavePage.accept();
    }catch(Exception e) {
    	e.getMessage();
    }      
	test.pass("Registration is completed successfully");
	BussinessFunctions.Logout(driver,properties);
	Thread.sleep(2000);
	driver.close();
}*/
}
