package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageSlider 
{
WebDriver driver;

public ManageSlider(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//p[text()='Manage Slider']") private WebElement manageslidertile;  
@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newbutton;
@FindBy(xpath = "//input[@id='main_img']") private WebElement choosefilebutton;
@FindBy(xpath = "//input[@id='link']") private WebElement linktextfield;
@FindBy(xpath = "//button[@name='create']") private WebElement savebutton;
@FindBy(xpath="//button[@data-dismiss='alert']")private WebElement alert;
@FindBy(xpath="//a[contains(@onclick,'return confirm')]") private WebElement deleteicon;

public void manageSliderTileClick()
{
	manageslidertile.click();
}

public void newButtonClick()
{
	newbutton.click();
}

public void chooseFileButtonClick()
{
	
}

public void passingValueTolinkTextField(String txt)
{
	linktextfield.sendKeys(txt);
}

public void saveButtonClick()
{
	savebutton.click();
}

public boolean isAlertDisplayed()
{
return alert.isDisplayed();

}
public void deleteButtonClick()
{
	deleteicon.click();
	driver.switchTo().alert().accept();
  
}
}
