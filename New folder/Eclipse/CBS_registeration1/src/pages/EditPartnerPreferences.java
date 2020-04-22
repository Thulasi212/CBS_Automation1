package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
public class EditPartnerPreferences {
	
	//*****LOGOUT MENU******
	@FindBy(xpath="//span[@class='menu-arrow-off']")
	private WebElement logoutMenu;
	public void logoutMenu(){ logoutMenu.click();}
	
	@FindBy(linkText="Edit Partner Preference")
	private WebElement edit_PP;
	public void edit_PP(){ edit_PP.click(); }

	
	//*****MARITAL STATUS*****
	@FindBys({@FindBy(xpath="//input[@type='checkbox' and @name='lookingStatus[]']")})
	private List<WebElement> mStatus_AllCheckBoxes;
	public List<WebElement> mStatus_AllCheckBoxes(){return mStatus_AllCheckBoxes;}
	

	@FindBy(xpath=".//*[@id='lookingMaritalStatus']/label[1]")
	private WebElement mStatus_Unmarried;
	public  WebElement mStatus_Unmarried(){return mStatus_Unmarried;}
	
	@FindBy(xpath=".//*[@id='lookingMaritalStatus']/label[2]")
	private WebElement mStatus_WidowOrWidower;
	public  WebElement mStatus_WidowOrWidower(){return mStatus_WidowOrWidower;}
	
	@FindBy(xpath=".//*[@id='lookingMaritalStatus']/label[3]")
	private WebElement mStatus_Divorced;
	public  WebElement mStatus_Divorced(){ return mStatus_Divorced;}
	
	@FindBy(xpath=".//*[@id='lookingMaritalStatus']/label[5]")
	private WebElement mStatus_Separated;
	public  void mStatus_Separated(){  mStatus_Separated.click();}
	
	@FindBy(xpath="//input[@id='lookingStatus0']/following-sibling::label")
	private WebElement mStatus_DoesNotMatter;
	public WebElement mStatus_DoesNotMatter(){  return mStatus_DoesNotMatter;}
	
	//*****HAVE CHILDREN******
	@FindBy(id="partnerHavechild0")
	private WebElement child_DoesNotMatter;
	public WebElement child_DoesNotMatter(){return child_DoesNotMatter;}
	
	@FindBy(id="partnerHavechild2")
	private WebElement child_YesLivingToGether;
	public WebElement child_YesLivingToGether(){ return child_YesLivingToGether;}
	
	@FindBy(id="partnerHavechild3")
	private WebElement child_YesNotLivingToGether;
	public WebElement child_YesNotLivingToGether(){ return child_YesNotLivingToGether;}
	
	@FindBy(id="partnerHavechild1")
	private WebElement child_No;
	public WebElement child_No(){return  child_No;}
	
	//*****AGE***********
	@FindBy(id="select2-fage-container")
	private WebElement age_From;
	public WebElement age_From() {return age_From;}
    
	@FindBy(id="select2-tage-container")
	private WebElement age_To;
	public WebElement age_To() {return age_To;}
	//*****HIGHT*********
	//*****PHYSICAL sTATUS***
	@FindBy(id="physicalStatus2")
	private WebElement pStatus_DoesNotMatter;
	public WebElement pStatus_DoesNotMatter(){  return pStatus_DoesNotMatter;}
	
	@FindBy(id="physicalStatus0")
	private WebElement pStatus_Normal;
	public WebElement pStatus_Normal(){  return pStatus_Normal;}
	
	@FindBy(id="physicalStatus1")
	private WebElement pStatus_PChallenged;
	public WebElement pStatus_PChallenged(){  return pStatus_PChallenged;}
	
	//******MOTHER TONGUE********
	@FindBy(xpath="//select[@id='motherTongue']/following-sibling::span/span[1]/span/ul/li/span")
	private WebElement motherTongue_ChoiceRemove;
	public WebElement motherTongue_ChoiceRemove(){
		return motherTongue_ChoiceRemove;
	}
	@FindBy(xpath="//select[@id='motherTongue']/following-sibling::span/span[1]/span/ul")
	private WebElement motherTongue;
	public WebElement motherTongue() {return motherTongue;}
	
	//*******Caste/Division**********
	@FindBy(xpath="//select[@id='casteDivision']/following-sibling::span/span[1]/span/ul")
	private WebElement casteOrDivision;
	public WebElement casteOrDivision(){return casteOrDivision;}
	
	//*******SUBCASTE***************
	@FindBy(xpath="//select[@id='subCaste']/following-sibling::span/span[1]/span/ul")
	private WebElement subCaste;
	public WebElement subCaste(){return subCaste;}
	
	//*******STAR***************
	@FindBy(xpath="//select[@id='star']/following-sibling::span/span[1]/span/ul")
	private WebElement star;
	public WebElement star(){return star;}
	
	//********GOTHRA***********
	@FindBy(xpath="//select[@id='gothram']/following-sibling::span/span[1]/span/ul")
	private WebElement gothra;
	public WebElement gothra(){return gothra;}
	
	//************MANGLILK**********
	@FindBy(id="manglik3")
	private WebElement manglik_DoesNotMatter;
	public WebElement manglik_DoesNotMatter(){  return  manglik_DoesNotMatter;}
	
	@FindBy(id="manglik1")
	private WebElement manglik_Yes;
	public WebElement manglik_Yes(){  return  manglik_Yes;}
	
	@FindBy(id="manglik2")
	private WebElement manglik_No;
	public WebElement manglik_No(){  return  manglik_No;}
	
	
	//*****EDUCATION***************
	
	@FindBy(id="educationTempradio1")
	private WebElement edu_Any;
	public WebElement edu_Any(){  return  edu_Any;}
	
	@FindBy(id="educationTempradio2")
	private WebElement edu_AnyDegree;
	public WebElement edu_AnyDegree(){  return  edu_AnyDegree;}
	
	@FindBy(id="educationTempradio3")
	private WebElement edu_ProfDegree;
	public WebElement edu_ProfDegree(){  return  edu_ProfDegree;}
	
	@FindBy(id="educationTempradio4")
	private WebElement edu_SpecificDegree;
	public WebElement edu_SpecificDegree(){  return  edu_SpecificDegree;}
	
	//***********OCCUPATION*************
	@FindBy(xpath="//select[@id='occupation']/following-sibling::span/span[1]/span/ul")
	private WebElement occupation;
	public WebElement occupation(){ return occupation;}
	
	//*************CITIZENSHIP************
	@FindBy(xpath="//select[@id='citizenship']/following-sibling::span/span[1]/span/ul")
	private WebElement citizenship;
	public WebElement citizenship(){return citizenship;}
	
	//**************Country Living In ********
	@FindBy(xpath="//select[@id='countryLivingIn']/following-sibling::span/span[1]/span/ul")
	private WebElement countryLivingIn;
	public WebElement countryLivingIn(){return countryLivingIn;}
	//*****FOOD HABITS*************
	@FindBy(id="eatingHabits1")
	private WebElement food_Vegetarian;
	public WebElement food_Vegetarian(){  return  food_Vegetarian;}
	
	@FindBy(id="eatingHabits2")
	private WebElement food_NonVegetarian;
	public WebElement food_NonVegetarian(){  return  food_NonVegetarian;}
	
	@FindBy(id="eatingHabits3")
	private WebElement food_Eggetarian;
	public WebElement food_Eggetarian(){  return  food_Eggetarian;}
	
	@FindBy(id="eatingHabits4")
	private WebElement food_Vegen;
	public WebElement food_Vegen(){  return  food_Vegen;}
	
	@FindBy(id="eatingHabits0")
	private WebElement food_DoesNotMatter;
	public WebElement food_DoesNotMatter(){  return food_DoesNotMatter;}
	
	//******SMOKING HABITS******
	
	@FindBy(id="smokingHabits1")
	private WebElement smokeHabits_NonSmoker;
	public WebElement smokeHabits_NonSmoker(){  return smokeHabits_NonSmoker;}
	
	@FindBy(id="smokingHabits2")
	private WebElement smokeHabits_LightOrSocialSmoker;
	public WebElement smokeHabits_LightOrSocialSmoker(){  return smokeHabits_LightOrSocialSmoker;}
	
	@FindBy(id="smokingHabits3")
	private WebElement smokeHabits_RegularSmoker;
	public WebElement smokeHabits_RegularSmoker(){  return smokeHabits_RegularSmoker;}
	
	@FindBy(id="smokingHabits0")
	private WebElement smokeHabits_DoesNotMatter;
	public WebElement smokeHabits_DoesNotMatter(){  return smokeHabits_DoesNotMatter;}
	
	//*****Drinking Habits*****
	
	@FindBy(id="drinkingHabits1")
	private WebElement drinkHabits_NonDrinker;
	public WebElement drinkHabits_NonDrinker(){  return drinkHabits_NonDrinker;}
	
	@FindBy(id="drinkingHabits2")
	private WebElement drinkHabits_LightOrSocialDrinker;
	public WebElement drinkHabits_LightOrSocialDrinker(){  return drinkHabits_LightOrSocialDrinker;}
	
	@FindBy(id="drinkingHabits3")
	private WebElement drinkHabits_RegularDrinker;
	public WebElement drinkHabits_RegularDrinker(){  return drinkHabits_RegularDrinker;}
	
	@FindBy(id="drinkingHabits0")
	private WebElement drinkHabits_DoesNotMatter;
	public WebElement drinkHabits_DoesNotMatter(){  return drinkHabits_DoesNotMatter;}
	
	//***** ANUAL INCOME*************
	
	//***** PARTNER DESCRIPTION******
	@FindBy(id="partnerDescription")
	private WebElement partnerDescription;
	public WebElement partnerDescription(){  return partnerDescription;}
	
	//**** SAVE BUTTON
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	private WebElement saveButton;
	public WebElement saveButton(){  return saveButton;}
	
	//***********SUCCESS MESSAGE**********
	@FindBy(xpath=".//*[@id='sucessGMsg']")
	private WebElement successMsg;
	public WebElement successMsg(){ return successMsg;}
	
}

