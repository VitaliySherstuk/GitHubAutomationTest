import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.generator.GeneratorClass;
import by.htp.steps.Steps;

public class TestClassFour {

	private Steps steps;
	private final String USER = GeneratorClass.generateWord(6);
	private final String EMAIL = GeneratorClass.generateWord(5)+ "@yopmail.com";
	private final String PASSWORD = "A1`~!@#$%^&*()_+=-':;'/|?><.,";
	private final String HEADER_LOGINED = "Welcome to GitHub";
	private final String HEADER_USER = "@" + USER;
	private final String PERSONAL_INFORMATION = GeneratorClass.generatorSentence(30);
	private final String BUTTON_READ_GUIDE = "Read the guide";
	private final String BUTTON_START_PROJECT = "Start a project";
	private final String HEADER_TITLE_REPOSITORY = "Please verify your email address";
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test(priority=1)
	public void checkPasswordContainsSymbols()
	{
		steps.createNewUser(USER, EMAIL, PASSWORD);
		Assert.assertTrue(steps.isLoginedIsStepOne(HEADER_LOGINED, HEADER_USER));
	}
	
	@Test(priority=2)
	public void checkLoginingAddPersonalInformation()
	{
		steps.isEndLoginedAddPersonalInformation(PERSONAL_INFORMATION, BUTTON_READ_GUIDE, BUTTON_START_PROJECT, USER);
	}
	
	@Test(priority=3)
	public void checkCreateNewReposiry()
	{
		steps.isCreateNewRepository(HEADER_TITLE_REPOSITORY);
	}
	
	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
	
}
