package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.NewContactPage;

public class NewContactStepDefinition {
	
	NewContactPage newContact;
	
	public NewContactStepDefinition() {
		newContact = new NewContactPage();
	}
	
	@When("User clicks on New Contact link")
	public void user_clicks_on_new_contact_link() {
		newContact.navigateToNewContactPage();
	}
	
	@Then("User is on New Contact page")
	public void user_is_on_new_contact_page() {
		Assert.assertTrue(newContact.verifyPresenceOfCreateNewContactButton(),"User is not on New Contact page");
	}	
	
	@When("Create a contact with firstname {string} lastname {string} mobile {string} and email {string}")
	public void create_a_contact_with_firstname_lastname_mobile_and_email(
			String firstname, String lastname, String mobile, String email) {
		
		newContact.createContact(firstname, lastname, mobile, email);
	}
	
	@Then("User is created with firstname {string} lastname {string} mobile {string} and email {string}")
	public void user_is_created_with_firstname_lastname_mobile_and_email(
			String firstname, String lastname, String mobile, String email) {
		
		String expectedFullName = firstname+" "+lastname;
		
		String temp = newContact.getCreatedUserDetails();
		String actualFullName = temp.split(",")[0].trim();
		String actualMobile = temp.split(",")[1].trim();
		String actualEmail = temp.split(",")[2].trim();
		
		Assert.assertTrue(expectedFullName.equalsIgnoreCase(actualFullName) &&
							mobile.equalsIgnoreCase(actualMobile)&&
								email.equalsIgnoreCase(actualEmail));
	}

}
