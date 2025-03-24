package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCampaignPage {
	
	WebDriver driver;

	public SelectCampaignPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	@FindBy(id="search-criteria")
	private WebElement cmpgSearchCriteria;

	@FindBy(xpath = "//option[text()='Campaign ID']")
	private WebElement cmpgSearchById;
	
	@FindBy(xpath = "//option[text()='Campaign Name']")
	private WebElement cmpgSearchByName;
	
	
	
	
	
}
