package drupal;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

public class ParallelSuiteTest 
{
 public WebDriver Driver;
  
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
		this.Driver = new ChromeDriver(chromeOptions);
		Driver.get("https://www.google.com");
  }
  
  @Test(priority=0)
  public void comparePageTitle() {
	    WebDriver Driver = this.Driver;
	    String pageTitle = Driver.getTitle();
	    String ourTitle = "Google";
	    Assert.assertEquals(ourTitle, pageTitle);

  }
  @AfterClass
  public void afterClass() {
	 this.Driver.close();
  } 
}
