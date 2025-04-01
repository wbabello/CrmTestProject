package Product_Test_Cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericFileUtility.ExcelFileUtility;
import GenericFileUtility.PropertiesFileUtility;
import GenericJavaUtility.JavaUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.ProductsPage;
import ObjectRepository.dashboardPage;
import genericListenerUtility.ListenerImp;


@Listeners(ListenerImp.class)
public class CreateProductTest extends BaseClass {
@Test(groups = "regressionTest")
	public void createProductTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		JavaUtility javaUtil = new JavaUtility();
		int RandomNum = javaUtil.getRandomNum(5000);

		ExcelFileUtility getExcelDat = new ExcelFileUtility();

		String productName = getExcelDat.getDataFromExcel("Sheet3", 1, 0) + RandomNum;

		String quantity = getExcelDat.getDataFromExcel("Sheet3", 1, 1);
		String price = getExcelDat.getDataFromExcel("Sheet3", 1, 2);
		String productCategory = getExcelDat.getDataFromExcel("Sheet3", 1, 3);
		String vendorId = getExcelDat.getDataFromExcel("Sheet3", 1, 4);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		dashboardPage dashBd = new dashboardPage(driver);
		Thread.sleep(2000);
		dashBd.getProductsLink().click();
		ProductsPage proD = new ProductsPage(driver);
		proD.addProduct();
		Thread.sleep(2000);
		CreateProductPage newProduct = new CreateProductPage(driver);
		newProduct.addNewProduct(productName, quantity, price, productCategory, vendorId);
		Thread.sleep(5000);
		String ConfirmationMsg = driver.findElement(By.xpath("//div[text()='Product " + productName + " Successfully Added']")).getText();
		boolean status = ConfirmationMsg.contains(productName);
		Assert.assertEquals(status, true);
		Thread.sleep(5000);

		System.out.println("TestCase4 Created Successfull");
		

	}

}
