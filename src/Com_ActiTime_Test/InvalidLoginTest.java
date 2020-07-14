package Com_ActiTime_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com_ActiTIme_Generic.BaseTest;
import Com_ActiTIme_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void InvalidLogin() throws InterruptedException 
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		String eErrormsg = ExcelData.getData(file_path, "TC02", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i = 1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw  = ExcelData.getData(file_path, "TC02", i, 1);
			Reporter.log("User name = "+un,true);
			lp.enterUserName(un);
			Reporter.log("Password = "+pw,true);
			lp.enterPassword(pw);
			lp.clickOnLogin();
			String aErrormsg = lp.verifyError();
			Assert.assertEquals(aErrormsg, eErrormsg);
			Reporter.log("========================================",true);
			Thread.sleep(1000);
		}
		
	}

}
