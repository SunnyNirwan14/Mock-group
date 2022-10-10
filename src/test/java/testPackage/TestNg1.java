package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pompackage.HomePage;
import pompackage.LogInPage;
import utility.ImportData;
import utility.Pojo;
import utility.Screenshot;
import utility.Waits;

public class TestNg1 extends Pojo
{
	static WebDriver driver;
	SoftAssert soft=new SoftAssert();
	ExtentReports extent;
	ExtentTest logger;
	
	
	@BeforeClass
	public void beforeclassA()
	{
		WebDriver driver=openChromeBrowser();
		this.driver=driver;
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/Newreport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		logger=extent.createTest("VerifyLoginPage");
		logger=extent.createTest("VerifyLoginPage");
	}
	
	@BeforeMethod
	public void beforemethodA()
	{
		
		//Waits.applyImpliciteWait(driver);
	}
	
	
	@Test(priority=0)
	public void VerifyLoginPage() throws IOException 
	{
		String ActualURL=driver.getCurrentUrl();
		System.out.println(ActualURL);
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(ActualURL,ExpectedURL);
		
		LogInPage login = new LogInPage(driver);
		login.sendUserName(ImportData.importExcelData(1,0));
		login.sendpassword(ImportData.importExcelData(1,1));
		login.clickOnLoginButton();
		//Screenshot.captureScreenshot(driver);
		
		
		String afterURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		Assert.assertNotEquals(ActualURL, afterURL);
		
		
	}
	
	
	@Test(priority=1)
	public void VerifyHomePage() throws EncryptedDocumentException, IOException
	{
		String ActualURLhome=driver.getCurrentUrl();
		String ExpectedURLhome="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		soft.assertEquals(ActualURLhome, ExpectedURLhome);
		HomePage home=new HomePage(driver);
		boolean result=home.verifyAdminTab();
		soft.assertTrue(result);	//fail
		boolean result1=home.verifyPIMTab();
		soft.assertTrue(result1);	
		boolean result2=home.verifyLeaveTab();
		soft.assertTrue(result2);
		home.verifySearchBar(ImportData.importExcelData(2,0));
		//src.captureScreenshot(driver);
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String path=Screenshot.captureScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		extent.flush();
	}
	
	@AfterClass
	public void close() 
	{
		driver.quit();
		
	}
	
	
	
	

}
