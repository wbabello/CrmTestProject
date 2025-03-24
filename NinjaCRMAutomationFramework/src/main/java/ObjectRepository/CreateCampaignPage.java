package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

//	Create a Webdriver Constructor
	
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		


	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	
	
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignButn;
	
	@FindBy(xpath = "//button[text()='Select']\"")
	private WebElement selectBtn;
	

//	 create a getter for all Data Members of Campaign

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaignButn() {
		return createCampaignButn;
	}
	
	
	public void createCampinWithoutDate(String campName, String targSize) {
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(targSize);
		createCampaignButn.click();		
		
	}

	public void createCampinWithDate(String campName, String targSize, String date) {
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(targSize);
		expectedCloseDate.sendKeys(date);
		createCampaignButn.click();		
		
	}
	
	
	

	
	

		
}
