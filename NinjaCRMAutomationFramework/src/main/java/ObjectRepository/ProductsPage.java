package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchProduct;
	
	@FindBy(xpath = "//input[@placeholder='Search by product Id']")
	private WebElement searchInputById;
	
	@FindBy(xpath = "//input[@placeholder='Search by product Name']")
	private WebElement searchInputByName;
	
	@FindBy(xpath = "//button[text()='Select']")
	private WebElement selectBtn;
	
	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProductBtn;


	public WebElement getSearchProduct() {
		return searchProduct;
	}

	public WebElement getSearchInputById() {
		return searchInputById;
	}

	public WebElement getSearchInputByName() {
		return searchInputByName;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}
	
	
//	Method to create add a Product
	
	public void addProduct() {
		addProductBtn.click();
		
	}
	
	


	
	
}
