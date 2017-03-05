package by.htp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageStepTwo extends AbstractPage{

	private final String urlPage = "https://github.com/join/plan";
	
	@FindBy(xpath = "//h1[text()='Welcome to GitHub']")
	private WebElement headerTitle;
	
	@FindBy(xpath = "//div[contains(text(), 'Signed in as')]/strong")
	private WebElement titleUser;
	
	@FindBy(xpath = "//img[@class='avatar']")
	private WebElement dropDownMenu;
	
	@FindBy(xpath="//p[@class='lead']/strong")
	private WebElement paragraphTitleUser;
	
	@FindBy(xpath="//button[contains(text(), 'Continue')]")
	private WebElement buttonContinue;
	
	@FindBy(xpath="//input[@value='free']")
	private WebElement radioButton;
	
	
	public LoginPageStepTwo(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	
	public String getHeaderTitle()
	{
		return headerTitle.getText();
	}
	
	public String getTitleUser()
	{
		((JavascriptExecutor) driver).executeScript("document.querySelectorAll('li.dropdown:nth-child(3) > div:nth-child(2)')[0].style.display='block'", dropDownMenu);
		return titleUser.getText().trim();
	}
	

	public String getParagraphTitleUser()
	{
		return paragraphTitleUser.getText();
	}
	
	public void clickButtomContinue()
	{
		buttonContinue.click();
	}
	
	public void clickRaddioButton()
	{
		radioButton.click();
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
	}
}
