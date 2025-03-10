package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
        //find and click the button to open the alert
        driver.findElement(By.id("confirmation")).click();
        // Switch focus to the alert
        Alert confirmAlert = driver.switchTo().alert();
        //print the text from the alert
        String alertText = confirmAlert.getText();
        System.out.println("Text in alert: " + alertText);
        
        //close the alert by clicking OK
        confirmAlert.accept();
        
        //can also close the alert by clicking cancel
        //confirmAlert.dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
        
        driver.quit();

	}

}
