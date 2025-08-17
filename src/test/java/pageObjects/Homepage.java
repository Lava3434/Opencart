package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	//elements
	@FindBy (xpath="//span[normalize-space()='My Account']") WebElement myaccount_ele;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register_ele;
	@FindBy(linkText="Login") WebElement link_login;
	
	//actions
	
	public void linkmyaccount()
	{
		myaccount_ele.click();
	}
	
	public void linkregister()
	{
		register_ele.click();
	}
	
	public void click_login()
	{
		link_login.click();
	}
}
