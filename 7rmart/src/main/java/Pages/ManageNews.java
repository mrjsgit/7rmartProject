package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews

{
	WebDriver driver;
	
	public ManageNews(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Manage News']") private WebElement managenewstile;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton; 
	@FindBy(xpath="//textarea[@name='news']") private WebElement newstxt;
	@FindBy(xpath="//button[@name='create']") private WebElement savebutton;
	@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertdisplay;
	@FindBy(xpath="//table/tbody/tr[1]/td[2]//child::a[1]") private WebElement editbutton;
	@FindBy(xpath="//button[@name='update']") private WebElement updatebutton;
	
	public void manageNewsTileClick()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",managenewstile);
		managenewstile.click();
		
	}

	public void newbuttonClick()
	{
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();",newbutton);
		newbutton.click();
	}
	
	public void passingNewsText(String txt)
	{
		newstxt.sendKeys(txt);
	}
	public void savebuttonClick()
	{
		savebutton.click();
	}
	
	
	public boolean isAlertDisplayed()
	{
		return alertdisplay.isDisplayed();
	}
	
	public void editButtonclick()
	{
		editbutton.click();
	}
	public void updatingTextField(String txt)
	{
		newstxt.sendKeys(txt);
	}
	
	public void  updateButtonClick()
	{
		updatebutton.click();
	}
}
