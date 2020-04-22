package com.cm.testscripts;

public class RegularSearchTest {
	/*	@Test
	public static void regularSearchTest() throws Throwable{
		test=extent.createTest("Regular Search Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups1();
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.searchLink()).perform();
		HomePage.regularSearch().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked Regular search");
		Select st=new Select(MarkAsViewedPage.ageFrom());
		List<WebElement> options=st.getOptions();
		test.pass("Minimum Age: "+options.get(1).getText());
		test.pass("Maximum Age: "+options.get(options.size()-1).getText());
    	st.selectByIndex(6);
    	String fAge=options.get(6).getText();
    	test.pass("Selected From Age: "+fAge);
    	Select st1=new Select(MarkAsViewedPage.ageTo());
		List<WebElement> options1=st1.getOptions();
    	st1.selectByIndex(18);
    	String tAge=options1.get(18).getText();
    	test.pass("Selected To Age: "+tAge);
    	Select st2=new Select(MarkAsViewedPage.heightFrom());
		List<WebElement> options2=st2.getOptions();
		test.pass("Minimum Height: "+options2.get(1).getText());
		test.pass("Maximum Height: "+options2.get(options2.size()-1).getText());
    	st2.selectByIndex(12);
    	String fHeight=options2.get(12).getText();
    	test.pass("Selected From Height: "+fHeight);
    	Select st3=new Select(MarkAsViewedPage.heightTo());
		List<WebElement> options3=st3.getOptions();
    	st3.selectByIndex(options3.size()-19);
    	String tHeight=options3.get(options3.size()-19).getText();
    	test.pass("Selected To height: "+tHeight);
    	//if(!MarkAsViewedPage.unmarried().isSelected()){
    		//MarkAsViewedPage.unmarried().click();
    //	}
    //	test.pass("Marital status: "+MarkAsViewedPage.unmarried().getText());
    	String s=MarkAsViewedPage.casteOrDivision().getText();
    	test.pass(s);
        act.doubleClick(MarkAsViewedPage.casteOrDivision()).build().perform();
		
	}*/

}
