package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUser 
{
WebDriver driver;

public AdminUser(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement adminusertile;
@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton;
@FindBy(xpath="//input[@id='username']") private WebElement usernamefield;
@FindBy(xpath="//input[@id='password']") private WebElement passwordfield;
@FindBy(xpath="//select[@name='user_type']") private WebElement dropdownfield;
@FindBy(xpath="//button[@name='Create']") private WebElement savebutton;
@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertpopup;

public void adminUserTileClick()
{
	adminusertile.click();
	
}

public void newButtonClick()
{
	
	newbutton.click();
}

public void passingUsername(String txt)
{
	usernamefield.sendKeys(txt);
}

public void passingPassword(String txt)
{
	passwordfield.sendKeys(txt);
}

public void dropdownFieldSelection(int dropdown)
{
	PageUtility pageutility =new PageUtility ();
	pageutility.selectDropDownByIndexValue(dropdownfield, dropdown);

}
public void saveButtonClick()
{
	savebutton.click();
}

public boolean isAlertPopupDisplayed()
{
	return alertpopup.isDisplayed();
}


}
