package testPackage1;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class TestclassA 
{
	static WebDriver driver;
	@BeforeClass
	public void beforeclass()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test(priority=0)
	public void VerifyLoginPage() throws EncryptedDocumentException, IOException
	{
		String ActualURL=driver.getCurrentUrl();
		System.out.println(ActualURL);
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(ActualURL,ExpectedURL);
		
		LogInPage login = new LogInPage(driver);
		login.sendUserName(ImportData.importExcelData(1,0));
		login.sendpassword(ImportData.importExcelData(1,1));
		login.clickOnLoginButton();
		String afterURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		Assert.assertNotEquals(ActualURL, afterURL);
	}
	
	@Test(priority=1)
	public void VerifyHomePage()
	{
		HomePage home=new HomePage(driver);
		boolean result=home.verifyAdminTab();
		home.verifyPIMTab();
		home.verifyLeaveTab();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(result);
		soft.assertAll();
		
	}
	
	
	

}
