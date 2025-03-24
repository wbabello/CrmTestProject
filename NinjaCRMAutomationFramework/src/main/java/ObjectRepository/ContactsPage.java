package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//option[@value='contactId']")
	private WebElement seachContactById;
	
	@FindBy(xpath = "//input[@placeholder='Search by Contact Id']")
	private WebElement inputContactId;
	
	@FindBy(xpath = "//option[@value='contactName']")
	private WebElement seachContactByContName;
	
	@FindBy(xpath = "//input[@placeholder='Search by Contact Name']")
	private WebElement inputContactName;
	
	@FindBy(xpath = "//span[text()='Create Contact']")
	private WebElement createNewContact;



	public WebElement getSeachContactById() {
		return seachContactById;
	}

	public WebElement getInputContactId() {
		return inputContactId;
	}

	public WebElement getSeachContactByContName() {
		return seachContactByContName;
	}

	public WebElement getInputContactName() {
		return inputContactName;
	}

	public WebElement getCreateNewContact() {
		return createNewContact;
	}
	
	
	public void CreateNewContact() {
		createNewContact.click();
		
	}
	
	
	
	
	
	
	

}
