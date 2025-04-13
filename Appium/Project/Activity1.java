package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Activity1 {
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
	public void tasksTest1() {
		// Tasks to be added
		String[][] tasksToAdd = {
			{"Complete Activity 1", "High"}, 
			{"Complete Activity 2", "Medium"},
			{"Complete Activity 3", "Low"}
		};

		// Repeat actions for each task to add
		for (String tasks[] : tasksToAdd) {
			// Find the create new task button and click it
			driver.findElement(AppiumBy.id("fab_new_task")).click();
			// Wait for input field to show and then enter the task name
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("et_new_task_name")))
					.sendKeys(tasks[0]);
			// Set the priority
			driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
			wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='"+ tasks[1] +"']")))
				.click();
			// Click Save
			driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		}

		// Assertions
		// Find all the added tasks
		List<WebElement> tasksAdded = wait.until(ExpectedConditions.
			numberOfElementsToBe(AppiumBy.id("com.app.todolist:id/rl_exlv_task_group_root"), 3));
		// Verify number of tasks added
		assertEquals(tasksAdded.size(), 3);
	}

	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}

}