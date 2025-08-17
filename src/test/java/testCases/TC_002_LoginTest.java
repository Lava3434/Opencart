package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccount_page;
import testbase.Baseclass;

public class TC_002_LoginTest extends Baseclass{
	
	@Test(groups={"Sanity","Master"})
	public void VerifyLogin_page()
	{
		try
		{
		logger.info("*** TC_002_Logintest started***");
		Homepage hp=new Homepage(driver);
		hp.linkmyaccount();
		logger.info("clicked on my account");
		
		hp.click_login();
		logger.info("clicked on login");
		
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		logger.info("entered email");
		
		lp.setPassword(p.getProperty("password"));
		logger.info("entered password");
		
		lp.clicklogin();
		
		Myaccount_page my=new Myaccount_page(driver);
		boolean target=my.ismyaccountpageExists();
		
		//Assert.assertEquals(target, true,"login failed");
		Assert.assertTrue(target);
		}
		catch(Exception e)
		{
			logger.debug("test failed");
			logger.error("debug errors");
			Assert.fail();
		}
	}

}
