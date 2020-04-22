package com.cm.testscripts;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.PaymentPage;

public class PaymentTest extends BaseTest{
	public ExcelData eData;
	public PaymentTest() throws Throwable{
		LoginPage2.loadProperties();
		PaymentPage.loadProperties();
		HomePage.loadProperties();
		eData=new ExcelData();
	}
	@Test
	public void specialOffer_PaymentTest1() throws Throwable{
		test=extent.createTest("Payment Test through Popup Offer");
		boolean status=false;
		LoginPage2.login();
		try{
			WebdriverWaitLib.waitElementToPresent(LoginPage2.skipToDailyMatches_Popup());
			if(LoginPage2.skipTodailyMatches_takeControl().isDisplayed())
			{
				LoginPage2.skipToDailyMatches_Popup().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("Clicked on Daily Matches Close Button");
			}
		}catch(Exception e){e.getMessage();}
		try{
			WebdriverWaitLib.waitElementToPresent(LoginPage2.skipToDailyMatches_Popup());
			if(LoginPage2.skipDailyMatches_viewAll().isDisplayed())
			{
				LoginPage2.skipToDailyMatches_Popup().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("Clicked on Daily Matches Close Button");
			}
		}catch(Exception e){e.getMessage();}
		//***Skip To Daily Matches Page(Go Premium)
		try{
			WebdriverWaitLib.waitElementToPresent(LoginPage2.skipToDMatches_GoPremiumBtn());
			LoginPage2.skipToDMatches_GoPremiumBtn().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.pass("clicked on Go Premium in Daily Matches");
			status=true;
		}catch(Exception e){e.getMessage();}
		//***Skip To Daily Matches Page(Proceed)
		try{
			LoginPage2.skipToMyMatrimony_proceed().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.pass("clicked on Proceed in Daily Matches");
			status=true;
		}catch(Exception e){e.getMessage();}
		try{
			LoginPage2.skipToMyMatrimony_Popup().click();
			test.pass("SkipMyMatches Popup is closed successfully");	
			try{
				WebdriverWaitLib.waitElementToPresent(LoginPage2.strategic_Popup());
				LoginPage2.strategic_Popup().click();
				test.pass("Strategic Popup is closed");
				}catch(Exception e){e.getMessage();}
		}catch(Exception e){e.getMessage();}
		try{
			LoginPage2.skipToDailyMatches_Popup().click();
			test.pass("clicked on Skip To Daily Matches popup");
		}catch(Exception e){e.getMessage();}
		try{
			Thread.sleep(5000);
			LoginPage2.addPhoto().click();
			WebdriverWaitLib.waitElementToPresent(LoginPage2.areYousure_Popup());
			LoginPage2.areYousure_Popup().click();
			try{
				WebdriverWaitLib.waitElementToPresent(LoginPage2.reason3_Popup());
				LoginPage2.reason3_Popup().click();
				WebdriverWaitLib.waitElementToPresent(LoginPage2.submit_Popup());
				LoginPage2.submit_Popup().click();
			    }catch(Exception e){e.getMessage();}
	    }catch(Exception e){e.getMessage();}
		try{
			WebdriverWaitLib.waitElementToPresent(LoginPage2.offer_UpgradeBtn());
			Thread.sleep(5000);
			LoginPage2.offer_UpgradeBtn().click();
			status=true;
			test.pass("clicked on Upgrade button in Special offer Popup");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.info("Navigating to Payment Page....................");
			Set<String> set= driver.getWindowHandles();
			Iterator<String> it=set.iterator();
		    it.next();
			String paymentpage=it.next();
			driver.switchTo().window(paymentpage);
			test.pass("driver control is navigated to Payment page successfully");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e){e.getMessage();}
		try{
			LoginPage2.getItNow().click();
			test.pass("clicked on Get it Now");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.info("Navigating to Payment Page....................");
			Set<String> set= driver.getWindowHandles();
			Iterator<String> it=set.iterator();
		    it.next();
			String paymentpage=it.next();
			driver.switchTo().window(paymentpage);
			test.pass("driver control is navigated to Payment page successfully");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(9000);
			LoginPage2.getItNow_AvailNow().click();
					
		}catch(Exception e){e.getMessage();}
		if(status){
			String pckg=eData.getExcelData("Payment", 1, 0);
			System.out.println(pckg);
			if(pckg.equalsIgnoreCase("Gold3months")){
			    if(!PaymentPage.gold_3months().isSelected()){
			    	PaymentPage.gold_3months().click();
				    test.pass(" Gold 3months package is Selected");
			    }else{
			    	test.pass("Gold 3months package is Already Selected");
			    }   	
			 }else if(pckg.equalsIgnoreCase("Gold6months")){
			    if(!PaymentPage.gold_6months().isSelected()){
			    	PaymentPage.gold_6months().click();
				    test.pass(" Gold 6months Package is Selected");
			    }else{
			    	test.pass("Gold 6months Package is Already Selected");
			    }
			    	
			  } else if (pckg.equalsIgnoreCase("Diamond3months")){
			    	if(!PaymentPage.diamond_3months().isSelected()){
			    		PaymentPage.diamond_3months().click();
				    	test.pass("Diamond 3months package is selected");
			    	}else{
			    		test.pass("Diamond 3months package is Already selected");
			    	}
			    	
			    }else if(pckg.equalsIgnoreCase("Diamond6months")){
			    	if(!PaymentPage.diamond_6months().isSelected()){
			    		 PaymentPage.diamond_6months().click();
				    	 test.pass("Diamond 6months is SelectedPackage");
			    	}else{
			    		 test.pass("Diamond 6months is Already SelectedPackage");
			    	}
		    	   
		        } else if (pckg.equalsIgnoreCase("Platinum3months")){
		        	if(!PaymentPage.platinum_3months().isSelected()){
		        		PaymentPage.platinum_3months().click();
		 	    	    test.pass(" Platinum 3months package is Selected");
		        	}else{
		        		test.pass(" Platinum 3months package is Already Selected");
		        	}
		        }else if(pckg.equalsIgnoreCase("Platinum6months")){
		        	if(!PaymentPage.platinum_6months().isSelected()){
		        		PaymentPage.platinum_6months().click();
		     	        test.pass("platinum 6months Package is Selected");
		        	}else{
		        		test.pass("platinum 6months Package is Already Selected");
		        	}
	            } else{
	            	if(!PaymentPage.till_u_marry().isSelected()){
	            		PaymentPage.till_u_marry().click();
	             	   test.pass(" Tii_U_Marry package is Selected");
	                }else{
	                	test.pass(" Tii_U_Marry package is Already Selected");
	                }
	            }
		        if(!PaymentPage.profHighlighter().isSelected()){
		        	PaymentPage.profHighlighter().click();
		        	test.pass(" profile Highlighter is selected");
		        } 
		        if(!PaymentPage.topPlacement().isSelected()){
		        	PaymentPage.topPlacement().click();
		        	test.pass("Top Placement is selected");
		        } 
		        if(!PaymentPage.astroMatch().isSelected()){
		        	PaymentPage.astroMatch().click();
		        	test.pass(" AstroMatch is selected");
		        }
		        if(!PaymentPage.astromatchSpecial().isSelected()){
		        	PaymentPage.astromatchSpecial().click();
		        	test.pass(" AstroMatch  Special checkout is selected");
		        }
		        String totalAmount=PaymentPage.splTotalAmount().getText();
		        test.pass("Total Amount: "+totalAmount);
		        test.pass("Payment Started.....");
		        try{
		        	Thread.sleep(1000);
		        	String cardHolderName=eData.getExcelData("Payment", 1, 2);
		        	PaymentPage.cardHolderName().sendKeys(cardHolderName);
		        }catch(Exception e){e.getMessage();}
		        String cardNo=eData.getExcelData("Payment", 1, 1);
		        PaymentPage.creditCardNoEdit().sendKeys(cardNo);
		        new Select(PaymentPage.cardExpiryMonth()).selectByIndex(1);
		        String cExYear=eData.getExcelData("Payment", 1, 3);
		        new Select(PaymentPage.cardExpiryYear()).selectByVisibleText(cExYear);
		        String ccv=eData.getExcelData("Payment", 1, 4);
		        PaymentPage.ccvEdit().sendKeys(ccv);
		        PaymentPage.paySecure().click();
		        test.pass("Clicked on Pay Securely");
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        test.pass(PaymentPage.paymentFailureMsg().getText());
		        PaymentPage.goBackLink().click();
		        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		        String summaryAmount=PaymentPage.summaryAmount().getText();
		        test.pass("Summary Amount: "+summaryAmount);
		        test.pass("Validating Total Amount with Payment Failure Summary Amount.....");
		        Assert.assertEquals(totalAmount, summaryAmount);
		        test.pass("Payment failure Amount validated Successfully");
			}
			driver.close();
	}
	@Test
	public void specialOffer_PaymentTest2() throws Throwable{
		test=extent.createTest("Payment Test through Header Placement Offer");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(1000);
		HomePage.matchesLink().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean status=false;
		try{
			Thread.sleep(3000);
			PaymentPage.headerUpgradeBtn().click();
			status=true;
			test.pass("clicked on Upgrade button in Special offer Popup");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e){e.getMessage();}
		if(status){
			test.info("Navigating to Payment Page....................");
			Set<String> set= driver.getWindowHandles();
			Iterator<String> it=set.iterator();
		    it.next();
			String paymentpage=it.next();
			driver.switchTo().window(paymentpage);
			test.pass("driver control is navigated to Payment page successfully");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    String pckg=eData.getExcelData("Payment", 1, 0);
		    System.out.println(pckg);
		    if(pckg.equalsIgnoreCase("Gold3months")){
		    	if(!PaymentPage.gold_3months().isSelected()){
		    		PaymentPage.gold_3months().click();
			    	test.pass(" Gold 3months package is Selected");
		    	}else{
		    		test.pass("Gold 3months package is Already Selected");
		    	}
		    	
		    }else if(pckg.equalsIgnoreCase("Gold6months")){
		    	if(!PaymentPage.gold_6months().isSelected()){
		    		PaymentPage.gold_6months().click();
			    	test.pass(" Gold 6months Package is Selected");
		    	}else{
		    		test.pass("Gold 6months Package is Already Selected");
		    	}
		    	
		    } else if (pckg.equalsIgnoreCase("Diamond3months")){
		    	if(!PaymentPage.diamond_3months().isSelected()){
		    		PaymentPage.diamond_3months().click();
			    	test.pass("Diamond 3months package is selected");
		    	}else{
		    		test.pass("Diamond 3months package is Already selected");
		    	}
		    	
		    }else if(pckg.equalsIgnoreCase("Diamond6months")){
		    	if(!PaymentPage.diamond_6months().isSelected()){
		    		 PaymentPage.diamond_6months().click();
			    	 test.pass("Diamond 6months is SelectedPackage");
		    	}else{
		    		 test.pass("Diamond 6months is Already SelectedPackage");
		    	}
	    	   
	        } else if (pckg.equalsIgnoreCase("Platinum3months")){
	        	if(!PaymentPage.platinum_3months().isSelected()){
	        		PaymentPage.platinum_3months().click();
	 	    	    test.pass(" Platinum 3months package is Selected");
	        	}else{
	        		test.pass(" Platinum 3months package is Already Selected");
	        	}
	        }else if(pckg.equalsIgnoreCase("Platinum6months")){
	        	if(!PaymentPage.platinum_6months().isSelected()){
	        		PaymentPage.platinum_6months().click();
	     	        test.pass("platinum 6months Package is Selected");
	        	}else{
	        		test.pass("platinum 6months Package is Already Selected");
	        	}
            } else{
            	if(!PaymentPage.till_u_marry().isSelected()){
            		PaymentPage.till_u_marry().click();
             	   test.pass(" Tii_U_Marry package is Selected");
                }else{
                	test.pass(" Tii_U_Marry package is Already Selected");
                }
            }
	        if(!PaymentPage.profHighlighter().isSelected()){
	        	PaymentPage.profHighlighter().click();
	        	test.pass(" profile Highlighter is selected");
	        } 
	        if(!PaymentPage.topPlacement().isSelected()){
	        	PaymentPage.topPlacement().click();
	        	test.pass("Top Placement is selected");
	        } 
	        if(!PaymentPage.astroMatch().isSelected()){
	        	PaymentPage.astroMatch().click();
	        	test.pass(" AstroMatch is selected");
	        }
	        if(!PaymentPage.astromatchSpecial().isSelected()){
	        	PaymentPage.astromatchSpecial().click();
	        	test.pass(" AstroMatch  Special checkout is selected");
	        }
	        String totalAmount=PaymentPage.splTotalAmount().getText();
	        test.pass("Total Amount: "+totalAmount);
	        test.pass("Payment Started.....");
	        try{
	        	Thread.sleep(1000);
	        	String cardHolderName=eData.getExcelData("Payment", 1, 2);
	        	PaymentPage.cardHolderName().sendKeys(cardHolderName);
	        }catch(Exception e){e.getMessage();}
	        String cardNo=eData.getExcelData("Payment", 1, 1);
	        PaymentPage.creditCardNoEdit().sendKeys(cardNo);
	        new Select(PaymentPage.cardExpiryMonth()).selectByIndex(1);
	        String cExYear=eData.getExcelData("Payment", 1, 3);
	        new Select(PaymentPage.cardExpiryYear()).selectByVisibleText(cExYear);
	        String ccv=eData.getExcelData("Payment", 1, 4);
	        PaymentPage.ccvEdit().sendKeys(ccv);
	        PaymentPage.paySecure().click();
	        test.pass("Clicked on Pay Securely");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        test.pass(PaymentPage.paymentFailureMsg().getText());
	        PaymentPage.goBackLink().click();
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        String summaryAmount=PaymentPage.summaryAmount().getText();
	        test.pass("Summary Amount: "+summaryAmount);
	        test.pass("Validating Total Amount with Payment Failure Summary Amount.....");
	        Assert.assertEquals(totalAmount, summaryAmount);
	        test.pass("Payment failure Amount validated Successfully");
		}else{
			test.pass("Header placement offer is Not Available to Check Payment flow");
		}  
        driver.quit();
	}
	@Test
	public void specialOffer_PaymentTest3() throws Throwable{
		test=extent.createTest("Payment Test through chat Placement Offer");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		boolean status=false;
		try{
			PaymentPage.chat_PayOnlineLink().click();
			status=true;
			test.pass("clicked on Pay online link in Chat Palcement offer");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e){e.getMessage();}
		if(status){
			test.info("Navigating to Payment Page....................");
			Set<String> set= driver.getWindowHandles();
			Iterator<String> it=set.iterator();
		    it.next();
			String paymentpage=it.next();
			driver.switchTo().window(paymentpage);
			test.pass("driver control is navigated to Payment page successfully");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    String pckg=eData.getExcelData("Payment", 1, 0);
		    System.out.println(pckg);
		    if(pckg.equalsIgnoreCase("Gold3months")){
		    	if(!PaymentPage.gold_3months().isSelected()){
		    		PaymentPage.gold_3months().click();
			    	test.pass(" Gold 3months package is Selected");
		    	}else{
		    		test.pass("Gold 3months package is Already Selected");
		    	}
		    	
		    }else if(pckg.equalsIgnoreCase("Gold6months")){
		    	if(!PaymentPage.gold_6months().isSelected()){
		    		PaymentPage.gold_6months().click();
			    	test.pass(" Gold 6months Package is Selected");
		    	}else{
		    		test.pass("Gold 6months Package is Already Selected");
		    	}
		    	
		    } else if (pckg.equalsIgnoreCase("Diamond3months")){
		    	if(!PaymentPage.diamond_3months().isSelected()){
		    		PaymentPage.diamond_3months().click();
			    	test.pass("Diamond 3months package is selected");
		    	}else{
		    		test.pass("Diamond 3months package is Already selected");
		    	}
		    	
		    }else if(pckg.equalsIgnoreCase("Diamond6months")){
		    	if(!PaymentPage.diamond_6months().isSelected()){
		    		 PaymentPage.diamond_6months().click();
			    	 test.pass("Diamond 6months is SelectedPackage");
		    	}else{
		    		 test.pass("Diamond 6months is Already SelectedPackage");
		    	}
	    	   
	        } else if (pckg.equalsIgnoreCase("Platinum3months")){
	        	if(!PaymentPage.platinum_3months().isSelected()){
	        		PaymentPage.platinum_3months().click();
	 	    	    test.pass(" Platinum 3months package is Selected");
	        	}else{
	        		test.pass(" Platinum 3months package is Already Selected");
	        	}
	        }else if(pckg.equalsIgnoreCase("Platinum6months")){
	        	if(!PaymentPage.platinum_6months().isSelected()){
	        		PaymentPage.platinum_6months().click();
	     	        test.pass("platinum 6months Package is Selected");
	        	}else{
	        		test.pass("platinum 6months Package is Already Selected");
	        	}
            } else{
            	if(!PaymentPage.till_u_marry().isSelected()){
            		PaymentPage.till_u_marry().click();
             	   test.pass(" Tii_U_Marry package is Selected");
                }else{
                	test.pass(" Tii_U_Marry package is Already Selected");
                }
            }
	        if(!PaymentPage.profHighlighter().isSelected()){
	        	PaymentPage.profHighlighter().click();
	        	test.pass(" profile Highlighter is selected");
	        } 
	        if(!PaymentPage.topPlacement().isSelected()){
	        	PaymentPage.topPlacement().click();
	        	test.pass("Top Placement is selected");
	        } 
	        if(!PaymentPage.astroMatch().isSelected()){
	        	PaymentPage.astroMatch().click();
	        	test.pass(" AstroMatch is selected");
	        }
	        if(!PaymentPage.astromatchSpecial().isSelected()){
	        	PaymentPage.astromatchSpecial().click();
	        	test.pass(" AstroMatch  Special checkout is selected");
	        }
	        String totalAmount=PaymentPage.splTotalAmount().getText();
	        test.pass("Total Amount: "+totalAmount);
	        test.pass("Payment Started.....");
	        try{
	        	Thread.sleep(1000);
	        	String cardHolderName=eData.getExcelData("Payment", 1, 2);
	        	PaymentPage.cardHolderName().sendKeys(cardHolderName);
	        }catch(Exception e){e.getMessage();}
	        String cardNo=eData.getExcelData("Payment", 1, 1);
	        PaymentPage.creditCardNoEdit().sendKeys(cardNo);
	        new Select(PaymentPage.cardExpiryMonth()).selectByIndex(1);
	        String cExYear=eData.getExcelData("Payment", 1, 3);
	        new Select(PaymentPage.cardExpiryYear()).selectByVisibleText(cExYear);
	        String ccv=eData.getExcelData("Payment", 1, 4);
	        PaymentPage.ccvEdit().sendKeys(ccv);
	        PaymentPage.paySecure().click();
	        test.pass("Clicked on Pay Securely");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        test.pass(PaymentPage.paymentFailureMsg().getText());
	        PaymentPage.goBackLink().click();
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        String summaryAmount=PaymentPage.summaryAmount().getText();
	        test.pass("Summary Amount: "+summaryAmount);
	        test.pass("Validating Total Amount with Payment Failure Summary Amount.....");
	        Assert.assertEquals(totalAmount, summaryAmount);
	        test.pass("Payment failure Amount validated Successfully");
		}else{
			test.pass("Chat Banner is  Not Available to Check Payment flow");
		}  
        driver.quit();
	}
	@Test
	public void specialOffer_PaymentTest4() throws Throwable{
		test=extent.createTest("Payment Test through Upgrade link from Top Menu");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(1000);
		PaymentPage.updradeLinkFromMenu().click();
		test.pass("clicked on Upgrade link in Top menu");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.info("Navigating to Payment Page....................");
		Set<String> set= driver.getWindowHandles();
		Iterator<String> it=set.iterator();
	    it.next();
		String paymentpage=it.next();
		driver.switchTo().window(paymentpage);
		test.pass("driver control is navigated to Payment page successfully");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String pckg=eData.getExcelData("Payment", 1, 0);
	    if(pckg.equalsIgnoreCase("Gold3months")){
	    	if(!PaymentPage.gold_3months().isSelected()){
	    		PaymentPage.gold_3months().click();
		    	test.pass(" Gold 3months package is Selected");
	    	}else{
	    		test.pass("Gold 3months package is Already Selected");
	    	}
	    	
	    }else if(pckg.equalsIgnoreCase("Gold6months")){
	    	if(!PaymentPage.gold_6months().isSelected()){
	    		PaymentPage.gold_6months().click();
		    	test.pass(" Gold 6months Package is Selected");
	    	}else{
	    		test.pass("Gold 6months Package is Already Selected");
	    	}
	    	
	    } else if (pckg.equalsIgnoreCase("Diamond3months")){
	    	if(!PaymentPage.diamond_3months().isSelected()){
	    		PaymentPage.diamond_3months().click();
		    	test.pass("Diamond 3months package is selected");
	    	}else{
	    		test.pass("Diamond 3months package is Already selected");
	    	}
	    	
	    }else if(pckg.equalsIgnoreCase("Diamond6months")){
	    	if(!PaymentPage.diamond_6months().isSelected()){
	    		 PaymentPage.diamond_6months().click();
		    	 test.pass("Diamond 6months is SelectedPackage");
	    	}else{
	    		 test.pass("Diamond 6months is Already SelectedPackage");
	    	}
    	   
        } else if (pckg.equalsIgnoreCase("Platinum3months")){
        	if(!PaymentPage.platinum_3months().isSelected()){
        		PaymentPage.platinum_3months().click();
 	    	    test.pass(" Platinum 3months package is Selected");
        	}else{
        		test.pass(" Platinum 3months package is Already Selected");
        	}
        }else if(pckg.equalsIgnoreCase("Platinum6months")){
        	if(!PaymentPage.platinum_6months().isSelected()){
        		PaymentPage.platinum_6months().click();
     	        test.pass("platinum 6months Package is Selected");
        	}else{
        		test.pass("platinum 6months Package is Already Selected");
        	}
        } else{
        	if(!PaymentPage.till_u_marry().isSelected()){
        		PaymentPage.till_u_marry().click();
         	   test.pass(" Tii_U_Marry package is Selected");
            }else{
            	test.pass(" Tii_U_Marry package is Already Selected");
            }
        }
        if(!PaymentPage.profHighlighter().isSelected()){
        	PaymentPage.profHighlighter().click();
        	test.pass(" profile Highlighter is selected");
        } 
        if(!PaymentPage.topPlacement().isSelected()){
        	PaymentPage.topPlacement().click();
        	test.pass("Top Placement is selected");
        } 
        if(!PaymentPage.astroMatch().isSelected()){
        	PaymentPage.astroMatch().click();
        	test.pass(" AstroMatch is selected");
        }
        if(!PaymentPage.astromatchSpecial().isSelected()){
        	PaymentPage.astromatchSpecial().click();
        	test.pass(" AstroMatch  Special checkout is selected");
        }
        String totalAmount=PaymentPage.splTotalAmount().getText();
        test.pass("Total Amount: "+totalAmount);
        test.pass("Payment Started.....");
        try{
        	Thread.sleep(1000);
        	String cardHolderName=eData.getExcelData("Payment", 1, 2);
        	PaymentPage.cardHolderName().sendKeys(cardHolderName);
        }catch(Exception e){e.getMessage();}
        String cardNo=eData.getExcelData("Payment", 1, 1);
        PaymentPage.creditCardNoEdit().sendKeys(cardNo);
        new Select(PaymentPage.cardExpiryMonth()).selectByIndex(1);
        String cExYear=eData.getExcelData("Payment", 1, 3);
        new Select(PaymentPage.cardExpiryYear()).selectByVisibleText(cExYear);
        String ccv=eData.getExcelData("Payment", 1, 4);
        PaymentPage.ccvEdit().sendKeys(ccv);
        PaymentPage.paySecure().click();
        test.pass("Clicked on Pay Securely");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try{
        	 test.pass(PaymentPage.paymentFailureMsg().getText());
             PaymentPage.goBackLink().click();
             driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
             String summaryAmount=PaymentPage.summaryAmount().getText();
             test.pass("Summary Amount: "+summaryAmount);
             test.pass("Validating Total Amount with Payment Failure Summary Amount.....");
             Assert.assertEquals(totalAmount, summaryAmount);
        }catch(Exception e){e.getMessage();}
        test.pass("Payment failure Amount validated Successfully");
        driver.quit();
	}
	

}
