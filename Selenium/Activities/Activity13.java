package activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a new instance of the firefox driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/tables");
		System.out.println("page of the title is: " + driver.getTitle());
		
		//print the number of columns
		List<WebElement> cols = driver.findElements(By.xpath("//table/thread/tr/th"));
		System.out.println("Number of columns: " + cols.size());

		//print the number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Number of rowss: " + rows.size());
		
		//print the cells values of the third row
		List<WebElement> thirdrow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		for(WebElement cell :thirdrow) {
			System.out.println(cell.getText());
		}
		//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]")).getText());
		
		//print the cells values of the second row and second column
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText());
		
		driver.quit();
		
		

	}

}
