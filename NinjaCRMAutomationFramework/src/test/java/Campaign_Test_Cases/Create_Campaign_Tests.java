
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

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
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

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;

public class Create_Campaign_Tests extends BaseClass {
	@Test()
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
		driver.manage().window().maximize();
		Thread.sleep(2000);
		dashboardPage dashBdPage = new dashboardPage(driver);
		dashBdPage.getCampaignLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
		createCampaign.createCampinWithDate(campName, targetSize, closeDate);
		Thread.sleep(2000);
//		campaign.displayCampaignMessage(campName);
		String confMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();

		Thread.sleep(5000);

		boolean status = confMsg.contains(campName);
		Assert.assertEquals(status, true);
		System.out.println(status);
		

		
	}

	@Test()
	public void createCampaignWithout_CloseDate_TC2() throws IOException, InterruptedException {

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		JavaUtility javaUtil = new JavaUtility();
		int RandomNum = javaUtil.getRandomNum(5000);

		ExcelFileUtility getExcelDat = new ExcelFileUtility();
		String campName = getExcelDat.getDataFromExcel("Sheet1", 1, 0) + RandomNum;
		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		
		dashboardPage dashBdPage = new dashboardPage(driver);
		dashBdPage.getCampaignLink().click();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateCampaign().click();
		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
		createCampaign.createCampinWithoutDate(campName, targetSize);
		Thread.sleep(2000);
		campaign.displayCampaignMessage(campName);
		Thread.sleep(5000);
		


	}

}

//====================

////				TC2- Verify that User Navigate to the Contact Dashboard through the Contact Navigational Link
//				
//				driver.findElement(By.id("username")).sendKeys("rmgyantra");// Input userName
//				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");// input password
//				driver.findElement(By.xpath("//button[text()='Sign In']")).click(); // click on sign-in button
//				Thread.sleep(2000);
//				driver.findElement(By.linkText("Campaigns")).click();
//				Thread.sleep(2000);		
//				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
//				driver.findElement(By.name("campaignName")).sendKeys("List Campaign 105");
//				driver.findElement(By.name("targetSize")).sendKeys("5");
//				driver.findElement(By.name("expectedCloseDate")).sendKeys("05/03/2025");
//				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
//				Thread.sleep(2000);
//				WebElement getCampaingMsg = driver.findElement(By.xpath("//div[@role='alert']"));
//				String msgVal = getCampaingMsg.getText();
//				if(msgVal.contains("List Campaign 105")) {
//					System.out.println("Test is passed");			
//					
//				} else {
//					System.out.println("Test is failed");
//				}
//				Thread.sleep(5000);
//				
//				driver.findElement(By.xpath("//*[name()='svg' and @role='img']")).click();
//				driver.findElement(By.xpath("//div[text()='Logout ']")).click();
//				Thread.sleep(2000);
//				driver.quit();
//					
//	
