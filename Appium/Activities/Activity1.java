package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class Activity1 {
	//Driver declaration
	AppiumDriver driver;
	
	//Setup  function
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		//set desired capabilites
		UiAutomator2Options options = new UiAutomator2Options().
		setPlatformName("android").setAutomationName("UiAutomator2").setAppPackage("com.miui.calculator").setAppActivity(".cal.CalculatorActivity")
		//.setApp("C:\\Users\\IpsitaPrusty\\Downloads\\Calculator_8.6.1 (625857114)_APKPure.apk\")
		.noReset();
		// Set Appium server URL
		URL serverURL = new URI(" http://127.0.0.1:4723").toURL();
		
		//initialize driver
		driver = new AndroidDriver(serverURL,options);
	}
	@Test
	public void claculatorTest8()
	{
		//find and tap the digit 8
		driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_8")).click();
		//find and tap the multiply symbol
				driver.findElement(AppiumBy.accessibilityId("multiply")).click();
				//find and tap the digit 3
				driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_3")).click();
				//find and tap the equals symbol 
				driver.findElement(AppiumBy.accessibilityId("equals")).click();
				
				String result = driver.findElement(AppiumBy.id("result")).getText();
				
				assertEquals(result, "=24");
	
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	
}
}

 