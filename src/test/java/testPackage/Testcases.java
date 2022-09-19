package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pompackage.HomePage;
import pompackage.LogInPage;
import utility.ImportData;




public class Testcases 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		//(Verify login functionality)
		
		LogInPage login=new LogInPage(driver);
		login.sendUserName(ImportData.importExcelData(1,0));
		login.sendpassword(ImportData.importExcelData(1,1));
		login.clickOnLoginButton();
		
		
		//(Verify home page)
		
		HomePage home=new HomePage(driver);
		home.verifyAdminTab();
		home.verifyPIMTab();
		home.verifyLeaveTab();
		
	}

}
