package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Matches {

	static long timeOutInSeconds=20;
	//PartnerPreferences 
	
	public static WebElement martialStatus_ChBox(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	public static WebElement ageFroms(WebDriver driver,String locator) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		return element;
	}
public static WebElement ageTos(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	return element;
}
public static WebElement heightFroms(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement heightTos(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement phyStatus(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement motherTongues(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement castes(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement subCaste(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement stars(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement gothras(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement mangliks(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement educations(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement occupations(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement citizenships(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement countryLivingIn(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement foodHabits(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement smokingHabits(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement drinkingHabits(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}public static WebElement saveBtn(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}
public static WebElement successMsg(WebDriver driver,String locator) throws Exception
{
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	return element;
}
@FindBy(xpath="//*[@id='topnav-login-menu']/div[2]/div[2]/a")
private WebElement matchesLink;
public void matchesLink(){  matchesLink.click();}

@FindBys({@FindBy(xpath="//span[text()='Age, Height ']/following-sibling::span")})
private List<WebElement> ageHeight;
public List<WebElement> ageHeight(){return ageHeight;} 
@FindBys({@FindBy(xpath="//a[text()='Yes']")})
private List<WebElement> yes;
public List<WebElement> yes(){return yes;} 

@FindBys({@FindBy(xpath="//span[text()='Caste/Division']/following-sibling::span")})
private List<WebElement> CasteOrDivision;
public List<WebElement> CasteOrDivision(){return CasteOrDivision;} 

@FindBy(xpath="//*[@id='paginationBottom']/span[2]")
private WebElement paginationLink2;
public WebElement paginationLink2() {return paginationLink2;}
@FindBy(id="Close_pop")
private WebElement sentInterest_Popup;
public WebElement sentInterest_Popup(){
   return sentInterest_Popup;
}

@FindBy(xpath="//*[@id='lightpic']/div/div/div/div/div[3]/div[1]/div[2]")
private WebElement confirmMsg_InPopup;
public WebElement confirmMsg_InPopup(){
   return confirmMsg_InPopup;
}

//**************View Profile**************
@FindBys(@FindBy(xpath="//*[contains(text(),'Request for')]"))
private List<WebElement> requestFor;
public  List<WebElement> requestFor(){
   return requestFor;
}
@FindBys(@FindBy(xpath="//a[contains(text(),'View Full Profile')]"))
private List<WebElement> viewFullProfile;
public List<WebElement> viewFullProfile(){
	return viewFullProfile;
}
@FindBy(xpath="//*[@id='paginationBottom']/span[2]")
private WebElement paginationNext;
public WebElement paginationNext(){
	return paginationNext;
}
 @FindBys(@FindBy(xpath="//a[@class='avatar-txtbg']"))
	private List<WebElement> reqPhoto;
	public List<WebElement> reqPhoto(){
		return reqPhoto;
	}
@FindBy(xpath="//*[@id='lightpic']/div/div/div/div[4]")
private WebElement reqphotoConfMsg;
public WebElement reqphotoConfMsg(){
	return reqphotoConfMsg;
}
@FindBy(xpath=".//*[@id='lightpic']/div/div/div/div[2]/a")
private WebElement reqphotoPopupClose;
public WebElement reqphotoPopupClose(){
	return reqphotoPopupClose;
}
@FindBy(xpath="//a[contains(text(),'Request Horoscope')]")
private WebElement reqHoroscope;
public WebElement reqHoroscope(){
	return reqHoroscope;
}
@FindBy(xpath=".//*[@id='lightpic']/div/div/div/div[4]")
private WebElement reqHoroscopeConfMsg;
public WebElement reqHoroscopeConfMsg(){
	return reqHoroscopeConfMsg;
}
@FindBy(xpath="//*[@id='lightpic']/div/div/div/div[2]/a")
private WebElement reqHoroscopePopupClose;
public WebElement reqHoroscopePopupClose(){
	return reqHoroscopePopupClose;
}

	
@FindBy(xpath="//*[@id='intacceptpm']/b")
private WebElement requestConfMsg;
public WebElement requestConfMsg(){
	return requestConfMsg;
}

@FindBy(xpath="//*[@id='accept_close']")
private WebElement requestConfMsgClose;
public WebElement requestConfMsgClose(){
	return requestConfMsgClose;
}

}