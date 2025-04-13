package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.time.Duration;

import static activities.ActionsBase.doSwipe;

public class Activity4 {
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

    @Test
    public void webAppTest() throws InterruptedException {
        // Get width and height of the screen
        Dimension dims = driver.manage().window().getSize();
        System.out.println(dims);
        Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8));
        Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.6));

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

        // Scroll(Fling) to the end of the page
        doSwipe(driver, start, end, 50);

        // Wait for To-Do list link and click it
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))
        ).click();

        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='todo-input']")));

        // Find elements on the page
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='todo-input']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='todo-add']"));
        // Enter tasks
        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        addTaskInput.sendKeys("Clear the list");
        addTaskButton.click();

        // Find all added tasks
        List<WebElement> tasksAdded = driver.findElements(AppiumBy.xpath("//android.widget.ListView/android.view.View"));
        // Check off tasks one by one
        for(WebElement task : tasksAdded) {
        	task.findElement(AppiumBy.xpath("//android.view.View/android.widget.CheckBox")).click();
        }

        // Assertion to check if all tasks are added
        tasksAdded = driver.findElements(AppiumBy.xpath("//android.widget.ListView/android.view.View"));
        Assert.assertEquals(tasksAdded.size(), 5);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
