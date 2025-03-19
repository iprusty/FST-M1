package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class activity1 {
	//Declare class objects
	WebDriver driver;
  
  @BeforeClass //setup function
  public void setUP() {
	  //Driver initialization
	  driver = new FirefoxDriver();
	  //open the browser
	  driver.get("https://training-support.net");
  }
  
  @Test(priority = 1)
  public void pageTitleTest() {
	  //verify page title
	  assertEquals(driver.getTitle(),"Training Support");
  }
  
  @Test(priority = 2)
  public void aboutLinkTest() {
	  //find the page link and click it
	  driver.findElement(By.linkText("About Us")).click();
	  
	  //verify page redirect
	  assertEquals(driver.getTitle(), "About Training Support");
  }

  @AfterClass
  public void tearDown() {
	  //Close the browser
	  driver.quit();
  }

}
