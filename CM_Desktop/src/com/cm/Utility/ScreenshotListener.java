package com.cm.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener extends BaseTest implements ITestListener {
	@Override
	public void onTestFailure(ITestResult r) {
		String failedTestName= r.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(".//Screenshots//"+failedTestName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
