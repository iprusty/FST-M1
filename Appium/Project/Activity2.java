package liveProject;

import static activities.ActionsBase.longPress;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	// Declare driver
	AndroidDriver driver;
	WebDriverWait wait;

	// Setup method
	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setAppPackage("com.app.todolist");
		caps.setAppActivity(".view.MainActivity");
		caps.noReset();

		// Appium Server URL
		URL serverURL = new URL("http://localhost:4723");

		// Initialization of driver
		driver = new AndroidDriver(serverURL, caps);
		// Initialization of wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void tasksTest2() {
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the point of long press
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .15));
		
		// Perform long press on the first list item
		longPress(driver, start);
		// Select edit task
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")).click();
		
		// Set a deadline for the coming weekend
		driver.findElement(AppiumBy.id("tv_todo_list_deadline")).click();
		driver.findElement(AppiumBy.accessibilityId("15 February 2025")).click();
		// Save details
		driver.findElement(AppiumBy.id("bt_deadline_ok")).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();

		// Assertions
		String expectedDeadline = driver.findElement(AppiumBy.id("tv_exlv_task_deadline")).getText();
		Assert.assertEquals(expectedDeadline, "Deadline: 15.02.2025");
	}

	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}
