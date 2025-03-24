package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage {
	
	WebDriver driver;

	public LogOutPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//*[name()='svg' and @role='img']")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logOutBtn;

// creation of Getter for all the Data Member of the Object

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}


	
}
