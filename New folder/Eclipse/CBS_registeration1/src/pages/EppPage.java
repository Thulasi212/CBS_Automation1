package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseTest;
public class EppPage extends BaseTest {
	public static Properties properties;
	//*****LOGOUT MENU******
	public  static WebElement logoutMenu(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("logoutMenu")));
		return element;
	}
	public  static WebElement edit_PP(){
		WebElement element=driver.findElement(By.linkText(properties.getProperty("edit_PP")));
		return element;
	}
	
	//*****MARITAL STATUS*****
	public  static WebElement mStatus_UnmarriedCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_UnmarriedCheckbox")));
		return element;
	}
	public  static WebElement mStatus_WidowOrWidowerCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_WidowOrWidowerCheckbox")));
		return element;
	}
	public  static WebElement mStatus_DivorcedCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_DivorcedCheckbox")));
		return element;
	}
	public  static WebElement mStatus_SeparatedCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_SeparatedCheckbox")));
		return element;
	}
	public  static WebElement mStatus_DoesNotMatterCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_DoesNotMatterCheckbox")));
		return element;
	}
	public  static WebElement mStatus_UnmarriedText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mStatus_UnmarriedText")));
		return element;
	}
	
	//*****HAVE CHILDREN******
	public  static WebElement child_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("child_DoesNotMatter")));
		return element;
	}
	public  static WebElement child_YesLivingToGether(){
		WebElement element=driver.findElement(By.id(properties.getProperty("child_YesLivingToGether")));
		return element;
	}
	public  static WebElement child_YesNotLivingToGether(){
		WebElement element=driver.findElement(By.id(properties.getProperty("child_YesNotLivingToGether")));
		return element;
	}
	public  static WebElement child_No(){
		WebElement element=driver.findElement(By.id(properties.getProperty("child_No")));
		return element;
	}
	
	//*****AGE**********
	public  static WebElement age_From(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("age_From")));
		return element;
	}
	public  static WebElement age_To(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("age_To")));
		return element;
	}

	//*****HIGHT*********
	public  static WebElement heightFrom(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("heightFrom")));
		return element;
	}
	public  static WebElement heightTo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("heightTo")));
		return element;
	}
	
	//*****PHYSICAL sTATUS***
	public  static WebElement pStatus_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("pStatus_DoesNotMatter")));
		return element;
	}
	public  static WebElement pStatus_Normal(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("pStatus_Normal")));
		return element;
	}
	public  static WebElement pStatus_NormalText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("pStatus_NormalText")));
		return element;
	}
	public  static WebElement pStatus_PChallenged(){
		WebElement element=driver.findElement(By.id(properties.getProperty("pStatus_PChallenged")));
		return element;
	}
	
	//******MOTHER TONGUE********
	public  static List<WebElement> motherTongue_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("motherTongue_ChoiceRemove")));
		return lst;
	}
	public  static WebElement motherTongueChoiceText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("motherTongueChoiceText")));
		return element;
	}
	public  static WebElement motherTongue(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("motherTongue")));
		return element;
	}
	
	//*******Caste/Division**********
	public  static WebElement casteOrDivision(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("casteOrDivision")));
		return element;
	}
	public  static List<WebElement> casteOrDivision_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("casteOrDivision_ChoiceRemove")));
		return lst;
	}
	public  static WebElement casteOrDivisionChoiceText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("casteOrDivisionChoiceText")));
		return element;
	}
	//*******SUBCASTE***************
	public  static List<WebElement> subCaste_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("subCaste_ChoiceRemove")));
		return lst;
	}
	public  static WebElement subCasteChoiceText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("subCasteChoiceText")));
		return element;
	}
	public  static WebElement subCaste(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("subCaste")));
		return element;
	}
	
	//*******STAR***************
	public  static List<WebElement> star_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("star_ChoiceRemove")));
		return lst;
	}   
	public  static WebElement starChoiceText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("starChoiceText")));
		return element;
	}
	public  static WebElement star(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("star")));
		return element;
	}
	
	
	//********GOTHRA***********
	public  static List<WebElement> gothra_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("gothra_ChoiceRemove")));
		return lst;
	} 
	public  static WebElement gothraChoiceText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("gothraChoiceText")));
		return element;
	}
	public  static WebElement gothra(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("gothra")));
		return element;
	}
	
	
	//************MANGLILK**********
	public  static WebElement manglik_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("manglik_DoesNotMatter")));
		return element;
	}
	public  static WebElement manglik_Yes(){
		WebElement element=driver.findElement(By.id(properties.getProperty("manglik_Yes")));
		return element;
	}
	public  static WebElement manglik_No(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("manglik_No")));
		return element;
	}
	//*****EDUCATION***************
	public  static WebElement edu_Any(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("edu_Any")));
		return element;
	}
	public  static WebElement edu_AnyDegree(){
		WebElement element=driver.findElement(By.id(properties.getProperty("edu_AnyDegree")));
		return element;
	}
	public  static WebElement edu_ProfDegree(){
		WebElement element=driver.findElement(By.id(properties.getProperty("edu_ProfDegree")));
		return element;
	}
	public  static WebElement edu_SpecificDegree(){
		WebElement element=driver.findElement(By.id(properties.getProperty("edu_SpecificDegree")));
		return element;
	}
	//***********OCCUPATION*************
	public  static List<WebElement> occ_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("occ_ChoiceRemove")));
		return lst;
	}
	
	public  static WebElement occupationText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("occupationText")));
		return element;
	} 
	public  static WebElement occupation(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("occupation")));
		return element;
	} 
	//*************CITIZENSHIP************
	public  static List<WebElement> citizenship_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("citizenship_ChoiceRemove")));
		return lst;
	}
	public  static WebElement citizenshipText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("citizenshipText")));
		return element;
	}
	public  static WebElement citizenship(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("citizenship")));
		return element;
	}
	
	//**************Country Living In ********
	public  static List<WebElement> countryLivingIn_ChoiceRemove(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("countryLivingIn_ChoiceRemove")));
		return lst;
	}
	public  static WebElement countryLivingInText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("countryLivingInText")));
		return element;
	}
	public  static WebElement countryLivingIn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("countryLivingIn")));
		return element;
	}
	//*****FOOD HABITS*************
	public  static WebElement food_Vegetarian(){
		WebElement element=driver.findElement(By.id(properties.getProperty("food_Vegetarian")));
		return element;
	}
	public  static WebElement food_NonVegetarian(){
		WebElement element=driver.findElement(By.id(properties.getProperty("food_NonVegetarian")));
		return element;
	}
	public  static WebElement food_Eggetarian(){
		WebElement element=driver.findElement(By.id(properties.getProperty("food_Eggetarian")));
		return element;
	}
	public  static WebElement food_Vegen(){
		WebElement element=driver.findElement(By.id(properties.getProperty("food_Vegen")));
		return element;
	}
	public  static WebElement food_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("food_DoesNotMatter")));
		return element;
	}
	
	//******SMOKING HABITS******
	public  static WebElement smokeHabits_NonSmoker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("smokeHabits_NonSmoker")));
		return element;
	}
	public  static WebElement smokeHabits_LightOrSocialSmoker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("smokeHabits_LightOrSocialSmoker")));
		return element;
	}
	public  static WebElement smokeHabits_RegularSmoker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("smokeHabits_RegularSmoker")));
		return element;
	}
	public  static WebElement smokeHabits_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("smokeHabits_DoesNotMatter")));
		return element;
	}
	
	//*****Drinking Habits*****
	public  static WebElement drinkHabits_NonDrinker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("drinkHabits_NonDrinker")));
		return element;
	}
	public  static WebElement drinkHabits_LightOrSocialDrinker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("drinkHabits_LightOrSocialDrinker")));
		return element;
	}
	public  static WebElement drinkHabits_RegularDrinker(){
		WebElement element=driver.findElement(By.id(properties.getProperty("drinkHabits_RegularDrinker")));
		return element;
	}
	public  static WebElement drinkHabits_DoesNotMatter(){
		WebElement element=driver.findElement(By.id(properties.getProperty("drinkHabits_DoesNotMatter")));
		return element;
	}
	
	//***** PARTNER DESCRIPTION******
	public  static WebElement partnerDescription(){
		WebElement element=driver.findElement(By.id(properties.getProperty("partnerDescription")));
		return element;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Home.properties"));
    	properties.load(fis);
	}
	
	//**** SAVE BUTTON
	public  static WebElement saveButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("saveButton")));
		return element;
	}
	
	//***********SUCCESS MESSAGE**********
	public  static WebElement successMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("successMsg")));
		return element;
	}
	
	
}
