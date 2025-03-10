package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// Initialization of the WebDriver
		WebDriver driver = new FirefoxDriver();
						
		 // open the browser using a URL
		 driver.get("https://training-support.net/webelements/login-form");
		 System.out.println("page of the title is : " + driver.getTitle());
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("password");
		 //driver.findElement(By.className("svelte-1pdjkmx")).click();
		 driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		 
		//String message =  driver.findElement(By.className("text-black")).getText();
		 String message =  driver.findElement(By.tagName("h1")).getText();
		System.out.println(message);
				

	}
		 
		
	}

