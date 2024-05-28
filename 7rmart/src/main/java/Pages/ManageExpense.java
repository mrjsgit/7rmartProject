package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageExpense
{
	WebDriver driver;

	public ManageExpense(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense']") private WebElement manageexpensetile   ;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement  newbutton ;
	@FindBy(xpath="//select[@id='user_id']") private WebElement userdropdown  ;
	@FindBy(xpath="//input[@id='ex_date']") private WebElement date  ;
	@FindBy(xpath="//table/tbody/tr[3]/td[2]") private WebElement dateselection;
	@FindBy(xpath="//select[@id='ex_cat']") private WebElement  category ;
	@FindBy(xpath="//select[@id='order_id']") private WebElement orderid  ;
	@FindBy(xpath="//select[@id='purchase_id']") private WebElement purchaseid  ;
    @FindBy(xpath="//select[@id='ex_type']") private WebElement expensetype   ;
	@FindBy(xpath="//input[@id='amount']") private WebElement amount  ;
	@FindBy(xpath="//textarea[@id='content']") private WebElement remarks;
	@FindBy(xpath="//input[@type='file']") private WebElement choosefile  ;
	@FindBy(xpath="//button[text()='Save']") private WebElement savebutton ;
	@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alert  ;
	@FindBy(xpath="//p[text()='Manage Expense']") private WebElement manageexpenseradiobutton  ;
	@FindBy(xpath="//a[contains(@onclick,'return confirm')]") private WebElement deleteicon;

	
	
	
	public void manageExpenseTileClick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",manageexpensetile);
	}
	
	
	public void newButtonClick()
	{
		newbutton.click();
	}
	
	public void userDropDownField(int num)
	{
		Select select = new Select(userdropdown);
		select.selectByIndex(num);	
	}
	
	public void dateField()
	{
		date.click();
		dateselection.click();
	}
	
	public void categorydropDown(int num)
	{	
		Select select = new Select(category);
		select.selectByIndex(num);	
	}
	
	public void orderIddropDown(int num)
	{	
		Select select = new Select(orderid);
		select.selectByIndex(num);	
	}
	public void purchaseIddropDown(int num)
	{	
		Select select = new Select(purchaseid);
		select.selectByIndex(num);	
	}
	public void expenseTypedropDown(int num)
	{	
		Select select = new Select(expensetype);
		select.selectByIndex(num);	
	}
	
	
	public void passingValueToAmountField(String num)
	{
		amount.sendKeys(num);
	}
	
	public void passingValueToRemarkField(String txt)
	{
		remarks.sendKeys(txt);
	}
	public void chooseFileButtonClick()
	{
		choosefile.click();
	}
	public void saveButtonClick()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",savebutton);
	}
	
	public boolean isAlertDisplayed()
	{
	return alert.isDisplayed();
	}
	public void manageExpenseRadioButtonClick()
	{
		manageexpenseradiobutton.click();
	}
	public void deleteButtonClick()
	{
		deleteicon.click();
		driver.switchTo().alert().accept();
	  
	}
	
}
	
	

