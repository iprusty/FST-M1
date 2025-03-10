package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		
			//create a new instance of the FireFox driver
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://training-support.net/webelements/tables");
			System.out.println("page of the title is: " + driver.getTitle());
			
			 // Print the number of columns
	        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
	        System.out.println("Number of columns: " + cols.size());
	        // Print the number of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
	        System.out.println("Number of rows: " + rows.size());
			
			
			  // Print the Book Name in the 5th row
	        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
	        System.out.println("Book name before sorting: " + cellValue.getText());

	        // Sort the table
	        driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();

	        // Print the cell value of the second row and second column again
	        cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
	        System.out.println("Book Name after sorting: " + cellValue.getText());

	        // Close the browser
	        driver.quit();
	    }
	
			
			
			

	}


