package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;

public class Activity1 extends BaseTest {
  @Test
  public void VerifyWebsiteTitle() {
      String title = driver.getTitle();
      //Print the title of the page
      System.out.println("Page title is: " + title);
      //Assertion for page title
      Assert.assertEquals("SuiteCRM", title);
  }
}
