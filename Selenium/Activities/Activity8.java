package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {

		//create a new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		//create the actions object
		Actions builder = new Actions(driver);
		
		//create the wait object
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 // open the browser using a URL
		 driver.get("https://training-support.net/webelements/mouse-events");
		//print the title of the page
		 System.out.println("page of the title is : " + driver.getTitle());
	//Find the elemets that can be clicked	 
	WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
	WebElement cargoToml = driver.findElement(By.xpath( "//h1[text()='Cargo.toml']"));
	WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
	WebElement targetButton = driver.findElement(By.xpath( "//h1[text()='target']"));
	
	
	//perform left click on cargo.lock and then cargo.toml
	builder.click(cargoLock).pause(2000).click(cargoToml).pause(2000).perform();
	//print the front side text
	String actionMessage = driver.findElement(By.id("result")).getText();
	System.out.println(actionMessage);
	
	//perform double click on src then right click on target
	builder.doubleClick(srcButton).pause(2000).contextClick(targetButton).pause(2000).perform();
	//and then open it
	builder.click(driver.findElement(By.xpath("//span[text()='Open']"))).pause(2000).build().perform();
	//print the front side text
	actionMessage = driver.findElement(By.id("result")).getText();
	System.out.println(actionMessage);
	
	//close the browser
	driver.quit();
		 
		 
	}

}
