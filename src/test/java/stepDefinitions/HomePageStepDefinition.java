package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import utils.Log;
import utils.Util;

public class HomePageStepDefinition {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageStepDefinition() {
		
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Then("User is on Home Page")
	public void user_is_navigated_to_home_page() {
		
		Assert.assertEquals(homePage.getTitle(), "CRMPRO","Actual title does not match with the expected one");
	}
	
	@Then("User verifies items on navigation menu")
	public void user_verifies_items_on_navigation_menu(DataTable dataTable) {
		List<String> expectedNavBarItems = dataTable.asLists().get(0);
		List<String> actualNavBarItems = homePage.getNavBarItems();
		
		Util.compareLists(actualNavBarItems, expectedNavBarItems);
	}
	
	@Then("User verifies presence of calendar widget")
	public void user_verifies_presence_of_calendar_widget() {
		Assert.assertTrue(homePage.verifyPresenceOfCalendarWidget(),"Calendar Widget is not present on Home Page");
	}
	
	@Then("Calendar widget should show month {string} and year {string}")
	public void calendar_widget_should_show_month_and_year(String month, String year) {
		String temp = homePage.getMonthYearFromCalendarWidget();
		String actualMonth = temp.split(",")[0].toLowerCase();
		String actualYear = temp.split(",")[1].toLowerCase();
		
		Assert.assertTrue(actualMonth.equalsIgnoreCase(month) && actualYear.equalsIgnoreCase(year), 
				"Either month or year are not matching with expected ones");
	}

}
