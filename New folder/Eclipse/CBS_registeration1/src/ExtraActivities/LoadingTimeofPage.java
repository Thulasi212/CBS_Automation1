package ExtraActivities;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadingTimeofPage {
	public static void main(String[] args) throws Exception {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "C:\\Mohan\\geckodriver-v0.18.0-arm7hf\\geckodriver.exe");
        driver = new FirefoxDriver();       
        StopWatch pageLoad = new StopWatch();
        pageLoad.start();
        //Open your web app (In my case, I opened communitymatrimony)
        driver.navigate().to("https://www.communitymatrimony.com/");
     
       driver.manage().window().maximize();
       Thread.sleep(2000);
        // Wait for the required any element (I am waiting for Login button in communitymatrimony)
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_l")));

        pageLoad.stop();
        //Get the time
        long pageLoadTime_ms = pageLoad.getTime();
        long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
        System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
        System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
        driver.close();
	}

}
