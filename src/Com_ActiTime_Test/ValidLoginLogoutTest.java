package Com_ActiTime_Test;

import org.testng.annotations.Test;

import Com_ActiTIme_Generic.BaseTest;
import Com_ActiTIme_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMEEnterTimeTrackPage;
import Com_ActiTime_Pages.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void ValidLoginLogout()
	{
		
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw  = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String hpTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrackPage hp = new actiTIMEEnterTimeTrackPage(driver);
		//to verify the title login webpage
		lp.verifyTitle(lgTitle);
		// enter valid user name
		lp.enterUserName(un);
		//enter valid password
		lp.enterPassword(pw);
		// click on login button
		lp.clickOnLogin();
		// verify home page title
		lp.verifyTitle(hpTitle);
		// to click on logout
		hp.clickOnLogout();
		//to verify the title login webpage
		lp.verifyTitle(lgTitle);
	}

}
