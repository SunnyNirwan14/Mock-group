package pompackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage
{
	static WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy (xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()=' Login ']")
	private WebElement LoginButton;
	
	
	public LogInPage(WebDriver driver)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String s)
	{
		//Waits.applyExplicitWait("//input[@name='username']",driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		userName.sendKeys(s);
	}
	
	public void sendpassword(String s)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
		password.sendKeys(s);
	}
	
	public void clickOnLoginButton()
	{
		LoginButton.click();
	}

}
