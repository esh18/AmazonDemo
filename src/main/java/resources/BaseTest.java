package resources;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	public WebDriver setupWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		return driver;
	}

	public void SwitchWindowToChild() {
		Set<String> windows = driver.getWindowHandles();
		if (windows.size() > 1) {
			Iterator<String> iterator = windows.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			driver.switchTo().window(childWindow);
		} else {
			System.out.println("No child window found to switch.");
		}
	}

	public void SwitchWindowToParent() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		if (iterator.hasNext()) {
			String parentWindow = iterator.next();
			driver.switchTo().window(parentWindow);
		} else {
			System.out.println("No parent window found to switch.");
		}
	}

	public void closeAllChildWindows() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}

		// Switch back to the parent window
		driver.switchTo().window(parentWindow);
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
		} else {
			System.out.println("Driver is already null.");
		}
	}
}
