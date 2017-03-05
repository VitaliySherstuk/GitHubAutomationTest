package by.htp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageStepThree extends AbstractPage {

	private final String urlPage = "https://github.com/join/customize";
	
	@FindBy(xpath = "//p[@class='lead']")
	private WebElement paragraphTitle;
	
	@FindBy(xpath = "//form[@class='setup-form']/fieldset[1]/h3")
	private WebElement headerTitle;
	
	@FindBy(xpath = "//a[@class='alternate-action']")
	private WebElement linkSkipStep;

	@FindBy(xpath = "//input[@name='commit']")
	private WebElement buttonSubmit;
	
	public LoginPageStepThree(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getHeaderTitle()
	{
		return headerTitle.getText();
	}
	
	public String getParaphTitle()
	{
		return paragraphTitle.getText();
	}
	
	public void clickLinkSkip()
	{
		linkSkipStep.click();
	}
	
	public String getTextLink()
	{
		return linkSkipStep.getText();
	}
	
	public void clickButtonSubmit()
	{
		buttonSubmit.click();
		
	}
	
	public void clickLink()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSubmit);
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
		
	}
	
	
}
