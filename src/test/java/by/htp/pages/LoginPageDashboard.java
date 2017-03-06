package by.htp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDashboard extends AbstractPage {

	private final String urlPage = "https://github.com/dashboard";
	
	@FindBy(xpath = "//div[contains(text(), 'Signed in as')]/strong")
	private WebElement titleUser;
	
	@FindBy(xpath = "//img[@class='avatar']")
	private WebElement dropDownMenu;
	
	@FindBy(xpath = "//a[text()='Start a project']")
	private WebElement buttonStartProject;
	
	@FindBy(xpath = "//a[@class='btn btn-primary shelf-cta']")
	private WebElement buttonReadGuide;
	
	@FindBy(xpath = "//form[@class='logout-form']/button[contains(text(), 'Sign out')]")
	private WebElement buttonSignOut;

	
	public LoginPageDashboard(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	
	public String getTitleUser()
	{
		((JavascriptExecutor) driver).executeScript("document.querySelectorAll('li.dropdown:nth-child(3) > div:nth-child(2)')[0].style.display='block'", dropDownMenu);
		return titleUser.getText().trim();
	}
	
	public String getButtonStartProject()
	{
		
		return buttonStartProject.getText();
	}
	
	public void clickButtonStartProject()
	{
		((JavascriptExecutor) driver).executeScript("document.querySelectorAll('.modal-backdrop')[0].style.display='block'");
		buttonStartProject.click();
	}
	
	public String getButtonReadGuide()
	{
		return buttonReadGuide.getText();
	}
	
	public void clickSignOut()
	{
		buttonSignOut.click();
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
		
	}
}
