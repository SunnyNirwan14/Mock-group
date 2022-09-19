package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Pojo 
{
	public WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","src"+File.separator+"test"+File.separator+"resources"+File.separator+"Driver"+File.separator+"chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		return driver;
	}
	
	public WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","src"+File.separator+"test"+File.separator+"resources"+File.separator+"Driver"+File.separator+"msedgedriver.exe");
		
		WebDriver driver=new EdgeDriver();
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		return driver;
	}

}
