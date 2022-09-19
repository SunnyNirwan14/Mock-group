package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits 
{
	//static WebDriver driver1;
	
	
	public static void applyImpliciteWait(WebDriver driver)
	{
		//this.driver1=driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}
	
	public static void applyExplicitWait(String xpath,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
		
	}
	
	public void applyFluentWait()
	{
		
	}

}
