package com.app.Android_App;

	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;






	public class Http extends BaseTest {


		/*    public static void main(String[] args) {
		        String ip = "www.communitymatrimony.com";
		        String pingResult = "";

		        String pingCmd = "ping " + ip;
		        try {
		            Runtime r = Runtime.getRuntime();
		            Process p = r.exec(pingCmd);

		            BufferedReader in = new BufferedReader(new
		            InputStreamReader(p.getInputStream()));
		            String inputLine;
		            while ((inputLine = in.readLine()) != null) {
		                System.out.println(inputLine);
		                pingResult += inputLine;
		            }
		            in.close();

		        } catch (IOException e) {
		            System.out.println(e);
		        }
		    }   */
		
		
		 public static void main (String args[]) throws Exception  {
			 
			 String ip = BaseTest.readValueFromExcelSheet().get(1).get("Ping");
		        String pingResult = "";
			 
			 for (int i = 0; i < ip.length(); i++) {
				 
				  String pingCmd = "ping " + ip;
			        try {
			            Runtime r = Runtime.getRuntime();
			            Process p = r.exec(pingCmd);

			            BufferedReader in = new BufferedReader(new
			            InputStreamReader(p.getInputStream()));
			            String inputLine;
			            while ((inputLine = in.readLine()) != null) {
			                System.out.println(inputLine);
			                pingResult += inputLine;
			            }
			            in.close();

			        } catch (IOException e) {
			            System.out.println(e);
			        }
				 
				
		//	}
			        String Url1 = BaseTest.readValueFromExcelSheet().get(1).get("Response");
			        for (int j = 0; j < Url1.length(); j++) {
			        	

				        URL url = new URL(Url1);
				        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				        connection.setRequestMethod("GET");
				        connection.connect();

				        int code = connection.getResponseCode();
				        System.out.println("Response code of the object is "+code);
				        if (code==200 | code<=200)
				        {
				            System.out.println("Success");
				        } else  if (code==300 | code <=300) {
				        	  System.out.println("Redirecting");
				    } else if (code==400 | code<=400) {
				    	System.out.println("Client Error");
				}  else if (code==500 | code<=500) {
			    	System.out.println("Server Error");
				        
				  
				    }
				 
				 
			}
			        }
						
					}


	
		 }





