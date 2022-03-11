package appHooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import pageClasses.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class ApplicationHooks {
	
	DriverFactory driverFactory;
	WebDriver driver;
	
	@BeforeAll
	public static void before_all() {
		Log.info("This should execute before any code");
	}
	
	
	@Before()
	public void setup() {
		
//		Process p = Runtime.getRuntime().exec(command);
		
		driverFactory = new DriverFactory();
		driverFactory.launchBrowser();
		driver = driverFactory.getDriver();
		driver.get(ConfigReader.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		new LoginPage().performLogin();
	}
	
	@After
	public void tearDown() {
		driverFactory.closeBrowser();
	}
	
	@AfterStep
	public void captureScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotdata = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotdata, "image/png", "image");
		}
	}

}
