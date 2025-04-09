package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class Activity2 {
	//Driver declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	//Setup  function
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		//set desired capabilites
		UiAutomator2Options options = new UiAutomator2Options().
		setPlatformName("android").setAutomationName("UiAutomator2").setAppPackage("com.android.chrome")
.setAppActivity("com.google.android.apps.chrome.Main")
		//.setApp("C:\\Users\\IpsitaPrusty\\Downloads\\Calculator_8.6.1 (625857114)_APKPure.apk\")
		.noReset();
		// Set Appium server URL
		URL serverURL = new URI(" http://127.0.0.1:4723").toURL();
		
		//initialize driver
		driver = new AndroidDriver(serverURL,options);
		
		//wait = new WebDriverWait(androidDriver,Duration.ofSeconds(10))
		// Open the browser with the URL
		driver.get("https://training-support.net");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void chromeTest() {
	 
	        // Find heading on the page
		
	        String pageHeading = driver.findElement(AppiumBy.xpath( "//android.widget.TextView[@text='Training Support']")).getText();
		
	        // Print to console
		
	        System.out.println("Heading: " + pageHeading);
		
	        // Find and click the About Us link
		
	        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		
	 
		
	        // Find heading of new page and print to console
		
	        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
		
	                "//android.widget.TextView[@text='About Us']"
		
	        )).getText();
		
	        System.out.println(aboutPageHeading);
		
	    }
	
	    // Tear down method
		
	    @AfterClass
		
	    public void tearDown() {
		
	        // Close the app
		
	        driver.quit();
		
	    }
	
}

 