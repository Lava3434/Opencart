package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage extends Basepage{

	public Registerpage(WebDriver driver)
	{
		super(driver);
	}
	//elements of registration page
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_fname;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_tele;
	
	//passwords
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_cnfpassword;
	
	//privacy and policy
	@FindBy(xpath="//input[@name='agree']") WebElement chk_privacy;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement cnfmessage;
	
	//actions
	public void firstname(String fname)
	{
		txt_fname.sendKeys(fname);
	}
	
	public void lastname(String lname)
	{
		txt_lname.sendKeys(lname);
	}
	
	public void email(String mail)
	{
		txt_email.sendKeys(mail);
	}
	
	public void telephone(String tele)
	{
		txt_tele.sendKeys(tele);
	}
	
	public void password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void cnfpassword(String pwd)
	{
		txt_cnfpassword.sendKeys(pwd);
	}
	
	public void privacypolicy()
	{
		chk_privacy.click();
	}
	
	public void continuebtn()
	{
		btn_continue.click();
	}
	
	public String getconfirmmsg()
	{
		try
		{
			return (cnfmessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
}
