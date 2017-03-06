import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.generator.GeneratorClass;
import by.htp.steps.Steps;

public class TestClassFive {

	private Steps steps;
	private final String USER = "j3j*5-i$h7";
	private final String USER_SPACE = " ";
	private final String EMAIL = GeneratorClass.generateWord(5)+ "@yopmail.com";
	private final String PASSWORD = "Aa12345";
	private final String ERROR = "There were problems creating your account.";
	private final String ERROR_TEXT_FOBIDEN_SYMBOL = "Login may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen";
	private final String ERROR_TEXT_SPACE_SYMBOL = "Login can't be blank";
	private final String USER_LIMIT = GeneratorClass.generateWord(40);
	
	@BeforeClass
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	
	@Test
	public void checkUsernameForbiddenSymbol()
	{
		steps.createNewUser(USER, EMAIL, PASSWORD);
		Assert.assertTrue(steps.isErrorForbiddenSymbol(ERROR, ERROR_TEXT_FOBIDEN_SYMBOL));
		
	}
	
	@Test
	public void checkUsernameSpaceSymbol()
	{
		steps.createNewUser(USER_SPACE, EMAIL, PASSWORD);
		Assert.assertTrue(steps.isErrorForbiddenSymbol(ERROR, ERROR_TEXT_SPACE_SYMBOL));
	}
	

	
	
	@AfterClass
	public void finishWork()
	{
		steps.closeDriver();
	}
	
}
