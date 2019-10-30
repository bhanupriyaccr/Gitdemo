package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.landingpage;
import pageobjects.loginpage;
import resources.base;



public class homepage extends base {
public static Logger log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void open() throws IOException
	{
		driver=intiateBrowser();
		log.info("browser initialized");
	}

	@Test(dataProvider = "getData")
	public void browserInvoke(String username , String password) throws IOException, InterruptedException {
		//calling method with out creating object thrugh inheritance
	
		
		driver.get("http://www.qaclickacademy.com");
		
		//calling method by creating obj to class
		landingpage la=new landingpage(driver);
		
		la.getLogin().click();
		
		loginpage lp= new loginpage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		log.info("loginpage initialized");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="bhanu@gmail.com";
	    data[0][1]="psd123";
	    data[1][0]="priya@gmail.com";
	    data[1][1]="ram@123";
	    
	    return data;
	}
	@AfterTest
	public void close() {
		driver.close();
		driver=null;
	}
}
