package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	@DataProvider(name="Login_data")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir") + "/testdata/opencart_Logindata.xlsx";; //taking xl file from test data
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrow=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		//create 2d string array 
		String logindata[][]=new String[totalrow][totalcols]; //created 2d string array which stores data
		for(int i=1;i<=totalrow;i++) //for rows
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
