package Contact_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericFileUtility.ExcelFileUtility;
import GenericFileUtility.PropertiesFileUtility;
import GenericJavaUtility.JavaUtility;
import GenericWebDriverUtility.WebDriverUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductsPage;
import ObjectRepository.dashboardPage;
import genericListenerUtility.ListenerImp;


@Listeners(ListenerImp.class)
public class CreatE_ContactWithCampaignTest extends BaseClass {

	@Test(groups = "regressionTest")

	public void createContactWithCampaignTest() throws IOException, InterruptedException {

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		JavaUtility javaUtil = new JavaUtility();
		int RandomNum = javaUtil.getRandomNum(5000);

		WebDriverUtility webDriverUtil = new WebDriverUtility();

		ExcelFileUtility getExcelDat = new ExcelFileUtility();
		String organizationName = getExcelDat.getDataFromExcel("Sheet2", 2, 0) + RandomNum;
		String contactName = getExcelDat.getDataFromExcel("Sheet2", 1, 1) + RandomNum;
		String mobile = getExcelDat.getDataFromExcel("Sheet2", 3, 2);
		String title = getExcelDat.getDataFromExcel("Sheet2", 1, 3);
		String campName = getExcelDat.getDataFromExcel("Sheet1", 0, 1) + RandomNum;
		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);

	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	
		Thread.sleep(2000);

		Thread.sleep(2000);
		dashboardPage dash = new dashboardPage(driver);
		dash.getCampaignLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		Thread.sleep(2000);
		CreateCampaignPage newCampaign = new CreateCampaignPage(driver);
		newCampaign.createCampinWithoutDate(campName, targetSize);
		Thread.sleep(5000);
		dash.getContactsLink().click();
		Thread.sleep(2000);
		ContactsPage contact = new ContactsPage(driver);
		contact.CreateNewContact();
		Thread.sleep(2000);
		CreateContactPage createContact = new CreateContactPage(driver);

		createContact.createContactWithCampaign(organizationName, contactName, mobile, title, "selectCampaign",
				"create-contact", campName);
		Thread.sleep(1000);

		String ConfirmationMsg = driver.findElement(By.xpath("//div[text()='Contact " + contactName + " Successfully Added']")).getText();

		boolean status = ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true);		
		Thread.sleep(5000);

		System.out.println("TestCase3 Created Successfull");

	}

}
