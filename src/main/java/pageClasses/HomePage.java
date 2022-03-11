package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import common.SeleniumMethods;

public class HomePage {
	
	private By loggedInUsername = By.xpath("//td[contains(text(),\"User:\")]");
	private By navBarItems = By.xpath("//div[@id='navmenu']/ul/li/a");
	private By calendarWidget = By.cssSelector("#homebox_CALENDAR");
	private By monthFromCalendarWidget = By.cssSelector("select[name='slctMonth']");
	private By yearFromCalendarWidget = By.cssSelector("select[name='slctYear']");
	
	public By contactsLink = By.cssSelector("a[title='Contacts']");
	public By newContactsLink = By.linkText("New Contact");
	
	
	SeleniumMethods com;
	public HomePage() {
		com = new SeleniumMethods();
	}
	
	public String getTitle() {
		return com.getTitle();
	}
	
	
	public void verifyLoggedInUser() {
		
		String temp =  com.getText(loggedInUsername);
		String username = temp.substring(temp.indexOf(':')+2);
		
		Assert.assertEquals(username, "bhushan jagtap", "Logged in Username is not matching with actual one");
	}
	
	public List<String> getNavBarItems() {
		return com.getAllWebElementsText(navBarItems);
	}
	
	public boolean verifyPresenceOfCalendarWidget() {
		return com.isElementPresent(calendarWidget);
	}
	
	public String getMonthYearFromCalendarWidget() {
		String month = com.getFirstSelectedOptionText(monthFromCalendarWidget);
		String year = com.getFirstSelectedOptionText(yearFromCalendarWidget);
		
		return month+","+year;
	}

}
