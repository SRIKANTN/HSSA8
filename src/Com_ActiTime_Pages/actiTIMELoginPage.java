package Com_ActiTime_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ActiTIme_Generic.BasePage;

public class actiTIMELoginPage extends BasePage
{
	//Declaration
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name= "pwd")
	private WebElement pwTB;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lgBT;
	
	@FindBy(xpath = "//span[contains(text(),'Username or Password')]")
	private WebElement error;
	
	@FindBy(xpath = "//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	
	//Intilization
	public actiTIMELoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void enterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	public void clickOnLogin()
	{
		lgBT.click();
	}
	public String verifyError()
	{
		verifyElement(error);
		String aErrorMsg = error.getText();
		return aErrorMsg;
	}
	public String verifyVersion()
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}
	

}
