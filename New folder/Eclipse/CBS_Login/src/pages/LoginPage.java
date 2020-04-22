package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	static long timeOutInSeconds=30;
	public static WebElement username(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement passwordclr(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement password(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement login_Click(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	public static WebElement username1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	public static WebElement  passwordLabel(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	public static WebElement  password1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	public static WebElement  logIn(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement mouseoverLogout1(WebDriver driver,String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement Logout_Click1(WebDriver driver,String locator)throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement ppMouseActions(WebDriver driver,String locator)throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement Louout_Comploetely1(WebDriver driver,String locator)throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	

}

