package GenericWebDriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementToBeClicked(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void swithToWindow(WebDriver driver, String partialUrl) {

		Set<String> windowIds = driver.getWindowHandles();
		for (String Window : windowIds) {
			driver.switchTo().window(Window);
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains(partialUrl)) {
				break;
			}
		}

	}

}
