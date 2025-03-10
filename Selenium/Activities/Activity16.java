package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		//create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("page of the title is: " + driver.getTitle());
		
	    //Find the dropdown
		WebElement selectElement = driver.findElement(By.cssSelector("select.h-10"));
		//Pass the WebElement to the Select object
		Select dropdown = new Select(selectElement);
		
		//Select the second option using visible text
		dropdown.selectByVisibleText("Two");
		// Print the selected option
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
      //Select the 3rd option using index
        dropdown.selectByIndex(3);
     // Print the selected option
        System.out.println(dropdown.getFirstSelectedOption().getText());
      //Select the 4rth option using value attribute
        dropdown.selectByValue("four");
        // Print the selected option
        System.out.println(dropdown.getFirstSelectedOption().getText());
      
        // Print all the options
        List<WebElement> alloptions = dropdown.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option : alloptions) {
        	System.out.println(option.getText());
        }
        	
        	driver.quit();
        }
	}


