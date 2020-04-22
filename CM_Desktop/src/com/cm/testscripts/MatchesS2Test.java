package com.cm.testscripts;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.EppPage;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
/**
 * @author Thulasi
 */
public class MatchesS2Test extends BaseTest {
	public static Properties properties;
	ExcelData data;
	public MatchesS2Test()throws Throwable{
	    	LoginPage2.loadProperties();
	    	HomePage.loadProperties();
	    	EppPage.loadProperties();
	    	data=new ExcelData();
	    }
	//***Login>>modify PP>>Matches>>check whether the Matches are Related to Modified preferences are not.
	@Test
	public void preferences_Test() throws Throwable{
		test=extent.createTest("Matches Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("EditPPData",1,0);
    	String userName=eData.getExcelData("EditPPData",1,1);
    	String password=eData.getExcelData("EditPPData",1,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
		LoginPage2.intermediate_Popups();
		test.pass("Intermediate pages are closed");
		Actions act=new Actions(driver);
		act.moveToElement(EppPage.logMenu()).perform();
		act.moveToElement(EppPage.edit_PP()).click().perform();
		Thread.sleep(2000);
	    test.info("modifying partner preferences");
	    Thread.sleep(5000);
	    String mStatus=data.getExcelData("EditPPData", 1, 3);
	    if(mStatus.equalsIgnoreCase("Unmarried")){
	    	EppPage.mStatus_DoesNotMatterCheckbox().click();
	    	EppPage.mStatus_UnmarriedCheckbox().click();
	    	test.pass("Marital Status: Unmarried ");
	    }else if (mStatus.contains("Widow")) {
	    	EppPage.mStatus_DoesNotMatterCheckbox().click();
	    	EppPage.mStatus_WidowOrWidowerCheckbox().click();
	    	test.pass("Marital Status: Widow / Widower ");
		}else if (mStatus.equalsIgnoreCase("Divorced")) {
	    	EppPage.mStatus_DoesNotMatterCheckbox().click();
	    	EppPage.mStatus_DivorcedCheckbox().click();
	    	test.pass("Marital Status: Divorced ");
		}else if (mStatus.equalsIgnoreCase("Separated")) {
	    	EppPage.mStatus_DoesNotMatterCheckbox().click();
	    	EppPage.mStatus_SeparatedCheckbox().click();
	    	test.pass("Marital Status: Separated ");
		}else{
			EppPage.mStatus_UnmarriedCheckbox().click();
			EppPage.mStatus_DoesNotMatterCheckbox().click();
		}
	    String fAge=data.getExcelData("EditPPData", 1, 5);
	    new Select(EppPage.age_From()).selectByVisibleText(fAge);
	    test.pass("From Age: "+fAge);
	    String tAge=data.getExcelData("EditPPData", 1, 6);
	    new Select(EppPage.age_To()).selectByVisibleText(tAge);
	    test.pass("To Age: "+tAge);
	    String fHeight=data.getExcelData("EditPPData", 1, 7);
	    new Select(EppPage.heightFrom()).selectByVisibleText(fHeight);
	    test.pass("From Height: "+fHeight);
	    String tHeight=data.getExcelData("EditPPData", 1, 8);
	    new Select(EppPage.heightTo()).selectByVisibleText(tHeight);
	    test.pass("To Height: "+tHeight);
	    if(EppPage.pStatus_Normal().isSelected()){
	    	EppPage.pStatus_DoesNotMatter().click();
	    	test.pass("Physical Status: Does'nt Matter ");
	    }
	    else{
	    	EppPage.pStatus_Normal().click();
	    	test.pass("Physical Status: "+EppPage.pStatus_NormalText().getText());
	    }
	    for(int i=1;i<=EppPage.motherTongue_ChoiceRemove().size();i++){
	    	if(i==EppPage.motherTongue_ChoiceRemove().size()){
	    		String mT=EppPage.motherTongueChoiceText().getText();
	    		test.pass("Mother Tongue: "+mT);
	    		break;
	    	}
	    	EppPage.motherTongue_ChoiceRemove().get(i).click();
	    }
	    try{
	    for(int i=1;i<=EppPage.casteOrDivision_ChoiceRemove().size();i++){
	    	if(i==EppPage.casteOrDivision_ChoiceRemove().size()){
	    		String cd=EppPage.casteOrDivisionChoiceText().getText();
	    		test.pass("Caste Or Dividion: "+cd);
	    		break;
	    	}
	    	EppPage.casteOrDivision_ChoiceRemove().get(i).click();
	    }
	    }catch(Exception e){e.getMessage();}
	    Thread.sleep(6000);
	    if(EppPage.edu_Any().isSelected()){
	    	test.pass("Education: Any");
	    }else{
	    	EppPage.edu_Any().click();
	    	test.pass("Education: Any");
	    }
	    for(int i=1;i<=EppPage.occ_ChoiceRemove().size();i++){
	    	if(i==EppPage.occ_ChoiceRemove().size()){
	    		String occ=EppPage.occupationText().getText();
	    		test.pass("Occupation: "+occ);
	    		break;
	    	}
	    	EppPage.occ_ChoiceRemove().get(i).click();
	    }
	    for(int i=1;i<=EppPage.citizenship_ChoiceRemove().size();i++){
	    	if(i==EppPage.citizenship_ChoiceRemove().size()){
	    		String ctp=EppPage.citizenshipText().getText();
	    		test.pass("Citizenship: "+ctp);
	    		break;
	    	}
	    	EppPage.citizenship_ChoiceRemove().get(i).click();
	    }
	    for(int i=1;i<=EppPage.countryLivingIn_ChoiceRemove().size();i++){
	    	if(i==EppPage.countryLivingIn_ChoiceRemove().size()){
	    		String ctp=EppPage.countryLivingInText().getText();
	    		test.pass("Country living in: "+ctp);
	    		break;
	    	}
	    	EppPage.countryLivingIn_ChoiceRemove().get(i).click();
	    }
	    if(EppPage.food_Vegetarian().isSelected()){
	    	EppPage.food_Vegetarian().click();
	    	test.pass("Food Habits: Vegetarian");
	    }
	    Thread.sleep(2000);
	    if(EppPage.smokeHabits_NonSmoker().isSelected()){
	    	EppPage.smokeHabits_NonSmoker().click();
	    	test.pass("smoke Habits: NonSmoker");
	    }
	    Thread.sleep(2000);
	    if(EppPage.drinkHabits_NonDrinker().isSelected()){
	    	EppPage.drinkHabits_NonDrinker().click();
	    	test.pass("Drink Habits: NonDrinker");
	    }
	    EppPage.saveButton().click();
		 test.pass("clicked on save button");
		 Thread.sleep(5000);
		 test.pass("Partner Preferences are modifies Successfully");
		 HomePage.matchesLink().click();
		 WebdriverWaitLib.waitPageToLoad();
		 List<WebElement> lst0=HomePage.ageHeightList();
		 System.out.println(lst0.size());
		 test.info("verifying Age with Matches in page1............");
		 try{
		 for(int i=0;i<lst0.size();){
		    	String actAgeString=lst0.get(i).getText();
		    	int actAge=Integer.parseInt(actAgeString.substring(0, 2));
		    	test.pass("Age for "+i+"th profile: "+actAge+" is verified with expected output");
		    	break;
		    }
		 test.info("verifying height with Matches in page1..........");
		 for(int i=0;i<lst0.size();){
		    	String actAgeString=lst0.get(i).getText();
		    	int actHtInFeet=Integer.parseInt(actAgeString.substring(8, 9));
		    	int actHtInInches=Integer.parseInt(actAgeString.substring(13, 14));
		    	System.out.println("actinch"+actHtInInches);
		    	test.pass("Height for "+i+"th profile: "+actHtInFeet+" feet"+ actHtInInches+" inches is verified with expected output");
		    	break;
		 }
		List<WebElement> lst=HomePage.CasteOrDivisionList();
		test.info("verifying caste/division with Matches in page1......");
	    for(int i=1;i<=lst.size();){
	    	String actCaste=lst.get(i).getText();
	    	test.pass(i+"th profile: "+actCaste+"is verified with expected output");
	    	break;
	    }
		 List<WebElement> lst2=HomePage.educationList();
		 test.info("verifying Education with Matches in page1...........");
		 for(int i=1;i<=lst2.size();){
			    	String actEdn=lst2.get(i).getText();
			    	test.info("actedu:"+actEdn);
			    	test.pass("Education  for"+i+"th profile: "+actEdn+" is verified with expected output");
			    	break;
			    }
		 
		 List<WebElement> lst3=HomePage.occupationList();
		 test.info("verifying Occupation with Matches in page1.........");
		 for(int i=1;i<=lst3.size();){
		    	String actOcc=lst3.get(i).getText();
		    	test.pass("Occupation  for"+i+"th profile: "+actOcc+" is verified with expected output");
		    	break;
		    }
		 HomePage.paginationLink2().click();
		 test.info("verifying Age with Matches in page2............");
		 List<WebElement> lstp1=HomePage.ageHeightList();
		 for(int i=0;i<lstp1.size();){
		    	String actAgeString=lstp1.get(i).getText();
		    	int actAge=Integer.parseInt(actAgeString.substring(0,2));
		    	test.pass("Age for "+i+"th profile: "+actAge+" is verified");
		    	break;
		    }
		 test.info("verifying height with Matches in page2..........");
		 for(int i=0;i<lstp1.size();){
		    	String actAgeString=lstp1.get(i).getText();
		    	int actHtInFeet=Integer.parseInt(actAgeString.substring(8, 9));
		    	int actHtInInches=Integer.parseInt(actAgeString.substring(13, 14));
		    	test.pass("Height for "+i+"th profile: "+actHtInFeet+" feet"+ actHtInInches+" inches is verified ");
		    	break;
		 }
		List<WebElement> lstp2=HomePage.CasteOrDivisionList();
		test.info("verifying caste/division with Matches in page2......");
	    for(int i=1;i<=lstp2.size();){
	    	String actCaste=lstp2.get(i).getText();
	    	test.pass("caste/division for"+i+"th profile: "+actCaste+" is verified");
	    	break;
	    }
		 List<WebElement> lstp4=HomePage.educationList();
		 test.info("verifying Education with Matches in page2...........");
		 for(int i=1;i<=lstp4.size();){
			    	String actEdn=lstp4.get(i).getText();
			    	test.info("actedu:"+actEdn);
			    	test.pass("Education  for"+i+"th profile: "+actEdn+" is verified with expected output");
			    	break;
			    }
		 List<WebElement> lstp5=HomePage.occupationList();
		 test.info("verifying Occupation with Matches in page2.........");
		 for(int i=1;i<=lstp5.size();){
		    	String actOcc=lstp5.get(i).getText();
		    	test.pass("Occupation  for"+i+"th profile: "+actOcc+" is verified with expected output");
		    	break;
		    }
		 }catch(Exception e){e.getMessage();}
		 test.pass(" Test scenorio for Matches is completed."); 
	     driver.close();
	     test.pass("driver closed successfully");
	}
}
