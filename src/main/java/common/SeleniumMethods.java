package common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import driverManager.DriverFactory;
import utils.Log;

public class SeleniumMethods {
	
	WebDriver driver;
	
	public SeleniumMethods() {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getText(Object elem) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		return element.getText();
	}
	
	public List<String> getAllWebElementsText(Object elem){
		List<WebElement> elements;
		if(elem instanceof By) {
			elements = driver.findElements((By) elem);
		}
		else {
			elements = (List<WebElement>) elem;
		}
		
		List<String> textList = new ArrayList<String>();
		for(WebElement e: elements) {
			textList.add(e.getText());
		}
		
		return textList;
	}
	
	public void sendKeys(Object elem, String keysToSend){
		sendKeys(elem, keysToSend,"");
	}
	
	public void sendKeys(Object elem, String keysToSend, String desc) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		element.sendKeys(keysToSend);
		
		if(desc != "") {
			Log.info(desc+" is entered");
		}
	}
	
	public void click(Object elem) {
		click(elem, "");
	}
	
	public void click(Object elem, String desc) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		element.click();
		
		if(desc != "") {
			Log.info(desc+" is clicked");
		}
	}
	
	public void switchToChildeFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToMainFrame() {
		driver.switchTo().defaultContent();
	}
	
	public boolean isElementPresent(Object elem) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		return element.isDisplayed();
	}
	
	/**
	 * @param elem
	 * @return
	 */
	public String getFirstSelectedOptionText(Object elem) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		
		Select sel = new Select(element);
		return sel.getFirstSelectedOption().getText();
		
	}
	
	public void moveToElement(Object elem) {
		WebElement element;
		if(elem instanceof By) {
			element = driver.findElement((By) elem);
		}
		else {
			element = (WebElement)elem;
		}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}

}
