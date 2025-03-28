package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.LoginPage;

public class Activity4 extends BaseTest {
  @Test
  public void testLogin() {
	  LoginPage lp = new LoginPage(driver);
	  lp.enterUsename("admin");
	  lp.enterPassword("pa$$w0rd");
	  lp.clickLogin();
	  
	  Assert.assertEquals(driver.getTitle(), "SuiteCRM");
	  System.out.println("Login Succesful, Homepage verified");
  }
}
