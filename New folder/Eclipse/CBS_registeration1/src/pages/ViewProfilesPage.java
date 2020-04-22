package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewProfilesPage {
	static long timeOutInSeconds=20;
	//viewProfile
	public static WebElement viewProfile_Link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement displayName(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement loadProfileValues1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement loadProfileValues2(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement loadProfileValues3(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement addPhoto_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement phonenumber(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement editMyProfile_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//ABout me details
	public static WebElement fewLinesAboutMe_Text(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement aboutMe_editLink1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement basicDetails_editLink2(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//PersonnelInformation
	public static WebElement profilecreatedfor(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement age(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement gender(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement noofChild(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement PhyscialStatuss(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement Name(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement hieght(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement martialStatus(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement MotherTongue(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement bodyType(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//Relgious Information
	public static WebElement relgiousInfo_editLink(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement Denomination(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement RelgiousValues(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//Professional Information
	public static WebElement professonalInfo_editLink(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement Education(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement occupaton(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement detailsEdu(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//Location
	public static WebElement location_editlink(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement city(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement state(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement country(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement citizenship(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//FamilyDetails
	public static WebElement familyDetails_editLink(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement value(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement type(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement status(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	//PartnerPreferences
	public static WebElement partnerPref_link(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement partnerPref_editLink(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement martialStatus1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement HaveChild(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement age1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement height1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement eating_habits(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement occupation1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement country1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement citizenship1(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement residential_status(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement reportAbuse(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement safemm(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}public static WebElement viewProfile_Back(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
}