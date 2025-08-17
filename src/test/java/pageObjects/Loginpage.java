package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	//elements
	
	//email address
	@FindBy(xpath="//input[@id='input-email']") WebElement text_email;
	
	//password
	@FindBy(xpath="//input[@id='input-password']") WebElement text_password;
	
	//loginbutton
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	
	//action methods
	
	public void setEmail(String email)
	{
		text_email.sendKeys(email);
	}
	public void setPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void clicklogin()
	{
		btn_login.click();
	}

}
