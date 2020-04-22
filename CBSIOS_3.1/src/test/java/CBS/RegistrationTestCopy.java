package CBS;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicFunctions.Base;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class RegistrationTestCopy extends Base {
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
		String communityName = readValueFromExcelSheet().get(1).get("CommunityName");
		System.out.println("Community name: " + communityName);
		reg.getComm().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		reg.getCommSearch().click();
		((IOSDriver) driver).getKeyboard().pressKey(communityName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='" + communityName + "']")).click();
		Thread.sleep(2000);
		java.util.List<IOSElement> prof = driver.findElements(By.className("UIAPickerWheel"));
		String proCreate = readValueFromExcelSheet().get(1).get("Profile Created By");
		System.out.println("Profile created By: " + proCreate);
		prof.get(0).sendKeys(proCreate);
		Thread.sleep(1000);
		// reg.getProfileCreate_Done().click();
		System.out.println("Profile created by selected");
		Thread.sleep(3000);
		String gender = readValueFromExcelSheet().get(1).get("Gender");
		System.out.println("Gender" + gender);
		if (gender.equalsIgnoreCase("Male")) {
			reg.getGender_Male().click();
		} else {
			reg.getGender_Female().click();
		}
		System.out.println("Gender selected");
		Thread.sleep(1000);
		String name = readValueFromExcelSheet().get(1).get("Name");
		reg.getName().click();
		((IOSDriver) driver).getKeyboard().pressKey(name);
		reg.getKeypad_Done().click();
		Thread.sleep(1000);
		System.out.println("Name: " + name);
		java.util.List<IOSElement> dob = driver.findElements(By.className("UIAPickerWheel"));
		System.out.println("DOB size: " + dob.size());
		String year = readValueFromExcelSheet().get(1).get("Dob_Year");
		dob.get(2).sendKeys(year);
		String month = readValueFromExcelSheet().get(1).get("Dob_Month");
		dob.get(1).sendKeys(month);
		String date = readValueFromExcelSheet().get(1).get("Dob_Date");
		dob.get(0).sendKeys(date);
		Thread.sleep(1000);
		reg.getDob_Done().click();
		Thread.sleep(1000);
		String mail = "supertestregmail" + Math.floor(Math.random() * 143231) + "@gmail.com";
		reg.getEmail().click();
		((IOSDriver) driver).getKeyboard().pressKey(mail);
		reg.getKeypad_Done().click();
		System.out.println("Email: " + mail);
		Thread.sleep(2000);
		String password = readValueFromExcelSheet().get(1).get("Password");
		reg.getPassword().click();
		((IOSDriver) driver).getKeyboard().pressKey(password);
		reg.getKeypad_Done().click();
		System.out.println("Password: " + password);
		Thread.sleep(2000);
		String mobileNo = readValueFromExcelSheet().get(1).get("Mobile Number");
		System.out.println("Mobile NUmber: " + mobileNo);
		reg.getMobNo().click();
		((IOSDriver) driver).getKeyboard().pressKey(mobileNo);
		reg.getKeypad_Num_Done().click();
		Thread.sleep(2000);
		String mT = readValueFromExcelSheet().get(1).get("Mother Tongue");
		System.out.println("Mother Tongue: " + mT);
		if (communityName.equalsIgnoreCase("KeralachristianMatrimony.com")) {
			System.out.println("Mother Tongue pre selected");
		} else {
			reg.getMotherTongueSearch().click();
			((IOSDriver) driver).getKeyboard().pressKey(mT);
			reg.getMotherTongue().click();
		}
		boolean status1 = false;
		boolean status2 = false;
		for (int i = 0; i < 1;) {
			try {
				reg.getCasteOrDivisionSearch().click();
				System.out.println("Clicked on Select Caste/Division ");
				status1 = true;
				System.out.println("Fetching Caste/Division value from Excel...");
				
				String casteDivi = Base.getExcelData("Registration", 2, 10);
				System.out.println("Caste/Division: " + casteDivi);
				((IOSDriver) driver).getKeyboard().pressKey(casteDivi);
				reg.getCasteOrDivision().click();
				System.out.println("Caste/Division selected");
				Thread.sleep(2000);
				try {
					java.util.List<IOSElement> subCasteList = driver.findElements(By.className("UIAPickerWheel"));
					System.out.println("Sub Caste size: " + subCasteList.size());
					String subCaste = readValueFromExcelSheet().get(1).get("Sub Caste");
					System.out.println("Sub caste: " + subCaste);
					subCasteList.get(0).sendKeys(subCaste);
					Thread.sleep(1000);
					reg.getSubCaste_Done().click();
					System.out.println("subcaste selected");
					status2 = true;
				} catch (Exception e) {
					e.getMessage();
				}
				if (status2 == true) {
					break;
				}
				try {
					reg.getSubCasteSearch().click();
					System.out.println("clicked on select subcaste");
					status2 = true;
					System.out.println("fetching value from Excel");
					String subCaste = readValueFromExcelSheet().get(1).get("Sub Caste");
					System.out.println("Sub Caste: " + subCaste);
					((IOSDriver) driver).getKeyboard().pressKey(subCaste);
					reg.getSubCaste().click();
					System.out.println("subcaste selected");
				} catch (Exception e) {
					e.getMessage();
					System.out.println("Sub caste not Displayed");
				}

			} catch (Exception e) {
				e.getMessage();
				System.out.println("Caste/ Division not Displayed");
			}
			if (status1 == true) {
				break;
			}
			try {
				java.util.List<IOSElement> religionList = driver.findElements(By.className("UIAPickerWheel"));
				System.out.println("Sub Caste size: " + religionList.size());
				String reli = readValueFromExcelSheet().get(1).get("Religion");
				System.out.println("Religion: " + reli);
				religionList.get(0).sendKeys(reli);
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
			if (status1 == true) {
				break;
			}
			try {

				reg.getDenominationSearch().click();
				status1 = true;
				String denomination = readValueFromExcelSheet().get(1).get("Denomination");
				System.out.println("Denomination: " + denomination);
				((IOSDriver) driver).getKeyboard().pressKey(denomination);
				reg.getDenomination().click();
				Thread.sleep(3000);
				if (denomination.equalsIgnoreCase("Others")) {
					reg.getOthersDenomination().click();
					String otherDenomi = readValueFromExcelSheet().get(1).get("Others_Denomination");
					((IOSDriver) driver).getKeyboard().pressKey(otherDenomi);
					reg.getKeypad_Done().click();
					Thread.sleep(3000);
				}
				try {
					reg.getDivisionSearch().click();
					String division = readValueFromExcelSheet().get(1).get("Division");
					System.out.println("Division: " + division);
					((IOSDriver) driver).getKeyboard().pressKey(division);
					reg.getDivision().click();
					Thread.sleep(3000);
					if (division.equalsIgnoreCase("Others")) {
						reg.getOthersDivision().click();
						String otherDivision = readValueFromExcelSheet().get(1).get("Others_Division");
						((IOSDriver) driver).getKeyboard().pressKey(otherDivision);
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
			if (status1 == true) {
				break;
			}
			try {
				java.util.List<IOSElement> sectList = driver.findElements(By.className("UIAPickerWheel"));
				System.out.println("Sect size: " + sectList.size());
				String st = readValueFromExcelSheet().get(1).get("Sect");
				System.out.println("Sect: " + st);
				sectList.get(0).sendKeys(st);
				Thread.sleep(1000);
				reg.getSect().click();
				Thread.sleep(3000);
				reg.getDivisionSearch().click();
				String division1 = readValueFromExcelSheet().get(1).get("Muslim_Division");
				System.out.println("Division: " + division1);
				((IOSDriver) driver).getKeyboard().pressKey(division1);
				reg.getDivision().click();
			} catch (Exception e) {
				e.getMessage();
				System.out.println("Sect field  not Displayed");
			}

		}
		Thread.sleep(1000);
		reg.getCheck_TermsAndCon().click();
		reg.getContinueButton().click();
		Thread.sleep(3000);
		reg.getMStatus().click();
		java.util.List<IOSElement> mStatusList = driver.findElements(By.className("UIAPickerWheel"));
		System.out.println("Marital statu size: " + mStatusList.size());
		String m = readValueFromExcelSheet().get(1).get("Marital Status");
		mStatusList.get(0).sendKeys(m);
		Thread.sleep(2000);
		reg.getMStatus_Done().click();
		if (m.equalsIgnoreCase("Unmarried")) {
			System.out.println("Marital Status: " + m);
		} else {
			System.out.println("Marital Status: " + m);
			java.util.List<IOSElement> childList = driver.findElements(By.className("UIAPickerWheel"));
			String c = readValueFromExcelSheet().get(1).get("No.of Children");
			System.out.println("No.of Children: " + c);
			mStatusList.get(0).sendKeys(c);
			Thread.sleep(1000);
			reg.getNoOfChild_Done().click();
		}
		reg.getCountrysearch().click();
		String country = readValueFromExcelSheet().get(1).get("Country");
		((IOSDriver) driver).getKeyboard().pressKey(country);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='" + country + "']")).click();
		boolean stateStatus = true;
		try {
			reg.getStateSearch().click();
			stateStatus = false;
			String state = readValueFromExcelSheet().get(1).get("State");
			((IOSDriver) driver).getKeyboard().pressKey(state);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='" + state + "']")).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (stateStatus) {
			try {
				reg.getStateText().click();
				String state = readValueFromExcelSheet().get(1).get("State");
				((IOSDriver) driver).getKeyboard().pressKey(state);
				reg.getKeypad_Done().click();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		boolean cityStatus = true;
		try {
			reg.getCitySearch().click();
			cityStatus = false;
			String city = readValueFromExcelSheet().get(1).get("City");
			((IOSDriver) driver).getKeyboard().pressKey(city);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='" + city + "']")).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (cityStatus) {
			reg.getCityText().click();
			String city = readValueFromExcelSheet().get(1).get("City");
			((IOSDriver) driver).getKeyboard().pressKey(city);
			reg.getKeypad_Done().click();
		}
		Thread.sleep(2000);
		try {
			reg.getCitizenshipSearch().click();
			String citizen = readValueFromExcelSheet().get(1).get("Citizenship");
			driver.findElement(By.xpath("//*[@id='" + citizen + "']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			java.util.List<IOSElement> residingStatusList = driver.findElements(By.className("UIAPickerWheel"));
			String re = readValueFromExcelSheet().get(1).get("Residing Status");
			residingStatusList.get(0).sendKeys(re);
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
		String ht = readValueFromExcelSheet().get(1).get("Height");
		System.out.println(ht);
		((IOSDriver) driver).getKeyboard().pressKey(ht);
		reg.getHeightValue().click();
		reg.getEduSearch().click();
		String ed = readValueFromExcelSheet().get(1).get("Education");
		System.out.println(ed);
		((IOSDriver) driver).getKeyboard().pressKey(ed);
		reg.getEduValue().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> empInList = driver.findElements(By.className("UIAPickerWheel"));
		String emp = readValueFromExcelSheet().get(1).get("Emploed In");
		empInList.get(0).sendKeys(emp);
		Thread.sleep(1000);
		reg.getEmplyedIn_Done().click();
		Thread.sleep(3000);
		reg.getOccuValue().click();
		Thread.sleep(4000);
		String incType = readValueFromExcelSheet().get(1).get("IncomeType");
		System.out.println();
		if (incType.equalsIgnoreCase("incType")) {
			reg.getIncomeType_Monthly().click();
		} else {
			reg.getIncomeType_Annual().click();
		}
		Thread.sleep(1000);
		reg.getSalary().click();
		String sal = readValueFromExcelSheet().get(1).get("Salary");
		((IOSDriver) driver).getKeyboard().pressKey(sal);
		reg.getKeypad_Num_Done().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> phyStatusList = driver.findElements(By.className("UIAPickerWheel"));
		String phy = readValueFromExcelSheet().get(1).get("Physical Status");
		phyStatusList.get(0).sendKeys(phy);
		Thread.sleep(1000);
		reg.getPhysicalStatus().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> fStatusList = driver.findElements(By.className("UIAPickerWheel"));
		String fStatus = readValueFromExcelSheet().get(1).get("Family Status");
		fStatusList.get(0).sendKeys(fStatus);
		Thread.sleep(1000);
		reg.getFamilyStatus().click();
		Thread.sleep(1000);
		java.util.List<IOSElement> fTypeList = driver.findElements(By.className("UIAPickerWheel"));
		String fType = readValueFromExcelSheet().get(1).get("Family Type");
		System.out.println("Family Type: " + fType);
		fTypeList.get(0).sendKeys(fType);
		Thread.sleep(2000);
		reg.getFamilyType().click();
		Thread.sleep(2000);
		java.util.List<IOSElement> fValuesList = driver.findElements(By.className("UIAPickerWheel"));
		String fvalues = readValueFromExcelSheet().get(1).get("Family Values");
		System.out.println("Family Type: " + fvalues);
		fValuesList.get(0).sendKeys(fvalues);
		reg.getFamilyValues().click();
		Thread.sleep(2000);
		reg.getGothram().click();
		String gothram = readValueFromExcelSheet().get(1).get("Gothram");
		System.out.println(gothram);
		((IOSDriver) driver).getKeyboard().pressKey(gothram);
		reg.getGothramValue().click();
		Thread.sleep(2000);
		reg.getContinueButton().click();

	}
}
