package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

//	Create a Webdriver Constructor
	
	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath ="//span[text()='Create Campaign']" )
	private WebElement createCampaign;

	@FindBy(xpath = "//option[@value='campaignId']")
	private WebElement searchByCampID;
	
	@FindBy(xpath = "//input[@placeholder='Search by Campaign Id']")
	private WebElement inputCampId;
	
	@FindBy(xpath = "//option[@value='campaignName']")
	private WebElement searchByCampName;
	
	@FindBy(xpath = "//input[@placeholder='Search by Campaign Name']")
	private WebElement inputCampName;
	
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement campaignMessage;
	

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getSearchByCampID() {
		return searchByCampID;
	}

	public WebElement getInputCampId() {
		return inputCampId;
	}

	public WebElement getSearchByCampName() {
		return searchByCampName;
	}

	public WebElement getInputCampName() {
		return inputCampName;
	}
	
	
	public WebElement getCampaignMessage() {
		return campaignMessage;
	}
	
	
	public void displayCampaignMessage(String campName) {
		String msgVal = getCampaignMessage().getText();
		if(msgVal.contains(campName)) {
			System.out.println("Test is passed");	
		}else {
			System.out.println("Test is failed");
	}
	
	
	}
	
	

	
	
	

		
}
