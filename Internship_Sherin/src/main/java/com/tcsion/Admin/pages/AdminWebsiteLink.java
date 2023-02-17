package com.tcsion.Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcsion.Base.BaseClass;

public class AdminWebsiteLink extends BaseClass{
	
	@FindBy(xpath="//*[text()='Website']")
	private WebElement AdminWebsite;
	
	public AdminWebsiteLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//AdminUrl() ;
	}
	public void clickWebsite()
	{
		AdminWebsite.click();
	}



}
