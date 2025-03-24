package GenericBaseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import GenericFileUtility.ExcelFileUtility;
import GenericFileUtility.PropertiesFileUtility;
import GenericJavaUtility.JavaUtility;
import GenericWebDriverUtility.UtilityClassObject;
import GenericWebDriverUtility.WebDriverUtility;
import ObjectRepository.LoginPage;
import ObjectRepository.dashboardPage;

public class BaseClass {

	public PropertiesFileUtility fLib = new PropertiesFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility Wlib = new WebDriverUtility();
	public ExcelFileUtility exl = new ExcelFileUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("Established the Database Connection");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Configuration setup started");
	}



	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
	}



	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Login");
		String URL = fLib.getDataFromPropFile("url");
		String PASSWORD = fLib.getDataFromPropFile("password");
		String USERNAME = fLib.getDataFromPropFile("uname");
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.LongIn(USERNAME, PASSWORD);

	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("Close DB Connection");
	}

	@AfterClass
	public void afterClass() {
		
		sdriver.quit();
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("Log-out");		
		dashboardPage dash = new dashboardPage(driver);
		dash.logOut();
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Configuration setup ended");
		
	}

}
