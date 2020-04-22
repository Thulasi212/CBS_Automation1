package CBS;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicFunctions.Base;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class RegistrationTest extends Base {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected IOSDriver<IOSElement> driver = null;

	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability(MobileCapabilityType.UDID, "989240f183880fddcaff8ce3a01d58842aaa2317");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.communityMatrimony.CommunityMatrimony");
		driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}
	@Test
	public void registerTest() throws Throwable {
		RegistrationPage reg = new RegistrationPage(driver);
		String communityName=getExcelData("Registration", 2, 0);
		System.out.println("Community name: " + communityName);
		reg.getComm().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		reg.getCommSearch().click();
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(communityName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='" + communityName + "']")).click();
		Thread.sleep(2000);
		reg.getProfileCreate_Done().click();
		System.out.println("Profile created by selected");
		Thread.sleep(3000);
		String gender=getExcelData("Registration", 2, 2);
		System.out.println("Gender" + gender);
		if (gender.equalsIgnoreCase("Male")) {
			reg.getGender_Male().click();
		} else {
			reg.getGender_Female().click();
		}
		System.out.println("Gender selected");
		Thread.sleep(1000);
		String name=getExcelData("Registration", 2, 3);
		reg.getName().click();
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(name);
		reg.getKeypad_Done().click();
		Thread.sleep(1000);
		System.out.println("Name: " + name);
		/*java.util.List<IOSElement> dob = driver.findElements(By.className("UIAPickerWheel"));
		System.out.println("DOB size: " + dob.size());
		String year = readValueFromExcelSheet().get(1).get("Dob_Year");
		System.out.println(year);
		System.out.println(dob.get(2).getText());
		dob.get(2).sendKeys(year);
		String month = readValueFromExcelSheet().get(1).get("Dob_Month");
		dob.get(1).sendKeys(month);
		String date = readValueFromExcelSheet().get(1).get("Dob_Date");
		dob.get(0).sendKeys(date);
		Thread.sleep(1000);*/
		reg.getDob_Done().click();
		Thread.sleep(1000);
		String mail = "supertestregmail" + Math.floor(Math.random() * 143231) + "@gmail.com";
		reg.getEmail().click();
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(mail);
		reg.getKeypad_Done().click();
		System.out.println("Email: " + mail);
		Thread.sleep(2000);
		String password=getExcelData("Registration", 2, 7);
		reg.getPassword().click();
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(password);
		reg.getKeypad_Done().click();
		System.out.println("Password: " + password);
		Thread.sleep(2000);
		String mobileNo=getExcelData("Registration", 2, 8);
		System.out.println("Mobile NUmber: " + mobileNo);
		reg.getMobNo().click();
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(mobileNo);
		reg.getKeypad_Num_Done().click();
		Thread.sleep(2000);
		String mT=getExcelData("Registration", 2, 9);
		System.out.println("Mother Tongue: " + mT);
		if (communityName.equalsIgnoreCase("KeralachristianMatrimony.com")) {
			System.out.println("Mother Tongue pre selected");
		} else {
			reg.getMotherTongueSearch().click();
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(mT);
			reg.getMotherTongue().click();
		}
		Thread.sleep(2000);
		
		try {
			reg.getCasteOrDivisionSearch().click();
			System.out.println("Clicked on Select Caste/Division ");
			System.out.println("Fetching Caste/Division value from Excel...");
			String casteDivi=getExcelData("Registration", 2, 10);
			System.out.println("Caste/Division: " + casteDivi);
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(casteDivi);
			reg.getCasteOrDivision().click();
			System.out.println("Caste/Division selected");
			Thread.sleep(2000);
		  } catch (Exception e) {
			e.getMessage();
			
		  }
		try {
			/*
			 * java.util.List<IOSElement> subCasteList =
			 * driver.findElements(By.className("UIAPickerWheel"));
			 * System.out.println("Sub Caste size: "+subCasteList.size()); String
			 * subCaste=readValueFromExcelSheet().get(1).get("Sub Caste");
			 * System.out.println("Sub caste: "+subCaste);
			 * subCasteList.get(0).sendKeys(subCaste);
			 */
			Thread.sleep(1000);
			reg.getSubCaste_Done().click();
			System.out.println("subcaste selected");
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			reg.getSubCasteSearch().click();
			System.out.println("clicked on select subcaste");
			System.out.println("fetching value from Excel");
			String subCaste=getExcelData("Registration", 2, 12);
			System.out.println("Sub Caste: " + subCaste);
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(subCaste);
			reg.getSubCaste().click();
			System.out.println("subcaste selected");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Sub caste not Displayed");
		}
		try {
			/*
			 * java.util.List<IOSElement> religionList =
			 * driver.findElements(By.className("UIAPickerWheel"));
			 * System.out.println("Sub Caste size: "+religionList.size()); 
			 * String reli=getExcelData("Registration", 2, 11);
			 * System.out.println("Religion: "+reli); religionList.get(0).sendKeys(reli);
			 */
			Thread.sleep(1000);
			reg.getReligion_Done().click();
			Thread.sleep(3000);
			System.out.println("Religion selected");
			reg.getSubCaste_Done().click();
			System.out.println("Subcaste selected");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Religion field  not Displayed");
		}	
			try {
				reg.getDenominationSearch().click();
				String denomination=getExcelData("Registration", 2, 31);
				System.out.println("Denomination: " + denomination);
				((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(denomination);
				reg.getDenomination().click();
				Thread.sleep(3000);
				if (denomination.equalsIgnoreCase("Others")) {
					reg.getOthersDenomination().click();
					String otherDenomi=getExcelData("Registration", 2, 35);
					((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(otherDenomi);
					reg.getKeypad_Done().click();
					Thread.sleep(3000);
				}
				try {
					reg.getDivisionSearch().click();
					String division=getExcelData("Registration", 2, 32);
					System.out.println("Division: " + division);
					((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(division);
					reg.getDivision().click();
					Thread.sleep(3000);
					if (division.equalsIgnoreCase("Others")) {
						reg.getOthersDivision().click();
						String otherDivision=getExcelData("Registration", 2, 36);
						((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(otherDivision);
						reg.getKeypad_Done().click();
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					e.getMessage();
					System.out.println("Division field  not Displayed");
				}

			} catch (Exception e) {
				e.getMessage();
				System.out.println("Denomination field  not Displayed");
			}
			try {
				/*
				 * java.util.List<IOSElement> sectList =
				 * driver.findElements(By.className("UIAPickerWheel"));
				 * System.out.println("Sect size: "+sectList.size()); String
				 * st=readValueFromExcelSheet().get(1).get("Sect");
				 * System.out.println("Sect: "+st); sectList.get(0).sendKeys(st);
				 */
				Thread.sleep(1000);
				reg.getSect().click();
				Thread.sleep(3000);
				reg.getDivisionSearch().click();
				String muslimDivision=getExcelData("Registration", 2, 34);
				System.out.println("Division: " + muslimDivision);
				((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(muslimDivision);
				reg.getDivision().click();
			} catch (Exception e) {
				e.getMessage();
				System.out.println("Sect field  not Displayed");
			}
			Thread.sleep(1000);
			reg.getCheck_TermsAndCon().click();
			reg.getContinueButton().click();
			Thread.sleep(3000);
			reg.getMStatus().click();
		
		/*
		 * java.util.List<IOSElement> mStatusList =
		 * driver.findElements(By.className("UIAPickerWheel"));
		 * System.out.println("Marital statu size: "+mStatusList.size());
		 * mStatusList.get(0).sendKeys(m);
		 */
		String m=getExcelData("Registration", 2, 13);
		Thread.sleep(2000);
		reg.getMStatus_Done().click();
		if (m.equalsIgnoreCase("Unmarried")) {
			System.out.println("Marital Status: " + m);
		} else {
			System.out.println("Marital Status: " + m);
			/*
			 * java.util.List<IOSElement> childList =
			 * driver.findElements(By.className("UIAPickerWheel")); 
			 * String c=getExcelData("Registration", 2, 14);
			 * System.out.println("No.of Children: "+c); mStatusList.get(0).sendKeys(c);
			 */
			Thread.sleep(1000);
			reg.getNoOfChild_Done().click();
		}
		reg.getCountrysearch().click();
		String country=getExcelData("Registration", 2, 15);
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(country);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='" + country + "']")).click();
		boolean stateStatus = true;
		try {
			reg.getStateSearch().click();
			stateStatus = false;
			String state=getExcelData("Registration", 2, 16);
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(state);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='" + state + "']")).click();
			System.out.println("State: "+ state+" is selected");
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (stateStatus==true) {
			try {
				reg.getStateText().click();
				String state=getExcelData("Registration", 2, 16);
				((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(state);
				System.out.println("state : "+state+" is entered");
				reg.getKeypad_Done().click();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		boolean cityStatus = true;
		try {
			reg.getCitySearch().click();
			cityStatus = false;
			String city=getExcelData("Registration", 2, 17);
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(city);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='" + city + "']")).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (cityStatus==true) {
			reg.getCityText().click();
			String city=getExcelData("Registration", 2, 17);
			((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(city);
			reg.getKeypad_Done().click();
		}
		Thread.sleep(2000);
		try {
			reg.getCitizenshipSearch().click();
			String citizen=getExcelData("Registration", 2, 18);
			driver.findElement(By.xpath("//*[@id='" + citizen + "']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			/*
			 * java.util.List<IOSElement> residingStatusList =
			 * driver.findElements(By.className("UIAPickerWheel"));
			 * String residingStatus=getExcelData("Registration", 2, 19);
			 * residingStatusList.get(0).sendKeys(re);
			 */
			reg.getResidingStatus_Done().click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		reg.getContinueButton().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		reg.getHeight().click();
		Thread.sleep(2000);
		reg.getHeightSearch().click();
		Thread.sleep(1000);
		String ht=getExcelData("Registration", 2, 20);
		System.out.println(ht);
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(ht);
		reg.getHeightValue().click();
		reg.getEduSearch().click();
		String edu=getExcelData("Registration", 2, 22);
		System.out.println(edu);
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(edu);
		reg.getEduValue().click();
		Thread.sleep(2000);
		/*
		 * java.util.List<IOSElement> empInList =
		 * driver.findElements(By.className("UIAPickerWheel")); 
		 * String emp=getExcelData("Registration", 2, 23);
		 * empInList.get(0).sendKeys(emp);
		 */
		Thread.sleep(1000);
		reg.getEmplyedIn_Done().click();
		Thread.sleep(3000);
		reg.getOccuValue().click();
		Thread.sleep(4000);
		String incType=getExcelData("Registration", 2, 25);
		System.out.println();
		if (incType.equalsIgnoreCase("incType")) {
			reg.getIncomeType_Monthly().click();
		} else {
			reg.getIncomeType_Annual().click();
		}
		Thread.sleep(1000);
		reg.getSalary().click();
		String sal=getExcelData("Registration", 2, 26);
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(sal);
		reg.getKeypad_Num_Done().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> phyStatusList = driver.findElements(By.className("UIAPickerWheel"));
		String phy=getExcelData("Registration", 2, 21);
		phyStatusList.get(0).sendKeys(phy);
		Thread.sleep(1000);
		reg.getPhysicalStatus().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> fStatusList = driver.findElements(By.className("UIAPickerWheel"));
		String fStatus=getExcelData("Registration", 2, 27);
		fStatusList.get(0).sendKeys(fStatus);
		Thread.sleep(1000);
		reg.getFamilyStatus().click();
		Thread.sleep(1000);
		java.util.List<IOSElement> fTypeList = driver.findElements(By.className("UIAPickerWheel"));
		String fType=getExcelData("Registration", 2, 28);
		System.out.println("Family Type: " + fType);
		fTypeList.get(0).sendKeys(fType);
		Thread.sleep(2000);
		reg.getFamilyType().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> fValuesList = driver.findElements(By.className("UIAPickerWheel"));
		String fvalues=getExcelData("Registration", 2, 29);
		System.out.println("Family Type: " + fvalues);
		fValuesList.get(0).sendKeys(fvalues);
		reg.getFamilyValues().click();
		Thread.sleep(2000);
		reg.getGothram().click();
		String gothram=getExcelData("Registration", 2, 30);
		System.out.println(gothram);
		((IOSDriver<IOSElement>) driver).getKeyboard().pressKey(gothram);
		reg.getGothramValue().click();
		Thread.sleep(2000);
		reg.getContinueButton().click();
		 }
	
}
