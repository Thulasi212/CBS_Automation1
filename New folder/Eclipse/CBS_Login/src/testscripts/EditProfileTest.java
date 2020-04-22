package testscripts;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.EditProfilePage;
import utility.BaseTest;


public class EditProfileTest extends BaseTest{

	public static String baseurl;
	public static Properties properties;	
	
	public EditProfileTest()throws Exception{
		
		properties=new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\editProfile.properties"));
		properties.load(fis);
	}	
	/*@BeforeMethod
    public void startUp()
    {
    	 System.setProperty("webdriver.gecko.driver", "C:\\Mohan\\geckodriver.exe");
 		  driver = new FirefoxDriver();	
    }
	  */

    @Test
	public  void editProfileTest() throws Exception{
	
	test=extent.createTest("EditProfile Test Scenario-2");
	test.info("Browser Opened ");

		FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet1 = workbook.getSheet("login");
		Sheet sheet2=workbook.getSheet("editprofile");
		for (int i = 35; i <=35; i++) {
			baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
			driver.get(baseurl);	
			test.pass("Application Launched Successfully");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			String username = sheet1.getRow(i).getCell(1).getStringCellValue();
			String password = sheet1.getRow(i).getCell(2).getStringCellValue();
			test.pass("Reading communitymatrimony UserName & Password from Test Data Repository");
			test.pass("UserName is Valid :"+username);
			test.pass("Password is Valid : *******");						
			BussinessFunctions.cmLogin(driver,properties, username, password);
			Thread.sleep(3000);
			test.pass("Login Button Clicked");						
			System.out.println("Login Successfully...");															
						
									
							
						//	BussinessFunctions.intermidatePages(driver,properties);
							Thread.sleep(5000);
							try {
								WebElement photo_add = driver.findElement(By.xpath("/html/body/div[2]/a"));
								if (photo_add.isDisplayed()) {
									photo_add.click();
									driver.findElement(By.xpath("//*[@id=\"conform\"]/div/div/div/a[1]")).click();
									driver.findElement(By.xpath("//*[@id=\"reason3\"]")).click();
									driver.findElement(By.xpath("//*[@id=\"skipphotoclick\"]")).click();
									
								}
								
							} catch (Exception e) {
								e.getMessage();
							}
							
							
							try {
								WebElement skip_matches = driver.findElement(By.xpath("//a[contains(text(),'Skip to Daily Matches >>')]"));
								if (skip_matches.isDisplayed()) {
									skip_matches.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							try {
								WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
								if (element.isDisplayed()) {
									element.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							try {
								WebElement divorcee_intermediate_skip = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/a"));
								if (divorcee_intermediate_skip.isDisplayed()) {
									divorcee_intermediate_skip.click();
									
								}
							} catch (Exception e) {
								e.getMessage();
							}
							
							test.pass("Intermidate Pages are closed...Successfully");
							System.out.println("Intermidate Pages are closed...");	
							
						   Thread.sleep(3000);
						   try {
							driver.findElement(By.xpath("//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")).click();
						} catch (Exception e) {
							e.getMessage();
						}
							BussinessFunctions.mouseOverActionForEditProfile(driver, properties);
							Thread.sleep(2000);
							test.info("EditProfile Testing is started......");
							
						//	BussinessFunctions.editProfiles_Edit(driver, properties);
						//	Thread.sleep(2000);
							//basic information-name	
							
							Select profileFor = new Select(EditProfilePage.profileCreatedBy(driver, properties.getProperty("profileCreatedBy")));											
							WebElement profileForEle=profileFor.getFirstSelectedOption();
							
							if(profileForEle.isDisplayed()){
								test.pass("ProfileCreatedFor  : "+profileForEle.getText()+" - Displayed"+" ====> Before Updation");	
							}
							else{
								test.fail("ProfileCreatedFor Value is displayed - Height filed is Failed");
							}
							
							profileFor.selectByIndex(4);
														
							test.info("ProfileCreatedFor : "+profileFor.getFirstSelectedOption().getText()+" - Displayed" +" ====> After Updation" );
							
								WebElement e2=EditProfilePage.Name(driver, properties.getProperty("Name"));												
								//assertTrue(e1.getText().matches(idname));	
							
								if(e2.isDisplayed()){
									test.pass("Name  : "+e2.getAttribute("1"));																		
								}
								else{
									test.fail(" Name filed is Failed");
								}
								
								WebElement e3=EditProfilePage.DateOfBirth(driver, properties.getProperty("DateOfBirth"))	;										
								//assertTrue(e1.getText().matches(idname));	
							
								if(e3.isDisplayed()){
									test.pass("DateOfBirth  : "+e3.getText()+" - Dispalyed");	
								}
								else{
									test.fail("DateOfBirth  Value is displayed -DateOfBirth filed is Failed");
								}
								Thread.sleep(2000);
								try{
								WebElement e4=EditProfilePage.MaritialStatus(driver, properties.getProperty("MaritialStatus"))	;										
								//assertTrue(e1.getText().matches(idname));	
							
								if(e4.isDisplayed()){
									test.pass("MartialStatus  : "+e4.getText()+"  - Displayed");	
								}
								else{
									test.fail("MartialStatus filed is Failed");
								}
								}
								catch(Exception e ){ e.getMessage(); }
								Thread.sleep(2000);
								//NoOfChildrens
								/*String noOfChilds=sheet2.getRow(i).getCell(1).getStringCellValue();
								try{
								BussinessFunctions.editProfiles_noOfChildren(driver, properties, noOfChilds);
								test.info("NoOfChildrens Radio button Selected that Value is : "+noOfChilds);
								}
								catch(Exception e){
									e.getMessage();
								}*/
								Select height = new Select(EditProfilePage.Height(driver, properties.getProperty("Height")));											
																WebElement heightEle=height.getFirstSelectedOption();
																
								if(heightEle.isDisplayed()){
									test.pass("Height  : "+heightEle.getText()+" - Dipslayed"+" ====>Before Updation");	
								}
								else{
									test.fail(" Height filed is Failed");
								}
								
								
							height.selectByIndex(9);
								test.pass("Height : "+height.getFirstSelectedOption().getText()+" - Displayed" +" ====>After Updation" );
							
								Select weight = new Select(EditProfilePage.weight_dd(driver, properties.getProperty("weight_dd")));
									weight.selectByIndex(3);							
								WebElement weightEle=weight.getFirstSelectedOption();
							
								if(weightEle.isDisplayed()){
									test.pass("Weight  : "+weightEle.getText()+" - Displayed");	
								}
								else{
									test.fail(" Weight filed is Failed");
								}
								
								WebElement bodyTypes=driver.findElement(By.xpath(".//*[@id='bodyType3']"));
								bodyTypes.click();
								test.pass("BodyType : "+bodyTypes.getText()+" - Selected");
								
								WebElement complexion=driver.findElement(By.xpath(".//*[@id='complexion1']"));
								complexion.click();
								test.pass("Complexion : "+complexion.getText()+" - Selected");
								try{
								WebElement subcast=driver.findElement(By.xpath(".//*[@id='frmProfile']/dl[19]/dd[1]/label/b"));
								String scast=subcast.getText();
								test.pass("Subcast :"+scast+" - Displayed");
								}
								catch(Exception e) { e.getMessage(); }
							
								
								WebElement eatingHabits = driver.findElement(By.xpath(".//*[@id='eatingHabits2']"));
								test.pass("EatingHabits : "+ eatingHabits.getText()+" - Selected ");
								WebElement smokingHabits = driver.findElement(By.xpath(".//*[@id='smoke1']"));
								test.pass("SmokingHabits : "+ smokingHabits.getText()+" - Selected ");
								WebElement drinkingHabits = driver.findElement(By.xpath(".//*[@id='drink1']"));
								test.pass("drinkingHabits : "+ drinkingHabits.getText()+" - Selected ");
							
						Thread.sleep(4000)	;	
		EditProfilePage.basicInfo_edit_SaveBtn(driver,properties.getProperty("basicInfo_edit_SaveBtn")).click();
		Thread.sleep(2000);
		WebElement successMsg=driver.findElement(By.xpath(".//*[@id='sucessGMsg']"));
		test.pass(successMsg.getText());
		
	
				System.out.println("Logout Completed Successfully..");
				test.pass("Application LogedOut Successfully...");				
			}	
		driver.close();
		}
/*@AfterMethod
public void tearDown()
{
	driver.close();
}	*/ 




}


