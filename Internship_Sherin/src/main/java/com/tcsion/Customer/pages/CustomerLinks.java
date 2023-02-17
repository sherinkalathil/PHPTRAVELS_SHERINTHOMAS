package com.tcsion.Customer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class CustomerLinks extends BaseClass{
//WebDriver driver;
	
	//@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/bookings') and @class=' waves-effect']")
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings'][@class=' waves-effect']")
	private WebElement CustomerBooking;
	
	//@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/add_funds') and @class=' waves-effect']")
	@FindBy(xpath="//a[@href='https://phptravels.net/account/add_funds'][@class=' waves-effect']")
	private WebElement CustomerAddFunds;
	
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/profile') and @class=' waves-effect']")
	private WebElement CustomerProfile;
	
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/logout') and @class=' waves-effect']")
	private WebElement CustomerLogout;
	
	public CustomerLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//custAgentUrl();
		  
		}
	
	public void clickBookings()
	{
	    	
		CustomerBooking.click();
	}
	public void clickAddFunds()
	{
		CustomerAddFunds.click();
	}
	public void clickProfile()
	{
		CustomerProfile.click();
	}
	public void clickLogout()
	{
		CustomerLogout.click();
	}
	


}
