package com.crm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;

public class Activity3 extends BaseTest {
  @Test
  public void getCopyRightText() {
	 WebElement footertext =  driver.findElement(By.id("admin_options"));
	 System.out.println("first copyright text in the footer :" + footertext.getText());

	  
  }
}
