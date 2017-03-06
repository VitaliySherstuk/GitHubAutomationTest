package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageJoin extends AbstractPage {

	private final String urlPage = "https://github.com/dashboard";
	
	//div[contains(text(), 'There were problems creating your account.')]
	@FindBy(xpath = "//div[@class='flash flash-error my-3']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//dd[@class='error']")
	private WebElement textErrorMessage;
	
	public PageJoin(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	public String getTextErrorMesage()
	{
		return textErrorMessage.getText();
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
		
	}
}
