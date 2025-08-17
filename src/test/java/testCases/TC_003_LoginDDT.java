package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount_page;
import testbase.Baseclass;
import utilities.Dataproviders;

public class TC_003_LoginDDT extends Baseclass {
	
	@Test(dataProvider="Login_data",dataProviderClass=Dataproviders.class,groups="Dataprovider")
	public void LoginDDT(String email,String pwd,String exp)
	{
		try
		{
		logger.info("*** TC_003_LoginDDT started***");
		Homepage hp=new Homepage(driver);
		hp.linkmyaccount();
		hp.click_login();
	
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		Myaccount_page my=new Myaccount_page(driver);
		boolean target=my.ismyaccountpageExists();
		
		/*
		 * Valid data---login success---testpassed----logout
		   				login unsuccess---testfailed
		 *Invalid data---login success---testfailed----logout
		 				 login unsuccess--- testpassed
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				my.click_logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(target==true)
			{
				my.click_logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
			logger.info("***LoginDDT completed***");
		}
	}

}
