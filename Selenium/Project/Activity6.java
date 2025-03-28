package com.crm.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.LoginPage;

public class Activity6 extends BaseTest {

    @Test
    public void verifyActivitiesMenuExitsAndClickable() {
    	 LoginPage lp = new LoginPage(driver);
   	  lp.enterUsename("admin");
   	  lp.enterPassword("pa$$w0rd");
   	  lp.clickLogin();
     
      
        // Ensure the "Activities" menu item exists
        WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));
        activitiesMenu.click();
       
        
    }
}

