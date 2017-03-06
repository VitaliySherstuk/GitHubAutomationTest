import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.generator.GeneratorClass;
import by.htp.steps.Steps;

public class TestClassOne {

	private Steps steps;
	private final String HEADER = "create your personal account";
	private final String HEADER_LOGINED = "Welcome to GitHub";
	private final String PARAGRAPH_TEXT_STEP_THREE = "opportunities";
	private final String HEADER_TEXT_STEP_THREE = "How would you describe your level of programming experience?";
	private final String LINK_TEXT = "skip this step";
	private final String USER = GeneratorClass.generateWord(5);
	private final String EMAIL = GeneratorClass.generateWord(5)+ "@yopmail.com";
	private final String PASSWORD = "Aa1234567";
	private final String HEADER_USER = "@" + USER;
	private final String BUTTON_READ_GUIDE = "Read the guide";
	private final String BUTTON_START_PROJECT = "Start a project";
	private final String LINK_AUTORISATION = "Sign in";
	private final String LINK_REGISTRATION = "Sign up";
	private final String BUTTON_REGISTRATION = "Sign up for GitHub";
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test(priority=1)
	public void checkSignUp()
	{
		Assert.assertTrue(steps.clickSignUp(HEADER));
		
	}
	
	@Test(priority=2)
	public void checkLoginingStepOne()
	{
		steps.createNewUser(USER, EMAIL, PASSWORD);
		Assert.assertTrue(steps.isLoginedIsStepOne(HEADER_LOGINED, HEADER_USER));
		
		
	}
	
	@Test(priority=3)
	public void checkLoginingStepTwo()
	{
		Assert.assertTrue(steps.isLoginedIsStepTwo(LINK_TEXT));
	}
	
	@Test(priority=4)
	public void checkLoginingStepThree()
	{
		Assert.assertTrue(steps.isEndLogined(BUTTON_READ_GUIDE, BUTTON_START_PROJECT, USER));
	}
	
	@Test(priority=5)
	public void checkSignOut()
	{
		Assert.assertTrue(steps.clickSignOutPageDashboard(LINK_AUTORISATION, "LINK_REGISTRATION", BUTTON_REGISTRATION));
	}
	
	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
}
