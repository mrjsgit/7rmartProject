package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage 

{
WebDriver driver;

public ManageDeliveryBoyPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver , this);

}
@FindBy(xpath="//p[text()='Manage Delivery Boy']")private WebElement deliveryboytile;
@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement mainsearchbutton;
@FindBy(xpath="//input[@placeholder='Name']")private WebElement namefield ;
@FindBy(xpath="//button[@type='submit']")private WebElement search;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")private WebElement table;  //after search
@FindBy(xpath="//table/tbody/tr/td[1]")private List<WebElement> column1;

public void deliveryBoyTileClick()
{
	deliveryboytile.click();
}
public void mainSearchButtonClick()
{
	mainsearchbutton.click();
}
public void passingTextToNameField(String txt)
{
namefield.sendKeys(txt);
}
public void searchbuttonclick()
{
	search.click();
}

public boolean checkTableDisplayed()
{
	return table.isDisplayed();
}
 
	public boolean tableDataCheck(String input)
	{
		  // Loop through each element in the first column
		  for (WebElement data : column1)
		  {
		           if (!data.getText().equalsIgnoreCase(input)) 
		           {
		            return false;
		           }

		  }
		  // If all elements match the search input, return true
		  return true;
		}

}