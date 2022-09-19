package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg3 
{
	@BeforeClass
	public void beforeclassC()
	{
		System.out.println("beforeclassC");
	}
	
	@BeforeMethod
	public void beforemethodC()
	{
		System.out.println("beforemethodC");
	}
	
	
	@Test
	public void testB()
	{
		System.out.println("testB");
	}
	
	@Test(dependsOnMethods={"testA","testB"})
	public void testC()
	{
		System.out.println("testC");
		
	}
	
	@Test
	public void testA()
	{
		System.out.println("testA");
	}
	
	@AfterMethod
	public void aftermethodC()
	{
		System.out.println("aftermethodC");
	}
	
	
	@AfterClass
	public void afterclassC() 
	{
		System.out.println("afterclassC");
	}

}
