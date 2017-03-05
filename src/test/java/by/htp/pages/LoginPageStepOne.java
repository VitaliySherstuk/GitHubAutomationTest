package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageStepOne extends AbstractPage {
	
	private final String urlPage = "https://github.com/join?source=header-home";
	
	@FindBy(xpath="//h2[contains(text(), 'Create your personal account')]")
	private WebElement headerTitleCreate;
	
	@FindBy(xpath ="//input[@name='user[login]']")
	private WebElement inputUserName;
	
	@FindBy(xpath ="//input[@id='user_email']")
	private WebElement inputEmailAddres;
	
	@FindBy(xpath ="//input[@id='user_password']")
	private WebElement inputPassword;
	
	@FindBy(xpath="//button[@id='signup_button']")
	private WebElement buttonCreateAccount;
	
	public LoginPageStepOne(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getHeaderTitleCreate()
	{
		return headerTitleCreate.getText();
	}
	
	public void logining(String userName, String userEmailAddres, String userPassword)
	{
		
		inputUserName.sendKeys(userName);
		inputEmailAddres.sendKeys(userEmailAddres);
		inputPassword.sendKeys(userPassword);
		buttonCreateAccount.click();
	}
	
	
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
	}
}
