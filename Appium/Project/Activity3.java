package liveProject;

import static activities.ActionsBase.doSwipe;
import static activities.ActionsBase.longPress;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.app.todolist");
		options.setAppActivity(".view.MainActivity");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test(priority = 1)
	public void tasksTest3_1() {
		// Get width and height of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the point to long press
		Point longPressPoint = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.28));
		// Set the start and end points to move the slider
		Point slideStart = new Point((int) (dims.getWidth() * 0.27), (int) (dims.getHeight() * 0.56));
		Point sliderEnd = new Point((int) (dims.getWidth() * 0.593), (int) (dims.getHeight() * 0.56));

		// Mark the first 2 tasks as complete
		List<WebElement> checkBoxes = driver.findElements(AppiumBy.id("com.app.todolist:id/cb_task_done"));
		// Click first checkbox
		checkBoxes.get(0).click();
		// Click second checkbox
		checkBoxes.get(1).click();

		// Long press the third task to edit
		longPress(driver, longPressPoint);
		// Click on Edit task
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")).click();
		// Move the slider to 50%
		doSwipe(driver, slideStart, sliderEnd, 2000);
		// Click save
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();

		// Assertions
		String progressValue = driver.findElements(AppiumBy.xpath("//android.widget.ProgressBar")).get(2).getText();
		assertEquals(progressValue, "50.0");
	}

	@Test(priority = 2)
	public void tasksTest3_2() {
		// Find and tap more options
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		// Find and tap Completed tasks
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Completed tasks']")).click();

		// Get all tasks
		List<WebElement> completedTasks = driver
				.findElements(AppiumBy.id("com.app.todolist:id/rl_exlv_task_group_root"));
		// Assertions
		assertEquals(completedTasks.size(), 2);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
