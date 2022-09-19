package testPackage1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassB
{
	
	static WebDriver driver;
	@BeforeClass
	public void beforeclassB() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	}
	
	@BeforeMethod
	public void beforemethodB()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=0)
	public void VerifyAdmin()
	{
		WebElement Admin=driver.findElement(By.xpath("//span[text()='Admin']"));
		Admin.click();
	}
	
	@Test(priority=1)
	public void VerifyPIM()
	{
		WebElement PIM=driver.findElement(By.xpath("//span[text()='PIM']"));
		PIM.click();
	}
	
	@Test(priority=2)
	public void VerifyLeave()
	{
		WebElement Leave=driver.findElement(By.xpath("//span[text()='Leave']"));
		Leave.click();
	}
	
	@AfterMethod
	public void aftermethodB()
	{
		
	}
	
	

}
