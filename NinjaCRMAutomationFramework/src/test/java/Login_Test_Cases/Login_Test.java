package Login_Test_Cases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericFileUtility.PropertiesFileUtility;
import ObjectRepository.LoginPage;

public class Login_Test extends BaseClass {
@Test(groups = "smokeTest")
	public void logIn_Test_TC1Test() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String expectedUrl = "http://49.249.28.218:8098/dashboard";
		
		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER =  propUtil.getDataFromPropFile("browser");
		String URL =  propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(PASSWORD);
		System.out.println(USERNAME);

	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		String dashBoardUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(dashBoardUrl, expectedUrl);
//		System.out.println(dashBoardUrl);
//		if (expectedUrl.equals(dashBoardUrl)) {
//			System.out.println("Test Validation is pass");
//		} else {
//			System.out.println("Test Validation is failed");
//
//		}	

		
		Thread.sleep(2000);
		
		

	}

}
