package ExtraActivities;
import java.util.List;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindLinks {
  public static List findAllLinks(WebDriver driver)
  {
	 List<WebElement> elementList = new ArrayList();
	  elementList = driver.findElements(By.tagName("a"));
	  elementList.addAll(driver.findElements(By.tagName("img")));
	 List finalList = new ArrayList(); 
	  for (WebElement element : elementList)
	  {
		  if(element.getAttribute("href") != null)
		  {
			  finalList.add(element);
		  }		  
	  }	
	  return finalList;
  
  }
	public static String isLinkBroken(URL url) throws Exception

	{		
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		     response = connection.getResponseMessage();	       

		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}

	public static void main(String[] args) throws Exception {	
			FirefoxDriver ff = new FirefoxDriver();
			ff.get("https://www.brahminmatrimony.com/");	
		ff.manage().window().maximize();
			ff.findElement(By.xpath(".//*[@id='a12']")).sendKeys("BRH1130237");
			ff.findElement(By.xpath(".//*[@id='passwordClear1']")).clear();
			ff.findElement(By.xpath(".//*[@id='password1']")).sendKeys("cbstest");
			ff.findElement(By.xpath(".//*[@id='login_form_web']/div[2]/input[3]")).click();
			Thread.sleep(2000);
		    List<WebElement> allImages = findAllLinks(ff);    
		    System.out.println("Total number of elements found " + allImages.size());
		    for( WebElement element : allImages){
		    	try
		    	{
			        System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
			        System.out.println("Completed Successfully......");
			       System.out.println( ff.getCurrentUrl());
		    		//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    	}
		    	catch(Exception exp)
		    	{
		    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		
		    	}
		    }
	    }
	}