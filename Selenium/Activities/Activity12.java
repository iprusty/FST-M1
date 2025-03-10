package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {

		//create a new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		//create the wait object
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 // open the browser using a URL
		 driver.get("https://training-support.net/webelements/dynamic-content");
		//print the title of the page
		 System.out.println("page of the title is : " + driver.getTitle());
		 
		 driver.findElement(By.id("genButton")).click();
		 
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));

		 //find the input fields
		  System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
		  
		  driver.quit();
	}
}

