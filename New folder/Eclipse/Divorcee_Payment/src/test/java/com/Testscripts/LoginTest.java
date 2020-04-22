package com.Testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.ObjectRepository.LoginPom;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {

	WebDriver driver;

	@BeforeSuite
	public void startUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CBS\\eclipse-workspace\\Sample_Project\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

	}

	@Test
	public void login() throws Throwable {

		test = extent.startTest("Community Login Test");

		test.log(LogStatus.PASS, "Login Test Started");

		LoginPom l = new LoginPom(driver);

		driver.get("https://www.communitymatrimony.com");
		test.log(LogStatus.PASS, "Browser Launced SuccessFully");
		driver.manage().window().maximize();

		BaseTest.click(l.getMatriID());
		BaseTest.typeData(l.getMatriID(), BaseTest.getExcelData("Login", 1, 1));
		test.log(LogStatus.PASS, "Matri ID Entered SuccessFuly");

	BaseTest.click(l.getPassclr());
		BaseTest.typeData(l.getPassword(), BaseTest.getExcelData("Login", 1, 2));
		test.log(LogStatus.PASS, "Password Entered Successfully");

		BaseTest.click(l.getLogin_btn());
		test.log(LogStatus.PASS, "Login Button Clicked Successfully");

		Thread.sleep(3000);
		String randomID = BaseTest.randomSelection(driver);
	    System.out.println("Selected randomID : " + randomID);
		test.log(LogStatus.PASS, "Selected ID is : " + randomID);
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Randomaly Selected the Community ID");
		System.out.println("randomaly Selected");
		String domain = driver.getCurrentUrl();
		test.log(LogStatus.PASS,"Domain Name====>" + domain);
		System.out.println("====>" + domain);
		//////////////////////////////////////////////////////////////

		/*
		 * try { WebElement suspendid =
		 * driver.findElement(By.xpath("//*[@class='nomsg mediumtxt  pad10 ']"));
		 * 
		 * if (suspendid.isDisplayed()) { test.pass("This ID was Blocked/Suspended");
		 * break; } } catch (Exception e) { e.getMessage(); } try { WebElement
		 * mobile_verify=driver.findElement(By.xpath("(//a[@class='linkb font13'])[2]"))
		 * ;
		 * 
		 * if (mobile_verify.isDisplayed()) {
		 * //test.pass("This ID need to verify Mobile Number"); break;
		 * 
		 * }
		 * 
		 * 
		 * } catch (Exception e) { e.getMessage(); }
		 */

/////////////////////////////////////  Intermediate Pages  ////////////////////

		try {
			WebElement photo_add = driver.findElement(By.xpath("/html/body/div[2]/a"));
			if (photo_add.isDisplayed()) {
				photo_add.click();
				driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]")).click();
				driver.findElement(By.xpath("//*[@id=\"reason3\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"skipphotoclick\"]")).click();

			}

		} catch (Exception e) {
			System.out.println("  * * * * ");
		}

		try {
			WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
			if (skip_matches.isDisplayed()) {
				skip_matches.click();

			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}

		try {
			WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
			if (element.isDisplayed()) {
				element.click();

			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}
//////////////////////  New ly Added  ///////////////////////////////
		try {
			WebElement skip_to_matriony = driver.findElement(By.xpath("/html/body/header/div/div/div/a"));
			if (skip_to_matriony.isDisplayed()) {
				skip_to_matriony.click();
			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}

		try {
			WebElement skip_to_matrimony1 = driver.findElement(By.xpath("/html/body/div[3]/a"));
			if (skip_to_matrimony1.isDisplayed()) {
				skip_to_matrimony1.click();
			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}

////////////////////////////////////////////////////////////////////////////////////

		try {
			WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
			if (divorcee_intermediate_skip.isDisplayed()) {
				divorcee_intermediate_skip.click();

			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}

		try {

			WebElement horoscope = driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]"));
			if (horoscope.isDisplayed()) {
				horoscope.click();
			}
		} catch (Exception e) {
			System.out.println("* * * *");
		}

		try {
			driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]")).click();
		} catch (Exception e) {
			System.out.println("* * * ");
		}

		test.log(LogStatus.PASS, "Intermediate Page Closed Successfully");
// AD Pages

		try {
			driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
		} catch (Exception e) {
			System.out.println("* * * *");
		}
		
		
		
	//	driver.findElement(By.xpath("qwert")).click();

		test.log(LogStatus.PASS, "AD's POP UP Closed Successfully");
		
		test.log(LogStatus.PASS, "Logged Out Succesfully");
		
		test.log(LogStatus.PASS, "Login Test Completed Successfully");

	}

	@AfterMethod
	public void smsTest(ITestResult result) throws Throwable {

		if (result.getStatus() == 2) {
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			
			 try {
			String[] splt = url.split(".php?");
			String a = splt[0].toString();
			System.out.println(a);

			String[] b = a.split("://");
			String c = b[1].toString();
			System.out.println(c);

			String[] d = c.split("/");
			domain = d[0].toString();
			System.out.println(domain);
			
		//	error = result.getName();

			error = d[2].toString();
			System.out.println(error);
   
			Throwable exceptio = result.getThrowable();
			String exception = exceptio.getMessage();
			// System.out.println(exception);

			/*String except = exception.toString();
			System.out.println(except);*/

			String[] ex = exception.split(":");
			String exp = ex[0].toString();
			System.out.println("1" + exp);

			String expt = ex[1].toString().trim();
			System.out.println("2" + expt);

			String expti = ex[2].toString();

			String exptio = ex[3].toString();
			System.out.println(expti + " : " + exptio);
			
    } catch (Exception e) {
		
	}

		} else {

		}

		if (result.getStatus() == 2) {
			BaseTest.sendVFSms(domain, error, expt);
			BaseTest.reportflush(domain, error, expt);
		} else if (result.getStatus() == 1) {
			String pass = BaseTest.getExcelData("SMS", 1, 0);
			System.out.println(pass);
			if (pass.equals("2")) {
				BaseTest.sendVFSms1();
			}
		} else {
		}

		if (result.getStatus() == 2) {
			String fail = BaseTest.getExcelData("SMS", 1, 0);
			System.out.println(fail);
			if (fail.equals("2")) {
				BaseTest.sendVFSms2(domain, error, expt);
				BaseTest.reportflush1(domain, error, expt);
			}
		} else {
		}

		int a1 = result.getStatus();
		String status = Integer.toString(a1);

		BaseTest.setExcelData("SMS", 1, 0, status);
		System.out.println(result.getStatus());

		
		
		if (result.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.FAIL,  "Test Case Failed is "+result.getName());
			
			test.log(LogStatus.FAIL, "Script Failed due to  below reason : " +"\n"+ result.getThrowable());
			
		
			String screenshotPath = LoginTest.getScreenshot(driver, result.getName());
			
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }else if(result.getStatus() == ITestResult.SKIP){
			 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			 
		 }
		
		// test =extent.endTest("Login Test Completed Successfully");
		extent.endTest(test);
		extent.flush();

	}

}
