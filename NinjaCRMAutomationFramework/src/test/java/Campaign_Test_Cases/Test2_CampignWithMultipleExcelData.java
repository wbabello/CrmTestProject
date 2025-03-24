//
//package Campaign_Test_Cases;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import GenericFileUtility.ExcelFileUtility;
//import GenericFileUtility.PropertiesFileUtility;
//import GenericJavaUtility.JavaUtility;
//import ObjectRepository.CampaignPage;
//import ObjectRepository.CreateCampaignPage;
//import ObjectRepository.LogOutPage;
//import ObjectRepository.LoginPage;
//import ObjectRepository.dashboardPage;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class Test2_CampignWithMultipleExcelData {
//	@Test
//	public void Create_Campaign_WithCloseDate_TC1() throws IOException, InterruptedException {
//		// TODO Auto-generated method stub
//
//		PropertiesFileUtility propUtil = new PropertiesFileUtility();
//		String BROWSER = propUtil.getDataFromPropFile("browser");
//		String URL = propUtil.getDataFromPropFile("url");
//		String PASSWORD = propUtil.getDataFromPropFile("password");
//		String USERNAME = propUtil.getDataFromPropFile("uname");
//
//		JavaUtility javaUtil = new JavaUtility();
//		int RandomNum = javaUtil.getRandomNum(1000);
//
//		String closeDate = javaUtil.getRequiredDate(20);
//
//		ExcelFileUtility getExcelDat = new ExcelFileUtility();
////		String campName = getExcelDat.getDataFromExcel("Sheet1", 1, 0) + RandomNum;
////		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);
//
//		WebDriver driver = null;
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("Fireforx")) {
//			driver = new FirefoxDriver();
//
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.manage().window().maximize();
//		driver.get(URL);
//		Thread.sleep(2000);
//
//		LoginPage login = new LoginPage(driver);
//		login.LongIn(USERNAME, PASSWORD);
//		dashboardPage dashBdPage = new dashboardPage(driver);
//		dashBdPage.getCampaignLink().click();
//		CampaignPage campaign = new CampaignPage(driver);
//		campaign.getCreateCampaign().click();
//		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
//		createCampaign.createCampinWithDate(campName, targetSize, closeDate);
//		Thread.sleep(2000);
//		campaign.displayCampaignMessage(campName);
//		Thread.sleep(5000);
//		dashBdPage.logOut();
//
//		driver.quit();
//
//	}
//
//	@Test(dataProvider = "getData")
//	public void createCampaignWithout_CloseDate_TC2(String campName, String targetSize) throws IOException, InterruptedException {
//
//		PropertiesFileUtility propUtil = new PropertiesFileUtility();
//		String BROWSER = propUtil.getDataFromPropFile("browser");
//		String URL = propUtil.getDataFromPropFile("url");
//		String PASSWORD = propUtil.getDataFromPropFile("password");
//		String USERNAME = propUtil.getDataFromPropFile("uname");
//		JavaUtility javaUtil = new JavaUtility();
//		int RandomNum = javaUtil.getRandomNum(1000);
////		ExcelFileUtility getExcelDat = new ExcelFileUtility();
////		String campName = getExcelDat.getDataFromExcel("Sheet1", 1, 0) + RandomNum;
////		String targetSize = getExcelDat.getDataFromExcel("Sheet1", 1, 1);
//
//		WebDriver driver = null;
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("Fireforx")) {
//			driver = new FirefoxDriver();
//
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.manage().window().maximize();
//		driver.get(URL);
//		Thread.sleep(2000);
//
//		LoginPage login = new LoginPage(driver);
//		login.LongIn(USERNAME, PASSWORD);
//		dashboardPage dashBdPage = new dashboardPage(driver);
//		dashBdPage.getCampaignLink().click();
//		CampaignPage campaign = new CampaignPage(driver);
//		campaign.getCreateCampaign().click();
//		CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
//		createCampaign.createCampinWithoutDate(campName, targetSize);
//		Thread.sleep(2000);
//		campaign.displayCampaignMessage(campName);
//		Thread.sleep(5000);
//		dashBdPage.logOut();
//		
//		driver.quit();
//
//	}
//
//	 @DataProvider(name = "getData")
//	    public Object[][] getData() throws IOException {
//	        String filePath = "src/test/resources/TestData.xlsx";  // Path to Excel file
//	        FileInputStream file = new FileInputStream(filePath);
//	        Workbook workbook = new XSSFWorkbook(file);
//	        Sheet sheet = workbook.getSheet("Sheet1");
//
//	        i2
//
//	        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row
//
//	        for (int i = 1; i < rowCount; i++) { // Start from row 1 (excluding header)
//	            Row row = sheet.getRow(i);
//	            for (int j = 0; j < colCount; j++) {
//	                Cell cell = row.getCell(j);
//	                data[i - 1][j] = cell.toString(); // Store cell values
//	            }
//	        }
//
//	        workbook.close();
//	        return data;
//	    }
//	
//	}
//
//}
//
