package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProfilePage {
	static long timeOutInSeconds=20;
	//viewProfile
	public static WebElement errMsgs(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement settingScreen(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement accountSettings(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement deleteProfile(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement otherReasons(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement notSpecifyRadioBtns(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement submitBtn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement passwordforDelete(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement deleteBtn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement areUSureYes(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
}
