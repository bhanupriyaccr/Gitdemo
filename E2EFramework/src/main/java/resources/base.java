package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class base {
	public static WebDriver driver;
	public Properties prop ;
	public static Logger log= LogManager.getLogger(base.class.getName());

	@Test
	public WebDriver intiateBrowser() throws IOException
	{
		 prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Automation testing course\\chromedriver.exe" );
			//ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("headless");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Lenovo\\Desktop\\Automation testing course\\geckodriver.exe" );
			driver= new FirefoxDriver();
		}
		else
		{
			//driver= new IeDriver();
		}
		
		return driver;
	
	}
	public  void getScreenshot(String result) throws IOException 
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(src,new File("C:\\Users\\Lenovo\\Desktop\\Automation testing course\\"+result+"imagepriya.png"));
		
		
	}

}
