package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity5 {
	//Declare class objects
		WebDriver driver;
	  
	  @BeforeClass //setup function
	  public void setUP() {
		  //Driver initialization
		  driver = new FirefoxDriver();
		  //open the browser
		  driver.get("https://v1.training-support.net/selenium/target-practice");
	  }
  @Test(groups = { "HeaderTests","ButtonTests"})
  public void pageTitleTest() {
	  Assert.assertEquals(driver.getTitle(), "Selenium: Target-practice");
  }
  
  @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})	
  public void HeaderTest1() {
	WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
      Assert.assertEquals(header3.getText(), "Third header");
	
  }
  @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
  public void HeaderTest2() {
      Color header5color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
      Assert.assertEquals(header5color.asHex(), "#9333ea");
	
  }
  @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})	
  public void ButtonTest1() {
      WebElement button1 = driver.findElement(By.xpath("//button[contains(@class,'emerald')]"));
      Assert.assertEquals(button1.getText(), "Emerald");
	
  }
  @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
  public void ButtonTest2() {
      WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
      Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
	
  }
	

	
  //Include alwaysRun property on the @AfterTest
	
  //to make sure the page closes
	
  @AfterTest(alwaysRun = true)
	
  public void afterMethod() {
	
      //Close the browser
	
      driver.close();
	
  }
	

	
}