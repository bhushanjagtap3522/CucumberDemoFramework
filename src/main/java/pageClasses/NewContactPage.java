package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.SeleniumMethods;
import driverManager.DriverFactory;

public class NewContactPage {
	
	SeleniumMethods com;
	HomePage homePage;
	
	private By saveAndCreateAnother = By.cssSelector("input[name='addmore']");
	private By save = By.xpath("//input[@name='addmore']/preceding-sibling::input[@value='Save']");
	private By createdMobile = By.xpath("//td[.='Mobile']/following-sibling::td");
	
	@FindBy(id="first_name")
	private WebElement input_Firstname;
	
	@FindBy(id="surname")
	private WebElement input_Lastname;
	
	@FindBy(id="mobile")
	private WebElement input_Mobile;
	
	@FindBy(id="email")
	private WebElement input_Email;
	
	
	
	public NewContactPage() {
		PageFactory.initElements(new DriverFactory().getDriver(), this);
		com = new SeleniumMethods();
		homePage = new HomePage();
	}
	
	public void navigateToNewContactPage() {
		com.moveToElement(homePage.contactsLink);
		com.click(homePage.newContactsLink, "New Contact");
	}
	
	public boolean verifyPresenceOfCreateNewContactButton() {
		return com.isElementPresent(saveAndCreateAnother);
	}
	
	public void createContact(String fName, String lName, String mobile, String email) {
		com.sendKeys(input_Firstname, fName, "First Name");
		com.sendKeys(input_Lastname, lName, "Last Name");
		com.sendKeys(input_Mobile, mobile, "Mobile");
		com.sendKeys(input_Email, email, "Email");
		
		com.click(save, "Save");
	}
	
	public String getCreatedUserDetails() {
		String actualfullName = com.getText(input_Firstname)+" "+com.getText(input_Lastname);
		String actualMobile = com.getText(createdMobile);
		String actualEmail = com.getText(input_Email);
		
		return actualfullName+","+actualMobile+","+actualEmail;
	}

}
