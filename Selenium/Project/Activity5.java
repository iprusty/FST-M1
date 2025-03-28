package com.crm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.LoginPage;

public class Activity5 extends BaseTest { 
  @Test
  public void getNavMenuColor() {
	  LoginPage lp = new LoginPage(driver);
	  lp.enterUsename("admin");
	  lp.enterPassword("pa$$w0rd");
	  lp.clickLogin();
	WebElement menu =   driver.findElement(By.id("toolbar"));
	String color = menu.getCssValue("background-color");
	System.out.println("Navigation Menu color: " + color);
	  
  }
}
