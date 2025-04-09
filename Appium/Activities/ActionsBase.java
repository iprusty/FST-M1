package activities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class ActionsBase {
	// Create the pointer
	static final PointerInput pointer = new PointerInput(Kind.TOUCH, "finger");

	// Create the swipe action function
	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		// Create sequence of actions
		Sequence swipe = new Sequence(pointer, 1)
			.addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
			.addAction(pointer.createPointerDown(LEFT.asArg()))
			.addAction(pointer.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
			.addAction(pointer.createPointerUp(LEFT.asArg()));

		// Perform the actions
		driver.perform(Arrays.asList(swipe));
	}

	// Create the long press action function
	public static void longPress(AppiumDriver driver, Point start) {
		// Create sequence of actions
		Sequence longPress = new Sequence(pointer, 1)
			.addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
			.addAction(pointer.createPointerDown(LEFT.asArg()))
			.addAction(new Pause(pointer, Duration.ofMillis(500)))
			.addAction(pointer.createPointerUp(LEFT.asArg()));

		// Perform the actions
		driver.perform(Arrays.asList(longPress));
	}

	// Create the long press action function
	public static void tap(AppiumDriver driver, Point start) {
		// Create sequence of actions
		Sequence tap = new Sequence(pointer, 1)
			.addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
			.addAction(pointer.createPointerDown(LEFT.asArg()))
			.addAction(new Pause(pointer, Duration.ofMillis(100)))
			.addAction(pointer.createPointerUp(LEFT.asArg()));

		// Perform the actions
		driver.perform(Arrays.asList(tap));
	}
}