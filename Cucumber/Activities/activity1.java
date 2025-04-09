package stepDefinations;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class activity1 extends BaseClass {
        @Given("the user is on the TS homepage")
        public void openPage() {
        	//open the TS homepage
        	driver.get("https://training-support.net");
        	
        	//Assertion
        	assertEquals(driver.getTitle(), "Training Support");
        }
        
       @When("they click on the About Us link")
       public void clickLink() {
       	//find and click the About Us link
    	   driver.findElement(By.linkText("About Us")).click();
       }
       @Then("they are the redirected to the About page")
       public void redirectToAbout() {
          	//get the new page title and assert
    	   assertEquals(driver.getTitle(), "About Training Support");
       	   
}
}
