package com.crm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.LoginPage;

public class Activity7 extends BaseTest {
	
     @Test(priority=1)
	 public void testLogin() {
		  LoginPage lp = new LoginPage(driver);
		  lp.enterUsename("admin");
		  lp.enterPassword("pa$$w0rd");
		  lp.clickLogin();
	 }

    @Test(priority=2)
    public void verifyPhoneNumberInPopUp() {
       
        // Step 2: Navigate to Sales -> Lead
        WebElement salesMenu = driver.findElement(By.id("grouptab_0"));
        salesMenu.click();
        WebElement leadsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
        leadsOption.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Find the Additional Info icon in the table and click it
        WebElement  additionalInfoIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Additional Details']")));
        additionalInfoIcon.click();
        
       
       
        // Wait for the pop-up and extract phone number
        String parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
       
       // WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-id-9']")));
      
        WebElement phoneNumberElement =driver.findElement(By.className("phone"));
        String phoneNumber = phoneNumberElement.getText();
     // Print phone number to the console
        System.out.println("Lead Phone Number: " + phoneNumber);
        
  
        
        // Verify the phone number (You can implement assertions if needed)
        Assert.assertNotNull(phoneNumber, "Phone number should not be null");
        
        // Close the pop-up
        driver.close();
        driver.switchTo().window(parentWindow);
        
       
       
    }

   

        
        
    
}
