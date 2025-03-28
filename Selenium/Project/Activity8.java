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

public class Activity8  extends BaseTest {
	
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
	        WebElement accountsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Accounts']")));
	        accountsOption.click();
	     // Step 4: Find the table on the Account Page
	        // Find the rows in the table (assuming the table rows have <tr> elements inside a <table> with an id 'accountTable')
	        WebElement accountTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'list view table-responsive')]")));
	     // Find all the rows in the table
	        List<WebElement> rows = accountTable.findElements(By.tagName("tr"));
	        System.out.println("Total rows found: " + rows.size());

            // Step 5: Filter out unwanted rows
            List<WebElement> dataRows = rows.stream()
                .filter(row -> {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    return !cells.isEmpty() && !cells.get(0).getText().contains("BULK ACTION");
                })
                .toList();

            System.out.println("Filtered data rows count: " + dataRows.size());

            // Step 6: Extract names from the first 5 odd-numbered data rows
            FileWriter writer = new FileWriter("output.txt");
            int count = 0;

            for (int i = 0; i < dataRows.size(); i += 2) { // Odd rows
                List<WebElement> cells = dataRows.get(i).findElements(By.tagName("td"));

                // Extract the name from the correct column
                if (cells.size() > 2) {  // Ensure index 2 exists
                    String name = cells.get(2).getText().trim();
                    System.out.println("Valid name found: " + name);
                    writer.write(name + "\n");
                    count++;
                }

                if (count == 5) break;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close browser
        }
    }
}	    
	    	
	        