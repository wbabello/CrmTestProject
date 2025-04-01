package genericListenerUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import GenericBaseClassUtility.BaseClass;

public class ListenerImp implements ITestListener, ISuiteListener {
	
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;	

//	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("HH-mm-ss");
		String time= sim.format(date);
		System.out.println(time);
		
		
		spark = new ExtentSparkReporter("./ExtReports/report"+time+ ".html");		
		System.out.println("File created");
		spark.config().setDocumentTitle("CRM Test Suite Reports");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and created Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
				
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		Date date = new Date();
		SimpleDateFormat sim =  new SimpleDateFormat("HH-mm-ss");
		String time = sim.format(date);
		System.out.println(time);
		
	}

	

	@Override
	public void onTestStart (ITestResult result) {
	System.out.println(result.getMethod().getMethodName() + "Starts ");
	test = report.createTest(result.getMethod().getMethodName());
	test.log(Status.INFO, result.getMethod().getMethodName()+ "==>Started<===");
	
	
			
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + "ends ");
		test.log(Status.PASS, result.getMethod().getMethodName()+ "==>Completed<===");
		
		
	}
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
	
		String testCaseName = result.getMethod().getMethodName();
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("HH-mm-ss");
		String time = sim.format(date);
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);	
		File dest = new File("./screenshots/"+testCaseName+"_"+ time+ ".png");
		test.addScreenCaptureFromBase64String(temp,"Failed"+testCaseName);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==>Failed<==");
		
	
		
		
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();		

	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}


	

}
