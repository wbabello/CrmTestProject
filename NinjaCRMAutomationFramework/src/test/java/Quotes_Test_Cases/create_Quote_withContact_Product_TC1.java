package Quotes_Test_Cases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.PropertiesFileUtility;

public class create_Quote_withContact_Product_TC1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		PropertiesFileUtility propUtil = new PropertiesFileUtility();
		String BROWSER = propUtil.getDataFromPropFile("browser");
		String URL = propUtil.getDataFromPropFile("url");
		String PASSWORD = propUtil.getDataFromPropFile("password");
		String USERNAME = propUtil.getDataFromPropFile("uname");

		Random random = new Random();
		int randNumb = random.nextInt(1000);

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		Thread.sleep(2000);

		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Quotes")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Create Quote']")).click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
