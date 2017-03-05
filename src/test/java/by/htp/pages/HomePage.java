package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

	private final String urlPage = "http://github.com";
	
	@FindBy(xpath="//a[text()='Sign up']")
	private WebElement linkSignUp;
	
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement linkSignIn;
	
	@FindBy(xpath = "//button[@type='submit'][text()='Sign up for GitHub']")
	private WebElement buttonSignUpForGitHub;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickLinkSignUp()
	{
		linkSignUp.click();
	}
	
	public String getLinkSignIn()
	{
		return linkSignIn.getText();
	}
	
	public String getLinkSignUp()
	{
		return linkSignUp.getText();
	}
	
	public String getButtonSignUpForGitHub()
	{
		return buttonSignUpForGitHub.getText();
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
	}
}
