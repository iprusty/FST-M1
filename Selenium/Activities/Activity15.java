package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {

	public static void main(String[] args) {
		
		//create a new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		 // open the browser using a URL
		 driver.get("https://training-support.net/webelements/dynamic-attributes");
		//print the title of the page
		 System.out.println("page of the title is : " + driver.getTitle());

		 //find the input fields
		  System.out.println("Page title is: " + driver.getTitle());

	        // Find the input fields
	        WebElement fullName = driver.findElement(By.xpath("//input[contains(@id, 'full-name-')]"));
	        WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
	        WebElement eventDate = driver
	        		.findElement(By.xpath("//label[contains(text(), 'event?')]/following-sibling::input[@type='date']"));
	        WebElement details = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
	        
	        //type input values
	        fullName.sendKeys("ipsita");
	        email.sendKeys("ipsita@example.com");
	        eventDate.sendKeys("2025-03-15");
	        details.sendKeys("End of course party");
	        
	        //click the submit button
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	        
	        //print the sucess message
	        String message = driver.findElement(By.id("action-confirmation")).getText();
	        System.out.println("Sucess message: " + message);
		 
		 //close the browser
		 driver.quit();
	}

}
