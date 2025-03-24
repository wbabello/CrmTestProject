package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProductPage {

	WebDriver driver;

	public CreateProductPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(name = "price")
	private WebElement price;

	@FindBy(name = "productCategory")
	private WebElement productCategory;

	@FindBy(xpath = "//select[@name='vendorId']")
	private WebElement selectVendor;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addPrdBtn;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getAddPrdBtn() {
		return addPrdBtn;
	}

	public void addNewProduct(String prdName, String qty, String prodPrice, String category, String vendor) {
		productName.sendKeys(prdName);
		quantity.sendKeys(qty);
		price.sendKeys(prodPrice);
		Select select = new Select(productCategory);
		select.selectByIndex(2);
		Select vendOption = new Select(selectVendor);
		vendOption.selectByIndex(3);
		addPrdBtn.click();
		
				
		

	}

}
