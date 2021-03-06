import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.generator.GeneratorClass;
import by.htp.steps.Steps;


public class TestClassTwo {

	private Steps steps;
	private final String USER_MAX_SIZE = GeneratorClass.generateWord(39);
	private final String EMAIL = GeneratorClass.generateWord(5)+ "@yopmail.com";
	private final String PASSWORD = "Aa12345";
	private final String HEADER_USER = "@" + USER_MAX_SIZE;
	private final String HEADER_LOGINED = "Welcome to GitHub";
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	
	@Test
	public void checkEnterMaxSizeUsername()
	{
		steps.createNewUser(USER_MAX_SIZE, EMAIL, PASSWORD);
		Assert.assertTrue(steps.isLoginedIsStepOne(HEADER_LOGINED, HEADER_USER));
		
	}
	

	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
}
