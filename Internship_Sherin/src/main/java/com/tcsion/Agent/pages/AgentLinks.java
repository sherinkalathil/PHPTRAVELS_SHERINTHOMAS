package com.tcsion.Agent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AgentLinks extends BaseClass {
//WebDriver driver;
	
	//@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/bookings') and @class=' waves-effect']")
	
	//@FindBy(xpath="//a[text()=' My Bookings'][@class=' waves-effect']")
	//@FindBy(linkText =" My Bookings")
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings'][@class=' waves-effect']")
	private WebElement AgentBooking;
	
	//@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/add_funds') and @class=' waves-effect']")
	@FindBy(xpath="//a[@href='https://phptravels.net/account/add_funds'][@class=' waves-effect']")
	private WebElement AgentAddFunds;
	
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/profile') and @class=' waves-effect']")
	private WebElement AgentProfile;
	
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/account/logout') and @class=' waves-effect']")
	private WebElement AgentLogout;
	
	public AgentLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//custAgentUrl();  
		}
	
	public void clickAgentBookings()
	{
	    	
		AgentBooking.click();
	}
	public void clickAgentAddFunds()
	{
		AgentAddFunds.click();
	}
	public void clickAgentProfile()
	{
		AgentProfile.click();
	}
	public void clickAgentLogout()
	{
		AgentLogout.click();
	}
	

}
