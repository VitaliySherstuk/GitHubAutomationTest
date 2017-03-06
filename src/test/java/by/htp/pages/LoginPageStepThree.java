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
	
	@FindBy(xpath = "//div[@role='main']")
	private WebElement divMain;
	
	@FindBy(xpath = "//input[@id='answers_98_choice_461']")
	private WebElement radioButtonNewToProgramming;
	
	@FindBy(xpath = "//input[@id='answers_99_choice_468']")
	private WebElement radioButtonSchoolProject; 
	
	@FindBy(xpath = "//input[@id='answers_99_choice_466']")
	private WebElement radioButtonProjectManagement;
	
	@FindBy(xpath = "//input[@id='answers_100_choice_473']")
	private WebElement radioButtonOtherInformation;
	
	@FindBy(xpath = "//input[@id='answers_100_other']")
	private WebElement inputOtherInformation;
	
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
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSubmit);
	}
	
	public void clickLink()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkSkipStep);
	}
	
	public void clickDivMain()
	{
		((JavascriptExecutor)driver).executeScript("document.querySelectorAll('.modal-backdrop')[0].style.display='block';", divMain);
	}
	
	public void clickRadioButtonNewToProgramming()
	{
		radioButtonNewToProgramming.click();

	}
	
	public void clickRadioButtonScoolProject()
	{
		radioButtonSchoolProject.click();
	}
	
	public void clickRadioButtonProjectManagement()
	{
		radioButtonProjectManagement.click();
	}
	
	public void clickRadioButtonOtherInformation()
	{
		radioButtonOtherInformation.click();
	}
	
	public void clickInputOtherInformation(String information)
	{
		inputOtherInformation.sendKeys(information);
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
		
	}
	
	
}
