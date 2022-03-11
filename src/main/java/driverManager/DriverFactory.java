package driverManager;

import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.Log;

public class DriverFactory {
	WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>(); 
	
	public void launchBrowser() {
		
		String browser = ConfigReader.getProperty("browser").toUpperCase();
		Log.info("Launching browser "+browser);
		
		DriverType driverType = DriverType.valueOf(browser);
		driverType.getWebDriverManager().setup();
		driver = driverType.getWebDriverObj();
//		DriverType.CHROME.getWebDriverManager().setup();
//		driver = DriverType.CHROME.getWebDriverObj();
		threadLocal.set(driver);
		
		//cleanup method
		cleanup();
	}
	
	public WebDriver getDriver() {
		return threadLocal.get();
	}
	
	public void closeBrowser() {
		driver.quit();
		threadLocal.remove();
	}
	
	private void cleanup() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	

}
