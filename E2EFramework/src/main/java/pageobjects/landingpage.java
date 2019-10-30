package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class landingpage {
	public static Logger log= LogManager.getLogger(base.class.getName());
	WebDriver driver;
	public landingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login=By.linkText("Login");
	By title=By.xpath("//div[@class='text-center'][h2]");
	By navigation= By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By popup= By.xpath("//button[text()='NO THANKS']");
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	public WebElement getpopup() {
		return driver.findElement(popup);
	}
		public List<WebElement> getpopupSize() {
			return driver.findElements(popup);
		}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavibar() {
		return driver.findElement(navigation);
	}


}
