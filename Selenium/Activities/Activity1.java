package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// Initialization of the WebDriver
		WebDriver driver = new FirefoxDriver();
				
	    // open the browser using a URL
		driver.get("https://training-support.net");
		
		//print the title of the home page
		System.out.println("Page of the title is: " + driver.getTitle());
		//find the about us link and click it
		driver.findElement(By.linkText("About Us")).click();
		
		//print the title of the about page
		System.out.println("New page title is : " + driver.getTitle());
				
	     driver.quit();
			

	}

}
