import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.generator.GeneratorClass;
import by.htp.steps.Steps;

public class TestClassThree {

	private Steps steps;
	private final String USER = GeneratorClass.generateWord(8);
	private final String EMAIL = GeneratorClass.generateWord(5)+ "@yopmail.com";
	private final String PASSWORD_MAX_SIZE = GeneratorClass.generateWord(72);
	private final String HEADER_LOGINED = "Welcome to GitHub";
	private final String HEADER_USER = "@" + USER;
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test
	public void checkEnterMaxSizePassword()
	{
		steps.createNewUser(USER, EMAIL, PASSWORD_MAX_SIZE);
		Assert.assertTrue(steps.isLoginedIsStepOne(HEADER_LOGINED, HEADER_USER));
		
	}
	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
}
