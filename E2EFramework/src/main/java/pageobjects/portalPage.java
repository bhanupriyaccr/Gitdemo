package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class portalPage {
	public static Logger log= LogManager.getLogger(base.class.getName());
	WebDriver driver;
	public portalPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search =By.id("search-course-button");
	
	
	public WebElement getSearch() {
		return driver.findElement(search);
	}
	


}
