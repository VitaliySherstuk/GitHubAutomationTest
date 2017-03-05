import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.steps.Steps;


public class TestClassTwo {

	private Steps steps;
	private final String HEADER = "create your personal account";
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test
	public void testTest()
	{
		Assert.assertTrue(steps.clickSignUp(HEADER));
	}
	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
}
