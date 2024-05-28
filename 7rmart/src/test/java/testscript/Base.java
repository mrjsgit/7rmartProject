package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;
import utilities.WaitUtility;


public class Base {
  WebDriver driver;
  public ScreenShotUtility scrshot; //declaring varable globally
  @BeforeMethod
  @Parameters("browser")     //browser is the variable
  public void initializeBrowser(String browser) throws Exception  
  {
	if(browser.equalsIgnoreCase("chrome"))
	 
	{
		driver= new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	
	else
	{
		throw new Exception("invalid browser");
	} 
	 driver = new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
  }
  @AfterMethod
  public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.captureFailureScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
