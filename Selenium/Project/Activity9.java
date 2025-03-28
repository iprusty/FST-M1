package com.crm.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.crm.base.BaseTest;
import com.crm.pages.LoginPage;

public class Activity9  extends BaseTest {
	
	@Test
	 public void testLogin() {
		  LoginPage lp = new LoginPage(driver);
		  lp.enterUsename("admin");
		  lp.enterPassword("pa$$w0rd");
		  lp.clickLogin();
	 }
	    @Test
	    public void traverseAndPrintAccountTable() throws IOException {
	    	try {
	    	// Step 3: Navigate to Sales -> Account Page
	        WebElement salesMenu = driver.findElement(By.id("grouptab_0"));
	        salesMenu.click();
	        WebElement LeadOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")));
	        LeadOption.click();
	     // Step 4: Find the table on the Account Page
	        // Find the rows in the table (assuming the table rows have <tr> elements inside a <table> with an id 'accountTable')
	        WebElement accountTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'list view table-responsive')]")));
	     // Find all the rows in the table
	        List<WebElement> rows = accountTable.findElements(By.tagName("tr"));
	        System.out.println("Total rows found: " + rows.size());
	        
	        
            // Extract the first 10 values from 'Name' and 'User' columns
            int count = 0;
            System.out.println("Name | Users");
            
            for (WebElement row : rows) { // Start from 1 to skip the header row
                

                List<WebElement> columns = row.findElements(By.tagName("td"));

                // Assuming Name is in the first column and User is in the second column
                if (columns.size() >=2) {
                    String name = columns.get(0).getText().trim();
                    String user = columns.get(1).getText().trim();
                    
                    if(!name.isEmpty() && !user.isEmpty() &&  !name.equalsIgnoreCase("BULK ACTION") ) {
                    System.out.println("Name: " + name + ", User: " + user);
                    count++;
                }
                }
                
            if (count ==10) break;
            }
            if(count == 0) {
        System.out.println("no Filtered data found counts: " );
	    	}
	    	}
            catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	    }
}
	    	
            
	    


    

	        