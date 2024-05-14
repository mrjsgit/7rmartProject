package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	public void javaSriptClick(WebDriver  driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void clickAndHoldOnElement(WebElement element, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	
	public void dropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void dragandDrop()
	{
		Actions action = new Actions(driver);
		action.moveToElement(drag).build().perform();
		action.doubleClick(drag).build().perform();
		action.contextClick(drag).build().perform();   //method for 'right' click
		action.dragAndDrop(drag, drop).build().perform();
	}
	
	
}
