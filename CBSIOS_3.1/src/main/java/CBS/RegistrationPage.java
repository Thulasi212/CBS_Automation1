package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class RegistrationPage {
	IOSDriver<IOSElement> driver;

	public RegistrationPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@placeholder='Select Community']")
	private WebElement selectComm;
	public WebElement getComm() {
		return selectComm;
	}

	@FindBy(xpath = "//*[@id='Select Community']")
	private WebElement commSearch;
	public WebElement getCommSearch() {
		return commSearch;
	}

	@FindBy(xpath = "//*[@id='BrahminMatrimony.com']")
	private WebElement brahminMatrimony;
	public WebElement getBrahminMatrimony() {
		return brahminMatrimony;
	}

	@FindBy(xpath = "//*[@placeholder='Password (6 or more characters)']")
	private WebElement profile_Self;
	public WebElement getProfile_Self() {
		return profile_Self;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement profile_Done;
	public WebElement getProfileCreate_Done() {
		return profile_Done;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypePicker']")
	private WebElement profileCraetedByValue;
	public WebElement getProfCraetedByValue() {
		return profileCraetedByValue;
	}

	@FindBy(xpath = "//*[@id='Male']")
	private WebElement gender_Male;
	public WebElement getGender_Male() {
		return gender_Male;
	}

	@FindBy(xpath = "//*[@id='Female']")
	private WebElement gender_Female;
	public WebElement getGender_Female() {
		return gender_Female;
	}

	@FindBy(xpath = "//*[@placeholder='Name']")
	private WebElement name;
	public WebElement getName() {
		return name;
	}

	@FindBy(xpath = "//*[@accessibilityLabel='Done']")
	private WebElement keypad_Done;
	public WebElement getKeypad_Done() {
		return keypad_Done;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement dob_Done;
	public WebElement getDob_Done() {
		return dob_Done;
	}

	@FindBy(xpath = "//*[@placeholder='Email']")
	private WebElement email;
	public WebElement getEmail() {
		return email;
	}

	@FindBy(xpath = "//*[@placeholder='Password (6 or more characters)']")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//*[@placeholder='Mobile Number']")
	private WebElement mobNo;
	public WebElement getMobNo() {
		return mobNo;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement keypad_Num_Done;
	public WebElement getKeypad_Num_Done() {
		return keypad_Num_Done;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeSearchField']")
	private WebElement motherTongueSearch;
	public WebElement getMotherTongueSearch() {
		return motherTongueSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement motherTongue;
	public WebElement getMotherTongue() {
		return motherTongue;
	}

	@FindBy(xpath = "//*[@placeholder='Select Caste / Division']")
	private WebElement casteOrDivisionSearch;
	public WebElement getCasteOrDivisionSearch() {
		return casteOrDivisionSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement casteOrDivision;
	public WebElement getCasteOrDivision() {
		return casteOrDivision;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement subCaste_Done;
	public WebElement getSubCaste_Done() {
		return subCaste_Done;
	}

	@FindBy(xpath = "//*[@placeholder='Select Subcaste']")
	private WebElement subCasteSearch;
	public WebElement getSubCasteSearch() {
		return subCasteSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement subCaste;
	public WebElement getSubCaste() {
		return subCaste;
	}

	@FindBy(xpath = "///*[@text='Religion']/following-sibling::*")
	private WebElement religion_Done;
	public WebElement getReligion_Done() {
		return religion_Done;
	}

	@FindBy(xpath = "//*[@placeholder='Select Denomination']")
	private WebElement denominationSearch;
	public WebElement getDenominationSearch() {
		return denominationSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement denomination;
	public WebElement getDenomination() {
		return denomination;
	}

	@FindBy(xpath = "//*[@placeholder='Other Denomination']")
	private WebElement otherDenomination;
	public WebElement getOthersDenomination() {
		return otherDenomination;
	}

	@FindBy(xpath = "//*[@placeholder='Select Division']")
	private WebElement divisionSearch;
	public WebElement getDivisionSearch() {
		return divisionSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement division;
	public WebElement getDivision() {
		return division;
	}

	@FindBy(xpath = "//*[@placeholder='Other Division']")
	private WebElement otherDivision;
	public WebElement getOthersDivision() {
		return otherDivision;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement sect;
	public WebElement getSect() {
		return sect;
	}

	@FindBy(xpath = "//*[@id='btn Uncheck']")
	private WebElement check_TermsAndCon;
	public WebElement getCheck_TermsAndCon() {
		return check_TermsAndCon;
	}

	@FindBy(xpath = "//*[@id='Continue']")
	private WebElement continueButton;
	public WebElement getContinueButton() {
		return continueButton;
	}

	@FindBy(xpath = "//*[@placeholder='Marital Status']")
	private WebElement mStatus;
	public WebElement getMStatus() {
		return mStatus;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement mStatus_Done;
	public WebElement getMStatus_Done() {
		return mStatus_Done;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement noOfChild_Done;
	public WebElement getNoOfChild_Done() {
		return noOfChild_Done;
	}

	@FindBy(xpath = "//*[@placeholder='Select Country']")
	private WebElement countrySearch;
	public WebElement getCountrysearch() {
		return countrySearch;
	}

	@FindBy(xpath = "//*[@placeholder='Select State']")
	private WebElement stateSearch;
	public WebElement getStateSearch() {
		return stateSearch;
	}

	@FindBy(xpath = "//*[@placeholder='State']")
	private WebElement stateText;
	public WebElement getStateText() {
		return stateText;
	}

	@FindBy(xpath = "//*[@placeholder='Select City']")
	private WebElement citySearch;
	public WebElement getCitySearch() {
		return citySearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeTextField']")
	private WebElement cityText;
	public WebElement getCityText() {
		return cityText;
	}

	@FindBy(xpath = "//*[@placeholder='Select Citizenship']")
	private WebElement citizenshipSearch;
	public WebElement getCitizenshipSearch() {
		return citizenshipSearch;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement residingStatus_Done;
	public WebElement getResidingStatus_Done() {
		return residingStatus_Done;
	}

	@FindBy(xpath = "//*[@placeholder='Height']")
	private WebElement ht;
	public WebElement getHeight() {
		return ht;
	}

	@FindBy(xpath = "//*[@placeholder='Select Height']")
	private WebElement htSearch;
	public WebElement getHeightSearch() {
		return htSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement htValue;
	public WebElement getHeightValue() {
		return htValue;
	}

	@FindBy(xpath = "//*[@placeholder='Select Education']")
	private WebElement edu;
	public WebElement getEduSearch() {
		return edu;
	}

	@FindBy(xpath = "//*[@id='B.Tech.']")
	private WebElement eduValue;
	public WebElement getEduValue() {
		return eduValue;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement emplyedIn_Done;
	public WebElement getEmplyedIn_Done() {
		return emplyedIn_Done;
	}

	@FindBy(xpath = "//*[@id='Clerk']")
	private WebElement occuValue;
	public WebElement getOccuValue() {
		return occuValue;
	}

	@FindBy(xpath = "///*[@id='Monthly']")
	private WebElement incomeType_Monthly;

	public WebElement getIncomeType_Monthly() {
		return incomeType_Monthly;
	}

	@FindBy(xpath = "//*[@id='Annual']")
	private WebElement incomeType_Annual;

	public WebElement getIncomeType_Annual() {
		return incomeType_Annual;
	}

	@FindBy(xpath = "//*[@placeholder='Enter Salary']")
	private WebElement salary;

	public WebElement getSalary() {
		return salary;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement physicalStatus;

	public WebElement getPhysicalStatus() {
		return physicalStatus;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement familyStatus;

	public WebElement getFamilyStatus() {
		return familyStatus;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement familyType;

	public WebElement getFamilyType() {
		return familyType;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement familyValues;

	public WebElement getFamilyValues() {
		return familyValues;
	}

	@FindBy(xpath = "//*[@placeholder='Select Gothram']")
	private WebElement gothramSearch;

	public WebElement getGothram() {
		return gothramSearch;
	}

	@FindBy(xpath = "//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement gothramValue;

	public WebElement getGothramValue() {
		return gothramValue;
	}

}
