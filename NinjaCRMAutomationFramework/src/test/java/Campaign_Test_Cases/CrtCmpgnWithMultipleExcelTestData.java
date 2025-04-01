
package Campaign_Test_Cases;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.ExcelFileUtility;
import GenericFileUtility.PropertiesFileUtility;
import GenericJavaUtility.JavaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.LogOutPage;
import ObjectRepository.LoginPage;
import ObjectRepository.dashboardPage;
import genericListenerUtility.ListenerImp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
@Listeners(ListenerImp.class)
public class CrtCmpgnWithMultipleExcelTestData extends BaseClass{
	@Test
	public void Create_Campaign_WithCloseDate_TC1() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		JavaUtility javaUtil = new JavaUtility();
		int RandomNum = javaUtil.getRandomNum(5000);

		String closeDate = javaUtil.getRequiredDate(20);

		ExcelFileUtility getExcelDat = new ExcelFileUtility();
		String campName = getExcelDat.getDataFromExcel("Sheet1", 1, 0) + RandomNum;
		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Thread.sleep(2000);

		
		dashboardPage dashBdPage = new dashboardPage(driver);
		dashBdPage.getCampaignLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
		createCampaign.createCampinWithDate(campName, targetSize, closeDate);
		Thread.sleep(2000);
		campaign.displayCampaignMessage(campName);
		Thread.sleep(5000);
		

	

	}

	@Test()
	public void createCampaignWithout_CloseDate_TC2() throws IOException, InterruptedException {

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");
		JavaUtility javaUtil = new JavaUtility();
		int RandomNum = javaUtil.getRandomNum(1000);
		
		ExcelFileUtility getExcelDat = new ExcelFileUtility();
		String campName = getExcelDat.getDataFromExcel("Sheet1", 1, 0) + RandomNum;
		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("Fireforx")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(2000);

		LoginPage login = new LoginPage(driver);
		login.LongIn(USERNAME, PASSWORD);
		dashboardPage dashBdPage = new dashboardPage(driver);
		dashBdPage.getCampaignLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
		createCampaign.createCampinWithoutDate(campName, targetSize);
		Thread.sleep(2000);
//		campaign.displayCampaignMessage(campName);
		String confMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(5000);
		boolean status = confMsg.contains(campName);
		Assert.assertEquals(status, true);
		System.out.println(status);
		dashBdPage.logOut();
		
		driver.quit();
	}


	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelFileUtility getExcelDat = new ExcelFileUtility();
	Object[][] objArray = new Object[6][2];
		objArray[0][0] = getExcelDat.getDataFromExcel("Sheet1", 1, 0);
		objArray[0][1] = getExcelDat.getDataFromExcel("Sheet1", 1, 1);	
		objArray[1][0] = getExcelDat.getDataFromExcel("Sheet1",2, 0);
		objArray[1][1] = getExcelDat.getDataFromExcel("Sheet1", 2, 1);
		objArray[2][0] = getExcelDat.getDataFromExcel("Sheet1", 3, 0);
		objArray[2][1] = getExcelDat.getDataFromExcel("Sheet1", 3, 1);
		objArray[3][0] = getExcelDat.getDataFromExcel("Sheet1", 4, 0);
		objArray[3][1] = getExcelDat.getDataFromExcel("Sheet1", 4, 1);
		objArray[4][0] = getExcelDat.getDataFromExcel("Sheet1", 5, 0);
		objArray[4][1] = getExcelDat.getDataFromExcel("Sheet1", 5, 1);
		objArray[5][0] = getExcelDat.getDataFromExcel("Sheet1", 6, 0);
		objArray[5][1] = getExcelDat.getDataFromExcel("Sheet1", 6, 1);
		
		return objArray;
	

	}
}

