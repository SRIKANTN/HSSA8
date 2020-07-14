package Com_ActiTIme_Generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtlis 
{
	/***
	 * 
	 * @param driver
	 * @param srikanth
	 * @category used to take screen shot failed web pages
	 */
	public static void getScreenShot(WebDriver driver,String name)
	{
		SimpleDateFormat s1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String date = s1.format(new Date());
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			Files.copy(src, new File("./ScreenShots/"+name+date+".png"));
		} catch (IOException e) {
		}
	}
	/***
	 * 
	 * @param element
	 * @param index
	 */
	public static void SelectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void SelectByValue(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void SelectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void fileUpload(WebDriver driver, String xpathExpression,String file_path)
	{
		driver.findElement(By.xpath(xpathExpression)).sendKeys(file_path);
	}
	
}
