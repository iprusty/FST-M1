package com.crm.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;

public class Activity2 extends BaseTest {
  @Test
  public void getHeaderImageURL() {
	  driver.findElement(By.xpath("//div//img"));

      //Print title of new page
      System.out.println("Heading is: " + driver.getTitle());

	 
	  
  }
  }

