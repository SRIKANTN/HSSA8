package Com_ActiTime_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com_ActiTIme_Generic.BaseTest;
import Com_ActiTIme_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMELoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority = 3)
	public void Verifyversion()
	{
		String title  = ExcelData.getData(file_path, "TC01", 1, 2);
		String eVesrion = ExcelData.getData(file_path, "TC03", 1, 0);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		String aVersion = lp.verifyVersion();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aVersion, eVesrion);
		sa.assertAll();
		
	}

}
