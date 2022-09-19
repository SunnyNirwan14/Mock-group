package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pompackage.HomePage;
import pompackage.LogInPage;
import utility.ImportData;
import utility.Pojo;
import utility.Waits;

public class TestNg2 extends Pojo
{
	static WebDriver driver;
	Waits wait=new Waits();
	SoftAssert soft=new SoftAssert();
	
	@BeforeClass
	public void beforeclassB()
	{
		WebDriver driver=openEdgeBrowser();
		this.driver=driver;
	}
	
	@BeforeMethod
	public void beforemethodB()
	{
		//wait.applyImpliciteWait(driver);
	}
	
	
	@Test(priority=-1)
	public void testB() throws EncryptedDocumentException, IOException
	{
		String ActualURL=driver.getCurrentUrl();
		System.out.println(ActualURL);
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(ActualURL,ExpectedURL);
		
		LogInPage login = new LogInPage(driver);
		login.sendUserName(ImportData.importExcelData(1, 0));
		login.sendpassword(ImportData.importExcelData(1, 1));
		login.clickOnLoginButton();
		String afterURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		Assert.assertNotEquals(ActualURL, afterURL);
	}
	
	@Test(priority=1)
	public void testC() throws EncryptedDocumentException, IOException
	{
		String ActualURLhome=driver.getCurrentUrl();
		String ExpectedURLhome="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		soft.assertEquals(ActualURLhome, ExpectedURLhome);
		HomePage home=new HomePage(driver);
		boolean result=home.verifyAdminTab();
		soft.assertTrue(result);
		boolean result1=home.verifyPIMTab();
		soft.assertTrue(result1);
		boolean result2=home.verifyLeaveTab();
		soft.assertTrue(result2);
		home.verifySearchBar(ImportData.importExcelData(2, 0));
		//src.captureScreenshot(driver);
		soft.assertAll();
	}
	
	
	
	
	@AfterClass
	public void afterclassB() 
	{
		driver.quit();
	}

}
