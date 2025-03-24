package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="username")
	private WebElement usernameField;
	

	@FindBy(id="inputPassword")
	private WebElement passwordFied;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPaswdLink;
	
	@FindBy(linkText = "Create Account")
	private WebElement createAccBtn;


	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordFied() {
		return passwordFied;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getForgotPaswdLink() {
		return forgotPaswdLink;
	}

	public WebElement getCreateAccBtn() {
		return createAccBtn;
	}
	
	public void LongIn(String uname, String password) {
		usernameField.sendKeys(uname);
		passwordFied.sendKeys(password);
		signInBtn.click();
		
	}
	
	
	
}
