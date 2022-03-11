package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.SeleniumMethods;
import utils.ConfigReader;

public class LoginPage {
	
	WebDriver driver;
	SeleniumMethods com;
	HomePage homePage;
	
	By username = By.cssSelector("input[name='username']");
	By password = By.cssSelector("input[name='password']");
	By loginBtn = By.xpath("//input[@type='submit' and  @value='Login']");
	
	public LoginPage() {
		com = new SeleniumMethods();
	}
	
	public void performLogin() {
		performLogin(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
	}
	
	public void performLogin(String userName, String pwd) {
		
		com.sendKeys(username, userName, "User Name");
		com.sendKeys(password, pwd, "Password");
		com.click(loginBtn, "Login Button");
		
		com.switchToChildeFrame("mainpanel");
		
		homePage = new HomePage();
		homePage.verifyLoggedInUser();
	}

}
