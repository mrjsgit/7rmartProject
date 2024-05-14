package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOfferCode 

{
WebDriver driver;

public ManageOfferCode(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") private WebElement manageoffercodetile  ;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']") private WebElement newbutton  ;
@FindBy(xpath="//input[@id='offer_code']") private WebElement offercodetextfield ;
@FindBy(xpath="//input[@checked='checked']") private WebElement radiobuttonno  ;
@FindBy(xpath="//input[@id='offer_per']") private WebElement percentage  ;
@FindBy(xpath="//input[@id='offer_price']") private WebElement offerprice  ;
@FindBy(xpath="//div[@role='textbox']") private WebElement description  ;
@FindBy(xpath="//input[@id='main_img']") private WebElement choosefile  ;
@FindBy(xpath="//button[@name='create']") private WebElement savebutton  ;
@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alert  ;
@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard  ;
@FindBy(xpath="//a[contains(@onclick,'return confirm')]") private WebElement deleteicon;



public void manageOfferCodeTileClick()
{
manageoffercodetile.click();	
}

public void newbuttonClick()
{
	newbutton.click();
}

public void passingValueToOfferCodeTextField(String txt)
{
	offercodetextfield.sendKeys(txt);
}

public void radioButtonClick()
{
	radiobuttonno.click();
}
public void passingValueToPercentageTextField(String string)
{
	percentage.sendKeys(string);
}
public void passingValueToAmountField(String string)
{
	offerprice.sendKeys(string);
}

public void passingValueToDescriptionField(String desc)
{
	description.sendKeys(desc);
}

public void ChooseFileButtonClick()
{
	
}

public void saveButtonClick()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",savebutton);
     //savebutton.click();	
}

public boolean isAlertDisplayed()
{
return alert.isDisplayed();
}

public void dashBoardClick()
{
	dashboard.click();
}

public void deleteButtonClick()
{
	deleteicon.click();
	driver.switchTo().alert().accept();
  
}
}
