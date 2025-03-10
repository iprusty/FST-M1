package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		 // open the browser using a URL
		 driver.get("https://training-support.net/webelements/login-form");
		 System.out.println("page of the title is : " + driver.getTitle());
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
		 driver.findElement(By.xpath("//button[text()='Submit']")).click();
		 
		
		 String message = driver.findElement(By.xpath("//h1[contains(text(),'Success')]")).getText();
		System.out.println(message);
		driver.quit();
				

	}
		 
		
	

	}


