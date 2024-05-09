package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
  WebDriver driver;
  @BeforeMethod
  public void initializeBrowser() 
  {
	driver = new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
  }
  @AfterMethod
  public void quitAndClose()
  {
	// driver.close();
	 //driver.quit();
  }
}
