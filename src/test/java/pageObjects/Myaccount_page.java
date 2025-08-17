package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount_page extends Basepage {
	public Myaccount_page(WebDriver driver)
	{
		super(driver);
	}
	
	//elements
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msg_myaccount;
	
	//logout element
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement link_logout;
	
	//actions
	
	public boolean ismyaccountpageExists()
	{
		try {
		return(msg_myaccount.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	//logout action method
	public void click_logout()
	{
		link_logout.click();
	}

}
