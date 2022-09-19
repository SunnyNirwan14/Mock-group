package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	public static String captureScreenshot(WebDriver driver) throws IOException
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		LocalDateTime ldt=LocalDateTime.now();
		String datetime=dtf.format(ldt);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="D:\\Screenshot\\POM\\"+datetime+".jpg";
		File dest=new File(path);
		//FileHandler.copy(source, dest);
		FileUtils.copyFile(source, dest);
		return path;
	}

}
