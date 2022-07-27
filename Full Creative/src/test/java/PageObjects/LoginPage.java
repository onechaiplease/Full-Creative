package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By username = By.id("user");
	By password = By.id("password");
	By login = By.id("login");
	By Button = By.id("login-submit");
	
	By loginAssert = By.xpath("(//h3[@class='boards-page-section-header-name'])");

	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterUsername() {

		return driver.findElement(username);

	}

	public WebElement enterPassword() {

		return driver.findElement(password);
	}

	public WebElement clickOnLogin() {

		return driver.findElement(login);
	}

	public WebElement signinButton() {

		return driver.findElement(Button);
	}
	
	public WebElement loginAssert() {

		return driver.findElement(loginAssert);
	}

}
