package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DailyMatchePage {
	static long timeOutInSeconds=20;
	public static WebElement dailyMatch_MouseOvers(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement photo_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement photoNotUploaded(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement visit_TmrMsg(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement matID_Name(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement photoPage_ClsBtn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_liked_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_shtlisted_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_sendEmail_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_shtlisted_clsBtn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_liked_cls1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement phtPage_liked_cls2(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phtPage_sendEmail_clsBtn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement interested_yes_btn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		return element;
	}
	public static WebElement yes_btn_cls(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement interested_skip_btn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement ageHeight_text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement castDiv_text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement education_text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement subCast_text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement location_text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}

}
