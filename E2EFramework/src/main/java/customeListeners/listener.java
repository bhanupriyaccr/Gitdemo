package customeListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import resources.base;



public class listener extends base implements ITestListener {
	//WebDriver driver;
	//base b = new base();
//TestngListeners is c class which implements ITestListener interface which has below unimplemented
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  Calendar calendar = Calendar.getInstance();
		  SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");		   
		  String methodName = result.getName();
		  if(!result.isSuccess())
		  {
		       File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   try{
			        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/ScreenshotFailure/";
			        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");				
					FileHandler.copy(scrFile, destFile);
					Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				}
		   }
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

  }

