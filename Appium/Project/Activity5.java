package liveProject;

import static activities.ActionsBase.doSwipe;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://training-support.net/webelements");
	}

	@Test(priority = 1)
	public void loginPageTest() {
		// Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.85));
		Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.5));

		// Wait for page to load
		wait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

		// Scroll(Fling) to the end of the page
		doSwipe(driver, start, end, 145);

		// Wait for Login Form link and click it
		wait.until(ExpectedConditions
			.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Login Form')]")))
			.click();

		// Wait for the page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Submit']")));
		
		// Assertion
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView")).getText(), "Login Form");
	}

	@Test(priority = 2)
	public void invalidLoginTest() throws InterruptedException {
		// Find the input fields and login
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))
			.sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))
			.sendKeys("WrongPassword");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Submit']")).click();

		// Wait for success message to load and get text
		String message = wait.until(ExpectedConditions
			.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='subheading']")))
			.getText();
		assertEquals(message, "Invalid credentials");
	}
	
	@Test(priority = 3)
	public void validLoginTest() throws InterruptedException {
		// Find the input fields and login
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))
			.sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))
			.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Submit']")).click();

		// Wait for success message to load and get text
		String message = wait
			.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[2]")))
			.getText();
		assertEquals(message, "Welcome Back, Admin!");
	}
}
