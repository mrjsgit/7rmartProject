package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContent
{

	WebDriver driver;

	public ManageContent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//p[contains(text(),'Content')]") private WebElement managecontentbutton;
	@FindBy(xpath="//p[text()='Manage Contact']") private WebElement managecontactbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") private WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']") private WebElement phonefield;
	@FindBy(xpath="//button[@name='Update']") private WebElement updatebutton;
	@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertpopup;


	public void managecontentButtonClick()
	{
		managecontentbutton.click();
	}

	public void managecontactButtonClick()
	{
		managecontactbutton.click();
	}
	public void editButtonClick()
	{
		editbutton.click();
	}
	public void updatingPhoneField(String num)
	{
		phonefield.sendKeys(num);
	}
	
	public void updateButtonClick()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, updatebutton);
		//updatebutton.click();
	}
	public boolean isAlertPopupDisplayed()
	{
		return alertpopup.isDisplayed();
	}

}
