package Tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Dashboard;
import PageObjects.LoginPage;
import Resources.BaseClass;

public class Tests extends BaseClass {
	public WebDriver driver;
	public String email = "slowestone@nealheardtrainers.com";
	public String pass = "FullCreative@1234";
	public String title = "Full Creative";

	@BeforeMethod
	public void TrelloNavigation() throws IOException {

		driver = intializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 1)
	public void LoginTrello() throws InterruptedException {

		LoginPage signin = new LoginPage(driver);
		signin.enterUsername().sendKeys(email);
		Thread.sleep(2000);
		signin.clickOnLogin().click();
		signin.enterPassword().sendKeys(pass);
		signin.signinButton().click();

		if (signin.loginAssert().isDisplayed()) {

			System.out.println("login successfull");
		} else {
			System.out.println("login unsuccessfull");
		}
	}

	@Test(priority = 2)

	public void DashboardTest() throws InterruptedException {

		LoginPage a = new LoginPage(driver);
		a.enterUsername().sendKeys(email);
		Thread.sleep(2000);
		a.clickOnLogin().click();
		a.enterPassword().sendKeys(pass);
		a.signinButton().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Dashboard board = new Dashboard(driver);
		board.createBoard().click();
		board.title().sendKeys(title);
		Thread.sleep(3000);
		board.create().click();

		
		
		board.listName().sendKeys("In Progress");
		board.addList().click();
		board.listName().sendKeys("In QA");
		board.addList().click();

		board.addCard().click();
		board.cardText().sendKeys("Card to be moved");
		board.cardText().sendKeys(Keys.ENTER);

		Actions action = new Actions(driver);

		action.moveToElement(board.sourceCard()).build().perform();

		action.clickAndHold().build().perform();
		action.moveToElement(board.desitantionList()).build().perform();

		action.release().build().perform();

		WebElement element = board.sourceCard();
		Point location = element.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Coordinates of an element is : " + x + " and " + y);

		board.profile().click();
		board.logout().click();

	}

	@AfterMethod

	public void quitBrowser() {

		driver.quit();

	}

}
