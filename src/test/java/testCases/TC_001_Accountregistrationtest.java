package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registerpage;
import testbase.Baseclass;

public class TC_001_Accountregistrationtest extends Baseclass{
	
	
	@Test(groups={"Regression","Master"})
	public void Registrationpagetest()
	{
		try {
		logger.info("***Testing TC_001_Accountregistrationtest started***");
		Homepage hmpage=new Homepage(driver);
		hmpage.linkmyaccount();
		logger.info("clicked on linkaccount");
		hmpage.linkregister();
		logger.info("clicked on register account");
		
		logger.info("provided user details");
		Registerpage regpage=new Registerpage(driver);
		regpage.firstname(randomestring().toUpperCase());
		regpage.lastname(randomestring().toUpperCase());
		regpage.email(randomestring()+"@gmail.com");
		regpage.telephone(randomenumber());
		
		String password=randomealphanumeric();
		regpage.password(password);
		regpage.cnfpassword(password);
		
		regpage.privacypolicy();
		regpage.continuebtn();
		logger.info("checking validation results");
		Assert.assertEquals(regpage.getconfirmmsg(),"Your Account Has Been Created!");
		String msg=regpage.getconfirmmsg();
		if(msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
		    Assert.fail("Test failed due to exception: " + e.getMessage(), e);
		}

		logger.info("***Test TC_001_Accountregistrationtest completed***");
	}
	
	
	
	

}
