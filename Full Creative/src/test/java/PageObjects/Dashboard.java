package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
	public WebDriver driver;

	By createBoard = By.xpath("//div[@class='board-tile mod-add']");
	By boardTitle = By.xpath("//input[@type='text']");
	By create = By.xpath("/html/body/div[3]/div/section/div/form/button");
	By listName = By.className("list-name-input");
	By addList = By.xpath("//input[@value='Add list']");
	By addCard = By.className("js-add-a-card");
	By cardText = By.xpath("//textarea[@placeholder='Enter a title for this card…']");
	By sourceCard = By.xpath("(//span[@class='list-card-title js-card-name'])[1]");
	By desitantionList = By.xpath("(//div[@class='list js-list-content'])[2]");
	By profile = By.xpath("//span[@class='p6oJr7SHjK+vLr aqePx81u4BGHTH Glb3QqRGpd64YB']");
	By logout = By.xpath("//span[contains(text(),'Log out')]");

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createBoard() {

		return driver.findElement(createBoard);
	}

	public WebElement title() {

		return driver.findElement(boardTitle);
	}

	public WebElement create() {

		return driver.findElement(create);
	}

	public WebElement listName() {

		return driver.findElement(listName);
	}

	public WebElement addList() {

		return driver.findElement(addList);
	}

	public WebElement addCard() {

		return driver.findElement(addCard);
	}

	public WebElement cardText() {

		return driver.findElement(cardText);
	}

	public WebElement sourceCard() {

		return driver.findElement(sourceCard);
	}

	public WebElement desitantionList() {

		return driver.findElement(desitantionList);
	}

	public WebElement logout() {

		return driver.findElement(logout);
	}

	public WebElement profile() {

		return driver.findElement(profile);
	}

}
