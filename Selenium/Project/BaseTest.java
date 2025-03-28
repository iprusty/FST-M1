package com.crm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	 protected WebDriver driver;
	 protected WebDriverWait wait;
	
		
  
  @BeforeClass
  public void setUp() {
	  //Driver initialization
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  //open the browser
	  driver.get("https://alchemy.hguy.co/crm/");
  }

  @AfterClass
  public void teardown() {
	  driver.quit();
  }

}


