package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageCategory
{
    WebDriver driver;
	public ManageCategory(WebDriver driver)
	{
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement managecategorytileclick;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton  ;
	@FindBy(xpath="//input[@id='category']") private WebElement categorytextfield  ;
	@FindBy(xpath="//li[@id='134-selectable']") private WebElement dragitem  ;
	@FindBy(xpath="//div[@class='ms-selection']") private WebElement dropitem  ;
	@FindBy(xpath="//input[@name='top_menu' and @checked='checked']") private WebElement topmenuradiobutton  ;
	@FindBy(xpath="//input[@name='show_home' and @checked='checked']") private WebElement leftmenuradiobutton  ;
	@FindBy(xpath="//button[@type='submit']") private WebElement savebutton  ;
	@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertpopup;

	public void manageCategoryTileClick()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, managecategorytileclick);
		
				
		//managecategorytileclick.click();
	}
 public void newbuttonClick()
 {
	 newbutton.click();
 }
	
 public void passingValueTocategoryTextField(String cattext)
 {
	 categorytextfield.sendKeys(cattext);
 }
 
 public void dragAndDrop()
 {
	 PageUtility pageutility = new PageUtility();
	 pageutility.singleClick(dragitem, driver);
	 pageutility.doubleClick(dragitem, driver);
	 pageutility.dragAndDrop(dragitem, dropitem, driver);
 }
 
 public void chooseFile()
 {
	 
 }
 
 public void topMenuRadioButtonClick()
 {
	 topmenuradiobutton.click();
 }
 
 public void leftMenuRadioButtonClick()
 {
	 leftmenuradiobutton.click();
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
