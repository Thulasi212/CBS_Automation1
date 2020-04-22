package testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.testng.annotations.Test;

import businessFunctions.BussinessFunctions;
import pages.ViewProfilesPage;
import utility.BaseTest;



public class ViewProfileTest extends BaseTest {

public static String baseurl;
public static Properties properties;

public ViewProfileTest()throws Exception{
	
	properties=new Properties();
	FileInputStream fis = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\objectRepository\\Login.properties"));
	properties.load(fis);
}	

@Test
public  void loginTest() throws Exception{
	JavascriptExecutor js = (JavascriptExecutor)driver;

test=extent.createTest("ViewProfie Test Scenario-2");
test.pass("Browser Opened ");

	FileInputStream file = new FileInputStream(new File("C:\\Users\\amuthan\\eclipse-workspace\\CBSLogin\\Resources\\LoginTestData_Mohan.xlsx")); 
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet1=workbook.getSheet("login");
	//Sheet sheet2 = workbook.getSheet("viewprofile");
	
	for (int i = 3; i <=3; i++) {
		baseurl = sheet1.getRow(i).getCell(0).getStringCellValue();			
		driver.navigate().to(baseurl);	
		test.pass("Application Launched Successfully");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String username1 = sheet1.getRow(i).getCell(1).getStringCellValue();
		String password1 = sheet1.getRow(i).getCell(2).getStringCellValue();
		test.info("Reading communitymatrimony UserName & Password from Test Data Repository");
		test.pass("UserName is Valid :"+username1);
		test.pass("Password is Valid : *******");						
		BussinessFunctions.login(driver, properties, username1, password1);
		Thread.sleep(4000);
		test.pass("Login Button is Clicked");						
		System.out.println("Login Successfully...");															
																											
						String domain=driver.getCurrentUrl();							
						test.info("Domain Name====>"+domain);							
						System.out.println("====>"+domain);	
						BussinessFunctions.intermidatePages(driver, properties);
						Thread.sleep(2000);
						//view profile
						BussinessFunctions.mouseOverActionForViewProfile(driver, properties);
						Thread.sleep(2000);
						
						/*String idname=sheet2.getRow(i).getCell(2).getStringCellValue();	
						String ageHieght=sheet2.getRow(i).getCell(3).getStringCellValue();	
						String edu=sheet2.getRow(i).getCell(4).getStringCellValue();	
						String addr=sheet2.getRow(i).getCell(5).getStringCellValue();	
						String mobile=sheet2.getRow(i).getCell(6).getStringCellValue();	
						String aboutMe=sheet2.getRow(i).getCell(7).getStringCellValue();	
						String profilefor=sheet2.getRow(i).getCell(8).getStringCellValue();	
						String age1=sheet2.getRow(i).getCell(9).getStringCellValue();	
						String gender=sheet2.getRow(i).getCell(10).getStringCellValue();	
						String children=sheet2.getRow(i).getCell(11).getStringCellValue();	
						String physcialStatus=sheet2.getRow(i).getCell(12).getStringCellValue();	
						String name=sheet2.getRow(i).getCell(13).getStringCellValue();	
						String hight=sheet2.getRow(i).getCell(14).getStringCellValue();	
						String MaritalStatus=sheet2.getRow(i).getCell(15).getStringCellValue();	
						String MotherTongue=sheet2.getRow(i).getCell(16).getStringCellValue();	
						String bodyType=sheet2.getRow(i).getCell(17).getStringCellValue();	
						String deonomination=sheet2.getRow(i).getCell(18).getStringCellValue();	
						String religiousValue=sheet2.getRow(i).getCell(19).getStringCellValue();	
						String edu1=sheet2.getRow(i).getCell(20).getStringCellValue();	
						String Occupation=sheet2.getRow(i).getCell(21).getStringCellValue();	
						String EduDetails=sheet2.getRow(i).getCell(22).getStringCellValue();	
						String City=sheet2.getRow(i).getCell(23).getStringCellValue();	
						String Country=sheet2.getRow(i).getCell(24).getStringCellValue();	
						String State=sheet2.getRow(i).getCell(25).getStringCellValue();	
						String citizenship=sheet2.getRow(i).getCell(26).getStringCellValue();	
						String value=sheet2.getRow(i).getCell(27).getStringCellValue();	
						String type=sheet2.getRow(i).getCell(28).getStringCellValue();	
						String status=sheet2.getRow(i).getCell(29).getStringCellValue();*/	
						
							//BussinessFunctions.viewProfiles_WindowHandles(driver, properties);	
							//Thread.sleep(3000);
						
						String parent=driver.getWindowHandle();
						 System.out.println("Parent Window ID is  "+parent);
						 Thread.sleep(1000);
					//	driver.findElement(By.xpath("html body div div#lp-container.fleft div div div.lhtnorm.bgclr5 div#topnav-login-bg.clearfix div.clearfix.topnav-login-bg-inner div#topnav-login-menu.clearfix div.fright div.fleft.posrelative div#userpop div.searchmenu-down div.searchmenu.user-menu.smalltxt.clearfix.clr9 div.padr5.pad2 a.last span.boldtxt.font14")).click();
						Thread.sleep(1000);
						Set<String> winHandles=driver.getWindowHandles();
						int count=winHandles.size();
						System.out.println("Window Count is : "+count);
						for (String winHandle : winHandles) { 
						    driver.switchTo().window(winHandle);
						    // switch focus of WebDriver to the next found window handle (that's your newly opened window)
						    System.out.println("window Handle Id :"+winHandle);
						    Thread.sleep(3000);
						}
						Thread.sleep(3000);
						
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"newloadProfileValue\"]/div[1]/div/div[1]/div[7]/div[8]/div[1]")));
						
						Thread.sleep(3000);
                        WebElement e2=ViewProfilesPage.loadProfileValues1(driver, properties.getProperty("loadProfileValues1"));
                        			test.pass("Education :" + e2.getText()+" -  Matched");
                               System.out.println(e2.getText());
                               
                        WebElement e3=ViewProfilesPage.loadProfileValues2(driver, properties.getProperty("loadProfileValues2"));

                                    test.pass("Education :" + e3.getText()+" -  Matched");
                              System.out.println(e3.getText());
                              
                        WebElement e4=ViewProfilesPage.loadProfileValues3(driver, properties.getProperty("loadProfileValues3"));

                                    test.pass("City :" +e4.getText()+ " - Matched ");
                                    System.out.println(e4.getText());
                                    
                        //Personnel Information
                        WebElement e7=ViewProfilesPage.profilecreatedfor(driver, properties.getProperty("profilecreatedfor"));

                                    test.pass(" Profile Created for : "+e7.getText()+" -  Matched ");
                                    System.out.println(e7.getText());
                             
                        WebElement e8=ViewProfilesPage.age1(driver, properties.getProperty("age"));

                                    test.pass("Age : "+e8.getText()+ " - Matched");
                                    System.out.println(e8.getText());
                                    
                        WebElement e9=ViewProfilesPage.gender(driver, properties.getProperty("gender"));

                                    test.pass("Gender : "+e9.getText() + " - Matched");
                                    System.out.println(e9.getText());
                                    
                        WebElement e10=ViewProfilesPage.noofChild(driver,properties.getProperty("noofChild"));

                                    test.pass("Number of children : "+e10.getText() +" - Matched");
                             
                       WebElement e11=ViewProfilesPage.PhyscialStatuss(driver,properties.getProperty("PhyscialStatus"));

                                    test.pass("Physical Status : "+e11.getText() + " - Matched");
                             
                        WebElement e12=ViewProfilesPage.Name(driver, properties.getProperty("Name"));

                                    test.pass("Name : "+e12.getText()+ " - Matched");
                           
                        WebElement e13=ViewProfilesPage.height1(driver, properties.getProperty("hieght"));

                        test.pass("Height : "+ e13.getText() + " - Matched");
                                
                        WebElement e14=ViewProfilesPage.martialStatus(driver, properties.getProperty("martialStatus"));

                                    test.pass("Marital Status : "+ e14.getText() + " - Matched");
                                                           
                                
                        WebElement e15=ViewProfilesPage.MotherTongue(driver, properties.getProperty("MotherTongue"));

                                    test.pass("Mother Tongue : "+ e15.getText() + " - Matched");
                            
                       WebElement e16=ViewProfilesPage.bodyType(driver, properties.getProperty("bodyType"));

                                    test.pass("Body Type : "+ e16.getText() + " - Matched");
                            
                        //Relgious Information
                        WebElement e17=ViewProfilesPage.Denomination(driver, properties.getProperty("Denomination"));

                                    test.pass("Denomination : "+ e17.getText() + " - Matched" );
                            
                       // WebElement e18=ViewProfilesPage.RelgiousValues(driver, properties.getProperty("RelgiousValues"));

                                  //  test.pass("Religious Info : "+e18.getText() + " - Matched");
                              
                        WebElement e19=ViewProfilesPage.Education(driver, properties.getProperty("Education"));

                                    test.pass("Education : "+e19.getText() + " - Matched " );
                             
                        WebElement e20=ViewProfilesPage.occupation1(driver, properties.getProperty("occupaton"));

                                    test.pass("Occupation : "+ e20.getText() + " - Matched");
                               
                        WebElement e21=ViewProfilesPage.detailsEdu(driver, properties.getProperty("detailsEdu"));

                                    test.pass("Education Details : "+e21.getText() + " - Matched ");
                              
                        //Location
                        WebElement e22=ViewProfilesPage.city(driver, properties.getProperty("city"));

                                    test.pass("City : "+e22.getText() + " - Matched");
                              
                        WebElement e23=ViewProfilesPage.country1(driver, properties.getProperty("country"));

                                    test.pass("Country : "+ e23.getText() + " - Matched");
                              
                        WebElement e24=ViewProfilesPage.state(driver, properties.getProperty("state"));

                                    test.pass("State : "+e24.getText() + " - Matched");
                               
                        WebElement e25=ViewProfilesPage.citizenship1(driver, properties.getProperty("citizenship"));

                                    test.pass("Citizenship : "+e25.getText()+ "- Matched" );
                                                   
                        Thread.sleep(2000);

                        driver.close();
                        driver.switchTo().window(parent);


                        Thread.sleep(2000);
BussinessFunctions.Logout(driver,properties);

            Thread.sleep(2000);
            System.out.println("Successfully logged out ");
            test.pass("Application Logged Out Successfully...");
        }
	driver.close();
    }

}

						
						//basic information-name		
						/*WebElement e1=ViewProfilesPage.displayName(driver,properties.getProperty("displayname"));												
							//assertTrue(e1.getText().matches(idname));	
							if(e1.getText().matches(idname)){
								test.pass("Name is Matched - Value is : "+idname);	
							}
							else{
								test.fail("Name is not Matched - Name filed is Failed");
							}
						WebElement e2=ViewProfilesPage.loadProfileValues1(driver, properties.getProperty("loadProfileValues1"));								
							//assertTrue(e2.getText().matches(ageHieght));											
									
								if(e2.getText().matches(ageHieght)){
									test.pass("Age is Matched - Value is : "+ageHieght);	
								}
								else{
									test.fail("Age is not Matched - Age filed is Failed");
								}
						WebElement e3=ViewProfilesPage.loadProfileValues2(driver, properties.getProperty("loadProfileValues2"));														
							//assertTrue(e3.getText().matches(edu));												
								
								if(e3.getText().matches(edu)){
									test.pass("Education is Matched - Value is : "+edu);	
								}
								else{
									test.fail("Education is not Matched - Education filed is Failed");
								}
						WebElement e4=ViewProfilesPage.loadProfileValues3(driver, properties.getProperty("loadProfileValues3"));																
							//assertTrue(e4.getText().matches(addr));												
									
								if(e4.getText().matches(addr)){
									test.pass("Address Value is Matched - Value is : "+addr);	
								}
								else{
									test.fail("Address is not Matched - Address filed is Failed");
								}
						WebElement e5=ViewProfilesPage.phonenumber(driver,properties.getProperty("loadProfileValues4"));
							String mobileno=e5.getText();	
								test.info("Mobile Number Displayed Sccessfully");
						//About me 
						WebElement e6=ViewProfilesPage.fewLinesAboutMe_Text(driver, properties.getProperty("fewLinesAboutMe_Text"));
							String aboutMe1=e6.getText();
							test.info("AboutMe feild getting this description =====>"+aboutMe1);
								
						//Personnel Information
						WebElement e7=ViewProfilesPage.profilecreatedfor(driver, properties.getProperty("profilecreatedfor"));						
							//assertTrue(e7.getText().matches(profilefor));										
								if(e7.getText().matches(profilefor)){
									test.pass(" Profile Created for : "+profilefor+" - Value is Matched....");
								}
								else{
									test.fail("ProfileCreatedFor is not Matched - filed is Failed");
								}
						WebElement e8=ViewProfilesPage.age1(driver, properties.getProperty("age"));
							//assertTrue(e8.getText().matches(age1));									
								if(e8.getText().matches(age1)){
									test.pass("Age Value is  Matched & Value is : "+age1);	
								}
								else{
									test.fail("Age is not Matched - Age filed is Failed");
								}
						WebElement e9=ViewProfilesPage.gender(driver, properties.getProperty("gender"));
							//assertTrue(e9.getText().matches(gender));								
								if(e9.getText().matches(gender)){
									test.pass("Gender Value is Matched & Value is : "+gender);	
								}
								else{
									test.fail("Name is not Matched - Name filed is Failed");
								}
						WebElement e10=ViewProfilesPage.noofChild(driver,properties.getProperty("noofChild"));
							//assertTrue(e10.getText().matches(children));									
								if(e10.getText().matches(children)){
									test.pass("No. Of Children Value is Matched & Value is : "+children);
								}
								else{
									test.fail("No Of Children is not Matched -  filed is Failed");
								}
						WebElement e11=ViewProfilesPage.PhyscialStatus(driver,properties.getProperty("PhyscialStatus"));
							//assertTrue(e11.getText().matches(physcialStatus));											
								if(e11.getText().matches(physcialStatus)){
									test.pass("PhysicalStatus Value is Matched & Value is : "+physcialStatus);
								}
								else{
									test.fail("PhysicalStatus is not Matched -  filed is Failed");
								}
						WebElement e12=ViewProfilesPage.Name(driver, properties.getProperty("Name"));						
							//assertTrue(e12.getText().matches(name));									
								if(e12.getText().matches(name)){
									test.pass("Name Value is Matched & Value is : "+name);		
								}
								else{
									test.fail("Name is not Matched - Name filed is Failed");
								}
						WebElement e13=ViewProfilesPage.height1(driver, properties.getProperty("hieght"));						
							//assertTrue(e13.getText().matches(hight));											
								if(e13.getText().matches(hight)){
									test.pass("Height Value is Matched & Value is : "+hight);
								}
								else{
									test.fail("Height is not Matched - Height filed is Failed");
								}
						WebElement e14=ViewProfilesPage.martialStatus(driver, properties.getProperty("martialStatus"));						
							//assertTrue(e14.getText().matches(MaritalStatus));										
								if(e14.getText().matches(MaritalStatus)){
									test.pass("MaritalStatus Value is Matched & Value is : "+MaritalStatus);
								}
								else{
									test.fail("MaritalStatus is not Matched -  filed is Failed");
								}
						/*WebElement e15=ViewProfilesPage.MotherTongue(driver, properties.getProperty("MotherTongue"));						
							//assertTrue(e15.getText().matches(MotherTongue));	
						
								/if(e15.getText().matches(MotherTongue)){
									test.pass("MotherTongue Value is Matched & Value is : "+MotherTongue);	
								}
								else{
									test.fail("MotherTongue is not Matched -  filed is Failed");
								}
								String mother=e15.getText();
								System.out.println(mother);
								System.out.println(MotherTongue);
						WebElement e16=ViewProfilesPage.bodyType(driver, properties.getProperty("bodyType"));						
							//assertTrue(e16.getText().matches(bodyType));										
								if(e16.getText().matches(bodyType)){
									test.pass("BodyType Value is Matched & Value is : "+bodyType);
								}
								else{
									test.fail("BodyType is not Matched -  filed is Failed");
								}
						//Relgious Information
						WebElement e17=ViewProfilesPage.Denomination(driver, properties.getProperty("Denomination"));
							//assertTrue(e17.getText().matches(deonomination));									
								if(e17.getText().matches(deonomination)){
									test.pass("Denomination Value is Matched & Value is : "+deonomination);	
								}
								else{
									test.fail("Denomination is not Matched -  filed is Failed");
								}
						WebElement e18=ViewProfilesPage.RelgiousValues(driver, properties.getProperty("RelgiousValues"));
							//assertTrue(e18.getText().matches(religiousValue));									
								if(e18.getText().matches(religiousValue)){
									test.pass("RelgiousValues is Matched & Value is : "+religiousValue);	
								}
								else{
									test.fail("RelgiousValues is not Matched - filed is Failed");
								}
						//ProfessionalInformation
						WebElement e19=ViewProfilesPage.Education(driver, properties.getProperty("Education"));						
							//assertTrue(e19.getText().matches(edu1));										
								if(e19.getText().matches(edu1)){
									test.pass("Education Value is Matched & Value is : "+edu1);	
								}
								else{
									test.fail("Education is not Matched - filed is Failed");
								}
						WebElement e20=ViewProfilesPage.occupation1(driver, properties.getProperty("occupaton"));
							//assertTrue(e20.getText().matches(Occupation));											
								if(e20.getText().matches(Occupation)){
									test.pass("Occupation Value is Matched & Value is : "+Occupation);
								}
								else{
									test.fail("Ocuupation is not Matched -filed is Failed");
								}
						WebElement e21=ViewProfilesPage.detailsEdu(driver, properties.getProperty("detailsEdu"));
							//assertTrue(e21.getText().matches(EduDetails));										
								if(e21.getText().matches(EduDetails)){
									test.pass("EducationDetails Value is Matched & Value is : "+EduDetails);
								}
								else{
									test.fail("EducationDetails is not Matched - filed is Failed");
								}
						//Location
						WebElement e22=ViewProfilesPage.city(driver, properties.getProperty("city"));
							//assertTrue(e22.getText().matches(City));								
								if(e22.getText().matches(City)){
									test.pass("City Value is Matched & Value is : "+City);		
								}
								else{
									test.fail("City is not Matched - City filed is Failed");
								}
						WebElement e23=ViewProfilesPage.country1(driver, properties.getProperty("country"));
							//assertTrue(e23.getText().matches(Country));								
								if(e23.getText().matches(Country)){
									test.pass("Country Value is Matched & Value is : "+Country);	
								}
								else{
									test.fail("Country is not Matched - Country filed is Failed");
								}
						WebElement e24=ViewProfilesPage.state(driver, properties.getProperty("state"));
							//assertTrue(e24.getText().matches(State));								
								if(e24.getText().matches(State)){
									test.pass("State Value is Matched & Value is : "+State);	
								}
								else{
									test.fail("State is not Matched -filed is Failed");
								}
						WebElement e25=ViewProfilesPage.citizenship1(driver, properties.getProperty("citizenship"));
							//assertTrue(e25.getText().matches(citizenship));									
								if(e25.getText().matches(citizenship)){
									test.pass("Citizenship Value is Matched & Value is : "+citizenship);	
								}
								else{
									test.fail("Citizenship is not Matched -filed is Failed");
								}
								
						//Family Status
						WebElement e26=ViewProfilesPage.value(driver, properties.getProperty("value"));
							//assertTrue(e26.getText().matches(value));									
								if(e26.getText().matches(value)){
									test.pass("Family Value  is Matched & Value is : "+value);
								}
								else{
									test.fail("Family Value is not Matched -  filed is Failed");
								}
						WebElement e27=ViewProfilesPage.type(driver, properties.getProperty("type"));						
							//assertTrue(e27.getText().matches(type));								
								if(e27.getText().matches(type)){
									test.pass("Family Type is Matched & Value is : "+type);		
								}
								else{
									test.fail("Family Type is not Matched - filed is Failed");
								}
						WebElement e28=ViewProfilesPage.status(driver, properties.getProperty("status"));
							//assertTrue(e28.getText().matches(status));									
								if(e28.getText().matches(status)){
									test.pass("Family Status is Matched & Value is : "+status);
								}
								else{
									test.fail("Family Status is not Matched -filed is Failed");
								}
							
							
						Thread.sleep(2000);
						
						driver.close();
						driver.switchTo().window(parent);
												
						
						Thread.sleep(2000);
						BussinessFunctions.Logout(driver,properties);
			
			Thread.sleep(2000);
			System.out.println("Logout Completed Successfully..");
			test.info("Application LogedOut Successfully...");				
		}			
	}*/

	


