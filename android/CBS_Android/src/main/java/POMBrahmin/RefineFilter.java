package POMBrahmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import Base1.BaseBrahmin;
import io.appium.java_client.android.AndroidDriver;

public class RefineFilter extends BaseBrahmin{
	
	public RefineFilter(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@text='LATEST MATCHES']")
	private WebElement latest_matches;
	
	@FindBy(xpath="//*[@text='MATCHES']")
	private WebElement matches;
	
	@FindBy(xpath="//*[@id='tv_filter_refine']")
	private WebElement refine_filter;
	//*[@text='FILTER & REFINE']
	
	@FindBy(xpath="//*[@id='tv_Reset']")
	private WebElement reset;

	@FindBy(xpath="//*[@text='More']")
	private WebElement more;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[1]")
	private WebElement age;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[2]")
	private WebElement height;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[3]")
	private WebElement marital_status;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[4]")
	private WebElement mother_tongue;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[5]")
	private WebElement subcaste;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[7]")
	private WebElement dosham;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[6]")
	private WebElement star;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[8]")
	private WebElement country;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0])[9]")
	private WebElement state;
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0])[10]")
	private WebElement city;
	
	
	@FindBy(xpath="//*[@id='txt_title' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[@text]]")
	private WebElement Education;
	
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[8]")
	private WebElement Occupation;
	
	
	@FindBy(xpath="(//*[@id='recy_filter']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[9]")
	private WebElement Annual_Income;
		
	
	@FindBy(xpath="//*[@id='btn_apply']")
	private WebElement Apply;
	
	@FindBy(xpath="(//*[@id='spinner_text'])[1]")
	private WebElement Age_Height_From_btn;
	
	
	@FindBy(xpath="(//*[@id='spinner_text'])[2]")
	private WebElement Age_Height_to_btn;
	
	
	@FindBy(xpath="//*[@id='tv_Reset']")
	private WebElement Age_Height_confirm_btn;
	
	
	@FindBy(xpath="//*[@text='Reset']")
	private WebElement marital_status_radio_btn;
	
	
	@FindBy(xpath="//*[@text='Any']")
	private WebElement marital_status_Any_btn;
	
	@FindBy(xpath="//*[@text='Unmarried']")
	private WebElement marital_status_Unmarried_btn;
	
	@FindBy(xpath="//*[@text='Widow / Widower']")
	private WebElement marital_status_widow_btn;
	
	@FindBy(xpath="//*[@text='Separated']")
	private WebElement marital_status_seperated_btn;
	
	@FindBy(xpath="//*[@text='Divorced']")
	private WebElement marital_status_Divorced_btn;
	
	
	@FindBy(xpath="//*[@id='search_editText']")
	private WebElement search_btn;
	
	
	@FindBy(xpath="(//*[@id='refine_listView']/*/*[@id='refine_adapter_checkBox'])[1]")
	private WebElement search_value_choose_btn;
	
	
	
	

	public WebElement getEducation() {
		return Education;
	}

	public WebElement getOccupation() {
		return Occupation;
	}

	public WebElement getAnnual_Income() {
		return Annual_Income;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getAge_Height_From_btn() {
		return Age_Height_From_btn;
	}

	public WebElement getAge_Height_to_btn() {
		return Age_Height_to_btn;
	}

	public WebElement getAge_Height_confirm_btn() {
		return Age_Height_confirm_btn;
	}

	public WebElement getMarital_status_radio_btn() {
		return marital_status_radio_btn;
	}

	public WebElement getMarital_status_Any_btn() {
		return marital_status_Any_btn;
	}

	public WebElement getMarital_status_Unmarried_btn() {
		return marital_status_Unmarried_btn;
	}

	public WebElement getMarital_status_widow_btn() {
		return marital_status_widow_btn;
	}

	public WebElement getMarital_status_seperated_btn() {
		return marital_status_seperated_btn;
	}

	public WebElement getMarital_status_Divorced_btn() {
		return marital_status_Divorced_btn;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}

	public WebElement getSearch_value_choose_btn() {
		return search_value_choose_btn;
	}

	public WebElement getLatest_matches() {
		return latest_matches;
	}

	public WebElement getMatches() {
		return matches;
	}

	public WebElement getRefine_filter() {
		return refine_filter;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getAge() {
		return age;
	}

	public WebElement getHeight() {
		return height;
	}

	public WebElement getMarital_status() {
		return marital_status;
	}

	public WebElement getMother_tongue() {
		return mother_tongue;
	}

	public WebElement getSubcaste() {
		return subcaste;
	}

	public WebElement getDosham() {
		return dosham;
	}

	public WebElement getStar() {
		return star;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getApply() {
		return Apply;
	}
	
	
	
	
}
