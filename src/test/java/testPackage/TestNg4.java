package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg4
{
	@BeforeClass
	public void beforeclassD()
	{
		System.out.println("beforeclassD");
	}
	
	@BeforeMethod
	public void beforemethodD()
	{
		System.out.println("beforemethodD");
	}
	
	
	@Test(priority=-1)
	public void testB()
	{
		System.out.println("testB");
	}
	
	@Test
	public void testC()
	{
		System.out.println("testC");
	}
	
	@Test(priority=1)
	public void testA()
	{
		System.out.println("testA");
	}
	
	@AfterMethod
	public void aftermethodD()
	{
		System.out.println("aftermethodD");
	}
	
	
	@AfterClass
	public void afterclassD() 
	{
		System.out.println("afterclassD");
	}

}
