package by.htp.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import by.htp.driver.DriverSingleton;
import by.htp.pages.HomePage;
import by.htp.pages.LoginPageDashboard;
import by.htp.pages.LoginPageStepOne;
import by.htp.pages.LoginPageStepThree;
import by.htp.pages.LoginPageStepTwo;
import by.htp.pages.PageFinishCreateRepository;
import by.htp.pages.PageJoin;

public class Steps {

	private WebDriver driver;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}
	
	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}
	
	public void loadHomePage()
	{
		HomePage homePage = new HomePage(driver);
		homePage.openPage();
	}
	
	public boolean clickSignUp(String header)
	{
		HomePage homePage = new HomePage(driver);
		homePage.openPage();
		homePage.clickLinkSignUp();
		LoginPageStepOne loginPage = new LoginPageStepOne(driver);
		return (loginPage.getHeaderTitleCreate().trim().toLowerCase().equals(header));
	}
	
	public void createNewUser(String userName, String userEmailAddres, String userPassword)
	{
		LoginPageStepOne stepOne = new LoginPageStepOne(driver);
		stepOne.openPage();
		stepOne.logining(userName, userEmailAddres, userPassword);
		stepOne.clickButtonCreateAccount();
	}
	
	
	
	public boolean isLoginedIsStepOne(String headerText, String userText)
	{
		LoginPageStepTwo stepTwo = new LoginPageStepTwo(driver);
		String headerTitle = stepTwo.getHeaderTitle();
		String userTitle = stepTwo.getParagraphTitleUser();
		if((headerTitle.equals(headerText))&&(userTitle.equals(userText)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean isLoginedIsStepTwo(String linkText)
	{
		LoginPageStepTwo stepTwo = new LoginPageStepTwo(driver);
		stepTwo.clickRaddioButton();
		stepTwo.clickButtonContinue();
		LoginPageStepThree stepThree = new LoginPageStepThree(driver);

		return stepThree.getTextLink().equals(linkText);
	}
	
	public void clickSignOutLoginPageStepTwo()
	{
		LoginPageStepTwo stepTwo = new LoginPageStepTwo(driver);
//		stepTwo.getTitleUser();
		stepTwo.clickButtonSignOut();
	}
	
	
	public boolean isEndLogined(String textButtonReadGuide, String textButtonStartProject, String user)
	{
		LoginPageStepThree stepThree = new LoginPageStepThree(driver);
		stepThree.clickLink();
		LoginPageDashboard dashboard = new LoginPageDashboard(driver);
		
		if((dashboard.getButtonReadGuide().equals(textButtonReadGuide)) && (dashboard.getButtonStartProject().equals(textButtonStartProject))
				&& (dashboard.getTitleUser().equals(user)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean isEndLoginedAddPersonalInformation(String information, String textButtonReadGuide, String textButtonStartProject, String user)
	{
		LoginPageStepTwo stepTwo = new LoginPageStepTwo(driver);
		stepTwo.clickButtonContinue();
		LoginPageStepThree stepThree = new LoginPageStepThree(driver);
		stepThree.clickButtonSubmit();
		LoginPageDashboard dashboard = new LoginPageDashboard(driver);
		
		if((dashboard.getButtonReadGuide().equals(textButtonReadGuide)) && (dashboard.getButtonStartProject().equals(textButtonStartProject))
				&& (dashboard.getTitleUser().equals(user)))
		{
			return true;
		}
		else
		{
			return false;
		} 
	}
	
	public boolean clickSignOutPageDashboard(String textSignIn, String textSignUp, String textSignUpForGitHub)
	{
		LoginPageDashboard dashboard = new LoginPageDashboard(driver);
		dashboard.clickSignOut();
		HomePage homepage = new HomePage(driver);
		if((homepage.getLinkSignIn().equals(textSignIn))&&(homepage.getLinkSignUp().equals(textSignUp))
				&&(homepage.getButtonSignUpForGitHub().equals(textSignUpForGitHub)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isCreateNewRepository(String headerTitle)
	{
		LoginPageDashboard dashboard = new LoginPageDashboard(driver);
		dashboard.clickButtonStartProject();
		PageFinishCreateRepository createRepository = new PageFinishCreateRepository(driver);
		
		return createRepository.getHeaderTitle().equals(headerTitle);
	}
	
	public boolean isErrorForbiddenSymbol(String errorMessage, String textErrorMessage)
	{
		PageJoin pageJoin = new PageJoin(driver);
		if((pageJoin.getErrorMessage().equals(errorMessage))&&(pageJoin.getTextErrorMesage().equals(textErrorMessage)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	
}
