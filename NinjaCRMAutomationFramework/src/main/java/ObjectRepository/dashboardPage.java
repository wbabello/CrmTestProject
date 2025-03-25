package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {

	WebDriver driver;

	public dashboardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "Quotes")
	private WebElement quotesLink;

	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLink;

	@FindBy(linkText = "Purchase Order")
	private WebElement PurchaseOrderLink;

	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;

	@FindBy(xpath = "//*[ name()='svg' and @role ='img']")
	private WebElement profileLink;

	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logOutBtn;

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getPurchaseOrderLink() {
		return PurchaseOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getProfileLink() {
		return profileLink;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	// Log-out method
	public void logOut() {
		profileLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(logOutBtn).click();
		System.out.println("User logged out successfully.");
	}

}
