package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
        //find and click the button to open the alert
        driver.findElement(By.id("simple")).click();
        // Switch focus to the alert
        Alert simpleAlert = driver.switchTo().alert();
        //print the text from the alert
        System.out.println(simpleAlert.getText());
        
        simpleAlert.accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        
        driver.quit();


	}

}
