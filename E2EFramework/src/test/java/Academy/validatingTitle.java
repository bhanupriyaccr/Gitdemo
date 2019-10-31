package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.landingpage;
import pageobjects.loginpage;
import resources.base;



public class validatingTitle extends base {
	public static Logger log= LogManager.getLogger(validatingTitle.class.getName());
	@BeforeTest
	public void open() throws IOException
	{
		driver=intiateBrowser();
		driver.get("http://www.qaclickacademy.com");
		
	}
	@Test
	public void browserInvoke() throws IOException {
		//calling method with out creating object thrugh inheritance
	
	
			//calling method by creating obj to class
		landingpage la=new landingpage(driver);
		System.out.println(la.getTitle().getText());
		Assert.assertEquals(la.getTitle().getText(), "FEATURD COURSES");
		log.info("checked title");
		System.out.println("title A checked");
		System.out.println("title B checked");
}
	@AfterTest
	public void close() {
		driver.close();
		driver=null;
	}
}
