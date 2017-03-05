package by.htp.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver driver;
	
	private DriverSingleton(){};
	
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			System.setProperty("webdriver.gecko.driver", "c:\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void closeDriver()
	{
		driver.quit();
		driver=null;
	}
}
