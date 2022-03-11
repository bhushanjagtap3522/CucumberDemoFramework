package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum DriverType {

	CHROME {

		public WebDriverManager getWebDriverManager() {
			return WebDriverManager.chromedriver();
		}

		public WebDriver getWebDriverObj() {
			return new ChromeDriver();
		}

	},
	FIREFOX {

		public WebDriverManager getWebDriverManager() {
			return WebDriverManager.firefoxdriver();
		}

		public WebDriver getWebDriverObj() {
			return new FirefoxDriver();
		}

	},
	EDGE {

		public WebDriverManager getWebDriverManager() {
			return WebDriverManager.edgedriver();
		}

		public WebDriver getWebDriverObj() {
			return new EdgeDriver();
		}

	};

	public WebDriverManager getWebDriverManager() {
		return WebDriverManager.chromedriver();
	}

	public WebDriver getWebDriverObj() {
		return new ChromeDriver();
	}

}
