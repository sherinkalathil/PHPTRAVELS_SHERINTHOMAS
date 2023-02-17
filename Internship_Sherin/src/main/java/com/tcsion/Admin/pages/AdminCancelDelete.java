package com.tcsion.Admin.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class AdminCancelDelete extends BaseClass{
	@FindBy(xpath="//div[@class='card-text'][text()='Cancelled Bookings']")
	private WebElement cancelBooking;
	@FindBy(xpath="//*[@id=\"data\"]/tbody/tr[1]/td[15]/button")
	private WebElement delIcon;
	@FindBy(xpath="//table[@id='data']/tbody")
	private WebElement rows;
	@FindBy(xpath="//table[@id='data']/tbody/tr")
	private WebElement cols;
	
	public AdminCancelDelete (WebDriver driver)
	{
		BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
		//AdminUrl(); 
	}
	
	public void clickCancel()
	{
		cancelBooking.click();
	}
    public String clickDelete()
    {
    	String msg=null;
    	List<WebElement>TotRowLst=rows.findElements(By.tagName("tr"));
    	int rowCnt=TotRowLst.size();
    	System.out.println("Total row size"+TotRowLst.size());
    	List<WebElement>TotColLst=rows.findElements(By.tagName("td"));
    	int colCnt=TotColLst.size();
    	System.out.println("Total col size"+TotColLst.size());
    	
    	try
    	{
    		if (rowCnt>=1)
    		{
    			if (rowCnt>1 && colCnt>1)
    			{
    				JavascriptExecutor js = ((JavascriptExecutor) driver);
    				//WebElement element = driver.findElement (By.xpath("//*[@id=\"data\"]/tbody/tr[1]/td[15]/button"));
    				Point point = delIcon.getLocation();
    				int xcord = point.getX();
    				int ycord = point.getY ();
    				System.out.println(xcord + ", "+ycord);
    				
    				js.executeScript("window.scrollTo(" + xcord + "," + ycord + ");");
    				js.executeScript("arguments[0].click();",delIcon);
    				
    				Alert alert=driver.switchTo().alert();
    				msg=alert.getText();
    				System.out.println(msg);
    				alert.accept();
    			}
    			else
    			{
    				System.out.println("There are no records in the list");
    			}
    			
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("No records available");
    	}
    	return msg;
    }
}
