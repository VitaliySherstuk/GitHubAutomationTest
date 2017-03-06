package by.htp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFinishCreateRepository extends AbstractPage {

	private final String urlPage = "https://github.com/account/unverified-email";
	
	@FindBy(xpath = "//h1[text()='Please verify your email address']")
	private WebElement headerTitle;
	
	public PageFinishCreateRepository(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getHeaderTitle()
	{
		return headerTitle.getText();
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(urlPage);
		
	}
	
}
