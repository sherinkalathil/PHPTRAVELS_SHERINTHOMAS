package com.tcsion.Admin.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AdminViewBooking extends BaseClass{
	
	@FindBy(xpath="//a[@href='https://phptravels.net/api/admin/bookings'][@class='nav-link loadeffect']")
	private WebElement AdminBooking;
	
	//@FindBy(xpath="//a[@href='https://phptravels.net/api/../hotels/booking/invoice/3617/38']")
	@FindBy(xpath="//a[@href='https://phptravels.net/api/admin/bookings/confirmed'][@class='text-decoration-none']")
	private WebElement confirm;
	
	@FindBy(xpath="//*[@id='download']")
	private WebElement download;
	@FindBy(xpath="//*[text()='Confrimed Bookings']//preceding::div[1]")
	private WebElement confirmcount ;
	@FindBy(xpath="//*[@id=\"data\"]/tbody/tr[1]/td[14]/a")
	private WebElement Invoice;
	
	public AdminViewBooking(WebDriver driver)
	{
		BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
		//AdminUrl() ;
	}
	
	public boolean clickInvoice()
	{
		boolean correct=false;
		String confirmCount=confirmcount.getText();
		int confirmCountNow=Integer.parseInt(confirmCount);
		try
		{
			if(confirmCountNow>=1)
			{
				confirm.click();
				//driver.switchTo().alert().accept();
				
				Invoice.click();
				String mainWindowHandle = driver.getWindowHandle();
		        Set<String> allWindowHandles = driver.getWindowHandles();
		        Iterator<String> iterator = allWindowHandles.iterator();
		        while (iterator.hasNext()) {
		            String ChildWindow = iterator.next();
		                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
		                driver.switchTo().window(ChildWindow);
		                correct=download.isDisplayed();
		                driver.close();

			              }
		        }
		                driver.switchTo().window(mainWindowHandle);
		                //return correct;
			}
			else
			{
				System.out.println("There are no records in the list");
			}
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("No records available");
    	}
		
		
		/*Actions act1=new Actions(driver);
		act1.moveToElement(Invoice);
		Invoice.sendKeys(Keys.ENTER);*/
		
		 //driver.switchTo().window(mainWindowHandle);
         return correct;   
	 }
}
