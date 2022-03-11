package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.SeleniumMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageClasses.LoginPage;

public class LoginPageStepDefinition {

	WebDriver driver;
	LoginPage loginPage;
	SeleniumMethods com;

	public LoginPageStepDefinition() {
		com = new SeleniumMethods();
		loginPage = new LoginPage();
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		String expectedTtile = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(com.getTitle(), expectedTtile, "Actual Title is not matching with the expected one");
	}

	@When("User performs login with username {string} and password {string}")
	public void user_performs_login_with_username_and_password(String username, String password) {

		loginPage.performLogin(username, password);
	}
	
	
}
