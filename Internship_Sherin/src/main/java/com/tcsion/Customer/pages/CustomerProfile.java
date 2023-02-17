package com.tcsion.Customer.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcsion.Base.BaseClass;

public class CustomerProfile  extends BaseClass{

	//@FindBy(xpath="//a[contains(text(),\" My Profile\")][@class=\"  waves-effect\"]")
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/profile') and @class=' waves-effect']")
	private WebElement CustomerProfile;
	//@FindBy(css="input[name='address1'][class='form-control']")
	@FindBy(xpath="//input[@name='address1']")
	private WebElement address1;
	

	//@FindBy(xpath="//input[@name='address2'][@class='form-control']")
	@FindBy(xpath="//input[@name='address2']")
	private WebElement address2;
	
	@FindBy(xpath ="//button[text()='Update Profile']")
	//@FindBy(xpath="//button[contains(text(),"Update Profile")][@type="submit"]")
	private WebElement updProfile;
	
	
	@FindBy (xpath = "//*[text()=' Profile updated successfully.                                ']")
	private WebElement SuccessMsg;
	
	public CustomerProfile(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
		//custAgentUrl();  
	}
	public void clickProfile()
	{
		CustomerProfile.click();
	}
	
    public void setCustAddr1(String addr1)
    {
    	address1.clear();
    	address1.sendKeys(addr1);
    }
    public void setCustAddr2(String addr2 )
    {
    	address2.clear();
    	address2.sendKeys(addr2);
    }
    
    
   public boolean clickUpdate()
    {
	  Actions act=new Actions(driver);
	  act.moveToElement(updProfile);
	   updProfile.sendKeys(Keys.ENTER);
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40)); 
	  wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
	  boolean msg=SuccessMsg.isDisplayed();
	  return msg;
	  
    }
   
   
   
  
    

}
