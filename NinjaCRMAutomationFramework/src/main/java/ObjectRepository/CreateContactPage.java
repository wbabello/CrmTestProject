package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GenericWebDriverUtility.WebDriverUtility;

public class CreateContactPage {
	
	WebDriver driver;

	public CreateContactPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//span[text()='Create Contact']")
	private WebElement createNewContact;
	
	@FindBy(name = "organizationName")
	private WebElement organizationName;
	
	@FindBy(name = "contactName")
	private WebElement contactName;
	
	@FindBy(name = "mobile")
	private WebElement mobileNumber;
	
	@FindBy(name = "title")
	private WebElement title;
	
	@FindBy(xpath = "(//*[name()='svg' and @role='img'])[2]")
	private WebElement selectCampaignBtn;
	
	@FindBy(id="search-criteria")
	private WebElement cmpgSearchCriteria;

//	@FindBy(xpath = "//option[text()='Campaign ID']")
//	private WebElement cmpgSearchById;
//	
	
	@FindBy(id = "search-input")
	private WebElement searchInput;
	
//	@FindBy(xpath = "//option[text()='Campaign Name']")
//	private WebElement cmpgSearchByName;
	
	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContacBtn;
	
	@FindBy(xpath = "//button[text()='Select']")
	private WebElement selectBtn;
	
	

	
	// creation getters for the Data members;
	
	public WebElement getCreateNewContact() {
		return createNewContact;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getCmpgSearchCriteria() {
		return cmpgSearchCriteria;
	}

//	public WebElement getCmpgSearchById() {
//		return cmpgSearchById;
//	}
//
//	public WebElement getCmpgSearchByName() {
//		return cmpgSearchByName;
//	}

	public WebElement getCreateContacBtn() {
		return createContacBtn;
	}
	
	public WebElement getsearchInput() {
		return searchInput;
	}

	public WebElement selectBtn() {
		return selectBtn;
	}

	
	public void createContactWithCampaign(String orgName, String conName,String mobNum, String titl, String childUrl, String parentUrl, String campaignName) {
		
		organizationName.sendKeys(orgName);
		contactName.sendKeys(conName);
		mobileNumber.sendKeys(mobNum);
		title.sendKeys(titl);
		selectCampaignBtn.click();
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.swithToWindow(driver,childUrl );
		Select select = new Select(cmpgSearchCriteria);
		select.selectByValue("campaignName");
		searchInput.sendKeys(campaignName);
		selectBtn.click();
		webUtil.swithToWindow(driver, parentUrl);
		createContacBtn.click();
				
	}
	
	
	
}
