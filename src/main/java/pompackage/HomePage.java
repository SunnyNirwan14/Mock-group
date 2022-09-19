package pompackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriverWait wait;
	
	@FindBy (xpath="//*[text()='Admin']")
	private WebElement admin;
	
	@FindBy (xpath="//*[text()='PIM']")
	private WebElement PIM;
	
	@FindBy (xpath="//*[text()='Leave']")
	private WebElement leave;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	private WebElement Search;
	
	public HomePage(WebDriver driver)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAdminTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']")));
		boolean result=admin.isDisplayed();
		admin.click();
		return result;
	}
	
	public boolean verifyPIMTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PIM']")));
		boolean result=PIM.isDisplayed();
		PIM.click();
		return result;
	}
	
	public boolean verifyLeaveTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Leave']")));
		boolean result=leave.isDisplayed();
		leave.click();
		return result;
	}
	
	public boolean verifySearchBar(String s)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		boolean result=Search.isDisplayed();
		Search.sendKeys(s);
		return result;
	}
	
	
	
	
	
	
	

}
