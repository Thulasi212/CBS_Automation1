package com.Testscripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

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
import com.ObjectRepository.PaymentPom;
import com.relevantcodes.extentreports.LogStatus;

public class DivorceePayment extends BaseTest {
	
	
	WebDriver driver;

	@BeforeSuite
	public void startUp() {

		System.setProperty("webdriver.chrome.driver",
				".//Driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

	}

	@Test(retryAnalyzer=com.Testscripts.RetryFailedTestCases.class)
	public void Payment() throws Throwable {

		test = extent.startTest("Divorcee Negative Payment Test");

		test.log(LogStatus.PASS, "Negative Payment Test Started");

		LoginPom l = new LoginPom(driver);
		BaseTest b = new BaseTest();
		PaymentPom p = new PaymentPom(driver);

		driver.get("https://www.divorceematrimony.com");
		test.log(LogStatus.PASS, "Browser Launced SuccessFully");
		driver.manage().window().maximize();

		BaseTest.click(p.getDmatriID());
		BaseTest.typeData(p.getDmatriID(), BaseTest.getExcelData("Login", 4, 1));
		test.log(LogStatus.PASS, "Matri ID Entered SuccessFuly");

		BaseTest.click(p.getDpassWordclr1());
		BaseTest.typeData(p.getDpassword(), BaseTest.getExcelData("Login", 4, 2));
		test.log(LogStatus.PASS, "Password Entered Successfully");

		BaseTest.click(p.getDlogin());
		test.log(LogStatus.PASS, "Login Button Clicked Successfully");


		Thread.sleep(3000);
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

		
		
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/a[2]")).click();
		} catch (Exception e) {
			System.out.println("* * * ");
		}
		
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Skip to My Matrimony >>')]")).click();
		} catch (Exception e) {
			System.out.println("* * * ");
		}
		
		
		
		test.log(LogStatus.PASS, "Intermediate Page Closed Successfully");
// AD Pages
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
		} catch (Exception e) {
			System.out.println("* * * *");
		}
	
	
	
		
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/a/img")).click();
		} catch (Exception e) {
			System.out.println("* * * *");
		}
		
		
		
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id=\"strategicComm\"]/div/div[2]/a/img")).click();
		} catch (Exception e) {
			
		}
		
		test.log(LogStatus.PASS, "AD's POP UP Closed Successfully");
		
	//	b.click(driver.findElement(By.xpath("adfbf")));
		Thread.sleep(10000);
		b.click(p.getDupgrde());
		
		test.log(LogStatus.PASS, "Upgrade Button Clicked Successfully");
		/////////////////////////////////////////
try {		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window ID : "+parent);
		
		Thread.sleep(3000);
		Set<String> child = driver.getWindowHandles();
		System.out.println("Child  Window ID : "+child);
		
		for (String handle : child) {
			if (!parent.equals(handle)) {
				
				driver.switchTo().window(handle);
				
				
			}
		}
		
} catch (Exception e) {
	System.out.println("NO New Tab Opened to Handle");
}
		/////////////////////////////////////////
		
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Membership pack choosen Successfully");
		b.click(p.getDcardNumber());
		
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Entering card details");
		b.typeData(p.getDcardNumber(),b.getExcelData("Login", 4, 3));
		
		Thread.sleep(3000);
		b.typeData(p.getDexpreMnth(),b.getExcelData("Login", 4, 4));
		
		Thread.sleep(3000);
		b.typeData(p.getDexpreYr(),b.getExcelData("Login", 4, 5));
		
		Thread.sleep(3000);
		b.typeData(p.getDCvv(),b.getExcelData("Login", 4, 6));
		
		Thread.sleep(3000);
		b.click(p.getDpayCRDcard());
		 test.log(LogStatus.PASS, "Payment in Progress");
		 test.log(LogStatus.PASS, "Negative Payment test Completed Successfully"); 
		
		
		 extent.endTest(test);
			extent.flush();
		
	
	}

	@AfterMethod()
	public void smsTest(ITestResult result) throws Throwable {
		
	
		status = result.getName();
		
		if (result.getStatus()==ITestResult.FAILURE) {			
			test.log(LogStatus.FAIL,  "Test Case Failed is "+result.getName());			
			test.log(LogStatus.FAIL, "Script Failed due to  below reason : " +"\n"+ result.getThrowable());			
			String screenshotPath = DivorceePayment.getScreenshot(driver, result.getName());		
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }else if(result.getStatus() == ITestResult.SKIP){
			 test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());		 
		 }
		
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
			try {
				error = d[2].toString();
				System.out.println(error);
	} catch (Exception e) {
		error = d[1].toString();
		System.out.println(error);
	}	
			
			
	Thread.sleep(5000);
				try {
					if (error.contains("index")) {						
						error = "HomePage"; 						
					} else if (error.contains("logincheck")) {						
						error = "Login Page";						
					} else if (error.contains("cbslogincheck")) {						
						error = "Login Page";						
					}  else if (error.contains("register_payment_upgrade")) {						
						error = "Payment Page(PayUbiz)";						
					} else if (error.contains("?error=1")) {						
						error = "Login Page";						
					} else if (error.contains("setcookie")) {					
						error = "Login page";
					}
				} catch (Exception e) {				
				}
				
				
				try {
					if (error==null) {
						error = " Page Loading Timeout Error ";
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
	   
			
		
			String exception = result.getThrowable().getMessage();
			
		
			
			String[] ex = exception.split(": ");
			exp = ex[0].toString();
			System.out.println("1" + exp);

			expt = ex[1].toString().trim();
			System.out.println("2" + expt);
			
			
			try {
				if (expt.contains("Unable to locate element")) {					
					expt = "Requested Page is not displayed due to loading time";				
				} else if (expt.contains("")) {					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				if (error.contains("?error=1")) {				
					expt="Facing Technical Difficulty to login";					
				} else {
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
if(expt.endsWith("(Session info")) {
 expt= expt.replace("(Session info", "");
}else {
	expt = ex[1].toString().trim();
}
			 expti = ex[2].toString();

			exptio = ex[3].toString();
			System.out.println(expti + " : " + exptio);
			
			Thread.sleep(3000);
			try {
				if (driver.findElement(By.xpath("//*[@id=\"main-message\"]/h1")).isDisplayed()) {	
				expt = driver.findElement(By.xpath("//*[@id=\"main-message\"]/h1")).getText();
				System.out.println(expt);				
				} else {
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
					
			Thread.sleep(3000);	
			try {		
							if (driver.findElement(By.id("main-message")).isDisplayed()) {													
							expt = driver.findElement(By.id("main-message")).getText();
							System.out.println(expt);						
							} else {
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
			
			
			try {
				if (expt.isEmpty()) {					
					//expt = " Page Load timeout / Internal Server Error ";
					URL url1 = new URL(driver.getCurrentUrl());
					 String a1 = url1.toString();
					driver.get(a1);
					//URL url = new URL(Url1);
					HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
					connection.setRequestMethod("GET");
					connection.connect();
					int code = connection.getResponseCode();
					System.out.println("Response code of the object is " + code);
					try {
					if (code == 200 | code <= 200) {
					System.out.println("Success");
					} else if (code == 300 | code <= 300) {
					System.out.println("Redirecting");
					} else if (code == 400 | code <= 400) {
					System.out.println("Client Error");
					} else if (code == 500 | code <= 500) {
					System.out.println("Server Error");
					expt = "Internal Server Error";
					}
					} catch (Exception e) {
						expt = " Page Load timeout ";
					}
				}  else { 
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		//	status = result.getName();
			
    } catch (Exception e) {		
	}
		} else {
		}
		
		

	

		///   Level 1
		if (result.getStatus() == 2) {
			BaseTest.sendVFSms(domain, error, expt);
			BaseTest.reportflush(domain, error, expt);
		} else if (result.getStatus() == 1) {
			String pass = BaseTest.getExcelData("SMS", 1, 0);
			System.out.println(pass);
			if (pass.equals("2")) {
				BaseTest.sendVFSms1();
				BaseTest.reportflush2();
			}
		} else {
		}

		
		   ////   Level 2
		if (result.getStatus() == 2) {
			String fail = BaseTest.getExcelData("SMS", 1, 0);
			System.out.println(fail);
			if (fail.equals("2")) {			
		    	BaseTest.sendVFSms2(domain, error, expt);
				BaseTest.reportflush1(domain, error, expt);
				
			}
			}else if (result.getStatus() == 1) {
				String pass = BaseTest.getExcelData("SMS", 2, 0);
				if (pass.equals("2")) {
					BaseTest.sendVFSms3();
					BaseTest.reportflush3();
					
				}							
		} else {
		}

	

		
		//   Level 3 
		if (result.getStatus() == 2) {
			String fail = BaseTest.getExcelData("SMS", 2, 0);		
			System.out.println(fail);
			if (fail.equals("2")) {				
				BaseTest.sendVFSms_fail3(domain, error, expt);
				BaseTest.reportflush_fail3(domain, error, expt);
			}
			}else if (result.getStatus() == 1) {
				String pass = BaseTest.getExcelData("SMS", 3, 0);
				if (pass.equals("2")) {
					BaseTest.sendVFSms_pass3();
				BaseTest.reportflus_pass3();							
				}					
		} else {
		}
		

		//////////
		
if (BaseTest.getExcelData("SMS", 2, 0).equals("2")) {		
			int a2 = result.getStatus();
			String Status_2 = Integer.toString(a2);		
			BaseTest.setExcelData("SMS", 3, 0, Status_2);			
		} else {

		}

if (BaseTest.getExcelData("SMS", 1, 0).equals("2")) {		
			int a2 = result.getStatus();
			String Status_2 = Integer.toString(a2);			
			BaseTest.setExcelData("SMS", 2, 0, Status_2);			
		} else {
		}

		
		int a1 = result.getStatus();
		String status = Integer.toString(a1);
		BaseTest.setExcelData("SMS", 1, 0, status);
		System.out.println(result.getStatus());

	
}

}
