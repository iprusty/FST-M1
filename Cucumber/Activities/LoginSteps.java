package stepDefinations;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
    @Given("the user is on the login page")
    public void openPage() {
        // Open the login page
        driver.get("https://training-support.net/webelements/login-form");
        // Assert page title
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }

    @When("the user enters username and password")
    public void enterCreds() {
        // Find username field and enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        // Find password field and enter password
        driver.findElement(By.id("password")).sendKeys("password"); 
        
        //to get the entered values
        String enteredUsername = driver.findElement(By.id("username")).getAttribute("value");
        System.out.println("Username field has " + enteredUsername);
    }
    @When("the user enters {string} and {string}")
    public void enterCredsWithParam(String username, String password) {
        // Find username and password field and enter correct credentials
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password); 
        //to get the entered values
        String enteredUsername = driver.findElement(By.id("username")).getAttribute("value");
        System.out.println("Username field has " + enteredUsername);
    }
    @And("clicks the submit button")
    public void clickSubmit() {
        // Find the submit button and click it
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("get the confirmation message and verify it")
    public void getMessage() {
        // Find the confirmation message
     
        String message = driver.findElement(By.tagName("h1")).getText();
        // Assert message
        Assertions.assertEquals("Welcome Back, Admin!", message);
    }

    
        @Then("get the confirmation text and verify message as {string}")
        public void confirmMessageAsInput(String expectedMessage) {
        	
        	// find the  message 
            String message = "NOT FOUND";
            if(expectedMessage.contains("Invalid")) {
            	message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
            }else {
            	message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-center"))).getText();
            	
            }
            // Assert message
            Assertions.assertEquals(expectedMessage, message);
    }
}