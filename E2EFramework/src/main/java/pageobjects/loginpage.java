package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class loginpage {
	WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());

	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username= By.xpath("//input[@id='user_email']");
	By password= By.xpath("//input[@id='user_password']");
	By login= By.name("commit");
	public WebElement getUsername() {
		return driver.findElement(username);
		
	}
	public WebElement getPassword() {
		return driver.findElement(password);
		
	}
	public WebElement getLogin() {
		return driver.findElement(login);
		
	}
}
